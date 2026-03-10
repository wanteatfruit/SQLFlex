from sqlflex.main import parse as sqlflex_parse
from sqlflex.main import sql as sqlflex_sql
from sqlflex.main import find as sqlflex_find_dfs
from sqlflex.main import find_bfs as sqlflex_find_bfs
from sqlflex.main import transform as sqlflex_transform
import typing as t
import sqlflex.sqlast.ASTNodes as at

def parse(sql: str, expand_expr = True, dialect: str = ''):
  """
  Parse SQL string into AST. If expand_expr is True, it will expand the expression nodes. If False, it will keep expressions as a string without parsing them.
  This is useful for cases where expressions are not needed to be rewritten or analyzed further.
  Return (ast, called_LLM, warnings)
  """
  return sqlflex_parse(sql, expand_expr, dialect=dialect)


def pretty_print(ast: at.ASTNode) -> str:
  """
  Generate SQL string from AST
  """
  
  return sqlflex_sql(ast)

def find(seq: str, ast: at.ASTNode, dfs = True, filter_func: t.Callable = lambda x: True, *args, **kwargs) -> at.ASTNode:
  """
  Find the node in the AST. input example: "Where.Operation"
  seq no need start with root node, but must be in order and consecutive.
  """
  if dfs:
    return sqlflex_find_dfs(seq, ast, False, filter_func, *args, **kwargs)
  else:
    return sqlflex_find_bfs(seq, ast, False, filter_func, *args, **kwargs)

def findall(seq: str, ast: at.ASTNode, dfs = True, filter_func: t.Callable = lambda x: True, *args, **kwargs) -> t.List[at.ASTNode]:
  """
  Find all nodes in the AST. input example: "Where.Operation"
  seq no need start with root node, but must be in order and consecutive.
  """
  if dfs:
    return sqlflex_find_dfs(seq, ast, True, filter_func, *args, **kwargs)
  else:
    return sqlflex_find_bfs(seq, ast, True, filter_func, *args, **kwargs)
  

def transform(ast: at.ASTNode, func:t.Callable, inplace = True, *args, **kwargs):
  """
  Transform AST with a function
  """
  return sqlflex_transform(ast, func, inplace, *args, **kwargs)