# Generated from ./SQL.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .SQLParser import SQLParser
else:
    from SQLParser import SQLParser

# This class defines a complete listener for a parse tree produced by SQLParser.
class SQLListener(ParseTreeListener):

    # Enter a parse tree produced by SQLParser#root.
    def enterRoot(self, ctx:SQLParser.RootContext):
        pass

    # Exit a parse tree produced by SQLParser#root.
    def exitRoot(self, ctx:SQLParser.RootContext):
        pass


    # Enter a parse tree produced by SQLParser#setOperation.
    def enterSetOperation(self, ctx:SQLParser.SetOperationContext):
        pass

    # Exit a parse tree produced by SQLParser#setOperation.
    def exitSetOperation(self, ctx:SQLParser.SetOperationContext):
        pass


    # Enter a parse tree produced by SQLParser#setOperator.
    def enterSetOperator(self, ctx:SQLParser.SetOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#setOperator.
    def exitSetOperator(self, ctx:SQLParser.SetOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#selectStmt.
    def enterSelectStmt(self, ctx:SQLParser.SelectStmtContext):
        pass

    # Exit a parse tree produced by SQLParser#selectStmt.
    def exitSelectStmt(self, ctx:SQLParser.SelectStmtContext):
        pass


    # Enter a parse tree produced by SQLParser#selectClause.
    def enterSelectClause(self, ctx:SQLParser.SelectClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#selectClause.
    def exitSelectClause(self, ctx:SQLParser.SelectClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#selectSpecification.
    def enterSelectSpecification(self, ctx:SQLParser.SelectSpecificationContext):
        pass

    # Exit a parse tree produced by SQLParser#selectSpecification.
    def exitSelectSpecification(self, ctx:SQLParser.SelectSpecificationContext):
        pass


    # Enter a parse tree produced by SQLParser#projections.
    def enterProjections(self, ctx:SQLParser.ProjectionsContext):
        pass

    # Exit a parse tree produced by SQLParser#projections.
    def exitProjections(self, ctx:SQLParser.ProjectionsContext):
        pass


    # Enter a parse tree produced by SQLParser#projection.
    def enterProjection(self, ctx:SQLParser.ProjectionContext):
        pass

    # Exit a parse tree produced by SQLParser#projection.
    def exitProjection(self, ctx:SQLParser.ProjectionContext):
        pass


    # Enter a parse tree produced by SQLParser#projectionAlias.
    def enterProjectionAlias(self, ctx:SQLParser.ProjectionAliasContext):
        pass

    # Exit a parse tree produced by SQLParser#projectionAlias.
    def exitProjectionAlias(self, ctx:SQLParser.ProjectionAliasContext):
        pass


    # Enter a parse tree produced by SQLParser#tableAlias.
    def enterTableAlias(self, ctx:SQLParser.TableAliasContext):
        pass

    # Exit a parse tree produced by SQLParser#tableAlias.
    def exitTableAlias(self, ctx:SQLParser.TableAliasContext):
        pass


    # Enter a parse tree produced by SQLParser#fromClause.
    def enterFromClause(self, ctx:SQLParser.FromClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#fromClause.
    def exitFromClause(self, ctx:SQLParser.FromClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#tableReferences.
    def enterTableReferences(self, ctx:SQLParser.TableReferencesContext):
        pass

    # Exit a parse tree produced by SQLParser#tableReferences.
    def exitTableReferences(self, ctx:SQLParser.TableReferencesContext):
        pass


    # Enter a parse tree produced by SQLParser#tableReference.
    def enterTableReference(self, ctx:SQLParser.TableReferenceContext):
        pass

    # Exit a parse tree produced by SQLParser#tableReference.
    def exitTableReference(self, ctx:SQLParser.TableReferenceContext):
        pass


    # Enter a parse tree produced by SQLParser#joinClauses.
    def enterJoinClauses(self, ctx:SQLParser.JoinClausesContext):
        pass

    # Exit a parse tree produced by SQLParser#joinClauses.
    def exitJoinClauses(self, ctx:SQLParser.JoinClausesContext):
        pass


    # Enter a parse tree produced by SQLParser#joinClause.
    def enterJoinClause(self, ctx:SQLParser.JoinClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#joinClause.
    def exitJoinClause(self, ctx:SQLParser.JoinClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#joinType.
    def enterJoinType(self, ctx:SQLParser.JoinTypeContext):
        pass

    # Exit a parse tree produced by SQLParser#joinType.
    def exitJoinType(self, ctx:SQLParser.JoinTypeContext):
        pass


    # Enter a parse tree produced by SQLParser#joinSpecification.
    def enterJoinSpecification(self, ctx:SQLParser.JoinSpecificationContext):
        pass

    # Exit a parse tree produced by SQLParser#joinSpecification.
    def exitJoinSpecification(self, ctx:SQLParser.JoinSpecificationContext):
        pass


    # Enter a parse tree produced by SQLParser#onClause.
    def enterOnClause(self, ctx:SQLParser.OnClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#onClause.
    def exitOnClause(self, ctx:SQLParser.OnClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#usingClause.
    def enterUsingClause(self, ctx:SQLParser.UsingClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#usingClause.
    def exitUsingClause(self, ctx:SQLParser.UsingClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#whereClause.
    def enterWhereClause(self, ctx:SQLParser.WhereClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#whereClause.
    def exitWhereClause(self, ctx:SQLParser.WhereClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#groupByClause.
    def enterGroupByClause(self, ctx:SQLParser.GroupByClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#groupByClause.
    def exitGroupByClause(self, ctx:SQLParser.GroupByClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#orderByClause.
    def enterOrderByClause(self, ctx:SQLParser.OrderByClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#orderByClause.
    def exitOrderByClause(self, ctx:SQLParser.OrderByClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#groupByItem.
    def enterGroupByItem(self, ctx:SQLParser.GroupByItemContext):
        pass

    # Exit a parse tree produced by SQLParser#groupByItem.
    def exitGroupByItem(self, ctx:SQLParser.GroupByItemContext):
        pass


    # Enter a parse tree produced by SQLParser#orderByItem.
    def enterOrderByItem(self, ctx:SQLParser.OrderByItemContext):
        pass

    # Exit a parse tree produced by SQLParser#orderByItem.
    def exitOrderByItem(self, ctx:SQLParser.OrderByItemContext):
        pass


    # Enter a parse tree produced by SQLParser#havingClause.
    def enterHavingClause(self, ctx:SQLParser.HavingClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#havingClause.
    def exitHavingClause(self, ctx:SQLParser.HavingClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#subquery.
    def enterSubquery(self, ctx:SQLParser.SubqueryContext):
        pass

    # Exit a parse tree produced by SQLParser#subquery.
    def exitSubquery(self, ctx:SQLParser.SubqueryContext):
        pass


    # Enter a parse tree produced by SQLParser#updatabilityClause.
    def enterUpdatabilityClause(self, ctx:SQLParser.UpdatabilityClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#updatabilityClause.
    def exitUpdatabilityClause(self, ctx:SQLParser.UpdatabilityClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#parameterMarker.
    def enterParameterMarker(self, ctx:SQLParser.ParameterMarkerContext):
        pass

    # Exit a parse tree produced by SQLParser#parameterMarker.
    def exitParameterMarker(self, ctx:SQLParser.ParameterMarkerContext):
        pass


    # Enter a parse tree produced by SQLParser#literals.
    def enterLiterals(self, ctx:SQLParser.LiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#literals.
    def exitLiterals(self, ctx:SQLParser.LiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#asteriskLiteral.
    def enterAsteriskLiteral(self, ctx:SQLParser.AsteriskLiteralContext):
        pass

    # Exit a parse tree produced by SQLParser#asteriskLiteral.
    def exitAsteriskLiteral(self, ctx:SQLParser.AsteriskLiteralContext):
        pass


    # Enter a parse tree produced by SQLParser#stringLiterals.
    def enterStringLiterals(self, ctx:SQLParser.StringLiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#stringLiterals.
    def exitStringLiterals(self, ctx:SQLParser.StringLiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#numberLiterals.
    def enterNumberLiterals(self, ctx:SQLParser.NumberLiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#numberLiterals.
    def exitNumberLiterals(self, ctx:SQLParser.NumberLiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#dateTimeLiterals.
    def enterDateTimeLiterals(self, ctx:SQLParser.DateTimeLiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#dateTimeLiterals.
    def exitDateTimeLiterals(self, ctx:SQLParser.DateTimeLiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#hexadecimalLiterals.
    def enterHexadecimalLiterals(self, ctx:SQLParser.HexadecimalLiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#hexadecimalLiterals.
    def exitHexadecimalLiterals(self, ctx:SQLParser.HexadecimalLiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#bitValueLiterals.
    def enterBitValueLiterals(self, ctx:SQLParser.BitValueLiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#bitValueLiterals.
    def exitBitValueLiterals(self, ctx:SQLParser.BitValueLiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#booleanLiterals.
    def enterBooleanLiterals(self, ctx:SQLParser.BooleanLiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#booleanLiterals.
    def exitBooleanLiterals(self, ctx:SQLParser.BooleanLiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#nullValueLiterals.
    def enterNullValueLiterals(self, ctx:SQLParser.NullValueLiteralsContext):
        pass

    # Exit a parse tree produced by SQLParser#nullValueLiterals.
    def exitNullValueLiterals(self, ctx:SQLParser.NullValueLiteralsContext):
        pass


    # Enter a parse tree produced by SQLParser#identifier.
    def enterIdentifier(self, ctx:SQLParser.IdentifierContext):
        pass

    # Exit a parse tree produced by SQLParser#identifier.
    def exitIdentifier(self, ctx:SQLParser.IdentifierContext):
        pass


    # Enter a parse tree produced by SQLParser#unreservedWord.
    def enterUnreservedWord(self, ctx:SQLParser.UnreservedWordContext):
        pass

    # Exit a parse tree produced by SQLParser#unreservedWord.
    def exitUnreservedWord(self, ctx:SQLParser.UnreservedWordContext):
        pass


    # Enter a parse tree produced by SQLParser#reservedWord.
    def enterReservedWord(self, ctx:SQLParser.ReservedWordContext):
        pass

    # Exit a parse tree produced by SQLParser#reservedWord.
    def exitReservedWord(self, ctx:SQLParser.ReservedWordContext):
        pass


    # Enter a parse tree produced by SQLParser#variable.
    def enterVariable(self, ctx:SQLParser.VariableContext):
        pass

    # Exit a parse tree produced by SQLParser#variable.
    def exitVariable(self, ctx:SQLParser.VariableContext):
        pass


    # Enter a parse tree produced by SQLParser#schemaName.
    def enterSchemaName(self, ctx:SQLParser.SchemaNameContext):
        pass

    # Exit a parse tree produced by SQLParser#schemaName.
    def exitSchemaName(self, ctx:SQLParser.SchemaNameContext):
        pass


    # Enter a parse tree produced by SQLParser#tableName.
    def enterTableName(self, ctx:SQLParser.TableNameContext):
        pass

    # Exit a parse tree produced by SQLParser#tableName.
    def exitTableName(self, ctx:SQLParser.TableNameContext):
        pass


    # Enter a parse tree produced by SQLParser#columnName.
    def enterColumnName(self, ctx:SQLParser.ColumnNameContext):
        pass

    # Exit a parse tree produced by SQLParser#columnName.
    def exitColumnName(self, ctx:SQLParser.ColumnNameContext):
        pass


    # Enter a parse tree produced by SQLParser#unqualifiedShorthand.
    def enterUnqualifiedShorthand(self, ctx:SQLParser.UnqualifiedShorthandContext):
        pass

    # Exit a parse tree produced by SQLParser#unqualifiedShorthand.
    def exitUnqualifiedShorthand(self, ctx:SQLParser.UnqualifiedShorthandContext):
        pass


    # Enter a parse tree produced by SQLParser#qualifiedShorthand.
    def enterQualifiedShorthand(self, ctx:SQLParser.QualifiedShorthandContext):
        pass

    # Exit a parse tree produced by SQLParser#qualifiedShorthand.
    def exitQualifiedShorthand(self, ctx:SQLParser.QualifiedShorthandContext):
        pass


    # Enter a parse tree produced by SQLParser#owner.
    def enterOwner(self, ctx:SQLParser.OwnerContext):
        pass

    # Exit a parse tree produced by SQLParser#owner.
    def exitOwner(self, ctx:SQLParser.OwnerContext):
        pass


    # Enter a parse tree produced by SQLParser#name.
    def enterName(self, ctx:SQLParser.NameContext):
        pass

    # Exit a parse tree produced by SQLParser#name.
    def exitName(self, ctx:SQLParser.NameContext):
        pass


    # Enter a parse tree produced by SQLParser#constraintName.
    def enterConstraintName(self, ctx:SQLParser.ConstraintNameContext):
        pass

    # Exit a parse tree produced by SQLParser#constraintName.
    def exitConstraintName(self, ctx:SQLParser.ConstraintNameContext):
        pass


    # Enter a parse tree produced by SQLParser#columnNames.
    def enterColumnNames(self, ctx:SQLParser.ColumnNamesContext):
        pass

    # Exit a parse tree produced by SQLParser#columnNames.
    def exitColumnNames(self, ctx:SQLParser.ColumnNamesContext):
        pass


    # Enter a parse tree produced by SQLParser#tableNames.
    def enterTableNames(self, ctx:SQLParser.TableNamesContext):
        pass

    # Exit a parse tree produced by SQLParser#tableNames.
    def exitTableNames(self, ctx:SQLParser.TableNamesContext):
        pass


    # Enter a parse tree produced by SQLParser#characterSetName.
    def enterCharacterSetName(self, ctx:SQLParser.CharacterSetNameContext):
        pass

    # Exit a parse tree produced by SQLParser#characterSetName.
    def exitCharacterSetName(self, ctx:SQLParser.CharacterSetNameContext):
        pass


    # Enter a parse tree produced by SQLParser#expr.
    def enterExpr(self, ctx:SQLParser.ExprContext):
        pass

    # Exit a parse tree produced by SQLParser#expr.
    def exitExpr(self, ctx:SQLParser.ExprContext):
        pass


    # Enter a parse tree produced by SQLParser#andOperator.
    def enterAndOperator(self, ctx:SQLParser.AndOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#andOperator.
    def exitAndOperator(self, ctx:SQLParser.AndOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#orOperator.
    def enterOrOperator(self, ctx:SQLParser.OrOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#orOperator.
    def exitOrOperator(self, ctx:SQLParser.OrOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#exprList.
    def enterExprList(self, ctx:SQLParser.ExprListContext):
        pass

    # Exit a parse tree produced by SQLParser#exprList.
    def exitExprList(self, ctx:SQLParser.ExprListContext):
        pass


    # Enter a parse tree produced by SQLParser#exprListwithModifier.
    def enterExprListwithModifier(self, ctx:SQLParser.ExprListwithModifierContext):
        pass

    # Exit a parse tree produced by SQLParser#exprListwithModifier.
    def exitExprListwithModifier(self, ctx:SQLParser.ExprListwithModifierContext):
        pass


    # Enter a parse tree produced by SQLParser#notOperator.
    def enterNotOperator(self, ctx:SQLParser.NotOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#notOperator.
    def exitNotOperator(self, ctx:SQLParser.NotOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#booleanPrimary.
    def enterBooleanPrimary(self, ctx:SQLParser.BooleanPrimaryContext):
        pass

    # Exit a parse tree produced by SQLParser#booleanPrimary.
    def exitBooleanPrimary(self, ctx:SQLParser.BooleanPrimaryContext):
        pass


    # Enter a parse tree produced by SQLParser#comparisonOperator.
    def enterComparisonOperator(self, ctx:SQLParser.ComparisonOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#comparisonOperator.
    def exitComparisonOperator(self, ctx:SQLParser.ComparisonOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#isOperator.
    def enterIsOperator(self, ctx:SQLParser.IsOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#isOperator.
    def exitIsOperator(self, ctx:SQLParser.IsOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#predicate.
    def enterPredicate(self, ctx:SQLParser.PredicateContext):
        pass

    # Exit a parse tree produced by SQLParser#predicate.
    def exitPredicate(self, ctx:SQLParser.PredicateContext):
        pass


    # Enter a parse tree produced by SQLParser#inPredicate.
    def enterInPredicate(self, ctx:SQLParser.InPredicateContext):
        pass

    # Exit a parse tree produced by SQLParser#inPredicate.
    def exitInPredicate(self, ctx:SQLParser.InPredicateContext):
        pass


    # Enter a parse tree produced by SQLParser#betweenPredicate.
    def enterBetweenPredicate(self, ctx:SQLParser.BetweenPredicateContext):
        pass

    # Exit a parse tree produced by SQLParser#betweenPredicate.
    def exitBetweenPredicate(self, ctx:SQLParser.BetweenPredicateContext):
        pass


    # Enter a parse tree produced by SQLParser#likePredicate.
    def enterLikePredicate(self, ctx:SQLParser.LikePredicateContext):
        pass

    # Exit a parse tree produced by SQLParser#likePredicate.
    def exitLikePredicate(self, ctx:SQLParser.LikePredicateContext):
        pass


    # Enter a parse tree produced by SQLParser#bitExpr.
    def enterBitExpr(self, ctx:SQLParser.BitExprContext):
        pass

    # Exit a parse tree produced by SQLParser#bitExpr.
    def exitBitExpr(self, ctx:SQLParser.BitExprContext):
        pass


    # Enter a parse tree produced by SQLParser#logicalBitOperator.
    def enterLogicalBitOperator(self, ctx:SQLParser.LogicalBitOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#logicalBitOperator.
    def exitLogicalBitOperator(self, ctx:SQLParser.LogicalBitOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#multiplyBitOperator.
    def enterMultiplyBitOperator(self, ctx:SQLParser.MultiplyBitOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#multiplyBitOperator.
    def exitMultiplyBitOperator(self, ctx:SQLParser.MultiplyBitOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#plusBitOperator.
    def enterPlusBitOperator(self, ctx:SQLParser.PlusBitOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#plusBitOperator.
    def exitPlusBitOperator(self, ctx:SQLParser.PlusBitOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#concatBitOperator.
    def enterConcatBitOperator(self, ctx:SQLParser.ConcatBitOperatorContext):
        pass

    # Exit a parse tree produced by SQLParser#concatBitOperator.
    def exitConcatBitOperator(self, ctx:SQLParser.ConcatBitOperatorContext):
        pass


    # Enter a parse tree produced by SQLParser#simpleExpr.
    def enterSimpleExpr(self, ctx:SQLParser.SimpleExprContext):
        pass

    # Exit a parse tree produced by SQLParser#simpleExpr.
    def exitSimpleExpr(self, ctx:SQLParser.SimpleExprContext):
        pass


    # Enter a parse tree produced by SQLParser#mask_token.
    def enterMask_token(self, ctx:SQLParser.Mask_tokenContext):
        pass

    # Exit a parse tree produced by SQLParser#mask_token.
    def exitMask_token(self, ctx:SQLParser.Mask_tokenContext):
        pass


    # Enter a parse tree produced by SQLParser#paren_token.
    def enterParen_token(self, ctx:SQLParser.Paren_tokenContext):
        pass

    # Exit a parse tree produced by SQLParser#paren_token.
    def exitParen_token(self, ctx:SQLParser.Paren_tokenContext):
        pass


    # Enter a parse tree produced by SQLParser#existExpr.
    def enterExistExpr(self, ctx:SQLParser.ExistExprContext):
        pass

    # Exit a parse tree produced by SQLParser#existExpr.
    def exitExistExpr(self, ctx:SQLParser.ExistExprContext):
        pass


    # Enter a parse tree produced by SQLParser#uniqueExpr.
    def enterUniqueExpr(self, ctx:SQLParser.UniqueExprContext):
        pass

    # Exit a parse tree produced by SQLParser#uniqueExpr.
    def exitUniqueExpr(self, ctx:SQLParser.UniqueExprContext):
        pass


    # Enter a parse tree produced by SQLParser#functionCall.
    def enterFunctionCall(self, ctx:SQLParser.FunctionCallContext):
        pass

    # Exit a parse tree produced by SQLParser#functionCall.
    def exitFunctionCall(self, ctx:SQLParser.FunctionCallContext):
        pass


    # Enter a parse tree produced by SQLParser#aggregationFunction.
    def enterAggregationFunction(self, ctx:SQLParser.AggregationFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#aggregationFunction.
    def exitAggregationFunction(self, ctx:SQLParser.AggregationFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#aggregationFunctionName.
    def enterAggregationFunctionName(self, ctx:SQLParser.AggregationFunctionNameContext):
        pass

    # Exit a parse tree produced by SQLParser#aggregationFunctionName.
    def exitAggregationFunctionName(self, ctx:SQLParser.AggregationFunctionNameContext):
        pass


    # Enter a parse tree produced by SQLParser#modifier.
    def enterModifier(self, ctx:SQLParser.ModifierContext):
        pass

    # Exit a parse tree produced by SQLParser#modifier.
    def exitModifier(self, ctx:SQLParser.ModifierContext):
        pass


    # Enter a parse tree produced by SQLParser#specialFunction.
    def enterSpecialFunction(self, ctx:SQLParser.SpecialFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#specialFunction.
    def exitSpecialFunction(self, ctx:SQLParser.SpecialFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#castFunction.
    def enterCastFunction(self, ctx:SQLParser.CastFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#castFunction.
    def exitCastFunction(self, ctx:SQLParser.CastFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#castExpression.
    def enterCastExpression(self, ctx:SQLParser.CastExpressionContext):
        pass

    # Exit a parse tree produced by SQLParser#castExpression.
    def exitCastExpression(self, ctx:SQLParser.CastExpressionContext):
        pass


    # Enter a parse tree produced by SQLParser#convertFunction.
    def enterConvertFunction(self, ctx:SQLParser.ConvertFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#convertFunction.
    def exitConvertFunction(self, ctx:SQLParser.ConvertFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#positionFunction.
    def enterPositionFunction(self, ctx:SQLParser.PositionFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#positionFunction.
    def exitPositionFunction(self, ctx:SQLParser.PositionFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#substringFunction.
    def enterSubstringFunction(self, ctx:SQLParser.SubstringFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#substringFunction.
    def exitSubstringFunction(self, ctx:SQLParser.SubstringFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#extractFunction.
    def enterExtractFunction(self, ctx:SQLParser.ExtractFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#extractFunction.
    def exitExtractFunction(self, ctx:SQLParser.ExtractFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#extractExpression.
    def enterExtractExpression(self, ctx:SQLParser.ExtractExpressionContext):
        pass

    # Exit a parse tree produced by SQLParser#extractExpression.
    def exitExtractExpression(self, ctx:SQLParser.ExtractExpressionContext):
        pass


    # Enter a parse tree produced by SQLParser#trimFunction.
    def enterTrimFunction(self, ctx:SQLParser.TrimFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#trimFunction.
    def exitTrimFunction(self, ctx:SQLParser.TrimFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#regularFunction.
    def enterRegularFunction(self, ctx:SQLParser.RegularFunctionContext):
        pass

    # Exit a parse tree produced by SQLParser#regularFunction.
    def exitRegularFunction(self, ctx:SQLParser.RegularFunctionContext):
        pass


    # Enter a parse tree produced by SQLParser#regularFunctionName.
    def enterRegularFunctionName(self, ctx:SQLParser.RegularFunctionNameContext):
        pass

    # Exit a parse tree produced by SQLParser#regularFunctionName.
    def exitRegularFunctionName(self, ctx:SQLParser.RegularFunctionNameContext):
        pass


    # Enter a parse tree produced by SQLParser#matchExpression.
    def enterMatchExpression(self, ctx:SQLParser.MatchExpressionContext):
        pass

    # Exit a parse tree produced by SQLParser#matchExpression.
    def exitMatchExpression(self, ctx:SQLParser.MatchExpressionContext):
        pass


    # Enter a parse tree produced by SQLParser#caseExpression.
    def enterCaseExpression(self, ctx:SQLParser.CaseExpressionContext):
        pass

    # Exit a parse tree produced by SQLParser#caseExpression.
    def exitCaseExpression(self, ctx:SQLParser.CaseExpressionContext):
        pass


    # Enter a parse tree produced by SQLParser#caseWhen.
    def enterCaseWhen(self, ctx:SQLParser.CaseWhenContext):
        pass

    # Exit a parse tree produced by SQLParser#caseWhen.
    def exitCaseWhen(self, ctx:SQLParser.CaseWhenContext):
        pass


    # Enter a parse tree produced by SQLParser#caseElse.
    def enterCaseElse(self, ctx:SQLParser.CaseElseContext):
        pass

    # Exit a parse tree produced by SQLParser#caseElse.
    def exitCaseElse(self, ctx:SQLParser.CaseElseContext):
        pass


    # Enter a parse tree produced by SQLParser#intervalExpression.
    def enterIntervalExpression(self, ctx:SQLParser.IntervalExpressionContext):
        pass

    # Exit a parse tree produced by SQLParser#intervalExpression.
    def exitIntervalExpression(self, ctx:SQLParser.IntervalExpressionContext):
        pass


    # Enter a parse tree produced by SQLParser#intervalUnit.
    def enterIntervalUnit(self, ctx:SQLParser.IntervalUnitContext):
        pass

    # Exit a parse tree produced by SQLParser#intervalUnit.
    def exitIntervalUnit(self, ctx:SQLParser.IntervalUnitContext):
        pass


    # Enter a parse tree produced by SQLParser#dataType.
    def enterDataType(self, ctx:SQLParser.DataTypeContext):
        pass

    # Exit a parse tree produced by SQLParser#dataType.
    def exitDataType(self, ctx:SQLParser.DataTypeContext):
        pass


    # Enter a parse tree produced by SQLParser#dataTypeName.
    def enterDataTypeName(self, ctx:SQLParser.DataTypeNameContext):
        pass

    # Exit a parse tree produced by SQLParser#dataTypeName.
    def exitDataTypeName(self, ctx:SQLParser.DataTypeNameContext):
        pass


    # Enter a parse tree produced by SQLParser#dataTypeLength.
    def enterDataTypeLength(self, ctx:SQLParser.DataTypeLengthContext):
        pass

    # Exit a parse tree produced by SQLParser#dataTypeLength.
    def exitDataTypeLength(self, ctx:SQLParser.DataTypeLengthContext):
        pass


    # Enter a parse tree produced by SQLParser#characterSet.
    def enterCharacterSet(self, ctx:SQLParser.CharacterSetContext):
        pass

    # Exit a parse tree produced by SQLParser#characterSet.
    def exitCharacterSet(self, ctx:SQLParser.CharacterSetContext):
        pass


    # Enter a parse tree produced by SQLParser#collateClause.
    def enterCollateClause(self, ctx:SQLParser.CollateClauseContext):
        pass

    # Exit a parse tree produced by SQLParser#collateClause.
    def exitCollateClause(self, ctx:SQLParser.CollateClauseContext):
        pass


    # Enter a parse tree produced by SQLParser#ignoredIdentifier.
    def enterIgnoredIdentifier(self, ctx:SQLParser.IgnoredIdentifierContext):
        pass

    # Exit a parse tree produced by SQLParser#ignoredIdentifier.
    def exitIgnoredIdentifier(self, ctx:SQLParser.IgnoredIdentifierContext):
        pass



del SQLParser