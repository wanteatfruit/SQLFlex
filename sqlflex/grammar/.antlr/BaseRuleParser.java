// Generated from /home/junwen/code/sql-rewrite/sqlflex/grammar/BaseRule.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BaseRuleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, AND_=2, CONCAT_=3, NOT_=4, TILDE_=5, VERTICAL_BAR_=6, AMPERSAND_=7, 
		SIGNED_LEFT_SHIFT_=8, SIGNED_RIGHT_SHIFT_=9, CARET_=10, MOD_=11, COLON_=12, 
		PLUS_=13, MINUS_=14, ASTERISK_=15, SLASH_=16, BACKSLASH_=17, DOT_=18, 
		DOT_ASTERISK_=19, SAFE_EQ_=20, DEQ_=21, EQ_=22, NEQ_=23, GT_=24, GTE_=25, 
		LT_=26, LTE_=27, POUND_=28, LP_=29, RP_=30, LBE_=31, RBE_=32, LBT_=33, 
		RBT_=34, COMMA_=35, DQ_=36, SQ_=37, QUESTION_=38, AT_=39, SEMI_=40, WS=41, 
		SELECT=42, INSERT=43, UPDATE=44, DELETE=45, CREATE=46, ALTER=47, DROP=48, 
		TRUNCATE=49, SCHEMA=50, GRANT=51, REVOKE=52, ADD=53, SET=54, TABLE=55, 
		COLUMN=56, INDEX=57, CONSTRAINT=58, PRIMARY=59, UNIQUE=60, FOREIGN=61, 
		KEY=62, POSITION=63, PRECISION=64, FUNCTION=65, TRIGGER=66, PROCEDURE=67, 
		VIEW=68, INTO=69, VALUES=70, VALUE=71, WITH=72, UNION=73, DISTINCT=74, 
		CASE=75, WHEN=76, CAST=77, TRIM=78, SUBSTRING=79, FROM=80, NATURAL=81, 
		JOIN=82, FULL=83, INNER=84, OUTER=85, LEFT=86, RIGHT=87, CROSS=88, USING=89, 
		WHERE=90, AS=91, ON=92, IF=93, ELSE=94, THEN=95, FOR=96, TO=97, AND=98, 
		OR=99, IS=100, NOT=101, NULL=102, TRUE=103, FALSE=104, EXISTS=105, BETWEEN=106, 
		IN=107, ALL=108, ANY=109, LIKE=110, ORDER=111, GROUP=112, BY=113, ASC=114, 
		DESC=115, HAVING=116, LIMIT=117, OFFSET=118, BEGIN=119, COMMIT=120, ROLLBACK=121, 
		SAVEPOINT=122, BOOLEAN=123, DOUBLE=124, CHAR=125, CHARACTER=126, ARRAY=127, 
		INTERVAL=128, DATE=129, TIME=130, TIMESTAMP=131, LOCALTIME=132, LOCALTIMESTAMP=133, 
		YEAR=134, QUARTER=135, MONTH=136, WEEK=137, DAY=138, HOUR=139, MINUTE=140, 
		SECOND=141, MICROSECOND=142, MAX=143, MIN=144, SUM=145, COUNT=146, AVG=147, 
		DEFAULT=148, CURRENT=149, ENABLE=150, DISABLE=151, CALL=152, INSTANCE=153, 
		PRESERVE=154, DO=155, DEFINER=156, CURRENT_USER=157, SQL=158, CASCADED=159, 
		LOCAL=160, CLOSE=161, OPEN=162, NEXT=163, NAME=164, COLLATION=165, NAMES=166, 
		INTEGER=167, REAL=168, DECIMAL=169, TYPE=170, VARCHAR=171, FLOAT=172, 
		FOR_GENERATOR=173, INTERSECT=174, EXCEPT=175, GLOBAL=176, UNKNOWN=177, 
		ESCAPE=178, COLLATE=179, CONVERT=180, EXTRACT=181, LEADING=182, BOTH=183, 
		TRAILING=184, CURRENT_TIMESTAMP=185, MATCH=186, PARTIAL=187, END=188, 
		VARYING=189, NATIONAL=190, NCHAR=191, BIT=192, NUMERIC=193, DEC=194, SMALLINT=195, 
		ZONE=196, CASCADE=197, RESTRICT=198, IDENTIFIER_=199, MASK_TOKEN=200, 
		PAREN_TOKEN=201, STRING_=202, NUMBER_=203, HEX_DIGIT_=204, BIT_NUM_=205, 
		ADA=206, C92=207, CATALOG_NAME=208, CHARACTER_SET_CATALOG=209, CHARACTER_SET_NAME=210, 
		CHARACTER_SET_SCHEMA=211, CLASS_ORIGIN=212, COBOL=213, COLLATION_CATALOG=214, 
		COLLATION_NAME=215, COLLATION_SCHEMA=216, COLUMN_NAME=217, COMMAND_FUNCTION=218, 
		COMMITTED=219, CONDITION_NUMBER=220, CONNECTION_NAME=221, CONSTRAINT_CATALOG=222, 
		CONSTRAINT_NAME=223, CONSTRAINT_SCHEMA=224, CURSOR_NAME=225, DATA=226, 
		DATETIME_INTERVAL_CODE=227, DATETIME_INTERVAL_PRECISION=228, DYNAMIC_FUNCTION=229, 
		FORTRAN=230, LENGTH=231, MESSAGE_LENGTH=232, MESSAGE_OCTET_LENGTH=233, 
		MESSAGE_TEXT=234, MORE92=235, MUMPS=236, NULLABLE=237, NUMBER=238, PASCAL=239, 
		PLI=240, REPEATABLE=241, RETURNED_LENGTH=242, RETURNED_OCTET_LENGTH=243, 
		RETURNED_SQLSTATE=244, ROW_COUNT=245, SCALE=246, SCHEMA_NAME=247, SERIALIZABLE=248, 
		SERVER_NAME=249, SUBCLASS_ORIGIN=250, TABLE_NAME=251, UNCOMMITTED=252, 
		UNNAMED=253;
	public static final int
		RULE_parameterMarker = 0, RULE_literals = 1, RULE_asteriskLiteral = 2, 
		RULE_stringLiterals = 3, RULE_numberLiterals = 4, RULE_dateTimeLiterals = 5, 
		RULE_hexadecimalLiterals = 6, RULE_bitValueLiterals = 7, RULE_booleanLiterals = 8, 
		RULE_nullValueLiterals = 9, RULE_identifier = 10, RULE_unreservedWord = 11, 
		RULE_allKeywords = 12, RULE_variable = 13, RULE_schemaName = 14, RULE_tableName = 15, 
		RULE_columnName = 16, RULE_alias = 17, RULE_unqualifiedShorthand = 18, 
		RULE_qualifiedShorthand = 19, RULE_viewName = 20, RULE_owner = 21, RULE_name = 22, 
		RULE_constraintName = 23, RULE_columnNames = 24, RULE_tableNames = 25, 
		RULE_characterSetName = 26, RULE_expr = 27, RULE_exprOperator = 28, RULE_exprList = 29, 
		RULE_exprListwithModifier = 30, RULE_notOperator = 31, RULE_booleanPrimary = 32, 
		RULE_comparisonOperator = 33, RULE_isOperator = 34, RULE_predicate = 35, 
		RULE_inPredicate = 36, RULE_betweenPredicate = 37, RULE_likePredicate = 38, 
		RULE_bitExpr = 39, RULE_bitOperator = 40, RULE_simpleExpr = 41, RULE_mask_token = 42, 
		RULE_paren_token = 43, RULE_existExpr = 44, RULE_functionCall = 45, RULE_aggregationFunction = 46, 
		RULE_aggregationFunctionName = 47, RULE_modifier = 48, RULE_specialFunction = 49, 
		RULE_castFunction = 50, RULE_convertFunction = 51, RULE_positionFunction = 52, 
		RULE_substringFunction = 53, RULE_extractFunction = 54, RULE_trimFunction = 55, 
		RULE_regularFunction = 56, RULE_regularFunctionName = 57, RULE_matchExpression = 58, 
		RULE_caseExpression = 59, RULE_caseWhen = 60, RULE_caseElse = 61, RULE_intervalExpression = 62, 
		RULE_intervalUnit = 63, RULE_subquery = 64, RULE_dataType = 65, RULE_dataTypeName = 66, 
		RULE_dataTypeLength = 67, RULE_characterSet = 68, RULE_collateClause = 69, 
		RULE_ignoredIdentifier = 70, RULE_dropBehaviour = 71;
	private static String[] makeRuleNames() {
		return new String[] {
			"parameterMarker", "literals", "asteriskLiteral", "stringLiterals", "numberLiterals", 
			"dateTimeLiterals", "hexadecimalLiterals", "bitValueLiterals", "booleanLiterals", 
			"nullValueLiterals", "identifier", "unreservedWord", "allKeywords", "variable", 
			"schemaName", "tableName", "columnName", "alias", "unqualifiedShorthand", 
			"qualifiedShorthand", "viewName", "owner", "name", "constraintName", 
			"columnNames", "tableNames", "characterSetName", "expr", "exprOperator", 
			"exprList", "exprListwithModifier", "notOperator", "booleanPrimary", 
			"comparisonOperator", "isOperator", "predicate", "inPredicate", "betweenPredicate", 
			"likePredicate", "bitExpr", "bitOperator", "simpleExpr", "mask_token", 
			"paren_token", "existExpr", "functionCall", "aggregationFunction", "aggregationFunctionName", 
			"modifier", "specialFunction", "castFunction", "convertFunction", "positionFunction", 
			"substringFunction", "extractFunction", "trimFunction", "regularFunction", 
			"regularFunctionName", "matchExpression", "caseExpression", "caseWhen", 
			"caseElse", "intervalExpression", "intervalUnit", "subquery", "dataType", 
			"dataTypeName", "dataTypeLength", "characterSet", "collateClause", "ignoredIdentifier", 
			"dropBehaviour"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Default does not match anything'", "'&&'", "'||'", "'!'", "'~'", 
			"'|'", "'&'", "'<<'", "'>>'", "'^'", "'%'", "':'", "'+'", "'-'", "'*'", 
			"'/'", "'\\'", "'.'", "'.*'", "'<=>'", "'=='", "'='", null, "'>'", "'>='", 
			"'<'", "'<='", "'#'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", 
			"'\"'", "'''", "'?'", "'@'", "';'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'DO NOT MATCH ANY THING, JUST FOR GENERATOR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "AND_", "CONCAT_", "NOT_", "TILDE_", "VERTICAL_BAR_", "AMPERSAND_", 
			"SIGNED_LEFT_SHIFT_", "SIGNED_RIGHT_SHIFT_", "CARET_", "MOD_", "COLON_", 
			"PLUS_", "MINUS_", "ASTERISK_", "SLASH_", "BACKSLASH_", "DOT_", "DOT_ASTERISK_", 
			"SAFE_EQ_", "DEQ_", "EQ_", "NEQ_", "GT_", "GTE_", "LT_", "LTE_", "POUND_", 
			"LP_", "RP_", "LBE_", "RBE_", "LBT_", "RBT_", "COMMA_", "DQ_", "SQ_", 
			"QUESTION_", "AT_", "SEMI_", "WS", "SELECT", "INSERT", "UPDATE", "DELETE", 
			"CREATE", "ALTER", "DROP", "TRUNCATE", "SCHEMA", "GRANT", "REVOKE", "ADD", 
			"SET", "TABLE", "COLUMN", "INDEX", "CONSTRAINT", "PRIMARY", "UNIQUE", 
			"FOREIGN", "KEY", "POSITION", "PRECISION", "FUNCTION", "TRIGGER", "PROCEDURE", 
			"VIEW", "INTO", "VALUES", "VALUE", "WITH", "UNION", "DISTINCT", "CASE", 
			"WHEN", "CAST", "TRIM", "SUBSTRING", "FROM", "NATURAL", "JOIN", "FULL", 
			"INNER", "OUTER", "LEFT", "RIGHT", "CROSS", "USING", "WHERE", "AS", "ON", 
			"IF", "ELSE", "THEN", "FOR", "TO", "AND", "OR", "IS", "NOT", "NULL", 
			"TRUE", "FALSE", "EXISTS", "BETWEEN", "IN", "ALL", "ANY", "LIKE", "ORDER", 
			"GROUP", "BY", "ASC", "DESC", "HAVING", "LIMIT", "OFFSET", "BEGIN", "COMMIT", 
			"ROLLBACK", "SAVEPOINT", "BOOLEAN", "DOUBLE", "CHAR", "CHARACTER", "ARRAY", 
			"INTERVAL", "DATE", "TIME", "TIMESTAMP", "LOCALTIME", "LOCALTIMESTAMP", 
			"YEAR", "QUARTER", "MONTH", "WEEK", "DAY", "HOUR", "MINUTE", "SECOND", 
			"MICROSECOND", "MAX", "MIN", "SUM", "COUNT", "AVG", "DEFAULT", "CURRENT", 
			"ENABLE", "DISABLE", "CALL", "INSTANCE", "PRESERVE", "DO", "DEFINER", 
			"CURRENT_USER", "SQL", "CASCADED", "LOCAL", "CLOSE", "OPEN", "NEXT", 
			"NAME", "COLLATION", "NAMES", "INTEGER", "REAL", "DECIMAL", "TYPE", "VARCHAR", 
			"FLOAT", "FOR_GENERATOR", "INTERSECT", "EXCEPT", "GLOBAL", "UNKNOWN", 
			"ESCAPE", "COLLATE", "CONVERT", "EXTRACT", "LEADING", "BOTH", "TRAILING", 
			"CURRENT_TIMESTAMP", "MATCH", "PARTIAL", "END", "VARYING", "NATIONAL", 
			"NCHAR", "BIT", "NUMERIC", "DEC", "SMALLINT", "ZONE", "CASCADE", "RESTRICT", 
			"IDENTIFIER_", "MASK_TOKEN", "PAREN_TOKEN", "STRING_", "NUMBER_", "HEX_DIGIT_", 
			"BIT_NUM_", "ADA", "C92", "CATALOG_NAME", "CHARACTER_SET_CATALOG", "CHARACTER_SET_NAME", 
			"CHARACTER_SET_SCHEMA", "CLASS_ORIGIN", "COBOL", "COLLATION_CATALOG", 
			"COLLATION_NAME", "COLLATION_SCHEMA", "COLUMN_NAME", "COMMAND_FUNCTION", 
			"COMMITTED", "CONDITION_NUMBER", "CONNECTION_NAME", "CONSTRAINT_CATALOG", 
			"CONSTRAINT_NAME", "CONSTRAINT_SCHEMA", "CURSOR_NAME", "DATA", "DATETIME_INTERVAL_CODE", 
			"DATETIME_INTERVAL_PRECISION", "DYNAMIC_FUNCTION", "FORTRAN", "LENGTH", 
			"MESSAGE_LENGTH", "MESSAGE_OCTET_LENGTH", "MESSAGE_TEXT", "MORE92", "MUMPS", 
			"NULLABLE", "NUMBER", "PASCAL", "PLI", "REPEATABLE", "RETURNED_LENGTH", 
			"RETURNED_OCTET_LENGTH", "RETURNED_SQLSTATE", "ROW_COUNT", "SCALE", "SCHEMA_NAME", 
			"SERIALIZABLE", "SERVER_NAME", "SUBCLASS_ORIGIN", "TABLE_NAME", "UNCOMMITTED", 
			"UNNAMED"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BaseRule.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BaseRuleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterMarkerContext extends ParserRuleContext {
		public TerminalNode QUESTION_() { return getToken(BaseRuleParser.QUESTION_, 0); }
		public ParameterMarkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterMarker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterParameterMarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitParameterMarker(this);
		}
	}

	public final ParameterMarkerContext parameterMarker() throws RecognitionException {
		ParameterMarkerContext _localctx = new ParameterMarkerContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parameterMarker);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(QUESTION_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralsContext extends ParserRuleContext {
		public StringLiteralsContext stringLiterals() {
			return getRuleContext(StringLiteralsContext.class,0);
		}
		public NumberLiteralsContext numberLiterals() {
			return getRuleContext(NumberLiteralsContext.class,0);
		}
		public DateTimeLiteralsContext dateTimeLiterals() {
			return getRuleContext(DateTimeLiteralsContext.class,0);
		}
		public HexadecimalLiteralsContext hexadecimalLiterals() {
			return getRuleContext(HexadecimalLiteralsContext.class,0);
		}
		public BitValueLiteralsContext bitValueLiterals() {
			return getRuleContext(BitValueLiteralsContext.class,0);
		}
		public BooleanLiteralsContext booleanLiterals() {
			return getRuleContext(BooleanLiteralsContext.class,0);
		}
		public NullValueLiteralsContext nullValueLiterals() {
			return getRuleContext(NullValueLiteralsContext.class,0);
		}
		public AsteriskLiteralContext asteriskLiteral() {
			return getRuleContext(AsteriskLiteralContext.class,0);
		}
		public LiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitLiterals(this);
		}
	}

	public final LiteralsContext literals() throws RecognitionException {
		LiteralsContext _localctx = new LiteralsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_literals);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				stringLiterals();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				numberLiterals();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				dateTimeLiterals();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				hexadecimalLiterals();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				bitValueLiterals();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				booleanLiterals();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(152);
				nullValueLiterals();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(153);
				asteriskLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsteriskLiteralContext extends ParserRuleContext {
		public TerminalNode ASTERISK_() { return getToken(BaseRuleParser.ASTERISK_, 0); }
		public AsteriskLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asteriskLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterAsteriskLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitAsteriskLiteral(this);
		}
	}

	public final AsteriskLiteralContext asteriskLiteral() throws RecognitionException {
		AsteriskLiteralContext _localctx = new AsteriskLiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_asteriskLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ASTERISK_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralsContext extends ParserRuleContext {
		public TerminalNode STRING_() { return getToken(BaseRuleParser.STRING_, 0); }
		public CharacterSetNameContext characterSetName() {
			return getRuleContext(CharacterSetNameContext.class,0);
		}
		public CollateClauseContext collateClause() {
			return getRuleContext(CollateClauseContext.class,0);
		}
		public StringLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterStringLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitStringLiterals(this);
		}
	}

	public final StringLiteralsContext stringLiterals() throws RecognitionException {
		StringLiteralsContext _localctx = new StringLiteralsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stringLiterals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER_) {
				{
				setState(158);
				characterSetName();
				}
			}

			setState(161);
			match(STRING_);
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(162);
				collateClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralsContext extends ParserRuleContext {
		public TerminalNode NUMBER_() { return getToken(BaseRuleParser.NUMBER_, 0); }
		public TerminalNode PLUS_() { return getToken(BaseRuleParser.PLUS_, 0); }
		public TerminalNode MINUS_() { return getToken(BaseRuleParser.MINUS_, 0); }
		public NumberLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterNumberLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitNumberLiterals(this);
		}
	}

	public final NumberLiteralsContext numberLiterals() throws RecognitionException {
		NumberLiteralsContext _localctx = new NumberLiteralsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_numberLiterals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS_ || _la==MINUS_) {
				{
				setState(165);
				_la = _input.LA(1);
				if ( !(_la==PLUS_ || _la==MINUS_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(168);
			match(NUMBER_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeLiteralsContext extends ParserRuleContext {
		public TerminalNode STRING_() { return getToken(BaseRuleParser.STRING_, 0); }
		public TerminalNode DATE() { return getToken(BaseRuleParser.DATE, 0); }
		public TerminalNode TIME() { return getToken(BaseRuleParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(BaseRuleParser.TIMESTAMP, 0); }
		public TerminalNode LBE_() { return getToken(BaseRuleParser.LBE_, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RBE_() { return getToken(BaseRuleParser.RBE_, 0); }
		public DateTimeLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateTimeLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterDateTimeLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitDateTimeLiterals(this);
		}
	}

	public final DateTimeLiteralsContext dateTimeLiterals() throws RecognitionException {
		DateTimeLiteralsContext _localctx = new DateTimeLiteralsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dateTimeLiterals);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				_la = _input.LA(1);
				if ( !(((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & 7L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(171);
				match(STRING_);
				}
				break;
			case LBE_:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(LBE_);
				setState(173);
				identifier();
				setState(174);
				match(STRING_);
				setState(175);
				match(RBE_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HexadecimalLiteralsContext extends ParserRuleContext {
		public TerminalNode HEX_DIGIT_() { return getToken(BaseRuleParser.HEX_DIGIT_, 0); }
		public CharacterSetNameContext characterSetName() {
			return getRuleContext(CharacterSetNameContext.class,0);
		}
		public CollateClauseContext collateClause() {
			return getRuleContext(CollateClauseContext.class,0);
		}
		public HexadecimalLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexadecimalLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterHexadecimalLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitHexadecimalLiterals(this);
		}
	}

	public final HexadecimalLiteralsContext hexadecimalLiterals() throws RecognitionException {
		HexadecimalLiteralsContext _localctx = new HexadecimalLiteralsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_hexadecimalLiterals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER_) {
				{
				setState(179);
				characterSetName();
				}
			}

			setState(182);
			match(HEX_DIGIT_);
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(183);
				collateClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitValueLiteralsContext extends ParserRuleContext {
		public TerminalNode BIT_NUM_() { return getToken(BaseRuleParser.BIT_NUM_, 0); }
		public CharacterSetNameContext characterSetName() {
			return getRuleContext(CharacterSetNameContext.class,0);
		}
		public CollateClauseContext collateClause() {
			return getRuleContext(CollateClauseContext.class,0);
		}
		public BitValueLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitValueLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterBitValueLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitBitValueLiterals(this);
		}
	}

	public final BitValueLiteralsContext bitValueLiterals() throws RecognitionException {
		BitValueLiteralsContext _localctx = new BitValueLiteralsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bitValueLiterals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER_) {
				{
				setState(186);
				characterSetName();
				}
			}

			setState(189);
			match(BIT_NUM_);
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(190);
				collateClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralsContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(BaseRuleParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BaseRuleParser.FALSE, 0); }
		public BooleanLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterBooleanLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitBooleanLiterals(this);
		}
	}

	public final BooleanLiteralsContext booleanLiterals() throws RecognitionException {
		BooleanLiteralsContext _localctx = new BooleanLiteralsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_booleanLiterals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NullValueLiteralsContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(BaseRuleParser.NULL, 0); }
		public NullValueLiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullValueLiterals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterNullValueLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitNullValueLiterals(this);
		}
	}

	public final NullValueLiteralsContext nullValueLiterals() throws RecognitionException {
		NullValueLiteralsContext _localctx = new NullValueLiteralsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nullValueLiterals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_() { return getToken(BaseRuleParser.IDENTIFIER_, 0); }
		public UnreservedWordContext unreservedWord() {
			return getRuleContext(UnreservedWordContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_identifier);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER_:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(IDENTIFIER_);
				}
				break;
			case NAME:
			case TYPE:
			case ADA:
			case C92:
			case CATALOG_NAME:
			case CHARACTER_SET_CATALOG:
			case CHARACTER_SET_NAME:
			case CHARACTER_SET_SCHEMA:
			case CLASS_ORIGIN:
			case COBOL:
			case COLLATION_CATALOG:
			case COLLATION_NAME:
			case COLLATION_SCHEMA:
			case COLUMN_NAME:
			case COMMAND_FUNCTION:
			case COMMITTED:
			case CONDITION_NUMBER:
			case CONNECTION_NAME:
			case CONSTRAINT_CATALOG:
			case CONSTRAINT_NAME:
			case CONSTRAINT_SCHEMA:
			case CURSOR_NAME:
			case DATA:
			case DATETIME_INTERVAL_CODE:
			case DATETIME_INTERVAL_PRECISION:
			case DYNAMIC_FUNCTION:
			case FORTRAN:
			case LENGTH:
			case MESSAGE_LENGTH:
			case MESSAGE_OCTET_LENGTH:
			case MESSAGE_TEXT:
			case MORE92:
			case MUMPS:
			case NULLABLE:
			case NUMBER:
			case PASCAL:
			case PLI:
			case REPEATABLE:
			case RETURNED_LENGTH:
			case RETURNED_OCTET_LENGTH:
			case RETURNED_SQLSTATE:
			case ROW_COUNT:
			case SCALE:
			case SCHEMA_NAME:
			case SERIALIZABLE:
			case SERVER_NAME:
			case SUBCLASS_ORIGIN:
			case TABLE_NAME:
			case UNCOMMITTED:
			case UNNAMED:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				unreservedWord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnreservedWordContext extends ParserRuleContext {
		public TerminalNode ADA() { return getToken(BaseRuleParser.ADA, 0); }
		public TerminalNode C92() { return getToken(BaseRuleParser.C92, 0); }
		public TerminalNode CATALOG_NAME() { return getToken(BaseRuleParser.CATALOG_NAME, 0); }
		public TerminalNode CHARACTER_SET_CATALOG() { return getToken(BaseRuleParser.CHARACTER_SET_CATALOG, 0); }
		public TerminalNode CHARACTER_SET_NAME() { return getToken(BaseRuleParser.CHARACTER_SET_NAME, 0); }
		public TerminalNode CHARACTER_SET_SCHEMA() { return getToken(BaseRuleParser.CHARACTER_SET_SCHEMA, 0); }
		public TerminalNode CLASS_ORIGIN() { return getToken(BaseRuleParser.CLASS_ORIGIN, 0); }
		public TerminalNode COBOL() { return getToken(BaseRuleParser.COBOL, 0); }
		public TerminalNode COLLATION_CATALOG() { return getToken(BaseRuleParser.COLLATION_CATALOG, 0); }
		public TerminalNode COLLATION_NAME() { return getToken(BaseRuleParser.COLLATION_NAME, 0); }
		public TerminalNode COLLATION_SCHEMA() { return getToken(BaseRuleParser.COLLATION_SCHEMA, 0); }
		public TerminalNode COLUMN_NAME() { return getToken(BaseRuleParser.COLUMN_NAME, 0); }
		public TerminalNode COMMAND_FUNCTION() { return getToken(BaseRuleParser.COMMAND_FUNCTION, 0); }
		public TerminalNode COMMITTED() { return getToken(BaseRuleParser.COMMITTED, 0); }
		public TerminalNode CONDITION_NUMBER() { return getToken(BaseRuleParser.CONDITION_NUMBER, 0); }
		public TerminalNode CONNECTION_NAME() { return getToken(BaseRuleParser.CONNECTION_NAME, 0); }
		public TerminalNode CONSTRAINT_CATALOG() { return getToken(BaseRuleParser.CONSTRAINT_CATALOG, 0); }
		public TerminalNode CONSTRAINT_NAME() { return getToken(BaseRuleParser.CONSTRAINT_NAME, 0); }
		public TerminalNode CONSTRAINT_SCHEMA() { return getToken(BaseRuleParser.CONSTRAINT_SCHEMA, 0); }
		public TerminalNode CURSOR_NAME() { return getToken(BaseRuleParser.CURSOR_NAME, 0); }
		public TerminalNode DATA() { return getToken(BaseRuleParser.DATA, 0); }
		public TerminalNode DATETIME_INTERVAL_CODE() { return getToken(BaseRuleParser.DATETIME_INTERVAL_CODE, 0); }
		public TerminalNode DATETIME_INTERVAL_PRECISION() { return getToken(BaseRuleParser.DATETIME_INTERVAL_PRECISION, 0); }
		public TerminalNode DYNAMIC_FUNCTION() { return getToken(BaseRuleParser.DYNAMIC_FUNCTION, 0); }
		public TerminalNode FORTRAN() { return getToken(BaseRuleParser.FORTRAN, 0); }
		public TerminalNode LENGTH() { return getToken(BaseRuleParser.LENGTH, 0); }
		public TerminalNode MESSAGE_LENGTH() { return getToken(BaseRuleParser.MESSAGE_LENGTH, 0); }
		public TerminalNode MESSAGE_OCTET_LENGTH() { return getToken(BaseRuleParser.MESSAGE_OCTET_LENGTH, 0); }
		public TerminalNode MESSAGE_TEXT() { return getToken(BaseRuleParser.MESSAGE_TEXT, 0); }
		public TerminalNode MORE92() { return getToken(BaseRuleParser.MORE92, 0); }
		public TerminalNode MUMPS() { return getToken(BaseRuleParser.MUMPS, 0); }
		public TerminalNode NAME() { return getToken(BaseRuleParser.NAME, 0); }
		public TerminalNode NULLABLE() { return getToken(BaseRuleParser.NULLABLE, 0); }
		public TerminalNode NUMBER() { return getToken(BaseRuleParser.NUMBER, 0); }
		public TerminalNode PASCAL() { return getToken(BaseRuleParser.PASCAL, 0); }
		public TerminalNode PLI() { return getToken(BaseRuleParser.PLI, 0); }
		public TerminalNode REPEATABLE() { return getToken(BaseRuleParser.REPEATABLE, 0); }
		public TerminalNode RETURNED_LENGTH() { return getToken(BaseRuleParser.RETURNED_LENGTH, 0); }
		public TerminalNode RETURNED_OCTET_LENGTH() { return getToken(BaseRuleParser.RETURNED_OCTET_LENGTH, 0); }
		public TerminalNode RETURNED_SQLSTATE() { return getToken(BaseRuleParser.RETURNED_SQLSTATE, 0); }
		public TerminalNode ROW_COUNT() { return getToken(BaseRuleParser.ROW_COUNT, 0); }
		public TerminalNode SCALE() { return getToken(BaseRuleParser.SCALE, 0); }
		public TerminalNode SCHEMA_NAME() { return getToken(BaseRuleParser.SCHEMA_NAME, 0); }
		public TerminalNode SERIALIZABLE() { return getToken(BaseRuleParser.SERIALIZABLE, 0); }
		public TerminalNode SERVER_NAME() { return getToken(BaseRuleParser.SERVER_NAME, 0); }
		public TerminalNode SUBCLASS_ORIGIN() { return getToken(BaseRuleParser.SUBCLASS_ORIGIN, 0); }
		public TerminalNode TABLE_NAME() { return getToken(BaseRuleParser.TABLE_NAME, 0); }
		public TerminalNode TYPE() { return getToken(BaseRuleParser.TYPE, 0); }
		public TerminalNode UNCOMMITTED() { return getToken(BaseRuleParser.UNCOMMITTED, 0); }
		public TerminalNode UNNAMED() { return getToken(BaseRuleParser.UNNAMED, 0); }
		public UnreservedWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unreservedWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterUnreservedWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitUnreservedWord(this);
		}
	}

	public final UnreservedWordContext unreservedWord() throws RecognitionException {
		UnreservedWordContext _localctx = new UnreservedWordContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unreservedWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_la = _input.LA(1);
			if ( !(((((_la - 164)) & ~0x3f) == 0 && ((1L << (_la - 164)) & -4398046511039L) != 0) || ((((_la - 228)) & ~0x3f) == 0 && ((1L << (_la - 228)) & 67108863L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllKeywordsContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(BaseRuleParser.ADD, 0); }
		public TerminalNode ALL() { return getToken(BaseRuleParser.ALL, 0); }
		public TerminalNode ALTER() { return getToken(BaseRuleParser.ALTER, 0); }
		public TerminalNode ARRAY() { return getToken(BaseRuleParser.ARRAY, 0); }
		public TerminalNode AVG() { return getToken(BaseRuleParser.AVG, 0); }
		public TerminalNode BEGIN() { return getToken(BaseRuleParser.BEGIN, 0); }
		public TerminalNode BETWEEN() { return getToken(BaseRuleParser.BETWEEN, 0); }
		public TerminalNode BOOLEAN() { return getToken(BaseRuleParser.BOOLEAN, 0); }
		public TerminalNode BY() { return getToken(BaseRuleParser.BY, 0); }
		public TerminalNode CALL() { return getToken(BaseRuleParser.CALL, 0); }
		public TerminalNode CASCADED() { return getToken(BaseRuleParser.CASCADED, 0); }
		public TerminalNode CAST() { return getToken(BaseRuleParser.CAST, 0); }
		public TerminalNode CHAR() { return getToken(BaseRuleParser.CHAR, 0); }
		public TerminalNode CHARACTER() { return getToken(BaseRuleParser.CHARACTER, 0); }
		public TerminalNode CLOSE() { return getToken(BaseRuleParser.CLOSE, 0); }
		public TerminalNode COLUMN() { return getToken(BaseRuleParser.COLUMN, 0); }
		public TerminalNode COMMIT() { return getToken(BaseRuleParser.COMMIT, 0); }
		public TerminalNode CONSTRAINT() { return getToken(BaseRuleParser.CONSTRAINT, 0); }
		public TerminalNode COUNT() { return getToken(BaseRuleParser.COUNT, 0); }
		public TerminalNode CREATE() { return getToken(BaseRuleParser.CREATE, 0); }
		public TerminalNode CURRENT() { return getToken(BaseRuleParser.CURRENT, 0); }
		public TerminalNode CURRENT_USER() { return getToken(BaseRuleParser.CURRENT_USER, 0); }
		public TerminalNode DATE() { return getToken(BaseRuleParser.DATE, 0); }
		public TerminalNode DAY() { return getToken(BaseRuleParser.DAY, 0); }
		public TerminalNode DECIMAL() { return getToken(BaseRuleParser.DECIMAL, 0); }
		public TerminalNode DEFAULT() { return getToken(BaseRuleParser.DEFAULT, 0); }
		public TerminalNode DEFINER() { return getToken(BaseRuleParser.DEFINER, 0); }
		public TerminalNode DELETE() { return getToken(BaseRuleParser.DELETE, 0); }
		public TerminalNode DISABLE() { return getToken(BaseRuleParser.DISABLE, 0); }
		public TerminalNode DISTINCT() { return getToken(BaseRuleParser.DISTINCT, 0); }
		public TerminalNode DO() { return getToken(BaseRuleParser.DO, 0); }
		public TerminalNode DOUBLE() { return getToken(BaseRuleParser.DOUBLE, 0); }
		public TerminalNode DROP() { return getToken(BaseRuleParser.DROP, 0); }
		public TerminalNode ENABLE() { return getToken(BaseRuleParser.ENABLE, 0); }
		public TerminalNode FLOAT() { return getToken(BaseRuleParser.FLOAT, 0); }
		public TerminalNode FOR() { return getToken(BaseRuleParser.FOR, 0); }
		public TerminalNode FOREIGN() { return getToken(BaseRuleParser.FOREIGN, 0); }
		public TerminalNode FUNCTION() { return getToken(BaseRuleParser.FUNCTION, 0); }
		public TerminalNode GRANT() { return getToken(BaseRuleParser.GRANT, 0); }
		public TerminalNode HOUR() { return getToken(BaseRuleParser.HOUR, 0); }
		public TerminalNode INDEX() { return getToken(BaseRuleParser.INDEX, 0); }
		public TerminalNode INSERT() { return getToken(BaseRuleParser.INSERT, 0); }
		public TerminalNode INSTANCE() { return getToken(BaseRuleParser.INSTANCE, 0); }
		public TerminalNode INTEGER() { return getToken(BaseRuleParser.INTEGER, 0); }
		public TerminalNode INTERVAL() { return getToken(BaseRuleParser.INTERVAL, 0); }
		public TerminalNode KEY() { return getToken(BaseRuleParser.KEY, 0); }
		public TerminalNode LOCAL() { return getToken(BaseRuleParser.LOCAL, 0); }
		public TerminalNode LOCALTIME() { return getToken(BaseRuleParser.LOCALTIME, 0); }
		public TerminalNode LOCALTIMESTAMP() { return getToken(BaseRuleParser.LOCALTIMESTAMP, 0); }
		public TerminalNode MAX() { return getToken(BaseRuleParser.MAX, 0); }
		public TerminalNode MICROSECOND() { return getToken(BaseRuleParser.MICROSECOND, 0); }
		public TerminalNode MIN() { return getToken(BaseRuleParser.MIN, 0); }
		public TerminalNode MINUTE() { return getToken(BaseRuleParser.MINUTE, 0); }
		public TerminalNode MONTH() { return getToken(BaseRuleParser.MONTH, 0); }
		public TerminalNode NAME() { return getToken(BaseRuleParser.NAME, 0); }
		public TerminalNode NAMES() { return getToken(BaseRuleParser.NAMES, 0); }
		public TerminalNode NEXT() { return getToken(BaseRuleParser.NEXT, 0); }
		public TerminalNode OPEN() { return getToken(BaseRuleParser.OPEN, 0); }
		public TerminalNode POSITION() { return getToken(BaseRuleParser.POSITION, 0); }
		public TerminalNode PRECISION() { return getToken(BaseRuleParser.PRECISION, 0); }
		public TerminalNode PRESERVE() { return getToken(BaseRuleParser.PRESERVE, 0); }
		public TerminalNode PRIMARY() { return getToken(BaseRuleParser.PRIMARY, 0); }
		public TerminalNode PROCEDURE() { return getToken(BaseRuleParser.PROCEDURE, 0); }
		public TerminalNode QUARTER() { return getToken(BaseRuleParser.QUARTER, 0); }
		public TerminalNode REAL() { return getToken(BaseRuleParser.REAL, 0); }
		public TerminalNode REVOKE() { return getToken(BaseRuleParser.REVOKE, 0); }
		public TerminalNode ROLLBACK() { return getToken(BaseRuleParser.ROLLBACK, 0); }
		public TerminalNode SAVEPOINT() { return getToken(BaseRuleParser.SAVEPOINT, 0); }
		public TerminalNode SCHEMA() { return getToken(BaseRuleParser.SCHEMA, 0); }
		public TerminalNode SECOND() { return getToken(BaseRuleParser.SECOND, 0); }
		public TerminalNode SET() { return getToken(BaseRuleParser.SET, 0); }
		public TerminalNode SQL() { return getToken(BaseRuleParser.SQL, 0); }
		public TerminalNode SUM() { return getToken(BaseRuleParser.SUM, 0); }
		public TerminalNode TABLE() { return getToken(BaseRuleParser.TABLE, 0); }
		public TerminalNode TIME() { return getToken(BaseRuleParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(BaseRuleParser.TIMESTAMP, 0); }
		public TerminalNode TO() { return getToken(BaseRuleParser.TO, 0); }
		public TerminalNode TRIGGER() { return getToken(BaseRuleParser.TRIGGER, 0); }
		public TerminalNode TRIM() { return getToken(BaseRuleParser.TRIM, 0); }
		public TerminalNode TRUNCATE() { return getToken(BaseRuleParser.TRUNCATE, 0); }
		public TerminalNode TYPE() { return getToken(BaseRuleParser.TYPE, 0); }
		public TerminalNode UNIQUE() { return getToken(BaseRuleParser.UNIQUE, 0); }
		public TerminalNode UPDATE() { return getToken(BaseRuleParser.UPDATE, 0); }
		public TerminalNode VALUE() { return getToken(BaseRuleParser.VALUE, 0); }
		public TerminalNode VALUES() { return getToken(BaseRuleParser.VALUES, 0); }
		public TerminalNode VARCHAR() { return getToken(BaseRuleParser.VARCHAR, 0); }
		public TerminalNode VIEW() { return getToken(BaseRuleParser.VIEW, 0); }
		public TerminalNode WEEK() { return getToken(BaseRuleParser.WEEK, 0); }
		public TerminalNode WITH() { return getToken(BaseRuleParser.WITH, 0); }
		public TerminalNode YEAR() { return getToken(BaseRuleParser.YEAR, 0); }
		public AllKeywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allKeywords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterAllKeywords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitAllKeywords(this);
		}
	}

	public final AllKeywordsContext allKeywords() throws RecognitionException {
		AllKeywordsContext _localctx = new AllKeywordsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_allKeywords);
		try {
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(ADD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				match(ALTER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				match(ARRAY);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(208);
				match(AVG);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(209);
				match(BEGIN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(210);
				match(BETWEEN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(211);
				match(BOOLEAN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(212);
				match(BY);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(213);
				match(CALL);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(214);
				match(CASCADED);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(215);
				match(CAST);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(216);
				match(CHAR);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(217);
				match(CHARACTER);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(218);
				match(CLOSE);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(219);
				match(COLUMN);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(220);
				match(COMMIT);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(221);
				match(CONSTRAINT);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(222);
				match(COUNT);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(223);
				match(CREATE);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(224);
				match(CURRENT);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(225);
				match(CURRENT_USER);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(226);
				match(DATE);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(227);
				match(DAY);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(228);
				match(DECIMAL);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(229);
				match(DEFAULT);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(230);
				match(DEFINER);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(231);
				match(DELETE);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(232);
				match(DISABLE);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(233);
				match(DISTINCT);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(234);
				match(DO);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(235);
				match(DOUBLE);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(236);
				match(DROP);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(237);
				match(ENABLE);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(239);
				match(FLOAT);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(240);
				match(FOR);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(241);
				match(FOREIGN);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(243);
				match(FUNCTION);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(244);
				match(GRANT);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(245);
				match(HOUR);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(246);
				match(INDEX);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(247);
				match(INSERT);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 46);
				{
				setState(248);
				match(INSTANCE);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 47);
				{
				setState(249);
				match(INTEGER);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 48);
				{
				setState(250);
				match(INTERVAL);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 49);
				{
				setState(251);
				match(KEY);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 50);
				{
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 51);
				{
				setState(253);
				match(LOCAL);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 52);
				{
				setState(254);
				match(LOCALTIME);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 53);
				{
				setState(255);
				match(LOCALTIMESTAMP);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 54);
				{
				setState(256);
				match(MAX);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 55);
				{
				setState(257);
				match(MICROSECOND);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 56);
				{
				setState(258);
				match(MIN);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 57);
				{
				setState(259);
				match(MINUTE);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 58);
				{
				setState(260);
				match(MONTH);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 59);
				{
				setState(261);
				match(NAME);
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 60);
				{
				setState(262);
				match(NAMES);
				}
				break;
			case 61:
				enterOuterAlt(_localctx, 61);
				{
				setState(263);
				match(NEXT);
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 62);
				{
				setState(264);
				match(OPEN);
				}
				break;
			case 63:
				enterOuterAlt(_localctx, 63);
				{
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 64);
				{
				setState(266);
				match(POSITION);
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 65);
				{
				setState(267);
				match(PRECISION);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 66);
				{
				setState(268);
				match(PRESERVE);
				}
				break;
			case 67:
				enterOuterAlt(_localctx, 67);
				{
				setState(269);
				match(PRIMARY);
				}
				break;
			case 68:
				enterOuterAlt(_localctx, 68);
				{
				setState(270);
				match(PROCEDURE);
				}
				break;
			case 69:
				enterOuterAlt(_localctx, 69);
				{
				setState(271);
				match(QUARTER);
				}
				break;
			case 70:
				enterOuterAlt(_localctx, 70);
				{
				setState(272);
				match(REAL);
				}
				break;
			case 71:
				enterOuterAlt(_localctx, 71);
				{
				setState(273);
				match(REVOKE);
				}
				break;
			case 72:
				enterOuterAlt(_localctx, 72);
				{
				setState(274);
				match(ROLLBACK);
				}
				break;
			case 73:
				enterOuterAlt(_localctx, 73);
				{
				setState(275);
				match(SAVEPOINT);
				}
				break;
			case 74:
				enterOuterAlt(_localctx, 74);
				{
				setState(276);
				match(SCHEMA);
				}
				break;
			case 75:
				enterOuterAlt(_localctx, 75);
				{
				setState(277);
				match(SECOND);
				}
				break;
			case 76:
				enterOuterAlt(_localctx, 76);
				{
				setState(278);
				match(SET);
				}
				break;
			case 77:
				enterOuterAlt(_localctx, 77);
				{
				setState(279);
				match(SQL);
				}
				break;
			case 78:
				enterOuterAlt(_localctx, 78);
				{
				setState(280);
				match(SUM);
				}
				break;
			case 79:
				enterOuterAlt(_localctx, 79);
				{
				setState(281);
				match(TABLE);
				}
				break;
			case 80:
				enterOuterAlt(_localctx, 80);
				{
				setState(282);
				match(TIME);
				}
				break;
			case 81:
				enterOuterAlt(_localctx, 81);
				{
				setState(283);
				match(TIMESTAMP);
				}
				break;
			case 82:
				enterOuterAlt(_localctx, 82);
				{
				setState(284);
				match(TO);
				}
				break;
			case 83:
				enterOuterAlt(_localctx, 83);
				{
				setState(285);
				match(TRIGGER);
				}
				break;
			case 84:
				enterOuterAlt(_localctx, 84);
				{
				setState(286);
				match(TRIM);
				}
				break;
			case 85:
				enterOuterAlt(_localctx, 85);
				{
				setState(287);
				match(TRUNCATE);
				}
				break;
			case 86:
				enterOuterAlt(_localctx, 86);
				{
				setState(288);
				match(TYPE);
				}
				break;
			case 87:
				enterOuterAlt(_localctx, 87);
				{
				setState(289);
				match(UNIQUE);
				}
				break;
			case 88:
				enterOuterAlt(_localctx, 88);
				{
				setState(290);
				match(UPDATE);
				}
				break;
			case 89:
				enterOuterAlt(_localctx, 89);
				{
				setState(291);
				match(VALUE);
				}
				break;
			case 90:
				enterOuterAlt(_localctx, 90);
				{
				setState(292);
				match(VALUES);
				}
				break;
			case 91:
				enterOuterAlt(_localctx, 91);
				{
				setState(293);
				match(VARCHAR);
				}
				break;
			case 92:
				enterOuterAlt(_localctx, 92);
				{
				setState(294);
				match(VIEW);
				}
				break;
			case 93:
				enterOuterAlt(_localctx, 93);
				{
				setState(295);
				match(WEEK);
				}
				break;
			case 94:
				enterOuterAlt(_localctx, 94);
				{
				setState(296);
				match(WITH);
				}
				break;
			case 95:
				enterOuterAlt(_localctx, 95);
				{
				setState(297);
				match(YEAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> AT_() { return getTokens(BaseRuleParser.AT_); }
		public TerminalNode AT_(int i) {
			return getToken(BaseRuleParser.AT_, i);
		}
		public TerminalNode DOT_() { return getToken(BaseRuleParser.DOT_, 0); }
		public TerminalNode GLOBAL() { return getToken(BaseRuleParser.GLOBAL, 0); }
		public TerminalNode LOCAL() { return getToken(BaseRuleParser.LOCAL, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_) {
				{
				setState(301);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(300);
					match(AT_);
					}
					break;
				}
				setState(303);
				match(AT_);
				}
			}

			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL || _la==GLOBAL) {
				{
				setState(306);
				_la = _input.LA(1);
				if ( !(_la==LOCAL || _la==GLOBAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT_) {
				{
				setState(309);
				match(DOT_);
				}
			}

			setState(312);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SchemaNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SchemaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterSchemaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitSchemaName(this);
		}
	}

	public final SchemaNameContext schemaName() throws RecognitionException {
		SchemaNameContext _localctx = new SchemaNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_schemaName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public OwnerContext owner() {
			return getRuleContext(OwnerContext.class,0);
		}
		public TerminalNode DOT_() { return getToken(BaseRuleParser.DOT_, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(316);
				owner();
				setState(317);
				match(DOT_);
				}
				break;
			}
			setState(321);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public OwnerContext owner() {
			return getRuleContext(OwnerContext.class,0);
		}
		public TerminalNode DOT_() { return getToken(BaseRuleParser.DOT_, 0); }
		public QualifiedShorthandContext qualifiedShorthand() {
			return getRuleContext(QualifiedShorthandContext.class,0);
		}
		public UnqualifiedShorthandContext unqualifiedShorthand() {
			return getRuleContext(UnqualifiedShorthandContext.class,0);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_columnName);
		try {
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(323);
					owner();
					setState(324);
					match(DOT_);
					}
					break;
				}
				setState(328);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				qualifiedShorthand();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				unqualifiedShorthand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliasContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING_() { return getToken(BaseRuleParser.STRING_, 0); }
		public TerminalNode AS() { return getToken(BaseRuleParser.AS, 0); }
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(333);
				match(AS);
				}
			}

			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case TYPE:
			case IDENTIFIER_:
			case ADA:
			case C92:
			case CATALOG_NAME:
			case CHARACTER_SET_CATALOG:
			case CHARACTER_SET_NAME:
			case CHARACTER_SET_SCHEMA:
			case CLASS_ORIGIN:
			case COBOL:
			case COLLATION_CATALOG:
			case COLLATION_NAME:
			case COLLATION_SCHEMA:
			case COLUMN_NAME:
			case COMMAND_FUNCTION:
			case COMMITTED:
			case CONDITION_NUMBER:
			case CONNECTION_NAME:
			case CONSTRAINT_CATALOG:
			case CONSTRAINT_NAME:
			case CONSTRAINT_SCHEMA:
			case CURSOR_NAME:
			case DATA:
			case DATETIME_INTERVAL_CODE:
			case DATETIME_INTERVAL_PRECISION:
			case DYNAMIC_FUNCTION:
			case FORTRAN:
			case LENGTH:
			case MESSAGE_LENGTH:
			case MESSAGE_OCTET_LENGTH:
			case MESSAGE_TEXT:
			case MORE92:
			case MUMPS:
			case NULLABLE:
			case NUMBER:
			case PASCAL:
			case PLI:
			case REPEATABLE:
			case RETURNED_LENGTH:
			case RETURNED_OCTET_LENGTH:
			case RETURNED_SQLSTATE:
			case ROW_COUNT:
			case SCALE:
			case SCHEMA_NAME:
			case SERIALIZABLE:
			case SERVER_NAME:
			case SUBCLASS_ORIGIN:
			case TABLE_NAME:
			case UNCOMMITTED:
			case UNNAMED:
				{
				setState(336);
				identifier();
				}
				break;
			case STRING_:
				{
				setState(337);
				match(STRING_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnqualifiedShorthandContext extends ParserRuleContext {
		public TerminalNode ASTERISK_() { return getToken(BaseRuleParser.ASTERISK_, 0); }
		public UnqualifiedShorthandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unqualifiedShorthand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterUnqualifiedShorthand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitUnqualifiedShorthand(this);
		}
	}

	public final UnqualifiedShorthandContext unqualifiedShorthand() throws RecognitionException {
		UnqualifiedShorthandContext _localctx = new UnqualifiedShorthandContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unqualifiedShorthand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(ASTERISK_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedShorthandContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT_ASTERISK_() { return getToken(BaseRuleParser.DOT_ASTERISK_, 0); }
		public QualifiedShorthandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedShorthand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterQualifiedShorthand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitQualifiedShorthand(this);
		}
	}

	public final QualifiedShorthandContext qualifiedShorthand() throws RecognitionException {
		QualifiedShorthandContext _localctx = new QualifiedShorthandContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_qualifiedShorthand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			identifier();
			setState(343);
			match(DOT_ASTERISK_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ViewNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public OwnerContext owner() {
			return getRuleContext(OwnerContext.class,0);
		}
		public TerminalNode DOT_() { return getToken(BaseRuleParser.DOT_, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_viewName);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(346);
					owner();
					setState(347);
					match(DOT_);
					}
					break;
				}
				setState(351);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OwnerContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public OwnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_owner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterOwner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitOwner(this);
		}
	}

	public final OwnerContext owner() throws RecognitionException {
		OwnerContext _localctx = new OwnerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_owner);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstraintNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConstraintNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterConstraintName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitConstraintName(this);
		}
	}

	public final ConstraintNameContext constraintName() throws RecognitionException {
		ConstraintNameContext _localctx = new ConstraintNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constraintName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNamesContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public List<TerminalNode> COMMA_() { return getTokens(BaseRuleParser.COMMA_); }
		public TerminalNode COMMA_(int i) {
			return getToken(BaseRuleParser.COMMA_, i);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public ColumnNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterColumnNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitColumnNames(this);
		}
	}

	public final ColumnNamesContext columnNames() throws RecognitionException {
		ColumnNamesContext _localctx = new ColumnNamesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_columnNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP_) {
				{
				setState(360);
				match(LP_);
				}
			}

			setState(363);
			columnName();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_) {
				{
				{
				setState(364);
				match(COMMA_);
				setState(365);
				columnName();
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RP_) {
				{
				setState(371);
				match(RP_);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNamesContext extends ParserRuleContext {
		public List<TableNameContext> tableName() {
			return getRuleContexts(TableNameContext.class);
		}
		public TableNameContext tableName(int i) {
			return getRuleContext(TableNameContext.class,i);
		}
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public List<TerminalNode> COMMA_() { return getTokens(BaseRuleParser.COMMA_); }
		public TerminalNode COMMA_(int i) {
			return getToken(BaseRuleParser.COMMA_, i);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public TableNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterTableNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitTableNames(this);
		}
	}

	public final TableNamesContext tableNames() throws RecognitionException {
		TableNamesContext _localctx = new TableNamesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_tableNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP_) {
				{
				setState(374);
				match(LP_);
				}
			}

			setState(377);
			tableName();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_) {
				{
				{
				setState(378);
				match(COMMA_);
				setState(379);
				tableName();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RP_) {
				{
				setState(385);
				match(RP_);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CharacterSetNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_() { return getToken(BaseRuleParser.IDENTIFIER_, 0); }
		public CharacterSetNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterSetName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterCharacterSetName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitCharacterSetName(this);
		}
	}

	public final CharacterSetNameContext characterSetName() throws RecognitionException {
		CharacterSetNameContext _localctx = new CharacterSetNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_characterSetName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(IDENTIFIER_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public NotOperatorContext notOperator() {
			return getRuleContext(NotOperatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public BooleanPrimaryContext booleanPrimary() {
			return getRuleContext(BooleanPrimaryContext.class,0);
		}
		public ExprOperatorContext exprOperator() {
			return getRuleContext(ExprOperatorContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(391);
				notOperator();
				setState(392);
				expr(3);
				}
				break;
			case 2:
				{
				setState(394);
				match(LP_);
				setState(395);
				expr(0);
				setState(396);
				match(RP_);
				}
				break;
			case 3:
				{
				setState(398);
				booleanPrimary(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(401);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(402);
					exprOperator();
					setState(403);
					expr(5);
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprOperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(BaseRuleParser.AND, 0); }
		public TerminalNode OR() { return getToken(BaseRuleParser.OR, 0); }
		public TerminalNode AND_() { return getToken(BaseRuleParser.AND_, 0); }
		public ExprOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterExprOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitExprOperator(this);
		}
	}

	public final ExprOperatorContext exprOperator() throws RecognitionException {
		ExprOperatorContext _localctx = new ExprOperatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_exprOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			_la = _input.LA(1);
			if ( !(_la==AND_ || _la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprListContext extends ParserRuleContext {
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ASTERISK_() { return getToken(BaseRuleParser.ASTERISK_, 0); }
		public List<TerminalNode> COMMA_() { return getTokens(BaseRuleParser.COMMA_); }
		public TerminalNode COMMA_(int i) {
			return getToken(BaseRuleParser.COMMA_, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(LP_);
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(413);
				expr(0);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_) {
					{
					{
					setState(414);
					match(COMMA_);
					setState(415);
					expr(0);
					}
					}
					setState(420);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(421);
				match(ASTERISK_);
				}
				break;
			}
			setState(424);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprListwithModifierContext extends ParserRuleContext {
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ASTERISK_() { return getToken(BaseRuleParser.ASTERISK_, 0); }
		public List<TerminalNode> COMMA_() { return getTokens(BaseRuleParser.COMMA_); }
		public TerminalNode COMMA_(int i) {
			return getToken(BaseRuleParser.COMMA_, i);
		}
		public ExprListwithModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprListwithModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterExprListwithModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitExprListwithModifier(this);
		}
	}

	public final ExprListwithModifierContext exprListwithModifier() throws RecognitionException {
		ExprListwithModifierContext _localctx = new ExprListwithModifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_exprListwithModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(LP_);
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(427);
				modifier();
				}
				break;
			}
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(430);
				expr(0);
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_) {
					{
					{
					setState(431);
					match(COMMA_);
					setState(433);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(432);
						modifier();
						}
						break;
					}
					setState(435);
					expr(0);
					}
					}
					setState(440);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(441);
				match(ASTERISK_);
				}
				break;
			}
			setState(444);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NotOperatorContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BaseRuleParser.NOT, 0); }
		public TerminalNode NOT_() { return getToken(BaseRuleParser.NOT_, 0); }
		public NotOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterNotOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitNotOperator(this);
		}
	}

	public final NotOperatorContext notOperator() throws RecognitionException {
		NotOperatorContext _localctx = new NotOperatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_notOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			_la = _input.LA(1);
			if ( !(_la==NOT_ || _la==NOT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanPrimaryContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public BooleanPrimaryContext booleanPrimary() {
			return getRuleContext(BooleanPrimaryContext.class,0);
		}
		public IsOperatorContext isOperator() {
			return getRuleContext(IsOperatorContext.class,0);
		}
		public LiteralsContext literals() {
			return getRuleContext(LiteralsContext.class,0);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public BooleanPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterBooleanPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitBooleanPrimary(this);
		}
	}

	public final BooleanPrimaryContext booleanPrimary() throws RecognitionException {
		return booleanPrimary(0);
	}

	private BooleanPrimaryContext booleanPrimary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanPrimaryContext _localctx = new BooleanPrimaryContext(_ctx, _parentState);
		BooleanPrimaryContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_booleanPrimary, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(449);
			predicate();
			}
			_ctx.stop = _input.LT(-1);
			setState(465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(463);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanPrimaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_booleanPrimary);
						setState(451);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(452);
						isOperator();
						setState(453);
						literals();
						}
						break;
					case 2:
						{
						_localctx = new BooleanPrimaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_booleanPrimary);
						setState(455);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(456);
						comparisonOperator();
						setState(457);
						predicate();
						}
						break;
					case 3:
						{
						_localctx = new BooleanPrimaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_booleanPrimary);
						setState(459);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(460);
						comparisonOperator();
						setState(461);
						subquery();
						}
						break;
					}
					} 
				}
				setState(467);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ_() { return getToken(BaseRuleParser.EQ_, 0); }
		public TerminalNode GTE_() { return getToken(BaseRuleParser.GTE_, 0); }
		public TerminalNode GT_() { return getToken(BaseRuleParser.GT_, 0); }
		public TerminalNode LTE_() { return getToken(BaseRuleParser.LTE_, 0); }
		public TerminalNode LT_() { return getToken(BaseRuleParser.LT_, 0); }
		public TerminalNode NEQ_() { return getToken(BaseRuleParser.NEQ_, 0); }
		public TerminalNode SAFE_EQ_() { return getToken(BaseRuleParser.SAFE_EQ_, 0); }
		public TerminalNode ALL() { return getToken(BaseRuleParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(BaseRuleParser.ANY, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitComparisonOperator(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 265289728L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(470);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(469);
				_la = _input.LA(1);
				if ( !(_la==ALL || _la==ANY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsOperatorContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(BaseRuleParser.IS, 0); }
		public TerminalNode NOT() { return getToken(BaseRuleParser.NOT, 0); }
		public IsOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterIsOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitIsOperator(this);
		}
	}

	public final IsOperatorContext isOperator() throws RecognitionException {
		IsOperatorContext _localctx = new IsOperatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_isOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(IS);
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(473);
				match(NOT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PredicateContext extends ParserRuleContext {
		public InPredicateContext inPredicate() {
			return getRuleContext(InPredicateContext.class,0);
		}
		public BetweenPredicateContext betweenPredicate() {
			return getRuleContext(BetweenPredicateContext.class,0);
		}
		public LikePredicateContext likePredicate() {
			return getRuleContext(LikePredicateContext.class,0);
		}
		public BitExprContext bitExpr() {
			return getRuleContext(BitExprContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_predicate);
		try {
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				inPredicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
				betweenPredicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(478);
				likePredicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(479);
				bitExpr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InPredicateContext extends ParserRuleContext {
		public BitExprContext bitExpr() {
			return getRuleContext(BitExprContext.class,0);
		}
		public TerminalNode IN() { return getToken(BaseRuleParser.IN, 0); }
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(BaseRuleParser.NOT, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public Mask_tokenContext mask_token() {
			return getRuleContext(Mask_tokenContext.class,0);
		}
		public Paren_tokenContext paren_token() {
			return getRuleContext(Paren_tokenContext.class,0);
		}
		public InPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterInPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitInPredicate(this);
		}
	}

	public final InPredicateContext inPredicate() throws RecognitionException {
		InPredicateContext _localctx = new InPredicateContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_inPredicate);
		int _la;
		try {
			setState(510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				bitExpr(0);
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(483);
					match(NOT);
					}
				}

				setState(486);
				match(IN);
				setState(487);
				subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				bitExpr(0);
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(490);
					match(NOT);
					}
				}

				setState(493);
				match(IN);
				setState(494);
				exprList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(496);
				bitExpr(0);
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(497);
					match(NOT);
					}
				}

				setState(500);
				match(IN);
				setState(501);
				mask_token();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(503);
				bitExpr(0);
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(504);
					match(NOT);
					}
				}

				setState(507);
				match(IN);
				setState(508);
				paren_token();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BetweenPredicateContext extends ParserRuleContext {
		public List<BitExprContext> bitExpr() {
			return getRuleContexts(BitExprContext.class);
		}
		public BitExprContext bitExpr(int i) {
			return getRuleContext(BitExprContext.class,i);
		}
		public TerminalNode BETWEEN() { return getToken(BaseRuleParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(BaseRuleParser.AND, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NOT() { return getToken(BaseRuleParser.NOT, 0); }
		public BetweenPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterBetweenPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitBetweenPredicate(this);
		}
	}

	public final BetweenPredicateContext betweenPredicate() throws RecognitionException {
		BetweenPredicateContext _localctx = new BetweenPredicateContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_betweenPredicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			bitExpr(0);
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(513);
				match(NOT);
				}
			}

			setState(516);
			match(BETWEEN);
			setState(517);
			bitExpr(0);
			setState(518);
			match(AND);
			setState(519);
			predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LikePredicateContext extends ParserRuleContext {
		public BitExprContext bitExpr() {
			return getRuleContext(BitExprContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(BaseRuleParser.LIKE, 0); }
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode NOT() { return getToken(BaseRuleParser.NOT, 0); }
		public TerminalNode ESCAPE() { return getToken(BaseRuleParser.ESCAPE, 0); }
		public LikePredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likePredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterLikePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitLikePredicate(this);
		}
	}

	public final LikePredicateContext likePredicate() throws RecognitionException {
		LikePredicateContext _localctx = new LikePredicateContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_likePredicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			bitExpr(0);
			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(522);
				match(NOT);
				}
			}

			setState(525);
			match(LIKE);
			setState(526);
			simpleExpr(0);
			setState(529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(527);
				match(ESCAPE);
				setState(528);
				simpleExpr(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitExprContext extends ParserRuleContext {
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public List<BitExprContext> bitExpr() {
			return getRuleContexts(BitExprContext.class);
		}
		public BitExprContext bitExpr(int i) {
			return getRuleContext(BitExprContext.class,i);
		}
		public BitOperatorContext bitOperator() {
			return getRuleContext(BitOperatorContext.class,0);
		}
		public BitExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterBitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitBitExpr(this);
		}
	}

	public final BitExprContext bitExpr() throws RecognitionException {
		return bitExpr(0);
	}

	private BitExprContext bitExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BitExprContext _localctx = new BitExprContext(_ctx, _parentState);
		BitExprContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_bitExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(532);
			simpleExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(540);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BitExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitExpr);
					setState(534);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(535);
					bitOperator();
					setState(536);
					bitExpr(3);
					}
					} 
				}
				setState(542);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitOperatorContext extends ParserRuleContext {
		public TerminalNode VERTICAL_BAR_() { return getToken(BaseRuleParser.VERTICAL_BAR_, 0); }
		public TerminalNode AMPERSAND_() { return getToken(BaseRuleParser.AMPERSAND_, 0); }
		public TerminalNode SIGNED_LEFT_SHIFT_() { return getToken(BaseRuleParser.SIGNED_LEFT_SHIFT_, 0); }
		public TerminalNode SIGNED_RIGHT_SHIFT_() { return getToken(BaseRuleParser.SIGNED_RIGHT_SHIFT_, 0); }
		public TerminalNode PLUS_() { return getToken(BaseRuleParser.PLUS_, 0); }
		public TerminalNode MINUS_() { return getToken(BaseRuleParser.MINUS_, 0); }
		public TerminalNode ASTERISK_() { return getToken(BaseRuleParser.ASTERISK_, 0); }
		public TerminalNode SLASH_() { return getToken(BaseRuleParser.SLASH_, 0); }
		public TerminalNode MOD_() { return getToken(BaseRuleParser.MOD_, 0); }
		public TerminalNode CARET_() { return getToken(BaseRuleParser.CARET_, 0); }
		public TerminalNode TILDE_() { return getToken(BaseRuleParser.TILDE_, 0); }
		public TerminalNode NOT_() { return getToken(BaseRuleParser.NOT_, 0); }
		public BitOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterBitOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitBitOperator(this);
		}
	}

	public final BitOperatorContext bitOperator() throws RecognitionException {
		BitOperatorContext _localctx = new BitOperatorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_bitOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126960L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleExprContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ParameterMarkerContext parameterMarker() {
			return getRuleContext(ParameterMarkerContext.class,0);
		}
		public LiteralsContext literals() {
			return getRuleContext(LiteralsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode PLUS_() { return getToken(BaseRuleParser.PLUS_, 0); }
		public TerminalNode MINUS_() { return getToken(BaseRuleParser.MINUS_, 0); }
		public TerminalNode TILDE_() { return getToken(BaseRuleParser.TILDE_, 0); }
		public TerminalNode NOT_() { return getToken(BaseRuleParser.NOT_, 0); }
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExprListwithModifierContext exprListwithModifier() {
			return getRuleContext(ExprListwithModifierContext.class,0);
		}
		public ExistExprContext existExpr() {
			return getRuleContext(ExistExprContext.class,0);
		}
		public TerminalNode LBE_() { return getToken(BaseRuleParser.LBE_, 0); }
		public TerminalNode RBE_() { return getToken(BaseRuleParser.RBE_, 0); }
		public MatchExpressionContext matchExpression() {
			return getRuleContext(MatchExpressionContext.class,0);
		}
		public CaseExpressionContext caseExpression() {
			return getRuleContext(CaseExpressionContext.class,0);
		}
		public IntervalExpressionContext intervalExpression() {
			return getRuleContext(IntervalExpressionContext.class,0);
		}
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Mask_tokenContext mask_token() {
			return getRuleContext(Mask_tokenContext.class,0);
		}
		public Paren_tokenContext paren_token() {
			return getRuleContext(Paren_tokenContext.class,0);
		}
		public TerminalNode COLLATE() { return getToken(BaseRuleParser.COLLATE, 0); }
		public TerminalNode STRING_() { return getToken(BaseRuleParser.STRING_, 0); }
		public SimpleExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterSimpleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitSimpleExpr(this);
		}
	}

	public final SimpleExprContext simpleExpr() throws RecognitionException {
		return simpleExpr(0);
	}

	private SimpleExprContext simpleExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SimpleExprContext _localctx = new SimpleExprContext(_ctx, _parentState);
		SimpleExprContext _prevctx = _localctx;
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_simpleExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(546);
				functionCall();
				}
				break;
			case 2:
				{
				setState(547);
				parameterMarker();
				}
				break;
			case 3:
				{
				setState(548);
				literals();
				}
				break;
			case 4:
				{
				setState(549);
				identifier();
				}
				break;
			case 5:
				{
				setState(550);
				columnName();
				}
				break;
			case 6:
				{
				setState(551);
				variable();
				}
				break;
			case 7:
				{
				setState(552);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 24624L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(553);
				simpleExpr(12);
				}
				break;
			case 8:
				{
				setState(554);
				match(LP_);
				setState(555);
				expr(0);
				setState(556);
				match(RP_);
				}
				break;
			case 9:
				{
				setState(558);
				exprList();
				}
				break;
			case 10:
				{
				setState(559);
				exprListwithModifier();
				}
				break;
			case 11:
				{
				setState(560);
				existExpr();
				}
				break;
			case 12:
				{
				setState(561);
				match(LBE_);
				setState(562);
				identifier();
				setState(563);
				expr(0);
				setState(564);
				match(RBE_);
				}
				break;
			case 13:
				{
				setState(566);
				matchExpression();
				}
				break;
			case 14:
				{
				setState(567);
				caseExpression();
				}
				break;
			case 15:
				{
				setState(568);
				intervalExpression();
				}
				break;
			case 16:
				{
				setState(569);
				subquery();
				}
				break;
			case 17:
				{
				setState(570);
				mask_token();
				}
				break;
			case 18:
				{
				setState(571);
				paren_token();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(582);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SimpleExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr);
					setState(574);
					if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
					setState(575);
					match(COLLATE);
					setState(578);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRING_:
						{
						setState(576);
						match(STRING_);
						}
						break;
					case NAME:
					case TYPE:
					case IDENTIFIER_:
					case ADA:
					case C92:
					case CATALOG_NAME:
					case CHARACTER_SET_CATALOG:
					case CHARACTER_SET_NAME:
					case CHARACTER_SET_SCHEMA:
					case CLASS_ORIGIN:
					case COBOL:
					case COLLATION_CATALOG:
					case COLLATION_NAME:
					case COLLATION_SCHEMA:
					case COLUMN_NAME:
					case COMMAND_FUNCTION:
					case COMMITTED:
					case CONDITION_NUMBER:
					case CONNECTION_NAME:
					case CONSTRAINT_CATALOG:
					case CONSTRAINT_NAME:
					case CONSTRAINT_SCHEMA:
					case CURSOR_NAME:
					case DATA:
					case DATETIME_INTERVAL_CODE:
					case DATETIME_INTERVAL_PRECISION:
					case DYNAMIC_FUNCTION:
					case FORTRAN:
					case LENGTH:
					case MESSAGE_LENGTH:
					case MESSAGE_OCTET_LENGTH:
					case MESSAGE_TEXT:
					case MORE92:
					case MUMPS:
					case NULLABLE:
					case NUMBER:
					case PASCAL:
					case PLI:
					case REPEATABLE:
					case RETURNED_LENGTH:
					case RETURNED_OCTET_LENGTH:
					case RETURNED_SQLSTATE:
					case ROW_COUNT:
					case SCALE:
					case SCHEMA_NAME:
					case SERIALIZABLE:
					case SERVER_NAME:
					case SUBCLASS_ORIGIN:
					case TABLE_NAME:
					case UNCOMMITTED:
					case UNNAMED:
						{
						setState(577);
						identifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(584);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mask_tokenContext extends ParserRuleContext {
		public TerminalNode MASK_TOKEN() { return getToken(BaseRuleParser.MASK_TOKEN, 0); }
		public Mask_tokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mask_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterMask_token(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitMask_token(this);
		}
	}

	public final Mask_tokenContext mask_token() throws RecognitionException {
		Mask_tokenContext _localctx = new Mask_tokenContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_mask_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			match(MASK_TOKEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Paren_tokenContext extends ParserRuleContext {
		public TerminalNode PAREN_TOKEN() { return getToken(BaseRuleParser.PAREN_TOKEN, 0); }
		public Paren_tokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paren_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterParen_token(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitParen_token(this);
		}
	}

	public final Paren_tokenContext paren_token() throws RecognitionException {
		Paren_tokenContext _localctx = new Paren_tokenContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_paren_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			match(PAREN_TOKEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExistExprContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(BaseRuleParser.EXISTS, 0); }
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Mask_tokenContext mask_token() {
			return getRuleContext(Mask_tokenContext.class,0);
		}
		public ExistExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterExistExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitExistExpr(this);
		}
	}

	public final ExistExprContext existExpr() throws RecognitionException {
		ExistExprContext _localctx = new ExistExprContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_existExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(EXISTS);
			setState(592);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(590);
				subquery();
				}
				break;
			case MASK_TOKEN:
				{
				setState(591);
				mask_token();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public AggregationFunctionContext aggregationFunction() {
			return getRuleContext(AggregationFunctionContext.class,0);
		}
		public SpecialFunctionContext specialFunction() {
			return getRuleContext(SpecialFunctionContext.class,0);
		}
		public RegularFunctionContext regularFunction() {
			return getRuleContext(RegularFunctionContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_functionCall);
		try {
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(594);
				aggregationFunction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(595);
				specialFunction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(596);
				regularFunction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AggregationFunctionContext extends ParserRuleContext {
		public AggregationFunctionNameContext aggregationFunctionName() {
			return getRuleContext(AggregationFunctionNameContext.class,0);
		}
		public ExprListwithModifierContext exprListwithModifier() {
			return getRuleContext(ExprListwithModifierContext.class,0);
		}
		public Paren_tokenContext paren_token() {
			return getRuleContext(Paren_tokenContext.class,0);
		}
		public AggregationFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterAggregationFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitAggregationFunction(this);
		}
	}

	public final AggregationFunctionContext aggregationFunction() throws RecognitionException {
		AggregationFunctionContext _localctx = new AggregationFunctionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_aggregationFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			aggregationFunctionName();
			setState(602);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP_:
				{
				setState(600);
				exprListwithModifier();
				}
				break;
			case PAREN_TOKEN:
				{
				setState(601);
				paren_token();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AggregationFunctionNameContext extends ParserRuleContext {
		public TerminalNode MAX() { return getToken(BaseRuleParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(BaseRuleParser.MIN, 0); }
		public TerminalNode SUM() { return getToken(BaseRuleParser.SUM, 0); }
		public TerminalNode COUNT() { return getToken(BaseRuleParser.COUNT, 0); }
		public TerminalNode AVG() { return getToken(BaseRuleParser.AVG, 0); }
		public AggregationFunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationFunctionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterAggregationFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitAggregationFunctionName(this);
		}
	}

	public final AggregationFunctionNameContext aggregationFunctionName() throws RecognitionException {
		AggregationFunctionNameContext _localctx = new AggregationFunctionNameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_aggregationFunctionName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			_la = _input.LA(1);
			if ( !(((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 31L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(BaseRuleParser.DISTINCT, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_modifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			match(DISTINCT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecialFunctionContext extends ParserRuleContext {
		public CastFunctionContext castFunction() {
			return getRuleContext(CastFunctionContext.class,0);
		}
		public ConvertFunctionContext convertFunction() {
			return getRuleContext(ConvertFunctionContext.class,0);
		}
		public PositionFunctionContext positionFunction() {
			return getRuleContext(PositionFunctionContext.class,0);
		}
		public SubstringFunctionContext substringFunction() {
			return getRuleContext(SubstringFunctionContext.class,0);
		}
		public ExtractFunctionContext extractFunction() {
			return getRuleContext(ExtractFunctionContext.class,0);
		}
		public TrimFunctionContext trimFunction() {
			return getRuleContext(TrimFunctionContext.class,0);
		}
		public SpecialFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterSpecialFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitSpecialFunction(this);
		}
	}

	public final SpecialFunctionContext specialFunction() throws RecognitionException {
		SpecialFunctionContext _localctx = new SpecialFunctionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_specialFunction);
		try {
			setState(614);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(608);
				castFunction();
				}
				break;
			case CONVERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(609);
				convertFunction();
				}
				break;
			case POSITION:
				enterOuterAlt(_localctx, 3);
				{
				setState(610);
				positionFunction();
				}
				break;
			case SUBSTRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(611);
				substringFunction();
				}
				break;
			case EXTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(612);
				extractFunction();
				}
				break;
			case TRIM:
				enterOuterAlt(_localctx, 6);
				{
				setState(613);
				trimFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastFunctionContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(BaseRuleParser.CAST, 0); }
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public TerminalNode AS() { return getToken(BaseRuleParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NULL() { return getToken(BaseRuleParser.NULL, 0); }
		public CastFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterCastFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitCastFunction(this);
		}
	}

	public final CastFunctionContext castFunction() throws RecognitionException {
		CastFunctionContext _localctx = new CastFunctionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_castFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			match(CAST);
			setState(617);
			match(LP_);
			setState(620);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(618);
				expr(0);
				}
				break;
			case 2:
				{
				setState(619);
				match(NULL);
				}
				break;
			}
			setState(622);
			match(AS);
			setState(623);
			dataType();
			setState(624);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConvertFunctionContext extends ParserRuleContext {
		public TerminalNode CONVERT() { return getToken(BaseRuleParser.CONVERT, 0); }
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode USING() { return getToken(BaseRuleParser.USING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public ConvertFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_convertFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterConvertFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitConvertFunction(this);
		}
	}

	public final ConvertFunctionContext convertFunction() throws RecognitionException {
		ConvertFunctionContext _localctx = new ConvertFunctionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_convertFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(CONVERT);
			setState(627);
			match(LP_);
			setState(628);
			expr(0);
			setState(629);
			match(USING);
			setState(630);
			identifier();
			setState(631);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PositionFunctionContext extends ParserRuleContext {
		public TerminalNode POSITION() { return getToken(BaseRuleParser.POSITION, 0); }
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(BaseRuleParser.IN, 0); }
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public PositionFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positionFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterPositionFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitPositionFunction(this);
		}
	}

	public final PositionFunctionContext positionFunction() throws RecognitionException {
		PositionFunctionContext _localctx = new PositionFunctionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_positionFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			match(POSITION);
			setState(634);
			match(LP_);
			setState(635);
			expr(0);
			setState(636);
			match(IN);
			setState(637);
			expr(0);
			setState(638);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubstringFunctionContext extends ParserRuleContext {
		public TerminalNode SUBSTRING() { return getToken(BaseRuleParser.SUBSTRING, 0); }
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FROM() { return getToken(BaseRuleParser.FROM, 0); }
		public List<TerminalNode> NUMBER_() { return getTokens(BaseRuleParser.NUMBER_); }
		public TerminalNode NUMBER_(int i) {
			return getToken(BaseRuleParser.NUMBER_, i);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public TerminalNode FOR() { return getToken(BaseRuleParser.FOR, 0); }
		public SubstringFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substringFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterSubstringFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitSubstringFunction(this);
		}
	}

	public final SubstringFunctionContext substringFunction() throws RecognitionException {
		SubstringFunctionContext _localctx = new SubstringFunctionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_substringFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(SUBSTRING);
			setState(641);
			match(LP_);
			setState(642);
			expr(0);
			setState(643);
			match(FROM);
			setState(644);
			match(NUMBER_);
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(645);
				match(FOR);
				setState(646);
				match(NUMBER_);
				}
			}

			setState(649);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtractFunctionContext extends ParserRuleContext {
		public TerminalNode EXTRACT() { return getToken(BaseRuleParser.EXTRACT, 0); }
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode FROM() { return getToken(BaseRuleParser.FROM, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public ExtractFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extractFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterExtractFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitExtractFunction(this);
		}
	}

	public final ExtractFunctionContext extractFunction() throws RecognitionException {
		ExtractFunctionContext _localctx = new ExtractFunctionContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_extractFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			match(EXTRACT);
			setState(652);
			match(LP_);
			setState(653);
			identifier();
			setState(654);
			match(FROM);
			setState(655);
			expr(0);
			setState(656);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrimFunctionContext extends ParserRuleContext {
		public TerminalNode TRIM() { return getToken(BaseRuleParser.TRIM, 0); }
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public List<TerminalNode> STRING_() { return getTokens(BaseRuleParser.STRING_); }
		public TerminalNode STRING_(int i) {
			return getToken(BaseRuleParser.STRING_, i);
		}
		public TerminalNode FROM() { return getToken(BaseRuleParser.FROM, 0); }
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public TerminalNode LEADING() { return getToken(BaseRuleParser.LEADING, 0); }
		public TerminalNode BOTH() { return getToken(BaseRuleParser.BOTH, 0); }
		public TerminalNode TRAILING() { return getToken(BaseRuleParser.TRAILING, 0); }
		public TrimFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trimFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterTrimFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitTrimFunction(this);
		}
	}

	public final TrimFunctionContext trimFunction() throws RecognitionException {
		TrimFunctionContext _localctx = new TrimFunctionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_trimFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			match(TRIM);
			setState(659);
			match(LP_);
			setState(660);
			_la = _input.LA(1);
			if ( !(((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(661);
			match(STRING_);
			setState(662);
			match(FROM);
			setState(663);
			match(STRING_);
			setState(664);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegularFunctionContext extends ParserRuleContext {
		public RegularFunctionNameContext regularFunctionName() {
			return getRuleContext(RegularFunctionNameContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public Paren_tokenContext paren_token() {
			return getRuleContext(Paren_tokenContext.class,0);
		}
		public RegularFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterRegularFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitRegularFunction(this);
		}
	}

	public final RegularFunctionContext regularFunction() throws RecognitionException {
		RegularFunctionContext _localctx = new RegularFunctionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_regularFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			regularFunctionName();
			setState(669);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP_:
				{
				setState(667);
				exprList();
				}
				break;
			case PAREN_TOKEN:
				{
				setState(668);
				paren_token();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegularFunctionNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(BaseRuleParser.IF, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(BaseRuleParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode LOCALTIME() { return getToken(BaseRuleParser.LOCALTIME, 0); }
		public TerminalNode LOCALTIMESTAMP() { return getToken(BaseRuleParser.LOCALTIMESTAMP, 0); }
		public TerminalNode INTERVAL() { return getToken(BaseRuleParser.INTERVAL, 0); }
		public AllKeywordsContext allKeywords() {
			return getRuleContext(AllKeywordsContext.class,0);
		}
		public RegularFunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularFunctionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterRegularFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitRegularFunctionName(this);
		}
	}

	public final RegularFunctionNameContext regularFunctionName() throws RecognitionException {
		RegularFunctionNameContext _localctx = new RegularFunctionNameContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_regularFunctionName);
		try {
			setState(678);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(671);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
				match(IF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(673);
				match(CURRENT_TIMESTAMP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(674);
				match(LOCALTIME);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(675);
				match(LOCALTIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(676);
				match(INTERVAL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(677);
				allKeywords();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchExpressionContext extends ParserRuleContext {
		public LiteralsContext literals() {
			return getRuleContext(LiteralsContext.class,0);
		}
		public TerminalNode MATCH() { return getToken(BaseRuleParser.MATCH, 0); }
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode PARTIAL() { return getToken(BaseRuleParser.PARTIAL, 0); }
		public TerminalNode FULL() { return getToken(BaseRuleParser.FULL, 0); }
		public TerminalNode UNIQUE() { return getToken(BaseRuleParser.UNIQUE, 0); }
		public MatchExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterMatchExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitMatchExpression(this);
		}
	}

	public final MatchExpressionContext matchExpression() throws RecognitionException {
		MatchExpressionContext _localctx = new MatchExpressionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_matchExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			literals();
			setState(681);
			match(MATCH);
			setState(683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(682);
				match(UNIQUE);
				}
			}

			setState(685);
			_la = _input.LA(1);
			if ( !(_la==FULL || _la==PARTIAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(686);
			subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseExpressionContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(BaseRuleParser.CASE, 0); }
		public TerminalNode END() { return getToken(BaseRuleParser.END, 0); }
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public List<CaseWhenContext> caseWhen() {
			return getRuleContexts(CaseWhenContext.class);
		}
		public CaseWhenContext caseWhen(int i) {
			return getRuleContext(CaseWhenContext.class,i);
		}
		public CaseElseContext caseElse() {
			return getRuleContext(CaseElseContext.class,0);
		}
		public CaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitCaseExpression(this);
		}
	}

	public final CaseExpressionContext caseExpression() throws RecognitionException {
		CaseExpressionContext _localctx = new CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_caseExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			match(CASE);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7968774627278L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -35439720242549281L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 157942508867813375L) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & 36028797018963967L) != 0)) {
				{
				setState(689);
				simpleExpr(0);
				}
			}

			setState(693); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(692);
				caseWhen();
				}
				}
				setState(695); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(697);
				caseElse();
				}
			}

			setState(700);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseWhenContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(BaseRuleParser.WHEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(BaseRuleParser.THEN, 0); }
		public CaseWhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseWhen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterCaseWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitCaseWhen(this);
		}
	}

	public final CaseWhenContext caseWhen() throws RecognitionException {
		CaseWhenContext _localctx = new CaseWhenContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_caseWhen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			match(WHEN);
			setState(703);
			expr(0);
			setState(704);
			match(THEN);
			setState(705);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseElseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(BaseRuleParser.ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CaseElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterCaseElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitCaseElse(this);
		}
	}

	public final CaseElseContext caseElse() throws RecognitionException {
		CaseElseContext _localctx = new CaseElseContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_caseElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			match(ELSE);
			setState(708);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntervalExpressionContext extends ParserRuleContext {
		public TerminalNode INTERVAL() { return getToken(BaseRuleParser.INTERVAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IntervalUnitContext intervalUnit() {
			return getRuleContext(IntervalUnitContext.class,0);
		}
		public IntervalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterIntervalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitIntervalExpression(this);
		}
	}

	public final IntervalExpressionContext intervalExpression() throws RecognitionException {
		IntervalExpressionContext _localctx = new IntervalExpressionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_intervalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			match(INTERVAL);
			setState(711);
			expr(0);
			setState(712);
			intervalUnit();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntervalUnitContext extends ParserRuleContext {
		public TerminalNode MICROSECOND() { return getToken(BaseRuleParser.MICROSECOND, 0); }
		public TerminalNode SECOND() { return getToken(BaseRuleParser.SECOND, 0); }
		public TerminalNode MINUTE() { return getToken(BaseRuleParser.MINUTE, 0); }
		public TerminalNode HOUR() { return getToken(BaseRuleParser.HOUR, 0); }
		public TerminalNode DAY() { return getToken(BaseRuleParser.DAY, 0); }
		public TerminalNode WEEK() { return getToken(BaseRuleParser.WEEK, 0); }
		public TerminalNode MONTH() { return getToken(BaseRuleParser.MONTH, 0); }
		public TerminalNode QUARTER() { return getToken(BaseRuleParser.QUARTER, 0); }
		public TerminalNode YEAR() { return getToken(BaseRuleParser.YEAR, 0); }
		public IntervalUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterIntervalUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitIntervalUnit(this);
		}
	}

	public final IntervalUnitContext intervalUnit() throws RecognitionException {
		IntervalUnitContext _localctx = new IntervalUnitContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_intervalUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			_la = _input.LA(1);
			if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & 511L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubqueryContext extends ParserRuleContext {
		public SubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitSubquery(this);
		}
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeNameContext dataTypeName() {
			return getRuleContext(DataTypeNameContext.class,0);
		}
		public DataTypeLengthContext dataTypeLength() {
			return getRuleContext(DataTypeLengthContext.class,0);
		}
		public CharacterSetContext characterSet() {
			return getRuleContext(CharacterSetContext.class,0);
		}
		public CollateClauseContext collateClause() {
			return getRuleContext(CollateClauseContext.class,0);
		}
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public List<TerminalNode> STRING_() { return getTokens(BaseRuleParser.STRING_); }
		public TerminalNode STRING_(int i) {
			return getToken(BaseRuleParser.STRING_, i);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public List<TerminalNode> COMMA_() { return getTokens(BaseRuleParser.COMMA_); }
		public TerminalNode COMMA_(int i) {
			return getToken(BaseRuleParser.COMMA_, i);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitDataType(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_dataType);
		int _la;
		try {
			setState(745);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(718);
				dataTypeName();
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LP_) {
					{
					setState(719);
					dataTypeLength();
					}
				}

				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR || _la==CHARACTER) {
					{
					setState(722);
					characterSet();
					}
				}

				setState(726);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLLATE) {
					{
					setState(725);
					collateClause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(728);
				dataTypeName();
				setState(729);
				match(LP_);
				setState(730);
				match(STRING_);
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_) {
					{
					{
					setState(731);
					match(COMMA_);
					setState(732);
					match(STRING_);
					}
					}
					setState(737);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(738);
				match(RP_);
				setState(740);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR || _la==CHARACTER) {
					{
					setState(739);
					characterSet();
					}
				}

				setState(743);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLLATE) {
					{
					setState(742);
					collateClause();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeNameContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(BaseRuleParser.CHARACTER, 0); }
		public TerminalNode VARYING() { return getToken(BaseRuleParser.VARYING, 0); }
		public TerminalNode NATIONAL() { return getToken(BaseRuleParser.NATIONAL, 0); }
		public TerminalNode CHAR() { return getToken(BaseRuleParser.CHAR, 0); }
		public TerminalNode VARCHAR() { return getToken(BaseRuleParser.VARCHAR, 0); }
		public TerminalNode NCHAR() { return getToken(BaseRuleParser.NCHAR, 0); }
		public TerminalNode BIT() { return getToken(BaseRuleParser.BIT, 0); }
		public TerminalNode NUMERIC() { return getToken(BaseRuleParser.NUMERIC, 0); }
		public TerminalNode DECIMAL() { return getToken(BaseRuleParser.DECIMAL, 0); }
		public TerminalNode DEC() { return getToken(BaseRuleParser.DEC, 0); }
		public TerminalNode INTEGER() { return getToken(BaseRuleParser.INTEGER, 0); }
		public TerminalNode SMALLINT() { return getToken(BaseRuleParser.SMALLINT, 0); }
		public TerminalNode FLOAT() { return getToken(BaseRuleParser.FLOAT, 0); }
		public TerminalNode REAL() { return getToken(BaseRuleParser.REAL, 0); }
		public TerminalNode DOUBLE() { return getToken(BaseRuleParser.DOUBLE, 0); }
		public TerminalNode PRECISION() { return getToken(BaseRuleParser.PRECISION, 0); }
		public TerminalNode DATE() { return getToken(BaseRuleParser.DATE, 0); }
		public List<TerminalNode> TIME() { return getTokens(BaseRuleParser.TIME); }
		public TerminalNode TIME(int i) {
			return getToken(BaseRuleParser.TIME, i);
		}
		public TerminalNode TIMESTAMP() { return getToken(BaseRuleParser.TIMESTAMP, 0); }
		public TerminalNode INTERVAL() { return getToken(BaseRuleParser.INTERVAL, 0); }
		public TerminalNode WITH() { return getToken(BaseRuleParser.WITH, 0); }
		public TerminalNode ZONE() { return getToken(BaseRuleParser.ZONE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterDataTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitDataTypeName(this);
		}
	}

	public final DataTypeNameContext dataTypeName() throws RecognitionException {
		DataTypeNameContext _localctx = new DataTypeNameContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_dataTypeName);
		try {
			setState(788);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(747);
				match(CHARACTER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(748);
				match(CHARACTER);
				setState(749);
				match(VARYING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(750);
				match(NATIONAL);
				setState(751);
				match(CHARACTER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(752);
				match(NATIONAL);
				setState(753);
				match(CHARACTER);
				setState(754);
				match(VARYING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(755);
				match(CHAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(756);
				match(VARCHAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(757);
				match(NCHAR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(758);
				match(NATIONAL);
				setState(759);
				match(CHAR);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(760);
				match(NATIONAL);
				setState(761);
				match(CHAR);
				setState(762);
				match(VARYING);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(763);
				match(BIT);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(764);
				match(BIT);
				setState(765);
				match(VARYING);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(766);
				match(NUMERIC);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(767);
				match(DECIMAL);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(768);
				match(DEC);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(769);
				match(INTEGER);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(770);
				match(SMALLINT);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(771);
				match(FLOAT);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(772);
				match(REAL);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(773);
				match(DOUBLE);
				setState(774);
				match(PRECISION);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(775);
				match(DATE);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(776);
				match(TIME);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(777);
				match(TIMESTAMP);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(778);
				match(INTERVAL);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(779);
				match(TIME);
				setState(780);
				match(WITH);
				setState(781);
				match(TIME);
				setState(782);
				match(ZONE);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(783);
				match(TIMESTAMP);
				setState(784);
				match(WITH);
				setState(785);
				match(TIME);
				setState(786);
				match(ZONE);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(787);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeLengthContext extends ParserRuleContext {
		public TerminalNode LP_() { return getToken(BaseRuleParser.LP_, 0); }
		public List<TerminalNode> NUMBER_() { return getTokens(BaseRuleParser.NUMBER_); }
		public TerminalNode NUMBER_(int i) {
			return getToken(BaseRuleParser.NUMBER_, i);
		}
		public TerminalNode RP_() { return getToken(BaseRuleParser.RP_, 0); }
		public TerminalNode COMMA_() { return getToken(BaseRuleParser.COMMA_, 0); }
		public DataTypeLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeLength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterDataTypeLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitDataTypeLength(this);
		}
	}

	public final DataTypeLengthContext dataTypeLength() throws RecognitionException {
		DataTypeLengthContext _localctx = new DataTypeLengthContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_dataTypeLength);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			match(LP_);
			setState(791);
			match(NUMBER_);
			setState(794);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_) {
				{
				setState(792);
				match(COMMA_);
				setState(793);
				match(NUMBER_);
				}
			}

			setState(796);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CharacterSetContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(BaseRuleParser.SET, 0); }
		public IgnoredIdentifierContext ignoredIdentifier() {
			return getRuleContext(IgnoredIdentifierContext.class,0);
		}
		public TerminalNode CHARACTER() { return getToken(BaseRuleParser.CHARACTER, 0); }
		public TerminalNode CHAR() { return getToken(BaseRuleParser.CHAR, 0); }
		public TerminalNode EQ_() { return getToken(BaseRuleParser.EQ_, 0); }
		public CharacterSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterCharacterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitCharacterSet(this);
		}
	}

	public final CharacterSetContext characterSet() throws RecognitionException {
		CharacterSetContext _localctx = new CharacterSetContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_characterSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			_la = _input.LA(1);
			if ( !(_la==CHAR || _la==CHARACTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(799);
			match(SET);
			setState(801);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ_) {
				{
				setState(800);
				match(EQ_);
				}
			}

			setState(803);
			ignoredIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CollateClauseContext extends ParserRuleContext {
		public TerminalNode COLLATE() { return getToken(BaseRuleParser.COLLATE, 0); }
		public TerminalNode STRING_() { return getToken(BaseRuleParser.STRING_, 0); }
		public IgnoredIdentifierContext ignoredIdentifier() {
			return getRuleContext(IgnoredIdentifierContext.class,0);
		}
		public TerminalNode EQ_() { return getToken(BaseRuleParser.EQ_, 0); }
		public CollateClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collateClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterCollateClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitCollateClause(this);
		}
	}

	public final CollateClauseContext collateClause() throws RecognitionException {
		CollateClauseContext _localctx = new CollateClauseContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_collateClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			match(COLLATE);
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ_) {
				{
				setState(806);
				match(EQ_);
				}
			}

			setState(811);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_:
				{
				setState(809);
				match(STRING_);
				}
				break;
			case NAME:
			case TYPE:
			case IDENTIFIER_:
			case ADA:
			case C92:
			case CATALOG_NAME:
			case CHARACTER_SET_CATALOG:
			case CHARACTER_SET_NAME:
			case CHARACTER_SET_SCHEMA:
			case CLASS_ORIGIN:
			case COBOL:
			case COLLATION_CATALOG:
			case COLLATION_NAME:
			case COLLATION_SCHEMA:
			case COLUMN_NAME:
			case COMMAND_FUNCTION:
			case COMMITTED:
			case CONDITION_NUMBER:
			case CONNECTION_NAME:
			case CONSTRAINT_CATALOG:
			case CONSTRAINT_NAME:
			case CONSTRAINT_SCHEMA:
			case CURSOR_NAME:
			case DATA:
			case DATETIME_INTERVAL_CODE:
			case DATETIME_INTERVAL_PRECISION:
			case DYNAMIC_FUNCTION:
			case FORTRAN:
			case LENGTH:
			case MESSAGE_LENGTH:
			case MESSAGE_OCTET_LENGTH:
			case MESSAGE_TEXT:
			case MORE92:
			case MUMPS:
			case NULLABLE:
			case NUMBER:
			case PASCAL:
			case PLI:
			case REPEATABLE:
			case RETURNED_LENGTH:
			case RETURNED_OCTET_LENGTH:
			case RETURNED_SQLSTATE:
			case ROW_COUNT:
			case SCALE:
			case SCHEMA_NAME:
			case SERIALIZABLE:
			case SERVER_NAME:
			case SUBCLASS_ORIGIN:
			case TABLE_NAME:
			case UNCOMMITTED:
			case UNNAMED:
				{
				setState(810);
				ignoredIdentifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IgnoredIdentifierContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode DOT_() { return getToken(BaseRuleParser.DOT_, 0); }
		public IgnoredIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ignoredIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterIgnoredIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitIgnoredIdentifier(this);
		}
	}

	public final IgnoredIdentifierContext ignoredIdentifier() throws RecognitionException {
		IgnoredIdentifierContext _localctx = new IgnoredIdentifierContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_ignoredIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(813);
			identifier();
			setState(816);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(814);
				match(DOT_);
				setState(815);
				identifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DropBehaviourContext extends ParserRuleContext {
		public TerminalNode CASCADE() { return getToken(BaseRuleParser.CASCADE, 0); }
		public TerminalNode RESTRICT() { return getToken(BaseRuleParser.RESTRICT, 0); }
		public DropBehaviourContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropBehaviour; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).enterDropBehaviour(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseRuleListener ) ((BaseRuleListener)listener).exitDropBehaviour(this);
		}
	}

	public final DropBehaviourContext dropBehaviour() throws RecognitionException {
		DropBehaviourContext _localctx = new DropBehaviourContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_dropBehaviour);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(818);
				_la = _input.LA(1);
				if ( !(_la==CASCADE || _la==RESTRICT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 27:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 32:
			return booleanPrimary_sempred((BooleanPrimaryContext)_localctx, predIndex);
		case 39:
			return bitExpr_sempred((BitExprContext)_localctx, predIndex);
		case 41:
			return simpleExpr_sempred((SimpleExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean booleanPrimary_sempred(BooleanPrimaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitExpr_sempred(BitExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean simpleExpr_sempred(SimpleExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00fd\u0336\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u009b\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0003"+
		"\u0003\u00a0\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a4\b\u0003"+
		"\u0001\u0004\u0003\u0004\u00a7\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00b2\b\u0005\u0001\u0006\u0003\u0006\u00b5\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00b9\b\u0006\u0001\u0007\u0003\u0007\u00bc"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c0\b\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u00c8\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u012b\b\f\u0001"+
		"\r\u0003\r\u012e\b\r\u0001\r\u0003\r\u0131\b\r\u0001\r\u0003\r\u0134\b"+
		"\r\u0001\r\u0003\r\u0137\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0140\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0147\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u014c\b\u0010\u0001\u0011\u0003"+
		"\u0011\u014f\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0153\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u015e\b\u0014\u0001\u0014"+
		"\u0003\u0014\u0161\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0003\u0018\u016a\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u016f\b\u0018\n\u0018\f\u0018\u0172"+
		"\t\u0018\u0001\u0018\u0003\u0018\u0175\b\u0018\u0001\u0019\u0003\u0019"+
		"\u0178\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u017d\b"+
		"\u0019\n\u0019\f\u0019\u0180\t\u0019\u0001\u0019\u0003\u0019\u0183\b\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u0190\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b"+
		"\u0196\b\u001b\n\u001b\f\u001b\u0199\t\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01a1\b\u001d\n"+
		"\u001d\f\u001d\u01a4\t\u001d\u0001\u001d\u0003\u001d\u01a7\b\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u01ad\b\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01b2\b\u001e\u0001\u001e\u0005"+
		"\u001e\u01b5\b\u001e\n\u001e\f\u001e\u01b8\t\u001e\u0001\u001e\u0003\u001e"+
		"\u01bb\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0005 \u01d0\b \n \f \u01d3\t \u0001!\u0001"+
		"!\u0003!\u01d7\b!\u0001\"\u0001\"\u0003\"\u01db\b\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0003#\u01e1\b#\u0001$\u0001$\u0003$\u01e5\b$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0003$\u01ec\b$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003"+
		"$\u01f3\b$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u01fa\b$\u0001$\u0001"+
		"$\u0001$\u0003$\u01ff\b$\u0001%\u0001%\u0003%\u0203\b%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001&\u0001&\u0003&\u020c\b&\u0001&\u0001&\u0001&\u0001"+
		"&\u0003&\u0212\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0005\'\u021b\b\'\n\'\f\'\u021e\t\'\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0003)\u023d\b)\u0001)\u0001)\u0001)\u0001"+
		")\u0003)\u0243\b)\u0005)\u0245\b)\n)\f)\u0248\t)\u0001*\u0001*\u0001+"+
		"\u0001+\u0001,\u0001,\u0001,\u0003,\u0251\b,\u0001-\u0001-\u0001-\u0003"+
		"-\u0256\b-\u0001.\u0001.\u0001.\u0003.\u025b\b.\u0001/\u0001/\u00010\u0001"+
		"0\u00011\u00011\u00011\u00011\u00011\u00011\u00031\u0267\b1\u00012\u0001"+
		"2\u00012\u00012\u00032\u026d\b2\u00012\u00012\u00012\u00012\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0003"+
		"5\u0288\b5\u00015\u00015\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00018\u0001"+
		"8\u00018\u00038\u029e\b8\u00019\u00019\u00019\u00019\u00019\u00019\u0001"+
		"9\u00039\u02a7\b9\u0001:\u0001:\u0001:\u0003:\u02ac\b:\u0001:\u0001:\u0001"+
		":\u0001;\u0001;\u0003;\u02b3\b;\u0001;\u0004;\u02b6\b;\u000b;\f;\u02b7"+
		"\u0001;\u0003;\u02bb\b;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0001=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001?\u0001?\u0001"+
		"@\u0001@\u0001A\u0001A\u0003A\u02d1\bA\u0001A\u0003A\u02d4\bA\u0001A\u0003"+
		"A\u02d7\bA\u0001A\u0001A\u0001A\u0001A\u0001A\u0005A\u02de\bA\nA\fA\u02e1"+
		"\tA\u0001A\u0001A\u0003A\u02e5\bA\u0001A\u0003A\u02e8\bA\u0003A\u02ea"+
		"\bA\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0003B\u0315\bB\u0001C\u0001C\u0001C\u0001C\u0003C\u031b\bC\u0001"+
		"C\u0001C\u0001D\u0001D\u0001D\u0003D\u0322\bD\u0001D\u0001D\u0001E\u0001"+
		"E\u0003E\u0328\bE\u0001E\u0001E\u0003E\u032c\bE\u0001F\u0001F\u0001F\u0003"+
		"F\u0331\bF\u0001G\u0003G\u0334\bG\u0001G\u0000\u00046@NRH\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0000\u0011\u0001\u0000\r\u000e\u0001\u0000\u0081"+
		"\u0083\u0001\u0000gh\u0003\u0000\u00a4\u00a4\u00aa\u00aa\u00ce\u00fd\u0002"+
		"\u0000\u00a0\u00a0\u00b0\u00b0\u0002\u0000\u0002\u0002bc\u0002\u0000\u0004"+
		"\u0004ee\u0002\u0000\u0014\u0014\u0016\u001b\u0001\u0000lm\u0002\u0000"+
		"\u0004\u000b\r\u0010\u0002\u0000\u0004\u0005\r\u000e\u0001\u0000\u008f"+
		"\u0093\u0001\u0000\u00b6\u00b8\u0002\u0000SS\u00bb\u00bb\u0001\u0000\u0086"+
		"\u008e\u0001\u0000}~\u0001\u0000\u00c5\u00c6\u03da\u0000\u0090\u0001\u0000"+
		"\u0000\u0000\u0002\u009a\u0001\u0000\u0000\u0000\u0004\u009c\u0001\u0000"+
		"\u0000\u0000\u0006\u009f\u0001\u0000\u0000\u0000\b\u00a6\u0001\u0000\u0000"+
		"\u0000\n\u00b1\u0001\u0000\u0000\u0000\f\u00b4\u0001\u0000\u0000\u0000"+
		"\u000e\u00bb\u0001\u0000\u0000\u0000\u0010\u00c1\u0001\u0000\u0000\u0000"+
		"\u0012\u00c3\u0001\u0000\u0000\u0000\u0014\u00c7\u0001\u0000\u0000\u0000"+
		"\u0016\u00c9\u0001\u0000\u0000\u0000\u0018\u012a\u0001\u0000\u0000\u0000"+
		"\u001a\u0130\u0001\u0000\u0000\u0000\u001c\u013a\u0001\u0000\u0000\u0000"+
		"\u001e\u013f\u0001\u0000\u0000\u0000 \u014b\u0001\u0000\u0000\u0000\""+
		"\u014e\u0001\u0000\u0000\u0000$\u0154\u0001\u0000\u0000\u0000&\u0156\u0001"+
		"\u0000\u0000\u0000(\u0160\u0001\u0000\u0000\u0000*\u0162\u0001\u0000\u0000"+
		"\u0000,\u0164\u0001\u0000\u0000\u0000.\u0166\u0001\u0000\u0000\u00000"+
		"\u0169\u0001\u0000\u0000\u00002\u0177\u0001\u0000\u0000\u00004\u0184\u0001"+
		"\u0000\u0000\u00006\u018f\u0001\u0000\u0000\u00008\u019a\u0001\u0000\u0000"+
		"\u0000:\u019c\u0001\u0000\u0000\u0000<\u01aa\u0001\u0000\u0000\u0000>"+
		"\u01be\u0001\u0000\u0000\u0000@\u01c0\u0001\u0000\u0000\u0000B\u01d4\u0001"+
		"\u0000\u0000\u0000D\u01d8\u0001\u0000\u0000\u0000F\u01e0\u0001\u0000\u0000"+
		"\u0000H\u01fe\u0001\u0000\u0000\u0000J\u0200\u0001\u0000\u0000\u0000L"+
		"\u0209\u0001\u0000\u0000\u0000N\u0213\u0001\u0000\u0000\u0000P\u021f\u0001"+
		"\u0000\u0000\u0000R\u023c\u0001\u0000\u0000\u0000T\u0249\u0001\u0000\u0000"+
		"\u0000V\u024b\u0001\u0000\u0000\u0000X\u024d\u0001\u0000\u0000\u0000Z"+
		"\u0255\u0001\u0000\u0000\u0000\\\u0257\u0001\u0000\u0000\u0000^\u025c"+
		"\u0001\u0000\u0000\u0000`\u025e\u0001\u0000\u0000\u0000b\u0266\u0001\u0000"+
		"\u0000\u0000d\u0268\u0001\u0000\u0000\u0000f\u0272\u0001\u0000\u0000\u0000"+
		"h\u0279\u0001\u0000\u0000\u0000j\u0280\u0001\u0000\u0000\u0000l\u028b"+
		"\u0001\u0000\u0000\u0000n\u0292\u0001\u0000\u0000\u0000p\u029a\u0001\u0000"+
		"\u0000\u0000r\u02a6\u0001\u0000\u0000\u0000t\u02a8\u0001\u0000\u0000\u0000"+
		"v\u02b0\u0001\u0000\u0000\u0000x\u02be\u0001\u0000\u0000\u0000z\u02c3"+
		"\u0001\u0000\u0000\u0000|\u02c6\u0001\u0000\u0000\u0000~\u02ca\u0001\u0000"+
		"\u0000\u0000\u0080\u02cc\u0001\u0000\u0000\u0000\u0082\u02e9\u0001\u0000"+
		"\u0000\u0000\u0084\u0314\u0001\u0000\u0000\u0000\u0086\u0316\u0001\u0000"+
		"\u0000\u0000\u0088\u031e\u0001\u0000\u0000\u0000\u008a\u0325\u0001\u0000"+
		"\u0000\u0000\u008c\u032d\u0001\u0000\u0000\u0000\u008e\u0333\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0005&\u0000\u0000\u0091\u0001\u0001\u0000\u0000"+
		"\u0000\u0092\u009b\u0003\u0006\u0003\u0000\u0093\u009b\u0003\b\u0004\u0000"+
		"\u0094\u009b\u0003\n\u0005\u0000\u0095\u009b\u0003\f\u0006\u0000\u0096"+
		"\u009b\u0003\u000e\u0007\u0000\u0097\u009b\u0003\u0010\b\u0000\u0098\u009b"+
		"\u0003\u0012\t\u0000\u0099\u009b\u0003\u0004\u0002\u0000\u009a\u0092\u0001"+
		"\u0000\u0000\u0000\u009a\u0093\u0001\u0000\u0000\u0000\u009a\u0094\u0001"+
		"\u0000\u0000\u0000\u009a\u0095\u0001\u0000\u0000\u0000\u009a\u0096\u0001"+
		"\u0000\u0000\u0000\u009a\u0097\u0001\u0000\u0000\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u0003\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005\u000f\u0000\u0000\u009d\u0005\u0001"+
		"\u0000\u0000\u0000\u009e\u00a0\u00034\u001a\u0000\u009f\u009e\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a3\u0005\u00ca\u0000\u0000\u00a2\u00a4\u0003\u008a"+
		"E\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u0007\u0001\u0000\u0000\u0000\u00a5\u00a7\u0007\u0000\u0000"+
		"\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u00cb\u0000"+
		"\u0000\u00a9\t\u0001\u0000\u0000\u0000\u00aa\u00ab\u0007\u0001\u0000\u0000"+
		"\u00ab\u00b2\u0005\u00ca\u0000\u0000\u00ac\u00ad\u0005\u001f\u0000\u0000"+
		"\u00ad\u00ae\u0003\u0014\n\u0000\u00ae\u00af\u0005\u00ca\u0000\u0000\u00af"+
		"\u00b0\u0005 \u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00aa"+
		"\u0001\u0000\u0000\u0000\u00b1\u00ac\u0001\u0000\u0000\u0000\u00b2\u000b"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b5\u00034\u001a\u0000\u00b4\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b8\u0005\u00cc\u0000\u0000\u00b7\u00b9\u0003"+
		"\u008aE\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b9\r\u0001\u0000\u0000\u0000\u00ba\u00bc\u00034\u001a"+
		"\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0005\u00cd\u0000"+
		"\u0000\u00be\u00c0\u0003\u008aE\u0000\u00bf\u00be\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u000f\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0007\u0002\u0000\u0000\u00c2\u0011\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0005f\u0000\u0000\u00c4\u0013\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c8\u0005\u00c7\u0000\u0000\u00c6\u00c8\u0003\u0016\u000b\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u0015\u0001\u0000\u0000\u0000\u00c9\u00ca\u0007\u0003\u0000\u0000\u00ca"+
		"\u0017\u0001\u0000\u0000\u0000\u00cb\u012b\u00055\u0000\u0000\u00cc\u012b"+
		"\u0005l\u0000\u0000\u00cd\u012b\u0005/\u0000\u0000\u00ce\u012b\u0005\u007f"+
		"\u0000\u0000\u00cf\u012b\u0001\u0000\u0000\u0000\u00d0\u012b\u0005\u0093"+
		"\u0000\u0000\u00d1\u012b\u0005w\u0000\u0000\u00d2\u012b\u0005j\u0000\u0000"+
		"\u00d3\u012b\u0005{\u0000\u0000\u00d4\u012b\u0005q\u0000\u0000\u00d5\u012b"+
		"\u0005\u0098\u0000\u0000\u00d6\u012b\u0005\u009f\u0000\u0000\u00d7\u012b"+
		"\u0005M\u0000\u0000\u00d8\u012b\u0005}\u0000\u0000\u00d9\u012b\u0005~"+
		"\u0000\u0000\u00da\u012b\u0005\u00a1\u0000\u0000\u00db\u012b\u00058\u0000"+
		"\u0000\u00dc\u012b\u0005x\u0000\u0000\u00dd\u012b\u0005:\u0000\u0000\u00de"+
		"\u012b\u0005\u0092\u0000\u0000\u00df\u012b\u0005.\u0000\u0000\u00e0\u012b"+
		"\u0005\u0095\u0000\u0000\u00e1\u012b\u0005\u009d\u0000\u0000\u00e2\u012b"+
		"\u0005\u0081\u0000\u0000\u00e3\u012b\u0005\u008a\u0000\u0000\u00e4\u012b"+
		"\u0005\u00a9\u0000\u0000\u00e5\u012b\u0005\u0094\u0000\u0000\u00e6\u012b"+
		"\u0005\u009c\u0000\u0000\u00e7\u012b\u0005-\u0000\u0000\u00e8\u012b\u0005"+
		"\u0097\u0000\u0000\u00e9\u012b\u0005J\u0000\u0000\u00ea\u012b\u0005\u009b"+
		"\u0000\u0000\u00eb\u012b\u0005|\u0000\u0000\u00ec\u012b\u00050\u0000\u0000"+
		"\u00ed\u012b\u0005\u0096\u0000\u0000\u00ee\u012b\u0001\u0000\u0000\u0000"+
		"\u00ef\u012b\u0005\u00ac\u0000\u0000\u00f0\u012b\u0005`\u0000\u0000\u00f1"+
		"\u012b\u0005=\u0000\u0000\u00f2\u012b\u0001\u0000\u0000\u0000\u00f3\u012b"+
		"\u0005A\u0000\u0000\u00f4\u012b\u00053\u0000\u0000\u00f5\u012b\u0005\u008b"+
		"\u0000\u0000\u00f6\u012b\u00059\u0000\u0000\u00f7\u012b\u0005+\u0000\u0000"+
		"\u00f8\u012b\u0005\u0099\u0000\u0000\u00f9\u012b\u0005\u00a7\u0000\u0000"+
		"\u00fa\u012b\u0005\u0080\u0000\u0000\u00fb\u012b\u0005>\u0000\u0000\u00fc"+
		"\u012b\u0001\u0000\u0000\u0000\u00fd\u012b\u0005\u00a0\u0000\u0000\u00fe"+
		"\u012b\u0005\u0084\u0000\u0000\u00ff\u012b\u0005\u0085\u0000\u0000\u0100"+
		"\u012b\u0005\u008f\u0000\u0000\u0101\u012b\u0005\u008e\u0000\u0000\u0102"+
		"\u012b\u0005\u0090\u0000\u0000\u0103\u012b\u0005\u008c\u0000\u0000\u0104"+
		"\u012b\u0005\u0088\u0000\u0000\u0105\u012b\u0005\u00a4\u0000\u0000\u0106"+
		"\u012b\u0005\u00a6\u0000\u0000\u0107\u012b\u0005\u00a3\u0000\u0000\u0108"+
		"\u012b\u0005\u00a2\u0000\u0000\u0109\u012b\u0001\u0000\u0000\u0000\u010a"+
		"\u012b\u0005?\u0000\u0000\u010b\u012b\u0005@\u0000\u0000\u010c\u012b\u0005"+
		"\u009a\u0000\u0000\u010d\u012b\u0005;\u0000\u0000\u010e\u012b\u0005C\u0000"+
		"\u0000\u010f\u012b\u0005\u0087\u0000\u0000\u0110\u012b\u0005\u00a8\u0000"+
		"\u0000\u0111\u012b\u00054\u0000\u0000\u0112\u012b\u0005y\u0000\u0000\u0113"+
		"\u012b\u0005z\u0000\u0000\u0114\u012b\u00052\u0000\u0000\u0115\u012b\u0005"+
		"\u008d\u0000\u0000\u0116\u012b\u00056\u0000\u0000\u0117\u012b\u0005\u009e"+
		"\u0000\u0000\u0118\u012b\u0005\u0091\u0000\u0000\u0119\u012b\u00057\u0000"+
		"\u0000\u011a\u012b\u0005\u0082\u0000\u0000\u011b\u012b\u0005\u0083\u0000"+
		"\u0000\u011c\u012b\u0005a\u0000\u0000\u011d\u012b\u0005B\u0000\u0000\u011e"+
		"\u012b\u0005N\u0000\u0000\u011f\u012b\u00051\u0000\u0000\u0120\u012b\u0005"+
		"\u00aa\u0000\u0000\u0121\u012b\u0005<\u0000\u0000\u0122\u012b\u0005,\u0000"+
		"\u0000\u0123\u012b\u0005G\u0000\u0000\u0124\u012b\u0005F\u0000\u0000\u0125"+
		"\u012b\u0005\u00ab\u0000\u0000\u0126\u012b\u0005D\u0000\u0000\u0127\u012b"+
		"\u0005\u0089\u0000\u0000\u0128\u012b\u0005H\u0000\u0000\u0129\u012b\u0005"+
		"\u0086\u0000\u0000\u012a\u00cb\u0001\u0000\u0000\u0000\u012a\u00cc\u0001"+
		"\u0000\u0000\u0000\u012a\u00cd\u0001\u0000\u0000\u0000\u012a\u00ce\u0001"+
		"\u0000\u0000\u0000\u012a\u00cf\u0001\u0000\u0000\u0000\u012a\u00d0\u0001"+
		"\u0000\u0000\u0000\u012a\u00d1\u0001\u0000\u0000\u0000\u012a\u00d2\u0001"+
		"\u0000\u0000\u0000\u012a\u00d3\u0001\u0000\u0000\u0000\u012a\u00d4\u0001"+
		"\u0000\u0000\u0000\u012a\u00d5\u0001\u0000\u0000\u0000\u012a\u00d6\u0001"+
		"\u0000\u0000\u0000\u012a\u00d7\u0001\u0000\u0000\u0000\u012a\u00d8\u0001"+
		"\u0000\u0000\u0000\u012a\u00d9\u0001\u0000\u0000\u0000\u012a\u00da\u0001"+
		"\u0000\u0000\u0000\u012a\u00db\u0001\u0000\u0000\u0000\u012a\u00dc\u0001"+
		"\u0000\u0000\u0000\u012a\u00dd\u0001\u0000\u0000\u0000\u012a\u00de\u0001"+
		"\u0000\u0000\u0000\u012a\u00df\u0001\u0000\u0000\u0000\u012a\u00e0\u0001"+
		"\u0000\u0000\u0000\u012a\u00e1\u0001\u0000\u0000\u0000\u012a\u00e2\u0001"+
		"\u0000\u0000\u0000\u012a\u00e3\u0001\u0000\u0000\u0000\u012a\u00e4\u0001"+
		"\u0000\u0000\u0000\u012a\u00e5\u0001\u0000\u0000\u0000\u012a\u00e6\u0001"+
		"\u0000\u0000\u0000\u012a\u00e7\u0001\u0000\u0000\u0000\u012a\u00e8\u0001"+
		"\u0000\u0000\u0000\u012a\u00e9\u0001\u0000\u0000\u0000\u012a\u00ea\u0001"+
		"\u0000\u0000\u0000\u012a\u00eb\u0001\u0000\u0000\u0000\u012a\u00ec\u0001"+
		"\u0000\u0000\u0000\u012a\u00ed\u0001\u0000\u0000\u0000\u012a\u00ee\u0001"+
		"\u0000\u0000\u0000\u012a\u00ef\u0001\u0000\u0000\u0000\u012a\u00f0\u0001"+
		"\u0000\u0000\u0000\u012a\u00f1\u0001\u0000\u0000\u0000\u012a\u00f2\u0001"+
		"\u0000\u0000\u0000\u012a\u00f3\u0001\u0000\u0000\u0000\u012a\u00f4\u0001"+
		"\u0000\u0000\u0000\u012a\u00f5\u0001\u0000\u0000\u0000\u012a\u00f6\u0001"+
		"\u0000\u0000\u0000\u012a\u00f7\u0001\u0000\u0000\u0000\u012a\u00f8\u0001"+
		"\u0000\u0000\u0000\u012a\u00f9\u0001\u0000\u0000\u0000\u012a\u00fa\u0001"+
		"\u0000\u0000\u0000\u012a\u00fb\u0001\u0000\u0000\u0000\u012a\u00fc\u0001"+
		"\u0000\u0000\u0000\u012a\u00fd\u0001\u0000\u0000\u0000\u012a\u00fe\u0001"+
		"\u0000\u0000\u0000\u012a\u00ff\u0001\u0000\u0000\u0000\u012a\u0100\u0001"+
		"\u0000\u0000\u0000\u012a\u0101\u0001\u0000\u0000\u0000\u012a\u0102\u0001"+
		"\u0000\u0000\u0000\u012a\u0103\u0001\u0000\u0000\u0000\u012a\u0104\u0001"+
		"\u0000\u0000\u0000\u012a\u0105\u0001\u0000\u0000\u0000\u012a\u0106\u0001"+
		"\u0000\u0000\u0000\u012a\u0107\u0001\u0000\u0000\u0000\u012a\u0108\u0001"+
		"\u0000\u0000\u0000\u012a\u0109\u0001\u0000\u0000\u0000\u012a\u010a\u0001"+
		"\u0000\u0000\u0000\u012a\u010b\u0001\u0000\u0000\u0000\u012a\u010c\u0001"+
		"\u0000\u0000\u0000\u012a\u010d\u0001\u0000\u0000\u0000\u012a\u010e\u0001"+
		"\u0000\u0000\u0000\u012a\u010f\u0001\u0000\u0000\u0000\u012a\u0110\u0001"+
		"\u0000\u0000\u0000\u012a\u0111\u0001\u0000\u0000\u0000\u012a\u0112\u0001"+
		"\u0000\u0000\u0000\u012a\u0113\u0001\u0000\u0000\u0000\u012a\u0114\u0001"+
		"\u0000\u0000\u0000\u012a\u0115\u0001\u0000\u0000\u0000\u012a\u0116\u0001"+
		"\u0000\u0000\u0000\u012a\u0117\u0001\u0000\u0000\u0000\u012a\u0118\u0001"+
		"\u0000\u0000\u0000\u012a\u0119\u0001\u0000\u0000\u0000\u012a\u011a\u0001"+
		"\u0000\u0000\u0000\u012a\u011b\u0001\u0000\u0000\u0000\u012a\u011c\u0001"+
		"\u0000\u0000\u0000\u012a\u011d\u0001\u0000\u0000\u0000\u012a\u011e\u0001"+
		"\u0000\u0000\u0000\u012a\u011f\u0001\u0000\u0000\u0000\u012a\u0120\u0001"+
		"\u0000\u0000\u0000\u012a\u0121\u0001\u0000\u0000\u0000\u012a\u0122\u0001"+
		"\u0000\u0000\u0000\u012a\u0123\u0001\u0000\u0000\u0000\u012a\u0124\u0001"+
		"\u0000\u0000\u0000\u012a\u0125\u0001\u0000\u0000\u0000\u012a\u0126\u0001"+
		"\u0000\u0000\u0000\u012a\u0127\u0001\u0000\u0000\u0000\u012a\u0128\u0001"+
		"\u0000\u0000\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012b\u0019\u0001"+
		"\u0000\u0000\u0000\u012c\u012e\u0005\'\u0000\u0000\u012d\u012c\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000"+
		"\u0000\u0000\u012f\u0131\u0005\'\u0000\u0000\u0130\u012d\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0133\u0001\u0000\u0000"+
		"\u0000\u0132\u0134\u0007\u0004\u0000\u0000\u0133\u0132\u0001\u0000\u0000"+
		"\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0136\u0001\u0000\u0000"+
		"\u0000\u0135\u0137\u0005\u0012\u0000\u0000\u0136\u0135\u0001\u0000\u0000"+
		"\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000"+
		"\u0000\u0138\u0139\u0003\u0014\n\u0000\u0139\u001b\u0001\u0000\u0000\u0000"+
		"\u013a\u013b\u0003\u0014\n\u0000\u013b\u001d\u0001\u0000\u0000\u0000\u013c"+
		"\u013d\u0003*\u0015\u0000\u013d\u013e\u0005\u0012\u0000\u0000\u013e\u0140"+
		"\u0001\u0000\u0000\u0000\u013f\u013c\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142"+
		"\u0003,\u0016\u0000\u0142\u001f\u0001\u0000\u0000\u0000\u0143\u0144\u0003"+
		"*\u0015\u0000\u0144\u0145\u0005\u0012\u0000\u0000\u0145\u0147\u0001\u0000"+
		"\u0000\u0000\u0146\u0143\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000"+
		"\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u014c\u0003,\u0016"+
		"\u0000\u0149\u014c\u0003&\u0013\u0000\u014a\u014c\u0003$\u0012\u0000\u014b"+
		"\u0146\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014b"+
		"\u014a\u0001\u0000\u0000\u0000\u014c!\u0001\u0000\u0000\u0000\u014d\u014f"+
		"\u0005[\u0000\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014e\u014f\u0001"+
		"\u0000\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u0153\u0003"+
		"\u0014\n\u0000\u0151\u0153\u0005\u00ca\u0000\u0000\u0152\u0150\u0001\u0000"+
		"\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u0153#\u0001\u0000\u0000"+
		"\u0000\u0154\u0155\u0005\u000f\u0000\u0000\u0155%\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0003\u0014\n\u0000\u0157\u0158\u0005\u0013\u0000\u0000\u0158"+
		"\'\u0001\u0000\u0000\u0000\u0159\u0161\u0003\u0014\n\u0000\u015a\u015b"+
		"\u0003*\u0015\u0000\u015b\u015c\u0005\u0012\u0000\u0000\u015c\u015e\u0001"+
		"\u0000\u0000\u0000\u015d\u015a\u0001\u0000\u0000\u0000\u015d\u015e\u0001"+
		"\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0161\u0003"+
		"\u0014\n\u0000\u0160\u0159\u0001\u0000\u0000\u0000\u0160\u015d\u0001\u0000"+
		"\u0000\u0000\u0161)\u0001\u0000\u0000\u0000\u0162\u0163\u0003\u0014\n"+
		"\u0000\u0163+\u0001\u0000\u0000\u0000\u0164\u0165\u0003\u0014\n\u0000"+
		"\u0165-\u0001\u0000\u0000\u0000\u0166\u0167\u0003\u0014\n\u0000\u0167"+
		"/\u0001\u0000\u0000\u0000\u0168\u016a\u0005\u001d\u0000\u0000\u0169\u0168"+
		"\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016b"+
		"\u0001\u0000\u0000\u0000\u016b\u0170\u0003 \u0010\u0000\u016c\u016d\u0005"+
		"#\u0000\u0000\u016d\u016f\u0003 \u0010\u0000\u016e\u016c\u0001\u0000\u0000"+
		"\u0000\u016f\u0172\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000"+
		"\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000"+
		"\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0173\u0175\u0005\u001e\u0000"+
		"\u0000\u0174\u0173\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000"+
		"\u0000\u01751\u0001\u0000\u0000\u0000\u0176\u0178\u0005\u001d\u0000\u0000"+
		"\u0177\u0176\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000"+
		"\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017e\u0003\u001e\u000f\u0000"+
		"\u017a\u017b\u0005#\u0000\u0000\u017b\u017d\u0003\u001e\u000f\u0000\u017c"+
		"\u017a\u0001\u0000\u0000\u0000\u017d\u0180\u0001\u0000\u0000\u0000\u017e"+
		"\u017c\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f"+
		"\u0182\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0181"+
		"\u0183\u0005\u001e\u0000\u0000\u0182\u0181\u0001\u0000\u0000\u0000\u0182"+
		"\u0183\u0001\u0000\u0000\u0000\u01833\u0001\u0000\u0000\u0000\u0184\u0185"+
		"\u0005\u00c7\u0000\u0000\u01855\u0001\u0000\u0000\u0000\u0186\u0187\u0006"+
		"\u001b\uffff\uffff\u0000\u0187\u0188\u0003>\u001f\u0000\u0188\u0189\u0003"+
		"6\u001b\u0003\u0189\u0190\u0001\u0000\u0000\u0000\u018a\u018b\u0005\u001d"+
		"\u0000\u0000\u018b\u018c\u00036\u001b\u0000\u018c\u018d\u0005\u001e\u0000"+
		"\u0000\u018d\u0190\u0001\u0000\u0000\u0000\u018e\u0190\u0003@ \u0000\u018f"+
		"\u0186\u0001\u0000\u0000\u0000\u018f\u018a\u0001\u0000\u0000\u0000\u018f"+
		"\u018e\u0001\u0000\u0000\u0000\u0190\u0197\u0001\u0000\u0000\u0000\u0191"+
		"\u0192\n\u0004\u0000\u0000\u0192\u0193\u00038\u001c\u0000\u0193\u0194"+
		"\u00036\u001b\u0005\u0194\u0196\u0001\u0000\u0000\u0000\u0195\u0191\u0001"+
		"\u0000\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000\u0197\u0195\u0001"+
		"\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u01987\u0001\u0000"+
		"\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u019a\u019b\u0007\u0005"+
		"\u0000\u0000\u019b9\u0001\u0000\u0000\u0000\u019c\u01a6\u0005\u001d\u0000"+
		"\u0000\u019d\u01a2\u00036\u001b\u0000\u019e\u019f\u0005#\u0000\u0000\u019f"+
		"\u01a1\u00036\u001b\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a3\u01a7\u0001\u0000\u0000\u0000\u01a4\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a7\u0005\u000f\u0000\u0000\u01a6\u019d"+
		"\u0001\u0000\u0000\u0000\u01a6\u01a5\u0001\u0000\u0000\u0000\u01a6\u01a7"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01a9"+
		"\u0005\u001e\u0000\u0000\u01a9;\u0001\u0000\u0000\u0000\u01aa\u01ac\u0005"+
		"\u001d\u0000\u0000\u01ab\u01ad\u0003`0\u0000\u01ac\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ac\u01ad\u0001\u0000\u0000\u0000\u01ad\u01ba\u0001\u0000\u0000"+
		"\u0000\u01ae\u01b6\u00036\u001b\u0000\u01af\u01b1\u0005#\u0000\u0000\u01b0"+
		"\u01b2\u0003`0\u0000\u01b1\u01b0\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b5\u0003"+
		"6\u001b\u0000\u01b4\u01af\u0001\u0000\u0000\u0000\u01b5\u01b8\u0001\u0000"+
		"\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000"+
		"\u0000\u0000\u01b7\u01bb\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b9\u01bb\u0005\u000f\u0000\u0000\u01ba\u01ae\u0001\u0000"+
		"\u0000\u0000\u01ba\u01b9\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000"+
		"\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005\u001e"+
		"\u0000\u0000\u01bd=\u0001\u0000\u0000\u0000\u01be\u01bf\u0007\u0006\u0000"+
		"\u0000\u01bf?\u0001\u0000\u0000\u0000\u01c0\u01c1\u0006 \uffff\uffff\u0000"+
		"\u01c1\u01c2\u0003F#\u0000\u01c2\u01d1\u0001\u0000\u0000\u0000\u01c3\u01c4"+
		"\n\u0004\u0000\u0000\u01c4\u01c5\u0003D\"\u0000\u01c5\u01c6\u0003\u0002"+
		"\u0001\u0000\u01c6\u01d0\u0001\u0000\u0000\u0000\u01c7\u01c8\n\u0003\u0000"+
		"\u0000\u01c8\u01c9\u0003B!\u0000\u01c9\u01ca\u0003F#\u0000\u01ca\u01d0"+
		"\u0001\u0000\u0000\u0000\u01cb\u01cc\n\u0002\u0000\u0000\u01cc\u01cd\u0003"+
		"B!\u0000\u01cd\u01ce\u0003\u0080@\u0000\u01ce\u01d0\u0001\u0000\u0000"+
		"\u0000\u01cf\u01c3\u0001\u0000\u0000\u0000\u01cf\u01c7\u0001\u0000\u0000"+
		"\u0000\u01cf\u01cb\u0001\u0000\u0000\u0000\u01d0\u01d3\u0001\u0000\u0000"+
		"\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d2A\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000"+
		"\u01d4\u01d6\u0007\u0007\u0000\u0000\u01d5\u01d7\u0007\b\u0000\u0000\u01d6"+
		"\u01d5\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7"+
		"C\u0001\u0000\u0000\u0000\u01d8\u01da\u0005d\u0000\u0000\u01d9\u01db\u0005"+
		"e\u0000\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000"+
		"\u0000\u0000\u01dbE\u0001\u0000\u0000\u0000\u01dc\u01e1\u0003H$\u0000"+
		"\u01dd\u01e1\u0003J%\u0000\u01de\u01e1\u0003L&\u0000\u01df\u01e1\u0003"+
		"N\'\u0000\u01e0\u01dc\u0001\u0000\u0000\u0000\u01e0\u01dd\u0001\u0000"+
		"\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e0\u01df\u0001\u0000"+
		"\u0000\u0000\u01e1G\u0001\u0000\u0000\u0000\u01e2\u01e4\u0003N\'\u0000"+
		"\u01e3\u01e5\u0005e\u0000\u0000\u01e4\u01e3\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6"+
		"\u01e7\u0005k\u0000\u0000\u01e7\u01e8\u0003\u0080@\u0000\u01e8\u01ff\u0001"+
		"\u0000\u0000\u0000\u01e9\u01eb\u0003N\'\u0000\u01ea\u01ec\u0005e\u0000"+
		"\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000"+
		"\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ee\u0005k\u0000\u0000"+
		"\u01ee\u01ef\u0003:\u001d\u0000\u01ef\u01ff\u0001\u0000\u0000\u0000\u01f0"+
		"\u01f2\u0003N\'\u0000\u01f1\u01f3\u0005e\u0000\u0000\u01f2\u01f1\u0001"+
		"\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f5\u0005k\u0000\u0000\u01f5\u01f6\u0003T*"+
		"\u0000\u01f6\u01ff\u0001\u0000\u0000\u0000\u01f7\u01f9\u0003N\'\u0000"+
		"\u01f8\u01fa\u0005e\u0000\u0000\u01f9\u01f8\u0001\u0000\u0000\u0000\u01f9"+
		"\u01fa\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb"+
		"\u01fc\u0005k\u0000\u0000\u01fc\u01fd\u0003V+\u0000\u01fd\u01ff\u0001"+
		"\u0000\u0000\u0000\u01fe\u01e2\u0001\u0000\u0000\u0000\u01fe\u01e9\u0001"+
		"\u0000\u0000\u0000\u01fe\u01f0\u0001\u0000\u0000\u0000\u01fe\u01f7\u0001"+
		"\u0000\u0000\u0000\u01ffI\u0001\u0000\u0000\u0000\u0200\u0202\u0003N\'"+
		"\u0000\u0201\u0203\u0005e\u0000\u0000\u0202\u0201\u0001\u0000\u0000\u0000"+
		"\u0202\u0203\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000"+
		"\u0204\u0205\u0005j\u0000\u0000\u0205\u0206\u0003N\'\u0000\u0206\u0207"+
		"\u0005b\u0000\u0000\u0207\u0208\u0003F#\u0000\u0208K\u0001\u0000\u0000"+
		"\u0000\u0209\u020b\u0003N\'\u0000\u020a\u020c\u0005e\u0000\u0000\u020b"+
		"\u020a\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000\u0000\u020c"+
		"\u020d\u0001\u0000\u0000\u0000\u020d\u020e\u0005n\u0000\u0000\u020e\u0211"+
		"\u0003R)\u0000\u020f\u0210\u0005\u00b2\u0000\u0000\u0210\u0212\u0003R"+
		")\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000"+
		"\u0000\u0212M\u0001\u0000\u0000\u0000\u0213\u0214\u0006\'\uffff\uffff"+
		"\u0000\u0214\u0215\u0003R)\u0000\u0215\u021c\u0001\u0000\u0000\u0000\u0216"+
		"\u0217\n\u0002\u0000\u0000\u0217\u0218\u0003P(\u0000\u0218\u0219\u0003"+
		"N\'\u0003\u0219\u021b\u0001\u0000\u0000\u0000\u021a\u0216\u0001\u0000"+
		"\u0000\u0000\u021b\u021e\u0001\u0000\u0000\u0000\u021c\u021a\u0001\u0000"+
		"\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000\u021dO\u0001\u0000\u0000"+
		"\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021f\u0220\u0007\t\u0000\u0000"+
		"\u0220Q\u0001\u0000\u0000\u0000\u0221\u0222\u0006)\uffff\uffff\u0000\u0222"+
		"\u023d\u0003Z-\u0000\u0223\u023d\u0003\u0000\u0000\u0000\u0224\u023d\u0003"+
		"\u0002\u0001\u0000\u0225\u023d\u0003\u0014\n\u0000\u0226\u023d\u0003 "+
		"\u0010\u0000\u0227\u023d\u0003\u001a\r\u0000\u0228\u0229\u0007\n\u0000"+
		"\u0000\u0229\u023d\u0003R)\f\u022a\u022b\u0005\u001d\u0000\u0000\u022b"+
		"\u022c\u00036\u001b\u0000\u022c\u022d\u0005\u001e\u0000\u0000\u022d\u023d"+
		"\u0001\u0000\u0000\u0000\u022e\u023d\u0003:\u001d\u0000\u022f\u023d\u0003"+
		"<\u001e\u0000\u0230\u023d\u0003X,\u0000\u0231\u0232\u0005\u001f\u0000"+
		"\u0000\u0232\u0233\u0003\u0014\n\u0000\u0233\u0234\u00036\u001b\u0000"+
		"\u0234\u0235\u0005 \u0000\u0000\u0235\u023d\u0001\u0000\u0000\u0000\u0236"+
		"\u023d\u0003t:\u0000\u0237\u023d\u0003v;\u0000\u0238\u023d\u0003|>\u0000"+
		"\u0239\u023d\u0003\u0080@\u0000\u023a\u023d\u0003T*\u0000\u023b\u023d"+
		"\u0003V+\u0000\u023c\u0221\u0001\u0000\u0000\u0000\u023c\u0223\u0001\u0000"+
		"\u0000\u0000\u023c\u0224\u0001\u0000\u0000\u0000\u023c\u0225\u0001\u0000"+
		"\u0000\u0000\u023c\u0226\u0001\u0000\u0000\u0000\u023c\u0227\u0001\u0000"+
		"\u0000\u0000\u023c\u0228\u0001\u0000\u0000\u0000\u023c\u022a\u0001\u0000"+
		"\u0000\u0000\u023c\u022e\u0001\u0000\u0000\u0000\u023c\u022f\u0001\u0000"+
		"\u0000\u0000\u023c\u0230\u0001\u0000\u0000\u0000\u023c\u0231\u0001\u0000"+
		"\u0000\u0000\u023c\u0236\u0001\u0000\u0000\u0000\u023c\u0237\u0001\u0000"+
		"\u0000\u0000\u023c\u0238\u0001\u0000\u0000\u0000\u023c\u0239\u0001\u0000"+
		"\u0000\u0000\u023c\u023a\u0001\u0000\u0000\u0000\u023c\u023b\u0001\u0000"+
		"\u0000\u0000\u023d\u0246\u0001\u0000\u0000\u0000\u023e\u023f\n\u000e\u0000"+
		"\u0000\u023f\u0242\u0005\u00b3\u0000\u0000\u0240\u0243\u0005\u00ca\u0000"+
		"\u0000\u0241\u0243\u0003\u0014\n\u0000\u0242\u0240\u0001\u0000\u0000\u0000"+
		"\u0242\u0241\u0001\u0000\u0000\u0000\u0243\u0245\u0001\u0000\u0000\u0000"+
		"\u0244\u023e\u0001\u0000\u0000\u0000\u0245\u0248\u0001\u0000\u0000\u0000"+
		"\u0246\u0244\u0001\u0000\u0000\u0000\u0246\u0247\u0001\u0000\u0000\u0000"+
		"\u0247S\u0001\u0000\u0000\u0000\u0248\u0246\u0001\u0000\u0000\u0000\u0249"+
		"\u024a\u0005\u00c8\u0000\u0000\u024aU\u0001\u0000\u0000\u0000\u024b\u024c"+
		"\u0005\u00c9\u0000\u0000\u024cW\u0001\u0000\u0000\u0000\u024d\u0250\u0005"+
		"i\u0000\u0000\u024e\u0251\u0003\u0080@\u0000\u024f\u0251\u0003T*\u0000"+
		"\u0250\u024e\u0001\u0000\u0000\u0000\u0250\u024f\u0001\u0000\u0000\u0000"+
		"\u0251Y\u0001\u0000\u0000\u0000\u0252\u0256\u0003\\.\u0000\u0253\u0256"+
		"\u0003b1\u0000\u0254\u0256\u0003p8\u0000\u0255\u0252\u0001\u0000\u0000"+
		"\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0255\u0254\u0001\u0000\u0000"+
		"\u0000\u0256[\u0001\u0000\u0000\u0000\u0257\u025a\u0003^/\u0000\u0258"+
		"\u025b\u0003<\u001e\u0000\u0259\u025b\u0003V+\u0000\u025a\u0258\u0001"+
		"\u0000\u0000\u0000\u025a\u0259\u0001\u0000\u0000\u0000\u025b]\u0001\u0000"+
		"\u0000\u0000\u025c\u025d\u0007\u000b\u0000\u0000\u025d_\u0001\u0000\u0000"+
		"\u0000\u025e\u025f\u0005J\u0000\u0000\u025fa\u0001\u0000\u0000\u0000\u0260"+
		"\u0267\u0003d2\u0000\u0261\u0267\u0003f3\u0000\u0262\u0267\u0003h4\u0000"+
		"\u0263\u0267\u0003j5\u0000\u0264\u0267\u0003l6\u0000\u0265\u0267\u0003"+
		"n7\u0000\u0266\u0260\u0001\u0000\u0000\u0000\u0266\u0261\u0001\u0000\u0000"+
		"\u0000\u0266\u0262\u0001\u0000\u0000\u0000\u0266\u0263\u0001\u0000\u0000"+
		"\u0000\u0266\u0264\u0001\u0000\u0000\u0000\u0266\u0265\u0001\u0000\u0000"+
		"\u0000\u0267c\u0001\u0000\u0000\u0000\u0268\u0269\u0005M\u0000\u0000\u0269"+
		"\u026c\u0005\u001d\u0000\u0000\u026a\u026d\u00036\u001b\u0000\u026b\u026d"+
		"\u0005f\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026c\u026b\u0001"+
		"\u0000\u0000\u0000\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u026f\u0005"+
		"[\u0000\u0000\u026f\u0270\u0003\u0082A\u0000\u0270\u0271\u0005\u001e\u0000"+
		"\u0000\u0271e\u0001\u0000\u0000\u0000\u0272\u0273\u0005\u00b4\u0000\u0000"+
		"\u0273\u0274\u0005\u001d\u0000\u0000\u0274\u0275\u00036\u001b\u0000\u0275"+
		"\u0276\u0005Y\u0000\u0000\u0276\u0277\u0003\u0014\n\u0000\u0277\u0278"+
		"\u0005\u001e\u0000\u0000\u0278g\u0001\u0000\u0000\u0000\u0279\u027a\u0005"+
		"?\u0000\u0000\u027a\u027b\u0005\u001d\u0000\u0000\u027b\u027c\u00036\u001b"+
		"\u0000\u027c\u027d\u0005k\u0000\u0000\u027d\u027e\u00036\u001b\u0000\u027e"+
		"\u027f\u0005\u001e\u0000\u0000\u027fi\u0001\u0000\u0000\u0000\u0280\u0281"+
		"\u0005O\u0000\u0000\u0281\u0282\u0005\u001d\u0000\u0000\u0282\u0283\u0003"+
		"6\u001b\u0000\u0283\u0284\u0005P\u0000\u0000\u0284\u0287\u0005\u00cb\u0000"+
		"\u0000\u0285\u0286\u0005`\u0000\u0000\u0286\u0288\u0005\u00cb\u0000\u0000"+
		"\u0287\u0285\u0001\u0000\u0000\u0000\u0287\u0288\u0001\u0000\u0000\u0000"+
		"\u0288\u0289\u0001\u0000\u0000\u0000\u0289\u028a\u0005\u001e\u0000\u0000"+
		"\u028ak\u0001\u0000\u0000\u0000\u028b\u028c\u0005\u00b5\u0000\u0000\u028c"+
		"\u028d\u0005\u001d\u0000\u0000\u028d\u028e\u0003\u0014\n\u0000\u028e\u028f"+
		"\u0005P\u0000\u0000\u028f\u0290\u00036\u001b\u0000\u0290\u0291\u0005\u001e"+
		"\u0000\u0000\u0291m\u0001\u0000\u0000\u0000\u0292\u0293\u0005N\u0000\u0000"+
		"\u0293\u0294\u0005\u001d\u0000\u0000\u0294\u0295\u0007\f\u0000\u0000\u0295"+
		"\u0296\u0005\u00ca\u0000\u0000\u0296\u0297\u0005P\u0000\u0000\u0297\u0298"+
		"\u0005\u00ca\u0000\u0000\u0298\u0299\u0005\u001e\u0000\u0000\u0299o\u0001"+
		"\u0000\u0000\u0000\u029a\u029d\u0003r9\u0000\u029b\u029e\u0003:\u001d"+
		"\u0000\u029c\u029e\u0003V+\u0000\u029d\u029b\u0001\u0000\u0000\u0000\u029d"+
		"\u029c\u0001\u0000\u0000\u0000\u029eq\u0001\u0000\u0000\u0000\u029f\u02a7"+
		"\u0003\u0014\n\u0000\u02a0\u02a7\u0005]\u0000\u0000\u02a1\u02a7\u0005"+
		"\u00b9\u0000\u0000\u02a2\u02a7\u0005\u0084\u0000\u0000\u02a3\u02a7\u0005"+
		"\u0085\u0000\u0000\u02a4\u02a7\u0005\u0080\u0000\u0000\u02a5\u02a7\u0003"+
		"\u0018\f\u0000\u02a6\u029f\u0001\u0000\u0000\u0000\u02a6\u02a0\u0001\u0000"+
		"\u0000\u0000\u02a6\u02a1\u0001\u0000\u0000\u0000\u02a6\u02a2\u0001\u0000"+
		"\u0000\u0000\u02a6\u02a3\u0001\u0000\u0000\u0000\u02a6\u02a4\u0001\u0000"+
		"\u0000\u0000\u02a6\u02a5\u0001\u0000\u0000\u0000\u02a7s\u0001\u0000\u0000"+
		"\u0000\u02a8\u02a9\u0003\u0002\u0001\u0000\u02a9\u02ab\u0005\u00ba\u0000"+
		"\u0000\u02aa\u02ac\u0005<\u0000\u0000\u02ab\u02aa\u0001\u0000\u0000\u0000"+
		"\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac\u02ad\u0001\u0000\u0000\u0000"+
		"\u02ad\u02ae\u0007\r\u0000\u0000\u02ae\u02af\u0003\u0080@\u0000\u02af"+
		"u\u0001\u0000\u0000\u0000\u02b0\u02b2\u0005K\u0000\u0000\u02b1\u02b3\u0003"+
		"R)\u0000\u02b2\u02b1\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000"+
		"\u0000\u02b3\u02b5\u0001\u0000\u0000\u0000\u02b4\u02b6\u0003x<\u0000\u02b5"+
		"\u02b4\u0001\u0000\u0000\u0000\u02b6\u02b7\u0001\u0000\u0000\u0000\u02b7"+
		"\u02b5\u0001\u0000\u0000\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8"+
		"\u02ba\u0001\u0000\u0000\u0000\u02b9\u02bb\u0003z=\u0000\u02ba\u02b9\u0001"+
		"\u0000\u0000\u0000\u02ba\u02bb\u0001\u0000\u0000\u0000\u02bb\u02bc\u0001"+
		"\u0000\u0000\u0000\u02bc\u02bd\u0005\u00bc\u0000\u0000\u02bdw\u0001\u0000"+
		"\u0000\u0000\u02be\u02bf\u0005L\u0000\u0000\u02bf\u02c0\u00036\u001b\u0000"+
		"\u02c0\u02c1\u0005_\u0000\u0000\u02c1\u02c2\u00036\u001b\u0000\u02c2y"+
		"\u0001\u0000\u0000\u0000\u02c3\u02c4\u0005^\u0000\u0000\u02c4\u02c5\u0003"+
		"6\u001b\u0000\u02c5{\u0001\u0000\u0000\u0000\u02c6\u02c7\u0005\u0080\u0000"+
		"\u0000\u02c7\u02c8\u00036\u001b\u0000\u02c8\u02c9\u0003~?\u0000\u02c9"+
		"}\u0001\u0000\u0000\u0000\u02ca\u02cb\u0007\u000e\u0000\u0000\u02cb\u007f"+
		"\u0001\u0000\u0000\u0000\u02cc\u02cd\u0005\u0001\u0000\u0000\u02cd\u0081"+
		"\u0001\u0000\u0000\u0000\u02ce\u02d0\u0003\u0084B\u0000\u02cf\u02d1\u0003"+
		"\u0086C\u0000\u02d0\u02cf\u0001\u0000\u0000\u0000\u02d0\u02d1\u0001\u0000"+
		"\u0000\u0000\u02d1\u02d3\u0001\u0000\u0000\u0000\u02d2\u02d4\u0003\u0088"+
		"D\u0000\u02d3\u02d2\u0001\u0000\u0000\u0000\u02d3\u02d4\u0001\u0000\u0000"+
		"\u0000\u02d4\u02d6\u0001\u0000\u0000\u0000\u02d5\u02d7\u0003\u008aE\u0000"+
		"\u02d6\u02d5\u0001\u0000\u0000\u0000\u02d6\u02d7\u0001\u0000\u0000\u0000"+
		"\u02d7\u02ea\u0001\u0000\u0000\u0000\u02d8\u02d9\u0003\u0084B\u0000\u02d9"+
		"\u02da\u0005\u001d\u0000\u0000\u02da\u02df\u0005\u00ca\u0000\u0000\u02db"+
		"\u02dc\u0005#\u0000\u0000\u02dc\u02de\u0005\u00ca\u0000\u0000\u02dd\u02db"+
		"\u0001\u0000\u0000\u0000\u02de\u02e1\u0001\u0000\u0000\u0000\u02df\u02dd"+
		"\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000\u0000\u0000\u02e0\u02e2"+
		"\u0001\u0000\u0000\u0000\u02e1\u02df\u0001\u0000\u0000\u0000\u02e2\u02e4"+
		"\u0005\u001e\u0000\u0000\u02e3\u02e5\u0003\u0088D\u0000\u02e4\u02e3\u0001"+
		"\u0000\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000\u0000\u02e5\u02e7\u0001"+
		"\u0000\u0000\u0000\u02e6\u02e8\u0003\u008aE\u0000\u02e7\u02e6\u0001\u0000"+
		"\u0000\u0000\u02e7\u02e8\u0001\u0000\u0000\u0000\u02e8\u02ea\u0001\u0000"+
		"\u0000\u0000\u02e9\u02ce\u0001\u0000\u0000\u0000\u02e9\u02d8\u0001\u0000"+
		"\u0000\u0000\u02ea\u0083\u0001\u0000\u0000\u0000\u02eb\u0315\u0005~\u0000"+
		"\u0000\u02ec\u02ed\u0005~\u0000\u0000\u02ed\u0315\u0005\u00bd\u0000\u0000"+
		"\u02ee\u02ef\u0005\u00be\u0000\u0000\u02ef\u0315\u0005~\u0000\u0000\u02f0"+
		"\u02f1\u0005\u00be\u0000\u0000\u02f1\u02f2\u0005~\u0000\u0000\u02f2\u0315"+
		"\u0005\u00bd\u0000\u0000\u02f3\u0315\u0005}\u0000\u0000\u02f4\u0315\u0005"+
		"\u00ab\u0000\u0000\u02f5\u0315\u0005\u00bf\u0000\u0000\u02f6\u02f7\u0005"+
		"\u00be\u0000\u0000\u02f7\u0315\u0005}\u0000\u0000\u02f8\u02f9\u0005\u00be"+
		"\u0000\u0000\u02f9\u02fa\u0005}\u0000\u0000\u02fa\u0315\u0005\u00bd\u0000"+
		"\u0000\u02fb\u0315\u0005\u00c0\u0000\u0000\u02fc\u02fd\u0005\u00c0\u0000"+
		"\u0000\u02fd\u0315\u0005\u00bd\u0000\u0000\u02fe\u0315\u0005\u00c1\u0000"+
		"\u0000\u02ff\u0315\u0005\u00a9\u0000\u0000\u0300\u0315\u0005\u00c2\u0000"+
		"\u0000\u0301\u0315\u0005\u00a7\u0000\u0000\u0302\u0315\u0005\u00c3\u0000"+
		"\u0000\u0303\u0315\u0005\u00ac\u0000\u0000\u0304\u0315\u0005\u00a8\u0000"+
		"\u0000\u0305\u0306\u0005|\u0000\u0000\u0306\u0315\u0005@\u0000\u0000\u0307"+
		"\u0315\u0005\u0081\u0000\u0000\u0308\u0315\u0005\u0082\u0000\u0000\u0309"+
		"\u0315\u0005\u0083\u0000\u0000\u030a\u0315\u0005\u0080\u0000\u0000\u030b"+
		"\u030c\u0005\u0082\u0000\u0000\u030c\u030d\u0005H\u0000\u0000\u030d\u030e"+
		"\u0005\u0082\u0000\u0000\u030e\u0315\u0005\u00c4\u0000\u0000\u030f\u0310"+
		"\u0005\u0083\u0000\u0000\u0310\u0311\u0005H\u0000\u0000\u0311\u0312\u0005"+
		"\u0082\u0000\u0000\u0312\u0315\u0005\u00c4\u0000\u0000\u0313\u0315\u0003"+
		"\u0014\n\u0000\u0314\u02eb\u0001\u0000\u0000\u0000\u0314\u02ec\u0001\u0000"+
		"\u0000\u0000\u0314\u02ee\u0001\u0000\u0000\u0000\u0314\u02f0\u0001\u0000"+
		"\u0000\u0000\u0314\u02f3\u0001\u0000\u0000\u0000\u0314\u02f4\u0001\u0000"+
		"\u0000\u0000\u0314\u02f5\u0001\u0000\u0000\u0000\u0314\u02f6\u0001\u0000"+
		"\u0000\u0000\u0314\u02f8\u0001\u0000\u0000\u0000\u0314\u02fb\u0001\u0000"+
		"\u0000\u0000\u0314\u02fc\u0001\u0000\u0000\u0000\u0314\u02fe\u0001\u0000"+
		"\u0000\u0000\u0314\u02ff\u0001\u0000\u0000\u0000\u0314\u0300\u0001\u0000"+
		"\u0000\u0000\u0314\u0301\u0001\u0000\u0000\u0000\u0314\u0302\u0001\u0000"+
		"\u0000\u0000\u0314\u0303\u0001\u0000\u0000\u0000\u0314\u0304\u0001\u0000"+
		"\u0000\u0000\u0314\u0305\u0001\u0000\u0000\u0000\u0314\u0307\u0001\u0000"+
		"\u0000\u0000\u0314\u0308\u0001\u0000\u0000\u0000\u0314\u0309\u0001\u0000"+
		"\u0000\u0000\u0314\u030a\u0001\u0000\u0000\u0000\u0314\u030b\u0001\u0000"+
		"\u0000\u0000\u0314\u030f\u0001\u0000\u0000\u0000\u0314\u0313\u0001\u0000"+
		"\u0000\u0000\u0315\u0085\u0001\u0000\u0000\u0000\u0316\u0317\u0005\u001d"+
		"\u0000\u0000\u0317\u031a\u0005\u00cb\u0000\u0000\u0318\u0319\u0005#\u0000"+
		"\u0000\u0319\u031b\u0005\u00cb\u0000\u0000\u031a\u0318\u0001\u0000\u0000"+
		"\u0000\u031a\u031b\u0001\u0000\u0000\u0000\u031b\u031c\u0001\u0000\u0000"+
		"\u0000\u031c\u031d\u0005\u001e\u0000\u0000\u031d\u0087\u0001\u0000\u0000"+
		"\u0000\u031e\u031f\u0007\u000f\u0000\u0000\u031f\u0321\u00056\u0000\u0000"+
		"\u0320\u0322\u0005\u0016\u0000\u0000\u0321\u0320\u0001\u0000\u0000\u0000"+
		"\u0321\u0322\u0001\u0000\u0000\u0000\u0322\u0323\u0001\u0000\u0000\u0000"+
		"\u0323\u0324\u0003\u008cF\u0000\u0324\u0089\u0001\u0000\u0000\u0000\u0325"+
		"\u0327\u0005\u00b3\u0000\u0000\u0326\u0328\u0005\u0016\u0000\u0000\u0327"+
		"\u0326\u0001\u0000\u0000\u0000\u0327\u0328\u0001\u0000\u0000\u0000\u0328"+
		"\u032b\u0001\u0000\u0000\u0000\u0329\u032c\u0005\u00ca\u0000\u0000\u032a"+
		"\u032c\u0003\u008cF\u0000\u032b\u0329\u0001\u0000\u0000\u0000\u032b\u032a"+
		"\u0001\u0000\u0000\u0000\u032c\u008b\u0001\u0000\u0000\u0000\u032d\u0330"+
		"\u0003\u0014\n\u0000\u032e\u032f\u0005\u0012\u0000\u0000\u032f\u0331\u0003"+
		"\u0014\n\u0000\u0330\u032e\u0001\u0000\u0000\u0000\u0330\u0331\u0001\u0000"+
		"\u0000\u0000\u0331\u008d\u0001\u0000\u0000\u0000\u0332\u0334\u0007\u0010"+
		"\u0000\u0000\u0333\u0332\u0001\u0000\u0000\u0000\u0333\u0334\u0001\u0000"+
		"\u0000\u0000\u0334\u008f\u0001\u0000\u0000\u0000O\u009a\u009f\u00a3\u00a6"+
		"\u00b1\u00b4\u00b8\u00bb\u00bf\u00c7\u012a\u012d\u0130\u0133\u0136\u013f"+
		"\u0146\u014b\u014e\u0152\u015d\u0160\u0169\u0170\u0174\u0177\u017e\u0182"+
		"\u018f\u0197\u01a2\u01a6\u01ac\u01b1\u01b6\u01ba\u01cf\u01d1\u01d6\u01da"+
		"\u01e0\u01e4\u01eb\u01f2\u01f9\u01fe\u0202\u020b\u0211\u021c\u023c\u0242"+
		"\u0246\u0250\u0255\u025a\u0266\u026c\u0287\u029d\u02a6\u02ab\u02b2\u02b7"+
		"\u02ba\u02d0\u02d3\u02d6\u02df\u02e4\u02e7\u02e9\u0314\u031a\u0321\u0327"+
		"\u032b\u0330\u0333";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}