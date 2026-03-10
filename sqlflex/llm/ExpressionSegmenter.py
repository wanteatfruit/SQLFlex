from antlr4 import *
from sqlflex.parser.SQLLexer import SQLLexer
from sqlflex.parser.SQLParser import SQLParser
from sqlflex.sqlast.ASTBuilder import ASTBuilder
from sqlflex.sqlast.SQLGenerator import SQLGenerator
from sqlflex.error_handler.MyErrorListener import MyErrorListener
from sqlflex.error_handler.MyErrorStrategy import MyErrorStrategy
from sqlflex.utils import split_comma, remove_outer_paren
from sqlflex.llm.QuerySegmenter import QuerySegmenter
import sqlflex.llm.ASTNodeLLM as lm
import sqlflex.sqlast.ASTNodes as at
import typing as t
import re


class ExpressionSegmenter():
  def __init__(self, segmenter_model = 'gpt-4.1', temperature = 0.0, injected_attempt_parse = None, injected_find = None, injected_parse = None, dialect='DuckDB', use_anchor = True, use_validate = True):
    # adjust anchors and extract unknown operator step. aim for conservative approach
    boolean_operators = ['AND', 'OR']
    comparison_operators = ['>', '<', '>=', '<=', '=', '<>']
    is_operators = ['IS NULL', 'IS NOT NULL', 'IS TRUE', 'IS NOT TRUE', 'IS FALSE', 'IS NOT FALSE', 'IS UNKNOWN', 'IS NOT UNKNOWN']
    predicates = ['BETWEEN', 'LIKE', 'EXISTS', 'NOT IN', 'IN', 'NOT LIKE', 'NOT BETWEEN', 'NOT EXISTS', 'UNIQUE', 'NOT UNIQUE']
    bit_operators = ['+', '-', '/', '||', '|', '&', '%']
    others = ['CASE', 'WHEN', 'THEN', 'ELSE', 'END']

    sql03_anchors = ['IS DISTINCT FROM', 'OVER']

    # llm settings
    self.temperature = temperature
    self.segmenter_model = segmenter_model
    self.dialect = dialect
    self.use_anchor = use_anchor
    self.use_validate = use_validate
    self.cost = 0.0
    self.called_times = 0
    self.fix_times = 0
    self.failed_times = 0
    self.prompt_tokens = 0
    self.completion_tokens = 0

    self.use_sql03 = False
    
    # algorithm settings
    self.no_match = set()
    self.token_mapping = {}
    self.paren_mapping = {}
    self.single_quote_mapping = {}
    self.double_quote_mapping = {}
    self.attempt_parse = injected_attempt_parse
    self.find = injected_find
    self.main_parse = injected_parse

    if self.use_anchor:
        if self.use_sql03:
            self.anchors = sql03_anchors + boolean_operators + comparison_operators + is_operators + predicates + bit_operators + others
            #sql03
            self.contextual_window_anchor = ['PARTITION BY', 'ORDER BY', 'ROWS', 'RANGE', 'UNBOUNDED PRECEDING', 'CURRENT ROW', 'PRECEDING', 'BETWEEN', 'AND', 'UNBOUNDED FOLLOWING', 'FOLLOWING', 'EXCLUDE CURRENT ROW', 'EXCLUDE GROUP', 'EXCLUDE TIES', 'EXCLUDE NO OTHERS']
        else:
            self.anchors = boolean_operators + comparison_operators + is_operators + predicates + bit_operators + others
        self.contextual_cast_anchor = ['AS']
        self.contextual_extract_anchor = ['FROM']
        self.use_paren_mask = True
    else:
        self.anchors = []
        self.contextual_cast_anchor = []
        self.contextual_extract_anchor = []
        # abalation study
        self.use_paren_mask = False



  def preprocess_parentheses(self, sql: str):
      """
      Masks parentheses with <PAREN_%d>.
      Returns the transformed text and a mapping of placeholder → original substring.
      
      Example:
          ((a + b) * 3) < MAX(1,2)
      becomes
          <PAREN_0> < MAX<PAREN_1>
      
      And mapping might look like:
          { "<PAREN_0>": "((a + b) * 3)", ... }
      """
      def find_matching_paren(text, start_index):
        stack = []
        i = start_index
        while i < len(text):
          c = text[i]

          # 1) If we hit a quote, skip until its closing quote (handling doubled quotes)
          if c in ("'", '"'):
            quote_char = c
            i += 1
            while i < len(text):
              if text[i] == quote_char:
                # SQL escapes a quote by doubling it, e.g. 'It''s'
                if i + 1 < len(text) and text[i + 1] == quote_char:
                  i += 2
                  continue
                i += 1
                break
              i += 1
            continue

          # 2) Otherwise treat real parens
          if c == '(':
            stack.append('(')
          elif c == ')':
            if not stack:
              # stray closing paren — fail
              return -1
            stack.pop()
            if not stack:
              # first opening at start_index now closed
              return i

          i += 1

        return -1
      i = 0
      length = len(sql)
      result = []
      self.paren_mapping = {} # Reset mapping
      paren_counter = 0

      while i < length:
          # Check for delimeted literals.
          if sql[i] in ("'", '"'):
              quote_char = sql[i]
              start_literal = i
              i += 1
              while i < length:
                  if sql[i] == quote_char:
                      # Check for SQL-style escaped quotes (doubled quotes)
                      if i + 1 < length and sql[i + 1] == quote_char:
                          i += 2  # Skip both quotes
                      else:
                          i += 1  # End of literal
                          break
                  else:
                      i += 1
              result.append(sql[start_literal:i])
              continue
            
          if sql[i] in ('[', '{'):
              # Handle bracketed expressions as a whole
              start_bracket = i
              opening = sql[i]
              closing = ']' if opening == '[' else '}'
              bracket_count = 1
              i += 1
              while i < length and bracket_count > 0:
                  if sql[i] == opening:
                      bracket_count += 1
                  elif sql[i] == closing:
                      bracket_count -= 1
                  i += 1
              result.append(sql[start_bracket:i])
              continue

          char = sql[i]
          if char != '(':
              # Just copy non-parenthesis characters
              result.append(char)
              i += 1
          else:
              # We have an opening '(' => decide if it's function parentheses or not
              match_index = find_matching_paren(sql, i)
              if match_index == -1:
                  # Unbalanced parentheses; raise error
                  raise Exception("Unbalanced parentheses in SQL expression")
                
              # We don't need to check for function？ 
              chunk = sql[i:match_index + 1]  # entire parentheses substring
              token = f"<PAREN_{paren_counter}>"
              self.paren_mapping[token] = chunk
              result.append(token)
              paren_counter += 1

              # Move index past the matching ')'
              i = match_index + 1
      final_str = ""
      for i, token in enumerate(result):
        if token.startswith("<PAREN_"):
          # prepend and append space to the token if next token or previous token is not a space
          if i > 0 and result[i - 1] != " ":
            spaced_paren_token = " " + token
          else:
            spaced_paren_token = token
          if i < len(result) - 1 and result[i + 1] != " ":
            spaced_paren_token += " "
          final_str += spaced_paren_token  
        else:
          final_str += token
      return final_str.strip()  # Remove leading/trailing spaces
        


  def mask_sql(self, sql: str, no_match: set = None, context: str = '') -> str:
      # Reset mapping and define a mask token template.
      self.token_mapping = {}
      mask_sym = '<MASK_%>'
      counter = 0

      # Sort anchors by length (longest first)
      if context == 'castExpression':
        anchors = sorted(self.contextual_cast_anchor + self.anchors, key=len, reverse=True)
      elif context == 'extractExpression':
        anchors = sorted(self.contextual_extract_anchor + self.anchors, key=len, reverse=True)
      elif context == 'windowSpecification':
        anchors = sorted(self.contextual_window_anchor + self.anchors, key=len, reverse=True)
      elif context == 'expr':
        anchors = sorted(self.anchors, key=len, reverse=True)
      else:
        anchors = sorted(self.anchors, key=len, reverse=True)
      # Sort additional no_match patterns (if any)
      no_match = sorted(no_match, key=len, reverse=True) if no_match else []

      # We'll record “boundaries” that need to be treated specially.
      # Each boundary is a tuple: (start, end, type)
      # 'anchor' boundaries are kept intact; 'mask' boundaries (like string literals) are masked.
      boundaries = []

      i = 0
      while i < len(sql):
          # Check for delimeted literals.
          if sql[i] in ("'", '"'):
              quote_char = sql[i]
              start_literal = i
              i += 1
              while i < len(sql):
                  # If we see the matching quote, check for an escaped quote.
                  if sql[i] == quote_char:
                      # In SQL, an escaped quote is represented by a doubled quote.
                      if i + 1 < len(sql) and sql[i + 1] == quote_char:
                          i += 2  # Skip the escaped quote.
                      else:
                          i += 1  # End of literal.
                          break
                  else:
                      i += 1
              boundaries.append((start_literal, i, 'mask'))
              continue
            
          # Treat bracketed expressions as a whole
          if sql[i] in ('[', '{'):
              start_bracket = i
              opening = sql[i]
              closing = ']' if opening == '[' else '}'
              bracket_count = 1
              i += 1
              while i < len(sql) and bracket_count > 0:
                  if sql[i] == opening:
                      bracket_count += 1
                  elif sql[i] == closing:
                      bracket_count -= 1
                  i += 1
              boundaries.append((start_bracket, i, 'mask'))
              continue

          # Check for any no_match patterns.
          matched_no_match = False
          for pattern in no_match:
              plen = len(pattern)
              if i <= len(sql) - plen and sql[i:i + plen] == pattern:
                  # Simply skip over the no_match region.
                  i += plen
                  matched_no_match = True
                  break
          if matched_no_match:
              continue

          # Check for anchors at the current position.
          found_anchor = False
          for anchor in anchors:
              alen = len(anchor)
              if i + alen <= len(sql) and sql[i:i + alen].upper() == anchor:
                  # ensure anchors (words and symbols) are delimited by whitespace (or start/end of string).

                before_ok = (i == 0) or sql[i - 1].isspace()
                after_ok = (i + alen == len(sql)) or sql[i + alen].isspace()
                if not (before_ok and after_ok):
                    continue
                boundaries.append((i, i + alen, 'anchor'))
                i += alen  # Skip past the anchor.
                found_anchor = True
                break
          if not found_anchor:
              i += 1

      # Sort boundaries by their start position.
      boundaries.sort(key=lambda x: x[0])

      # Rebuild the output, masking any text that is not a recorded boundary.
      tokens = []
      last_index = 0

      for start, end, b_type in boundaries:
          # Mask any content between the end of the previous boundary and the start of this one.
          if last_index < start:
              content = sql[last_index:start]
              if content.strip():  # Only mask if there is non-space content.
                  mask_id = mask_sym.replace('%', str(counter))
                  tokens.append(mask_id)
                  self.token_mapping[mask_id] = content
                  counter += 1

          # Process the current boundary.
          if b_type == 'anchor':
              # Keep anchors as is.
              tokens.append(sql[start:end])
          elif b_type == 'mask':
              # Mask string literals (or other no-match regions).
              mask_id = mask_sym.replace('%', str(counter))
              tokens.append(mask_id)
              self.token_mapping[mask_id] = sql[start:end]
              counter += 1

          last_index = end

      # Mask any trailing text after the last boundary.
      if last_index < len(sql):
          content = sql[last_index:]
          if content.strip():
              mask_id = mask_sym.replace('%', str(counter))
              tokens.append(mask_id)
              self.token_mapping[mask_id] = content
              counter += 1

      # --- Post-processing 1: Merge consecutive mask tokens ---
      def is_mask_token(token):
          return token.startswith("<MASK_") and token.endswith(">") and token[6:-1].isdigit()

      merged_tokens = []
      merged_mapping = {}
      i = 0
      while i < len(tokens):
          token = tokens[i]
          if is_mask_token(token):
              # Start a consecutive mask token group.
              merged_token = token
              merged_value = self.token_mapping[token]
              i += 1
              # Merge all subsequent consecutive mask tokens.
              while i < len(tokens) and is_mask_token(tokens[i]):
                  merged_value += " " + self.token_mapping[tokens[i]]
                  i += 1
              merged_tokens.append(merged_token)
              merged_mapping[merged_token] = merged_value
          else:
              merged_tokens.append(token)
              i += 1

      # Update tokens and the mapping.
      tokens = merged_tokens
      self.token_mapping = merged_mapping
      
      # --- Post-processing 2: adjust token_mapping for consistency with original SQL ---
      def clean_token_content(content):
          # Remove leading/trailing whitespace.
          content = content.strip()
          # Remove extra spaces adjacent to brackets (both [ ], { }).
          content = re.sub(r'\s*([\[\]\{\}])\s*', r'\1', content)
          return content

      # Iterate over the mapping and adjust each entry.
      for token, content in self.token_mapping.items():
          candidate = clean_token_content(content)
          # Only update if the candidate is found in the original input.
          # This helps ensure that if the original input intentionally includes a space (e.g. "arr [3]"),
          # it won’t be removed.
          if candidate in sql:
              self.token_mapping[token] = candidate
              
      # Join tokens with spaces
      return ' '.join(tokens)

  def get_contextual_depth(self, cur_parent_expr_list=None, normal_parent=None):
      if cur_parent_expr_list and cur_parent_expr_list.parent and isinstance(cur_parent_expr_list.parent, at.Function) and cur_parent_expr_list.parent.name.upper() == 'CAST':
          depth = "castExpression"
      elif cur_parent_expr_list and cur_parent_expr_list.parent and isinstance(cur_parent_expr_list.parent, at.Function) and cur_parent_expr_list.parent.name.upper() == 'EXTRACT':
          depth = "extractExpression"
        #sql03
        # window function's parent is not expr_list
      elif self.use_sql03 and normal_parent and isinstance(normal_parent, at.Operation) and normal_parent.op.upper() == 'OVER':
          depth = "windowSpecification"
      else:
          depth = "expr"
      return depth

  def parse_expr_antlr(self, sql: str, parse_depth = "expr"):
    import signal
    from contextlib import contextmanager

    class TimeoutException(Exception):
        pass

    @contextmanager
    def time_limit(seconds):
        def signal_handler(signum, frame):
            raise TimeoutException("Parsing timed out")

        signal.signal(signal.SIGALRM, signal_handler)
        signal.alarm(seconds)
        try:
            yield
        finally:
            signal.alarm(0)
    # Parse the SQL expression
    input_stream = InputStream(sql)
    lexer = SQLLexer(input_stream)
    lexer.removeErrorListeners()
    lexer._errHandler = MyErrorStrategy()
    lexer.addErrorListener(MyErrorListener())
    token_stream = CommonTokenStream(lexer)
    parser = SQLParser(token_stream)
    parser.removeErrorListeners()
    parser._errHandler = MyErrorStrategy()
    parser.addErrorListener(MyErrorListener())
    # this will infinitely loop sometimes
    try:
        with time_limit(20):
            tree = getattr(parser, parse_depth)()
    except TimeoutException:
        raise Exception("ANTLR parsing took too long and was aborted")

    if token_stream.LA(1) != Token.EOF:
        raise Exception("Unexpected tokens after parsing")
    astbuilder = ASTBuilder(tree, parser, expand_expr=True)
    ast = astbuilder.build_ast()
    ast._build_parent()
    return ast

  def assemble_roots(self, roots: t.List[at.Expression]) -> at.Expression:
      # assumption: 1. paren_key are ordered 2. roots are in the same order as paren_key counter 3. roots are BFS
      # 0. create a  list recording marked roots
      marked = [False] * len(roots)
      
      for i, root in enumerate(roots):
          marked[i] = True
          parens = self.find("Mask", root, all = True, filter=lambda n: n.value.startswith("<PAREN_"))
          parens.sort(key=lambda n: n.value)
          for paren_index, paren_node in enumerate(parens):
              # 1. extract the corresponding paren_key from paren_node
              nxt_unmarked = marked.index(False)
              nxt_root = roots[nxt_unmarked] # skip the nodes that are already built
              marked[nxt_unmarked] = True
              
              parent = paren_node.parent
              if parent is not None:
                  if isinstance(parent, at.ExpressionList):
                      for expr_i, expr in enumerate(parent.exprList):
                          if expr == paren_node:
                              parent.exprList[expr_i] = nxt_root
                              nxt_root.parent = parent
                              break
                  else:
                      for attr, value in vars(parent).items():
                        if value == paren_node:
                            nxt_root.parent = parent
                            setattr(parent, attr, nxt_root)

      # 5. corner case: if parenthesis is at the root (e.g., (a IS DISTINCT FROM b)), need return the child
      for i, root in enumerate(roots):
          if isinstance(root, at.Mask):
              continue
          else:
              return root
    #   if isinstance(roots[0], at.Mask):
    #     return roots[1]
    #   return roots[0]
    
  def post_process_quotes(self, ast: at.Expression):
      sq_re = r'##SQ_\d+##'
      dq_re = r'##DQ_\d+##'
      for node in ast.bfs():
          # if any attribute in node.__dict__.values() is a <SQ> or <DQ> token, replace it with the original string
            for attr, value in vars(node).items():
              if isinstance(value, str):
                  value = re.sub(sq_re, lambda m: self.single_quote_mapping.get(m.group(0), m.group(0)), value)
                  value = re.sub(dq_re, lambda m: self.double_quote_mapping.get(m.group(0), m.group(0)), value)
                  node.__setattr__(attr, value)
  
  def segment_expr(self, sql: str):
    # ablation study
    if (not self.use_anchor and not self.use_paren_mask):
      root= self.segment_expr_no_paren_no_anchor(sql)
      self.post_process_quotes(root)
      return root
      
    parse_queue = []
    roots = []
    parse_queue.append((sql, None, None))
    segmenter = QuerySegmenter(segment_model=self.segmenter_model, segment_temp=self.temperature, dialect=self.dialect, use_validate=self.use_validate)

    while parse_queue:
        # 10. prepare for next iteration
        cur_expr, cur_parent_expr_list, normal_parent = parse_queue.pop(0)
        
        # 0. try parse with antlr, if success, return the root directly
        try:
            grammar_depth = self.get_contextual_depth(cur_parent_expr_list, normal_parent)
            cur_root: at.Expression = self.parse_expr_antlr(cur_expr, grammar_depth)
            if cur_expr != sql: # manually stripped parentheses in previous iteration
                cur_root.hasParentheses = True
            if cur_parent_expr_list is not None:
                cur_parent_expr_list.exprList.append(cur_root)
                cur_root.hasParentheses = False # assume for the outer expressions in the list, no parentheses
            else:
                roots.append(cur_root)
            continue
        except Exception as e:
            # continue into the segmenting process
            pass
           
        # 1. mask parenthesis
        preprocessed = self.preprocess_parentheses(cur_expr)

        # 3. add <paren> to no match
        for key in self.paren_mapping.keys():
            self.no_match.add(key)

        # 4. mask non-anchor parts with <mask>
        grammar_depth = self.get_contextual_depth(cur_parent_expr_list, normal_parent)
        masked = self.mask_sql(preprocessed, self.no_match, grammar_depth)
        
        # 5. parse with antlr
        try:
            grammar_depth = self.get_contextual_depth(cur_parent_expr_list, normal_parent)
            cur_root: at.Expression = self.parse_expr_antlr(masked, grammar_depth) # raise error if failed
            if cur_expr != sql: # manually stripped parentheses in previous iteration
                cur_root.hasParentheses = True
        except Exception as e:
            raise "Parsing failed, please check for anchor errors in the expression"
        
        # 6. expand each <mask>
        for mask_k, mask_v in self.token_mapping.items():
            try:
                # 7. parse content in each <mask> with antlr
                mask_parsed: at.Expression = self.parse_expr_antlr(mask_v, "expr")
            except Exception as e:
                # raise e
                # 7.1 if parse <token> failed, handle unknown segment (<PAREN> not expanded yet)
                # doesn't guarantee one segment is enough (consecutive unknown operators). recursively segment like main sql
                # max_segment_depth = 5
                
                def segment_expr(expr: str, depth: int = 0):
                    def replace_single_quoted_strings(input_text):
                        pattern = r"'(.*?)'"
                        def replacer(match):
                            cur_idx = len(self.single_quote_mapping)
                            self.single_quote_mapping[f"##SQ_{cur_idx}##"] = match.group(0)
                            return f"##SQ_{cur_idx}##"
                        result = re.sub(pattern, replacer, input_text)
                        return result
                    
                    def replace_double_quoted_strings(input_text):
                        pattern = r'"(.*?)"'
                        def replacer(match):
                            cur_idx = len(self.double_quote_mapping)
                            self.double_quote_mapping[f"##DQ_{cur_idx}##"] = match.group(0)
                            return f"##DQ_{cur_idx}##"
                        result = re.sub(pattern, replacer, input_text)
                        return result
                    
                    expr = replace_single_quoted_strings(expr)
                    expr = replace_double_quoted_strings(expr)
                    segmented_dict: lm.ExpressionExpand = segmenter.segment_query(expr, lm.ExpressionExpand, ignore_keyword=False)
                    cur_node = at.Expression()
                    # DummyNode error handling
                    if isinstance(segmented_dict, at.DummyNode):
                        failed_node = at.DummyLeaf(expr)
                        self.failed_times += 1
                        cur_node.value = expr
                        # return cur_node
                        return failed_node # for evaluation of counting no. of failed nodes
                    seg_literal = segmented_dict.literal
                    seg_op = segmented_dict.operator
                    # if only literal, return literal node
                    if seg_literal and not seg_op:
                        cur_node = at.Literal('Literal', seg_literal)
                        return cur_node
                    # else it's operation node
                    cur_node = at.Operation()
                    cur_node.op = seg_op
                    seg_operand1 = segmented_dict.left
                    seg_operand2 = segmented_dict.right
                    
                    # try parse each operand segment, if failed, segment it again
                    if seg_operand1:
                        node, _, error = self.attempt_parse(seg_operand1, "expr", True)
                        if error.should_restart:
                            cur_node.left = segment_expr(seg_operand1, depth + 1)
                        else:
                            cur_node.left = node
                        
                    if seg_operand2:
                        node, _, error = self.attempt_parse(seg_operand2, "expr", True)
                        if error.should_restart:
                            cur_node.right = segment_expr(seg_operand2, depth + 1)
                        else:
                            cur_node.right = node
                    
                    return cur_node
                
                mask_parsed = segment_expr(mask_v)

            mask_parsed._build_parent()

            # 7.2 replace mask node with parsed content
            masking_node = self.find("Mask", cur_root, False, lambda n: n.value == mask_k)
            parent = masking_node.parent
            if parent is not None:   
                for attr, value in vars(parent).items():
                    if value == masking_node:
                        mask_parsed.parent = parent
                        setattr(parent, attr, mask_parsed)
            else: # mask node is root
                mask_parsed.hasParentheses = cur_root.hasParentheses
                cur_root = mask_parsed

        # 8. expand each <paren>
        for paren_k, paren_v in self.paren_mapping.items():
            try:
                # 9. parse content in each <paren> with antlr
                paren_parsed = self.parse_expr_antlr(paren_v)
                paren_node = self.find("Mask", cur_root, False, lambda n: n.value == paren_k)
                # 9.1 replace paren node with parsed content
                parent = paren_node.parent
                if parent is not None:            
                    for attr, value in vars(parent).items():
                        if value == paren_node:
                            paren_parsed.parent = parent
                            # corner case: if only one argument in function, it should convert to an expression list
                            if isinstance(parent, at.Function) and attr == 'args' and not isinstance(paren_parsed, at.ExpressionList):
                                expr_list = at.ExpressionList()
                                paren_parsed.hasParentheses = False
                                expr_list.exprList = [paren_parsed]
                                setattr(parent, attr, expr_list)
                            else:
                                setattr(parent, attr, paren_parsed)
                else: # paren node is root
                    paren_parsed.hasParentheses = True
                    cur_root = paren_parsed
            except Exception as e:
                # raise e
                # 9.1 if parse <paren> failed, manually strip parentheses and repeat from step 1 (indicate unknown segment in <PAREN>)
                # 9.2 remove one ( from start and one ) from end
                paren_v = remove_outer_paren(paren_v)
                paren_node = self.find("Mask", cur_root, False, lambda n: n.value == paren_k)
                parent = paren_node.parent
                
                # 9.3 consider special cases: expression list, function, subquery
                # has comma and is not surrounded by other types of delimiter or parent is a function -> expression list
                if (len(split_comma(paren_v)) > 1) or isinstance(parent, at.Function):
                  expr_list = at.ExpressionList()
                  # attach this exprlist to the <paren> parent
                  if parent is not None:
                    if isinstance(parent, at.Function):
                      parent.args = expr_list
                      expr_list.parent = parent
                    else:
                      for attr, value in vars(parent).items():
                        if value == paren_node:
                            expr_list.parent = parent
                            setattr(parent, attr, expr_list)
                  else:
                    cur_root = expr_list

                  for expr in split_comma(paren_v):
                    if expr.upper().strip().startswith('SELECT'):
                      subquery_node = at.Subquery()
                      sub_select_node, LLM_stats, _ = self.main_parse(expr, True, segmenter.segment_model, segmenter.validator_model, self.dialect)
                      subquery_node.this = sub_select_node
                      expr_list.exprList.append(subquery_node)
                      self.cost += LLM_stats['total_cost']
                      self.called_times += LLM_stats['called_times']
                      self.fix_times += LLM_stats['fix_called_times']
                      self.failed_times += LLM_stats['fails']
                      self.prompt_tokens += LLM_stats['prompt_tokens']
                      self.completion_tokens += LLM_stats['completion_tokens']
                    else:
                      parse_queue.append((expr, expr_list, None))
                
                elif paren_v.upper().strip().startswith('SELECT'):
                  # subquery
                  subquery_node = at.Subquery()
                  sub_select_node, LLM_stats, _ = self.main_parse(paren_v, True, segmenter.segment_model, segmenter.validator_model, self.dialect, True, self.use_validate, self.use_anchor)
                  self.cost += LLM_stats['total_cost']
                  self.called_times += LLM_stats['called_times']
                  self.fix_times += LLM_stats['fix_called_times']
                  self.failed_times += LLM_stats['fails']
                  self.prompt_tokens += LLM_stats['prompt_tokens']
                  self.completion_tokens += LLM_stats['completion_tokens']
                  subquery_node.this = sub_select_node
                  if parent is not None:
                    for attr, value in vars(parent).items():
                        if value == paren_node:
                            subquery_node.parent = parent
                            setattr(parent, attr, subquery_node)
                  else:
                    cur_root = subquery_node
                # normal expression
                else:
                  parse_queue.append((paren_v, None, parent))

        if cur_parent_expr_list is not None:
          cur_parent_expr_list.exprList.append(cur_root)
          cur_root.parent = cur_parent_expr_list
          cur_root.hasParentheses = False # assume for the outer expressions in the list, no parentheses
        else:
          roots.append(cur_root)
    # 11. assemble roots
    final_root = self.assemble_roots(roots)
    self.cost += segmenter.cost
    self.called_times += segmenter.called_times
    self.fix_times += segmenter.fix_times
    self.prompt_tokens += segmenter.prompt_tokens
    self.completion_tokens += segmenter.completion_tokens
    
    # 12. post process quotes
    self.post_process_quotes(final_root)
    return final_root

  # ablation study: segment expression without parentheses and anchors (SQLFLex_a)
  def segment_expr_no_paren_no_anchor(self, expr: str, depth: int = 0):
      segmenter = QuerySegmenter(segment_model=self.segmenter_model, segment_temp=self.temperature, dialect=self.dialect, use_validate=self.use_validate)

      def replace_single_quoted_strings(input_text):
          pattern = r"'(.*?)'"
          def replacer(match):
              cur_idx = len(self.single_quote_mapping)
              self.single_quote_mapping[f"##SQ_{cur_idx}##"] = match.group(0)
              return f"##SQ_{cur_idx}##"
          result = re.sub(pattern, replacer, input_text)
          return result
      
      def replace_double_quoted_strings(input_text):
          pattern = r'"(.*?)"'
          def replacer(match):
              cur_idx = len(self.double_quote_mapping)
              self.double_quote_mapping[f"##DQ_{cur_idx}##"] = match.group(0)
              return f"##DQ_{cur_idx}##"
          result = re.sub(pattern, replacer, input_text)
          return result
      
      expr = replace_single_quoted_strings(expr)
      expr = replace_double_quoted_strings(expr)
      segmented_dict: lm.ExpressionEntire = segmenter.segment_query(expr, lm.ExpressionEntire, ignore_keyword=False)
      self.cost += segmenter.cost
      self.called_times += segmenter.called_times
      self.fix_times += segmenter.fix_times
      self.prompt_tokens += segmenter.prompt_tokens
      self.completion_tokens += segmenter.completion_tokens
      cur_node = at.Expression()
      # DummyNode error handling
      if isinstance(segmented_dict, at.DummyNode):
          failed_node = at.DummyLeaf(expr)
          self.failed_times += 1
          cur_node.value = expr
          raise Exception(f"Failed to parse expression: {expr}") # speed up eval
      seg_literal = segmented_dict.literal
      seg_op = segmented_dict.operator
      seg_subquery = segmented_dict.subquery
      seg_function = segmented_dict.function
      if seg_literal:
          cur_node = at.Literal('Literal', seg_literal)
          return cur_node
      if seg_op:
        cur_node = at.Operation()
        cur_node.op = seg_op
        seg_operand1 = segmented_dict.left
        seg_operand2 = segmented_dict.right
        if seg_operand1:
            seg_operand1 = remove_outer_paren(seg_operand1)
            node, _, error = self.attempt_parse(seg_operand1, "expr", True)
            if error.should_restart:
                cur_node.left = self.segment_expr_no_paren_no_anchor(seg_operand1, depth + 1)
            else:
                cur_node.left = node
            
        if seg_operand2:
            seg_operand2 = remove_outer_paren(seg_operand2)
            node, _, error = self.attempt_parse(seg_operand2, "expr", True)
            if error.should_restart:
                cur_node.right = self.segment_expr_no_paren_no_anchor(seg_operand2, depth + 1)
            else:
                cur_node.right = node
      if seg_subquery:
        subquery_node = at.Subquery()
        sub_select_node, LLM_stats, _ = self.main_parse(remove_outer_paren(seg_subquery), True, segmenter.segment_model, segmenter.validator_model, self.dialect)
        subquery_node.this = sub_select_node
        cur_node = subquery_node
        self.cost += LLM_stats['total_cost']
        self.called_times += LLM_stats['called_times']
        self.fix_times += LLM_stats['fix_called_times']
        self.failed_times += LLM_stats['fails']
        self.prompt_tokens += LLM_stats['prompt_tokens']
        self.completion_tokens += LLM_stats['completion_tokens']
      if seg_function:
        func_node = at.Function()
        # name is before the first parenthesis, e.g., "CAST" in "CAST(a AS INT)"
        func_node.name = seg_function[:seg_function.find('(')]
        func_node.args = at.ExpressionList()
        arg_list = seg_function[seg_function.find('(') + 1: seg_function.rfind(')')]
        for arg in split_comma(arg_list):
            node, _, error = self.attempt_parse(arg, "expr", True)
            if error.should_restart:
                func_node.args.exprList.append(self.segment_expr_no_paren_no_anchor(arg, depth + 1))
            else:
                func_node.args.exprList.append(node)
        cur_node = func_node
      return cur_node
     
  
  

# Helper functions
def has_remaining_mask(expr: str):
    mask_regex = re.compile(r'<MASK_\d+>')
    return mask_regex.search(expr)

def has_remaining_paren(expr: str):
    paren_regex = re.compile(r'<PAREN_\d+>')
    return paren_regex.search(expr)             
            
if __name__ == "__main__":
  from sqlflex.main import attempt_parse, find, parse
  expr_parser = ExpressionSegmenter(injected_attempt_parse=attempt_parse, injected_find=find, injected_parse=parse, segmenter_model='gpt-4o')
  sql = "a + c += b"
  
#   print(expr_parser.mask_sql(sql, expr_parser.no_match))
#   print(expr_parser.token_mapping)

  
  # # sql = 'a IS DISTINCT FROM b IS DISTINCT FROM c'
  root = expr_parser.segment_expr(sql)
  root.pretty_print()
  print(root)
  
  print(expr_parser.cost)

  gen = SQLGenerator()
  print(gen.generate(root))
  