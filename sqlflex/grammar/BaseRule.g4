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

nullValueLiterals
    : NULL
    ;

identifier
    : IDENTIFIER_ 
    // | unreservedWord
    ;

unreservedWord
    :   
    ;

reservedWord
    : ALL | AND | ANY | AS | ASC | AVG
    | BETWEEN | BIT | BOTH | BY
    | CASE | CAST | CHAR | CHARACTER | COALESCE | COLLATE | CONVERT | CROSS | CURRENT_DATE
    | DATE | DAY | DEC | DECIMAL | DESC | DISTINCT | DOUBLE
    | ELSE | END | ESCAPE | EXCEPT | EXISTS | EXTRACT
    | FALSE | FLOAT | FOR | FROM | FULL
    | GLOBAL | GROUP
    | HAVING | HOUR
    | IN | INNER | INT | INTEGER | INTERSECT | INTERVAL | IS
    | JOIN
    | LEADING | LEFT | LIKE | LOCAL
    | MATCH | MAX | MIN | MINUTE | MONTH
    | NATURAL | NATIONAL | NCHAR | NOT | NULL | NULLIF | NUMERIC
    | OF | OFFSET | ON | ONLY | OR | ORDER | OUTER
    | PARTIAL | POSITION | PRECISION
    | READ | REAL | RIGHT
    | SECOND | SELECT | SET | SMALLINT | SOME | SUBSTRING | SUM
    | THEN | TIME | TIMESTAMP | TRAILING | TRIM | TRUE | TO
    | UNION | UNIQUE | UNKNOWN | UPDATE | USING
    | VARCHAR | VARYING
    | WHEN | WHERE | WITH
    | YEAR
    | ZONE
    ;

variable
    : (AT_? AT_)? (GLOBAL | LOCAL)? DOT_? identifier
    ;

schemaName
    : identifier
    ;

tableName
    : (owner) DOT_ (name) | name
    ;

columnName
    : (owner) DOT_ (name) | name
    | qualifiedShorthand | unqualifiedShorthand
    ;

tableAlias
    : AS? (identifier | STRING_)
    ;

unqualifiedShorthand
    : ASTERISK_
    ;

qualifiedShorthand
    : (owner | reservedWord) DOT_ASTERISK_
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
    | bitExpr
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
    : bitExpr NOT? LIKE bitExpr (ESCAPE simpleExpr)?
    ;

bitExpr
    : bitExpr multiplyBitOperator bitExpr
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
    : identifier | reservedWord
    ;

matchExpression
    : literals MATCH UNIQUE? PARTIAL  subquery
    | literals MATCH UNIQUE? FULL subquery
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
    ;

dataTypeName
    : CHARACTER | CHAR | CHARACTER VARYING | CHAR VARYING | VARCHAR
    | NATIONAL CHARACTER | NATIONAL CHAR | NCHAR | NATIONAL CHARACTER VARYING | NATIONAL CHAR VARYING | NCHAR VARYING
    | BIT | BIT VARYING
    | NUMERIC | DECIMAL | DEC | INTEGER | SMALLINT | INT
    | FLOAT | REAL | DOUBLE PRECISION
    | DATE | TIME | TIMESTAMP | TIME WITH TIME ZONE | TIMESTAMP WITH TIME ZONE
    | intervalExpression
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