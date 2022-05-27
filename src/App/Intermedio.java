package App;

import Evaluador.evaluadorLexer;
import Evaluador.evaluadorParser;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import sintaxis.Instruccion;
import sintaxis.Simbolo;
import sintaxis.sicstdLexer;
import sintaxis.sicstdParser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Intermedio {
    private  File aIntermedio;
    public LinkedHashMap<String, String> tabsim;
    private File aFuente, tabsimbolos;
    private final ArrayList<Instruccion> instrucciones;
    private final ArrayList<Integer> lineasErrores;
    public final ArrayList<String> lineasArchivo;
    private final ArrayList<String> tipoErrores;
    private final ArrayList<String> codigoObjeto;
    public ArrayList<Simbolo> tablaSimbolos;
    private int primerDir, ultimaDir;
    private String BASE;
    private ArrayList<String> nombresSimbolos;

    public Intermedio(ArrayList<Instruccion> mapa, File archivo, ArrayList<Integer> lineasErrores, ArrayList<String> errores){
        lineasArchivo = new ArrayList<>();
        codigoObjeto = new ArrayList<>();
        tablaSimbolos = new ArrayList<>();
        nombresSimbolos = new ArrayList<>();
        String nombre = archivo.getName().replace(".xe", ".int");
        aFuente = archivo;
        this.instrucciones = mapa;
        this.lineasErrores = lineasErrores;
        this.tipoErrores = errores;
        aIntermedio = new File(nombre);
        primerDir = ultimaDir = 0;
        generaTabla();
        escribeArchivo();
        escribeTabsim();
        escribeRegistros();
    }

    private void generaTabla(){
        tabsim = new LinkedHashMap<>();
        String linea;
        Scanner sc;
        String lineaAEscribir;
        int cp = 0x0;
        int contador = 1;
        int contInst = 1;
        int contErrores = 0;
        boolean error = false;
        try {
            sc = new Scanner(aFuente);
            cp += instrucciones.get(0).getBytes();
            while (sc.hasNext()){
                linea = sc.nextLine();
                linea = linea.replaceAll("[\t\n\s]+","\t");
                String[] elementos = linea.split("[\t\r\s]+");
                if(elementos.length > 1){
                    if(elementos[1].trim().equals("END") || elementos[0].trim().equals("END")) {
                        lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
                        lineasArchivo.add(lineaAEscribir);
                        ultimaDir = cp;
                        break;
                    }
                }else{
                    if(elementos[0].trim().equals("END")) {
                        lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
                        lineasArchivo.add(lineaAEscribir);
                        ultimaDir = cp;
                        break;
                    }
                }
                if(elementos.length > 1){
                    if (elementos[1].trim().equals("START")) {
                        lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
                        lineasArchivo.add(lineaAEscribir);
                        contador++;
                        primerDir = cp;
                        continue;
                    }
                }else{
                    if (elementos[0].trim().equals("START")) {
                        lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
                        lineasArchivo.add(lineaAEscribir);
                        contador++;
                        primerDir = cp;
                        continue;
                    }
                }
                if(!lineasErrores.contains(contador)){
                    boolean bandera = false;
                    Instruccion instruccion = instrucciones.get(contInst++);
                    if( instruccion.getSimbolo() != null && !instruccion.getSimbolo().isBlank()){
                        if(tabsim.containsKey(instruccion.getSimbolo()) && error){
                            int ultimo = lineasArchivo.size() -1;
                            String ultimaInst = lineasArchivo.get(ultimo).replace("----","Error: Símbolo duplicado");
                            lineasArchivo.remove(ultimo);
                            lineasArchivo.add(ultimaInst);
                            error = false;
                        }else if(tabsim.containsKey(instruccion.getSimbolo()) && !error){
                            lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\tError: Símbolo duplicado";
                            cp += instruccion.getBytes();
                            contador++;
                            lineasArchivo.add(lineaAEscribir);
                            continue;
                        }
                        else{
                            Simbolo simbolo = new Simbolo(instruccion.getSimbolo());
                                if(!instruccion.simboloObj.equ){
                                    simbolo.relativo = true;
                                    simbolo.dirOSimbolo = Integer.toHexString(cp);
                                }else {
                                    if(instruccion.getDireccion().equals("*")){
                                        simbolo.relativo = true;
                                        simbolo.dirOSimbolo = Integer.toHexString(cp);
                                    }else if(instruccion.isExpresion()){
                                        if(esExpresionValida(instruccion.getDireccion())){
                                            String res = agrupaSimbolos(instruccion.getDireccion(),instruccion);
                                            int valor = evaluaValor(instruccion,res);
                                            simbolo.relativo = instruccion.simboloObj.relativo;
                                            simbolo.dirOSimbolo = Integer.toHexString(valor).toUpperCase();
                                        }else{
                                            lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\tError: expresión inválida";
                                            lineasArchivo.add(lineaAEscribir);
                                            simbolo.dirOSimbolo = "FFFF";
                                            nombresSimbolos.add(simbolo.nombre);
                                            tablaSimbolos.add(simbolo);
                                            tabsim.put(instruccion.getSimbolo(),"FFFF");
                                            contador++;
                                            continue;
                                        }
                                    }else{
                                        if(instruccion.getDireccion().matches("[0-9A-F]+[Hh]")){
                                            String valor = instruccion.getDireccion().split("[Hh]")[0];
                                            simbolo.dirOSimbolo = valor;
                                        }else {
                                            simbolo.dirOSimbolo = Integer.toHexString(Integer.parseInt(instruccion.getDireccion())).toUpperCase();
                                        }
                                        simbolo.relativo = false;
                                    }
                                }
                            nombresSimbolos.add(simbolo.nombre);
                            tablaSimbolos.add(simbolo);
                            tabsim.put(instruccion.getSimbolo(),Integer.toHexString(cp));
                        }
                    }
                    int bytes = instruccion.getBytes();
                    if(instruccion.getNombre().equals("ORG")){
                        if(instruccion.getDireccion().matches("[0-9A-F]+[Hh]")){
                            String valor = instruccion.getDireccion().split("[Hh]")[0];
                            bytes = Integer.parseInt(valor,16);
                        }else {
                            bytes = Integer.parseInt(instruccion.getDireccion());
                        }
                        cp = bytes;
                        lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----" ;
                        lineasArchivo.add(lineaAEscribir);
                        contador++;
                        continue;
                    }
                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----" ;
                    cp += bytes;
                    contador++;
                }else{
                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t" + tipoErrores.get(contErrores++);
                    contador++;
                    error = true;
                }
                lineasArchivo.add(lineaAEscribir);
            }
            sc.close();

            generaCodigoObjeto();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String agrupaSimbolos(String expresion, Instruccion inst){
        String[] simbolos = expresion.split("[-*/+()0-9]+");
        String expresionAux = expresion;
        ArrayList<String> tiposTerminos = new ArrayList<>();
        if(simbolos.length > 1 && !(simbolos.length == 2 && simbolos[0].isEmpty()) ){
            for(String simbolo : simbolos){
                if(!simbolo.isEmpty())
                    expresionAux = expresionAux.replace(simbolo, " ");
            }
            int abs = 0;
            int rels = 0;
            for(String simbolo : simbolos){
                for(Simbolo simb : tablaSimbolos){
                    if(simbolo.equals(simb.nombre)){
                        if(simb.relativo) rels++;
                        else abs++;
                        if(rels >= 2) {
                            abs+=2;
                            rels -=2;
                        }
                        expresionAux = expresionAux.replaceFirst(" ",String.valueOf(Integer.parseInt(simb.dirOSimbolo,16)));
                    }
                }
            }
            if(rels > 0 && rels %2 == 1 && abs > 0 && abs % 2 == 0)
                inst.simboloObj.relativo = true;
            else if(rels == 0 && abs > 0 && abs % 2 == 0)
                inst.simboloObj.relativo = false;
            return expresionAux;
        }
        Simbolo simbolo = null;
        int indx = simbolos[0].isEmpty() ? 1 : 0;
        for(Simbolo simb : tablaSimbolos){
            if(simb.nombre.equals(simbolos[indx])){
                simbolo = simb;
                break;
            }
        }
        if(simbolo != null){
            expresionAux = expresionAux.replace(simbolos[indx],String.valueOf(Integer.parseInt(simbolo.dirOSimbolo,16)));
            inst.simboloObj.relativo = simbolo.relativo;
            return expresionAux;
        }
        return "Error: símbolo no existe";
    }

    private String simbolosAgrupados(String[]simbolos, String[] elementos, String expresion, int cont, int indx ){
        boolean bandera = false;
        boolean bandera2 = false;
        Simbolo simb1 = null;
        Simbolo simb2 = null;
        String simbolo1 = "+";
        String simbolo2 = "+";
        for(int i = indx; i < elementos.length; i++){
            String elemento = elementos[i];
            if(elemento.matches("[-+]") && !bandera){
                simbolo1 = elemento;
                bandera = true;
            }
            else if (elemento.equals(" ") && !bandera2){
                for(String simbolo : simbolos){
                    for(Simbolo simboloObj : tablaSimbolos){
                        if( !simbolos[cont].isEmpty() && simboloObj.nombre.equals(simbolos[cont])){
                            simb1 = simboloObj;
                            bandera2 = true;
                            bandera = true;
                            break;
                        }
                    }
                    cont++;
                    if(bandera2) break;
                }
            }
            else if( elemento.matches("[-+]") && bandera){
                simbolo2 = elemento;
            }
            else if(elemento.equals(" ") && bandera2){
                boolean band = false;
                for(String simbolo : simbolos){
                    for(Simbolo simboloObj : tablaSimbolos){
                        if( !simbolos[cont].isEmpty() && simboloObj.nombre.equals(simbolos[cont])){
                            simb2 = simboloObj;
                            band = true;
                            break;
                        }
                    }
                    if(band) break;
                    cont++;
                }
                if(!simbolo1.equals(simbolo2)){
                    int operacion = 0;
                    //expresion.replaceFirst(" ", simb1.dirOSimbolo);
                    String resultado = "";
                    if(simbolo1.equals("+") && simbolo2.equals("-")){
                        operacion = Integer.parseInt(simb1.dirOSimbolo,16) - Integer.parseInt(simb2.dirOSimbolo,16);
                        resultado = expresion.replaceAll(" - ",String.valueOf(operacion));
                    }

                    return resultado;
                }
                return "Error";
            }

        }
        return "Error";
    }

    private boolean esExpresionValida(String expresion) {
        String[] simbolos = expresion.split("[\\p{Punct}\\p{Digit}\t\n\s\r]+");
        for (String simbolo : simbolos){
            if(!simbolo.isEmpty() && !nombresSimbolos.contains(simbolo)) return false;
        }
        return true;
    }
    private void generaCodigoObjeto(){
        int contInst = 1;
        codigoObjeto.add(lineasArchivo.get(0));
        for (int i = 1; i < lineasArchivo.size(); i++) {
            String instruccion = lineasArchivo.get(i);
            String[] arregloInst = instruccion.split("[\t\r\s]+");
            if(arregloInst[1].equals("END"))break;

            if(!instruccion.contains("Error: sintaxis")){

                String[] arreglo = lineasArchivo.get(i+1).split("[\t\n\s]+");
                int cp = Integer.parseInt(arreglo[0],16);
                Instruccion inst = instrucciones.get(contInst++);
                String nuevaInst;
                String codobj;
                if(inst.getNombre().equals("BASE")) {
                    BASE = Integer.toHexString(Integer.parseInt(tabsim.get(inst.getDireccion()), 16));
                    codigoObjeto.add(instruccion);
                    continue;
                }
                if(inst.simboloObj.equ || inst.simboloObj.nombre.equals("ORG")) {
                    codigoObjeto.add(instruccion);
                    continue;
                }
                if(inst.isExpresion()){

                    String res = agrupaSimbolos(inst.getDireccion(),inst);
                    if(inst.getNombre().equals("WORD") && inst.simboloObj.relativo)
                        inst.setRelocalizable(true);
                    int operacion = 0;
                    if(!res.equals("Error")){
                        operacion = evaluaValor(inst,res);
                        if(operacion < 0) inst.setDireccion(String.valueOf(operacion));
                        else inst.setDireccion(Integer.toHexString(operacion).toUpperCase() + "H");

                        if(inst.simboloObj.relativo){
                            inst.setConstante(false);
                        }else{
                            inst.setConstante(true);
                        }
                        codobj = codigoObjeto(inst,cp);
                        nuevaInst = instruccion.replace("----",codobj.toUpperCase());
                    }else {
                        nuevaInst = instruccion.replace("Error: Símbolo duplicado","Error: Expresión inválida");
                    }
                }
                else if(instruccion.contains("Error: Símbolo duplicado")){
                    codobj = codigoObjeto(inst,cp);
                    nuevaInst = instruccion.replace("Error: Símbolo duplicado",codobj.toUpperCase() + "Error: Símbolo duplicado");
                }else{
                    codobj = codigoObjeto(inst,cp);
                    nuevaInst = instruccion.replace("----",codobj.toUpperCase());
                }
                lineasArchivo.remove(i);
                lineasArchivo.add(i,nuevaInst);
                codigoObjeto.add(nuevaInst);
            }
        }
        codigoObjeto.add(lineasArchivo.get(lineasArchivo.size() - 1));
    }

    private void escribeArchivo(){
        try {
            PrintWriter writer = new PrintWriter(aIntermedio);
            for(String linea : lineasArchivo){
                writer.println(linea);
            }
            writer.close();
            aIntermedio.createNewFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo escribir archivo intermedio en disco");
            e.printStackTrace();
        }

    }
    private void escribeTabsim(){
        String nombre = aFuente.getName().replace(".xe", ".tabsim");
        tabsimbolos = new File(nombre);
        try {
            String encabezado = "Símbolo\t" + "\tDirección\n";
            PrintWriter wr = new PrintWriter(tabsimbolos);
            wr.write(encabezado);
            Iterator it = tabsim.keySet().iterator();
            String linea;
            while (it.hasNext()){
                String key = (String) it.next();
                linea = key + "\t\t" + tabsim.get(key);
                wr.println(linea);
            }
            wr.close();
            tabsimbolos.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void escribeRegistros(){
        String[] arregloRegistros = new String[]{"A","X","L","B","S","T","F","CP ó PC","SW"};
        try {
            FileReader descripciones = new FileReader("descripciones.txt");
            Scanner sc = new Scanner(descripciones);
            String nombre = aFuente.getName().replace(".xe",".registros");
            File registros = new File(nombre);
            PrintWriter wr = new PrintWriter(registros);
            int contador = 0;
            String linea;
            for(String registro : arregloRegistros){
                if(contador == 7) contador = 8;
                linea = registro + "\t" + contador + "\t" + sc.nextLine();
                wr.println(linea);
                contador++;
            }
            wr.println("\nTamaño del programa: " + Integer.toHexString((ultimaDir - primerDir)));
            wr.close();
            sc.close();
            registros.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int evaluaValor(Instruccion inst, String cadena ){
        ANTLRInputStream input = new ANTLRInputStream(cadena);
        sicstdLexer lexer = new sicstdLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        sicstdParser parser = new sicstdParser(tokens);
        Object resultado = parser.expresion_ar().value;

        return evalua(inst, cadena);
        //return (int)resultado;
    }

    private int evalua(Instruccion inst, String caddena){
        ANTLRInputStream input = new ANTLRInputStream(caddena);
        evaluadorLexer lexer = new evaluadorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        evaluadorParser parser = new evaluadorParser(tokens);
        Object resultado = parser.expresion().value;
        return (int) resultado;
    }

    public File archivoIntermedio() {return  aIntermedio;}
    private String codigoObjeto(Instruccion instruccion, int cp){
        String algo = "";
        if(instruccion.isDirectiva()){
            return codopDirectiva(instruccion);
        }
        switch (instruccion.getNombre()){
            case "INSF4":
            case "INSF3":
                if(instruccion.getInstruccion().equals("RSUB")) return "4F0000";
                return codopInstF3(instruccion,cp);
            case "INSF2":
                return codopInstF2(instruccion);
            case "INSF1":
                return Integer.toHexString(instruccion.getCodigoOp());
        }
        return "------";
    }

    private String codopDirectiva(Instruccion instruccion){
        Pattern patronDirectivas = Pattern.compile("WORD|BYTE");
        Matcher matcher = patronDirectivas.matcher(instruccion.getNombre());
        if(matcher.find()){
            if(instruccion.getNombre().contains("BYTE") ){
                if( instruccion.getNombre().contains("C")) {
                    char[] caracteres = instruccion.getDireccion().toCharArray();
                    StringBuilder asciiCaracteres = new StringBuilder();
                    for (char caracter : caracteres) {
                        asciiCaracteres.append(Integer.toHexString(caracter));
                    }
                    return String.valueOf(asciiCaracteres);
                }
                int tamano = instruccion.getDireccion().length();
                if(tamano %2 == 0) return instruccion.getDireccion();
                return "0"+ instruccion.getDireccion();
            }
            String[] numero = instruccion.getDireccion().split("[h|H]");
            int bytes = instruccion.getDireccion().matches("[A-F0-9]+[H|h]?")
                    ?
                    Integer.parseInt(numero[0], 16)
                    :
                    Integer.parseInt(instruccion.getDireccion());
            String asterisco = instruccion.isRelocalizable() ? "*" : "";
            if(bytes > 0){
                int valor = 6 - numero[0].length();
                if (6 - valor != 0) {
                    String ceros = "";
                    for (int i = 0; i < valor; i++) ceros += "0";
                    return ceros + Integer.toHexString(bytes) + asterisco;
                }
            }else{
                String hexadecimal = Integer.toHexString(bytes);
                return hexadecimal.substring(2,hexadecimal.length()).toUpperCase() + asterisco;
            }
            return Integer.toHexString(bytes) + asterisco;
        }
        return "\t----";
    }
    private String codopInstF2(Instruccion inst){
        String[] registros = inst.getDireccion().split(",");
        String codopInst = Integer.toHexString(inst.getCodigoOp());
        String r1 = valorRegistro(registros[0]);
        String r2 = "0";
        if(registros.length > 1)
         r2 = valorRegistro(registros[1]);
        return codopInst + r1 + r2;
    }
    private String valorRegistro(String registro){
        return switch (registro) {
            case "A" -> "0";
            case "X" -> "1";
            case "L" -> "2";
            case "B" -> "3";
            case "S" -> "4";
            case "T" -> "5";
            case "F" -> "6";
            default -> "-1";
        };
    }
    private String codopInstF3(Instruccion instruccion,int cp){
        switch (instruccion.getTipo()){
            case "simple":
                return calculaSimple(instruccion,cp);
            case "inmediato":
            case "indirecto": return calculaIndirecto(instruccion,cp);
        }
        return "";
    }
    private String calculaSimple(Instruccion inst, int cp){
        String operando = obtenOperando(inst.getDireccion());
        String[] codigo = inst.getCodigoOp2().split("");
        String n,i,x,b,p,e;
        n = i = "1";
        x = inst.isIndexado() ? "1" : "0";
        e = inst.isF4() ? "1" : "0";
        String op = getByteBinario(codigo[0],codigo[1]);
        if(operando.contains("H") || operando.contains("h")){
            operando = operando.split("[H|h]")[0];
            int decimal = Integer.parseInt(operando,16);
            if(decimal < 4096) inst.setConstante(true);
        }
        if(operando.equals("Error: Símbolo no encontrado")){
            b = p = "1";
            String[] banderas = new String[]{n,i,x,b,p,e};
            String binario = op;
            for(int j = 0; j < banderas.length; j++) binario += banderas[j];
            int bin = Integer.parseInt(binario,2);
            String hexadecimal = Integer.toHexString(bin).toUpperCase();
            return  anexaCeros(3,hexadecimal)+ (inst.isF4() ? "FFFFF " : "FFF ") + operando;
        }
        if(inst.isConstante()){
            b = p = "0";
            String[] banderas = new String[]{n,i,x,b,p,e};
            return valorFinal(op,banderas,operando,3);
        }
        if(inst.isF4() && inst.isIndexado()){
            x = e = "1";
            b = p = "0";
            String dir = inst.getDireccion();
            if(operando.contains("H") || operando.contains("h")){
                dir = inst.getDireccion().split("[H|h]")[0];
                dir = anexaCeros(4,dir);
            }
            int binario = Integer.parseInt((op+ n+i+x+b+p+e),2);
            return Integer.toHexString(binario).toUpperCase() + dir;
        }
        x = inst.isIndexado() ? "1" : "0";
        e = inst.isF4() ? "1" : "0";
        String despCont = relativoAContador(inst,cp);
        if(!despCont.equals("\0")) {
            b = "0"; p = "1";
            int codigoBanderas = Integer.parseInt((op + n + i + x + b + p + e),2);
            return Integer.toHexString(codigoBanderas)+despCont;
        }
        String despBase = "\0";
        if(this.BASE != null) despBase = relativoABase(inst);
        if(!despBase.equals("\0")) {
            b = "1"; p = "0";
            return Integer.toHexString(Integer.parseInt((op + n + i + x + b + p + e),2)) + despBase;
        }
        String desp = inst.getNombre().equals("INSF3")
                ? "FFF" : "FFFFF";
        b = p = "1";
        String resultado = Integer.toHexString(Integer.parseInt((op + n+i+x+b+p+e),2));
        return resultado + desp + " Error: no relativo al contador o a la base";
    }
    private String calculaIndirecto(Instruccion inst, int cp){
        String operando = obtenOperando(inst.getDireccion());
        String[] codigo = inst.getCodigoOp2().split("");
        String n,i,x,b,p,e;
        if(inst.getTipo().equals("indirecto")) {
            n = "1";i = "0";
        }
        else {
            n = "0";i = "1";
        }
        if(operando.matches("^[A-F0-9]+^[H|h]*")){
            operando = operando.split("[H|h]")[0];
            int decimal = Integer.parseInt(operando,16);
            if(decimal < 4096) inst.setConstante(true);
        }
        String bytes = getByteBinario(codigo[0],codigo[1]);
        x = inst.isIndexado() ? "1" : "0"; e = inst.isF4() ? "1" : "0";
        b = "0"; p = "0";
        String[] banderas = new String[]{n,i,x,b,p,e};
        if(operando.equals("Error: Símbolo no encontrado")){
            banderas[3] = banderas [ 4] = "1";
            int formato = inst.isF4() ? 4 : 3;
            String binario = bytes;
            for(int j = 0; j < banderas.length; j++) binario += banderas[j];
            int bin = Integer.parseInt(binario,2);
            String hexadecimal = Integer.toHexString(bin);
            return anexaCeros(3,hexadecimal) + (formato == 4 ? "FFFFF " : "FFF ") + operando;
        }
        if(inst.isF4() && !inst.isConstante()){
            inst.setF4(true);
            return valorFinal(bytes,banderas,operando,4) + "*";
        }
        if(inst.isConstante()){
            return valorFinal(bytes,banderas,operando,3);
        }
        if(inst.isF4()){
            return valorFinal(bytes,banderas,operando,4);
        }
        String dirCont = relativoAContador(inst,cp);
        if(dirCont.contains("Error")){
            banderas[3] = "1"; banderas[4] = "1";
            String acumulador = "";
            for (String bandera : banderas) acumulador += bandera;
            int binario = Integer.parseInt((bytes + acumulador),2);
            return Integer.toHexString(binario).toUpperCase() + "FFF   " + dirCont;
        }else if(dirCont.contains("constante")){
            int formato = inst.isF4() ? 4 : 3;
            return valorFinal(bytes,banderas,operando,formato);
        }
        if(!dirCont.equals("\0")){
            b = "0"; p= "1";
            int binario = Integer.parseInt((bytes + n+i+x+b+p+e),2);
            String hexadecimal = Integer.toHexString(binario);
            return anexaCeros(3,hexadecimal) + dirCont;
        }
        String dirBase = relativoABase(inst);
        if(!dirBase.equals("\0")){
            b = "1"; p = "0";
            int binario = Integer.parseInt((bytes +n+i+x+b+p+e));
            String hexadecimal = Integer.toHexString(binario);
            return  anexaCeros(3,hexadecimal)+ dirBase;
        }
        return "";
    }
    private String obtenOperando(String operando){
        String op = operando.split(",")[0];
        Pattern hexadecimal = Pattern.compile("^[A-F0-9]+[H|h]");
        Pattern simbolo = Pattern.compile("^[a-zA-Z0-9]+");
        Pattern constante = Pattern.compile("^[0-9]+");
        Matcher match = constante.matcher(op);
        if(match.find()) return op;
        match = hexadecimal.matcher(op);
        if(match.find()) return op.split("[H|h]")[0];
        match = simbolo.matcher(op);
        if(match.find()){
            if(tabsim.containsKey(op)){
                return tabsim.get(op);
            }
            return "Error: Símbolo no encontrado";
        }
        return "";
    }
    private String valorFinal(String codigoInst,String[] banderas, String operando, int formato){
        String valorBinario = "";
        StringBuilder acumulador = new StringBuilder();
        for (String bandera : banderas) valorBinario += bandera;
        int decimal = Integer.parseInt(codigoInst + valorBinario,2);
        acumulador.append(Integer.toHexString(decimal));
        String codOperando = anexaCeros(formato,operando);
        String valorBytes = anexaCeros(3, String.valueOf(acumulador));
        return valorBytes + codOperando;
    }
    private String relativoAContador(Instruccion inst, int cp){
        String[] operadores = inst.getDireccion().split(",");
        String simbolo = operadores[0];
        String dirSimbolo = tabsim.get(simbolo);
        try{
            if((simbolo.contains("H") || simbolo.contains("h")) && dirSimbolo == null){
                dirSimbolo = simbolo.split("[H|h]")[0];
            }
            int TA = Integer.parseInt(dirSimbolo,16);
            //if(!(TA > 4096)) return "constante";
            if(TA - cp < -2408 || TA - cp > 2047) return "\0";
            String result = Integer.toHexString(TA- cp);
            if(TA - cp < 1){
                int caracterFinal = result.length();
                result = inst.isF4()
                        ? result.substring(caracterFinal-4,caracterFinal)
                        : result.substring(caracterFinal-3,caracterFinal);
            }
            if(inst.getNombre().equals("INSF3")){
                return anexaCeros(3,result);
            }
            return anexaCeros(4,result);
        }catch (Exception e){
            return " Error: símbolo no existe en tabsim";
        }
    }
    private String relativoABase(Instruccion inst){
        String[] operadores = inst.getDireccion().split(",");
        String simbolo = operadores[0];
        String dirSimbolo = tabsim.get(simbolo);
        try {
            if(simbolo.contains("H") || simbolo.contains("h")){
                dirSimbolo = simbolo.split("[H|h]")[0];
            }
            int TA = Integer.parseInt(dirSimbolo,16);
            int base = Integer.parseInt(this.BASE,16);
            if(TA - base < 0 || TA - base > 4095) return "\0";
            String result = Integer.toHexString(TA- base);
            if(inst.getNombre().equals("INSF3")){
                return anexaCeros(3,result);
            }
            return anexaCeros(4,result);
        }catch (Exception e){
            return " Error: símbolo no existe en tabsim";
        }
    }
    private String anexaCeros(int formato, String cadena){
        String cerosInsf3 = "000";
        String cerosInsf4 = "00000";
        if(formato == 3){
            return cerosInsf3.substring(0,3 - cadena.length()) + cadena;
        }
        return cerosInsf4.substring(0,5 - cadena.length()) + cadena;
    }
    private String getByteBinario(String numero1, String numero2){
        int decimal1 = Integer.parseInt(numero1,16);
        int decimal2 = Integer.parseInt(numero2,16);
        String binario = Integer.toBinaryString(decimal1);
        String binario2 = Integer.toBinaryString(decimal2);
        binario = binario.length() == 4 ?
                binario : "0000".substring(0,4 - binario.length()) + binario;
        binario2 = binario2.length() == 4 ?
                binario2 : "0000".substring(0,4 - binario2.length()) + binario2;
        return binario + binario2.substring(0,2);
    }
    public File tablaSimbolos(){return tabsimbolos;}
    public ArrayList<String> getCodigoObjeto() {
        return codigoObjeto;
    }
}
