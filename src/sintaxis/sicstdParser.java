// Generated from /home/raul/Documentos/UASLP/2021-2022-2/SoftwareDeSistemas/Laboratorio/analizador/grammar/sicstd.g4 by ANTLR 4.9.2

    package sintaxis;
    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sicstdParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, END=2, COMA=3, SHARP=4, ARROBA=5, H=6, MAS=7, BYTE=8, BASE=9, 
		X=10, C=11, CLEAR=12, REGISTRO=13, DIRECTIVA=14, INSF1=15, INSF2=16, SHIFT=17, 
		SVC=18, INSF3=19, RSUB=20, FIN_INSTRUCCION=21, COMILLA=22, NUMERO=23, 
		HEXADECIMAL=24, SIMBOLO=25, EB=26;
	public static final int
		RULE_programa = 0, RULE_start = 1, RULE_end = 2, RULE_instruccion = 3, 
		RULE_inst_f1 = 4, RULE_inst_f2 = 5, RULE_op_insf2 = 6, RULE_inst_f3 = 7, 
		RULE_inst_f4 = 8, RULE_directiva = 9, RULE_direccion = 10, RULE_simple = 11, 
		RULE_indirecto = 12, RULE_inmediato = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "start", "end", "instruccion", "inst_f1", "inst_f2", "op_insf2", 
			"inst_f3", "inst_f4", "directiva", "direccion", "simple", "indirecto", 
			"inmediato"
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

	@Override
	public String getGrammarFileName() { return "sicstd.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public ArrayList<Instruccion> listaInstrucciones = new ArrayList<>();

	public sicstdParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			start();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAS) | (1L << BYTE) | (1L << BASE) | (1L << CLEAR) | (1L << DIRECTIVA) | (1L << INSF1) | (1L << INSF2) | (1L << SHIFT) | (1L << SVC) | (1L << INSF3) | (1L << RSUB) | (1L << SIMBOLO))) != 0)) {
				{
				{
				setState(29);
				instruccion();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			end();
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

	public static class StartContext extends ParserRuleContext {
		public Token SIMBOLO;
		public Token NUMERO;
		public Token HEXADECIMAL;
		public TerminalNode START() { return getToken(sicstdParser.START, 0); }
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(sicstdParser.HEXADECIMAL, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(37);
				((StartContext)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			setState(40);
			match(START);
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERO:
				{
				setState(41);
				((StartContext)_localctx).NUMERO = match(NUMERO);

				            listaInstrucciones.add(new Instruccion("Start",(((StartContext)_localctx).NUMERO!=null?((StartContext)_localctx).NUMERO.getText():null),(((StartContext)_localctx).SIMBOLO!=null?((StartContext)_localctx).SIMBOLO.getText():null), "Start"));
				        
				}
				break;
			case HEXADECIMAL:
				{
				setState(43);
				((StartContext)_localctx).HEXADECIMAL = match(HEXADECIMAL);

				            listaInstrucciones.add(new Instruccion("Start",(((StartContext)_localctx).HEXADECIMAL!=null?((StartContext)_localctx).HEXADECIMAL.getText():null),(((StartContext)_localctx).SIMBOLO!=null?((StartContext)_localctx).SIMBOLO.getText():null), "Start"));
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(47);
			match(FIN_INSTRUCCION);
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

	public static class EndContext extends ParserRuleContext {
		public Token SIMBOLO;
		public TerminalNode END() { return getToken(sicstdParser.END, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(END);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(50);
				((EndContext)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			listaInstrucciones.add(new Instruccion("END",(((EndContext)_localctx).SIMBOLO!=null?((EndContext)_localctx).SIMBOLO.getText():null)));
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

	public static class InstruccionContext extends ParserRuleContext {
		public Inst_f1Context inst_f1() {
			return getRuleContext(Inst_f1Context.class,0);
		}
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public Inst_f2Context inst_f2() {
			return getRuleContext(Inst_f2Context.class,0);
		}
		public Inst_f3Context inst_f3() {
			return getRuleContext(Inst_f3Context.class,0);
		}
		public Inst_f4Context inst_f4() {
			return getRuleContext(Inst_f4Context.class,0);
		}
		public DirectivaContext directiva() {
			return getRuleContext(DirectivaContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruccion);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				inst_f1();
				setState(56);
				match(FIN_INSTRUCCION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				inst_f2();
				setState(59);
				match(FIN_INSTRUCCION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				inst_f3();
				setState(62);
				match(FIN_INSTRUCCION);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				inst_f4();
				setState(65);
				match(FIN_INSTRUCCION);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				directiva();
				setState(68);
				match(FIN_INSTRUCCION);
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

	public static class Inst_f1Context extends ParserRuleContext {
		public Token SIMBOLO;
		public Token INSF1;
		public TerminalNode INSF1() { return getToken(sicstdParser.INSF1, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public Inst_f1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst_f1; }
	}

	public final Inst_f1Context inst_f1() throws RecognitionException {
		Inst_f1Context _localctx = new Inst_f1Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_inst_f1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(72);
				((Inst_f1Context)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			setState(75);
			((Inst_f1Context)_localctx).INSF1 = match(INSF1);

			        listaInstrucciones.add(new Instruccion("INSF1","",(((Inst_f1Context)_localctx).SIMBOLO!=null?((Inst_f1Context)_localctx).SIMBOLO.getText():null),(((Inst_f1Context)_localctx).INSF1!=null?((Inst_f1Context)_localctx).INSF1.getText():null)));
			    
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

	public static class Inst_f2Context extends ParserRuleContext {
		public Token SIMBOLO;
		public Token INSF2;
		public Token CLEAR;
		public Token SHIFT;
		public Token SVC;
		public Token NUMERO;
		public TerminalNode INSF2() { return getToken(sicstdParser.INSF2, 0); }
		public TerminalNode COMA() { return getToken(sicstdParser.COMA, 0); }
		public List<TerminalNode> REGISTRO() { return getTokens(sicstdParser.REGISTRO); }
		public TerminalNode REGISTRO(int i) {
			return getToken(sicstdParser.REGISTRO, i);
		}
		public List<TerminalNode> X() { return getTokens(sicstdParser.X); }
		public TerminalNode X(int i) {
			return getToken(sicstdParser.X, i);
		}
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public TerminalNode CLEAR() { return getToken(sicstdParser.CLEAR, 0); }
		public TerminalNode SHIFT() { return getToken(sicstdParser.SHIFT, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public TerminalNode SVC() { return getToken(sicstdParser.SVC, 0); }
		public Inst_f2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst_f2; }
	}

	public final Inst_f2Context inst_f2() throws RecognitionException {
		Inst_f2Context _localctx = new Inst_f2Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_inst_f2);
		int _la;
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIMBOLO) {
					{
					setState(78);
					((Inst_f2Context)_localctx).SIMBOLO = match(SIMBOLO);
					}
				}

				setState(81);
				((Inst_f2Context)_localctx).INSF2 = match(INSF2);
				setState(82);
				_la = _input.LA(1);
				if ( !(_la==X || _la==REGISTRO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(83);
				match(COMA);
				setState(84);
				_la = _input.LA(1);
				if ( !(_la==X || _la==REGISTRO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				listaInstrucciones.add(new Instruccion("INSF2","",(((Inst_f2Context)_localctx).SIMBOLO!=null?((Inst_f2Context)_localctx).SIMBOLO.getText():null),(((Inst_f2Context)_localctx).INSF2!=null?((Inst_f2Context)_localctx).INSF2.getText():null)));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIMBOLO) {
					{
					setState(86);
					((Inst_f2Context)_localctx).SIMBOLO = match(SIMBOLO);
					}
				}

				setState(89);
				((Inst_f2Context)_localctx).CLEAR = match(CLEAR);
				setState(90);
				_la = _input.LA(1);
				if ( !(_la==X || _la==REGISTRO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				listaInstrucciones.add(new Instruccion("INSF2","",(((Inst_f2Context)_localctx).SIMBOLO!=null?((Inst_f2Context)_localctx).SIMBOLO.getText():null),(((Inst_f2Context)_localctx).CLEAR!=null?((Inst_f2Context)_localctx).CLEAR.getText():null)));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIMBOLO) {
					{
					setState(92);
					((Inst_f2Context)_localctx).SIMBOLO = match(SIMBOLO);
					}
				}

				setState(95);
				((Inst_f2Context)_localctx).SHIFT = match(SHIFT);
				setState(96);
				_la = _input.LA(1);
				if ( !(_la==X || _la==REGISTRO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(97);
				match(COMA);
				setState(98);
				match(NUMERO);
				listaInstrucciones.add(new Instruccion("INSF2","",(((Inst_f2Context)_localctx).SIMBOLO!=null?((Inst_f2Context)_localctx).SIMBOLO.getText():null),(((Inst_f2Context)_localctx).SHIFT!=null?((Inst_f2Context)_localctx).SHIFT.getText():null)));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIMBOLO) {
					{
					setState(100);
					((Inst_f2Context)_localctx).SIMBOLO = match(SIMBOLO);
					}
				}

				setState(103);
				((Inst_f2Context)_localctx).SVC = match(SVC);
				setState(104);
				((Inst_f2Context)_localctx).NUMERO = match(NUMERO);
				listaInstrucciones.add(new Instruccion("INSF2",(((Inst_f2Context)_localctx).NUMERO!=null?((Inst_f2Context)_localctx).NUMERO.getText():null),(((Inst_f2Context)_localctx).SIMBOLO!=null?((Inst_f2Context)_localctx).SIMBOLO.getText():null),(((Inst_f2Context)_localctx).SVC!=null?((Inst_f2Context)_localctx).SVC.getText():null)));
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

	public static class Op_insf2Context extends ParserRuleContext {
		public String value;
		public Token REGISTRO;
		public Token X;
		public TerminalNode REGISTRO() { return getToken(sicstdParser.REGISTRO, 0); }
		public TerminalNode X() { return getToken(sicstdParser.X, 0); }
		public Op_insf2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_insf2; }
	}

	public final Op_insf2Context op_insf2() throws RecognitionException {
		Op_insf2Context _localctx = new Op_insf2Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_op_insf2);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REGISTRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((Op_insf2Context)_localctx).REGISTRO = match(REGISTRO);
				((Op_insf2Context)_localctx).value =  (((Op_insf2Context)_localctx).REGISTRO!=null?((Op_insf2Context)_localctx).REGISTRO.getText():null);
				}
				break;
			case X:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				((Op_insf2Context)_localctx).X = match(X);
				((Op_insf2Context)_localctx).value =  (((Op_insf2Context)_localctx).X!=null?((Op_insf2Context)_localctx).X.getText():null);
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

	public static class Inst_f3Context extends ParserRuleContext {
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public IndirectoContext indirecto() {
			return getRuleContext(IndirectoContext.class,0);
		}
		public InmediatoContext inmediato() {
			return getRuleContext(InmediatoContext.class,0);
		}
		public TerminalNode RSUB() { return getToken(sicstdParser.RSUB, 0); }
		public Inst_f3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst_f3; }
	}

	public final Inst_f3Context inst_f3() throws RecognitionException {
		Inst_f3Context _localctx = new Inst_f3Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_inst_f3);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				simple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				indirecto();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				inmediato();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(RSUB);

				        listaInstrucciones.add(new Instruccion("INSF3","","","RSUB"));
				    
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

	public static class Inst_f4Context extends ParserRuleContext {
		public Token SIMBOLO;
		public Token INSF3;
		public DireccionContext direccion;
		public TerminalNode MAS() { return getToken(sicstdParser.MAS, 0); }
		public TerminalNode INSF3() { return getToken(sicstdParser.INSF3, 0); }
		public DireccionContext direccion() {
			return getRuleContext(DireccionContext.class,0);
		}
		public TerminalNode COMA() { return getToken(sicstdParser.COMA, 0); }
		public TerminalNode X() { return getToken(sicstdParser.X, 0); }
		public TerminalNode ARROBA() { return getToken(sicstdParser.ARROBA, 0); }
		public TerminalNode SHARP() { return getToken(sicstdParser.SHARP, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public Inst_f4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst_f4; }
	}

	public final Inst_f4Context inst_f4() throws RecognitionException {
		Inst_f4Context _localctx = new Inst_f4Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_inst_f4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(121);
				((Inst_f4Context)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			setState(124);
			match(MAS);
			{
			setState(125);
			((Inst_f4Context)_localctx).INSF3 = match(INSF3);
			}
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(126);
				((Inst_f4Context)_localctx).direccion = direccion();

				            listaInstrucciones.add(new Instruccion("INSF4",(String)((Inst_f4Context)_localctx).direccion.value,(((Inst_f4Context)_localctx).SIMBOLO!=null?((Inst_f4Context)_localctx).SIMBOLO.getText():null),(((Inst_f4Context)_localctx).INSF3!=null?((Inst_f4Context)_localctx).INSF3.getText():null)));
				        
				}
				break;
			case 2:
				{
				setState(129);
				((Inst_f4Context)_localctx).direccion = direccion();
				setState(130);
				match(COMA);
				setState(131);
				match(X);

				            listaInstrucciones.add(new Instruccion("INSF4",(String)((Inst_f4Context)_localctx).direccion.value + ", X",(((Inst_f4Context)_localctx).SIMBOLO!=null?((Inst_f4Context)_localctx).SIMBOLO.getText():null),(((Inst_f4Context)_localctx).INSF3!=null?((Inst_f4Context)_localctx).INSF3.getText():null)));
				        
				}
				break;
			case 3:
				{
				setState(134);
				match(ARROBA);
				{
				setState(135);
				((Inst_f4Context)_localctx).direccion = direccion();
				}

				            listaInstrucciones.add(new Instruccion("INSF4",(String)((Inst_f4Context)_localctx).direccion.value,(((Inst_f4Context)_localctx).SIMBOLO!=null?((Inst_f4Context)_localctx).SIMBOLO.getText():null),(((Inst_f4Context)_localctx).INSF3!=null?((Inst_f4Context)_localctx).INSF3.getText():null)));
				        
				}
				break;
			case 4:
				{
				setState(138);
				match(SHARP);
				{
				setState(139);
				((Inst_f4Context)_localctx).direccion = direccion();
				}

				            listaInstrucciones.add(new Instruccion("INSF4",(String)((Inst_f4Context)_localctx).direccion.value,(((Inst_f4Context)_localctx).SIMBOLO!=null?((Inst_f4Context)_localctx).SIMBOLO.getText():null)));
				        
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

	public static class DirectivaContext extends ParserRuleContext {
		public Token SIMBOLO;
		public Token DIRECTIVA;
		public Token NUMERO;
		public Token HEXADECIMAL;
		public TerminalNode DIRECTIVA() { return getToken(sicstdParser.DIRECTIVA, 0); }
		public TerminalNode BYTE() { return getToken(sicstdParser.BYTE, 0); }
		public TerminalNode BASE() { return getToken(sicstdParser.BASE, 0); }
		public List<TerminalNode> SIMBOLO() { return getTokens(sicstdParser.SIMBOLO); }
		public TerminalNode SIMBOLO(int i) {
			return getToken(sicstdParser.SIMBOLO, i);
		}
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(sicstdParser.HEXADECIMAL, 0); }
		public TerminalNode C() { return getToken(sicstdParser.C, 0); }
		public List<TerminalNode> COMILLA() { return getTokens(sicstdParser.COMILLA); }
		public TerminalNode COMILLA(int i) {
			return getToken(sicstdParser.COMILLA, i);
		}
		public TerminalNode X() { return getToken(sicstdParser.X, 0); }
		public DirectivaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directiva; }
	}

	public final DirectivaContext directiva() throws RecognitionException {
		DirectivaContext _localctx = new DirectivaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_directiva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(144);
				((DirectivaContext)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIRECTIVA:
				{
				setState(147);
				((DirectivaContext)_localctx).DIRECTIVA = match(DIRECTIVA);
				setState(152);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NUMERO:
					{
					setState(148);
					((DirectivaContext)_localctx).NUMERO = match(NUMERO);
					listaInstrucciones.add(new Instruccion((((DirectivaContext)_localctx).DIRECTIVA!=null?((DirectivaContext)_localctx).DIRECTIVA.getText():null),(((DirectivaContext)_localctx).NUMERO!=null?((DirectivaContext)_localctx).NUMERO.getText():null),(((DirectivaContext)_localctx).SIMBOLO!=null?((DirectivaContext)_localctx).SIMBOLO.getText():null)));
					}
					break;
				case HEXADECIMAL:
					{
					setState(150);
					((DirectivaContext)_localctx).HEXADECIMAL = match(HEXADECIMAL);
					listaInstrucciones.add(new Instruccion((((DirectivaContext)_localctx).DIRECTIVA!=null?((DirectivaContext)_localctx).DIRECTIVA.getText():null),(((DirectivaContext)_localctx).HEXADECIMAL!=null?((DirectivaContext)_localctx).HEXADECIMAL.getText():null),(((DirectivaContext)_localctx).SIMBOLO!=null?((DirectivaContext)_localctx).SIMBOLO.getText():null)));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BYTE:
				{
				setState(154);
				match(BYTE);
				setState(165);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case C:
					{
					setState(155);
					match(C);
					setState(156);
					match(COMILLA);
					setState(157);
					((DirectivaContext)_localctx).SIMBOLO = match(SIMBOLO);
					setState(158);
					match(COMILLA);

					                listaInstrucciones.add(new Instruccion("BYTEC",(((DirectivaContext)_localctx).SIMBOLO!=null?((DirectivaContext)_localctx).SIMBOLO.getText():null),"C"));
					            
					}
					break;
				case X:
					{
					setState(160);
					match(X);
					setState(161);
					match(COMILLA);
					setState(162);
					((DirectivaContext)_localctx).HEXADECIMAL = match(HEXADECIMAL);
					setState(163);
					match(COMILLA);
					listaInstrucciones.add(new Instruccion("BYTEX",(((DirectivaContext)_localctx).HEXADECIMAL!=null?((DirectivaContext)_localctx).HEXADECIMAL.getText():null),"X"));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BASE:
				{
				setState(167);
				match(BASE);
				setState(168);
				((DirectivaContext)_localctx).SIMBOLO = match(SIMBOLO);
				listaInstrucciones.add(new Instruccion("BASE",(((DirectivaContext)_localctx).SIMBOLO!=null?((DirectivaContext)_localctx).SIMBOLO.getText():null)));
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

	public static class DireccionContext extends ParserRuleContext {
		public Object value;
		public Token HEXADECIMAL;
		public Token NUMERO;
		public Token SIMBOLO;
		public TerminalNode HEXADECIMAL() { return getToken(sicstdParser.HEXADECIMAL, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public DireccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direccion; }
	}

	public final DireccionContext direccion() throws RecognitionException {
		DireccionContext _localctx = new DireccionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_direccion);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HEXADECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				((DireccionContext)_localctx).HEXADECIMAL = match(HEXADECIMAL);
				((DireccionContext)_localctx).value =  (((DireccionContext)_localctx).HEXADECIMAL!=null?((DireccionContext)_localctx).HEXADECIMAL.getText():null);
				}
				break;
			case NUMERO:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				((DireccionContext)_localctx).NUMERO = match(NUMERO);
				((DireccionContext)_localctx).value =  (((DireccionContext)_localctx).NUMERO!=null?((DireccionContext)_localctx).NUMERO.getText():null);
				}
				break;
			case SIMBOLO:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				((DireccionContext)_localctx).SIMBOLO = match(SIMBOLO);
				((DireccionContext)_localctx).value =  (((DireccionContext)_localctx).SIMBOLO!=null?((DireccionContext)_localctx).SIMBOLO.getText():null);
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

	public static class SimpleContext extends ParserRuleContext {
		public Token SIMBOLO;
		public Token INSF3;
		public Token NUMERO;
		public DireccionContext direccion;
		public TerminalNode INSF3() { return getToken(sicstdParser.INSF3, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public DireccionContext direccion() {
			return getRuleContext(DireccionContext.class,0);
		}
		public TerminalNode COMA() { return getToken(sicstdParser.COMA, 0); }
		public TerminalNode X() { return getToken(sicstdParser.X, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public SimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple; }
	}

	public final SimpleContext simple() throws RecognitionException {
		SimpleContext _localctx = new SimpleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_simple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(180);
				((SimpleContext)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			setState(183);
			((SimpleContext)_localctx).INSF3 = match(INSF3);
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(184);
				((SimpleContext)_localctx).NUMERO = match(NUMERO);

				            Instruccion inst = new Instruccion("INSF3",(((SimpleContext)_localctx).NUMERO!=null?((SimpleContext)_localctx).NUMERO.getText():null),(((SimpleContext)_localctx).SIMBOLO!=null?((SimpleContext)_localctx).SIMBOLO.getText():null),(((SimpleContext)_localctx).INSF3!=null?((SimpleContext)_localctx).INSF3.getText():null));
				            inst.setTipo("simple");
				            inst.setConstante(true);
				            listaInstrucciones.add(inst);
				        
				}
				break;
			case 2:
				{
				setState(186);
				((SimpleContext)_localctx).direccion = direccion();

				            Instruccion inst = new Instruccion("INSF3",(String)((SimpleContext)_localctx).direccion.value,(((SimpleContext)_localctx).SIMBOLO!=null?((SimpleContext)_localctx).SIMBOLO.getText():null),(((SimpleContext)_localctx).INSF3!=null?((SimpleContext)_localctx).INSF3.getText():null));
				            inst.setTipo("simple");
				            listaInstrucciones.add(inst);
				        
				}
				break;
			case 3:
				{
				setState(194);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(189);
					((SimpleContext)_localctx).NUMERO = match(NUMERO);

					                Instruccion inst = new Instruccion("INSF3",(((SimpleContext)_localctx).NUMERO!=null?((SimpleContext)_localctx).NUMERO.getText():null) + ",X",(((SimpleContext)_localctx).SIMBOLO!=null?((SimpleContext)_localctx).SIMBOLO.getText():null),(((SimpleContext)_localctx).INSF3!=null?((SimpleContext)_localctx).INSF3.getText():null));
					                inst.setTipo("simple");
					                inst.setConstante(true);
					                listaInstrucciones.add(inst);
					            
					}
					break;
				case 2:
					{
					setState(191);
					((SimpleContext)_localctx).direccion = direccion();

					                Instruccion inst = new Instruccion("INSF3",(String)((SimpleContext)_localctx).direccion.value + ",X",(((SimpleContext)_localctx).SIMBOLO!=null?((SimpleContext)_localctx).SIMBOLO.getText():null),(((SimpleContext)_localctx).INSF3!=null?((SimpleContext)_localctx).INSF3.getText():null));
					                inst.setTipo("simple");
					                inst.setIndexado(true);
					                listaInstrucciones.add(inst);
					            
					}
					break;
				}
				setState(196);
				match(COMA);
				setState(197);
				match(X);
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

	public static class IndirectoContext extends ParserRuleContext {
		public Object value;
		public Token SIMBOLO;
		public Token INSF3;
		public Token NUMERO;
		public DireccionContext direccion;
		public TerminalNode INSF3() { return getToken(sicstdParser.INSF3, 0); }
		public TerminalNode ARROBA() { return getToken(sicstdParser.ARROBA, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public DireccionContext direccion() {
			return getRuleContext(DireccionContext.class,0);
		}
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public IndirectoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indirecto; }
	}

	public final IndirectoContext indirecto() throws RecognitionException {
		IndirectoContext _localctx = new IndirectoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_indirecto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(200);
				((IndirectoContext)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			setState(203);
			((IndirectoContext)_localctx).INSF3 = match(INSF3);
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(204);
				match(ARROBA);
				setState(205);
				((IndirectoContext)_localctx).NUMERO = match(NUMERO);

				            Instruccion inst = new Instruccion("INSF3",(((IndirectoContext)_localctx).NUMERO!=null?((IndirectoContext)_localctx).NUMERO.getText():null),(((IndirectoContext)_localctx).SIMBOLO!=null?((IndirectoContext)_localctx).SIMBOLO.getText():null),(((IndirectoContext)_localctx).INSF3!=null?((IndirectoContext)_localctx).INSF3.getText():null));
				            inst.setTipo("indirecto");
				            inst.setConstante(true);
				            listaInstrucciones.add(inst);
				}
				break;
			case 2:
				{
				setState(207);
				match(ARROBA);
				setState(208);
				((IndirectoContext)_localctx).direccion = direccion();

				            Instruccion inst = new Instruccion("INSF3",(String)((IndirectoContext)_localctx).direccion.value,(((IndirectoContext)_localctx).SIMBOLO!=null?((IndirectoContext)_localctx).SIMBOLO.getText():null),(((IndirectoContext)_localctx).INSF3!=null?((IndirectoContext)_localctx).INSF3.getText():null));
				            inst.setTipo("indirecto");
				            listaInstrucciones.add(inst);
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

	public static class InmediatoContext extends ParserRuleContext {
		public Object value;
		public Token SIMBOLO;
		public Token INSF3;
		public Token NUMERO;
		public DireccionContext direccion;
		public TerminalNode INSF3() { return getToken(sicstdParser.INSF3, 0); }
		public TerminalNode SHARP() { return getToken(sicstdParser.SHARP, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public DireccionContext direccion() {
			return getRuleContext(DireccionContext.class,0);
		}
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public InmediatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inmediato; }
	}

	public final InmediatoContext inmediato() throws RecognitionException {
		InmediatoContext _localctx = new InmediatoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_inmediato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIMBOLO) {
				{
				setState(213);
				((InmediatoContext)_localctx).SIMBOLO = match(SIMBOLO);
				}
			}

			setState(216);
			((InmediatoContext)_localctx).INSF3 = match(INSF3);
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(217);
				match(SHARP);
				setState(218);
				((InmediatoContext)_localctx).NUMERO = match(NUMERO);

				            Instruccion inst = new Instruccion("INSF3",(((InmediatoContext)_localctx).NUMERO!=null?((InmediatoContext)_localctx).NUMERO.getText():null),(((InmediatoContext)_localctx).SIMBOLO!=null?((InmediatoContext)_localctx).SIMBOLO.getText():null),(((InmediatoContext)_localctx).INSF3!=null?((InmediatoContext)_localctx).INSF3.getText():null));
				            inst.setTipo("inmediato");
				            inst.setConstante(true);
				            listaInstrucciones.add(inst);
				}
				break;
			case 2:
				{
				setState(220);
				match(SHARP);
				setState(221);
				((InmediatoContext)_localctx).direccion = direccion();

				            Instruccion inst = new Instruccion("INSF3",(String)((InmediatoContext)_localctx).direccion.value,(((InmediatoContext)_localctx).SIMBOLO!=null?((InmediatoContext)_localctx).SIMBOLO.getText():null),(((InmediatoContext)_localctx).INSF3!=null?((InmediatoContext)_localctx).INSF3.getText():null));
				            inst.setTipo("inmediato");
				            listaInstrucciones.add(inst);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u00e5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\7\2!\n\2\f\2\16\2$\13"+
		"\2\3\2\3\2\3\3\5\3)\n\3\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\3\3\3\3\3\4\3\4"+
		"\5\4\66\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5I\n\5\3\6\5\6L\n\6\3\6\3\6\3\6\3\7\5\7R\n\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7Z\n\7\3\7\3\7\3\7\3\7\5\7`\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7h\n\7\3\7\3\7\3\7\5\7m\n\7\3\b\3\b\3\b\3\b\5\bs\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\5\tz\n\t\3\n\5\n}\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0091\n\n\3\13\5\13\u0094\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u009b\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00a8\n\13\3\13\3\13\3\13\5\13\u00ad\n\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b5\n\f\3\r\5\r\u00b8\n\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c5\n\r\3\r\3\r\5\r\u00c9\n\r\3\16"+
		"\5\16\u00cc\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d6\n"+
		"\16\3\17\5\17\u00d9\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00e3\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\3\4\2\f"+
		"\f\17\17\2\u00fd\2\36\3\2\2\2\4(\3\2\2\2\6\63\3\2\2\2\bH\3\2\2\2\nK\3"+
		"\2\2\2\fl\3\2\2\2\16r\3\2\2\2\20y\3\2\2\2\22|\3\2\2\2\24\u0093\3\2\2\2"+
		"\26\u00b4\3\2\2\2\30\u00b7\3\2\2\2\32\u00cb\3\2\2\2\34\u00d8\3\2\2\2\36"+
		"\"\5\4\3\2\37!\5\b\5\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3"+
		"\2\2\2$\"\3\2\2\2%&\5\6\4\2&\3\3\2\2\2\')\7\33\2\2(\'\3\2\2\2()\3\2\2"+
		"\2)*\3\2\2\2*/\7\3\2\2+,\7\31\2\2,\60\b\3\1\2-.\7\32\2\2.\60\b\3\1\2/"+
		"+\3\2\2\2/-\3\2\2\2\60\61\3\2\2\2\61\62\7\27\2\2\62\5\3\2\2\2\63\65\7"+
		"\4\2\2\64\66\7\33\2\2\65\64\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\b"+
		"\4\1\28\7\3\2\2\29:\5\n\6\2:;\7\27\2\2;I\3\2\2\2<=\5\f\7\2=>\7\27\2\2"+
		">I\3\2\2\2?@\5\20\t\2@A\7\27\2\2AI\3\2\2\2BC\5\22\n\2CD\7\27\2\2DI\3\2"+
		"\2\2EF\5\24\13\2FG\7\27\2\2GI\3\2\2\2H9\3\2\2\2H<\3\2\2\2H?\3\2\2\2HB"+
		"\3\2\2\2HE\3\2\2\2I\t\3\2\2\2JL\7\33\2\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2"+
		"MN\7\21\2\2NO\b\6\1\2O\13\3\2\2\2PR\7\33\2\2QP\3\2\2\2QR\3\2\2\2RS\3\2"+
		"\2\2ST\7\22\2\2TU\t\2\2\2UV\7\5\2\2VW\t\2\2\2Wm\b\7\1\2XZ\7\33\2\2YX\3"+
		"\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\16\2\2\\]\t\2\2\2]m\b\7\1\2^`\7\33\2\2"+
		"_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\23\2\2bc\t\2\2\2cd\7\5\2\2de\7\31\2"+
		"\2em\b\7\1\2fh\7\33\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7\24\2\2jk\7\31"+
		"\2\2km\b\7\1\2lQ\3\2\2\2lY\3\2\2\2l_\3\2\2\2lg\3\2\2\2m\r\3\2\2\2no\7"+
		"\17\2\2os\b\b\1\2pq\7\f\2\2qs\b\b\1\2rn\3\2\2\2rp\3\2\2\2s\17\3\2\2\2"+
		"tz\5\30\r\2uz\5\32\16\2vz\5\34\17\2wx\7\26\2\2xz\b\t\1\2yt\3\2\2\2yu\3"+
		"\2\2\2yv\3\2\2\2yw\3\2\2\2z\21\3\2\2\2{}\7\33\2\2|{\3\2\2\2|}\3\2\2\2"+
		"}~\3\2\2\2~\177\7\t\2\2\177\u0090\7\25\2\2\u0080\u0081\5\26\f\2\u0081"+
		"\u0082\b\n\1\2\u0082\u0091\3\2\2\2\u0083\u0084\5\26\f\2\u0084\u0085\7"+
		"\5\2\2\u0085\u0086\7\f\2\2\u0086\u0087\b\n\1\2\u0087\u0091\3\2\2\2\u0088"+
		"\u0089\7\7\2\2\u0089\u008a\5\26\f\2\u008a\u008b\b\n\1\2\u008b\u0091\3"+
		"\2\2\2\u008c\u008d\7\6\2\2\u008d\u008e\5\26\f\2\u008e\u008f\b\n\1\2\u008f"+
		"\u0091\3\2\2\2\u0090\u0080\3\2\2\2\u0090\u0083\3\2\2\2\u0090\u0088\3\2"+
		"\2\2\u0090\u008c\3\2\2\2\u0091\23\3\2\2\2\u0092\u0094\7\33\2\2\u0093\u0092"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u00ac\3\2\2\2\u0095\u009a\7\20\2\2"+
		"\u0096\u0097\7\31\2\2\u0097\u009b\b\13\1\2\u0098\u0099\7\32\2\2\u0099"+
		"\u009b\b\13\1\2\u009a\u0096\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u00ad\3"+
		"\2\2\2\u009c\u00a7\7\n\2\2\u009d\u009e\7\r\2\2\u009e\u009f\7\30\2\2\u009f"+
		"\u00a0\7\33\2\2\u00a0\u00a1\7\30\2\2\u00a1\u00a8\b\13\1\2\u00a2\u00a3"+
		"\7\f\2\2\u00a3\u00a4\7\30\2\2\u00a4\u00a5\7\32\2\2\u00a5\u00a6\7\30\2"+
		"\2\u00a6\u00a8\b\13\1\2\u00a7\u009d\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a8"+
		"\u00ad\3\2\2\2\u00a9\u00aa\7\13\2\2\u00aa\u00ab\7\33\2\2\u00ab\u00ad\b"+
		"\13\1\2\u00ac\u0095\3\2\2\2\u00ac\u009c\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad"+
		"\25\3\2\2\2\u00ae\u00af\7\32\2\2\u00af\u00b5\b\f\1\2\u00b0\u00b1\7\31"+
		"\2\2\u00b1\u00b5\b\f\1\2\u00b2\u00b3\7\33\2\2\u00b3\u00b5\b\f\1\2\u00b4"+
		"\u00ae\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\27\3\2\2"+
		"\2\u00b6\u00b8\7\33\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00c8\7\25\2\2\u00ba\u00bb\7\31\2\2\u00bb\u00c9\b"+
		"\r\1\2\u00bc\u00bd\5\26\f\2\u00bd\u00be\b\r\1\2\u00be\u00c9\3\2\2\2\u00bf"+
		"\u00c0\7\31\2\2\u00c0\u00c5\b\r\1\2\u00c1\u00c2\5\26\f\2\u00c2\u00c3\b"+
		"\r\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\7\5\2\2\u00c7\u00c9\7\f\2\2\u00c8\u00ba\3\2"+
		"\2\2\u00c8\u00bc\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\31\3\2\2\2\u00ca\u00cc"+
		"\7\33\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2"+
		"\u00cd\u00d5\7\25\2\2\u00ce\u00cf\7\7\2\2\u00cf\u00d0\7\31\2\2\u00d0\u00d6"+
		"\b\16\1\2\u00d1\u00d2\7\7\2\2\u00d2\u00d3\5\26\f\2\u00d3\u00d4\b\16\1"+
		"\2\u00d4\u00d6\3\2\2\2\u00d5\u00ce\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d6\33"+
		"\3\2\2\2\u00d7\u00d9\7\33\2\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2"+
		"\u00d9\u00da\3\2\2\2\u00da\u00e2\7\25\2\2\u00db\u00dc\7\6\2\2\u00dc\u00dd"+
		"\7\31\2\2\u00dd\u00e3\b\17\1\2\u00de\u00df\7\6\2\2\u00df\u00e0\5\26\f"+
		"\2\u00e0\u00e1\b\17\1\2\u00e1\u00e3\3\2\2\2\u00e2\u00db\3\2\2\2\u00e2"+
		"\u00de\3\2\2\2\u00e3\35\3\2\2\2\35\"(/\65HKQY_glry|\u0090\u0093\u009a"+
		"\u00a7\u00ac\u00b4\u00b7\u00c4\u00c8\u00cb\u00d5\u00d8\u00e2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}