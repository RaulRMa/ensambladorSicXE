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
    private ArrayList<String> listaErrores, tipoErrores;
    public ArrayList<Integer> lineasErrores;
    private ArrayList<Instruccion> instrucciones;
    private boolean hayErrores;
    private String entrada;
    private String nombreArchivo;

    public Analizador(File archivo){
        try {
            listaErrores = new ArrayList<>();
            lineasErrores = new ArrayList<>();
            instrucciones = new ArrayList<>();
            tipoErrores = new ArrayList<>();
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

    public Analizador(String cadena, String nombreArchivo){
        try {
            listaErrores = new ArrayList<>();
            lineasErrores = new ArrayList<>();
            instrucciones = new ArrayList<>();
            tipoErrores = new ArrayList<>();
            hayErrores = false;
            String nombre = nombreArchivo.replace(".xe", ".err");
            archivoSalida = new File(nombre);
            this.entrada = cadena;
            analisis(entrada);
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

    private void analisis(String cadena){
        ANTLRInputStream input = new ANTLRInputStream(cadena);
        sicstdLexer lexer = new sicstdLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        sicstdParser parser = new sicstdParser(tokens);
        ANTLRErrorListener errorListener = errores();
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        parser.programa();
        instrucciones = parser.listaInstrucciones;
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
        instrucciones = parser.listaInstrucciones;
    }
    public ArrayList<Integer> lineasErr (){return lineasErrores;}
    public ArrayList<Instruccion> listaInstrucciones(){return  instrucciones;}
    public ArrayList<String> getTipoErrores(){return tipoErrores;}

    private ANTLRErrorListener errores() {
        return new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                if(s.contains("no viable alternative at input")){
                    tipoErrores.add("Error: Símbolo no encontrado");
                }else tipoErrores.add("Error: sintaxis");
                String error = "Error en línea: " + i + " " + s;
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
