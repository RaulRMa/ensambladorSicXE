// Generated from /home/raul/Documentos/UASLP/softwareDeSistemas/ensambladorSicXE/grammar/evaluador.g4 by ANTLR 4.10.1
package Evaluador;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class evaluadorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAS=1, MENOS=2, MULT=3, DIV=4, PAR_INI=5, PAR_FIN=6, NUMERO=7, EB=8;
	public static final int
		RULE_expresion = 0, RULE_factor = 1, RULE_termino = 2, RULE_print = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"expresion", "factor", "termino", "print"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAS", "MENOS", "MULT", "DIV", "PAR_INI", "PAR_FIN", "NUMERO", 
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

	@Override
	public String getGrammarFileName() { return "evaluador.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public evaluadorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpresionContext extends ParserRuleContext {
		public Object value;
		public Token t4;
		public FactorContext t1;
		public FactorContext t2;
		public FactorContext t3;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MENOS() { return getTokens(evaluadorParser.MENOS); }
		public TerminalNode MENOS(int i) {
			return getToken(evaluadorParser.MENOS, i);
		}
		public List<TerminalNode> MAS() { return getTokens(evaluadorParser.MAS); }
		public TerminalNode MAS(int i) {
			return getToken(evaluadorParser.MAS, i);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expresion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(8);
				((ExpresionContext)_localctx).t4 = match(MENOS);
				}
			}

			{
			setState(11);
			((ExpresionContext)_localctx).t1 = factor();
			((ExpresionContext)_localctx).value =  (((ExpresionContext)_localctx).t4!=null?((ExpresionContext)_localctx).t4.getText():null) != null ? - (int)((ExpresionContext)_localctx).t1.value : (int)((ExpresionContext)_localctx).t1.value; 
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAS || _la==MENOS) {
				{
				setState(21);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MAS:
					{
					setState(13);
					match(MAS);
					setState(14);
					((ExpresionContext)_localctx).t2 = factor();
					((ExpresionContext)_localctx).value =  (((ExpresionContext)_localctx).t4!=null?((ExpresionContext)_localctx).t4.getText():null) != null ? - (int)_localctx.value + (int)((ExpresionContext)_localctx).t2.value : (int)_localctx.value + (int)((ExpresionContext)_localctx).t2.value; 
					}
					break;
				case MENOS:
					{
					setState(17);
					match(MENOS);
					setState(18);
					((ExpresionContext)_localctx).t3 = factor();
					((ExpresionContext)_localctx).value =  (((ExpresionContext)_localctx).t4!=null?((ExpresionContext)_localctx).t4.getText():null) != null ? - (int)_localctx.value - (int)((ExpresionContext)_localctx).t3.value : (int)_localctx.value - (int)((ExpresionContext)_localctx).t3.value; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FactorContext extends ParserRuleContext {
		public Object value;
		public TerminoContext t1;
		public TerminoContext t2;
		public TerminoContext t3;
		public List<TerminoContext> termino() {
			return getRuleContexts(TerminoContext.class);
		}
		public TerminoContext termino(int i) {
			return getRuleContext(TerminoContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(evaluadorParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(evaluadorParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(evaluadorParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(evaluadorParser.DIV, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((FactorContext)_localctx).t1 = termino();
			 ((FactorContext)_localctx).value =  (int)((FactorContext)_localctx).t1.value;
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(28);
					match(MULT);
					setState(29);
					((FactorContext)_localctx).t2 = termino();
					((FactorContext)_localctx).value =  (int)_localctx.value * (int)((FactorContext)_localctx).t2.value; 
					}
					break;
				case DIV:
					{
					setState(32);
					match(DIV);
					setState(33);
					((FactorContext)_localctx).t3 = termino();
					((FactorContext)_localctx).value =  (int)_localctx.value / (int)((FactorContext)_localctx).t3.value; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TerminoContext extends ParserRuleContext {
		public Object value;
		public ExpresionContext expresion;
		public Token NUMERO;
		public TerminalNode PAR_INI() { return getToken(evaluadorParser.PAR_INI, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAR_FIN() { return getToken(evaluadorParser.PAR_FIN, 0); }
		public TerminalNode NUMERO() { return getToken(evaluadorParser.NUMERO, 0); }
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_termino);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAR_INI:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(PAR_INI);
				setState(42);
				((TerminoContext)_localctx).expresion = expresion();
				setState(43);
				match(PAR_FIN);
				((TerminoContext)_localctx).value =  ((TerminoContext)_localctx).expresion.value; 
				}
				break;
			case NUMERO:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				((TerminoContext)_localctx).NUMERO = match(NUMERO);
				 ((TerminoContext)_localctx).value =  Integer.parseInt((((TerminoContext)_localctx).NUMERO!=null?((TerminoContext)_localctx).NUMERO.getText():null)); 
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

	public static class PrintContext extends ParserRuleContext {
		public ExpresionContext expresion;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((PrintContext)_localctx).expresion = expresion();

			        System.out.println(((PrintContext)_localctx).expresion.value);
			    
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

	public static final String _serializedATN =
		"\u0004\u0001\b6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0003\u0000\n\b"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0016"+
		"\b\u0000\n\u0000\f\u0000\u0019\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00021\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u00007\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0002\u001a\u0001\u0000\u0000\u0000\u00040\u0001\u0000"+
		"\u0000\u0000\u00062\u0001\u0000\u0000\u0000\b\n\u0005\u0002\u0000\u0000"+
		"\t\b\u0001\u0000\u0000\u0000\t\n\u0001\u0000\u0000\u0000\n\u000b\u0001"+
		"\u0000\u0000\u0000\u000b\f\u0003\u0002\u0001\u0000\f\u0017\u0006\u0000"+
		"\uffff\uffff\u0000\r\u000e\u0005\u0001\u0000\u0000\u000e\u000f\u0003\u0002"+
		"\u0001\u0000\u000f\u0010\u0006\u0000\uffff\uffff\u0000\u0010\u0016\u0001"+
		"\u0000\u0000\u0000\u0011\u0012\u0005\u0002\u0000\u0000\u0012\u0013\u0003"+
		"\u0002\u0001\u0000\u0013\u0014\u0006\u0000\uffff\uffff\u0000\u0014\u0016"+
		"\u0001\u0000\u0000\u0000\u0015\r\u0001\u0000\u0000\u0000\u0015\u0011\u0001"+
		"\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000\u0000\u0017\u0015\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0001\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a\u001b\u0003"+
		"\u0004\u0002\u0000\u001b&\u0006\u0001\uffff\uffff\u0000\u001c\u001d\u0005"+
		"\u0003\u0000\u0000\u001d\u001e\u0003\u0004\u0002\u0000\u001e\u001f\u0006"+
		"\u0001\uffff\uffff\u0000\u001f%\u0001\u0000\u0000\u0000 !\u0005\u0004"+
		"\u0000\u0000!\"\u0003\u0004\u0002\u0000\"#\u0006\u0001\uffff\uffff\u0000"+
		"#%\u0001\u0000\u0000\u0000$\u001c\u0001\u0000\u0000\u0000$ \u0001\u0000"+
		"\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001"+
		"\u0000\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0005\u0000\u0000*+\u0003\u0000\u0000\u0000+,\u0005\u0006"+
		"\u0000\u0000,-\u0006\u0002\uffff\uffff\u0000-1\u0001\u0000\u0000\u0000"+
		"./\u0005\u0007\u0000\u0000/1\u0006\u0002\uffff\uffff\u00000)\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u00001\u0005\u0001\u0000\u0000\u0000"+
		"23\u0003\u0000\u0000\u000034\u0006\u0003\uffff\uffff\u00004\u0007\u0001"+
		"\u0000\u0000\u0000\u0006\t\u0015\u0017$&0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}