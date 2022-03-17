// Generated from /home/raulr/Documentos/UASLP/Software de sistemas/laboratorio/ensambladorSicXE/grammar/sicstd.g4 by ANTLR 4.9.2

    package sintaxis;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link sicstdParser}.
 */
public interface sicstdListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link sicstdParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(sicstdParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(sicstdParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(sicstdParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(sicstdParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(sicstdParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(sicstdParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(sicstdParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(sicstdParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#inst_f1}.
	 * @param ctx the parse tree
	 */
	void enterInst_f1(sicstdParser.Inst_f1Context ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#inst_f1}.
	 * @param ctx the parse tree
	 */
	void exitInst_f1(sicstdParser.Inst_f1Context ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#inst_f2}.
	 * @param ctx the parse tree
	 */
	void enterInst_f2(sicstdParser.Inst_f2Context ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#inst_f2}.
	 * @param ctx the parse tree
	 */
	void exitInst_f2(sicstdParser.Inst_f2Context ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#op_insf2}.
	 * @param ctx the parse tree
	 */
	void enterOp_insf2(sicstdParser.Op_insf2Context ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#op_insf2}.
	 * @param ctx the parse tree
	 */
	void exitOp_insf2(sicstdParser.Op_insf2Context ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#inst_f3}.
	 * @param ctx the parse tree
	 */
	void enterInst_f3(sicstdParser.Inst_f3Context ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#inst_f3}.
	 * @param ctx the parse tree
	 */
	void exitInst_f3(sicstdParser.Inst_f3Context ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#inst_f4}.
	 * @param ctx the parse tree
	 */
	void enterInst_f4(sicstdParser.Inst_f4Context ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#inst_f4}.
	 * @param ctx the parse tree
	 */
	void exitInst_f4(sicstdParser.Inst_f4Context ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#directiva}.
	 * @param ctx the parse tree
	 */
	void enterDirectiva(sicstdParser.DirectivaContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#directiva}.
	 * @param ctx the parse tree
	 */
	void exitDirectiva(sicstdParser.DirectivaContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#direccion}.
	 * @param ctx the parse tree
	 */
	void enterDireccion(sicstdParser.DireccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#direccion}.
	 * @param ctx the parse tree
	 */
	void exitDireccion(sicstdParser.DireccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#simple}.
	 * @param ctx the parse tree
	 */
	void enterSimple(sicstdParser.SimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#simple}.
	 * @param ctx the parse tree
	 */
	void exitSimple(sicstdParser.SimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#indirecto}.
	 * @param ctx the parse tree
	 */
	void enterIndirecto(sicstdParser.IndirectoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#indirecto}.
	 * @param ctx the parse tree
	 */
	void exitIndirecto(sicstdParser.IndirectoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sicstdParser#inmediato}.
	 * @param ctx the parse tree
	 */
	void enterInmediato(sicstdParser.InmediatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sicstdParser#inmediato}.
	 * @param ctx the parse tree
	 */
	void exitInmediato(sicstdParser.InmediatoContext ctx);
}