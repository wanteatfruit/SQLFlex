import typing as t

def get_attributes(obj) -> t.Dict:
  """Get all attributes of an object, return a dictionary of attribute name and value"""
  attributes = {}
  for attr in dir(obj):
    # ignore methods and private attributes and node_type and value
    if not callable(getattr(obj, attr)) and not attr.startswith("__") and not attr == "node_type" and not attr == "value":
      attributes[attr] = getattr(obj, attr)
  return attributes


def split_comma(sql: str):
    """Find the outermost commas (ignore commas in brackets, braces, parenthesis and quotes).
    Return the separated str list."""
    stack = []
    comma_pos = []
    in_quote = None

    for i, c in enumerate(sql):
        # If we're inside a quote, only check for its closing quote.
        if in_quote:
            if c == in_quote:
                in_quote = None
            continue

        # Not inside a quote: check if we are starting one.
        if c in ("'", '"'):
            in_quote = c
        elif c in "([{":
            stack.append(c)
        elif c in ")]}":
            if stack:
                stack.pop()
        elif c == ',' and not stack:
            comma_pos.append(i)

    if not comma_pos:
        return [sql]
    else:
        result = []
        start = 0
        for pos in comma_pos:
            result.append(sql[start:pos])
            start = pos + 1
        result.append(sql[start:])
        return result

def remove_outer_paren(sql: str):
  """Extract the outer most parenthesis, return the extracted string"""
  if sql[0] == '(' and sql[-1] == ')':
    return sql[1:-1]
  else:
    return sql
  

def extract_other_group(string: str, segment: str):
  parts_segment = segment.split()
  parts_string = string.split()
  # Check for continuous phrases in the string
  result = []
  temp_phrase = []
  
  # Pointers to keep track of the current position in the string and segment
  pointer_segment = 0
  pointer_string = 0
  
  while pointer_string < len(parts_string) and pointer_segment < len(parts_segment):
    if parts_string[pointer_string].upper() == parts_segment[pointer_segment].upper(): # case insensitive, as LLM may change the case
        temp_phrase.append(parts_string[pointer_string])
        pointer_string += 1
        pointer_segment += 1
    else:
        if temp_phrase:
            result.append(" ".join(temp_phrase))
            temp_phrase = []
        pointer_string += 1
  
  if temp_phrase:
    result.append(" ".join(temp_phrase))
  
  if result:
    return result
  else:
    # not space-separated, use regex to find the segment in the string
    import re
    parts = [re.escape(p) for p in segment.strip().split()]
    pattern = r"\s*".join(parts)
    matches = re.finditer(pattern, string, flags=re.IGNORECASE)
    return [m.group(0) for m in matches]

def normalize_sql(sql: str):
  sql = sql.strip()
  sql = sql.replace('\n', '')
  sql = sql.replace('\t', '')
  sql = sql.replace(' ', '')
  sql = sql.replace(';', '')
  sql = sql.lower()
  return sql


if __name__ == "__main__":
  string = "SELECT CNT(*), c1, RAND(t) FROM t2 OTHER STUFF WHERE t>1 INTO FILE"
  segment = "OTHER STUFF INTO FILE"
  print(extract_other_group(string, segment))
  