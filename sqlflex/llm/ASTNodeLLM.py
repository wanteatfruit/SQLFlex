from __future__ import annotations # for forward references, must be at the top of the file
from pydantic import BaseModel, Field
from typing import List, Optional

# should be unused
class SetOperation(BaseModel):
  """TOP-level set operation in a SQL query, must not include the subquery. If setOp is not present, then selectStmt2 should not be present and selectStmt1 should be the entire query"""
  setOp: Optional[str] = Field(description="The top-level set operation.")
  selectStmt1: str = Field(description="The set operator's left SELECT statement")
  selectStmt2: Optional[str] = Field(description="The set operator's right SELECT statement")

class SelectStmt(BaseModel):
  """
  Represents a SQL SELECT statement.
  """
  select: str = Field(description="The SELECT clause, including the **SELECT** keyword and its associated projections.")
  from_: Optional[str] = Field(description="The FROM clause, including the **FROM** keyword, specifying the source table(s).")
  joins: Optional[List[str]] = Field(description="The JOIN clauses, which is the tables joined with the outermost FROM clause, and it's not part of the FROM clause. Each should include the **JOIN** keyword and its associated conditions.")
  where: Optional[str] = Field(description="The WHERE clause, including the **WHERE** keyword, defining filtering conditions.")
  group_by: Optional[str] = Field(description="The GROUP BY clause, including the **GROUP BY** keyword, specifying grouping criteria.")
  having: Optional[str] = Field(description="The HAVING clause, including the **HAVING** keyword, defining filtering conditions for grouped data.")
  order_by: Optional[str] = Field(description="The ORDER BY clause, including the **ORDER BY** keyword, specifying sorting criteria.")
  other: Optional[str] = Field(description="Any additional content that are database-specific features.")

class Select(BaseModel):
  """A SELECT clause in a SQL query"""
  keyword: str = Field(description="The SELECT keyword. Always expected to be 'SELECT' as per SQL syntax.")
  selectSpecifiers: Optional[str] = Field(description="Additional specifiers or options for the SELECT clause, such as DISTINCT. This should appear before the list of projections and after the SELECT keyword.")
  projections: str = Field(description="The list of selected columns or expressions. If there are multiple items, they should be separated by commas.")
  other: Optional[str] = Field(description="Any additional content that are database-specific features.")
  
class Projection(BaseModel):
  """A projection in a SELECT clause. It is either a column or an expression, but not both. If unsure, use the 'expr' field."""
  
  column: Optional[str] = Field(description="The name or identifier of a column from a table or view, including *") # can't assume that if it's a column name, the rule-based parser will be able to parse it
  expr: Optional[str] = Field(description="A SQL expression (including type casting), subqueries should also be included here.")
  alias: Optional[str] = Field(description="The alias name for the projection. This includes the 'AS' keyword if present in the input.")
  other: Optional[str] = Field(
      description="Any additional content that are database-specific features."
  )

class Column(BaseModel):
  """A column name. If the column is in the form of table.column, put table in the owner field, and column in the name field, and the dot in the other field"""
  name: str = Field(description="The column name, including any enclosing delimeters if present.")
  owner: Optional[str] = Field(description="The column owner, including any enclosing delimeters if present.")
  other: Optional[str] = Field(description="The dot (.) in the table reference.")
  
class From(BaseModel):
    """Represents a FROM clause in an SQL query."""
    
    keyword: str = Field(
        description="The FROM keyword, which specifies the clause where the source tables or subqueries for the query are defined."
    )
    
    tableReferences: str = Field(
        description="The list of table references in the FROM clause, separated by commas if multiple references are present. "
                    # "Each table reference may include table names, subqueries, or expressions (e.g., `table1, table2`, "
                    # "`(SELECT ...) AS alias`, or `generate_series(1, 10)`."
    )
    
    other: Optional[str] = Field(
        description="Any additional content that are database-specific features."
    )
    
class TableReference(BaseModel):
    """
    Represents a table reference in the FROM clause of an SQL query. It should be one of a subquery, a table name, or an expression, but not a combination of these. If unsure, use the 'expr' field.
    """

    subquery: Optional[str] = Field(
        description=(
            "The inline subquery component of the table reference. Use this field only when the entire "
            "parenthesized expression begins with a SELECT statement. Include the expression with its "
            "enclosing parentheses. For example, '(SELECT * FROM employees)' qualifies as a subquery. "        
            )
    )
    
    table_name: Optional[str] = Field(
        description=(
            "The name or identifier of a table, This field should be used when the table reference is strictly in the form of table_name or schema_name.table_name."
        )
    )

    expr: Optional[str] = Field(
        description=(
            "A SQL expression that is not a SELECT subquery."
        )
    )

    alias: Optional[str] = Field(
        description=(
            "The alias assigned to the table reference. This includes the 'AS' keyword if present in the input. "
        )
    )
    
    other: Optional[str] = Field(
        description="Any additional content that are database-specific features."
    )

class Table(BaseModel):
  """A table name. If the table is in the form of schema.table, put schema in the owner field, and table in the name field, and the dot in the other field"""
  name: str = Field(description="The table name, including any enclosing delimeters if present.")
  owner: Optional[str] = Field(description="The owner of the table, including any enclosing delimeters if present")
  other: Optional[str] = Field(description="The dot (.) in the table reference.")

class Alias(BaseModel):
  """An alias in a SQL query"""
  alias: str = Field(description="The alias expression")
  as_: Optional[str] = Field(description="The AS keyword, if it exists")
  # other: Optional[str] = Field(description="All other content in the alias")
  
# special case
class JoinClauses(BaseModel):
  """consecutive JOIN clauses"""
  joinClauses: List[str] = Field(description="The JOIN clauses")

class Join(BaseModel):
  """A JOIN clause"""
  joinType: Optional[str] = Field(
      description=(
          "The type of join, if specified. It should appear before the 'JOIN' keyword. Do not include the 'JOIN' keyword."
      )
  )
  # keyword: str = Field(description="The 'JOIN' keyword. If an explicit join type is present, this field should still only contain 'JOIN', while the type is assigned to joinType.")
  tableReference: str = Field(description="The table reference to be joined.")
  joinSpec: Optional[str] = Field(
      description=(
          "The join condition or specification, including the associated keyword. "
          "Examples include ON conditions (e.g., ON table1.id = table2.id) or USING clauses."
      )
  )
  other: Optional[str] = Field(description="Any additional content that are database-specific features.")
  
class JoinSpecification(BaseModel):
  """A join specification in a JOIN clause"""
  on: Optional[str] = Field(description="The ON clause")
  using: Optional[str] = Field(description="The USING clause")
  # other: Optional[str] = Field(description="All other clauses in the join specification")

class On(BaseModel):
  """An ON clause in a JOIN clause"""
  # keyword: str = Field(description="The ON keyword")
  expr: str = Field(description="The expression in the ON clause")
  # other: Optional[str] = Field(description="All other content in the ON clause")

class Using(BaseModel):
  """A USING clause in a JOIN clause"""
  # keyword: str = Field(description="The USING keyword")
  columns: str = Field(description="The columns in the USING clause")
  other: Optional[str] = Field(description="Any additional content that are database-specific features.")
  
class Where(BaseModel):
  """A WHERE clause"""
  keyword: str = Field(description="The WHERE keyword")
  expr: str = Field(description="The expression in the WHERE clause")
  # other: Optional[str] = Field(description="All other content in the WHERE clause")
  
class GroupBy(BaseModel):
  """A GROUP BY clause"""
  keyword: str = Field(description="The GROUP BY keyword")
  groupByItems: str = Field(description="The items in the GROUP BY clause, separated by commas")
  other: Optional[str] = Field(description="All other content in the GROUP BY clause")
  
class GroupByItem(BaseModel):
  """An item in a GROUP BY clause"""
  expr: str = Field(description="The expression in the group by item")
  other: Optional[str] = Field(description="All other content in the GROUP BY item")

class Having(BaseModel):
  """A HAVING clause"""
  keyword: str = Field(description="The HAVING keyword")
  expr: str = Field(description="The expression in the HAVING clause")
  # other: Optional[str] = Field(description="All other content in the HAVING clause")

class OrderBy(BaseModel):
  """An ORDER BY clause"""
  keyword: str = Field(description="The ORDER BY keyword")
  orderByItems: str = Field(description=" A comma-separated list of column names, expressions that define the sorting order.")
  other: Optional[str] = Field(description="All other dialect-specific content in the ORDER BY clause")

class OrderByItem(BaseModel):
  """An item in an ORDER BY clause"""
  expr: str = Field(description="The expression in the ORDER BY item")
  order: Optional[str] = Field(description="The specific order of ORDER BY item")
  other: Optional[str] = Field(description="All other content in the ORDER BY item")
  
# temp
class Expression(BaseModel):
    """Represents an expression in a SQL query."""
    
    value: str = Field(
        description="The full expression as provided in the input. "
                    "Repeat the input exactly as is, without attempting to segment or modify it in any way."
    )

class ExpressionExpand(BaseModel):
  """
  # Represents an expression in a SQL query

  - An expression can either be a **literal** or an **operation** involving an operator and its operands. These two cases are **mutually exclusive**.
  
  - A literal is a single value or a keyword-based phrasal expression. If an expression contains <PAREN> token, it is not a literal. The literal should not contain other sub-expressions or operations.
  
  - An operation is any expression that contains one or more explicit SQL operator or operator keywords. If more than one operator is present, the operator with the lowest precedence should be selected. If there are multiple different operators with the same precedence, the leftmost operator should be selected. If there are multiple same operators, select the operator based on the associativity of the operator.
  The left and right operand are defined based on the relative position to the operator. The operands must include all following clauses associated with the operator.
  For example, in "OP1 a OP2 b", different operators OP1 and OP2 have the same precedence, choose "OP1" as the operator, and "a OP2 b" together as the right operand.
  
  # Additional Notes
  
  - The token <PAREN_%d> represents parenthesized expression, where %d is the index of the parentheses (e.g, <PAREN_0> ). When segmenting the expression, the <PAREN_%d> tokens are treated as a whole and preserved, do not treat the < and > in the <PAREN_%d> token as operators.
  The <PAREN> means there exists a sub expression, so it must be a part of the operand for an operation. For example, in "OP1 a OP2 <PAREN_0>", the operator is OP1, there's no left operand (based on the relative position), the right operand is "a OP2 <PAREN_0>".
  - The token ##SQ_%d## and ##DQ_%d## represents quoted strings, where %d is the index of the string (e.g, ##SQ_0## ). When segmenting the expression, the ##SQ_%d## and ##DQ_%d## tokens are treated as a whole and preserved, and they must be a part of the operand for an operation (they are not a literal).
  - Pay special attention to enclosing delimeters, especially quotes, brackets, backticks. They must not be missing or misplaced.
  
  """
  literal: Optional[str] = Field(
      description="If this expression is a literal value (e.g., an identifier, a column or table name, an array, a JSON value, or another special data type), or an declarative phrasal expression that has no explicit operator (e.g., an INTERVAL expression), populate this field. If the expression contains an explicit operation, **leave this field empty**. Additionally, we always consider bracketed expressions to be literals, if the expression is surrounded by brackets (e.g., [] or {}), include the brackets. **Implicit** type casting (e.g., i BIGINT) should be considered a literal."
  )
  operator: Optional[str] = Field(
      description="The SQL operator that has lowest precedence. This includes action-defining keywords, as well as unary, and binary operators. If an operator is provided, the `literal` field **must be empty**. **Explicit** type casting operators (e.g., i :: BIGINT, i AS BIGINT) should be considered an operator."
  )
  left: Optional[str] = Field(
      description="The left operand for the operator in the expression, whose position must be to the left of the operator. If the operator has no left operand, leave this field empty. This includes all dependent clauses associated with the operator. If the `literal` field is populated, this field **must be empty**."
  )
  right: Optional[str] = Field(
      description="The right operand for the operator in the expression, whose position must be to the right of the operator If the operator has no right operand, leave this field empty. This includes all dependent clauses associated with the operator. If the `literal` field is populated, this field **must be empty**."
  )

# ablation study SQLFlex_a
class ExpressionEntire(BaseModel):
  """
  # Represents an expression in a SQL query

  - An expression can be a **literal**, **operation**, **subquery**, or **function call**. These four cases are **mutually exclusive**.
  
  - A literal is a single value or a keyword-based phrasal expression. The literal should not contain other sub-expressions or operations.
  
  - An operation is any expression that contains one or more explicit SQL operator or operator keywords. If more than one operator is present, the operator with the lowest precedence should be selected. If there are multiple different operators with the same precedence, the leftmost operator should be selected. If there are multiple same operators, select the operator based on the associativity of the operator.
  The left and right operand are defined based on the relative position to the operator. The operands must include all following clauses associated with the operator.
  For example, in "OP1 a OP2 b", operator OP1 and OP2 have the same precedence, choose "OP1" as the operator, and "a OP2 b" together as the right operand.
  
  - A subquery is an expression that is a complete SQL query enclosed in parentheses. It should not contain any operators or other expressions outside the parentheses.
  
  - A function call is an expression that represents a function invocation, including the function name and its arguments. The function call should not contain any operators or other expressions outside the function call.
  
  # Additional Notes
  
  - The token ##SQ_%d## and ##DQ_%d## represents quoted strings, where %d is the index of the string (e.g, ##SQ_0## ). When segmenting the expression, the ##SQ_%d## and ##DQ_%d## tokens are treated as a whole and preserved, and they must be a part of the operand for an operation (they are not a literal).
  - Pay special attention to enclosing delimeters, especially parentheses, quotes, brackets, backticks. They must not be missing or misplaced.
  
  """
  literal: Optional[str] = Field(
      description="If this expression is a literal value (e.g., an identifier, a column or table name, an array, a JSON value, or another special data type), or an declarative phrasal expression that has no explicit operator (e.g., an INTERVAL expression), populate this field. If the expression contains an explicit operation, **leave this field empty**. Additionally, we always consider bracketed expressions to be literals, if the expression is surrounded by brackets (e.g., [] or {}), include the brackets. **Implicit** type casting (e.g., i BIGINT) should be considered a literal."
  )
  operator: Optional[str] = Field(
      description="The SQL operator that has lowest precedence. This includes action-defining keywords, as well as unary, and binary operators. If an operator is provided, the `literal` field **must be empty**. **Explicit** type casting operators (e.g., i :: BIGINT, i AS BIGINT) should be considered an operator."
  )
  left: Optional[str] = Field(
      description="The left operand for the operator in the expression, whose position must be to the left of the operator. If the operator has no left operand, leave this field empty. This includes all dependent clauses associated with the operator. If the `literal` field is populated, this field **must be empty**."
  )
  right: Optional[str] = Field(
      description="The right operand for the operator in the expression, whose position must be to the right of the operator If the operator has no right operand, leave this field empty. This includes all dependent clauses associated with the operator. If the `literal` field is populated, this field **must be empty**."
  )
  subquery: Optional[str] = Field(
      description="The expression is a subquery"
  )
  function: Optional[str] = Field(
      description="The expression is a function call, including the function name and its arguments."
  )
