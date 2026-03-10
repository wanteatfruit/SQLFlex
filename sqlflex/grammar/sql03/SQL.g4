
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

// want it to be flatter, instead of many levels
selectStmt
    : selectClause fromClause? joinClauses? whereClause? groupByClause? havingClause? windowClause? orderByClause? updatabilityClause? 
        // : selectClause fromClause? joinClauses? whereClause? groupByClause? havingClause? windowClause? orderByClause? updatabilityClause? limitClause?

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
    | AS? (identifier | STRING_) columnNames? // TODO: this is only allowed in tableReference
    ;



fromClause
    : FROM tableReferences
    ;

tableReferences
    : tableReference (COMMA_ tableReference)*
    ;


tableReference
    : (subquery tableAlias | (tableName | expr) tableAlias?
    // sql-03
    | lateralClause | unnestClause | onlyClause) sampleClause?
    ;

lateralClause
    : LATERAL subquery tableAlias
    ;
unnestClause
    : UNNEST LP_ expr RP_ tableAlias (WITH ORDINALITY)?
    ;
onlyClause
    : ONLY LP_ tableReference RP_ tableAlias?
    ;

sampleClause
    : TABLESAMPLE sampleMethod LP_ expr RP_ repeatableClause?
    ;

sampleMethod
    : BERNOULLI | SYSTEM
    ;

repeatableClause
    : REPEATABLE LP_ expr RP_
    ;

joinClauses
    : joinClause (joinClause)*
    ;

joinClause
    : joinType? JOIN tableReference joinSpecification?
    ;

joinType
    : (INNER | CROSS) | (LEFT | RIGHT | FULL) OUTER? | NATURAL (INNER | (LEFT | RIGHT | FULL) (OUTER)?)? | UNION
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
    : groupingElement | expr
    ;

groupingElement
    : ROLLUP LP_ expr (COMMA_ expr)* RP_
    | CUBE LP_ expr (COMMA_ expr)* RP_
    | GROUPING SETS LP_ groupByItem (COMMA_ groupByItem)* RP_
    | LP_ RP_
    ;


orderByItem
    : expr (ASC | DESC)? (NULLS FIRST | NULLS LAST)?
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

windowClause
    : WINDOW windowDefinition (COMMA_ windowDefinition)*
    ;

windowDefinition
    : identifier AS LP_ windowSpecification RP_
    ;

windowSpecification
    : identifier? (PARTITION BY expr)? (ORDER BY expr)?
    (
        (ROWS | RANGE)
        ((UNBOUNDED PRECEDING | CURRENT ROW | expr PRECEDING) | 
        (BETWEEN (UNBOUNDED PRECEDING | CURRENT ROW | expr PRECEDING | UNBOUNDED FOLLOWING | expr FOLLOWING) AND (UNBOUNDED PRECEDING | CURRENT ROW | expr PRECEDING | UNBOUNDED FOLLOWING | expr FOLLOWING)) )
        (EXCLUDE (CURRENT ROW | GROUP | TIES | NO OTHERS))?
    )?
    // : identifier? windowPartitionClause? windowOrderClause? windowFrameClause?
    ;

windowPartitionClause
    : PARTITION BY windowPartitionExpression (COMMA_ windowPartitionExpression)*
    ;

windowPartitionExpression
    : expr collateClause?
    ;

windowOrderClause
    : ORDER BY orderByItem (COMMA_ orderByItem)*
    ;

windowFrameClause
    : (ROWS | RANGE) windowFrameExtent windowFrameExclusion?
    ;

windowFrameExtent
    : windowFrameStart | windowFrameBetween
    ;

windowFrameStart
    : UNBOUNDED PRECEDING | CURRENT ROW | expr PRECEDING
    ;

windowFrameBetween
    : BETWEEN windowFrameBound AND windowFrameBound
    ;

windowFrameBound
    : windowFrameStart | UNBOUNDED FOLLOWING | expr FOLLOWING
    ;

windowFrameExclusion
    : EXCLUDE (CURRENT ROW | GROUP | TIES | NO OTHERS)
    ;

// augment

// limitClause
//     : LIMIT expr (OFFSET expr)?
//     | OFFSET expr
//     ;