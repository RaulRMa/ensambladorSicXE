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
		T__0=1, START=2, END=3, COMA=4, SHARP=5, ARROBA=6, H=7, MAS=8, BYTE=9, 
		BASE=10, X=11, C=12, REGISTRO=13, DIRECTIVA=14, INSF1=15, INSF2=16, INSF3=17, 
		COMILLA=18, SIMBOLO=19, HEXADECIMAL=20, CONSTANTE=21, FIN_INSTRUCCION=22, 
		EB=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "START", "END", "COMA", "SHARP", "ARROBA", "H", "MAS", "BYTE", 
			"BASE", "X", "C", "REGISTRO", "DIRECTIVA", "INSF1", "INSF2", "INSF3", 
			"COMILLA", "SIMBOLO", "HEXADECIMAL", "CONSTANTE", "FIN_INSTRUCCION", 
			"EB"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'RSUB'", "'START'", "'END'", "','", "'#'", "'@'", null, "'+'", 
			"'BYTE'", "'BASE'", "'X'", "'C'", null, null, null, null, null, null, 
			null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "START", "END", "COMA", "SHARP", "ARROBA", "H", "MAS", "BYTE", 
			"BASE", "X", "C", "REGISTRO", "DIRECTIVA", "INSF1", "INSF2", "INSF3", 
			"COMILLA", "SIMBOLO", "HEXADECIMAL", "CONSTANTE", "FIN_INSTRUCCION", 
			"EB"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u013b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\5\16[\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17i\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20|\n\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00ab\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0120\n\22\3\23\3\23\3\24"+
		"\6\24\u0125\n\24\r\24\16\24\u0126\3\25\6\25\u012a\n\25\r\25\16\25\u012b"+
		"\3\26\6\26\u012f\n\26\r\26\16\26\u0130\3\27\3\27\3\30\6\30\u0136\n\30"+
		"\r\30\16\30\u0137\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\3\2\t\4\2JJjj\6\2CDHHNNUV\3\2))\3\2C\\\4\2\62;CH\3\2\62;\4\2\13\13"+
		"\17\17\2\u0172\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\66\3\2\2\2\7<\3\2\2\2\t@\3\2\2\2\13B\3"+
		"\2\2\2\rD\3\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23J\3\2\2\2\25O\3\2\2\2\27T"+
		"\3\2\2\2\31V\3\2\2\2\33Z\3\2\2\2\35h\3\2\2\2\37{\3\2\2\2!\u00aa\3\2\2"+
		"\2#\u011f\3\2\2\2%\u0121\3\2\2\2\'\u0124\3\2\2\2)\u0129\3\2\2\2+\u012e"+
		"\3\2\2\2-\u0132\3\2\2\2/\u0135\3\2\2\2\61\62\7T\2\2\62\63\7U\2\2\63\64"+
		"\7W\2\2\64\65\7D\2\2\65\4\3\2\2\2\66\67\7U\2\2\678\7V\2\289\7C\2\29:\7"+
		"T\2\2:;\7V\2\2;\6\3\2\2\2<=\7G\2\2=>\7P\2\2>?\7F\2\2?\b\3\2\2\2@A\7.\2"+
		"\2A\n\3\2\2\2BC\7%\2\2C\f\3\2\2\2DE\7B\2\2E\16\3\2\2\2FG\t\2\2\2G\20\3"+
		"\2\2\2HI\7-\2\2I\22\3\2\2\2JK\7D\2\2KL\7[\2\2LM\7V\2\2MN\7G\2\2N\24\3"+
		"\2\2\2OP\7D\2\2PQ\7C\2\2QR\7U\2\2RS\7G\2\2S\26\3\2\2\2TU\7Z\2\2U\30\3"+
		"\2\2\2VW\7E\2\2W\32\3\2\2\2X[\5\27\f\2Y[\t\3\2\2ZX\3\2\2\2ZY\3\2\2\2["+
		"\34\3\2\2\2\\]\7Y\2\2]^\7Q\2\2^_\7T\2\2_i\7F\2\2`a\7T\2\2ab\7G\2\2bc\7"+
		"U\2\2ci\7D\2\2de\7T\2\2ef\7G\2\2fg\7U\2\2gi\7Y\2\2h\\\3\2\2\2h`\3\2\2"+
		"\2hd\3\2\2\2i\36\3\2\2\2jk\7H\2\2kl\7K\2\2l|\7Z\2\2mn\7H\2\2no\7N\2\2"+
		"op\7Q\2\2pq\7C\2\2q|\7V\2\2rs\7J\2\2st\7K\2\2t|\7Q\2\2uv\7U\2\2vw\7K\2"+
		"\2w|\7Q\2\2xy\7V\2\2yz\7K\2\2z|\7Q\2\2{j\3\2\2\2{m\3\2\2\2{r\3\2\2\2{"+
		"u\3\2\2\2{x\3\2\2\2| \3\2\2\2}~\7C\2\2~\177\7F\2\2\177\u0080\7F\2\2\u0080"+
		"\u00ab\7T\2\2\u0081\u0082\7E\2\2\u0082\u0083\7N\2\2\u0083\u0084\7G\2\2"+
		"\u0084\u0085\7C\2\2\u0085\u00ab\7T\2\2\u0086\u0087\7E\2\2\u0087\u0088"+
		"\7Q\2\2\u0088\u0089\7O\2\2\u0089\u008a\7R\2\2\u008a\u00ab\7T\2\2\u008b"+
		"\u008c\7F\2\2\u008c\u008d\7K\2\2\u008d\u008e\7X\2\2\u008e\u00ab\7T\2\2"+
		"\u008f\u0090\7O\2\2\u0090\u0091\7W\2\2\u0091\u0092\7N\2\2\u0092\u00ab"+
		"\7T\2\2\u0093\u0094\7U\2\2\u0094\u0095\7J\2\2\u0095\u0096\7K\2\2\u0096"+
		"\u0097\7H\2\2\u0097\u0098\7V\2\2\u0098\u00ab\7N\2\2\u0099\u009a\7U\2\2"+
		"\u009a\u009b\7J\2\2\u009b\u009c\7K\2\2\u009c\u009d\7H\2\2\u009d\u009e"+
		"\7V\2\2\u009e\u00ab\7T\2\2\u009f\u00a0\7U\2\2\u00a0\u00a1\7W\2\2\u00a1"+
		"\u00a2\7D\2\2\u00a2\u00ab\7T\2\2\u00a3\u00a4\7U\2\2\u00a4\u00a5\7X\2\2"+
		"\u00a5\u00ab\7E\2\2\u00a6\u00a7\7V\2\2\u00a7\u00a8\7K\2\2\u00a8\u00a9"+
		"\7Z\2\2\u00a9\u00ab\7T\2\2\u00aa}\3\2\2\2\u00aa\u0081\3\2\2\2\u00aa\u0086"+
		"\3\2\2\2\u00aa\u008b\3\2\2\2\u00aa\u008f\3\2\2\2\u00aa\u0093\3\2\2\2\u00aa"+
		"\u0099\3\2\2\2\u00aa\u009f\3\2\2\2\u00aa\u00a3\3\2\2\2\u00aa\u00a6\3\2"+
		"\2\2\u00ab\"\3\2\2\2\u00ac\u00ad\7C\2\2\u00ad\u00ae\7F\2\2\u00ae\u0120"+
		"\7F\2\2\u00af\u00b0\7C\2\2\u00b0\u00b1\7F\2\2\u00b1\u00b2\7F\2\2\u00b2"+
		"\u0120\7H\2\2\u00b3\u00b4\7C\2\2\u00b4\u00b5\7P\2\2\u00b5\u0120\7F\2\2"+
		"\u00b6\u00b7\7E\2\2\u00b7\u00b8\7Q\2\2\u00b8\u00b9\7O\2\2\u00b9\u0120"+
		"\7R\2\2\u00ba\u00bb\7E\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00bd\7O\2\2\u00bd"+
		"\u00be\7R\2\2\u00be\u0120\7H\2\2\u00bf\u00c0\7F\2\2\u00c0\u00c1\7K\2\2"+
		"\u00c1\u0120\7X\2\2\u00c2\u00c3\7F\2\2\u00c3\u00c4\7K\2\2\u00c4\u00c5"+
		"\7X\2\2\u00c5\u0120\7H\2\2\u00c6\u0120\7L\2\2\u00c7\u00c8\7L\2\2\u00c8"+
		"\u00c9\7G\2\2\u00c9\u0120\7S\2\2\u00ca\u00cb\7L\2\2\u00cb\u00cc\7I\2\2"+
		"\u00cc\u0120\7V\2\2\u00cd\u00ce\7L\2\2\u00ce\u00cf\7N\2\2\u00cf\u0120"+
		"\7V\2\2\u00d0\u00d1\7L\2\2\u00d1\u00d2\7U\2\2\u00d2\u00d3\7W\2\2\u00d3"+
		"\u0120\7D\2\2\u00d4\u00d5\7N\2\2\u00d5\u00d6\7F\2\2\u00d6\u0120\7C\2\2"+
		"\u00d7\u00d8\7N\2\2\u00d8\u00d9\7F\2\2\u00d9\u0120\7D\2\2\u00da\u00db"+
		"\7N\2\2\u00db\u00dc\7F\2\2\u00dc\u00dd\7E\2\2\u00dd\u0120\7J\2\2\u00de"+
		"\u00df\7N\2\2\u00df\u00e0\7F\2\2\u00e0\u0120\7H\2\2\u00e1\u00e2\7N\2\2"+
		"\u00e2\u00e3\7F\2\2\u00e3\u0120\7N\2\2\u00e4\u00e5\7N\2\2\u00e5\u00e6"+
		"\7F\2\2\u00e6\u0120\7U\2\2\u00e7\u00e8\7N\2\2\u00e8\u00e9\7F\2\2\u00e9"+
		"\u0120\7V\2\2\u00ea\u00eb\7N\2\2\u00eb\u00ec\7F\2\2\u00ec\u0120\7Z\2\2"+
		"\u00ed\u00ee\7N\2\2\u00ee\u00ef\7R\2\2\u00ef\u0120\7U\2\2\u00f0\u00f1"+
		"\7O\2\2\u00f1\u00f2\7W\2\2\u00f2\u0120\7N\2\2\u00f3\u00f4\7O\2\2\u00f4"+
		"\u00f5\7W\2\2\u00f5\u00f6\7N\2\2\u00f6\u0120\7H\2\2\u00f7\u00f8\7P\2\2"+
		"\u00f8\u00f9\7Q\2\2\u00f9\u00fa\7T\2\2\u00fa\u0120\7O\2\2\u00fb\u00fc"+
		"\7Q\2\2\u00fc\u0120\7T\2\2\u00fd\u00fe\7T\2\2\u00fe\u0120\7F\2\2\u00ff"+
		"\u0100\7T\2\2\u0100\u0101\7O\2\2\u0101\u0120\7Q\2\2\u0102\u0103\7U\2\2"+
		"\u0103\u0104\7U\2\2\u0104\u0120\7M\2\2\u0105\u0106\7U\2\2\u0106\u0107"+
		"\7V\2\2\u0107\u0120\7C\2\2\u0108\u0109\7U\2\2\u0109\u010a\7V\2\2\u010a"+
		"\u0120\7D\2\2\u010b\u010c\7U\2\2\u010c\u010d\7V\2\2\u010d\u010e\7E\2\2"+
		"\u010e\u0120\7J\2\2\u010f\u0110\7U\2\2\u0110\u0111\7V\2\2\u0111\u0120"+
		"\7H\2\2\u0112\u0113\7V\2\2\u0113\u0114\7K\2\2\u0114\u0120\7Z\2\2\u0115"+
		"\u0116\7U\2\2\u0116\u0117\7V\2\2\u0117\u0120\7N\2\2\u0118\u0119\7V\2\2"+
		"\u0119\u0120\7F\2\2\u011a\u011b\7U\2\2\u011b\u011c\7V\2\2\u011c\u0120"+
		"\7Z\2\2\u011d\u011e\7Y\2\2\u011e\u0120\7F\2\2\u011f\u00ac\3\2\2\2\u011f"+
		"\u00af\3\2\2\2\u011f\u00b3\3\2\2\2\u011f\u00b6\3\2\2\2\u011f\u00ba\3\2"+
		"\2\2\u011f\u00bf\3\2\2\2\u011f\u00c2\3\2\2\2\u011f\u00c6\3\2\2\2\u011f"+
		"\u00c7\3\2\2\2\u011f\u00ca\3\2\2\2\u011f\u00cd\3\2\2\2\u011f\u00d0\3\2"+
		"\2\2\u011f\u00d4\3\2\2\2\u011f\u00d7\3\2\2\2\u011f\u00da\3\2\2\2\u011f"+
		"\u00de\3\2\2\2\u011f\u00e1\3\2\2\2\u011f\u00e4\3\2\2\2\u011f\u00e7\3\2"+
		"\2\2\u011f\u00ea\3\2\2\2\u011f\u00ed\3\2\2\2\u011f\u00f0\3\2\2\2\u011f"+
		"\u00f3\3\2\2\2\u011f\u00f7\3\2\2\2\u011f\u00fb\3\2\2\2\u011f\u00fd\3\2"+
		"\2\2\u011f\u00ff\3\2\2\2\u011f\u0102\3\2\2\2\u011f\u0105\3\2\2\2\u011f"+
		"\u0108\3\2\2\2\u011f\u010b\3\2\2\2\u011f\u010f\3\2\2\2\u011f\u0112\3\2"+
		"\2\2\u011f\u0115\3\2\2\2\u011f\u0118\3\2\2\2\u011f\u011a\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120$\3\2\2\2\u0121\u0122\t\4\2\2\u0122&\3\2\2\2\u0123"+
		"\u0125\t\5\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2"+
		"\2\2\u0126\u0127\3\2\2\2\u0127(\3\2\2\2\u0128\u012a\t\6\2\2\u0129\u0128"+
		"\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"*\3\2\2\2\u012d\u012f\t\7\2\2\u012e\u012d\3\2\2\2\u012f\u0130\3\2\2\2"+
		"\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131,\3\2\2\2\u0132\u0133\7"+
		"\f\2\2\u0133.\3\2\2\2\u0134\u0136\t\b\2\2\u0135\u0134\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013a\b\30\2\2\u013a\60\3\2\2\2\f\2Zh{\u00aa\u011f\u0126\u012b\u0130"+
		"\u0137\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}