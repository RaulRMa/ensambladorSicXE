// Generated from /home/raul/Documentos/UASLP/2021-2022-2/SoftwareDeSistemas/Laboratorio/analizador/grammar/sicstd.g4 by ANTLR 4.9.2

    package sintaxis;

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
		T__0=1, T__1=2, INSTRUCCION=3, DIRECTIVA=4, REGISTRO=5, EB=6, BASE=7, 
		BYTE=8, START=9, END=10, COMA=11, SHARP=12, ARROBA=13, MAS=14, COMILLA=15, 
		X=16, SIMBOLO=17, FIN_INSTRUCCION=18, NUMERO=19, HEXADECIMAL=20, TEXTO=21, 
		VALOR_HEXADECIMAL=22;
	public static final int
		RULE_programa = 0, RULE_dec_start = 1, RULE_dec_end = 2, RULE_dec_instruccion = 3, 
		RULE_dec_directiva = 4, RULE_cod_op = 5, RULE_f1 = 6, RULE_f2 = 7, RULE_f3_4 = 8, 
		RULE_dir_memoria = 9, RULE_f_simple = 10, RULE_f_indirecto = 11, RULE_f_inmediato = 12, 
		RULE_valor_o_numero = 13, RULE_dec_byte = 14, RULE_dec_base = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "dec_start", "dec_end", "dec_instruccion", "dec_directiva", 
			"cod_op", "f1", "f2", "f3_4", "dir_memoria", "f_simple", "f_indirecto", 
			"f_inmediato", "valor_o_numero", "dec_byte", "dec_base"
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

	@Override
	public String getGrammarFileName() { return "sicstd.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public sicstdParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public Dec_startContext dec_start() {
			return getRuleContext(Dec_startContext.class,0);
		}
		public Dec_endContext dec_end() {
			return getRuleContext(Dec_endContext.class,0);
		}
		public List<Dec_instruccionContext> dec_instruccion() {
			return getRuleContexts(Dec_instruccionContext.class);
		}
		public Dec_instruccionContext dec_instruccion(int i) {
			return getRuleContext(Dec_instruccionContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			dec_start();
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					dec_instruccion();
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(39);
			dec_end();
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

	public static class Dec_startContext extends ParserRuleContext {
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public List<TerminalNode> EB() { return getTokens(sicstdParser.EB); }
		public TerminalNode EB(int i) {
			return getToken(sicstdParser.EB, i);
		}
		public TerminalNode START() { return getToken(sicstdParser.START, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(sicstdParser.HEXADECIMAL, 0); }
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public Dec_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_start; }
	}

	public final Dec_startContext dec_start() throws RecognitionException {
		Dec_startContext _localctx = new Dec_startContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec_start);
		int _la;
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIMBOLO:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(SIMBOLO);
				setState(42);
				match(EB);
				setState(43);
				match(START);
				setState(44);
				match(EB);
				setState(45);
				match(HEXADECIMAL);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(46);
					match(EB);
					}
				}

				setState(49);
				match(FIN_INSTRUCCION);
				}
				break;
			case EB:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(EB);
				setState(51);
				match(START);
				setState(52);
				match(EB);
				setState(53);
				match(HEXADECIMAL);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(54);
					match(EB);
					}
				}

				setState(57);
				match(FIN_INSTRUCCION);
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

	public static class Dec_endContext extends ParserRuleContext {
		public List<TerminalNode> EB() { return getTokens(sicstdParser.EB); }
		public TerminalNode EB(int i) {
			return getToken(sicstdParser.EB, i);
		}
		public TerminalNode END() { return getToken(sicstdParser.END, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public Dec_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_end; }
	}

	public final Dec_endContext dec_end() throws RecognitionException {
		Dec_endContext _localctx = new Dec_endContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec_end);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(EB);
				setState(61);
				match(END);
				setState(62);
				match(EB);
				setState(63);
				match(SIMBOLO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(EB);
				setState(65);
				match(END);
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

	public static class Dec_instruccionContext extends ParserRuleContext {
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public List<TerminalNode> EB() { return getTokens(sicstdParser.EB); }
		public TerminalNode EB(int i) {
			return getToken(sicstdParser.EB, i);
		}
		public TerminalNode INSTRUCCION() { return getToken(sicstdParser.INSTRUCCION, 0); }
		public Cod_opContext cod_op() {
			return getRuleContext(Cod_opContext.class,0);
		}
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public TerminalNode MAS() { return getToken(sicstdParser.MAS, 0); }
		public F1Context f1() {
			return getRuleContext(F1Context.class,0);
		}
		public Dec_directivaContext dec_directiva() {
			return getRuleContext(Dec_directivaContext.class,0);
		}
		public Dec_instruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_instruccion; }
	}

	public final Dec_instruccionContext dec_instruccion() throws RecognitionException {
		Dec_instruccionContext _localctx = new Dec_instruccionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dec_instruccion);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(SIMBOLO);
				setState(69);
				match(EB);
				setState(70);
				match(INSTRUCCION);
				setState(71);
				match(EB);
				setState(72);
				cod_op();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(73);
					match(EB);
					}
				}

				setState(76);
				match(FIN_INSTRUCCION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(EB);
				setState(79);
				match(INSTRUCCION);
				setState(80);
				match(EB);
				setState(81);
				cod_op();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(82);
					match(EB);
					}
				}

				setState(85);
				match(FIN_INSTRUCCION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(SIMBOLO);
				setState(88);
				match(EB);
				setState(89);
				match(MAS);
				setState(90);
				match(INSTRUCCION);
				setState(91);
				match(EB);
				setState(92);
				cod_op();
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(93);
					match(EB);
					}
				}

				setState(96);
				match(FIN_INSTRUCCION);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				match(EB);
				setState(99);
				match(MAS);
				setState(100);
				match(INSTRUCCION);
				setState(101);
				match(EB);
				setState(102);
				cod_op();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(103);
					match(EB);
					}
				}

				setState(106);
				match(FIN_INSTRUCCION);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				f1();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				dec_directiva();
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

	public static class Dec_directivaContext extends ParserRuleContext {
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public List<TerminalNode> EB() { return getTokens(sicstdParser.EB); }
		public TerminalNode EB(int i) {
			return getToken(sicstdParser.EB, i);
		}
		public TerminalNode DIRECTIVA() { return getToken(sicstdParser.DIRECTIVA, 0); }
		public Valor_o_numeroContext valor_o_numero() {
			return getRuleContext(Valor_o_numeroContext.class,0);
		}
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public Dec_byteContext dec_byte() {
			return getRuleContext(Dec_byteContext.class,0);
		}
		public Dec_baseContext dec_base() {
			return getRuleContext(Dec_baseContext.class,0);
		}
		public Dec_directivaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_directiva; }
	}

	public final Dec_directivaContext dec_directiva() throws RecognitionException {
		Dec_directivaContext _localctx = new Dec_directivaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dec_directiva);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(SIMBOLO);
				setState(113);
				match(EB);
				setState(114);
				match(DIRECTIVA);
				setState(115);
				match(EB);
				setState(116);
				valor_o_numero();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(117);
					match(EB);
					}
				}

				setState(120);
				match(FIN_INSTRUCCION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(EB);
				setState(123);
				match(DIRECTIVA);
				setState(124);
				match(EB);
				setState(125);
				valor_o_numero();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(126);
					match(EB);
					}
				}

				setState(129);
				match(FIN_INSTRUCCION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				dec_byte();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				dec_base();
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

	public static class Cod_opContext extends ParserRuleContext {
		public F2Context f2() {
			return getRuleContext(F2Context.class,0);
		}
		public F3_4Context f3_4() {
			return getRuleContext(F3_4Context.class,0);
		}
		public Cod_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cod_op; }
	}

	public final Cod_opContext cod_op() throws RecognitionException {
		Cod_opContext _localctx = new Cod_opContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cod_op);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				f2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				f3_4();
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

	public static class F1Context extends ParserRuleContext {
		public List<TerminalNode> EB() { return getTokens(sicstdParser.EB); }
		public TerminalNode EB(int i) {
			return getToken(sicstdParser.EB, i);
		}
		public TerminalNode INSTRUCCION() { return getToken(sicstdParser.INSTRUCCION, 0); }
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public F1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f1; }
	}

	public final F1Context f1() throws RecognitionException {
		F1Context _localctx = new F1Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_f1);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EB:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(EB);
				setState(140);
				match(INSTRUCCION);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(141);
					match(EB);
					}
				}

				setState(144);
				match(FIN_INSTRUCCION);
				}
				break;
			case SIMBOLO:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(SIMBOLO);
				setState(146);
				match(EB);
				setState(147);
				match(INSTRUCCION);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EB) {
					{
					setState(148);
					match(EB);
					}
				}

				setState(151);
				match(FIN_INSTRUCCION);
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

	public static class F2Context extends ParserRuleContext {
		public List<TerminalNode> REGISTRO() { return getTokens(sicstdParser.REGISTRO); }
		public TerminalNode REGISTRO(int i) {
			return getToken(sicstdParser.REGISTRO, i);
		}
		public TerminalNode COMA() { return getToken(sicstdParser.COMA, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public F2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f2; }
	}

	public final F2Context f2() throws RecognitionException {
		F2Context _localctx = new F2Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_f2);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(REGISTRO);
				setState(155);
				match(COMA);
				setState(156);
				match(REGISTRO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(REGISTRO);
				setState(158);
				match(COMA);
				setState(159);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(REGISTRO);
				setState(161);
				match(COMA);
				setState(162);
				match(NUMERO);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				match(SIMBOLO);
				setState(164);
				match(COMA);
				setState(165);
				match(REGISTRO);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				match(REGISTRO);
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

	public static class F3_4Context extends ParserRuleContext {
		public F_simpleContext f_simple() {
			return getRuleContext(F_simpleContext.class,0);
		}
		public F_indirectoContext f_indirecto() {
			return getRuleContext(F_indirectoContext.class,0);
		}
		public F_inmediatoContext f_inmediato() {
			return getRuleContext(F_inmediatoContext.class,0);
		}
		public F3_4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f3_4; }
	}

	public final F3_4Context f3_4() throws RecognitionException {
		F3_4Context _localctx = new F3_4Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_f3_4);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIMBOLO:
			case NUMERO:
			case HEXADECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				f_simple();
				}
				break;
			case ARROBA:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				f_indirecto();
				}
				break;
			case SHARP:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				f_inmediato();
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

	public static class Dir_memoriaContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(sicstdParser.HEXADECIMAL, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public Dir_memoriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dir_memoria; }
	}

	public final Dir_memoriaContext dir_memoria() throws RecognitionException {
		Dir_memoriaContext _localctx = new Dir_memoriaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dir_memoria);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIMBOLO) | (1L << NUMERO) | (1L << HEXADECIMAL))) != 0)) ) {
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

	public static class F_simpleContext extends ParserRuleContext {
		public Dir_memoriaContext dir_memoria() {
			return getRuleContext(Dir_memoriaContext.class,0);
		}
		public TerminalNode COMA() { return getToken(sicstdParser.COMA, 0); }
		public TerminalNode REGISTRO() { return getToken(sicstdParser.REGISTRO, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public F_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_simple; }
	}

	public final F_simpleContext f_simple() throws RecognitionException {
		F_simpleContext _localctx = new F_simpleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_f_simple);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				dir_memoria();
				setState(177);
				match(COMA);
				setState(178);
				match(REGISTRO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				dir_memoria();
				setState(181);
				match(COMA);
				{
				setState(182);
				match(T__0);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(NUMERO);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				dir_memoria();
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

	public static class F_indirectoContext extends ParserRuleContext {
		public TerminalNode ARROBA() { return getToken(sicstdParser.ARROBA, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public Dir_memoriaContext dir_memoria() {
			return getRuleContext(Dir_memoriaContext.class,0);
		}
		public F_indirectoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_indirecto; }
	}

	public final F_indirectoContext f_indirecto() throws RecognitionException {
		F_indirectoContext _localctx = new F_indirectoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_f_indirecto);
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(ARROBA);
				setState(189);
				match(NUMERO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(ARROBA);
				setState(191);
				dir_memoria();
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

	public static class F_inmediatoContext extends ParserRuleContext {
		public TerminalNode SHARP() { return getToken(sicstdParser.SHARP, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public Dir_memoriaContext dir_memoria() {
			return getRuleContext(Dir_memoriaContext.class,0);
		}
		public F_inmediatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_inmediato; }
	}

	public final F_inmediatoContext f_inmediato() throws RecognitionException {
		F_inmediatoContext _localctx = new F_inmediatoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_f_inmediato);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(SHARP);
				setState(195);
				match(NUMERO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(SHARP);
				setState(197);
				dir_memoria();
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

	public static class Valor_o_numeroContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(sicstdParser.HEXADECIMAL, 0); }
		public Valor_o_numeroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_o_numero; }
	}

	public final Valor_o_numeroContext valor_o_numero() throws RecognitionException {
		Valor_o_numeroContext _localctx = new Valor_o_numeroContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_valor_o_numero);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !(_la==NUMERO || _la==HEXADECIMAL) ) {
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

	public static class Dec_byteContext extends ParserRuleContext {
		public List<TerminalNode> SIMBOLO() { return getTokens(sicstdParser.SIMBOLO); }
		public TerminalNode SIMBOLO(int i) {
			return getToken(sicstdParser.SIMBOLO, i);
		}
		public List<TerminalNode> EB() { return getTokens(sicstdParser.EB); }
		public TerminalNode EB(int i) {
			return getToken(sicstdParser.EB, i);
		}
		public TerminalNode BYTE() { return getToken(sicstdParser.BYTE, 0); }
		public List<TerminalNode> COMILLA() { return getTokens(sicstdParser.COMILLA); }
		public TerminalNode COMILLA(int i) {
			return getToken(sicstdParser.COMILLA, i);
		}
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public TerminalNode VALOR_HEXADECIMAL() { return getToken(sicstdParser.VALOR_HEXADECIMAL, 0); }
		public TerminalNode NUMERO() { return getToken(sicstdParser.NUMERO, 0); }
		public Dec_byteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_byte; }
	}

	public final Dec_byteContext dec_byte() throws RecognitionException {
		Dec_byteContext _localctx = new Dec_byteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dec_byte);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(SIMBOLO);
				setState(203);
				match(EB);
				setState(204);
				match(BYTE);
				setState(205);
				match(EB);
				setState(206);
				match(T__0);
				setState(207);
				match(COMILLA);
				setState(208);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==VALOR_HEXADECIMAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(209);
				match(COMILLA);
				setState(210);
				match(FIN_INSTRUCCION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(EB);
				setState(212);
				match(BYTE);
				setState(213);
				match(EB);
				setState(214);
				match(T__0);
				setState(215);
				match(COMILLA);
				setState(216);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==VALOR_HEXADECIMAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
				match(COMILLA);
				setState(218);
				match(FIN_INSTRUCCION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(SIMBOLO);
				setState(220);
				match(EB);
				setState(221);
				match(BYTE);
				setState(222);
				match(EB);
				setState(223);
				match(T__1);
				setState(224);
				match(COMILLA);
				setState(225);
				_la = _input.LA(1);
				if ( !(_la==SIMBOLO || _la==NUMERO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(226);
				match(COMILLA);
				setState(227);
				match(FIN_INSTRUCCION);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				match(EB);
				setState(229);
				match(BYTE);
				setState(230);
				match(EB);
				setState(231);
				match(T__1);
				setState(232);
				match(COMILLA);
				setState(233);
				_la = _input.LA(1);
				if ( !(_la==SIMBOLO || _la==NUMERO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(234);
				match(COMILLA);
				setState(235);
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

	public static class Dec_baseContext extends ParserRuleContext {
		public List<TerminalNode> EB() { return getTokens(sicstdParser.EB); }
		public TerminalNode EB(int i) {
			return getToken(sicstdParser.EB, i);
		}
		public TerminalNode BASE() { return getToken(sicstdParser.BASE, 0); }
		public TerminalNode SIMBOLO() { return getToken(sicstdParser.SIMBOLO, 0); }
		public TerminalNode FIN_INSTRUCCION() { return getToken(sicstdParser.FIN_INSTRUCCION, 0); }
		public Dec_baseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_base; }
	}

	public final Dec_baseContext dec_base() throws RecognitionException {
		Dec_baseContext _localctx = new Dec_baseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dec_base);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(EB);
			setState(239);
			match(BASE);
			setState(240);
			match(EB);
			setState(241);
			match(SIMBOLO);
			setState(242);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00f7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\5\3=\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4E\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5V\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5a\n\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5k\n\5\3\5\3\5\3\5\3\5\5\5q\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6y\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0082\n\6\3\6\3\6\3\6\3\6"+
		"\5\6\u0088\n\6\3\7\3\7\5\7\u008c\n\7\3\b\3\b\3\b\5\b\u0091\n\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u0098\n\b\3\b\5\b\u009b\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00aa\n\t\3\n\3\n\3\n\5\n\u00af\n\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00bd\n\f\3\r\3\r\3"+
		"\r\3\r\5\r\u00c3\n\r\3\16\3\16\3\16\3\16\5\16\u00c9\n\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00ef\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\6\4\2\23\23\25"+
		"\26\3\2\25\26\4\2\25\25\30\30\4\2\23\23\25\25\2\u010b\2\"\3\2\2\2\4<\3"+
		"\2\2\2\6D\3\2\2\2\bp\3\2\2\2\n\u0087\3\2\2\2\f\u008b\3\2\2\2\16\u009a"+
		"\3\2\2\2\20\u00a9\3\2\2\2\22\u00ae\3\2\2\2\24\u00b0\3\2\2\2\26\u00bc\3"+
		"\2\2\2\30\u00c2\3\2\2\2\32\u00c8\3\2\2\2\34\u00ca\3\2\2\2\36\u00ee\3\2"+
		"\2\2 \u00f0\3\2\2\2\"&\5\4\3\2#%\5\b\5\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2"+
		"&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\5\6\4\2*\3\3\2\2\2+,\7\23\2\2,-\7\b"+
		"\2\2-.\7\13\2\2./\7\b\2\2/\61\7\26\2\2\60\62\7\b\2\2\61\60\3\2\2\2\61"+
		"\62\3\2\2\2\62\63\3\2\2\2\63=\7\24\2\2\64\65\7\b\2\2\65\66\7\13\2\2\66"+
		"\67\7\b\2\2\679\7\26\2\28:\7\b\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;=\7\24"+
		"\2\2<+\3\2\2\2<\64\3\2\2\2=\5\3\2\2\2>?\7\b\2\2?@\7\f\2\2@A\7\b\2\2AE"+
		"\7\23\2\2BC\7\b\2\2CE\7\f\2\2D>\3\2\2\2DB\3\2\2\2E\7\3\2\2\2FG\7\23\2"+
		"\2GH\7\b\2\2HI\7\5\2\2IJ\7\b\2\2JL\5\f\7\2KM\7\b\2\2LK\3\2\2\2LM\3\2\2"+
		"\2MN\3\2\2\2NO\7\24\2\2Oq\3\2\2\2PQ\7\b\2\2QR\7\5\2\2RS\7\b\2\2SU\5\f"+
		"\7\2TV\7\b\2\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\24\2\2Xq\3\2\2\2YZ\7"+
		"\23\2\2Z[\7\b\2\2[\\\7\20\2\2\\]\7\5\2\2]^\7\b\2\2^`\5\f\7\2_a\7\b\2\2"+
		"`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\24\2\2cq\3\2\2\2de\7\b\2\2ef\7\20\2"+
		"\2fg\7\5\2\2gh\7\b\2\2hj\5\f\7\2ik\7\b\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2"+
		"\2lm\7\24\2\2mq\3\2\2\2nq\5\16\b\2oq\5\n\6\2pF\3\2\2\2pP\3\2\2\2pY\3\2"+
		"\2\2pd\3\2\2\2pn\3\2\2\2po\3\2\2\2q\t\3\2\2\2rs\7\23\2\2st\7\b\2\2tu\7"+
		"\6\2\2uv\7\b\2\2vx\5\34\17\2wy\7\b\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z"+
		"{\7\24\2\2{\u0088\3\2\2\2|}\7\b\2\2}~\7\6\2\2~\177\7\b\2\2\177\u0081\5"+
		"\34\17\2\u0080\u0082\7\b\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\7\24\2\2\u0084\u0088\3\2\2\2\u0085\u0088\5"+
		"\36\20\2\u0086\u0088\5 \21\2\u0087r\3\2\2\2\u0087|\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0086\3\2\2\2\u0088\13\3\2\2\2\u0089\u008c\5\20\t\2\u008a"+
		"\u008c\5\22\n\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\r\3\2\2"+
		"\2\u008d\u008e\7\b\2\2\u008e\u0090\7\5\2\2\u008f\u0091\7\b\2\2\u0090\u008f"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u009b\7\24\2\2"+
		"\u0093\u0094\7\23\2\2\u0094\u0095\7\b\2\2\u0095\u0097\7\5\2\2\u0096\u0098"+
		"\7\b\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009b\7\24\2\2\u009a\u008d\3\2\2\2\u009a\u0093\3\2\2\2\u009b\17\3\2\2"+
		"\2\u009c\u009d\7\7\2\2\u009d\u009e\7\r\2\2\u009e\u00aa\7\7\2\2\u009f\u00a0"+
		"\7\7\2\2\u00a0\u00a1\7\r\2\2\u00a1\u00aa\7\3\2\2\u00a2\u00a3\7\7\2\2\u00a3"+
		"\u00a4\7\r\2\2\u00a4\u00aa\7\25\2\2\u00a5\u00a6\7\23\2\2\u00a6\u00a7\7"+
		"\r\2\2\u00a7\u00aa\7\7\2\2\u00a8\u00aa\7\7\2\2\u00a9\u009c\3\2\2\2\u00a9"+
		"\u009f\3\2\2\2\u00a9\u00a2\3\2\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a8\3\2"+
		"\2\2\u00aa\21\3\2\2\2\u00ab\u00af\5\26\f\2\u00ac\u00af\5\30\r\2\u00ad"+
		"\u00af\5\32\16\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3"+
		"\2\2\2\u00af\23\3\2\2\2\u00b0\u00b1\t\2\2\2\u00b1\25\3\2\2\2\u00b2\u00b3"+
		"\5\24\13\2\u00b3\u00b4\7\r\2\2\u00b4\u00b5\7\7\2\2\u00b5\u00bd\3\2\2\2"+
		"\u00b6\u00b7\5\24\13\2\u00b7\u00b8\7\r\2\2\u00b8\u00b9\7\3\2\2\u00b9\u00bd"+
		"\3\2\2\2\u00ba\u00bd\7\25\2\2\u00bb\u00bd\5\24\13\2\u00bc\u00b2\3\2\2"+
		"\2\u00bc\u00b6\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\27"+
		"\3\2\2\2\u00be\u00bf\7\17\2\2\u00bf\u00c3\7\25\2\2\u00c0\u00c1\7\17\2"+
		"\2\u00c1\u00c3\5\24\13\2\u00c2\u00be\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\31\3\2\2\2\u00c4\u00c5\7\16\2\2\u00c5\u00c9\7\25\2\2\u00c6\u00c7\7\16"+
		"\2\2\u00c7\u00c9\5\24\13\2\u00c8\u00c4\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\33\3\2\2\2\u00ca\u00cb\t\3\2\2\u00cb\35\3\2\2\2\u00cc\u00cd\7\23\2\2"+
		"\u00cd\u00ce\7\b\2\2\u00ce\u00cf\7\n\2\2\u00cf\u00d0\7\b\2\2\u00d0\u00d1"+
		"\7\3\2\2\u00d1\u00d2\7\21\2\2\u00d2\u00d3\t\4\2\2\u00d3\u00d4\7\21\2\2"+
		"\u00d4\u00ef\7\24\2\2\u00d5\u00d6\7\b\2\2\u00d6\u00d7\7\n\2\2\u00d7\u00d8"+
		"\7\b\2\2\u00d8\u00d9\7\3\2\2\u00d9\u00da\7\21\2\2\u00da\u00db\t\4\2\2"+
		"\u00db\u00dc\7\21\2\2\u00dc\u00ef\7\24\2\2\u00dd\u00de\7\23\2\2\u00de"+
		"\u00df\7\b\2\2\u00df\u00e0\7\n\2\2\u00e0\u00e1\7\b\2\2\u00e1\u00e2\7\4"+
		"\2\2\u00e2\u00e3\7\21\2\2\u00e3\u00e4\t\5\2\2\u00e4\u00e5\7\21\2\2\u00e5"+
		"\u00ef\7\24\2\2\u00e6\u00e7\7\b\2\2\u00e7\u00e8\7\n\2\2\u00e8\u00e9\7"+
		"\b\2\2\u00e9\u00ea\7\4\2\2\u00ea\u00eb\7\21\2\2\u00eb\u00ec\t\5\2\2\u00ec"+
		"\u00ed\7\21\2\2\u00ed\u00ef\7\24\2\2\u00ee\u00cc\3\2\2\2\u00ee\u00d5\3"+
		"\2\2\2\u00ee\u00dd\3\2\2\2\u00ee\u00e6\3\2\2\2\u00ef\37\3\2\2\2\u00f0"+
		"\u00f1\7\b\2\2\u00f1\u00f2\7\t\2\2\u00f2\u00f3\7\b\2\2\u00f3\u00f4\7\23"+
		"\2\2\u00f4\u00f5\7\24\2\2\u00f5!\3\2\2\2\31&\619<DLU`jpx\u0081\u0087\u008b"+
		"\u0090\u0097\u009a\u00a9\u00ae\u00bc\u00c2\u00c8\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}