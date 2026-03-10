# Generated from ./SQL.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .SQLParser import SQLParser
else:
    from SQLParser import SQLParser

# This class defines a complete generic visitor for a parse tree produced by SQLParser.

class SQLVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by SQLParser#root.
    def visitRoot(self, ctx:SQLParser.RootContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#setOperation.
    def visitSetOperation(self, ctx:SQLParser.SetOperationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#setOperator.
    def visitSetOperator(self, ctx:SQLParser.SetOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#selectStmt.
    def visitSelectStmt(self, ctx:SQLParser.SelectStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#selectClause.
    def visitSelectClause(self, ctx:SQLParser.SelectClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#selectSpecification.
    def visitSelectSpecification(self, ctx:SQLParser.SelectSpecificationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#projections.
    def visitProjections(self, ctx:SQLParser.ProjectionsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#projection.
    def visitProjection(self, ctx:SQLParser.ProjectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#projectionAlias.
    def visitProjectionAlias(self, ctx:SQLParser.ProjectionAliasContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#tableAlias.
    def visitTableAlias(self, ctx:SQLParser.TableAliasContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#fromClause.
    def visitFromClause(self, ctx:SQLParser.FromClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#tableReferences.
    def visitTableReferences(self, ctx:SQLParser.TableReferencesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#tableReference.
    def visitTableReference(self, ctx:SQLParser.TableReferenceContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#joinClauses.
    def visitJoinClauses(self, ctx:SQLParser.JoinClausesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#joinClause.
    def visitJoinClause(self, ctx:SQLParser.JoinClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#joinType.
    def visitJoinType(self, ctx:SQLParser.JoinTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#joinSpecification.
    def visitJoinSpecification(self, ctx:SQLParser.JoinSpecificationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#onClause.
    def visitOnClause(self, ctx:SQLParser.OnClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#usingClause.
    def visitUsingClause(self, ctx:SQLParser.UsingClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#whereClause.
    def visitWhereClause(self, ctx:SQLParser.WhereClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#groupByClause.
    def visitGroupByClause(self, ctx:SQLParser.GroupByClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#orderByClause.
    def visitOrderByClause(self, ctx:SQLParser.OrderByClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#groupByItem.
    def visitGroupByItem(self, ctx:SQLParser.GroupByItemContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#orderByItem.
    def visitOrderByItem(self, ctx:SQLParser.OrderByItemContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#havingClause.
    def visitHavingClause(self, ctx:SQLParser.HavingClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#subquery.
    def visitSubquery(self, ctx:SQLParser.SubqueryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#updatabilityClause.
    def visitUpdatabilityClause(self, ctx:SQLParser.UpdatabilityClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#parameterMarker.
    def visitParameterMarker(self, ctx:SQLParser.ParameterMarkerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#literals.
    def visitLiterals(self, ctx:SQLParser.LiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#asteriskLiteral.
    def visitAsteriskLiteral(self, ctx:SQLParser.AsteriskLiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#stringLiterals.
    def visitStringLiterals(self, ctx:SQLParser.StringLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#numberLiterals.
    def visitNumberLiterals(self, ctx:SQLParser.NumberLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#dateTimeLiterals.
    def visitDateTimeLiterals(self, ctx:SQLParser.DateTimeLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#hexadecimalLiterals.
    def visitHexadecimalLiterals(self, ctx:SQLParser.HexadecimalLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#bitValueLiterals.
    def visitBitValueLiterals(self, ctx:SQLParser.BitValueLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#booleanLiterals.
    def visitBooleanLiterals(self, ctx:SQLParser.BooleanLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#nullValueLiterals.
    def visitNullValueLiterals(self, ctx:SQLParser.NullValueLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#identifier.
    def visitIdentifier(self, ctx:SQLParser.IdentifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#unreservedWord.
    def visitUnreservedWord(self, ctx:SQLParser.UnreservedWordContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#reservedWord.
    def visitReservedWord(self, ctx:SQLParser.ReservedWordContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#variable.
    def visitVariable(self, ctx:SQLParser.VariableContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#schemaName.
    def visitSchemaName(self, ctx:SQLParser.SchemaNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#tableName.
    def visitTableName(self, ctx:SQLParser.TableNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#columnName.
    def visitColumnName(self, ctx:SQLParser.ColumnNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#unqualifiedShorthand.
    def visitUnqualifiedShorthand(self, ctx:SQLParser.UnqualifiedShorthandContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#qualifiedShorthand.
    def visitQualifiedShorthand(self, ctx:SQLParser.QualifiedShorthandContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#owner.
    def visitOwner(self, ctx:SQLParser.OwnerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#name.
    def visitName(self, ctx:SQLParser.NameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#constraintName.
    def visitConstraintName(self, ctx:SQLParser.ConstraintNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#columnNames.
    def visitColumnNames(self, ctx:SQLParser.ColumnNamesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#tableNames.
    def visitTableNames(self, ctx:SQLParser.TableNamesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#characterSetName.
    def visitCharacterSetName(self, ctx:SQLParser.CharacterSetNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#expr.
    def visitExpr(self, ctx:SQLParser.ExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#andOperator.
    def visitAndOperator(self, ctx:SQLParser.AndOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#orOperator.
    def visitOrOperator(self, ctx:SQLParser.OrOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#exprList.
    def visitExprList(self, ctx:SQLParser.ExprListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#exprListwithModifier.
    def visitExprListwithModifier(self, ctx:SQLParser.ExprListwithModifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#notOperator.
    def visitNotOperator(self, ctx:SQLParser.NotOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#booleanPrimary.
    def visitBooleanPrimary(self, ctx:SQLParser.BooleanPrimaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#comparisonOperator.
    def visitComparisonOperator(self, ctx:SQLParser.ComparisonOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#isOperator.
    def visitIsOperator(self, ctx:SQLParser.IsOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#predicate.
    def visitPredicate(self, ctx:SQLParser.PredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#inPredicate.
    def visitInPredicate(self, ctx:SQLParser.InPredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#betweenPredicate.
    def visitBetweenPredicate(self, ctx:SQLParser.BetweenPredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#likePredicate.
    def visitLikePredicate(self, ctx:SQLParser.LikePredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#bitExpr.
    def visitBitExpr(self, ctx:SQLParser.BitExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#logicalBitOperator.
    def visitLogicalBitOperator(self, ctx:SQLParser.LogicalBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#multiplyBitOperator.
    def visitMultiplyBitOperator(self, ctx:SQLParser.MultiplyBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#plusBitOperator.
    def visitPlusBitOperator(self, ctx:SQLParser.PlusBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#concatBitOperator.
    def visitConcatBitOperator(self, ctx:SQLParser.ConcatBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#simpleExpr.
    def visitSimpleExpr(self, ctx:SQLParser.SimpleExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#mask_token.
    def visitMask_token(self, ctx:SQLParser.Mask_tokenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#paren_token.
    def visitParen_token(self, ctx:SQLParser.Paren_tokenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#existExpr.
    def visitExistExpr(self, ctx:SQLParser.ExistExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#uniqueExpr.
    def visitUniqueExpr(self, ctx:SQLParser.UniqueExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#functionCall.
    def visitFunctionCall(self, ctx:SQLParser.FunctionCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#aggregationFunction.
    def visitAggregationFunction(self, ctx:SQLParser.AggregationFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#aggregationFunctionName.
    def visitAggregationFunctionName(self, ctx:SQLParser.AggregationFunctionNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#modifier.
    def visitModifier(self, ctx:SQLParser.ModifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#specialFunction.
    def visitSpecialFunction(self, ctx:SQLParser.SpecialFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#castFunction.
    def visitCastFunction(self, ctx:SQLParser.CastFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#castExpression.
    def visitCastExpression(self, ctx:SQLParser.CastExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#convertFunction.
    def visitConvertFunction(self, ctx:SQLParser.ConvertFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#positionFunction.
    def visitPositionFunction(self, ctx:SQLParser.PositionFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#substringFunction.
    def visitSubstringFunction(self, ctx:SQLParser.SubstringFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#extractFunction.
    def visitExtractFunction(self, ctx:SQLParser.ExtractFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#extractExpression.
    def visitExtractExpression(self, ctx:SQLParser.ExtractExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#trimFunction.
    def visitTrimFunction(self, ctx:SQLParser.TrimFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#regularFunction.
    def visitRegularFunction(self, ctx:SQLParser.RegularFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#regularFunctionName.
    def visitRegularFunctionName(self, ctx:SQLParser.RegularFunctionNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#matchExpression.
    def visitMatchExpression(self, ctx:SQLParser.MatchExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#caseExpression.
    def visitCaseExpression(self, ctx:SQLParser.CaseExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#caseWhen.
    def visitCaseWhen(self, ctx:SQLParser.CaseWhenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#caseElse.
    def visitCaseElse(self, ctx:SQLParser.CaseElseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#intervalExpression.
    def visitIntervalExpression(self, ctx:SQLParser.IntervalExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#intervalUnit.
    def visitIntervalUnit(self, ctx:SQLParser.IntervalUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#dataType.
    def visitDataType(self, ctx:SQLParser.DataTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#dataTypeName.
    def visitDataTypeName(self, ctx:SQLParser.DataTypeNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#dataTypeLength.
    def visitDataTypeLength(self, ctx:SQLParser.DataTypeLengthContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#characterSet.
    def visitCharacterSet(self, ctx:SQLParser.CharacterSetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#collateClause.
    def visitCollateClause(self, ctx:SQLParser.CollateClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SQLParser#ignoredIdentifier.
    def visitIgnoredIdentifier(self, ctx:SQLParser.IgnoredIdentifierContext):
        return self.visitChildren(ctx)



del SQLParser