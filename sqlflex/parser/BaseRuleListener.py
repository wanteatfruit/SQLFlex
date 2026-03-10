# Generated from ./BaseRule.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .BaseRuleParser import BaseRuleParser
else:
    from BaseRuleParser import BaseRuleParser

# This class defines a complete listener for a parse tree produced by BaseRuleParser.
class BaseRuleListener(ParseTreeListener):

    # Enter a parse tree produced by BaseRuleParser#parameterMarker.
    def enterParameterMarker(self, ctx:BaseRuleParser.ParameterMarkerContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#parameterMarker.
    def exitParameterMarker(self, ctx:BaseRuleParser.ParameterMarkerContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#literals.
    def enterLiterals(self, ctx:BaseRuleParser.LiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#literals.
    def exitLiterals(self, ctx:BaseRuleParser.LiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#asteriskLiteral.
    def enterAsteriskLiteral(self, ctx:BaseRuleParser.AsteriskLiteralContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#asteriskLiteral.
    def exitAsteriskLiteral(self, ctx:BaseRuleParser.AsteriskLiteralContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#stringLiterals.
    def enterStringLiterals(self, ctx:BaseRuleParser.StringLiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#stringLiterals.
    def exitStringLiterals(self, ctx:BaseRuleParser.StringLiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#numberLiterals.
    def enterNumberLiterals(self, ctx:BaseRuleParser.NumberLiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#numberLiterals.
    def exitNumberLiterals(self, ctx:BaseRuleParser.NumberLiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#dateTimeLiterals.
    def enterDateTimeLiterals(self, ctx:BaseRuleParser.DateTimeLiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#dateTimeLiterals.
    def exitDateTimeLiterals(self, ctx:BaseRuleParser.DateTimeLiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#hexadecimalLiterals.
    def enterHexadecimalLiterals(self, ctx:BaseRuleParser.HexadecimalLiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#hexadecimalLiterals.
    def exitHexadecimalLiterals(self, ctx:BaseRuleParser.HexadecimalLiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#bitValueLiterals.
    def enterBitValueLiterals(self, ctx:BaseRuleParser.BitValueLiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#bitValueLiterals.
    def exitBitValueLiterals(self, ctx:BaseRuleParser.BitValueLiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#booleanLiterals.
    def enterBooleanLiterals(self, ctx:BaseRuleParser.BooleanLiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#booleanLiterals.
    def exitBooleanLiterals(self, ctx:BaseRuleParser.BooleanLiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#nullValueLiterals.
    def enterNullValueLiterals(self, ctx:BaseRuleParser.NullValueLiteralsContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#nullValueLiterals.
    def exitNullValueLiterals(self, ctx:BaseRuleParser.NullValueLiteralsContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#identifier.
    def enterIdentifier(self, ctx:BaseRuleParser.IdentifierContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#identifier.
    def exitIdentifier(self, ctx:BaseRuleParser.IdentifierContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#unreservedWord.
    def enterUnreservedWord(self, ctx:BaseRuleParser.UnreservedWordContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#unreservedWord.
    def exitUnreservedWord(self, ctx:BaseRuleParser.UnreservedWordContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#reservedWord.
    def enterReservedWord(self, ctx:BaseRuleParser.ReservedWordContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#reservedWord.
    def exitReservedWord(self, ctx:BaseRuleParser.ReservedWordContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#variable.
    def enterVariable(self, ctx:BaseRuleParser.VariableContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#variable.
    def exitVariable(self, ctx:BaseRuleParser.VariableContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#schemaName.
    def enterSchemaName(self, ctx:BaseRuleParser.SchemaNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#schemaName.
    def exitSchemaName(self, ctx:BaseRuleParser.SchemaNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#tableName.
    def enterTableName(self, ctx:BaseRuleParser.TableNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#tableName.
    def exitTableName(self, ctx:BaseRuleParser.TableNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#columnName.
    def enterColumnName(self, ctx:BaseRuleParser.ColumnNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#columnName.
    def exitColumnName(self, ctx:BaseRuleParser.ColumnNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#tableAlias.
    def enterTableAlias(self, ctx:BaseRuleParser.TableAliasContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#tableAlias.
    def exitTableAlias(self, ctx:BaseRuleParser.TableAliasContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#unqualifiedShorthand.
    def enterUnqualifiedShorthand(self, ctx:BaseRuleParser.UnqualifiedShorthandContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#unqualifiedShorthand.
    def exitUnqualifiedShorthand(self, ctx:BaseRuleParser.UnqualifiedShorthandContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#qualifiedShorthand.
    def enterQualifiedShorthand(self, ctx:BaseRuleParser.QualifiedShorthandContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#qualifiedShorthand.
    def exitQualifiedShorthand(self, ctx:BaseRuleParser.QualifiedShorthandContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#owner.
    def enterOwner(self, ctx:BaseRuleParser.OwnerContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#owner.
    def exitOwner(self, ctx:BaseRuleParser.OwnerContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#name.
    def enterName(self, ctx:BaseRuleParser.NameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#name.
    def exitName(self, ctx:BaseRuleParser.NameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#constraintName.
    def enterConstraintName(self, ctx:BaseRuleParser.ConstraintNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#constraintName.
    def exitConstraintName(self, ctx:BaseRuleParser.ConstraintNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#columnNames.
    def enterColumnNames(self, ctx:BaseRuleParser.ColumnNamesContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#columnNames.
    def exitColumnNames(self, ctx:BaseRuleParser.ColumnNamesContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#tableNames.
    def enterTableNames(self, ctx:BaseRuleParser.TableNamesContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#tableNames.
    def exitTableNames(self, ctx:BaseRuleParser.TableNamesContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#characterSetName.
    def enterCharacterSetName(self, ctx:BaseRuleParser.CharacterSetNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#characterSetName.
    def exitCharacterSetName(self, ctx:BaseRuleParser.CharacterSetNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#expr.
    def enterExpr(self, ctx:BaseRuleParser.ExprContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#expr.
    def exitExpr(self, ctx:BaseRuleParser.ExprContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#andOperator.
    def enterAndOperator(self, ctx:BaseRuleParser.AndOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#andOperator.
    def exitAndOperator(self, ctx:BaseRuleParser.AndOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#orOperator.
    def enterOrOperator(self, ctx:BaseRuleParser.OrOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#orOperator.
    def exitOrOperator(self, ctx:BaseRuleParser.OrOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#exprList.
    def enterExprList(self, ctx:BaseRuleParser.ExprListContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#exprList.
    def exitExprList(self, ctx:BaseRuleParser.ExprListContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#exprListwithModifier.
    def enterExprListwithModifier(self, ctx:BaseRuleParser.ExprListwithModifierContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#exprListwithModifier.
    def exitExprListwithModifier(self, ctx:BaseRuleParser.ExprListwithModifierContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#notOperator.
    def enterNotOperator(self, ctx:BaseRuleParser.NotOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#notOperator.
    def exitNotOperator(self, ctx:BaseRuleParser.NotOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#booleanPrimary.
    def enterBooleanPrimary(self, ctx:BaseRuleParser.BooleanPrimaryContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#booleanPrimary.
    def exitBooleanPrimary(self, ctx:BaseRuleParser.BooleanPrimaryContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#comparisonOperator.
    def enterComparisonOperator(self, ctx:BaseRuleParser.ComparisonOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#comparisonOperator.
    def exitComparisonOperator(self, ctx:BaseRuleParser.ComparisonOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#isOperator.
    def enterIsOperator(self, ctx:BaseRuleParser.IsOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#isOperator.
    def exitIsOperator(self, ctx:BaseRuleParser.IsOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#predicate.
    def enterPredicate(self, ctx:BaseRuleParser.PredicateContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#predicate.
    def exitPredicate(self, ctx:BaseRuleParser.PredicateContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#inPredicate.
    def enterInPredicate(self, ctx:BaseRuleParser.InPredicateContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#inPredicate.
    def exitInPredicate(self, ctx:BaseRuleParser.InPredicateContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#betweenPredicate.
    def enterBetweenPredicate(self, ctx:BaseRuleParser.BetweenPredicateContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#betweenPredicate.
    def exitBetweenPredicate(self, ctx:BaseRuleParser.BetweenPredicateContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#likePredicate.
    def enterLikePredicate(self, ctx:BaseRuleParser.LikePredicateContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#likePredicate.
    def exitLikePredicate(self, ctx:BaseRuleParser.LikePredicateContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#bitExpr.
    def enterBitExpr(self, ctx:BaseRuleParser.BitExprContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#bitExpr.
    def exitBitExpr(self, ctx:BaseRuleParser.BitExprContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#logicalBitOperator.
    def enterLogicalBitOperator(self, ctx:BaseRuleParser.LogicalBitOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#logicalBitOperator.
    def exitLogicalBitOperator(self, ctx:BaseRuleParser.LogicalBitOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#multiplyBitOperator.
    def enterMultiplyBitOperator(self, ctx:BaseRuleParser.MultiplyBitOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#multiplyBitOperator.
    def exitMultiplyBitOperator(self, ctx:BaseRuleParser.MultiplyBitOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#plusBitOperator.
    def enterPlusBitOperator(self, ctx:BaseRuleParser.PlusBitOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#plusBitOperator.
    def exitPlusBitOperator(self, ctx:BaseRuleParser.PlusBitOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#concatBitOperator.
    def enterConcatBitOperator(self, ctx:BaseRuleParser.ConcatBitOperatorContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#concatBitOperator.
    def exitConcatBitOperator(self, ctx:BaseRuleParser.ConcatBitOperatorContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#simpleExpr.
    def enterSimpleExpr(self, ctx:BaseRuleParser.SimpleExprContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#simpleExpr.
    def exitSimpleExpr(self, ctx:BaseRuleParser.SimpleExprContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#mask_token.
    def enterMask_token(self, ctx:BaseRuleParser.Mask_tokenContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#mask_token.
    def exitMask_token(self, ctx:BaseRuleParser.Mask_tokenContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#paren_token.
    def enterParen_token(self, ctx:BaseRuleParser.Paren_tokenContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#paren_token.
    def exitParen_token(self, ctx:BaseRuleParser.Paren_tokenContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#existExpr.
    def enterExistExpr(self, ctx:BaseRuleParser.ExistExprContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#existExpr.
    def exitExistExpr(self, ctx:BaseRuleParser.ExistExprContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#uniqueExpr.
    def enterUniqueExpr(self, ctx:BaseRuleParser.UniqueExprContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#uniqueExpr.
    def exitUniqueExpr(self, ctx:BaseRuleParser.UniqueExprContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#functionCall.
    def enterFunctionCall(self, ctx:BaseRuleParser.FunctionCallContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#functionCall.
    def exitFunctionCall(self, ctx:BaseRuleParser.FunctionCallContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#aggregationFunction.
    def enterAggregationFunction(self, ctx:BaseRuleParser.AggregationFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#aggregationFunction.
    def exitAggregationFunction(self, ctx:BaseRuleParser.AggregationFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#aggregationFunctionName.
    def enterAggregationFunctionName(self, ctx:BaseRuleParser.AggregationFunctionNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#aggregationFunctionName.
    def exitAggregationFunctionName(self, ctx:BaseRuleParser.AggregationFunctionNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#modifier.
    def enterModifier(self, ctx:BaseRuleParser.ModifierContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#modifier.
    def exitModifier(self, ctx:BaseRuleParser.ModifierContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#specialFunction.
    def enterSpecialFunction(self, ctx:BaseRuleParser.SpecialFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#specialFunction.
    def exitSpecialFunction(self, ctx:BaseRuleParser.SpecialFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#castFunction.
    def enterCastFunction(self, ctx:BaseRuleParser.CastFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#castFunction.
    def exitCastFunction(self, ctx:BaseRuleParser.CastFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#castExpression.
    def enterCastExpression(self, ctx:BaseRuleParser.CastExpressionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#castExpression.
    def exitCastExpression(self, ctx:BaseRuleParser.CastExpressionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#convertFunction.
    def enterConvertFunction(self, ctx:BaseRuleParser.ConvertFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#convertFunction.
    def exitConvertFunction(self, ctx:BaseRuleParser.ConvertFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#positionFunction.
    def enterPositionFunction(self, ctx:BaseRuleParser.PositionFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#positionFunction.
    def exitPositionFunction(self, ctx:BaseRuleParser.PositionFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#substringFunction.
    def enterSubstringFunction(self, ctx:BaseRuleParser.SubstringFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#substringFunction.
    def exitSubstringFunction(self, ctx:BaseRuleParser.SubstringFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#extractFunction.
    def enterExtractFunction(self, ctx:BaseRuleParser.ExtractFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#extractFunction.
    def exitExtractFunction(self, ctx:BaseRuleParser.ExtractFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#extractExpression.
    def enterExtractExpression(self, ctx:BaseRuleParser.ExtractExpressionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#extractExpression.
    def exitExtractExpression(self, ctx:BaseRuleParser.ExtractExpressionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#trimFunction.
    def enterTrimFunction(self, ctx:BaseRuleParser.TrimFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#trimFunction.
    def exitTrimFunction(self, ctx:BaseRuleParser.TrimFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#regularFunction.
    def enterRegularFunction(self, ctx:BaseRuleParser.RegularFunctionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#regularFunction.
    def exitRegularFunction(self, ctx:BaseRuleParser.RegularFunctionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#regularFunctionName.
    def enterRegularFunctionName(self, ctx:BaseRuleParser.RegularFunctionNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#regularFunctionName.
    def exitRegularFunctionName(self, ctx:BaseRuleParser.RegularFunctionNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#matchExpression.
    def enterMatchExpression(self, ctx:BaseRuleParser.MatchExpressionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#matchExpression.
    def exitMatchExpression(self, ctx:BaseRuleParser.MatchExpressionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#caseExpression.
    def enterCaseExpression(self, ctx:BaseRuleParser.CaseExpressionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#caseExpression.
    def exitCaseExpression(self, ctx:BaseRuleParser.CaseExpressionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#caseWhen.
    def enterCaseWhen(self, ctx:BaseRuleParser.CaseWhenContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#caseWhen.
    def exitCaseWhen(self, ctx:BaseRuleParser.CaseWhenContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#caseElse.
    def enterCaseElse(self, ctx:BaseRuleParser.CaseElseContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#caseElse.
    def exitCaseElse(self, ctx:BaseRuleParser.CaseElseContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#intervalExpression.
    def enterIntervalExpression(self, ctx:BaseRuleParser.IntervalExpressionContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#intervalExpression.
    def exitIntervalExpression(self, ctx:BaseRuleParser.IntervalExpressionContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#intervalUnit.
    def enterIntervalUnit(self, ctx:BaseRuleParser.IntervalUnitContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#intervalUnit.
    def exitIntervalUnit(self, ctx:BaseRuleParser.IntervalUnitContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#subquery.
    def enterSubquery(self, ctx:BaseRuleParser.SubqueryContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#subquery.
    def exitSubquery(self, ctx:BaseRuleParser.SubqueryContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#dataType.
    def enterDataType(self, ctx:BaseRuleParser.DataTypeContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#dataType.
    def exitDataType(self, ctx:BaseRuleParser.DataTypeContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#dataTypeName.
    def enterDataTypeName(self, ctx:BaseRuleParser.DataTypeNameContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#dataTypeName.
    def exitDataTypeName(self, ctx:BaseRuleParser.DataTypeNameContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#dataTypeLength.
    def enterDataTypeLength(self, ctx:BaseRuleParser.DataTypeLengthContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#dataTypeLength.
    def exitDataTypeLength(self, ctx:BaseRuleParser.DataTypeLengthContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#characterSet.
    def enterCharacterSet(self, ctx:BaseRuleParser.CharacterSetContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#characterSet.
    def exitCharacterSet(self, ctx:BaseRuleParser.CharacterSetContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#collateClause.
    def enterCollateClause(self, ctx:BaseRuleParser.CollateClauseContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#collateClause.
    def exitCollateClause(self, ctx:BaseRuleParser.CollateClauseContext):
        pass


    # Enter a parse tree produced by BaseRuleParser#ignoredIdentifier.
    def enterIgnoredIdentifier(self, ctx:BaseRuleParser.IgnoredIdentifierContext):
        pass

    # Exit a parse tree produced by BaseRuleParser#ignoredIdentifier.
    def exitIgnoredIdentifier(self, ctx:BaseRuleParser.IgnoredIdentifierContext):
        pass



del BaseRuleParser