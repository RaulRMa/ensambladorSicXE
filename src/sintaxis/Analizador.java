package sintaxis;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;

public class Analizador {
    private File archivoSalida;
    private ArrayList<String> listaErrores;
    private boolean hayErrores;

    public Analizador(File archivo){
        try {
            listaErrores = new ArrayList<>();
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
    }

    private ANTLRErrorListener errores() throws FileNotFoundException {
        return new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                String error = "Error en línea: " + i;
                listaErrores.add(error);
                hayErrores = true;
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                System.out.println("Hay ambigüedad");
            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
                System.out.println("Algo del full context");
            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                System.out.println("Algo del context sensitivity");
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
