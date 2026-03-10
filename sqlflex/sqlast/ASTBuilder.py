from antlr4 import *
from overrides import override
from sqlflex.parser.SQLVisitor import SQLVisitor
from sqlflex.parser.SQLParser import SQLParser
from sqlflex.sqlast.ASTNodes import *



class ASTBuilder(SQLVisitor):
  """Build an AST from the parse tree"""
  
  def __init__(self, tree, parser=None, expand_expr=False) -> None:
    self.root = DummyRoot()
    self.dummy_root = True
    self.tree = tree
    self.antlrParser = parser
    self.expand_expr = expand_expr
    super().__init__()
    
  def build_ast(self):
    """Traverse the parse tree and build the AST, return the root node"""
    ast = self.visit(self.tree)
    if ast and self.dummy_root:
      self.root.add_child(ast)
      self.dummy_root = False
    
    # ast._build_parent()

    return ast
  
  # Override the visit method to use genericVisit as a fallback
  @override
  def visit(self, tree):

    # Attempt to find a specific visit method for the node type
    method_name = 'visit' + type(tree).__name__.replace('Context', '')
    visit_method = getattr(self, method_name, None)

    # If no specific visit method is found, use genericVisit
    if visit_method is None:
      ast_node = self.genericVisit(tree)
    else:
      ast_node = visit_method(tree)

    return ast_node

  def genericVisit(self, ctx: ParserRuleContext):
    if isinstance(ctx, TerminalNode):
      return self.visitTerminal(ctx)
   
    ast_node = self.processNode(ctx)
    
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      child_node = self.visit(child)
      if child_node:
        ast_node.add_child(child_node)
      
    return ast_node
  
  def processNode(self, ctx):
    rule_name = ctx.__class__.__name__.replace("Context", "")
    return DummyInner(rule_name)
   
  @override 
  def visitTerminal(self, node):
    text = node.getText()
    return DummyLeaf(text)   # keywords are treated as dummy nodes if not handled
  
  @override
  def visitRoot(self, ctx: SQLParser.RootContext):
    return self.visitSetOperation(ctx.getChild(0))
  
  @override
  def visitSetOperation(self, ctx: SQLParser.SetOperationContext):
    if ctx.getChildCount() == 1: # no set operation (union, intersect, except)
      root =  self.visit(ctx.getChild(0))
      return root
    else:
      setop = SetOperation()
      setop.setOp = self.visit(ctx.getChild(1))
      setop.selectStmt1 = self.visit(ctx.getChild(0))
      setop.selectStmt2 = self.visit(ctx.getChild(2))
      return setop
  
  @override
  def visitSetOperator(self, ctx: SQLParser.SetOperatorContext):
    return self.getOriginalText(ctx)
   
  @override
  def visitSelectStmt(self, ctx: SQLParser.SelectStmtContext):
    selectStmtNode = SelectStmt()
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Select):
        selectStmtNode.select = childNode
      elif isinstance(childNode, From):
        selectStmtNode.from_ = childNode
      elif isinstance(childNode, Where):
        selectStmtNode.where = childNode
      elif isinstance(childNode, t.List):
        for j in range(len(childNode)):
          if isinstance(childNode[j], Join):
            selectStmtNode.joins.append(childNode[j])
      elif isinstance(childNode, GroupBy):
        selectStmtNode.group_by = childNode
      elif isinstance(childNode, Having):
        selectStmtNode.having = childNode
      elif isinstance(childNode, OrderBy):
        selectStmtNode.order_by = childNode
      # elif isinstance(childNode, Limit):
      #   selectStmtNode.limit = childNode
      elif isinstance(childNode, Updatability):
        selectStmtNode.updatability = childNode
      elif isinstance(childNode, Window):
        selectStmtNode.window = childNode
      elif isinstance(childNode, Limit):
        selectStmtNode.limit = childNode
      elif isinstance(childNode, DummyNode):
        selectStmtNode.others.append(childNode)
    return selectStmtNode
   
  @override
  def visitSelectClause(self, ctx: SQLParser.SelectClauseContext):
    selectNode = Select()
    for i in range(1, ctx.getChildCount()): # skipping SELECT keyword
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Projections):
        selectNode.projections = childNode.projections
      elif isinstance(childNode, SelectOption):
        selectNode.selectSpecifiers += f"{childNode.option} "
    selectNode.selectSpecifiers = selectNode.selectSpecifiers.strip()
    return selectNode
  
  @override
  def visitSelectSpecification(self, ctx: SQLParser.SelectSpecificationContext) -> str:
    return SelectOption(ctx.getText())
  
  @override
  def visitProjections(self, ctx: SQLParser.ProjectionsContext):
    projectionsNode = Projections()
    prj_list = []
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Projection):
        prj_list.append(childNode)
    projectionsNode.projections = prj_list
    return projectionsNode
    
  
  @override
  def visitProjection(self, ctx: SQLParser.ProjectionContext):
    node = Projection()
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Expression):
        node.expr = childNode
      elif isinstance(childNode, Column):
        node.column = childNode
      elif isinstance(childNode, Alias):
        node.alias = childNode
      elif isinstance(childNode, Subquery):
        node.subquery = childNode.this
      elif isinstance(childNode, DummyNode):
        node.expr = childNode.value
    return node
  
  
  @override
  def visitUnqualifiedShorthand(self, ctx: SQLParser.UnqualifiedShorthandContext):
    return Column(ctx.getText())
  
  @override
  def visitQualifiedShorthand(self, ctx: SQLParser.QualifiedShorthandContext):
    return Column(ctx.getText())
  
  @override
  def visitTableAlias(self, ctx: SQLParser.TableAliasContext):
    node = Alias()
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Identifier) or (isinstance(childNode, DummyNode) and childNode.value.upper() != "AS"):
        node.alias = childNode.value
      elif isinstance(childNode, Columns):
        node.columns = childNode.columns
      elif isinstance(childNode, DummyNode) and childNode.value.upper() == "AS":
        node.as_ = True
    return node
  
  @override
  def visitProjectionAlias(self, ctx):
    node = Alias()
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Identifier) or (isinstance(childNode, DummyNode) and childNode.value.upper() != "AS"):
        node.alias = childNode.value
      elif isinstance(childNode, DummyNode) and childNode.value.upper() == "AS":
        node.as_ = True
    return node
      
  
  @override
  def visitColumnName(self, ctx: SQLParser.ColumnNameContext):
    text = ctx.getText()
    column = Column()
    if "." in text:
      parts = text.split(".")
      # sql03
      column.owner = ".".join(parts[:-1])
      column.name = parts[-1]
      return column
    else:
      return Column(text)
  
  @override
  def visitFromClause(self, ctx: SQLParser.FromClauseContext):
    node = From()
    for i in range(1, ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, TableReferences):
        node.tables = childNode.tables
    return node
  
  @override
  def visitTableReferences(self, ctx: SQLParser.TableReferencesContext):
    table_list = []
    tableRefNode = TableReferences()
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, TableReference):
        table_list.append(childNode)
    tableRefNode.tables = table_list
    return tableRefNode
  
  @override
  def visitTableReference(self, ctx: SQLParser.TableReferenceContext):
    node = TableReference()
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Table):
        node.table = childNode
      elif isinstance(childNode, Expression):
        node.expr = childNode
      elif isinstance(childNode, Alias):
        node.alias = childNode
      elif isinstance(childNode, Subquery):
        node.subquery = childNode.this
      # sql03
      elif isinstance(childNode, Sample):
        node.sample = childNode.sample
    return node
  
  #sql03
  def visitLateralClause(self, ctx):
    node = Expression()
    node.value = self.getOriginalText(ctx)
    return node
  
  #sql03
  def visitUnnestClause(self, ctx):
    node = Expression()
    node.value = self.getOriginalText(ctx)
    return node
  
  #sql03
  def visitOnlyClause(self, ctx):
    node = Expression()
    node.value = self.getOriginalText(ctx)
    return node
  
  #sql03
  def visitSampleClause(self, ctx):
    sample = Sample()
    sample.sample = self.getOriginalText(ctx)
    return sample
  
  @override
  def visitTableName(self, ctx: SQLParser.TableNameContext):
    text = ctx.getText()
    table = Table()
    if "." in text:
      parts = text.split(".")
      # sql03
      table.owner = ".".join(parts[:-1])
      table.name = parts[-1]
      return table
    else:
      return Table(text)
  
  @override
  def visitJoinClauses(self, ctx: SQLParser.JoinClausesContext):
    join_list = []
    for i in range(ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Join):
        join_list.append(childNode)
    return join_list
  
  @override
  def visitJoinClause(self, ctx: SQLParser.JoinClauseContext):
    join = Join()
    for i in range(0, ctx.getChildCount()):
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, TableReference):
        join.table = childNode
      elif isinstance(childNode, JoinType):
        join.joinType = childNode.joinType
      elif isinstance(childNode, JoinSpecification):
        if childNode.on:
          join.joinSpecification = childNode.on
        elif childNode.using:
          join.joinSpecification = childNode.using
  
    return join
  
  @override
  def visitJoinType(self, ctx: SQLParser.JoinTypeContext):
    return JoinType(self.getOriginalText(ctx))
  
  @override
  def visitJoinSpecification(self, ctx: SQLParser.JoinSpecificationContext):
    joinSpec = JoinSpecification()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, On):
        joinSpec.on = childNode
      elif isinstance(childNode, Using):
        joinSpec.using = childNode
    return joinSpec

  @override
  def visitOnClause(self, ctx: SQLParser.OnClauseContext):
    on = On()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Expression) or isinstance(childNode, Column) or isinstance(childNode, Subquery):
        on.expr = childNode
    return on
  
  @override
  def visitUsingClause(self, ctx: SQLParser.UsingClauseContext):
    using = Using()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Columns):
        using.columns = childNode.columns
    
    return using
        
  @override
  def visitColumnNames(self, ctx: SQLParser.ColumnNamesContext):
    columns = []
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Column):
        columns.append(childNode)
    return Columns(columns)

  @override
  def visitWhereClause(self, ctx: SQLParser.WhereClauseContext):
    node = Where()
    for i in range(1, ctx.getChildCount()): # skip WHERE keyword
      child = ctx.getChild(i)
      childNode = self.visit(child)
      if isinstance(childNode, Expression) or isinstance(childNode, Column) or isinstance(childNode, Subquery):
        node.expr = childNode
    return node

  @override
  def visitSubquery(self, ctx: SQLParser.SubqueryContext):
    subquery = Subquery()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, SelectStmt) or isinstance(childNode, SetOperation):
        subquery.this = childNode
    return subquery
  
  @override
  def visitGroupByClause(self, ctx: SQLParser.GroupByClauseContext):
    groupby = GroupBy()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, GroupByItem):
        groupby.groupByItems.append(childNode)
      elif isinstance(childNode, Expression) and childNode.value.upper().startswith("COLLATE"):
        groupby.collate = childNode.value
      # print("GroupByItem: ", childNode)
    return groupby

  @override
  def visitGroupByItem(self, ctx: SQLParser.GroupByItemContext):
    groupbyItem = GroupByItem()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Expression) or isinstance(childNode, Column) or isinstance(childNode, Subquery):
        groupbyItem.expr = childNode
    return groupbyItem
  
  # sql03
  def visitGroupingElement(self, ctx):
    expr = Expression()
    expr.value = self.getOriginalText(ctx)
    return expr
  
  @override
  def visitHavingClause(self, ctx: SQLParser.HavingClauseContext):
    having = Having()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Expression) or isinstance(childNode, Column) or isinstance(childNode, Subquery):
        having.expr = childNode
    return having
  
  @override
  def visitOrderByClause(self, ctx: SQLParser.OrderByClauseContext):
    orderby = OrderBy()
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, OrderByItem):
        orderby.orderByItems.append(childNode)
    return orderby
  
  @override
  def visitOrderByItem(self, ctx: SQLParser.OrderByItemContext):
    orderbyItem = OrderByItem()
    orders = []
    for i in range(ctx.getChildCount()):
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Expression) or isinstance(childNode, Column) or isinstance(childNode, Subquery):
        orderbyItem.expr = childNode
      if isinstance(childNode, DummyNode) and (childNode.value.upper() == 'ASC' or childNode.value.upper() == 'DESC' or childNode.value.upper() == 'NULLS' or childNode.value.upper() == 'FIRST' or childNode.value.upper() == 'LAST'):
        orders.append(childNode.value)
    if len(orders) > 0:
      orderbyItem.order = " ".join(orders).strip()
    return orderbyItem
  
  @override
  def visitUpdatabilityClause(self, ctx):
    node = Updatability()
    node.updatability = self.getOriginalText(ctx) # just treat the whole clause as a string
    return node
  
  # sql03
  def visitWindowClause(self, ctx):
    node = Window()
    node.windowClause = self.getOriginalText(ctx) # just treat the whole clause as a string
    return node 
  
  # augment
  def visitLimitClause(self, ctx):
    node = Limit()
    node.limitClause = self.getOriginalText(ctx) # just treat the whole clause as a string
    return node
  
  
  """
  Expression related nodes
  """

  #sql03
  def visitWindowFunction(self, ctx):
    node = Operation()
    node.op = "OVER"
    node.left = self.visit(ctx.getChild(0)) # window function
    if ctx.getChild(2).getText() == "(":
      node.right = self.visit(ctx.getChild(3)) # window name
      node.right.hasParentheses = True
    else:
      node.right = self.visit(ctx.getChild(2)) # window name or spec
    return node


  # #sql03
  def visitWindowSpecification(self, ctx):
    # count how many <MASK_n> in the text
    text = self.getOriginalText(ctx)
    mask_regex = r"(<MASK_\d+>)"
    import re
    masks = re.findall(mask_regex, text)
    if len(masks) > 0:
      # could be xxx zzz <MASK_n> yyy <MASK_m>
      # keep mask become ['xxx zzz ', '<MASK_n>, 'yyy', '<MASK_m>']
      parts = re.split(mask_regex, text)
      if len(parts) == 1 and re.match(mask_regex, parts[0]):
        node = Mask(parts[0])
      else:
        root = Operation()
        root_pointer = root
        inner = []
        leaves = []
        leave_nodes = []
        for i in range(len(parts)):
          part = parts[i].strip()
          if not re.match(mask_regex, part):
            op = Operation()
            op.op = part
            root_pointer.right = op
            root_pointer = op
            inner.append(i)
          else:
            leaves.append(i)
            leave_nodes.append(Mask(part))
        root_pointer = root.right

        
        if leaves[0] < inner[0]:
          root_pointer.left = leave_nodes[0]
          for j in range(1, len(leave_nodes)):
            if root_pointer.right:
              root_pointer = root_pointer.right
              root_pointer.left = leave_nodes[j]
            else:
              root_pointer.right = leave_nodes[j]
        if leaves[0] > inner[0]:
          for j in range(len(leave_nodes)):
            if root_pointer.right:
              root_pointer = root_pointer.right
              root_pointer.left = leave_nodes[j]
            else:
              root_pointer.right = leave_nodes[j]
        
        return root.right

    else:
      node = Expression()
      node.value = text


    return node

  @override
  def visitExprList(self, ctx: SQLParser.ExprListContext):
    expr_list = []
    expr_list_node = ExpressionList()
    for i in range(1,ctx.getChildCount()-1):
      if ctx.getChild(i).getText() == ",": continue
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Expression) or isinstance(childNode, Subquery) or isinstance(childNode, ExpressionList) or isinstance(childNode, Column):
        expr_list.append(childNode)
    expr_list_node.exprList = expr_list
    # print("ExprList: ", expr_list_node)
    return expr_list_node
  
  @override
  def visitExprListwithModifier(self, ctx):
    expr_list = []
    expr_list_node = ExpressionList()
    for i in range(1,ctx.getChildCount()-1):
      if ctx.getChild(i).getText() == ",": continue
      childNode = self.visit(ctx.getChild(i))
      if isinstance(childNode, Modifier):
        expr_list_node.modifier = childNode.value # str
      elif isinstance(childNode, Expression) or isinstance(childNode, Subquery) or isinstance(childNode, ExpressionList) or isinstance(childNode, Column):
        expr_list.append(childNode)
    expr_list_node.exprList = expr_list
    # print("ExprList: ", expr_list_node)
    return expr_list_node
  
  @override
  def visitModifier(self, ctx):
    return Modifier(self.getOriginalText(ctx))

  @override
  def visitExpr(self, ctx: SQLParser.ExprContext):
    if not self.expand_expr:
      exprNode = Expression()
      exprNode.value = self.getOriginalText(ctx)
      return exprNode
      
    exprNode = Operation()

    child_cnt = ctx.getChildCount()
    
    if child_cnt == 1:
      return self.visit(ctx.getChild(0)) # booleanPrimary
    elif child_cnt == 2: # NOT operator
      for i in range(child_cnt):
        childNode = self.visit(ctx.getChild(i))
        if isinstance(childNode, Operator):
          exprNode.op = childNode.value
        elif isinstance(childNode, Expression) or isinstance(childNode, Subquery) or isinstance(childNode, ExpressionList) or isinstance(childNode, Column):
          exprNode.right = childNode
      return exprNode
       
    elif child_cnt == 3:
      if ctx.getChild(0).getText().strip() == "(":
        exprNode = self.visit(ctx.getChild(1))
        exprNode.hasParentheses = True
        return exprNode
      for i in range(child_cnt):
        child = ctx.getChild(i)
        if i == 0:
          exprNode.left = self.visit(child)
        elif i == 1:
          exprNode.op = self.visit(child).value
        elif i == 2:
          exprNode.right = self.visit(child)
      return exprNode
        
    else:
      return exprNode
  
  # @override
  # def visitExprOperator(self, ctx: SQLParser.ExprOperatorContext):
  #   op = Operator(self.getOriginalText(ctx))
  #   return op
  @override
  def visitAndOperator(self, ctx):
    op = Operator(self.getOriginalText(ctx))
    return op

  @override
  def visitOrOperator(self, ctx):
    op = Operator(self.getOriginalText(ctx))
    return op
  
  @override
  def visitNotOperator(self, ctx: SQLParser.NotOperatorContext):
    op = Operator(self.getOriginalText(ctx))
    return op

  @override
  def visitBooleanPrimary(self, ctx: SQLParser.BooleanPrimaryContext):
    exprNode = Operation()
    childCnt = ctx.getChildCount()
    if childCnt == 1:
      return self.visit(ctx.getChild(0))
    elif childCnt == 3:
      exprNode.left = self.visit(ctx.getChild(0))
      exprNode.op = self.visit(ctx.getChild(1)).value
      exprNode.right = self.visit(ctx.getChild(2))
      return exprNode

      
  @override
  def visitIsOperator(self, ctx: SQLParser.IsOperatorContext):
    op = Operator(self.getOriginalText(ctx))
    return op
  
  @override
  def visitComparisonOperator(self, ctx: SQLParser.ComparisonOperatorContext):
    op = Operator(self.getOriginalText(ctx))
    return op
  
  @override
  def visitPredicate(self, ctx: SQLParser.PredicateContext):
    childCnt = ctx.getChildCount()
    if childCnt == 1:
      return self.visit(ctx.getChild(0))
    else:
      expr = Expression()
      expr.value = self.getOriginalText(ctx)
      return expr
    
  
  @override
  def visitInPredicate(self, ctx):
    childCnt = ctx.getChildCount()
    expr = Operation()
    if childCnt == 4:
      expr.op = "NOT IN"
      expr.left = self.visit(ctx.getChild(0))
      expr.right = self.visit(ctx.getChild(3))
    else:
      expr.op = "IN"
      expr.left = self.visit(ctx.getChild(0))
      expr.right = self.visit(ctx.getChild(2))
    return expr
  
  @override
  def visitBetweenPredicate(self, ctx: SQLParser.BetweenPredicateContext):
    childCnt = ctx.getChildCount()
    expr = Operation()
    if childCnt == 6:
      expr.op = "NOT BETWEEN AND"
      expr.left = self.visit(ctx.getChild(0))
      expr.right = self.visit(ctx.getChild(3))
      expr.third = self.visit(ctx.getChild(5))
    else:
      expr.op = "BETWEEN AND"
      expr.left = self.visit(ctx.getChild(0))
      expr.right = self.visit(ctx.getChild(2))
      expr.third = self.visit(ctx.getChild(4))
    return expr

  @override
  def visitLikePredicate(self, ctx):
    childCnt = ctx.getChildCount()
    expr = Operation()
    expr.left = self.visit(ctx.getChild(0))
    if childCnt == 3: # LIKE
      expr.op = "LIKE"
      expr.right = self.visit(ctx.getChild(2))
    elif childCnt == 4: # NOT LIKE
      expr.op = "NOT LIKE"
      expr.right = self.visit(ctx.getChild(3))
    elif childCnt == 5:
      expr.op = "LIKE ESCAPE"
      expr.right = self.visit(ctx.getChild(2))
      expr.third = self.visit(ctx.getChild(4))
    elif childCnt == 6:
      expr.op = "NOT LIKE ESCAPE"
      expr.right = self.visit(ctx.getChild(3))
      expr.third = self.visit(ctx.getChild(5))
    return expr
  
  # sql03
  def visitDistinctPredicate(self, ctx):
    expr = Operation()
    if ctx.getChildCount() == 6:
      expr.op = "IS NOT DISTINCT FROM"
      expr.right = self.visit(ctx.getChild(5))
    else:
      expr.op = "IS DISTINCT FROM"
      expr.right = self.visit(ctx.getChild(4))
    expr.left = self.visit(ctx.getChild(0))
    return expr
  
  # sql03
  def visitOverlapsPredicate(self, ctx):
    expr = Operation()
    expr.op = "OVERLAPS"
    expr.left = self.visit(ctx.getChild(0))
    expr.right = self.visit(ctx.getChild(2))
    return expr
  
  # sql03
  def visitTypePredicate(self, ctx):
    expr = Operation()
    expr.value = self.getOriginalText(ctx)
    return expr
  
  # sql03
  def visitSetPredicate(self, ctx):
    expr = Operation()
    if ctx.getChildCount() == 4:
      expr.op = "IS NOT A SET"
    else:
      expr.op  = "IS A SET"
    expr.left = self.visit(ctx.getChild(0))
    return expr
  
  # sql03
  def visitMemberPredicate(self, ctx):
    expr = Operation()
    expr.value = self.getOriginalText(ctx)
    return expr
  
  # sql03
  def visitSubmultisetPredicate(self, ctx):
    expr = Operation()
    if ctx.getChildCount() == 5:
      expr.op = "NOT SUBMULTISET OF"
      expr.right = self.visit(ctx.getChild(4))
    else:
      expr.op = "SUBMULTISET OF"
      expr.right = self.visit(ctx.getChild(3))
    expr.left = self.visit(ctx.getChild(0))
    return expr
  # sql03
  def visitNormalizedPredicate(self, ctx):
    expr = Operation()
    if ctx.getChildCount() == 4:
      expr.op = "IS NOT NORMALIZED"
    else:
      expr.op = "IS NORMALIZED"
    expr.left = self.visit(ctx.getChild(0))
    return expr
  
  @override
  def visitBitExpr(self, ctx: SQLParser.BitExprContext):
    childCnt = ctx.getChildCount()
    if childCnt == 1:
      return self.visit(ctx.getChild(0))
    else:
      expr = Operation()
      expr.op = self.visit(ctx.getChild(1)).value
      expr.left = self.visit(ctx.getChild(0))
      expr.right = self.visit(ctx.getChild(2))
      return expr
  
  # @override
  # def visitBitOperator(self, ctx: SQLParser.BitOperatorContext):
  #   op = Operator(self.getOriginalText(ctx))
  #   return op
  
  @override
  def visitConcatBitOperator(self, ctx):
    return Operator(self.getOriginalText(ctx))

  @override
  def visitPlusBitOperator(self, ctx):
    return Operator(self.getOriginalText(ctx))
  
  @override
  def visitMultiplyBitOperator(self, ctx):
    return Operator(self.getOriginalText(ctx))
  
  @override
  def visitLogicalBitOperator(self, ctx):
    return Operator(self.getOriginalText(ctx))
  
  @override
  def visitSimpleExpr(self, ctx: SQLParser.SimpleExprContext):
    childCnt = ctx.getChildCount()
    expr = Expression()
    expr.value = self.getOriginalText(ctx)
    if childCnt == 1:
      childNode = self.visit(ctx.getChild(0))
      if isinstance(childNode, Expression) or isinstance(childNode, Column) or isinstance(childNode, Subquery) or isinstance(childNode, ExpressionList):
        return childNode
      
    elif childCnt == 3 and ctx.getChild(0).getText().strip() == "(":
      childNode = self.visit(ctx.getChild(1))
      if isinstance(childNode, Expression):
        childNode.hasParentheses = True
        return childNode
    
    elif childCnt == 2 and (ctx.getChild(0).getText().strip() == "+" or ctx.getChild(0).getText().strip() == "-"):
      childNode = Operation()
      childNode.op = ctx.getChild(0).getText().strip()
      childNode.right = self.visit(ctx.getChild(1))
      return childNode

    return expr
  
  @override
  def visitExistExpr(self, ctx):
    expr = Operation()
    expr.op = "EXISTS"
    expr.right = self.visit(ctx.getChild(1))
    return expr
  
  @override
  def visitFunctionCall(self, ctx: SQLParser.FunctionCallContext):
    return self.visit(ctx.getChild(0))
  
  @override
  def visitAggregationFunction(self, ctx):
    func = Function()
    func.name = self.visit(ctx.getChild(0)).value
    args = self.visit(ctx.getChild(1))
    if isinstance(args, DummyNode):
      func.args = args.value
    elif isinstance(args,ExpressionList) or isinstance(args, Mask):
      func.args = args
    return func
  
  @override
  def visitCastFunction(self, ctx):
    func = Function()
    func.name = "CAST"
    args = ExpressionList()
    cast_op = self.visit(ctx.getChild(2))
    args.exprList = [cast_op]
    func.args = args
    return func
  
  @override
  def visitCastExpression(self, ctx):
    expr = Operation()
    expr.op = "AS"
    expr.left = self.visit(ctx.getChild(0))
    expr.right = self.visit(ctx.getChild(2))
    return expr
  
  @override
  def visitExtractFunction(self, ctx):
    func = Function()
    func.name = "EXTRACT"
    args = ExpressionList()
    extract_op = self.visit(ctx.getChild(2))
    args.exprList = [extract_op]
    func.args = args
    return func

  @override
  def visitExtractExpression(self, ctx):
    expr = Operation()
    expr.op = "FROM"
    expr.left = self.visit(ctx.getChild(0))
    expr.right = self.visit(ctx.getChild(2))
    return expr
  
  @override
  def visitDataType(self, ctx):
    expr = Expression() # use generic expression
    expr.value = self.getOriginalText(ctx)
    return expr
  
  # augment
  def visitDataTypeName(self, ctx):
    return self.visit(ctx.getChild(0))
  
  def visitPreDefinedType(self, ctx):
    node = Expression()
    node.value = self.getOriginalText(ctx)
    return node
  
  @override
  def visitRegularFunction(self, ctx):
    func = Function()
    func.name = self.visit(ctx.getChild(0)).value
    func.args = self.visit(ctx.getChild(1))
    return func
  
  # sql03
  @override
  def visitRegularFunctionName(self, ctx):
    expr = Expression()
    expr.value = self.getOriginalText(ctx)
    return expr
  
  @override
  def visitCaseExpression(self, ctx):
    case_node = Case()
    first_expr = self.visit(ctx.getChild(1))
    if isinstance(first_expr, When):
      case_node.when.append(first_expr)
    else:
      case_node.case = first_expr
    for i in range(2, ctx.getChildCount() - 1):
      child = self.visit(ctx.getChild(i))
      if isinstance(child, When):
        case_node.when.append(child)
      else:
        case_node.else_ = child
    
    return case_node
      
      
  @override
  def visitCaseWhen(self, ctx):
    case_when = When()
    case_when.when = self.visit(ctx.getChild(1))
    case_when.then = self.visit(ctx.getChild(3))
    # case_when.op = "WHEN"
    # case_when.left = self.visit(ctx.getChild(1))
    # case_when.right = self.visit(ctx.getChild(3))
    return case_when
  
  @override
  def visitCaseElse(self, ctx):
    # case_else = Expression()
    # case_else.op = "ELSE"
    # case_else.left = self.visit(ctx.getChild(1))
    return self.visit(ctx.getChild(1))

  @override
  def visitIntervalExpression(self, ctx):
    interval = Operation()
    interval.op = "INTERVAL"
    time_unit = Operation()
    if ctx.getChildCount() == 3:
      time_unit.op = self.getOriginalText(ctx.getChild(2))
    elif ctx.getChildCount() == 5:
      time_unit.op = self.getOriginalText(ctx.getChild(2)) + " TO " + self.getOriginalText(ctx.getChild(4))
    time_unit.left = self.visit(ctx.getChild(1))
    interval.right = time_unit
    return interval
  
  @override
  def visitMatchExpression(self, ctx):
    expr = Operation()
    expr.left = self.visit(ctx.getChild(0))
    if ctx.getChildCount() == 4:
      expr.op = "MATCH" + " " + self.visit(ctx.getChild(2)).value
      expr.right = self.visit(ctx.getChild(3))
    if ctx.getChildCount() == 5:
      expr.op = "MATCH UNIQUE" + " " + self.getOriginalText(ctx.getChild(3))
      expr.right = self.visit(ctx.getChild(4))
    return expr
  
  @override
  def visitUniqueExpr(self, ctx):
    expr = Operation()
    expr.op = "UNIQUE"
    expr.right = self.visit(ctx.getChild(1))
    return expr
  
  @override
  def visitCollateClause(self, ctx):
    expr = Expression()
    expr.value = self.getOriginalText(ctx)
    return expr
    
  """
  Identifier and Literal nodes
  """
  
  @override
  def visitMask_token(self, ctx):
    return Mask(ctx.getText())
  
  @override
  def visitParen_token(self, ctx):
    return Mask(ctx.getText())

  @override
  def visitIdentifier(self, ctx: SQLParser.IdentifierContext):
    return Identifier(ctx.getText())

  @override
  def visitVariable(self, ctx):
    return Identifier(self.getOriginalText(ctx))

  @override
  def visitLiterals(self, ctx: SQLParser.LiteralsContext):
    return self.visit(ctx.getChild(0))
    # return Literal(ctx.getText())
  
  @override
  def visitAsteriskLiteral(self, ctx):
    return AsteriskLiteral(self.getOriginalText(ctx))
  
  @override
  def visitStringLiterals(self, ctx):
    return StringLiteral(self.getOriginalText(ctx))
  
  @override
  def visitNumberLiterals(self, ctx):
    return NumberLiteral(self.getOriginalText(ctx))
  
  @override
  def visitBooleanLiterals(self, ctx):
    return BooleanLiteral(self.getOriginalText(ctx))
  
  @override
  def visitNullValueLiterals(self, ctx):
    return NullLiteral(self.getOriginalText(ctx))
  
  @override
  def visitDateTimeLiterals(self, ctx):
    return DateTimeLiteral(self.getOriginalText(ctx))
  
  @override
  def visitHexadecimalLiterals(self, ctx):
    return HexLiteral(self.getOriginalText(ctx))
  
  @override
  def visitBitValueLiterals(self, ctx):
    return BitLiteral(self.getOriginalText(ctx))
  
  @override
  def defaultResult(self) -> None:
    return self.root
  
  def getOriginalText(self, ctx):
    if self.antlrParser:
      tokenStream = self.antlrParser.getTokenStream()
      startToken = ctx.start
      stopToken = ctx.stop
      return tokenStream.getText(startToken, stopToken)
    else:
      return ctx.getText()

  def getAST(self):
    return self.root
  
      
