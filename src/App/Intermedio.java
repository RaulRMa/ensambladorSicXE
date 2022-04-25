package App;

import sintaxis.Instruccion;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Intermedio {
    private  File aIntermedio;
    private LinkedHashMap<String, String> tabsim;
    private File aFuente, tabsimbolos;
    private final ArrayList<Instruccion> instrucciones;
    private final ArrayList<Integer> lineasErrores;
    public final ArrayList<String> lineasArchivo;
    private final ArrayList<String> tipoErrores;
    private final ArrayList<String> codigoObjeto;
    private int primerDir, ultimaDir;
    private String BASE;

    public Intermedio(ArrayList<Instruccion> mapa, File archivo, ArrayList<Integer> lineasErrores, ArrayList<String> errores){
        lineasArchivo = new ArrayList<>();
        codigoObjeto = new ArrayList<>();
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
                String[] elementos = linea.split("[\t]");
                if(elementos.length > 1){
                    if(elementos[1].trim().equals("END")) {
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
                            tabsim.put(instruccion.getSimbolo(),Integer.toHexString(cp));
                        }
                    }

                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----" ;
                    cp += instruccion.getBytes();
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
    private void generaCodigoObjeto(){
        int contInst = 1;
        codigoObjeto.add(lineasArchivo.get(0));
        for (int i = 1; i < lineasArchivo.size(); i++) {
            String instruccion = lineasArchivo.get(i);
            String[] arregloInst = instruccion.split("\t+");
            if(arregloInst[1].equals("END"))break;

            if(!instruccion.contains("Error: sintaxis")){

                String[] arreglo = lineasArchivo.get(i+1).split("\t");
                int cp = Integer.parseInt(arreglo[0],16);
                Instruccion inst = instrucciones.get(contInst++);
                String nuevaInst;
                String codobj;
                if(inst.getNombre().equals("BASE")) {
                    BASE = Integer.toHexString(Integer.parseInt(tabsim.get(inst.getDireccion()), 16));
                    codigoObjeto.add(instruccion);
                    continue;
                }
                if(instruccion.contains("Error: Símbolo duplicado")){
                    codobj = codigoObjeto(inst,cp);
                    nuevaInst = instruccion.replace("Error: Símbolo duplicado",codobj + "Error: Símbolo duplicado");
                }else{
                    codobj = codigoObjeto(inst,cp);
                    nuevaInst = instruccion.replace("----",codobj);
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
        return algo;
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
            int bytes = instruccion.getDireccion().contains("H") | instruccion.getDireccion().contains("h")
                    ?
                    Integer.parseInt(numero[0], 16)
                    :
                    Integer.parseInt(instruccion.getDireccion());
            int valor = 6 - numero[0].length();
            if(6 - valor != 0){
                String ceros = "";
                for(int i = 0; i < valor; i++) ceros += "0";
                return ceros +Integer.toHexString( bytes);
            }
            return Integer.toHexString(bytes);
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
            String hexadecimal = Integer.toHexString(bin);
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
        Pattern hexadecimal = Pattern.compile("^[A-F0-9]+^[H|h]*");
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
