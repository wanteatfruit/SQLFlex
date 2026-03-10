from __future__ import annotations
from dataclasses import dataclass
import typing as t

@dataclass(init=False, repr=False)
class ASTNode:
  
  def __init__(self, node_type):
      self.node_type = node_type
      self.others: list[ASTNode] = []
      self.parent: ASTNode = None
      self.depth = 0

  def add_child(self, child):
      self.others.append(child)
      
  def __repr__(self):
      attrs = vars(self)
      attrs_str = ', '.join(f"{key}={value}" for key, value in attrs.items() if key not in ['node_type', 'others', 'parent', 'depth'] and value is not None and (not isinstance(value, (list, dict, str, bytes, bytearray)) or len(value) > 0))
      parent_str = f"parent={self.parent.node_type}" if self.parent else ""
      children_str = f"others={self.others}" if len(self.others) > 0 else ""
      depth_str = f"depth={self.depth}"
      parts = [attrs_str, children_str, parent_str]
      parts = [part for part in parts if part]
      return f"{self.node_type}({', '.join(parts)})"
    
  
  def __eq__(self, other):
    # First, ensure the other object is an ASTNode of the same type.
    if not isinstance(other, ASTNode) or type(self) != type(other):
        # print(f"not the same type: {type(self)} != {type(other)}")
        return False
    # Compare the node type
    if self.node_type != other.node_type:
        # print(f"not the same node type: {self.node_type} != {other.node_type}")
        return False
    # Build dictionaries of attributes excluding fields that are not relevant.
    def filtered_attrs(node):
        return {
            key: value
            for key, value in vars(node).items()
            if key not in ['parent', 'depth', 'hasParentheses']
        }

    self_attrs = filtered_attrs(self)
    other_attrs = filtered_attrs(other)

    # They should have the same keys.
    if self_attrs.keys() != other_attrs.keys():
        # print(f"not the same keys: {self_attrs.keys()} != {other_attrs.keys()}")
        return False
      
    for key in self_attrs:
        v1 = self_attrs[key]
        v2 = other_attrs[key]
        # If the value is another ASTNode, use recursive equality.
        if isinstance(v1, ASTNode) and isinstance(v2, ASTNode):
            if not v1 == v2:
                return False
        # If the value is a list, compare element-by-element.
        elif isinstance(v1, list) and isinstance(v2, list):
            if len(v1) != len(v2):
                return False
            for item1, item2 in zip(v1, v2):
                if isinstance(item1, ASTNode) and isinstance(item2, ASTNode):
                    if not item1 == item2:
                        return False
                else:
                    if item1 != item2:
                        return False
        else:
            if self._normalize_str(str(v1)) != self._normalize_str(str(v2)):
                # print(f"not the same value: {v1} != {v2}, key: {key}, self: {self}, other: {other}")
                return False

    return True

  def _normalize_str(self, s: str):
    return s.replace("\n", "").replace(" ", "").replace("\t", "").replace("\r", "").upper()

    
  def pretty_print(self):
    print(self._pretty_print())
  
  def _pretty_print(self, depth=0):
    indent = " " * depth
    result = f"{self.node_type}(\n"
    
    attrs = list(vars(self).items())
    filtered_attrs = [attr for attr in attrs if attr[0] not in ['node_type', 'parent', 'depth'] and attr[1] is not None and (not isinstance(attr[1], (list, dict, str, bytes, bytearray)) or len(attr[1]) > 0)]

    for i, (attr, value) in enumerate(filtered_attrs):
      result += f"{indent}  {attr}="
      if isinstance(value, ASTNode):
        result += value._pretty_print(depth + 2)
      elif isinstance(value, list):
        result += "[\n"
        for i, v in enumerate(value):
          result += f"{indent}    {v._pretty_print(depth + 4) if isinstance(v, ASTNode) else v}"
          if i < len(value) - 1:
            result += ",\n"
        result += f"]"
      else: # value is a primitive
        result += f"{value}"
      if i < len(filtered_attrs) - 1:
        result += "\n"

    result += f")"
    return result

  
  def dfs(self) -> t.Iterable[ASTNode]:
    stack = [self]
    
    while stack:
      node = stack.pop()
      
      yield node
      
      for child in node.get_children():
        stack.append(child)
  
      
  def bfs(self: ASTNode) -> t.Iterable[ASTNode]:
    queue = [self]
    
    while queue:
      node = queue.pop(0)
      
      yield node
      
      for child in node.get_children():
        queue.append(child)


  def _build_parent(self):
    """Build parent pointers for all nodes in the AST"""
    for node in self.dfs():
      children = node.get_children()
      for child in children:
        child.parent = node

  def _build_depth(self):
    """Build depth for all nodes in the AST"""
    for node in self.dfs():
      if node.parent:
        node.depth = node.parent.depth + 1
      else:
        node.depth = 0


  def get_children(self) -> t.List[ASTNode]:
    """Get all children of an AST node, return a list of children"""
    children = []
    for attr in dir(self):
      # ignore methods and private attributes and node_type and value
      if not callable(getattr(self, attr)) and not attr.startswith("__") and not attr == "node_type" and not attr == "value" and not attr == "parent" and not attr == "depth":
        attr_obj = getattr(self, attr)
        if isinstance(attr_obj, t.List):
          children.extend(attr_obj)
        elif isinstance(attr_obj, ASTNode):
          children.append(attr_obj)
    return children
    
 
class DummyNode(ASTNode):
  def __init__(self, value=None):
    super().__init__('DummyNode')
    self.value = value 
 
class DummyRoot(DummyNode):
  def __init__(self, value=None):
    super().__init__(value)
    self.isSetOperation = False

class DummyLeaf(DummyNode):
  def __init__(self, value=None):
    super().__init__(value)
    self.pos = -1

class DummyInner(DummyNode):
  def __init__(self, value=None):
    super().__init__(value)
    self.pos = -1

# used to store the result of the "other" in segments
class Other(ASTNode):
  def __init__(self, value=None):
    super().__init__('Other')
    self.value = value
    self.pos = -1

class Subquery(ASTNode):
  selectStmt: t.Union[SelectStmt | SetOperation]
  
  def __init__(self):
    super().__init__('Subquery')
    self.this: t.Union[SelectStmt | SetOperation] = None     
    
class SetOperation(ASTNode):
  selectStmt1: SelectStmt
  setOp: str
  selectStmt2: SelectStmt
  
  def __init__(self):
    super().__init__('SetOperation')
    self.selectStmt1: SelectStmt = None
    self.setOp: str = ""
    self.selectStmt2: SelectStmt = None
 

 
class SelectStmt(ASTNode):
  select: Select
  from_: From
  joins: t.List[Join]
  where: Where
  group_by: GroupBy
  having: Having
  order_by: OrderBy
  limit: Limit # augment
  updatability: Updatability
  
  def __init__(self):
    super().__init__('SelectStmt')
    self.select: Select = None
    self.from_: From = None
    self.joins: t.List[Join] = []
    self.where: Where = None 
    self.group_by: GroupBy = None
    self.having: Having = None
    self.window: Window = None # sql03
    self.order_by: OrderBy = None
    self.limit: Limit = None
    self.updatability: Updatability = None
            
class Select(ASTNode):
  projections: t.List[Projection]
  selectSpecifiers: str
  
  def __init__(self):
    super().__init__('Select')
    # self.columns: Columns = None
    self.projections: t.List[Projection] = []
    self.selectSpecifiers: str = ""

class SelectOption(ASTNode):
  option: str
  
  def __init__(self, option=None):
    super().__init__('SelectOption')
    self.option: str = option    
    

class Projections(ASTNode):
  def __init__(self):
    super().__init__('Projections')
    self.projections: t.List[Projection] = []    

class Projection(ASTNode):
  expr: Expression
  column: Column
  alias: Alias
  subquery: t.Union[SetOperation | SelectStmt | Subquery]

  def __init__(self):
    super().__init__('Projection')
    self.expr: Expression = None
    self.column: Column = None
    self.alias: Alias = None
    self.subquery: t.Union[SetOperation | SelectStmt] = None
    
class Alias(ASTNode):
  alias: str
  as_: bool
  columns: t.List[Column]
  
  def __init__(self):
    super().__init__('Alias')
    self.alias: str = ""
    self.as_: bool = False
    self.columns: t.List[Column] = []
    
class From(ASTNode):
  tables: t.List[TableReference]
  
  def __init__(self):
    super().__init__('From')
    self.tables: t.List[TableReference] = []

# placeholder node    
class TableReferences(ASTNode):
  def __init__(self):
    super().__init__('TableReferences')
    self.tables: t.List[TableReference] = []
    
class TableReference(ASTNode):
  table: Table
  expr: Expression
  alias: Alias
  subquery: t.Union[SetOperation | SelectStmt | Subquery]
  
  def __init__(self):
    super().__init__('TableReference')
    self.table: Table = None
    self.expr: Expression = None
    self.alias: Alias = None
    self.subquery: t.Union[SetOperation | SelectStmt] = None
    # self.sample: str = None # sql03

# # sql03
# class Sample(ASTNode):
#   sample: str
#   def __init__(self):
#     super().__init__('Sample')
#     self.sample: str = ""

class Join(ASTNode):
  table: TableReference
  joinType: str
  joinSpecification: JoinSpecification
  
  def __init__(self):
    super().__init__('Join')
    self.table: TableReference = None
    self.joinType: str = ""
    self.joinSpecification: JoinSpecification = None

class JoinType(ASTNode):
  joinType: str
  
  def __init__(self, value=""):
    super().__init__('_JoinType')
    self.joinType: str = value

class JoinSpecification(ASTNode):
  on: On
  using: Using
  
  def __init__(self):
    super().__init__('JoinSpecification')
    self.on: On = None
    self.using: Using = None    
    
class On(ASTNode):
  expr: Expression
  
  def __init__(self):
    super().__init__('On')
    self.expr: Expression = None

class Using(ASTNode):
  columns: t.List[Column]
  
  def __init__(self):
    super().__init__('Using')
    self.columns: t.List[Column] = []
    
class Where(ASTNode):
  expr: Expression
  
  def __init__(self):
    super().__init__('Where')
    self.expr: Expression = None

class GroupBy(ASTNode):
  groupByItems: t.List[GroupByItem]
  collate: str
  
  def __init__(self):
    super().__init__('GroupBy')
    self.groupByItems: t.List[GroupByItem] = []
    self.collate: str = ""
    
class GroupByItem(ASTNode):
  expr: Expression
  
  def __init__(self):
    super().__init__('GroupByItem')
    self.expr: Expression = None
    
class Having(ASTNode):
  expr: Expression
  
  def __init__(self):
    super().__init__('Having')
    self.expr: Expression = None
    
class OrderBy(ASTNode):
  orderByItems: t.List[OrderByItem]
  
  def __init__(self):
    super().__init__('OrderBy')
    self.orderByItems: t.List[OrderByItem] = []
    
class OrderByItem(ASTNode):
  expr: Expression
  order: str
  
  def __init__(self):
    super().__init__('OrderByItem')
    self.expr: Expression = None
    self.order: str = "" # ASC or DESC
    
    

class Updatability(ASTNode):
  updatability: str
  
  def __init__(self):
    super().__init__('Updatability')
    self.updatability: str = ""

# # sql03
class Window(ASTNode):
  windowClause: str
  def __init__(self):
    super().__init__('Window')
    self.windowClause: str = ""

# augment

class Limit(ASTNode):
  limitClause: str
  def __init__(self):
    super().__init__('Limit')
    self.limitClause: str = ""

class Expression(ASTNode):
  value: str
  def __init__(self, expr_type='Expression'):
    super().__init__(expr_type)
    self.value: str = "" # if no expand expression, value is the expression itself
    self.hasParentheses: bool = None

class Operation(Expression):
  value: str
  def __init__(self, expr_type='Operation'):
    super().__init__(expr_type)
    self.op: str = ""
    self.left: ASTNode = None
    self.right: ASTNode = None
    self.third: ASTNode = None
    self.hasParentheses: bool = None

class ExpressionList(Expression):
  def __init__(self, value=None):
    super().__init__('ExpressionList')
    self.exprList: t.List[Expression] = value if value is not None else []
    self.modifier: str = ""
    
class Column(ASTNode):
  name: str
  owner: str
  
  def __init__(self, value=None):
    super().__init__('Column')
    # self.id: Identifer = None
    self.name: str = value
    self.owner: str = ""
    self.hasParentheses: bool = None
    
class Table(ASTNode):
  name: str
  owner: str
  
  def __init__(self, value=None):
    super().__init__('Table')
    self.name: str = value
    self.owner: str = ""

class Columns(ASTNode):
  def __init__(self, value=None):
    super().__init__('Columns')
    self.columns: t.List[Column] = value if value is not None else []
    

class Function(Expression):
  name: str
  args: t.List[Expression]
  
  def __init__(self):
    super().__init__('Function')
    self.name: str = ""
    self.args: ExpressionList = []
    
class Case(Expression):
  def __init__(self):
    super().__init__('Case')
    self.case: Expression = None
    self.when: t.List[Expression] = []
    self.else_: Expression = None
    
class When(Expression):
  def __init__(self):
    super().__init__('When')
    self.when: Expression = None
    self.then: Expression = None
    
class Identifier(Expression):
  def __init__(self, value):
    super().__init__('Identifier')
    self.value = value


class Literal(Expression):
  def __init__(self, type, value):
    super().__init__(type)
    self.value = value
    
class AsteriskLiteral(Literal):
  def __init__(self, value):
    super().__init__('Asterisk', value)

class StringLiteral(Literal):
  def __init__(self, value):
    super().__init__('String', value)

class NumberLiteral(Literal):
  def __init__(self, value):
    super().__init__('Number', value)

class BooleanLiteral(Literal):
  def __init__(self, value):
    super().__init__('Boolean', value)

class NullLiteral(Literal):
  def __init__(self, value):
    super().__init__('Null', value)

class DateTimeLiteral(Literal):
  def __init__(self, value):
    super().__init__('DateTime', value)

class HexLiteral(Literal):
  def __init__(self, value):
    super().__init__('Hex', value)

class BitLiteral(Literal):
  def __init__(self, value):
    super().__init__('Bit', value)
  

class Operator(ASTNode):
  def __init__(self, value):
    super().__init__('Operator')
    self.value = value

# @dataclass
class Mask(Expression):
  # value: str
  def __init__(self, value):
    super().__init__('Mask')
    self.value = value
    
  # def __eq__(self, other):
  #   if not isinstance(other, Mask):
  #     return False
  #     # Compare both the base fields (from ASTNode) and the additional 'value'
  #   return (self.parent is other.parent and
  #           self.others == other.others and
  #           self.value == other.value)
    

# temp, only for the modifier distinct in MAX(distinct expr, ...)
class Modifier(ASTNode):
  def __init__(self, value):
    super().__init__('Modifier')
    self.value = value