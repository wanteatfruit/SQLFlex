import re

class HeuristicParser:
  
  def parse_setop(self, sql:str):
    """
    Extract set operations and SELECT statements from a SQL query.
    """

    def clean_sql_statement(statement):
        statement = re.sub(r'\s*,\s*', ', ', statement)
        statement = re.sub(r'\s*=\s*', ' = ', statement)

        return statement.strip()

    def extract_set_operations_and_selects(sql_query):
        set_operations = {'UNION', 'INTERSECT', 'EXCEPT'}
        modifiers = {'ALL', 'DISTINCT', 'BY', 'NAME'}
        
        operations = []  # To store set operations
        selects = []  # To store SELECT statements
        query = sql_query.strip()
        
        while True:
            # Tokenize the query
            tokens = re.split(r'(\s+|,|;|\(|\)|"[^"]*"|\'[^\']*\')', query)
            tokens = [token.strip() for token in tokens if token.strip()]  # Remove empty tokens and whitespace
            stack = []  # Track parentheses
            operand_start = 0
            found = False
            
            for i, token in enumerate(tokens):
                if token == '(':
                    stack.append(i)
                elif token == ')':
                    if stack:
                        stack.pop()
                elif token.upper() in set_operations and not stack:
                    # Found a set operation outside of parentheses
                    set_operation = token.upper()
                    modifier_tokens = []
                    
                    # Collect all consecutive modifiers (ALL, DISTINCT, etc.)
                    j = i + 1
                    while j < len(tokens) and tokens[j].upper() in modifiers:
                        modifier_tokens.append(tokens[j].upper())
                        j += 1
                    
                    if modifier_tokens:
                        set_operation += f" {' '.join(modifier_tokens)}"
                    
                    left_operand_tokens = tokens[operand_start:i]
                    right_operand_tokens = tokens[j:]
                    
                    # Join tokens back into strings
                    left_operand = ' '.join(left_operand_tokens).strip()
                    right_operand = ' '.join(right_operand_tokens).strip()
                    
                    # Ensure parentheses balance for left and right operands
                    if left_operand.count('(') != left_operand.count(')') or \
                      right_operand.count('(') != right_operand.count(')'):
                        raise ValueError("Parentheses mismatch in SQL query.")
                    
                    # Add the set operation and cleaned left operand
                    operations.append(set_operation)
                    selects.append(clean_sql_statement(left_operand))
                    
                    # Update the query to continue parsing
                    query = right_operand
                    found = True
                    break
            
            if not found:
                break  # No more set operations found

        # Add the last remaining query as a cleaned SELECT statement
        if query.strip():
            selects.append(clean_sql_statement(query.strip()))

        return operations, selects
      
    set_operations, select_statements = extract_set_operations_and_selects(sql)
    

    return set_operations, select_statements
  
  def remove_redundant_parentheses(self, s: str):
    """
    Remove redundant parentheses from the input string,
    but ignore any parentheses inside single or double-quoted literals.
    """
    def remove_consecutive_tuples(tuples_list):
      result = set()
      n = len(tuples_list)
      for i in range(n):
        for j in range(i + 1, n):
          t1, t2 = tuples_list[i], tuples_list[j]
          if abs(t1[0] - t2[0]) == 1 and abs(t1[1] - t2[1]) == 1:
            result.add(t1 if t1[0] < t2[0] else t2)
      to_remove_idx = []
      for opening, closing in result:
        to_remove_idx.extend([opening, closing])
      return to_remove_idx

    # collapse spaced parens outside of literals
    s = s.replace('( (', '((').replace(') )', '))')

    stack = []
    pairs = []
    i = 0
    while i < len(s):
      c = s[i]
      # skip over quoted literals entirely
      if c in ("'", '"'):
        quote_char = c
        i += 1
        while i < len(s):
          if s[i] == quote_char:
            # handle doubled‑quote escape in SQL strings
            if i + 1 < len(s) and s[i + 1] == quote_char:
              i += 2
              continue
            i += 1
            break
          i += 1
        continue

      if c == '(':
        stack.append(i)
      elif c == ')':
        if stack:
          opening_index = stack.pop()
          pairs.append((opening_index, i))
      i += 1

    to_remove = remove_consecutive_tuples(pairs)
    return ''.join(ch for idx, ch in enumerate(s) if idx not in to_remove)


  def remove_outer_parenthesis(self, s: str):
    """
    Remove the outermost parentheses from the input string
    but ignore any parentheses inside single or double-quoted literals.
    """
    # collapse spaced parens outside of literals
    s = s.replace('( (', '((').replace(') )', '))')

    stack = []
    pairs = []
    i = 0
    while i < len(s):
      c = s[i]
      # skip over quoted literals entirely
      if c in ("'", '"'):
        quote_char = c
        i += 1
        while i < len(s):
          if s[i] == quote_char:
            if i + 1 < len(s) and s[i + 1] == quote_char:
              i += 2
              continue
            i += 1
            break
          i += 1
        continue

      if c == '(':
        stack.append(i)
      elif c == ')':
        if stack:
          opening_index = stack.pop()
          pairs.append((opening_index, i))
      i += 1

    # if the very first '(' matches the very last ')', strip them
    if pairs and pairs[0][0] == 0 and pairs[0][1] == len(s) - 1:
      return s[1:-1]
    return s
    
  
  def normalize(self, s: str):
    # normalize the sql, remove all excess spaces and newlines
    cur_sql = s
    cur_sql = re.sub(r';\s*$','', cur_sql)
    cur_sql = re.sub(r'\s+', ' ', cur_sql)
    cur_sql = cur_sql.replace('\n', ' ').replace('\t', ' ').strip()
    cur_sql = cur_sql.replace('\\n', ' ').replace('\\t', ' ').strip()
    cur_sql = cur_sql.rstrip(';')
    # make sure there is at most one semicolon at the end
    return cur_sql
    


if __name__ == "__main__":
  sql_query = """
SELECT UNNEST ( ( '1,2,3,4,,6',( case when random() < 10 then 0 else 1 end ) ) )
"""
  
  parser = HeuristicParser()
  root = parser.remove_redundant_parentheses(sql_query)
  
  print(root)

