from sqlflex.sqlast.ASTNodes import *
import re

class SQLGenerator:
  
  def generate(self, node:ASTNode):
    sql = ""
    if isinstance(node, SetOperation):
      sql = self.genSetOperation(node)
    elif isinstance(node, SelectStmt):
      sql = self.genSelectStmt(node)
    elif isinstance(node, DummyNode):
      sql = node.value.strip()
    elif isinstance(node, Expression):
      sql = self.genExpr(node)
    elif isinstance(node, Subquery):
      sql = self.genSubquery(node)
    elif isinstance(node, ExpressionList):
      sql = self.genExprList(node)
    else:
      raise ValueError(f"Node type {node.node_type} not supported")

    # if no semicolon, add
    if sql[-1] != ";":
      sql += ";"

    # Remove spaces after '('
    sql = re.sub(r'\(\s+', '(', sql)
    # Remove spaces before ')'
    sql = re.sub(r'\s+\)', ')', sql)
    # Remove spaces before ','
    sql = re.sub(r'\s+,', ',', sql)

    return sql

  def genDummyNode(self, curNode: ASTNode, parts:t.List[str]) -> str:
    if curNode.others:
      for c in curNode.others:
        if isinstance(c, DummyLeaf):
          parts.insert(c.pos, c.value)
        elif isinstance(c, Other):
          parts.insert(c.pos, c.value)
  
  def genSubquery(self, node: Subquery) -> str:
    if isinstance(node, Subquery):
      node = node.this
    elif isinstance(node, SelectStmt) or isinstance(node, SetOperation):
      pass
    parts = []
    if isinstance(node, SelectStmt):
      parts.append(self.genSelectStmt(node))
    elif isinstance(node, SetOperation):
      parts.append(self.genSetOperation(node))
    # self.genDummyNode(node, parts)
    
    return "(" + " ".join(parts) + ")"
          
  def genSetOperation(self, node: SetOperation) -> str:
    parts = []
    left = node.selectStmt1
    right = node.selectStmt2
    if left:
      if isinstance(left, SetOperation):
        parts.append(self.genSetOperation(left))
      elif isinstance(left, SelectStmt):
        parts.append(self.genSelectStmt(left))
    if node.setOp:
      parts.append(node.setOp)
    if right:
      if isinstance(right, SetOperation):
        parts.append(self.genSetOperation(right))
      elif isinstance(right, SelectStmt):
        parts.append(self.genSelectStmt(right))
    self.genDummyNode(node, parts)

    return " ".join(parts)

  def genSelectStmt(self, node: SelectStmt) -> str:
    parts = []
    if node.select:
      parts.append(self.genSelect(node.select))
    if node.from_:
      parts.append(self.genFrom(node.from_))
    if node.joins:
      parts.append(self.genJoins(node.joins))
    if node.where:
      parts.append(self.genWhere(node.where))
    if node.group_by:
      parts.append(self.genGroupBy(node.group_by))
    if node.having:
      parts.append(self.genHaving(node.having))
    if hasattr(node, "window") and node.window:
      parts.append(self.genWindow(node.window))
    if node.order_by:
      parts.append(self.genOrderBy(node.order_by))
    if node.limit:
      parts.append(self.genLimit(node.limit))
    if node.updatability:
      parts.append(self.genUpdatability(node.updatability))
    self.genDummyNode(node, parts)
    
    sql = " ".join(parts)
    
    return sql
  
  def genLimit(self, node: Limit) -> str:
    return node.limitClause
  
  def genSelect(self, node: Select) -> str:
    parts = []
    if node.selectSpecifiers:
      parts.append(node.selectSpecifiers)
    if node.projections:
      parts.append(self.genProjections(node.projections))
      
    self.genDummyNode(node, parts)
    
    return "SELECT "+" ".join(parts)
  
  def genProjections(self, proj_list: t.List[Projection]) -> str:
    parts = []
    for p in proj_list:
      parts.append(self.genProjection(p))
    return ", ".join(parts)
  
  def genProjection(self, node: Projection) -> str:
    parts = []
    if node.column:
      parts.append(self.genColumn(node.column))
    elif node.expr:
      parts.append(self.genExpr(node.expr))
    elif node.subquery:
      parts.append(self.genSubquery(node.subquery))
    if node.alias:
      parts.append(self.genAlias(node.alias))
      
    self.genDummyNode(node, parts)
    
    return " ".join(parts)
  
  def genFrom(self, node: From) -> str:
    parts = []
    if node.tables:
      parts.append(self.genTableReferences(node.tables))
    
    self.genDummyNode(node, parts)
    return "FROM " + " ".join(parts)
  
  def genTableReferences(self, table_list: t.List[TableReference]) -> str:
    parts = []
    for t in table_list:
      parts.append(self.genTableReference(t))
    return ", ".join(parts)
  
  def genTableReference(self, node: TableReference) -> str:
    parts = []
    if node.table:
      parts.append(self.genTable(node.table))
    elif node.expr:
      parts.append(self.genExpr(node.expr))
    elif node.subquery:
      parts.append(self.genSubquery(node.subquery))
    if node.alias:
      parts.append(self.genAlias(node.alias))
    self.genDummyNode(node, parts)
    return " ".join(parts)
  
  def genTable(self, node: Table) -> str:
    parts = []
    if node.owner and node.name:
      parts.append(node.owner+"."+node.name)
    elif node.name:
      parts.append(node.name)
    self.genDummyNode(node, parts)
    return " ".join(parts)
  
  
  def genWhere(self, node: Where) -> str:
    parts = []
    if node.expr:
      parts.append(self.genExpr(node.expr))
    self.genDummyNode(node, parts)
    return "WHERE "+" ".join(parts)
  
  
  def genColumn(self, node: Column) -> str:
    parts = []
    if node.owner and node.name:
      parts.append(node.owner+"."+node.name)
    elif node.name:
      parts.append(node.name)
    if hasattr(node, 'hasParentheses') and node.hasParentheses: # when it's used in expression
      parts.insert(0, "(")
      parts.append(")")
    self.genDummyNode(node, parts)
    return " ".join(parts)

  def genAlias(self, node: Alias) -> str:
    parts = []
    alias = ""
    if node.alias and node.columns:
      alias = node.alias
      column_names = []
      for c in node.columns:
        column_names.append(self.genColumn(c))
      columns = ", ".join(column_names)
      columns = "("+columns+")"
      alias += columns
    elif node.alias:
      alias = node.alias
    parts.append(alias)
    self.genDummyNode(node, parts)
    if node.as_:
      parts.insert(0, "AS")
    
    return " ".join(parts)
  
  def genJoins(self, join_list: t.List[Join]) -> str:
    parts = []
    for j in join_list:
      parts.append(self.genJoin(j))
    return " ".join(parts)
  
  def genJoin(self, node: Join) -> str:
    parts = []
    if node.joinType:
      parts.insert(0, node.joinType)
      parts.append("JOIN")
    if node.table:
      parts.append(self.genTableReference(node.table))
    if node.joinSpecification:
      parts.append(self.genJoinSpecification(node.joinSpecification))
    self.genDummyNode(node, parts)
    
    if "JOIN" in parts:
      return " ".join(parts)
    else:
      return "JOIN " + " ".join(parts)
  
  def genJoinSpecification(self, node: t.Union[On | Using]) -> str:
    parts = []
    if isinstance(node, On):
      parts.append(self.genOn(node))
    elif isinstance(node, Using):
      parts.append(self.genUsing(node))
    # self.genDummyNode(node, parts)
    return " ".join(parts)
    # if node.on:
    #   parts.append(self.genOn(node.on))
    # if node.using:
    #   parts.append(self.genUsing(node.using))
    # self.genDummyNode(node, parts)
    # return " ".join(parts)

    
  def genOn(self, node: On) -> str:
    parts = []
    if node.expr:
      parts.append(self.genExpr(node.expr))
    self.genDummyNode(node, parts)
    return "ON " + " ".join(parts)
  
  def genUsing(self, node: Using) -> str:
    parts = []
    using_columns_parts = []
    if node.columns:
      parts.append("(")
      for i, item in enumerate(node.columns):
        using_columns_parts.append(self.genExpr(item))
        if i < len(node.columns) - 1:
          using_columns_parts.append(",")
    parts.append(" ".join(using_columns_parts))
    parts.append(")")
    self.genDummyNode(node, parts)
    return "USING " + " ".join(parts)
  
  def genGroupBy(self, node: GroupBy) -> str:
    parts = []
    group_by_items_parts = []
    if node.groupByItems:
      for i, item in enumerate(node.groupByItems):
        group_by_items_parts.append(self.genGroupByItem(item))
        if i < len(node.groupByItems) - 1:
          group_by_items_parts.append(",")
    parts.append(" ".join(group_by_items_parts))
    if hasattr(node, "collate") and node.collate:
      parts.append(node.collate)
    self.genDummyNode(node, parts)
    return "GROUP BY " + " ".join(parts)
  
  def genGroupByItem(self, node: GroupByItem) -> str:
    parts = []
    if node.expr:
      parts.append(self.genExpr(node.expr))
    self.genDummyNode(node, parts)
    return " ".join(parts)
  
  def genHaving(self, node: Having) -> str:
    parts = []
    if node.expr:
      parts.append(self.genExpr(node.expr))
    self.genDummyNode(node, parts)
    return "HAVING " + " ".join(parts)
  
  
  def genOrderBy(self, node: OrderBy) -> str:
    parts = []
    order_by_items_parts = []
    if node.orderByItems:
      for i, item in enumerate(node.orderByItems):
        order_by_items_parts.append(self.genOrderByItem(item))
        if i < len(node.orderByItems) - 1:
          order_by_items_parts.append(",")
    parts.append(" ".join(order_by_items_parts))
    self.genDummyNode(node, parts)
    return "ORDER BY " + " ".join(parts)
  
  def genOrderByItem(self, node: OrderByItem) -> str:
    parts = []
    if node.expr:
      parts.append(self.genExpr(node.expr))
    if node.order:
      parts.append(node.order)
    self.genDummyNode(node, parts)
    return " ".join(parts)
  
  
  def genUpdatability(self, node: Updatability) -> str:
    parts = []
    if node.updatability:
      parts.append(node.updatability)
    self.genDummyNode(node, parts)
    return " ".join(parts)
  
  def genOperand(self, node) -> str:
    parts = []
    if isinstance(node, Expression):
      parts.append(self.genExpr(node))
    elif isinstance(node, Column):
      parts.append(self.genColumn(node))
    elif isinstance(node, ExpressionList):
      parts.append(self.genExprList(node))
    elif isinstance(node, Subquery):
      parts.append(self.genSubquery(node))
    self.genDummyNode(node, parts)
    return " ".join(parts)
    
  def genExpr(self, node: Expression) -> str:
    parts = []
    if node is None:
      return ""
    if isinstance(node, Literal):
      parts.append(self.genLiteral(node))
    elif isinstance(node, Function):
      parts.append(self.genFunction(node))
    elif isinstance(node, Case):
      parts.append(self.genCase(node))
    elif isinstance(node, ExpressionList):
      parts.append(self.genExprList(node))
    elif isinstance(node, Operation):
      if not node.left and node.op and node.right and not node.third: # unary
        parts.append(node.op)
        parts.append(self.genOperand(node.right))
      
      elif node.left and node.op and not node.right and not node.third: # unary case 2
        parts.append(self.genOperand(node.left))
        parts.append(node.op)
      
      elif node.left and node.op and node.right and not node.third: # binary
        parts.append(self.genOperand(node.left))
        parts.append(node.op)
        parts.append(self.genOperand(node.right))

      elif node.left and node.op and node.right and node.third: # ternary
        op_parts = node.op.split(" ")
        if len(op_parts) == 2: # between and
          first_op = op_parts[0]
          second_op = op_parts[1]
        elif len(op_parts) == 3: # not between and
          first_op = " ".join(op_parts[:2])
          second_op = op_parts[2]
        parts.append(self.genOperand(node.left))
        parts.append(first_op)
        parts.append(self.genOperand(node.right))
        parts.append(second_op)
        parts.append(self.genOperand(node.third))

      elif not node.op and node.value: # not expanded or literal
        parts.append(node.value)
      elif not node.op and not node.value: # if op is deleted in test reduction
        parts.append(self.genExpr(node.left))
        parts.append(self.genExpr(node.right))
      
    elif isinstance(node, Subquery):
      parts.append(self.genSubquery(node))
    elif isinstance(node, ExpressionList):
      parts.append(self.genExprList(node))
    elif isinstance(node, Column):
      parts.append(self.genColumn(node))
    elif isinstance(node, Identifier):
      parts.append(node.value)
    elif node.value: # for unexpanded nodes
      parts.append(node.value)
    if (not isinstance(node, Column) and not isinstance(node, Subquery)) and node.hasParentheses:
      parts.insert(0, "(")
      parts.append(")")
    self.genDummyNode(node, parts)
    return " ".join(parts)
  
  def genExprList(self, node: ExpressionList) -> str:
    parts = []
    expr_list = node.exprList
    if node.modifier:
      parts.append(node.modifier)
    for i, expr in enumerate(expr_list):
      if i < len(expr_list) - 1:
        parts.append(self.genExpr(expr)+",")
      else:
        parts.append(self.genExpr(expr))
    parts.insert(0, "(")
    parts.append(")")
    return " ".join(parts)
  
  def genFunction(self, node: Function) -> str:
    parts = []
    if node.name:
      parts.append(node.name)
    if node.args:
      parts.append(self.genExprList(node.args))
    # if node.hasParentheses:
    #   parts.insert(0, "(")
    #   parts.append(")")
    self.genDummyNode(node, parts)
    return "".join(parts)
  
  def genCase(self, node: Case) -> str:
    parts = []
    if node.case:
      parts.append(self.genExpr(node.case))
    for expr in node.when:
      parts.append(self.genCaseWhen(expr))
    if node.else_:
      parts.append(self.genElse(node.else_))
    self.genDummyNode(node, parts)
    parts.insert(0, "CASE")
    parts.append("END")
    # if node.hasParentheses:
    #   parts.insert(0, "(")
    #   parts.append(")")
    return " ".join(parts)
  
  def genCaseWhen(self, node: When) -> str:
    parts = []
    parts.append("WHEN")
    parts.append(self.genExpr(node.when))
    parts.append("THEN")
    parts.append(self.genExpr(node.then))
    return " ".join(parts)
  
  def genElse(self, node: Expression) -> str:
    parts = []
    parts.append("ELSE")
    parts.append(self.genExpr(node))
    return " ".join(parts)
  
  def genLiteral(self, node: Literal) -> str:
    return node.value