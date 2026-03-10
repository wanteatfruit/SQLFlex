
grammar BaseRule;

import Symbol, Keyword, Literals;

parameterMarker
    : QUESTION_
    ;

literals
    : stringLiterals
    | numberLiterals
    | dateTimeLiterals
    | hexadecimalLiterals
    | bitValueLiterals
    | booleanLiterals
    | nullValueLiterals
    | asteriskLiteral
    | arrayLiterals
    ;

asteriskLiteral
    : ASTERISK_
    ;

stringLiterals
    : characterSetName? STRING_ collateClause?
    | SQ_TOKEN
    ;

numberLiterals
    : (PLUS_ | MINUS_)? NUMBER_
    ;

dateTimeLiterals
    : (DATE | TIME | TIMESTAMP) STRING_
    | CURRENT_DATE
    ;

hexadecimalLiterals
    : characterSetName? HEX_DIGIT_ collateClause?
    ;

bitValueLiterals
    : characterSetName? BIT_NUM_ collateClause?
    ;

booleanLiterals
    : TRUE | FALSE | UNKNOWN
    ;

arrayLiterals
    : ARRAY LBT_ (expr (COMMA_ expr)*)? RBT_
    ;

nullValueLiterals
    : NULL
    ;

identifier
    : IDENTIFIER_ 
    | unreservedWord
    ;

unreservedWord
    : AVG
    | BERNOULLI
    | COALESCE | CONVERT | COUNT
    | EXTRACT
    | FIRST | FOLLOWING
    | LAST
    | MAX | MIN
    | NORMALIZED | NULLIF | NULLS
    | OTHERS | ORDINALITY | OBJECT
    | READ | REPEATABLE | ROW_NUMBER
    | SIMPLE | SUBSTRING | SUM | SYSTEM
    | TABLESAMPLE | TIES | TRIM
    | UNBOUNDED 
    | ZONE
    ;

reservedWord
    : ALL | AND | ANY | ARRAY | AS | ASC | ASET
    | BETWEEN | BOTH | BY | BINARY | BLOB | BIGINT | BOOLEAN
    | CASE | CAST | CHAR | CHARACTER | COLLATE | CROSS | CUBE | CURRENT | CURRENT_DATE | CLOB
    | DATE | DAY | DEC | DECIMAL | DESC | DISTINCT | DOUBLE
    | ELSE | END | ESCAPE | EXCEPT | EXCLUDE | EXISTS
    | FALSE | FLOAT |  FOR | FROM | FULL
    | GLOBAL | GROUP | GROUPING
    | HAVING | HOUR
    | IN | INNER | INTEGER | INTERSECT | INTERVAL | IS | INT
    | JOIN
    | LARGE | LATERAL | LEADING | LEFT | LIKE | LOCAL
    | MATCH  | MEMBER | MINUTE | MONTH
    | NCHAR | NATIONAL | NATURAL | NO | NOT | NULL  | NUMERIC
    | OF | ON | ONLY | OR | ORDER | OUTER | OVER | OVERLAPS | OFFSET
    | PARTIAL | PARTITION | POSITION | PRECISION | PRECEDING
    | RANGE | REAL | RIGHT | ROLLUP | ROWS | ROW
    | SECOND | SELECT | SET | SMALLINT | SOME | SUBMULTISET
    | THEN | TIME | TIMESTAMP | TO | TRAILING  | TRUE
    | UNION | UNIQUE | UNKNOWN | UNNEST | UPDATE | USING
    | VALUES | VARCHAR | VARYING
    | WHEN | WHERE | WITH | WINDOW | WITHOUT
    | YEAR
    ;

variable
    : (AT_? AT_)? (GLOBAL | LOCAL)? DOT_? identifier
    ;

schemaName
    : identifier
    ;

tableName
    : (owner) DOT_ (name) | name | owner DOT_ name (DOT_ name)+
    ;

columnName
    : (owner) DOT_ (name) | name | owner DOT_ name (DOT_ name)+
    | qualifiedShorthand | unqualifiedShorthand
    ;

tableAlias
    : AS? (identifier | STRING_)
    ;

unqualifiedShorthand
    : ASTERISK_
    ;

qualifiedShorthand
    : (owner | reservedWord) DOT_ASTERISK_ | (owner | reservedWord) (DOT_ (name | reservedWord))* DOT_ASTERISK_
    ;

owner
    : identifier
    ;

name
    : identifier
    ;

constraintName
    : identifier
    ;

columnNames
    : LP_ columnName (COMMA_ columnName)* RP_
    ;

tableNames
    : LP_? tableName (COMMA_ tableName)* RP_?
    ;

characterSetName
    : IDENTIFIER_
    ;

expr
    : expr andOperator expr
    | expr orOperator expr
    | notOperator expr
    | LP_ expr RP_
    | booleanPrimary
    ;

andOperator
    : AND
    ;

orOperator
    : OR
    ;

exprList
    : LP_ (expr (COMMA_ expr)* | ASTERISK_)? RP_
    ;

exprListwithModifier
    : LP_ modifier? (expr (COMMA_ modifier? expr)* | ASTERISK_)? RP_
    ;

notOperator
    : NOT 
    ;

booleanPrimary
    : booleanPrimary isOperator literals
    | booleanPrimary comparisonOperator predicate
    | booleanPrimary comparisonOperator subquery
    | predicate
    ;

comparisonOperator
    : (EQ_ | GTE_ | GT_ | LTE_ | LT_ | NEQ_) (ALL | SOME | ANY)?
    ;

isOperator
    : IS NOT?
    ;

predicate
    : inPredicate
    | betweenPredicate
    | likePredicate
    | overlapsPredicate
    | typePredicate
    | distinctPredicate
    | normalizedPredicate
    | memberPredicate
    | submultisetPredicate
    | setPredicate
    | bitExpr
    ;

normalizedPredicate
    : bitExpr IS NOT? NORMALIZED
    ;

submultisetPredicate
    : bitExpr NOT? SUBMULTISET OF expr
    ;

memberPredicate
    : bitExpr NOT? MEMBER OF LP_ expr RP_
    ;

setPredicate
    : bitExpr IS NOT? ASET
    ;

distinctPredicate
    : bitExpr IS NOT? DISTINCT FROM bitExpr
    ;

typePredicate
    : bitExpr IS NOT? OF LP_ dataType (COMMA_ dataType (COMMA_ dataType)*)? RP_
    ;

overlapsPredicate
    : bitExpr OVERLAPS bitExpr
    ;

inPredicate
    : bitExpr NOT? IN subquery
    | bitExpr NOT? IN exprList
    | bitExpr NOT? IN mask_token
    | bitExpr NOT? IN paren_token
    ;

betweenPredicate
    : bitExpr NOT? BETWEEN bitExpr AND predicate
    ;

likePredicate
    : bitExpr NOT? LIKE simpleExpr (ESCAPE simpleExpr)?
    ;

bitExpr
    :
    // aug
    // : bitExpr DOUBLE_COLON_ dataTypeName
     bitExpr multiplyBitOperator bitExpr
    | bitExpr plusBitOperator bitExpr
    | bitExpr concatBitOperator bitExpr
    | bitExpr logicalBitOperator bitExpr
    | simpleExpr
    ;

logicalBitOperator
    : VERTICAL_BAR_ | AMPERSAND_
    ;

multiplyBitOperator
    : ASTERISK_ | SLASH_ | MOD_
    ;

plusBitOperator
    : PLUS_ | MINUS_
    ;

concatBitOperator
    :  CONCAT_
    ;

simpleExpr
    : functionCall
    | parameterMarker
    | literals
    | identifier
    | columnName
    | collateClause
    | variable
    | (PLUS_ | MINUS_) simpleExpr
    | LP_ expr RP_
    | exprList
    | exprListwithModifier
    | existExpr
    | uniqueExpr
    | matchExpression
    | caseExpression
    | intervalExpression
    | simpleExpr DEREFERENCE_ identifier exprList
    | simpleExpr AS (dataType | identifier)
    | simpleExpr LBT_ numberLiterals RBT_
    | valuesExpression
    | windowFunction
    | subquery
    | mask_token
    | paren_token
    ;

mask_token
    : MASK_TOKEN
    ;

paren_token
    : PAREN_TOKEN
    ;

existExpr
    : EXISTS (subquery | mask_token)
    ;

uniqueExpr
    : UNIQUE (subquery | mask_token)
    ;

functionCall
    : aggregationFunction | specialFunction | regularFunction 
    ;

aggregationFunction
    : aggregationFunctionName (exprListwithModifier | paren_token)
    ;

aggregationFunctionName
    : MAX | MIN | SUM | COUNT | AVG
    ;

modifier
    : DISTINCT
    ;

specialFunction
    : castFunction | convertFunction | positionFunction | substringFunction | extractFunction | trimFunction
    ;

castFunction
    : CAST LP_ castExpression RP_
    ;

castExpression
    : (expr | NULL) AS (dataType | mask_token)
    ;

convertFunction
    : CONVERT LP_ expr USING identifier RP_
    ;

positionFunction
    : POSITION LP_ expr IN expr RP_
    ;

substringFunction
    : SUBSTRING LP_ expr FROM NUMBER_ (FOR NUMBER_)? RP_
    ;

extractFunction
    : EXTRACT LP_ extractExpression RP_
    ;

extractExpression
    : (identifier | mask_token) FROM expr
    ;

trimFunction
    : TRIM LP_ (LEADING | BOTH | TRAILING) STRING_ FROM STRING_ RP_
    ;

regularFunction
    : regularFunctionName (exprList | paren_token)
    ;

regularFunctionName
    : identifier 
    | (identifier | reservedWord) DOT_ (identifier | reservedWord) 
    | (identifier | reservedWord) DOUBLE_COLON_ (identifier | reservedWord)
    | reservedWord
    ;

valuesExpression
    : VALUES exprList
    ;

matchExpression
    : literals MATCH UNIQUE? (PARTIAL | FULL | SIMPLE)  subquery
    ;

caseExpression
    : CASE simpleExpr? caseWhen+ caseElse? END
    | NULLIF LP_ expr COMMA_ expr RP_
    | COALESCE exprList
    ;

caseWhen
    : WHEN expr THEN expr
    ;

caseElse
    : ELSE expr
    ;

intervalExpression
    : INTERVAL expr intervalUnit
    | INTERVAL expr intervalUnit TO intervalUnit
    ;

intervalUnit
    : SECOND | MINUTE | HOUR | DAY | MONTH | YEAR
    ;

subquery
    : 'Default does not match anything'
    ;

dataType
    : dataTypeName dataTypeLength? characterSet? collateClause? | dataTypeName LP_ STRING_ (COMMA_ STRING_)* RP_ characterSet? collateClause?
    | rowType
    ;

dataTypeName
    : preDefinedType
    | identifier
    //aug
    // | mask_token
    ;

preDefinedType
    :    
    CHARACTER | CHAR | CHARACTER VARYING | VARCHAR | CHAR VARYING | CHARACTER LARGE OBJECT | CHAR LARGE OBJECT | CLOB
    | NATIONAL CHARACTER | NATIONAL CHAR | NCHAR | NATIONAL CHARACTER VARYING | NATIONAL CHAR VARYING | NCHAR VARYING | NATIONAL CHARACTER LARGE OBJECT | NCHAR LARGE OBJECT | NCLOB
    | BINARY LARGE OBJECT | BLOB
    | NUMERIC | DECIMAL | DEC | INTEGER | INT | SMALLINT | BIGINT
    | FLOAT | REAL | DOUBLE PRECISION
    | BOOLEAN
    | DATE | TIME | TIMESTAMP | TIME (WITH | WITHOUT) TIME ZONE | TIMESTAMP (WITH | WITHOUT) TIME ZONE
    | intervalExpression
    ;

rowType
    : ROW LP_ identifier dataType (COMMA_ identifier dataType)* RP_
    ;

dataTypeLength
    : LP_ NUMBER_ (COMMA_ NUMBER_)? RP_
    ;

characterSet
    : (CHARACTER | CHAR) SET EQ_? ignoredIdentifier
    ;

collateClause
    : COLLATE EQ_? (STRING_ | ignoredIdentifier)
    ;

ignoredIdentifier
    : identifier (DOT_ identifier)?
    ;


windowFunction
    : (mask_token | windowFunctionType) OVER (LP_ windowSpecification RP_ | mask_token)
    ;

windowFunctionType
    : ROW_NUMBER LP_ RP_ | aggregationFunction | regularFunction
    ;

windowNameOrSpec
    : identifier | windowSpecification
    ;

windowSpecification
    : 'Default does not match anything'
    ;