// Generated from /home/junwen/code/sql-rewrite/sqlflex/grammar/BaseRule.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BaseRuleParser}.
 */
public interface BaseRuleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#parameterMarker}.
	 * @param ctx the parse tree
	 */
	void enterParameterMarker(BaseRuleParser.ParameterMarkerContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#parameterMarker}.
	 * @param ctx the parse tree
	 */
	void exitParameterMarker(BaseRuleParser.ParameterMarkerContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterLiterals(BaseRuleParser.LiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitLiterals(BaseRuleParser.LiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#asteriskLiteral}.
	 * @param ctx the parse tree
	 */
	void enterAsteriskLiteral(BaseRuleParser.AsteriskLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#asteriskLiteral}.
	 * @param ctx the parse tree
	 */
	void exitAsteriskLiteral(BaseRuleParser.AsteriskLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#stringLiterals}.
	 * @param ctx the parse tree
	 */
	void enterStringLiterals(BaseRuleParser.StringLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#stringLiterals}.
	 * @param ctx the parse tree
	 */
	void exitStringLiterals(BaseRuleParser.StringLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#numberLiterals}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiterals(BaseRuleParser.NumberLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#numberLiterals}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiterals(BaseRuleParser.NumberLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#dateTimeLiterals}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeLiterals(BaseRuleParser.DateTimeLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#dateTimeLiterals}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeLiterals(BaseRuleParser.DateTimeLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#hexadecimalLiterals}.
	 * @param ctx the parse tree
	 */
	void enterHexadecimalLiterals(BaseRuleParser.HexadecimalLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#hexadecimalLiterals}.
	 * @param ctx the parse tree
	 */
	void exitHexadecimalLiterals(BaseRuleParser.HexadecimalLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#bitValueLiterals}.
	 * @param ctx the parse tree
	 */
	void enterBitValueLiterals(BaseRuleParser.BitValueLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#bitValueLiterals}.
	 * @param ctx the parse tree
	 */
	void exitBitValueLiterals(BaseRuleParser.BitValueLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#booleanLiterals}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiterals(BaseRuleParser.BooleanLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#booleanLiterals}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiterals(BaseRuleParser.BooleanLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#nullValueLiterals}.
	 * @param ctx the parse tree
	 */
	void enterNullValueLiterals(BaseRuleParser.NullValueLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#nullValueLiterals}.
	 * @param ctx the parse tree
	 */
	void exitNullValueLiterals(BaseRuleParser.NullValueLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(BaseRuleParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(BaseRuleParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#unreservedWord}.
	 * @param ctx the parse tree
	 */
	void enterUnreservedWord(BaseRuleParser.UnreservedWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#unreservedWord}.
	 * @param ctx the parse tree
	 */
	void exitUnreservedWord(BaseRuleParser.UnreservedWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#allKeywords}.
	 * @param ctx the parse tree
	 */
	void enterAllKeywords(BaseRuleParser.AllKeywordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#allKeywords}.
	 * @param ctx the parse tree
	 */
	void exitAllKeywords(BaseRuleParser.AllKeywordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(BaseRuleParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(BaseRuleParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void enterSchemaName(BaseRuleParser.SchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void exitSchemaName(BaseRuleParser.SchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(BaseRuleParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(BaseRuleParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(BaseRuleParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(BaseRuleParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(BaseRuleParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(BaseRuleParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#unqualifiedShorthand}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedShorthand(BaseRuleParser.UnqualifiedShorthandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#unqualifiedShorthand}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedShorthand(BaseRuleParser.UnqualifiedShorthandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#qualifiedShorthand}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedShorthand(BaseRuleParser.QualifiedShorthandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#qualifiedShorthand}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedShorthand(BaseRuleParser.QualifiedShorthandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(BaseRuleParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(BaseRuleParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#owner}.
	 * @param ctx the parse tree
	 */
	void enterOwner(BaseRuleParser.OwnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#owner}.
	 * @param ctx the parse tree
	 */
	void exitOwner(BaseRuleParser.OwnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(BaseRuleParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(BaseRuleParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#constraintName}.
	 * @param ctx the parse tree
	 */
	void enterConstraintName(BaseRuleParser.ConstraintNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#constraintName}.
	 * @param ctx the parse tree
	 */
	void exitConstraintName(BaseRuleParser.ConstraintNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#columnNames}.
	 * @param ctx the parse tree
	 */
	void enterColumnNames(BaseRuleParser.ColumnNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#columnNames}.
	 * @param ctx the parse tree
	 */
	void exitColumnNames(BaseRuleParser.ColumnNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#tableNames}.
	 * @param ctx the parse tree
	 */
	void enterTableNames(BaseRuleParser.TableNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#tableNames}.
	 * @param ctx the parse tree
	 */
	void exitTableNames(BaseRuleParser.TableNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#characterSetName}.
	 * @param ctx the parse tree
	 */
	void enterCharacterSetName(BaseRuleParser.CharacterSetNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#characterSetName}.
	 * @param ctx the parse tree
	 */
	void exitCharacterSetName(BaseRuleParser.CharacterSetNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BaseRuleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BaseRuleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#exprOperator}.
	 * @param ctx the parse tree
	 */
	void enterExprOperator(BaseRuleParser.ExprOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#exprOperator}.
	 * @param ctx the parse tree
	 */
	void exitExprOperator(BaseRuleParser.ExprOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(BaseRuleParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(BaseRuleParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#exprListwithModifier}.
	 * @param ctx the parse tree
	 */
	void enterExprListwithModifier(BaseRuleParser.ExprListwithModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#exprListwithModifier}.
	 * @param ctx the parse tree
	 */
	void exitExprListwithModifier(BaseRuleParser.ExprListwithModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#notOperator}.
	 * @param ctx the parse tree
	 */
	void enterNotOperator(BaseRuleParser.NotOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#notOperator}.
	 * @param ctx the parse tree
	 */
	void exitNotOperator(BaseRuleParser.NotOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#booleanPrimary}.
	 * @param ctx the parse tree
	 */
	void enterBooleanPrimary(BaseRuleParser.BooleanPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#booleanPrimary}.
	 * @param ctx the parse tree
	 */
	void exitBooleanPrimary(BaseRuleParser.BooleanPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(BaseRuleParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(BaseRuleParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#isOperator}.
	 * @param ctx the parse tree
	 */
	void enterIsOperator(BaseRuleParser.IsOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#isOperator}.
	 * @param ctx the parse tree
	 */
	void exitIsOperator(BaseRuleParser.IsOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(BaseRuleParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(BaseRuleParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#inPredicate}.
	 * @param ctx the parse tree
	 */
	void enterInPredicate(BaseRuleParser.InPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#inPredicate}.
	 * @param ctx the parse tree
	 */
	void exitInPredicate(BaseRuleParser.InPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#betweenPredicate}.
	 * @param ctx the parse tree
	 */
	void enterBetweenPredicate(BaseRuleParser.BetweenPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#betweenPredicate}.
	 * @param ctx the parse tree
	 */
	void exitBetweenPredicate(BaseRuleParser.BetweenPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#likePredicate}.
	 * @param ctx the parse tree
	 */
	void enterLikePredicate(BaseRuleParser.LikePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#likePredicate}.
	 * @param ctx the parse tree
	 */
	void exitLikePredicate(BaseRuleParser.LikePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpr(BaseRuleParser.BitExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpr(BaseRuleParser.BitExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#bitOperator}.
	 * @param ctx the parse tree
	 */
	void enterBitOperator(BaseRuleParser.BitOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#bitOperator}.
	 * @param ctx the parse tree
	 */
	void exitBitOperator(BaseRuleParser.BitOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr(BaseRuleParser.SimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr(BaseRuleParser.SimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#mask_token}.
	 * @param ctx the parse tree
	 */
	void enterMask_token(BaseRuleParser.Mask_tokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#mask_token}.
	 * @param ctx the parse tree
	 */
	void exitMask_token(BaseRuleParser.Mask_tokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#paren_token}.
	 * @param ctx the parse tree
	 */
	void enterParen_token(BaseRuleParser.Paren_tokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#paren_token}.
	 * @param ctx the parse tree
	 */
	void exitParen_token(BaseRuleParser.Paren_tokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#existExpr}.
	 * @param ctx the parse tree
	 */
	void enterExistExpr(BaseRuleParser.ExistExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#existExpr}.
	 * @param ctx the parse tree
	 */
	void exitExistExpr(BaseRuleParser.ExistExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BaseRuleParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BaseRuleParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#aggregationFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregationFunction(BaseRuleParser.AggregationFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#aggregationFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregationFunction(BaseRuleParser.AggregationFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#aggregationFunctionName}.
	 * @param ctx the parse tree
	 */
	void enterAggregationFunctionName(BaseRuleParser.AggregationFunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#aggregationFunctionName}.
	 * @param ctx the parse tree
	 */
	void exitAggregationFunctionName(BaseRuleParser.AggregationFunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(BaseRuleParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(BaseRuleParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#specialFunction}.
	 * @param ctx the parse tree
	 */
	void enterSpecialFunction(BaseRuleParser.SpecialFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#specialFunction}.
	 * @param ctx the parse tree
	 */
	void exitSpecialFunction(BaseRuleParser.SpecialFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#castFunction}.
	 * @param ctx the parse tree
	 */
	void enterCastFunction(BaseRuleParser.CastFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#castFunction}.
	 * @param ctx the parse tree
	 */
	void exitCastFunction(BaseRuleParser.CastFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#convertFunction}.
	 * @param ctx the parse tree
	 */
	void enterConvertFunction(BaseRuleParser.ConvertFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#convertFunction}.
	 * @param ctx the parse tree
	 */
	void exitConvertFunction(BaseRuleParser.ConvertFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#positionFunction}.
	 * @param ctx the parse tree
	 */
	void enterPositionFunction(BaseRuleParser.PositionFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#positionFunction}.
	 * @param ctx the parse tree
	 */
	void exitPositionFunction(BaseRuleParser.PositionFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void enterSubstringFunction(BaseRuleParser.SubstringFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void exitSubstringFunction(BaseRuleParser.SubstringFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#extractFunction}.
	 * @param ctx the parse tree
	 */
	void enterExtractFunction(BaseRuleParser.ExtractFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#extractFunction}.
	 * @param ctx the parse tree
	 */
	void exitExtractFunction(BaseRuleParser.ExtractFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#trimFunction}.
	 * @param ctx the parse tree
	 */
	void enterTrimFunction(BaseRuleParser.TrimFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#trimFunction}.
	 * @param ctx the parse tree
	 */
	void exitTrimFunction(BaseRuleParser.TrimFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#regularFunction}.
	 * @param ctx the parse tree
	 */
	void enterRegularFunction(BaseRuleParser.RegularFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#regularFunction}.
	 * @param ctx the parse tree
	 */
	void exitRegularFunction(BaseRuleParser.RegularFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#regularFunctionName}.
	 * @param ctx the parse tree
	 */
	void enterRegularFunctionName(BaseRuleParser.RegularFunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#regularFunctionName}.
	 * @param ctx the parse tree
	 */
	void exitRegularFunctionName(BaseRuleParser.RegularFunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#matchExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatchExpression(BaseRuleParser.MatchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#matchExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatchExpression(BaseRuleParser.MatchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpression(BaseRuleParser.CaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpression(BaseRuleParser.CaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#caseWhen}.
	 * @param ctx the parse tree
	 */
	void enterCaseWhen(BaseRuleParser.CaseWhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#caseWhen}.
	 * @param ctx the parse tree
	 */
	void exitCaseWhen(BaseRuleParser.CaseWhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#caseElse}.
	 * @param ctx the parse tree
	 */
	void enterCaseElse(BaseRuleParser.CaseElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#caseElse}.
	 * @param ctx the parse tree
	 */
	void exitCaseElse(BaseRuleParser.CaseElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#intervalExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntervalExpression(BaseRuleParser.IntervalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#intervalExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntervalExpression(BaseRuleParser.IntervalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#intervalUnit}.
	 * @param ctx the parse tree
	 */
	void enterIntervalUnit(BaseRuleParser.IntervalUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#intervalUnit}.
	 * @param ctx the parse tree
	 */
	void exitIntervalUnit(BaseRuleParser.IntervalUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(BaseRuleParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(BaseRuleParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(BaseRuleParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(BaseRuleParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#dataTypeName}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeName(BaseRuleParser.DataTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#dataTypeName}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeName(BaseRuleParser.DataTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#dataTypeLength}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeLength(BaseRuleParser.DataTypeLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#dataTypeLength}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeLength(BaseRuleParser.DataTypeLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#characterSet}.
	 * @param ctx the parse tree
	 */
	void enterCharacterSet(BaseRuleParser.CharacterSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#characterSet}.
	 * @param ctx the parse tree
	 */
	void exitCharacterSet(BaseRuleParser.CharacterSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#collateClause}.
	 * @param ctx the parse tree
	 */
	void enterCollateClause(BaseRuleParser.CollateClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#collateClause}.
	 * @param ctx the parse tree
	 */
	void exitCollateClause(BaseRuleParser.CollateClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#ignoredIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterIgnoredIdentifier(BaseRuleParser.IgnoredIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#ignoredIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitIgnoredIdentifier(BaseRuleParser.IgnoredIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BaseRuleParser#dropBehaviour}.
	 * @param ctx the parse tree
	 */
	void enterDropBehaviour(BaseRuleParser.DropBehaviourContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseRuleParser#dropBehaviour}.
	 * @param ctx the parse tree
	 */
	void exitDropBehaviour(BaseRuleParser.DropBehaviourContext ctx);
}