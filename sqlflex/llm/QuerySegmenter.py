from __future__ import annotations # for forward references, must be at the top of the file
# putting these lines at the very top of the python script ensures that langchain can pick up the USER_AGENT value
from dotenv import load_dotenv
load_dotenv()
import re
from dotenv import load_dotenv
from langchain_openai import ChatOpenAI
from pydantic import BaseModel
from typing import List, Optional, Tuple
from langchain_core.prompts import ChatPromptTemplate
import sqlflex.llm.ASTNodeLLM as llm
from sqlflex.sqlast.ASTNodes import DummyLeaf
from sqlflex.mappings import keywords
from langchain_deepseek import ChatDeepSeek
from langchain_google_genai import ChatGoogleGenerativeAI
from langchain_anthropic import ChatAnthropic
from langchain_community.callbacks.manager import get_openai_callback
from typing_extensions import List

# normalize pydantic model to None if the value is empty string
def normalize_empty_string_to_none(response: BaseModel):
  data = response.model_dump()
  def convert(value):
    if isinstance(value, str) and value == "":
      return None
    elif isinstance(value, dict):
      return {k: convert(v) for k, v in value.items()}
    elif isinstance(value, list):
      return [convert(item) for item in value]
    else:
      return value
  normalized_response = convert(data)
  return response.model_copy(update=normalized_response)

class QuerySegmenter():
  def __init__(self, segment_model: str = 'gpt-4.1', validator_model: str = 'gpt-4.1', segment_temp: float = 0.0, validator_temp: float = 0.5, dialect: str = 'duckdb', whole_query: str = None, use_validate = True):
    self.segment_model = segment_model
    self.validator_model = validator_model
    self.segment_temp = segment_temp
    self.validator_temp = validator_temp
    # hardcoded temperature
    if segment_model in ['gpt-4o', 'gpt-4o-mini', 'gpt-4.1-nano', 'gpt-4.1', 'gpt-4.1-mini']:
      self.client = ChatOpenAI(model=segment_model, temperature=0.0)
      self.validation_client = ChatOpenAI(model=segment_model, temperature=0.0, timeout=15)
    elif segment_model in ['gpt-5-mini', 'gpt-5']:
      self.client = ChatOpenAI(
        model=segment_model,
        reasoning_effort='minimal'
        )
      self.validation_client = ChatOpenAI(
        model=segment_model,
        reasoning_effort='minimal'
      )
    elif segment_model == 'o3-mini' or segment_model == 'o3' or segment_model == 'o4-mini':
      self.client = ChatOpenAI(model=segment_model, reasoning_effort='low')
      self.validation_client = ChatOpenAI(model=segment_model)
    elif segment_model == 'deepseek-chat':
      self.client = ChatDeepSeek(model='deepseek-chat', temperature=0.0)
      self.validation_client = ChatDeepSeek(model='deepseek-chat', temperature=0.5)
    elif segment_model == 'gemini':
      self.client = ChatGoogleGenerativeAI(model='gemini-2.5-flash', temperature=0.0, top_p=0.0)
      self.validation_client = ChatGoogleGenerativeAI(model='gemini-2.5-pro', temperature=0.0, top_p=0.0, thinking_budget=0)
    elif segment_model == 'claude-4':
      self.client = ChatAnthropic(model='claude-sonnet-4-20250514', temperature=0.0)
      self.validation_client = ChatAnthropic(model='claude-sonnet-4-20250514', temperature=0.0)
    else:
      raise ValueError(f"Unsupported segment model: {segment_model}. Supported models are: gpt-4.1, gpt-4.1-mini, gpt-4o, gpt-4o-mini, o3-mini, o3, o4-mini, deepseek-chat, gemini, claude-4.")
    self.dialect = dialect
    self.cost = 0.0
    self.called_times = 0
    self.fix_times = 0
    self.prompt_tokens = 0
    self.completion_tokens = 0
    self.whole_query = whole_query
    self.use_validate = use_validate
  
  def segment_query(self, query: str, llm_node: BaseModel, ignore_keyword = True):
    """
    Segment a SQL query into different clauses.
    
    :param query: The SQL query string.
    :param llm_node: The BaseModel for structured LLM output.
    :param token_validation_mode: 
          0 = disabled, 1 = regex tokenizer, 2 = character tokenizer.
    :param order_validation_mode: 
          0 = disabled, 1 = regex tokenizer, 2 = character tokenizer.
    """
    try:
      load_dotenv()
      client = self.client
      
      system = (
          "You are an SQL expert in various SQL dialects. Your task is to segment an SQL query or a valid part of a query into its components while adhering strictly to the following rules:\n\n"
          "- Token Grouping: Do not split tokens that are not space-separated. For example, func(expr(1)) must be treated as a single segment, preserving its entirety.\n"
          "- Completeness: Ensure all tokens from the original query are included in the segmented output. Do not add, modify, or omit any tokens.\n"
          "- Order Preservation: Maintain the exact order of tokens as they appear in the input.\n\n"
          "Important Notes:\n"
          f"- The input is **always a valid SQL query or a valid fragment of a query** in {self.dialect}.\n"
          "- Use the SQL's context and semantic information to understand the SQL query.\n"
          # "- Use your reasoning ability to identify dialect-specific features. If there's no semantically corresponding segment to put it in, then priortize segmenting to the **Other** segment\n"
          "- Reason step by step to ensure correctness and consistency: self-reflect on 3 to 5 results, and return the most consistent result as final output."
      )
      expression_system = (
        f"You are an SQL expert in various SQL dialects and SQL expressions. Your task is to segment an SQL expression in the {self.dialect} dialect based on the specifications and adhere to the following rules:\n\n"
          "- Token Grouping: Do not split tokens that are not space-separated. For example, func(expr(1)) must be treated as a single segment, preserving its entirety.\n"
          "- Completeness: Ensure all tokens from the original query are included in the segmented output. Do not add, modify, or omit any tokens.\n"
          "- Order Preservation: Maintain the exact order of tokens as they appear in the input.\n\n"
          "Important Notes:\n"
          f"- The input is **always a valid SQL expression or a valid fragment of a expression** in {self.dialect}.\n"
          "- Use its context and semantic information to understand the expression.\n"
          "- Reason step by step to ensure correctness and consistency: self-reflect on 3 to 5 results, and return the most consistent result as final output.\n"
      )
      human = (
        "Input SQL query: {query}"
      )
      if llm_node == llm.ExpressionExpand:
        prompt = ChatPromptTemplate.from_messages([("system", expression_system), ("human", human)])
      else:
        prompt = ChatPromptTemplate.from_messages([("system", system), ("human", human)])
      structured_llm =  client.with_structured_output(llm_node)
      initial_prompt = prompt | structured_llm
      with get_openai_callback() as cb:
        response = initial_prompt.invoke({"query": query})
        response = normalize_empty_string_to_none(response)
        # print(f"LLM response: {response}")
        # response = response['parsed']
        prompt_tokens = re.findall(r'Prompt Tokens: (\d+)', str(cb))
        completion_tokens = re.findall(r'Completion Tokens: (\d+)', str(cb))
        self.cost += cb.total_cost
        self.prompt_tokens += int(prompt_tokens[0]) if len(prompt_tokens) > 0 else 0
        self.completion_tokens += int(completion_tokens[0]) if len(completion_tokens) > 0 else 0
        self.called_times += 1
      
    
      if self.use_validate:
        response, validate_fail, fix_cost = _validate_and_fix_segmentation(
            segmenter = self,
            query=query,
            response=response,
            llm_node=llm_node,
            ignore_keyword=ignore_keyword,
        )
        self.cost += fix_cost
        if validate_fail:
          # if query starts with a keyword, then the keyword should not be added as a segment
          if query.split()[0].upper() in keywords and (llm_node != llm.SetOperation and llm_node != llm.SelectStmt):
              # remove the keyword token from the response
              dummy_response = DummyLeaf(value=" ".join(query.split()[1:]))
          else:
              dummy_response = DummyLeaf(value=query)
          # # -------- for eval purposes only --------
          # raise Exception("Validation failed")
          # # -------- for eval purposes only --------
          return dummy_response
      
      return response
    except Exception as e:
      dummy_response = DummyLeaf(value=query)
      return dummy_response

  def generate_query_from_ast(self, ast):
    """
    Generate a SQL query from the given AST.
    
    :param ast: The AST to generate the SQL query from.
    """
    try:
      load_dotenv()
      client = self.client
      
      system = (
          "You are an SQL expert in various SQL dialects. Your task is to generate a SQL query from the given AST while adhering strictly to the following rules:\n\n"
          "Important Notes:\n"
          f"- The input is **always a valid AST** in {self.dialect}.\n"
          "- Use the AST's context and semantic information to understand the SQL query.\n"
          "- Reason step by step to ensure correctness and consistency: self-reflect on 3 to 5 results, and return the most consistent result as final output."
          "- Only generate the SQL query, do not include any additional text or explanation. Output a JSON object with key 'query' containing the SQL query as a string."
      )
      
      human = (
        "Input AST: {ast}"
      )
      prompt = ChatPromptTemplate.from_messages([("system", system), ("human", human)])

      structured_llm =  client.with_structured_output(method='json_mode')
      initial_prompt = prompt | structured_llm
      response = initial_prompt.invoke({"ast": ast})
      
      return response


    except Exception as e:
      return DummyLeaf(value=str(ast))
      

def _validate_and_fix_segmentation(
  segmenter: QuerySegmenter,
  query: str, 
  response,
  llm_node,
  ignore_keyword: bool = True,
  # token_validation_mode: int = 1,  # 0 = disabled, 1 = regex, 2 = char
  # order_validation_mode: int = 1,   # 0 = disabled, 1 = regex, 2 = char
  max_attempts: int = 3
):

  fix_cost = 0.0
  
  # if token_validation_mode == 0 and order_validation_mode == 0:
  #     return response, False, fix_cost
      
  validate_client = segmenter.validation_client
  validation_llm = validate_client.with_structured_output(llm_node)
  
  token_fix_prompt = (
      "The segmented tokens differ from the original query's space-separated tokens. "
      "Ensure that the segmentation includes all tokens from the original query without adding or omitting any. "
      "Fix the segmentation by identifying the missing or extra tokens. "
      "Pay special attention to missing symbols and delimeters, e.g., parentheses, brackets, quotes, commas, and operators. "
      # "Think step by step: What are the tokens in the original query, and what should they be in the segmentation?"
  )

  order_fix_prompt = (
      "The order of tokens in the segmented output does not match the original query. "
      "Ensure that the segmentation preserves the exact order of tokens as they appear in the query. "
      "Fix the segmentation by aligning the token order correctly. "
      # "Think step by step: What is the correct order of tokens in the original query?"
  )
  
  expr_order_fix_prompt = (
    "The left operator must be on the left side of the operator, and the right operator must be on the right side of the operator. "
    "Ensure that the segmentation does not contain the left operator on the right side of the operator, and vice versa."
    "The left and right operand are defined as (left_operand operator right_operand) or (left_operand operator) or (operator right_operand)"
  )
  
  expr_mutex_fix_prompt = (
    "The literal and operator/operands are mutually exclusive. "
    "Ensure that the segmentation does not contain both literal and operator/operands."
  )
  
  projection_mutex_fix_prompt = (
    "Column, and expression are mutually exclusive. "
    "Ensure that the segmentation does not contain both column and expression. If ambiguous, prioritize expression."
  )
  
  table_ref_mutex_fix_prompt = (
    "The subquery, table name, and expression are mutually exclusive. "
    "Ensure that the segmentation does not contain both subquery, table name, and expression. If ambiguous, prioritize expression."
  )
  
  join_mutex_fix_prompt = (
    "The join type should not contain 'JOIN', and the keyword should be 'JOIN' and not include the join type. "
    "For example, 'LEFT JOIN' should be segmented as 'LEFT' to join type and 'JOIN' to keyword. "
    "Ensure that the segmentation does not contain both join type and keyword."
  )
  
  expr_parentk_fix_prompt = (
    "The literal contains <PAREN> token. "
    "Ensure that the segmentation does not contain <PAREN>, since it can be segmented further"
  )
  
  expr_no_ellipsis_fix_prompt = (
    "You should break the operator into separate operators, and choose the one that is higher in the hierarchy first (lower precedence). "
  )
  

  
  for attempt in range(max_attempts + 1):
    # Determine token validation based on mode
    # if token_validation_mode == 0:
    #   token_valid, diff = True, None
    # else:
    token_valid, diff = validate_tokens(query, response, ignore_keyword=ignore_keyword)
    # Determine order validation based on mode
    # if order_validation_mode == 0:
    #   order_valid, incorrects = True, None
    # else:
    order_valid, incorrects = validate_order(query, response, ignore_keyword=ignore_keyword)

      
    if llm_node == llm.ExpressionExpand:
      mutex_valid, mutex_incorrects = validate_expr_mutex(response)
      parentk_valid, parentk_incorrects = validate_expr_paren(response)
      op_order_valid, op_order_incorrects = validate_expr_op_order(response, query)
      op_no_ellipsis_valid, op_no_ellipsis_incorrects = validate_expr_op_no_ellipsis(response, query)
    else:
      mutex_valid, mutex_incorrects = True, None
      parentk_valid, parentk_incorrects = True, None
      op_order_valid, op_order_incorrects = True, None
      op_no_ellipsis_valid, op_no_ellipsis_incorrects = True, None
    
    if llm_node == llm.Projection:
      mutex_valid, mutex_incorrects = validate_projection_mutex(response)
    elif llm_node == llm.TableReference:
      mutex_valid, mutex_incorrects = validate_tableref_mutex(response)
    elif llm_node == llm.Join:
      mutex_valid, mutex_incorrects = validate_join_mutex(response)
      # pass

    # if all validation pass, we are done
    if (
      order_valid and 
      token_valid and 
      (llm_node != llm.ExpressionExpand or (mutex_valid and parentk_valid and op_order_valid and op_no_ellipsis_valid)) and 
      (llm_node != llm.Projection or mutex_valid) and 
      (llm_node != llm.TableReference or mutex_valid)
      and (llm_node != llm.Join or mutex_valid)
    ):
      return response, False, fix_cost
    if attempt == max_attempts:
      return response, True, fix_cost

    segmented_output_hint = f"The segmented output is: {str(response)}"
    whole_query_hint = f"The whole query is: {segmenter.whole_query}" if (segmenter.whole_query) else ""
    fix_hints = (
            "The segmentation is incorrect. Fix it based on these hints:\n"
            f"{token_fix_prompt if (not token_valid) else ''}\n"
            f"{f'The difference in tokens is: {str(diff)}' if (not token_valid) else ''}"
            f"{order_fix_prompt if (not order_valid) else ''}\n"
            f"{f'The incorrect order segments are: {str(incorrects)}' if (not order_valid) else ''}"
            f"{expr_mutex_fix_prompt if (not mutex_valid and llm_node == llm.ExpressionExpand) else ''}\n"
            f"{expr_parentk_fix_prompt if (not parentk_valid and llm_node == llm.ExpressionExpand) else ''}\n"
            f"{expr_order_fix_prompt if (not op_order_valid and llm_node == llm.ExpressionExpand) else ''}\n"
            f"{expr_no_ellipsis_fix_prompt if (not op_no_ellipsis_valid and llm_node == llm.ExpressionExpand) else ''}\n"
            f"{projection_mutex_fix_prompt if (not mutex_valid and llm_node == llm.Projection) else ''}\n"
            f"{table_ref_mutex_fix_prompt if (not mutex_valid and llm_node == llm.TableReference) else ''}\n"
            f"{join_mutex_fix_prompt if (not mutex_valid and llm_node == llm.Join) else ''}\n"
    )

    fix_prompt = ChatPromptTemplate.from_messages([
        ("system", """You are an SQL expert. Your task is to fix an incorrect SQL query segmentation while adhering to these rules:
- Token Grouping: Do not split tokens that are not space-separated. For example, func(expr(1)) must be treated as a single segment.
- Completeness: Ensure all tokens from the original query are included in the segmented output.
- Order Preservation: Maintain the exact order of tokens as they appear in the input.
- Self-reflect on 3 to 5 results, and choose the result that appears the most number of times.
"""),
        ("human", "The original input is: {query}"),
        ("human", segmented_output_hint.replace("{", "{{").replace("}", "}}")),
        ("human", whole_query_hint.replace("{", "{{").replace("}", "}}")),
        ("human", fix_hints.replace("{", "{{").replace("}", "}}")),
        ("human", "While fixing, first reflect on possible sources of the problem, distill those down to the most likely sources, validate your assumptions, and finally implement the fix.")
    ])
    validation_prompt = fix_prompt | validation_llm
    with get_openai_callback() as cb:
      response = validation_prompt.invoke({"query": query})
      response = normalize_empty_string_to_none(response)
      fix_cost += cb.total_cost
      segmenter.called_times += 1
      segmenter.fix_times += 1
  
  return response, True, fix_cost

def _char_tokenizer(query: str) -> List[str]:
  """Tokenize the query into individual characters, ignoring any whitespace."""
  # Convert the query into a list of characters and filter out whitespace
  return [char for char in query if not char.isspace()]

def validate_expr_paren(segmented_query: llm.ExpressionExpand, ignore_keyword: bool = True):

  if not isinstance(segmented_query, llm.ExpressionExpand):
    return True, None
  literal = segmented_query.literal
  
  if literal and "<PAREN" in literal:
    return False, [("literal", "Literal contains <PAREN> token.")]
  
  return True, None

def validate_expr_mutex(segmented_query: llm.ExpressionExpand, ignore_keyword: bool = True):
  
  if not isinstance(segmented_query, llm.ExpressionExpand):
    return True, None
  
  literal = segmented_query.literal
  op = segmented_query.operator
  left = segmented_query.left
  right = segmented_query.right
  # third = segmented_query.third
  msgs = []
  
  # if literal and (op or left or right or third):
  if literal and (op or left or right):
    msg = "Literal and operator/operands are mutually exclusive"
    msgs.append(("literal", msg))
  # if third and not (left and right):
  #   msg = "Third operand is not allowed without left and right operands"
  #   msgs.append(("third", msg))
  # if op and not (left or right or third or literal):
  if op and not (left or right or literal):
    msg = "Operator is not allowed without left or right or third operand"
    msgs.append(("operator", msg))  
  if len(msgs) > 0:
    return False, msgs

  return True, None

def validate_expr_op_no_ellipsis(segmented_query: llm.ExpressionExpand, input_query: str):
  """the operator should not contain ellipsis"""
  if not isinstance(segmented_query, llm.ExpressionExpand):
    return True, None
  operator = segmented_query.operator
  if operator and "..." in operator:
    return False, [("operator", "The operator should not contain ellipsis. You should break it into separate operators")]
  return True, None

def validate_expr_op_order(segmented_query: llm.ExpressionExpand, input_query: str, ignore_keyword: bool = True):
  """Checking if the left operator is on the left side of the operator, and the right operator is on the right side of the operator"""
  if not isinstance(segmented_query, llm.ExpressionExpand):
    return True, None
  operator = segmented_query.operator
  left = segmented_query.left
  right = segmented_query.right
  if operator and left and right:
    # find left in the input query
    left_index = input_query.lower().find(left.lower())
    right_index = input_query.lower().rfind(right.lower())
    operator_index = input_query.lower().find(operator.lower())
    # conservative, if not found, then it's fine for this validation
    # left right operator may have same substring, so if same index, conservatively assume it's correct
    # only when left_index > operator_index or right_index < operator_index, then it's wrong
    if (left_index > operator_index and right_index != -1 and operator_index != -1) or (right_index < operator_index and right_index != -1 and operator_index != -1):
      return False, [("operator", "The left operand must be on the left side of the operator, and the right operand must be on the right side of the operator")]
    else:
      return True, None
  elif operator and left and not right:
    left_index = input_query.lower().find(left.lower())
    operator_index = input_query.lower().find(operator.lower())
    if left_index > operator_index and left_index != -1:
      return False, [("operator", "The left operand must be on the left side of the operator")]
    return True, None
  elif operator and right and not left:
    right_index = input_query.lower().rfind(right.lower())
    operator_index = input_query.lower().find(operator.lower())
    if right_index < operator_index and right_index != -1:
      return False, [("operator", "The right operand must be on the right side of the operator")]
    return True, None
  return True, None

def validate_projection_mutex(segmented_query: llm.Projection, ignore_keyword: bool = True):
  if not isinstance(segmented_query, llm.Projection):
    return True, None
  column = segmented_query.column
  expr = segmented_query.expr
  # subquery = segmented_query.subquery
  # if column and (expr or subquery) or expr and (column or subquery) or subquery and (column or expr):
  if column and expr:
    return False, [("column", "Column and expression are mutually exclusive")]
  return True, None

def validate_tableref_mutex(segmented_query: llm.TableReference, ignore_keyword: bool = True):
  if not isinstance(segmented_query, llm.TableReference):
    return True, None
  subquery = segmented_query.subquery
  table = segmented_query.table_name
  expr = segmented_query.expr
  if subquery and (table or expr) or table and (subquery or expr) or expr and (subquery or table):
    return False, [("subquery", "Subquery, table name, and expression are mutually exclusive")]
  return True, None

def validate_join_mutex(segmented_query: llm.Join, ignore_keyword: bool = True):
  if not isinstance(segmented_query, llm.Join):
    return True, None
  join_type = segmented_query.joinType
  if join_type and 'JOIN' in join_type.upper():
    return False, [("joinType", "The join type should not contain 'JOIN', the join type appears before JOIN keyword in the query")]
  return True, None

def validate_tokens(original_query: str, segmented_query: BaseModel, ignore_keyword: bool = True) -> Tuple[bool, Optional[List[Tuple[str, str]]]]:
  """
  Enhanced token validation logic using character-level detection with readable output.
  
  :param tokenizer_func: Function to split a string into tokens (kept for compatibility, but char tokenizer is used internally).
  :param original_query: The original query string.
  :param segmented_query: A BaseModel instance whose fields contain segmented query parts.
  :param ignore_keyword: Flag to ignore differences that involve known keywords.
  :return: A tuple where the first element is True if tokens match, False otherwise,
            and the second element is None if tokens match or a list of differences.
  """
  if ignore_keyword:
    for keyword in keywords:
      original_query = original_query.lower().replace(keyword.lower(), "")
  original_query_chars = _char_tokenizer(original_query.lower())
  segmented_query_chars = []
  for key in segmented_query.model_fields.keys():
    segmented_value = getattr(segmented_query, key)
    if segmented_value:
      if isinstance(segmented_value, list):
        for value in segmented_value:
          if ignore_keyword:
            for keyword in keywords:
              value = value.lower().replace(keyword.lower(), "")
          segmented_query_chars.extend(_char_tokenizer(str(value).lower()))
      else:
        if ignore_keyword:
          for keyword in keywords:
            segmented_value = segmented_value.lower().replace(keyword.lower(), "")
        segmented_query_chars.extend(_char_tokenizer(str(segmented_value).lower()))
  

  tokens_original_dict = {token: original_query_chars.count(token) for token in set(original_query_chars)}
  tokens_segmented_dict = {token: segmented_query_chars.count(token) for token in set(segmented_query_chars)}
  
  difference = []
  missings = []
  less_thans = []
  if tokens_original_dict != tokens_segmented_dict:
    for token, count in tokens_original_dict.items():
      if token in tokens_segmented_dict:
        if tokens_segmented_dict[token] < count:
          difference.append((token, "less than original query"))
          less_thans.append(token)
          missings.append(token)
        elif tokens_segmented_dict[token] > count:
          difference.append((token, "more than original query"))
      else:
        # difference.append((token, "missing"))
        missings.append(token)
  
  all_missing_indexes_dict = {}
  all_missing_indexes = []
  for miss in missings:
    # find the all indexes missing token in the segmented query, compared with the original query
    indexes = [i for i, char in enumerate(original_query_chars) if char == miss]
    if indexes:
      for index in indexes:
        all_missing_indexes_dict[index] = miss
      all_missing_indexes.extend(indexes)
  
  all_missing_indexes.sort()
  # find consecutive ranges of all missing indexes
  consecutive_ranges = []
  if all_missing_indexes:
    start = all_missing_indexes[0]
    end = start
    for i in range(1, len(all_missing_indexes)):
      if all_missing_indexes[i] == end + 1:
        end = all_missing_indexes[i]
      else:
        consecutive_ranges.append((start, end))
        start = all_missing_indexes[i]
        end = start
    consecutive_ranges.append((start, end))
  for starttoend in consecutive_ranges:
    # build the string representation of the missing tokens
    start, end = starttoend
    missing_string = "".join(original_query_chars[start:end + 1])
    # no need to report missing strings that are already in less_thans
    if missing_string not in less_thans:
      difference.append((missing_string, "missing"))    

  diff_string = [f"{item[0]} is {item[1]}" for item in difference]

  if difference:
    return False, diff_string
  else:
    return True, None
  
  
def validate_order(original_query: str, segmented_query: BaseModel, ignore_keyword: bool = True):
  """
  Compare token order in each segment with the original query using character-level detection,
  ignoring case. Returns longest consecutive mismatch strings when order fails.
  
  For keys in a designated set (e.g. operator), allow non-contiguous matching 
  (i.e. the tokens must appear in order, but need not be adjacent).
  """
  
  tokens_original = _char_tokenizer(original_query.lower())
  incorrect_segment = []
  
  # Define which keys should be allowed non-contiguous matching.
  non_contiguous_keys = {'operator', 'other'}  # add more keys if needed

  def match_tokens(tokens_original, tokens_segment, allow_non_contiguous=False):
      if allow_non_contiguous:
          # Non-contiguous matching: Check that tokens_segment appear in order within tokens_original.
          index = 0
          for token in tokens_original:
              if token == tokens_segment[index]:
                  index += 1
                  if index == len(tokens_segment):
                      return True
          return False
      else:
          # Contiguous matching: tokens_segment must appear as a contiguous block in tokens_original.
          for start in range(len(tokens_original) - len(tokens_segment) + 1):
              if tokens_original[start:start + len(tokens_segment)] == tokens_segment:
                  return True
          return False

  for key in segmented_query.model_fields.keys():
      segmented_value = getattr(segmented_query, key)
      
      if ignore_keyword and key == 'keyword':
          continue
      
      if segmented_value:
          # Use non-contiguous matching if this key is flagged.
          allow_non_contiguous = key in non_contiguous_keys
          if isinstance(segmented_value, list):
              # Validate each segment in the list.
              for value in segmented_value:
                  tokens_in_segment = _char_tokenizer(value.lower())
                  if not match_tokens(tokens_original, tokens_in_segment, allow_non_contiguous):
                      incorrect_segment.append((key, "token order doesn't match"))
          else:
              tokens_in_segment = _char_tokenizer(segmented_value.lower())
              if not match_tokens(tokens_original, tokens_in_segment, allow_non_contiguous):
                  incorrect_segment.append((key, "token order doesn't match"))

  # transform incorrect_segment to string: The field item[0] item[1]
  incorrect_segment = [f"Field {item[0]} {item[1]}" for item in incorrect_segment]
  
  if incorrect_segment:
      return False, incorrect_segment
  else:
      return True, incorrect_segment
  

if __name__ == "__main__":
  segmenter = QuerySegmenter(dialect='DuckDB', segment_model='gpt-4.1')
  query = """SELECT * EXCLUDE(c0) FROM "cb@w" """
  ast = segmenter.directly_generate_all_ast(query)
  print(ast)
  pretty_printed = segmenter.generate_query_from_ast(ast)
  print(pretty_printed)