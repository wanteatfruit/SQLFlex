import sqlflex.sqlast.ASTNodes as at
import sqlflex.llm.ASTNodeLLM as lm

# grammar rule to AST node mapping
rule2ast = {
  'setOperation': at.SetOperation,
  'selectStmt': at.SelectStmt,
  'selectClause': at.Select,
  'projection': at.Projection,
  'projectionAlias': at.Alias,
  'columnName': at.Column,
  'fromClause': at.From,
  'tableAlias': at.Alias,
  'tableReference': at.TableReference,
  'tableName': at.Table,
  'joinClause': at.Join,
  'joinSpecification': at.JoinSpecification,
  'onClause': at.On,
  'usingClause': at.Using,
  'whereClause': at.Where,
  'groupByClause': at.GroupBy,
  'groupByItem': at.GroupByItem,
  'havingClause': at.Having,
  'orderByClause': at.OrderBy,
  'orderByItem': at.OrderByItem,
  'expr': at.Expression,
}

# grammar rule to LLM node mapping
rule2lm = {
  'setOperation': lm.SetOperation,
  'selectStmt': lm.SelectStmt,
  'selectClause': lm.Select,
  'projection': lm.Projection,
  'projectionAlias': lm.Alias,
  'columnName': lm.Column,
  'fromClause': lm.From,
  'tableReference': lm.TableReference,
  'tableName': lm.Table,
  'tableAlias': lm.Alias,
  'joinClauses': lm.JoinClauses,
  'joinClause': lm.Join,
  'joinSpecification': lm.JoinSpecification,
  'onClause': lm.On,
  'usingClause': lm.Using,
  'whereClause': lm.Where,
  'groupByClause': lm.GroupBy,
  'groupByItem': lm.GroupByItem,
  'havingClause': lm.Having,
  'orderByClause': lm.OrderBy,
  'orderByItem': lm.OrderByItem,
  'expr': lm.Expression,
}

# maps LLM node attribute name to the next parse rule
llmAttr2rule = {
  lm.SetOperation:{
    'selectStmt1': 'selectStmt',
    'selectStmt2': 'selectStmt',
    'setOp': '$',
  },
  lm.SelectStmt: {
    'select': 'selectClause',
    'from_': 'fromClause',
    'where': 'whereClause',
    'joins': '&joinClause',
    'group_by': 'groupByClause',
    'having': 'havingClause',
    'order_by': 'orderByClause',
  },
  lm.Select: {
    'selectSpecifiers': '$',
    'projections': '&projection',
  },
  lm.Projection: {
    'expr': 'expr',
    'column': 'columnName',
    'alias': 'projectionAlias',
  },
  lm.Column: {
    'name': '$',
    'owner': '$',
  },
  lm.From: {
    'tableReferences': '&tableReference',
  },
  lm.TableReference: {
    'expr': 'expr',
    'table_name': 'tableName',
    'alias': 'tableAlias',
  },
  lm.Table: {
    'name': '$',
    'owner': '$',
  },
  lm.Alias: {
    'alias': '$',
    'as_': '$',
  },
  lm.JoinClauses: {
    'joinClauses': '&joinClause',
  },
  lm.Join: {
    'tableReference': 'tableReference',
    'joinType': '$',
    'joinSpec': 'joinSpecification',
  },
  lm.JoinSpecification: {
    'on': 'onClause',
    'using': 'usingClause',
  },
  lm.On: {
    'expr': 'expr',
  },
  lm.Using: {
    'columns': '&columnName',
  },
  lm.Where: {
    'expr': 'expr',
  },
  lm.GroupBy: {
    'groupByItems': '&groupByItem',  
  },
  lm.GroupByItem: {
    'expr': 'expr',
  },
  lm.Having: {
    'expr': 'expr',
  },
  lm.OrderBy: {
    'orderByItems': '&orderByItem',
  },
  lm.OrderByItem: {
    'expr': 'expr',
    'order': '$',
  },
  lm.Expression: {
    'value': '$',
  }
}

keywords = (
  'SELECT',
  'FROM',
  'WHERE',
  'JOIN',
  'ON',
  'USING',
  'GROUP BY',
  'HAVING',
  'ORDER BY',
)