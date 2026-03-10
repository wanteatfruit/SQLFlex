// Generated from /home/junwen/code/sql-rewrite/sqlflex/grammar/Alphabet.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Alphabet extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR_GENERATOR=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FOR_GENERATOR", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
			"Z", "UL_"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DO NOT MATCH ANY THING, JUST FOR GENERATOR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FOR_GENERATOR"
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


	public Alphabet(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Alphabet.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0001\u009a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0000"+
		"\u0000\u001c\u0001\u0001\u0003\u0000\u0005\u0000\u0007\u0000\t\u0000\u000b"+
		"\u0000\r\u0000\u000f\u0000\u0011\u0000\u0013\u0000\u0015\u0000\u0017\u0000"+
		"\u0019\u0000\u001b\u0000\u001d\u0000\u001f\u0000!\u0000#\u0000%\u0000"+
		"\'\u0000)\u0000+\u0000-\u0000/\u00001\u00003\u00005\u00007\u0000\u0001"+
		"\u0000\u001a\u0002\u0000AAaa\u0002\u0000BBbb\u0002\u0000CCcc\u0002\u0000"+
		"DDdd\u0002\u0000EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002\u0000HHhh\u0002"+
		"\u0000IIii\u0002\u0000JJjj\u0002\u0000KKkk\u0002\u0000LLll\u0002\u0000"+
		"MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000QQqq\u0002"+
		"\u0000RRrr\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000"+
		"VVvv\u0002\u0000WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002\u0000ZZzz~"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u00019\u0001\u0000\u0000\u0000\u0003"+
		"d\u0001\u0000\u0000\u0000\u0005f\u0001\u0000\u0000\u0000\u0007h\u0001"+
		"\u0000\u0000\u0000\tj\u0001\u0000\u0000\u0000\u000bl\u0001\u0000\u0000"+
		"\u0000\rn\u0001\u0000\u0000\u0000\u000fp\u0001\u0000\u0000\u0000\u0011"+
		"r\u0001\u0000\u0000\u0000\u0013t\u0001\u0000\u0000\u0000\u0015v\u0001"+
		"\u0000\u0000\u0000\u0017x\u0001\u0000\u0000\u0000\u0019z\u0001\u0000\u0000"+
		"\u0000\u001b|\u0001\u0000\u0000\u0000\u001d~\u0001\u0000\u0000\u0000\u001f"+
		"\u0080\u0001\u0000\u0000\u0000!\u0082\u0001\u0000\u0000\u0000#\u0084\u0001"+
		"\u0000\u0000\u0000%\u0086\u0001\u0000\u0000\u0000\'\u0088\u0001\u0000"+
		"\u0000\u0000)\u008a\u0001\u0000\u0000\u0000+\u008c\u0001\u0000\u0000\u0000"+
		"-\u008e\u0001\u0000\u0000\u0000/\u0090\u0001\u0000\u0000\u00001\u0092"+
		"\u0001\u0000\u0000\u00003\u0094\u0001\u0000\u0000\u00005\u0096\u0001\u0000"+
		"\u0000\u00007\u0098\u0001\u0000\u0000\u00009:\u0005D\u0000\u0000:;\u0005"+
		"O\u0000\u0000;<\u0005 \u0000\u0000<=\u0005N\u0000\u0000=>\u0005O\u0000"+
		"\u0000>?\u0005T\u0000\u0000?@\u0005 \u0000\u0000@A\u0005M\u0000\u0000"+
		"AB\u0005A\u0000\u0000BC\u0005T\u0000\u0000CD\u0005C\u0000\u0000DE\u0005"+
		"H\u0000\u0000EF\u0005 \u0000\u0000FG\u0005A\u0000\u0000GH\u0005N\u0000"+
		"\u0000HI\u0005Y\u0000\u0000IJ\u0005 \u0000\u0000JK\u0005T\u0000\u0000"+
		"KL\u0005H\u0000\u0000LM\u0005I\u0000\u0000MN\u0005N\u0000\u0000NO\u0005"+
		"G\u0000\u0000OP\u0005,\u0000\u0000PQ\u0005 \u0000\u0000QR\u0005J\u0000"+
		"\u0000RS\u0005U\u0000\u0000ST\u0005S\u0000\u0000TU\u0005T\u0000\u0000"+
		"UV\u0005 \u0000\u0000VW\u0005F\u0000\u0000WX\u0005O\u0000\u0000XY\u0005"+
		"R\u0000\u0000YZ\u0005 \u0000\u0000Z[\u0005G\u0000\u0000[\\\u0005E\u0000"+
		"\u0000\\]\u0005N\u0000\u0000]^\u0005E\u0000\u0000^_\u0005R\u0000\u0000"+
		"_`\u0005A\u0000\u0000`a\u0005T\u0000\u0000ab\u0005O\u0000\u0000bc\u0005"+
		"R\u0000\u0000c\u0002\u0001\u0000\u0000\u0000de\u0007\u0000\u0000\u0000"+
		"e\u0004\u0001\u0000\u0000\u0000fg\u0007\u0001\u0000\u0000g\u0006\u0001"+
		"\u0000\u0000\u0000hi\u0007\u0002\u0000\u0000i\b\u0001\u0000\u0000\u0000"+
		"jk\u0007\u0003\u0000\u0000k\n\u0001\u0000\u0000\u0000lm\u0007\u0004\u0000"+
		"\u0000m\f\u0001\u0000\u0000\u0000no\u0007\u0005\u0000\u0000o\u000e\u0001"+
		"\u0000\u0000\u0000pq\u0007\u0006\u0000\u0000q\u0010\u0001\u0000\u0000"+
		"\u0000rs\u0007\u0007\u0000\u0000s\u0012\u0001\u0000\u0000\u0000tu\u0007"+
		"\b\u0000\u0000u\u0014\u0001\u0000\u0000\u0000vw\u0007\t\u0000\u0000w\u0016"+
		"\u0001\u0000\u0000\u0000xy\u0007\n\u0000\u0000y\u0018\u0001\u0000\u0000"+
		"\u0000z{\u0007\u000b\u0000\u0000{\u001a\u0001\u0000\u0000\u0000|}\u0007"+
		"\f\u0000\u0000}\u001c\u0001\u0000\u0000\u0000~\u007f\u0007\r\u0000\u0000"+
		"\u007f\u001e\u0001\u0000\u0000\u0000\u0080\u0081\u0007\u000e\u0000\u0000"+
		"\u0081 \u0001\u0000\u0000\u0000\u0082\u0083\u0007\u000f\u0000\u0000\u0083"+
		"\"\u0001\u0000\u0000\u0000\u0084\u0085\u0007\u0010\u0000\u0000\u0085$"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0007\u0011\u0000\u0000\u0087&\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0007\u0012\u0000\u0000\u0089(\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0007\u0013\u0000\u0000\u008b*\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0007\u0014\u0000\u0000\u008d,\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0007\u0015\u0000\u0000\u008f.\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0007\u0016\u0000\u0000\u00910\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0007\u0017\u0000\u0000\u00932\u0001\u0000\u0000\u0000\u0094\u0095\u0007"+
		"\u0018\u0000\u0000\u00954\u0001\u0000\u0000\u0000\u0096\u0097\u0007\u0019"+
		"\u0000\u0000\u00976\u0001\u0000\u0000\u0000\u0098\u0099\u0005_\u0000\u0000"+
		"\u00998\u0001\u0000\u0000\u0000\u0001\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}