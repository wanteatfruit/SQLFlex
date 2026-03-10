from antlr4 import *
from sqlflex.parser.SQLLexer import SQLLexer
from sqlflex.parser.SQLParser import SQLParser
from sqlflex.sqlast.ASTBuilder import ASTBuilder
from sqlflex.sqlast.SQLGenerator import SQLGenerator
from sqlflex.error_handler.MyErrorListener import MyErrorListener
from sqlflex.error_handler.MyErrorStrategy import MyErrorStrategy
from sqlflex.mappings import rule2ast, rule2lm, llmAttr2rule
from sqlflex.utils import split_comma, remove_outer_paren, extract_other_group
from sqlflex.llm.QuerySegmenter import QuerySegmenter
from sqlflex.llm.ExpressionSegmenter import ExpressionSegmenter
from sqlflex.sqlast.HeuristicParser import HeuristicParser
import sqlflex.llm.ASTNodeLLM as lm
import sqlflex.sqlast.ASTNodes as at
from copy import deepcopy
import typing as t
import re
import argparse
import time


def setup_parser(cur_sql):
  input_stream = InputStream(cur_sql)
  lexer = SQLLexer(input_stream)
  error_listener = MyErrorListener()
  error_strat = MyErrorStrategy()
  lexer.removeErrorListeners()
  lexer.addErrorListener(error_listener)
  lexer._errHandler = error_strat
  stream = CommonTokenStream(lexer)
  parser = SQLParser(stream)
  
  # bail if error occurs
  parser.removeErrorListeners()
  parser.addErrorListener(error_listener)
  # parser._errHandler = error_strat
  
  return parser, stream, error_listener


def attempt_parse(sql, parse_depth = "selectStmt", expand_expr = False):
  """Parse with raising error"""
  parser, stream, error_listener = setup_parser(sql)
  try:
    # parse current rule, equals to tree = parser.select_stmt()
    tree = getattr(parser, parse_depth)()
    
    if stream.LA(1) != Token.EOF: # check if all tokens are consumed, especially when parsing a subtree
      raise Exception
    
    # build the AST based on parse tree
    visitor = ASTBuilder(tree, parser=parser, expand_expr=expand_expr)
    ast = visitor.build_ast()
    return ast, tree.toStringTree(recog=parser), error_listener
  except Exception as e:
    error_listener.should_restart = True
    return None, None, error_listener


def extract_segments(segments, cur_sql:str):
  cur_sql = cur_sql.replace('\n',' ').strip()
  segment_list = []
  for key in segments.model_fields.keys():
    llm_node_attr = getattr(segments, key)
    if llm_node_attr:
      if key == 'other':
        other_parts = extract_other_group(cur_sql, llm_node_attr)
        for part in other_parts:
          segment_list.append(part)
      elif key == 'joins' and isinstance(llm_node_attr, list):
        for join_clause in llm_node_attr:
          segment_list.append(join_clause)
      else:
        segment_list.append(llm_node_attr)
  
  # Reorder segment_list to align with the order in cur_sql
  segment_list.sort(key=lambda x: cur_sql.find(x if isinstance(x, str) else x.value))
  return segment_list


def parse(sql: str, expand_expr: bool = True, segmenter_model: str = 'gpt-4.1', validator_model: str = 'gpt-4.1', dialect: str = 'DuckDB', use_llm: bool = True, use_validate: bool = True, use_anchor: bool = True)-> tuple[at.ASTNode, dict, list]:
  """Return: AST, LLM_stats, warnings"""
  
  LLM_stats = {"called_times": 0, "expr_called_times":0, "fix_called_times": 0, "fails": 0, "expr_cost":0.0, "total_cost": 0.0, "total_time": 0.0, "prompt_tokens":0, "completion_tokens":0}
  warnings = []

  # initialization
  start_time = time.time()
  print(f"[sqlflex] Parsing SQL ({dialect} dialect)...")
  if use_llm:
    print(f"[sqlflex] LLM enabled — segmenter: {segmenter_model}, validator: {validator_model}")
  heuristic_parser = HeuristicParser()
  segmenter = QuerySegmenter(segment_model=segmenter_model, validator_model=validator_model, dialect=dialect, whole_query=sql, use_validate=use_validate)
  expr_segmenter = ExpressionSegmenter(segmenter_model=segmenter_model, injected_attempt_parse=attempt_parse, injected_find=find_bfs, injected_parse=parse, use_validate=use_validate, use_anchor=use_anchor)
  base_sql = heuristic_parser.normalize(sql)
  base_sql = heuristic_parser.remove_redundant_parentheses(base_sql)
  base_rule = "root" # needed for first iteration
  base_root = at.DummyRoot()
  segment_q = [(base_rule, base_sql, base_root)] # queue (rule, sql, node)
  
  

  
  while segment_q:
    cur_rule, cur_sql, parent_node = segment_q.pop(0)
    ast, parse_tree, error_listener = attempt_parse(cur_sql, cur_rule, expand_expr) # error is caught in error_listener
    
    if error_listener.should_restart:
      print(f"[sqlflex] Grammar parse failed for '{cur_rule}', falling back to LLM segmentation...")
      if not use_llm:
        return None, LLM_stats, [f"Error in parsing rule {cur_rule}, query: {cur_sql}"]
      
      # normalize the sql, remove all excess spaces and newlines
      cur_sql = heuristic_parser.normalize(cur_sql)
      
      # use heuristic parser to segment the set operation
      if cur_rule == 'root' or cur_rule == 'setOperation': # setop is not a root rule, but it's a special case from subquery
        set_operations, select_stmts = heuristic_parser.parse_setop(cur_sql)
        if len(set_operations) == 0 or len(select_stmts) < 2:
          cur_rule = 'selectStmt'
        elif len(set_operations) == 1:
          cur_node = at.SetOperation()
          cur_node.setOp = set_operations[0]
          for select in select_stmts:
            segment_q.append(('selectStmt', select, cur_node))
          
          if cur_rule == 'root':
            base_root = cur_node
          else:
            attach_ast_to_parent_by_type(parent_node, cur_node)
          continue
        
        elif len(set_operations) > 1:
          set_node = at.SetOperation()
          set_node.setOp = set_operations[0]
          segment_q.append(('selectStmt', select_stmts[0], set_node)) # select stmt on the left
          
          cur_node = set_node
          
          for i in range(1, len(set_operations)):
            new_node = at.SetOperation()
            new_node.setOp = set_operations[i]
            segment_q.append(('selectStmt', select_stmts[i], new_node)) # select stmt on the left of the new set operation
            cur_node.selectStmt2 = new_node
            cur_node = new_node
          
          segment_q.append(('selectStmt', select_stmts[len(select_stmts) - 1], cur_node))
          
          if cur_rule == 'root':
            base_root = set_node
          else:
            attach_ast_to_parent_by_type(parent_node, set_node)
          continue
            
      # the current parse rule's AST node (meaning: the current node e.g., Select is not parsable, we need to segment it, the segment are attached to this root)
      # need to attach cur_root to the parent node if error again
      segment_type = rule2lm[cur_rule]
      segmented = segmenter.segment_query(cur_sql, segment_type)

      # if the segmenter returns a dummy node, it means the segmenter is not able to segment the query (validation failed)
      if isinstance(segmented, at.DummyLeaf):
        print(f"[sqlflex] Warning: LLM validation failed for '{cur_rule}', creating fallback node")
        cur_node = rule2ast[cur_rule]()
        cur_node.add_child(segmented)
        if isinstance(parent_node, at.DummyRoot):
          parent_node.add_child(cur_node)
        else:
          attach_ast_to_parent_by_type(parent_node, cur_node)
        warnings.append(f"Rule {cur_rule} has LLM validation failed")
        LLM_stats['fails'] += 1
        continue
      
      segment_list = extract_segments(segmented, cur_sql)

      # create a new AST node for the current rule
      cur_node = rule2ast[cur_rule]() 

      # analyze the segmented parts
      for key in segmented.model_fields.keys(): 

        llm_node_attr = getattr(segmented, key)
        if llm_node_attr is None: # no such clause e.g. join = None
          continue
        else:
          # special cases
          if key == 'other':  
            # split the other part into parts
            other_parts = extract_other_group(cur_sql, llm_node_attr)
            for part in other_parts:
              other = at.Other(part)
              other.pos = segment_list.index(part)
              if (isinstance(cur_node, at.Column) or isinstance(cur_node, at.Table)): # special case, dot already during print
                continue
              cur_node.add_child(other)
          elif key == 'keyword':
            continue
          elif key == 'subquery': # assume subquery included by parentheses, no dummy parts, so 100% fail on next parse rule
            subquery = remove_outer_paren(llm_node_attr)
            segment_q.append(('setOperation', subquery, cur_node))
          elif key == 'expr' and expand_expr:
            # calling expression segmenter
            expr_node = expr_segmenter.segment_expr(llm_node_attr)
            attach_ast_to_parent_by_type(cur_node, expr_node)
            pass
          else:
            nxt_parse_rule = llmAttr2rule.get(segment_type, {}).get(key)
            if nxt_parse_rule is None: # no grammar rule
              pass
            elif nxt_parse_rule == '$': # terminal, no need to parse further
              attach_terminal_to_current_by_name(cur_node, key, llm_node_attr)
              pass
            elif nxt_parse_rule.startswith('&'): # comma separated list in rule, manually break up comma
              if key == 'columns': # special case for using clause
                nxt_parse_rule_single = nxt_parse_rule[1:]
                # remove parentheses
                llm_node_attr = remove_outer_paren(llm_node_attr)
                nxt_list = split_comma(llm_node_attr)
                
              # special case, joins are not comma separated, LLM breaks it up
              if nxt_parse_rule == '&joinClause' and isinstance(segmented, lm.SelectStmt):
                nxt_parse_rule_single = nxt_parse_rule[1:]
                nxt_list = llm_node_attr
                
              else:
                nxt_parse_rule_single = nxt_parse_rule[1:] # projections -> projection
                nxt_list = split_comma(llm_node_attr)
                
              for nxt in nxt_list:
                segment_q.append((nxt_parse_rule_single, nxt, cur_node))
            else:
              # pass the next rule and the segment to the queue, the current node will act as the parent node
              nxt_sql: str = llm_node_attr                    
              segment_q.append((nxt_parse_rule, nxt_sql, cur_node))  
      
      # attach the current node to the parent node
      if isinstance(parent_node, at.DummyRoot):
        # top level, directly add to parent
        parent_node.add_child(cur_node)
      else:
        attach_ast_to_parent_by_type(parent_node, cur_node)
            
    else:
      if cur_rule == base_rule:
        # successfully parsed at root
        print(f"[sqlflex] Parsed successfully without LLM")
        base_root = ast
        break
      else:
        attach_ast_to_parent_by_type(parent_node, ast)
  
  if isinstance(base_root, at.DummyRoot):
    base_root = base_root.others[0]
    
  base_root._build_parent()
  base_root._build_depth()
  base_root = prune_join(base_root)
  end_time = time.time()
  LLM_stats['total_time'] = end_time - start_time
  LLM_stats['total_cost'] += segmenter.cost
  LLM_stats['total_cost'] += expr_segmenter.cost
  LLM_stats['expr_cost'] = expr_segmenter.cost
  LLM_stats['expr_called_times'] = expr_segmenter.called_times
  LLM_stats['called_times'] += segmenter.called_times
  LLM_stats['called_times'] += expr_segmenter.called_times
  LLM_stats['fix_called_times'] += segmenter.fix_times
  LLM_stats['fix_called_times'] += expr_segmenter.fix_times
  LLM_stats['fails'] += expr_segmenter.failed_times
  LLM_stats['prompt_tokens'] += segmenter.prompt_tokens
  LLM_stats['prompt_tokens'] += expr_segmenter.prompt_tokens
  LLM_stats['completion_tokens'] += segmenter.completion_tokens
  LLM_stats['completion_tokens'] += expr_segmenter.completion_tokens
  print(f"[sqlflex] Parsing complete in {LLM_stats['total_time']:.2f}s — "
        f"LLM calls: {LLM_stats['called_times']}, "
        f"tokens: {LLM_stats['prompt_tokens']}↑ {LLM_stats['completion_tokens']}↓"
        + (f", warnings: {len(warnings)}" if warnings else ""))
  return base_root, LLM_stats, warnings

def prune_join(ast: at.ASTNode):
  
  # prune join specification node
  for node in ast.dfs():
    if isinstance(node, at.JoinSpecification) and isinstance(node.parent, at.Join):
      join_node = node.parent
      if node.on:
        join_node.joinSpecification = node.on
      elif node.using:
        join_node.joinSpecification = node.using
      if node.others:
        join_node.others.extend(node.others)
      node.parent = None

  return ast 

def attach_terminal_to_current_by_name(cur_node, key, terminal):
  """Search for the attribute that has the same name"""
  for attr_name, attr_type in type(cur_node).__annotations__.items():
    if not getattr(cur_node, attr_name) and attr_name == key:
      setattr(cur_node, attr_name, terminal)
      break
    else:
      continue

def attach_ast_to_parent_by_type(parent_node, ast):
  """Search for the first None attribute in the parent node that have the same type and attach the AST to it"""
  def resolve_type(attr_type):
    if isinstance(attr_type, str):
      try:
        attr_type = eval(attr_type, globals(), at.__dict__)
      except: 
        attr_type = eval(f"at.{attr_type}")
    return attr_type

  for attr_name, attr_type in type(parent_node).__annotations__.items():
    resolved_type = resolve_type(attr_type)
        
    origin = t.get_origin(resolved_type)
    args = t.get_args(resolved_type)
    
    # not list
    if getattr(parent_node, attr_name) is not None and origin is None: 
      continue
    
    # special case for join specification
    if isinstance(ast, at.JoinSpecification):
      if ast.on:
        setattr(parent_node, 'joinSpecification', ast.on)
        break
      if ast.using:
        setattr(parent_node, 'joinSpecification', ast.using)
        break
      
      
    
    if origin is not None:
      if origin is list:
        if isinstance(ast, args[0]):
          list_attr = getattr(parent_node, attr_name)
          list_attr.append(ast)
          break
      elif origin is t.Union:
        for arg in args:
          if isinstance(ast, arg):
            setattr(parent_node, attr_name, ast)
            break
    elif isinstance(ast, resolved_type):
      setattr(parent_node, attr_name, ast)
      break

def find(seq: str, ast: at.ASTNode, all = False, filter:t.Callable = lambda x: True, *args, **kwargs ) -> t.Union[at.ASTNode, t.List[at.ASTNode]]:
  """
  Find the node(s) in the AST. input example: "Where.Expression"
  seq no need start with root node, but must be in order. If multiple have same path, raise error first
  """
  
  order = seq.split(".")
  order_len = len(order)
  
  cur_match = 0
  match = []
  for cur_node in ast.dfs():
    cur_node_type = cur_node.node_type
    if cur_node_type == order[cur_match]:
      cur_match += 1
      if cur_match == order_len:
        if filter(cur_node, *args, **kwargs):
          if all:
            match.append(cur_node)
            cur_match -= 1
          else:
            return cur_node
        else:
          cur_match -= 1

    else:
      cur_match = 0 # reset the match
  
  return match

def find_bfs(seq: str, ast: at.ASTNode, all = False, filter:t.Callable = lambda x: True, *args, **kwargs ) -> t.Union[at.ASTNode, t.List[at.ASTNode]]:
  """
  Find the node(s) in the AST. input example: "Where.Expression"
  seq no need start with root node, but must be in order. If multiple have same path, raise error first
  """
  
  order = seq.split(".")
  order_len = len(order)
  
  cur_match = 0
  match = []
  for cur_node in ast.bfs():
    cur_node_type = cur_node.node_type
    if cur_node_type == order[cur_match]:
      cur_match += 1
      if cur_match == order_len:
        if filter(cur_node, *args, **kwargs):
          if all:
            match.append(cur_node)
            cur_match -= 1
          else:
            return cur_node
        else:
          cur_match -= 1

    else:
      cur_match = 0 # reset the match
  
  return match

def sql(ast: at.ASTNode) -> str:
  """
  Transform an AST back to SQL
  """
  
  generator = SQLGenerator()

  sql = generator.generate(ast)
  
  return sql

def transform(ast: at.ASTNode, func:t.Callable, inplace = True, *args, **kwargs):
  
  if inplace:
    for node in ast.dfs():
      func(node, *args, **kwargs)
  else:
    new_ast = deepcopy(ast)
    for node in new_ast.dfs():
      func(node, *args, **kwargs)
    return new_ast
    

if __name__ == '__main__':
  parser = argparse.ArgumentParser(description='SQL Parser and Transformer')
  parser.add_argument('-i', '--input', type=str, help='SQL query to parse', required=False)
  parser.add_argument('-e', '--expand_expr', action='store_true', help='Expand expressions in the AST', required=False, default=True)
  parser.add_argument('-sm', '--segmenter_model', type=str, required=False, default='gpt-4.1', help='Segmenter model to use')
  parser.add_argument('-vm', '--validator_model', type=str, required=False, default='gpt-4.1', help='Validator model to use')
  parser.add_argument('-d', '--dialect', type=str, required=False, default='DuckDB', help='SQL dialect in prompt')
  parser.add_argument('-u', '--use_llm', action='store_true', help='Use LLM for parsing', required=False, default=True)
  parser.add_argument('-v', '--use_validate', action='store_true', help='Use LLM to validate the segments', required=False, default=True)
  parser.add_argument('-a', '--use_anchor', action='store_true', help='Use anchor to segment the expression', required=False, default=True)
  
  args = parser.parse_args()
  
  if not args.input:
    input_sql = """
SELECT Count FROM t;
"""
  else:
    input_sql = args.input

  expand_expr = args.expand_expr
  segmenter_model = args.segmenter_model
  validator_model = args.validator_model
  dialect = args.dialect
  use_llm = args.use_llm
  use_validate = args.use_validate
  use_anchor = args.use_anchor
  

  ast, LLM_stats, warnings = parse(input_sql, expand_expr=expand_expr, segmenter_model = segmenter_model, validator_model = validator_model, dialect=dialect, use_llm=use_llm, use_validate=True, use_anchor=True)
  print("===========test ast=============")
  ast.pretty_print()
  print("=========LLM stats=========")
  print(LLM_stats)
  print(warnings)
  print("=========test sql generate=========")
  print(sql(ast))
  

  

  # print("===========test find============")
  # select_col: at.Column = find("Select.Columns.Column", ast)
  # where_cond: at.Expression = find("Where.Expression", ast)
  
  # print(select_col)
  # print(where_cond)
  
  # norec = False
  
  # if select_col.name == '*':
  #   norec = True
  
  # # transform func
  # def replace_star_column(node):
  #   if isinstance(node, at.Column) and node.name == '*':
  #     node.name = f"({where_cond.value}) IS TRUE"
  
  # def delete_where(node):
  #   if isinstance(node, at.SelectStmt):
  #     node.where = None
    
  # # transform api
  # new_ast = transform(ast, replace_star_column, inplace=False)
  # new_ast = transform(new_ast, delete_where, inplace=False)
  
  
  # print("===========test transform============")
  # print(sql(ast))
  # print(sql(new_ast))
  
  
  # for node in ast.dfs():
  #   if isinstance(node, Column) and node.name == '*':
  #     norec = True
  
  # if norec:
  #   norec_col = f"({where_cond.value}) IS TRUE"
  #   for node in ast.dfs():
  #     if isinstance(node, Column) and node.name == '*':
  #       node.name = norec_col
        
  # print("===========test transform============")
    
  # print(sql(ast))
      


