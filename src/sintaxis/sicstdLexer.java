// Generated from /home/raul/Documentos/UASLP/2021-2022-2/SoftwareDeSistemas/Laboratorio/analizador/grammar/sicstd.g4 by ANTLR 4.9.2

    package sintaxis;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sicstdLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INSTRUCCION=3, DIRECTIVA=4, REGISTRO=5, EB=6, BASE=7, 
		BYTE=8, START=9, END=10, COMA=11, SHARP=12, ARROBA=13, MAS=14, COMILLA=15, 
		X=16, SIMBOLO=17, FIN_INSTRUCCION=18, NUMERO=19, HEXADECIMAL=20, TEXTO=21, 
		VALOR_HEXADECIMAL=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "INSTRUCCION", "DIRECTIVA", "REGISTRO", "EB", "BASE", 
			"BYTE", "START", "END", "COMA", "SHARP", "ARROBA", "MAS", "COMILLA", 
			"X", "SIMBOLO", "FIN_INSTRUCCION", "NUMERO", "HEXADECIMAL", "TEXTO", 
			"VALOR_HEXADECIMAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'X'", "'C'", null, null, null, null, "'BASE'", "'BYTE'", "'START'", 
			"'END'", "','", "'#'", "'@'", "'+'", null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INSTRUCCION", "DIRECTIVA", "REGISTRO", "EB", "BASE", 
			"BYTE", "START", "END", "COMA", "SHARP", "ARROBA", "MAS", "COMILLA", 
			"X", "SIMBOLO", "FIN_INSTRUCCION", "NUMERO", "HEXADECIMAL", "TEXTO", 
			"VALOR_HEXADECIMAL"
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


	public sicstdLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "sicstd.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u013b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00d9\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00e7\n\5\3\6\3\6\3\7\6\7\u00ec\n\7\r\7\16"+
		"\7\u00ed\3\7\5\7\u00f1\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\6\22\u0114\n\22\r\22\16\22\u0115\3\22\7"+
		"\22\u0119\n\22\f\22\16\22\u011c\13\22\3\23\3\23\3\24\6\24\u0121\n\24\r"+
		"\24\16\24\u0122\3\25\6\25\u0126\n\25\r\25\16\25\u0127\3\25\3\25\3\26\6"+
		"\26\u012d\n\26\r\26\16\26\u012e\3\26\7\26\u0132\n\26\f\26\16\26\u0135"+
		"\13\26\3\27\6\27\u0138\n\27\r\27\16\27\u0139\2\2\30\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30\3\2\f\7\2CDHHNNUVZZ\4\2\13\13\17\17\3\2))\3\2ZZ\3\2C\\"+
		"\4\2\62;C\\\3\2\62;\4\2JJjj\4\2C\\c|\5\2\62;C\\c|\2\u0174\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2"+
		"\2\7\u00d8\3\2\2\2\t\u00e6\3\2\2\2\13\u00e8\3\2\2\2\r\u00f0\3\2\2\2\17"+
		"\u00f2\3\2\2\2\21\u00f7\3\2\2\2\23\u00fc\3\2\2\2\25\u0102\3\2\2\2\27\u0106"+
		"\3\2\2\2\31\u0108\3\2\2\2\33\u010a\3\2\2\2\35\u010c\3\2\2\2\37\u010e\3"+
		"\2\2\2!\u0110\3\2\2\2#\u0113\3\2\2\2%\u011d\3\2\2\2\'\u0120\3\2\2\2)\u0125"+
		"\3\2\2\2+\u012c\3\2\2\2-\u0137\3\2\2\2/\60\7Z\2\2\60\4\3\2\2\2\61\62\7"+
		"E\2\2\62\6\3\2\2\2\63\64\7C\2\2\64\65\7F\2\2\65\u00d9\7F\2\2\66\67\7C"+
		"\2\2\678\7F\2\289\7F\2\29\u00d9\7H\2\2:;\7C\2\2;<\7F\2\2<=\7F\2\2=\u00d9"+
		"\7T\2\2>?\7C\2\2?@\7P\2\2@\u00d9\7F\2\2AB\7E\2\2BC\7N\2\2CD\7G\2\2DE\7"+
		"C\2\2E\u00d9\7T\2\2FG\7E\2\2GH\7Q\2\2HI\7O\2\2I\u00d9\7R\2\2JK\7E\2\2"+
		"KL\7Q\2\2LM\7O\2\2MN\7R\2\2N\u00d9\7H\2\2OP\7E\2\2PQ\7Q\2\2QR\7O\2\2R"+
		"S\7R\2\2S\u00d9\7T\2\2TU\7F\2\2UV\7K\2\2V\u00d9\7X\2\2WX\7F\2\2XY\7K\2"+
		"\2YZ\7X\2\2Z\u00d9\7H\2\2[\\\7F\2\2\\]\7K\2\2]^\7X\2\2^\u00d9\7T\2\2_"+
		"`\7H\2\2`a\7K\2\2a\u00d9\7Z\2\2bc\7H\2\2cd\7N\2\2de\7Q\2\2ef\7C\2\2f\u00d9"+
		"\7V\2\2gh\7J\2\2hi\7K\2\2i\u00d9\7Q\2\2j\u00d9\7L\2\2kl\7L\2\2lm\7G\2"+
		"\2m\u00d9\7S\2\2no\7L\2\2op\7I\2\2p\u00d9\7V\2\2qr\7L\2\2rs\7N\2\2s\u00d9"+
		"\7V\2\2tu\7L\2\2uv\7U\2\2vw\7W\2\2w\u00d9\7D\2\2xy\7N\2\2yz\7F\2\2z\u00d9"+
		"\7C\2\2{|\7N\2\2|}\7F\2\2}\u00d9\7D\2\2~\177\7N\2\2\177\u0080\7F\2\2\u0080"+
		"\u0081\7E\2\2\u0081\u00d9\7J\2\2\u0082\u0083\7N\2\2\u0083\u0084\7F\2\2"+
		"\u0084\u00d9\7H\2\2\u0085\u0086\7N\2\2\u0086\u0087\7F\2\2\u0087\u00d9"+
		"\7N\2\2\u0088\u0089\7N\2\2\u0089\u008a\7F\2\2\u008a\u00d9\7U\2\2\u008b"+
		"\u008c\7N\2\2\u008c\u008d\7F\2\2\u008d\u00d9\7V\2\2\u008e\u008f\7N\2\2"+
		"\u008f\u0090\7F\2\2\u0090\u00d9\7Z\2\2\u0091\u0092\7N\2\2\u0092\u0093"+
		"\7R\2\2\u0093\u00d9\7U\2\2\u0094\u0095\7O\2\2\u0095\u0096\7W\2\2\u0096"+
		"\u00d9\7N\2\2\u0097\u0098\7O\2\2\u0098\u0099\7W\2\2\u0099\u009a\7N\2\2"+
		"\u009a\u00d9\7H\2\2\u009b\u009c\7O\2\2\u009c\u009d\7W\2\2\u009d\u009e"+
		"\7N\2\2\u009e\u00d9\7T\2\2\u009f\u00a0\7P\2\2\u00a0\u00a1\7Q\2\2\u00a1"+
		"\u00a2\7T\2\2\u00a2\u00d9\7O\2\2\u00a3\u00a4\7Q\2\2\u00a4\u00d9\7T\2\2"+
		"\u00a5\u00a6\7T\2\2\u00a6\u00d9\7F\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9"+
		"\7O\2\2\u00a9\u00d9\7Q\2\2\u00aa\u00ab\7T\2\2\u00ab\u00ac\7U\2\2\u00ac"+
		"\u00ad\7W\2\2\u00ad\u00d9\7D\2\2\u00ae\u00af\7U\2\2\u00af\u00b0\7J\2\2"+
		"\u00b0\u00b1\7K\2\2\u00b1\u00b2\7H\2\2\u00b2\u00b3\7V\2\2\u00b3\u00d9"+
		"\7N\2\2\u00b4\u00b5\7U\2\2\u00b5\u00b6\7J\2\2\u00b6\u00b7\7K\2\2\u00b7"+
		"\u00b8\7H\2\2\u00b8\u00b9\7V\2\2\u00b9\u00d9\7T\2\2\u00ba\u00bb\7U\2\2"+
		"\u00bb\u00bc\7K\2\2\u00bc\u00d9\7Q\2\2\u00bd\u00be\7U\2\2\u00be\u00bf"+
		"\7U\2\2\u00bf\u00d9\7M\2\2\u00c0\u00c1\7U\2\2\u00c1\u00c2\7V\2\2\u00c2"+
		"\u00d9\7C\2\2\u00c3\u00c4\7U\2\2\u00c4\u00c5\7V\2\2\u00c5\u00d9\7D\2\2"+
		"\u00c6\u00c7\7U\2\2\u00c7\u00c8\7V\2\2\u00c8\u00c9\7E\2\2\u00c9\u00d9"+
		"\7J\2\2\u00ca\u00cb\7U\2\2\u00cb\u00cc\7V\2\2\u00cc\u00d9\7H\2\2\u00cd"+
		"\u00ce\7V\2\2\u00ce\u00cf\7K\2\2\u00cf\u00d9\7Z\2\2\u00d0\u00d1\7U\2\2"+
		"\u00d1\u00d2\7V\2\2\u00d2\u00d9\7N\2\2\u00d3\u00d4\7V\2\2\u00d4\u00d9"+
		"\7F\2\2\u00d5\u00d6\7U\2\2\u00d6\u00d7\7V\2\2\u00d7\u00d9\7Z\2\2\u00d8"+
		"\63\3\2\2\2\u00d8\66\3\2\2\2\u00d8:\3\2\2\2\u00d8>\3\2\2\2\u00d8A\3\2"+
		"\2\2\u00d8F\3\2\2\2\u00d8J\3\2\2\2\u00d8O\3\2\2\2\u00d8T\3\2\2\2\u00d8"+
		"W\3\2\2\2\u00d8[\3\2\2\2\u00d8_\3\2\2\2\u00d8b\3\2\2\2\u00d8g\3\2\2\2"+
		"\u00d8j\3\2\2\2\u00d8k\3\2\2\2\u00d8n\3\2\2\2\u00d8q\3\2\2\2\u00d8t\3"+
		"\2\2\2\u00d8x\3\2\2\2\u00d8{\3\2\2\2\u00d8~\3\2\2\2\u00d8\u0082\3\2\2"+
		"\2\u00d8\u0085\3\2\2\2\u00d8\u0088\3\2\2\2\u00d8\u008b\3\2\2\2\u00d8\u008e"+
		"\3\2\2\2\u00d8\u0091\3\2\2\2\u00d8\u0094\3\2\2\2\u00d8\u0097\3\2\2\2\u00d8"+
		"\u009b\3\2\2\2\u00d8\u009f\3\2\2\2\u00d8\u00a3\3\2\2\2\u00d8\u00a5\3\2"+
		"\2\2\u00d8\u00a7\3\2\2\2\u00d8\u00aa\3\2\2\2\u00d8\u00ae\3\2\2\2\u00d8"+
		"\u00b4\3\2\2\2\u00d8\u00ba\3\2\2\2\u00d8\u00bd\3\2\2\2\u00d8\u00c0\3\2"+
		"\2\2\u00d8\u00c3\3\2\2\2\u00d8\u00c6\3\2\2\2\u00d8\u00ca\3\2\2\2\u00d8"+
		"\u00cd\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d8\u00d5\3\2"+
		"\2\2\u00d9\b\3\2\2\2\u00da\u00db\7Y\2\2\u00db\u00dc\7Q\2\2\u00dc\u00dd"+
		"\7T\2\2\u00dd\u00e7\7F\2\2\u00de\u00df\7T\2\2\u00df\u00e0\7G\2\2\u00e0"+
		"\u00e1\7U\2\2\u00e1\u00e7\7D\2\2\u00e2\u00e3\7T\2\2\u00e3\u00e4\7G\2\2"+
		"\u00e4\u00e5\7U\2\2\u00e5\u00e7\7Y\2\2\u00e6\u00da\3\2\2\2\u00e6\u00de"+
		"\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e7\n\3\2\2\2\u00e8\u00e9\t\2\2\2\u00e9"+
		"\f\3\2\2\2\u00ea\u00ec\7\"\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2"+
		"\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00f1"+
		"\t\3\2\2\u00f0\u00eb\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\16\3\2\2\2\u00f2"+
		"\u00f3\7D\2\2\u00f3\u00f4\7C\2\2\u00f4\u00f5\7U\2\2\u00f5\u00f6\7G\2\2"+
		"\u00f6\20\3\2\2\2\u00f7\u00f8\7D\2\2\u00f8\u00f9\7[\2\2\u00f9\u00fa\7"+
		"V\2\2\u00fa\u00fb\7G\2\2\u00fb\22\3\2\2\2\u00fc\u00fd\7U\2\2\u00fd\u00fe"+
		"\7V\2\2\u00fe\u00ff\7C\2\2\u00ff\u0100\7T\2\2\u0100\u0101\7V\2\2\u0101"+
		"\24\3\2\2\2\u0102\u0103\7G\2\2\u0103\u0104\7P\2\2\u0104\u0105\7F\2\2\u0105"+
		"\26\3\2\2\2\u0106\u0107\7.\2\2\u0107\30\3\2\2\2\u0108\u0109\7%\2\2\u0109"+
		"\32\3\2\2\2\u010a\u010b\7B\2\2\u010b\34\3\2\2\2\u010c\u010d\7-\2\2\u010d"+
		"\36\3\2\2\2\u010e\u010f\t\4\2\2\u010f \3\2\2\2\u0110\u0111\t\5\2\2\u0111"+
		"\"\3\2\2\2\u0112\u0114\t\6\2\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2"+
		"\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u011a\3\2\2\2\u0117\u0119"+
		"\t\7\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b$\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7\f\2\2"+
		"\u011e&\3\2\2\2\u011f\u0121\t\b\2\2\u0120\u011f\3\2\2\2\u0121\u0122\3"+
		"\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123(\3\2\2\2\u0124\u0126"+
		"\t\b\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\t\t\2\2\u012a*\3\2\2\2"+
		"\u012b\u012d\t\n\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0133\3\2\2\2\u0130\u0132\t\13\2\2"+
		"\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134,\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0138\t\7\2\2\u0137"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a.\3\2\2\2\16\2\u00d8\u00e6\u00ed\u00f0\u0115\u011a\u0122\u0127"+
		"\u012e\u0133\u0139\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}