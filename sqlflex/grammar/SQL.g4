grammar SQL;

import BaseRule;

root
    : setOperation (EOF | SEMI_)
    ;

setOperation
    : setOperation setOperator selectStmt
    | selectStmt
    ;

setOperator
    : UNION (ALL | DISTINCT)?
    | INTERSECT (ALL | DISTINCT)?
    | EXCEPT (ALL | DISTINCT)?
    ;

selectStmt
    : selectClause fromClause? joinClauses? whereClause? groupByClause? havingClause? orderByClause? updatabilityClause?
    ;

selectClause
    : SELECT selectSpecification* projections
    ;

selectSpecification
    : ALL | DISTINCT
    ;


projections
    : projection (COMMA_ projection)*
    ;

projection
    :  subquery projectionAlias
    | (columnName | expr) projectionAlias? 
    ;

projectionAlias
    : AS? (identifier | STRING_)
    ;

tableAlias
    : AS? (identifier | STRING_)
    | AS? (identifier | STRING_) columnNames? // TODO: this is not allowed in projection, is only allowed in tableReference
    ;



fromClause
    : FROM tableReferences
    ;

tableReferences
    : tableReference (COMMA_ tableReference)*
    ;


tableReference
    : subquery tableAlias | (tableName | expr) tableAlias?
    ;

joinClauses
    : joinClause (joinClause)*
    ;

joinClause
    : joinType? JOIN tableReference joinSpecification?
    ;

joinType
    : (INNER | CROSS) | (LEFT | RIGHT | FULL) OUTER? | NATURAL (INNER | (LEFT | RIGHT | FULL) (OUTER)?)?
    ;

joinSpecification
    : onClause | usingClause
    ;

onClause
    : ON expr
    ;

usingClause
    : USING columnNames
    ;

whereClause
    : WHERE expr
    ;

groupByClause
    : GROUP BY groupByItem (COMMA_ groupByItem)* collateClause?
    ;

orderByClause
    : ORDER BY orderByItem (COMMA_ orderByItem)*
    ;

groupByItem
    : expr
    ;

orderByItem
    : expr (ASC | DESC)?
    ;


havingClause
    : HAVING expr
    ;

subquery
    : LP_ setOperation RP_
    ;

updatabilityClause
    : FOR READ ONLY
    | FOR UPDATE
    | FOR OF LP_? columnName (COMMA_ columnName)* RP_?
    ;