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
		START=1, END=2, COMA=3, SHARP=4, ARROBA=5, H=6, MAS=7, BYTE=8, BASE=9, 
		X=10, C=11, CLEAR=12, REGISTRO=13, DIRECTIVA=14, INSF1=15, INSF2=16, SHIFT=17, 
		SVC=18, INSF3=19, RSUB=20, FIN_INSTRUCCION=21, COMILLA=22, NUMERO=23, 
		HEXADECIMAL=24, SIMBOLO=25, EB=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"START", "END", "COMA", "SHARP", "ARROBA", "H", "MAS", "BYTE", "BASE", 
			"X", "C", "CLEAR", "REGISTRO", "DIRECTIVA", "INSF1", "INSF2", "SHIFT", 
			"SVC", "INSF3", "RSUB", "FIN_INSTRUCCION", "COMILLA", "NUMERO", "HEXADECIMAL", 
			"SIMBOLO", "EB"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "','", "'#'", "'@'", null, "'+'", "'BYTE'", 
			"'BASE'", "'X'", "'C'", "'CLEAR'", null, null, null, null, null, "'SVC'", 
			null, "'RSUB'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "START", "END", "COMA", "SHARP", "ARROBA", "H", "MAS", "BYTE", 
			"BASE", "X", "C", "CLEAR", "REGISTRO", "DIRECTIVA", "INSF1", "INSF2", 
			"SHIFT", "SVC", "INSF3", "RSUB", "FIN_INSTRUCCION", "COMILLA", "NUMERO", 
			"HEXADECIMAL", "SIMBOLO", "EB"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u014b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16b\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17p\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0083\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u009e\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00ac\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u0125\n\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\6\30"+
		"\u0131\n\30\r\30\16\30\u0132\3\31\6\31\u0136\n\31\r\31\16\31\u0137\3\31"+
		"\7\31\u013b\n\31\f\31\16\31\u013e\13\31\3\32\6\32\u0141\n\32\r\32\16\32"+
		"\u0142\3\33\6\33\u0146\n\33\r\33\16\33\u0147\3\33\3\33\2\2\34\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\t\4\2JJjj\6\2CDHH"+
		"NNUV\3\2))\3\2\62;\4\2\62;CH\5\2\62;C\\c|\4\2\13\13\17\17\2\u0180\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5=\3\2\2\2\7A\3\2\2"+
		"\2\tC\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23P\3\2\2"+
		"\2\25U\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33a\3\2\2\2\35o\3\2\2\2\37\u0082"+
		"\3\2\2\2!\u009d\3\2\2\2#\u00ab\3\2\2\2%\u00ad\3\2\2\2\'\u0124\3\2\2\2"+
		")\u0126\3\2\2\2+\u012b\3\2\2\2-\u012d\3\2\2\2/\u0130\3\2\2\2\61\u0135"+
		"\3\2\2\2\63\u0140\3\2\2\2\65\u0145\3\2\2\2\678\7U\2\289\7V\2\29:\7C\2"+
		"\2:;\7T\2\2;<\7V\2\2<\4\3\2\2\2=>\7G\2\2>?\7P\2\2?@\7F\2\2@\6\3\2\2\2"+
		"AB\7.\2\2B\b\3\2\2\2CD\7%\2\2D\n\3\2\2\2EF\7B\2\2F\f\3\2\2\2GH\t\2\2\2"+
		"H\16\3\2\2\2IJ\7-\2\2J\20\3\2\2\2KL\7D\2\2LM\7[\2\2MN\7V\2\2NO\7G\2\2"+
		"O\22\3\2\2\2PQ\7D\2\2QR\7C\2\2RS\7U\2\2ST\7G\2\2T\24\3\2\2\2UV\7Z\2\2"+
		"V\26\3\2\2\2WX\7E\2\2X\30\3\2\2\2YZ\7E\2\2Z[\7N\2\2[\\\7G\2\2\\]\7C\2"+
		"\2]^\7T\2\2^\32\3\2\2\2_b\5\25\13\2`b\t\3\2\2a_\3\2\2\2a`\3\2\2\2b\34"+
		"\3\2\2\2cd\7Y\2\2de\7Q\2\2ef\7T\2\2fp\7F\2\2gh\7T\2\2hi\7G\2\2ij\7U\2"+
		"\2jp\7D\2\2kl\7T\2\2lm\7G\2\2mn\7U\2\2np\7Y\2\2oc\3\2\2\2og\3\2\2\2ok"+
		"\3\2\2\2p\36\3\2\2\2qr\7H\2\2rs\7K\2\2s\u0083\7Z\2\2tu\7H\2\2uv\7N\2\2"+
		"vw\7Q\2\2wx\7C\2\2x\u0083\7V\2\2yz\7J\2\2z{\7K\2\2{\u0083\7Q\2\2|}\7U"+
		"\2\2}~\7K\2\2~\u0083\7Q\2\2\177\u0080\7V\2\2\u0080\u0081\7K\2\2\u0081"+
		"\u0083\7Q\2\2\u0082q\3\2\2\2\u0082t\3\2\2\2\u0082y\3\2\2\2\u0082|\3\2"+
		"\2\2\u0082\177\3\2\2\2\u0083 \3\2\2\2\u0084\u0085\7C\2\2\u0085\u0086\7"+
		"F\2\2\u0086\u0087\7F\2\2\u0087\u009e\7T\2\2\u0088\u0089\7E\2\2\u0089\u008a"+
		"\7Q\2\2\u008a\u008b\7O\2\2\u008b\u008c\7R\2\2\u008c\u009e\7T\2\2\u008d"+
		"\u008e\7F\2\2\u008e\u008f\7K\2\2\u008f\u0090\7X\2\2\u0090\u009e\7T\2\2"+
		"\u0091\u0092\7O\2\2\u0092\u0093\7W\2\2\u0093\u0094\7N\2\2\u0094\u009e"+
		"\7T\2\2\u0095\u0096\7U\2\2\u0096\u0097\7W\2\2\u0097\u0098\7D\2\2\u0098"+
		"\u009e\7T\2\2\u0099\u009a\7V\2\2\u009a\u009b\7K\2\2\u009b\u009c\7Z\2\2"+
		"\u009c\u009e\7T\2\2\u009d\u0084\3\2\2\2\u009d\u0088\3\2\2\2\u009d\u008d"+
		"\3\2\2\2\u009d\u0091\3\2\2\2\u009d\u0095\3\2\2\2\u009d\u0099\3\2\2\2\u009e"+
		"\"\3\2\2\2\u009f\u00a0\7U\2\2\u00a0\u00a1\7J\2\2\u00a1\u00a2\7K\2\2\u00a2"+
		"\u00a3\7H\2\2\u00a3\u00a4\7V\2\2\u00a4\u00ac\7N\2\2\u00a5\u00a6\7U\2\2"+
		"\u00a6\u00a7\7J\2\2\u00a7\u00a8\7K\2\2\u00a8\u00a9\7H\2\2\u00a9\u00aa"+
		"\7V\2\2\u00aa\u00ac\7T\2\2\u00ab\u009f\3\2\2\2\u00ab\u00a5\3\2\2\2\u00ac"+
		"$\3\2\2\2\u00ad\u00ae\7U\2\2\u00ae\u00af\7X\2\2\u00af\u00b0\7E\2\2\u00b0"+
		"&\3\2\2\2\u00b1\u00b2\7C\2\2\u00b2\u00b3\7F\2\2\u00b3\u0125\7F\2\2\u00b4"+
		"\u00b5\7C\2\2\u00b5\u00b6\7F\2\2\u00b6\u00b7\7F\2\2\u00b7\u0125\7H\2\2"+
		"\u00b8\u00b9\7C\2\2\u00b9\u00ba\7P\2\2\u00ba\u0125\7F\2\2\u00bb\u00bc"+
		"\7E\2\2\u00bc\u00bd\7Q\2\2\u00bd\u00be\7O\2\2\u00be\u0125\7R\2\2\u00bf"+
		"\u00c0\7E\2\2\u00c0\u00c1\7Q\2\2\u00c1\u00c2\7O\2\2\u00c2\u00c3\7R\2\2"+
		"\u00c3\u0125\7H\2\2\u00c4\u00c5\7F\2\2\u00c5\u00c6\7K\2\2\u00c6\u0125"+
		"\7X\2\2\u00c7\u00c8\7F\2\2\u00c8\u00c9\7K\2\2\u00c9\u00ca\7X\2\2\u00ca"+
		"\u0125\7H\2\2\u00cb\u0125\7L\2\2\u00cc\u00cd\7L\2\2\u00cd\u00ce\7G\2\2"+
		"\u00ce\u0125\7S\2\2\u00cf\u00d0\7L\2\2\u00d0\u00d1\7I\2\2\u00d1\u0125"+
		"\7V\2\2\u00d2\u00d3\7L\2\2\u00d3\u00d4\7N\2\2\u00d4\u0125\7V\2\2\u00d5"+
		"\u00d6\7L\2\2\u00d6\u00d7\7U\2\2\u00d7\u00d8\7W\2\2\u00d8\u0125\7D\2\2"+
		"\u00d9\u00da\7N\2\2\u00da\u00db\7F\2\2\u00db\u0125\7C\2\2\u00dc\u00dd"+
		"\7N\2\2\u00dd\u00de\7F\2\2\u00de\u0125\7D\2\2\u00df\u00e0\7N\2\2\u00e0"+
		"\u00e1\7F\2\2\u00e1\u00e2\7E\2\2\u00e2\u0125\7J\2\2\u00e3\u00e4\7N\2\2"+
		"\u00e4\u00e5\7F\2\2\u00e5\u0125\7H\2\2\u00e6\u00e7\7N\2\2\u00e7\u00e8"+
		"\7F\2\2\u00e8\u0125\7N\2\2\u00e9\u00ea\7N\2\2\u00ea\u00eb\7F\2\2\u00eb"+
		"\u0125\7U\2\2\u00ec\u00ed\7N\2\2\u00ed\u00ee\7F\2\2\u00ee\u0125\7V\2\2"+
		"\u00ef\u00f0\7N\2\2\u00f0\u00f1\7F\2\2\u00f1\u0125\7Z\2\2\u00f2\u00f3"+
		"\7N\2\2\u00f3\u00f4\7R\2\2\u00f4\u0125\7U\2\2\u00f5\u00f6\7O\2\2\u00f6"+
		"\u00f7\7W\2\2\u00f7\u0125\7N\2\2\u00f8\u00f9\7O\2\2\u00f9\u00fa\7W\2\2"+
		"\u00fa\u00fb\7N\2\2\u00fb\u0125\7H\2\2\u00fc\u00fd\7P\2\2\u00fd\u00fe"+
		"\7Q\2\2\u00fe\u00ff\7T\2\2\u00ff\u0125\7O\2\2\u0100\u0101\7Q\2\2\u0101"+
		"\u0125\7T\2\2\u0102\u0103\7T\2\2\u0103\u0125\7F\2\2\u0104\u0105\7T\2\2"+
		"\u0105\u0106\7O\2\2\u0106\u0125\7Q\2\2\u0107\u0108\7U\2\2\u0108\u0109"+
		"\7U\2\2\u0109\u0125\7M\2\2\u010a\u010b\7U\2\2\u010b\u010c\7V\2\2\u010c"+
		"\u0125\7C\2\2\u010d\u010e\7U\2\2\u010e\u010f\7V\2\2\u010f\u0125\7D\2\2"+
		"\u0110\u0111\7U\2\2\u0111\u0112\7V\2\2\u0112\u0113\7E\2\2\u0113\u0125"+
		"\7J\2\2\u0114\u0115\7U\2\2\u0115\u0116\7V\2\2\u0116\u0125\7H\2\2\u0117"+
		"\u0118\7V\2\2\u0118\u0119\7K\2\2\u0119\u0125\7Z\2\2\u011a\u011b\7U\2\2"+
		"\u011b\u011c\7V\2\2\u011c\u0125\7N\2\2\u011d\u011e\7V\2\2\u011e\u0125"+
		"\7F\2\2\u011f\u0120\7U\2\2\u0120\u0121\7V\2\2\u0121\u0125\7Z\2\2\u0122"+
		"\u0123\7Y\2\2\u0123\u0125\7F\2\2\u0124\u00b1\3\2\2\2\u0124\u00b4\3\2\2"+
		"\2\u0124\u00b8\3\2\2\2\u0124\u00bb\3\2\2\2\u0124\u00bf\3\2\2\2\u0124\u00c4"+
		"\3\2\2\2\u0124\u00c7\3\2\2\2\u0124\u00cb\3\2\2\2\u0124\u00cc\3\2\2\2\u0124"+
		"\u00cf\3\2\2\2\u0124\u00d2\3\2\2\2\u0124\u00d5\3\2\2\2\u0124\u00d9\3\2"+
		"\2\2\u0124\u00dc\3\2\2\2\u0124\u00df\3\2\2\2\u0124\u00e3\3\2\2\2\u0124"+
		"\u00e6\3\2\2\2\u0124\u00e9\3\2\2\2\u0124\u00ec\3\2\2\2\u0124\u00ef\3\2"+
		"\2\2\u0124\u00f2\3\2\2\2\u0124\u00f5\3\2\2\2\u0124\u00f8\3\2\2\2\u0124"+
		"\u00fc\3\2\2\2\u0124\u0100\3\2\2\2\u0124\u0102\3\2\2\2\u0124\u0104\3\2"+
		"\2\2\u0124\u0107\3\2\2\2\u0124\u010a\3\2\2\2\u0124\u010d\3\2\2\2\u0124"+
		"\u0110\3\2\2\2\u0124\u0114\3\2\2\2\u0124\u0117\3\2\2\2\u0124\u011a\3\2"+
		"\2\2\u0124\u011d\3\2\2\2\u0124\u011f\3\2\2\2\u0124\u0122\3\2\2\2\u0125"+
		"(\3\2\2\2\u0126\u0127\7T\2\2\u0127\u0128\7U\2\2\u0128\u0129\7W\2\2\u0129"+
		"\u012a\7D\2\2\u012a*\3\2\2\2\u012b\u012c\7\f\2\2\u012c,\3\2\2\2\u012d"+
		"\u012e\t\4\2\2\u012e.\3\2\2\2\u012f\u0131\t\5\2\2\u0130\u012f\3\2\2\2"+
		"\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\60"+
		"\3\2\2\2\u0134\u0136\t\6\2\2\u0135\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013c\3\2\2\2\u0139\u013b\5\r"+
		"\7\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\62\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0141\t\7\2"+
		"\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\64\3\2\2\2\u0144\u0146\t\b\2\2\u0145\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2"+
		"\2\2\u0149\u014a\b\33\2\2\u014a\66\3\2\2\2\16\2ao\u0082\u009d\u00ab\u0124"+
		"\u0132\u0137\u013c\u0142\u0147\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}