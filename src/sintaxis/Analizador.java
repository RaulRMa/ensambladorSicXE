package sintaxis;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

public class Analizador {
    private File archivoSalida;
    private ArrayList<String> listaErrores;
    private ArrayList<Integer> lineasErrores;
    private boolean hayErrores;
    private Map<Integer, Object> mapalineas;

    public Analizador(File archivo){
        try {
            listaErrores = new ArrayList<>();
            lineasErrores = new ArrayList<>();
            hayErrores = false;
            String nombre = archivo.getName().replace(".xe", ".err");
            archivoSalida = new File(nombre);
            inicia(archivo);
            if(hayErrores){
                escribeArchivo();
            }
            archivoSalida.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File obtenArchivoSalida() {
        return archivoSalida;
    }

    private void inicia(File archivo) throws IOException {
        ANTLRFileStream input = new ANTLRFileStream(archivo.getAbsolutePath());
        sicstdLexer lexer = new sicstdLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        sicstdParser parser = new sicstdParser(tokens);
        ANTLRErrorListener errorListener = errores();
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        parser.programa();
        mapalineas = parser.lineas;
    }
    public Map<Integer, Object> regresaMapa() {
        return mapalineas;
    }
    public ArrayList lineasErr (){return lineasErrores;}

    private ANTLRErrorListener errores() {
        return new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                String error = "Error en línea: " + i;
                if(!listaErrores.contains(error)){
                    listaErrores.add(error);
                    lineasErrores.add(i);
                }
                hayErrores = true;
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                //System.out.println("Hay ambigüedad");
            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
                //System.out.println("Algo del full context");
            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                //System.out.println("Algo del context sensitivity");
            }
        };
    }

    private void escribeArchivo() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(archivoSalida);
        for(String error : listaErrores){
            writer.println(error);
        }
        writer.close();
    }

    public boolean hayErrores(){
        return this.hayErrores;
    }
}
