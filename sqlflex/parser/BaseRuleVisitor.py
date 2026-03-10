# Generated from ./BaseRule.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .BaseRuleParser import BaseRuleParser
else:
    from BaseRuleParser import BaseRuleParser

# This class defines a complete generic visitor for a parse tree produced by BaseRuleParser.

class BaseRuleVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by BaseRuleParser#parameterMarker.
    def visitParameterMarker(self, ctx:BaseRuleParser.ParameterMarkerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#literals.
    def visitLiterals(self, ctx:BaseRuleParser.LiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#asteriskLiteral.
    def visitAsteriskLiteral(self, ctx:BaseRuleParser.AsteriskLiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#stringLiterals.
    def visitStringLiterals(self, ctx:BaseRuleParser.StringLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#numberLiterals.
    def visitNumberLiterals(self, ctx:BaseRuleParser.NumberLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#dateTimeLiterals.
    def visitDateTimeLiterals(self, ctx:BaseRuleParser.DateTimeLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#hexadecimalLiterals.
    def visitHexadecimalLiterals(self, ctx:BaseRuleParser.HexadecimalLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#bitValueLiterals.
    def visitBitValueLiterals(self, ctx:BaseRuleParser.BitValueLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#booleanLiterals.
    def visitBooleanLiterals(self, ctx:BaseRuleParser.BooleanLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#nullValueLiterals.
    def visitNullValueLiterals(self, ctx:BaseRuleParser.NullValueLiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#identifier.
    def visitIdentifier(self, ctx:BaseRuleParser.IdentifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#unreservedWord.
    def visitUnreservedWord(self, ctx:BaseRuleParser.UnreservedWordContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#reservedWord.
    def visitReservedWord(self, ctx:BaseRuleParser.ReservedWordContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#variable.
    def visitVariable(self, ctx:BaseRuleParser.VariableContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#schemaName.
    def visitSchemaName(self, ctx:BaseRuleParser.SchemaNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#tableName.
    def visitTableName(self, ctx:BaseRuleParser.TableNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#columnName.
    def visitColumnName(self, ctx:BaseRuleParser.ColumnNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#tableAlias.
    def visitTableAlias(self, ctx:BaseRuleParser.TableAliasContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#unqualifiedShorthand.
    def visitUnqualifiedShorthand(self, ctx:BaseRuleParser.UnqualifiedShorthandContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#qualifiedShorthand.
    def visitQualifiedShorthand(self, ctx:BaseRuleParser.QualifiedShorthandContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#owner.
    def visitOwner(self, ctx:BaseRuleParser.OwnerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#name.
    def visitName(self, ctx:BaseRuleParser.NameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#constraintName.
    def visitConstraintName(self, ctx:BaseRuleParser.ConstraintNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#columnNames.
    def visitColumnNames(self, ctx:BaseRuleParser.ColumnNamesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#tableNames.
    def visitTableNames(self, ctx:BaseRuleParser.TableNamesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#characterSetName.
    def visitCharacterSetName(self, ctx:BaseRuleParser.CharacterSetNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#expr.
    def visitExpr(self, ctx:BaseRuleParser.ExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#andOperator.
    def visitAndOperator(self, ctx:BaseRuleParser.AndOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#orOperator.
    def visitOrOperator(self, ctx:BaseRuleParser.OrOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#exprList.
    def visitExprList(self, ctx:BaseRuleParser.ExprListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#exprListwithModifier.
    def visitExprListwithModifier(self, ctx:BaseRuleParser.ExprListwithModifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#notOperator.
    def visitNotOperator(self, ctx:BaseRuleParser.NotOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#booleanPrimary.
    def visitBooleanPrimary(self, ctx:BaseRuleParser.BooleanPrimaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#comparisonOperator.
    def visitComparisonOperator(self, ctx:BaseRuleParser.ComparisonOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#isOperator.
    def visitIsOperator(self, ctx:BaseRuleParser.IsOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#predicate.
    def visitPredicate(self, ctx:BaseRuleParser.PredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#inPredicate.
    def visitInPredicate(self, ctx:BaseRuleParser.InPredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#betweenPredicate.
    def visitBetweenPredicate(self, ctx:BaseRuleParser.BetweenPredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#likePredicate.
    def visitLikePredicate(self, ctx:BaseRuleParser.LikePredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#bitExpr.
    def visitBitExpr(self, ctx:BaseRuleParser.BitExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#logicalBitOperator.
    def visitLogicalBitOperator(self, ctx:BaseRuleParser.LogicalBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#multiplyBitOperator.
    def visitMultiplyBitOperator(self, ctx:BaseRuleParser.MultiplyBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#plusBitOperator.
    def visitPlusBitOperator(self, ctx:BaseRuleParser.PlusBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#concatBitOperator.
    def visitConcatBitOperator(self, ctx:BaseRuleParser.ConcatBitOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#simpleExpr.
    def visitSimpleExpr(self, ctx:BaseRuleParser.SimpleExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#mask_token.
    def visitMask_token(self, ctx:BaseRuleParser.Mask_tokenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#paren_token.
    def visitParen_token(self, ctx:BaseRuleParser.Paren_tokenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#existExpr.
    def visitExistExpr(self, ctx:BaseRuleParser.ExistExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#uniqueExpr.
    def visitUniqueExpr(self, ctx:BaseRuleParser.UniqueExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#functionCall.
    def visitFunctionCall(self, ctx:BaseRuleParser.FunctionCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#aggregationFunction.
    def visitAggregationFunction(self, ctx:BaseRuleParser.AggregationFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#aggregationFunctionName.
    def visitAggregationFunctionName(self, ctx:BaseRuleParser.AggregationFunctionNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#modifier.
    def visitModifier(self, ctx:BaseRuleParser.ModifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#specialFunction.
    def visitSpecialFunction(self, ctx:BaseRuleParser.SpecialFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#castFunction.
    def visitCastFunction(self, ctx:BaseRuleParser.CastFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#castExpression.
    def visitCastExpression(self, ctx:BaseRuleParser.CastExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#convertFunction.
    def visitConvertFunction(self, ctx:BaseRuleParser.ConvertFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#positionFunction.
    def visitPositionFunction(self, ctx:BaseRuleParser.PositionFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#substringFunction.
    def visitSubstringFunction(self, ctx:BaseRuleParser.SubstringFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#extractFunction.
    def visitExtractFunction(self, ctx:BaseRuleParser.ExtractFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#extractExpression.
    def visitExtractExpression(self, ctx:BaseRuleParser.ExtractExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#trimFunction.
    def visitTrimFunction(self, ctx:BaseRuleParser.TrimFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#regularFunction.
    def visitRegularFunction(self, ctx:BaseRuleParser.RegularFunctionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#regularFunctionName.
    def visitRegularFunctionName(self, ctx:BaseRuleParser.RegularFunctionNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#matchExpression.
    def visitMatchExpression(self, ctx:BaseRuleParser.MatchExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#caseExpression.
    def visitCaseExpression(self, ctx:BaseRuleParser.CaseExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#caseWhen.
    def visitCaseWhen(self, ctx:BaseRuleParser.CaseWhenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#caseElse.
    def visitCaseElse(self, ctx:BaseRuleParser.CaseElseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#intervalExpression.
    def visitIntervalExpression(self, ctx:BaseRuleParser.IntervalExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#intervalUnit.
    def visitIntervalUnit(self, ctx:BaseRuleParser.IntervalUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#subquery.
    def visitSubquery(self, ctx:BaseRuleParser.SubqueryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#dataType.
    def visitDataType(self, ctx:BaseRuleParser.DataTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#dataTypeName.
    def visitDataTypeName(self, ctx:BaseRuleParser.DataTypeNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#dataTypeLength.
    def visitDataTypeLength(self, ctx:BaseRuleParser.DataTypeLengthContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#characterSet.
    def visitCharacterSet(self, ctx:BaseRuleParser.CharacterSetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#collateClause.
    def visitCollateClause(self, ctx:BaseRuleParser.CollateClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by BaseRuleParser#ignoredIdentifier.
    def visitIgnoredIdentifier(self, ctx:BaseRuleParser.IgnoredIdentifierContext):
        return self.visitChildren(ctx)



del BaseRuleParser