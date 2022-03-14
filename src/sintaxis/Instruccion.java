package sintaxis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruccion {
    private final String nombre;
    private final String direccion;
    private String simbolo;
    private int bytes;
    private int codigoOp;
    private String codigoOp2;
    private String instruccion;
    private boolean relocalizable, directiva, indexado, constante;
    private String tipo;

    public Instruccion(String nombre, String direccion, String simbolo){
        indexado = constante = relocalizable = directiva = false;
        this.nombre = nombre;
        this.direccion = direccion;
        this.simbolo = simbolo;
        calculaBytes(nombre,direccion);
    }
    public Instruccion(String nombre, String direccion, String simbolo, String instruccion){
        indexado = constante = relocalizable = directiva = false;
        this.instruccion = instruccion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.simbolo = simbolo;
        calculaBytes(nombre,direccion);
    }
    public Instruccion(String nombre, String direccion){
        indexado = constante = relocalizable = directiva = false;
        this.nombre = nombre;
        this.direccion = direccion;
        calculaBytes(nombre, direccion);
    }

    private void calculaBytes(String nombre, String direccion){
        switch (tipoInstruccion(nombre)){
            case "Start":
                bytes = bytesStart(direccion);
                break;
            case "SIC":

                bytes = bytesInstruccion(nombre);
                break;
            case "DIRECTIVA":
                directiva = true;
                bytes = bytesDirectiva(nombre,direccion);
                break;
            case "Byte":
                directiva = true;
                bytes = bytesByte(nombre,direccion);
                break;
        }
    }

    private String tipoInstruccion(Object key){
        Pattern patronFormato = Pattern.compile("F1|F2|F3|F4");
        Pattern patronDirectivas = Pattern.compile("WORD|RESB|RESW");
        Matcher matcher;
        matcher = patronFormato.matcher(key.toString());
        if(matcher.find()) return "SIC";
        matcher = patronDirectivas.matcher(key.toString());
        if(matcher.find()) return  "DIRECTIVA";
        if(key.toString().contains("BYTE")) return "Byte";
        if(key.toString().contains("Base")) return "Base";
        if(key.toString().contains("Start")) return "Start";
        return "End";
    }

    private int bytesInstruccion(String tipo){
        if(tipo.contains("F1")) {
            codigoOp = codOpF1().get(this.instruccion);
            return 1;
        }
        if(tipo.contains("F2")) {
            codigoOp = codOpF2().get(this.instruccion);
            return 2;
        }
        if(tipo.contains("F3")) {
            codigoOp2 = codOp3o4().get(this.instruccion);
            return 3;
        }
        codigoOp2 = codOp3o4().get(this.instruccion);
        return 4;
    }
    private int bytesStart(String direccion){
        if(direccion.contains("H") | direccion.contains("H")){
            String[] cadenas = direccion.split("[H|h]+");
            return Integer.parseInt(cadenas[0],16);
        }
        return Integer.parseInt(direccion);
    }
    private int bytesDirectiva(Object key, String direccion){
        int bytes = 0;
        if(key.toString().contains("WORD")){
            bytes = 3;
        }else {
            String[] numero = direccion.split("[h|H]");
            int bytes1 = direccion.contains("H") | direccion.contains("h")
                    ?
                    Integer.parseInt(numero[0], 16)
                    :
                    Integer.parseInt(direccion);
            if(key.toString().contains("RESB")){
                bytes = bytes1;
            }
            else{
                bytes = bytes1;
                bytes *= 3;
            }
        }
        return bytes;
    }


    private int bytesByte(Object key, String direccion){
        String total;
        if(key.toString().contains("C")){
            total = String.valueOf(direccion.length());
            return Integer.parseInt(total,16);
        }
        int longitud = direccion.length();
        if(longitud % 2 == 0) {
            total = String.valueOf(longitud/2);
            return Integer.parseInt(total,16);
        }
        total = String.valueOf((longitud+1)/2);
        return Integer.parseInt(total);
    }

    private Map<String, Integer> codOpF1(){
        return Map.of(
                "FIX",0xC4, "FLOAT",0xC0,"HIO",0xF4,
                "NORM",0xC8,"SIO",0xF0,"TIO",0xF8
        );
    }

    private Map<String, Integer> codOpF2(){
        Map<String, Integer> codopsF2 = new HashMap<>(Map.of(
                "ADDR", 0x90, "CLEAR", 0XB4, "COMPR", 0XA0,
                "DIVR", 0X9C, "MULR", 0X98, "RMO", 0XAC,
                "SHIFTL", 0XA4, "SHIFTR", 0XA8, "SUBR", 0X94,
                "SVC", 0XB0
        ));
        codopsF2.put("TIXR",0XB8);
        return codopsF2;
    }

    private Map<String, String>codOp3o4(){
        Map<String, String> codops = new HashMap<>();
        try {
            FileReader fr = new FileReader("CODIGOSF3.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNext()){
                String clave = sc.next();
                String valor = sc.next();
                codops.put(clave,valor);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InputMismatchException e){
            System.out.println("No se vale eso we");
        }
        return codops;
    }


    public String getNombre() {
        return nombre;
    }

    public int getBytes() {
        return bytes;
    }
    public String getSimbolo() {
        return simbolo;
    }


    public int getCodigoOp() {
        return codigoOp;
    }

    public boolean isRelocalizable() {
        return relocalizable;
    }

    public void setRelocalizable(boolean relocalizable) {
        this.relocalizable = relocalizable;
    }

    public boolean isDirectiva() {
        return directiva;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isIndexado() {
        return indexado;
    }

    public void setIndexado(boolean indexado) {
        this.indexado = indexado;
    }

    public boolean isConstante() {
        return constante;
    }

    public void setConstante(boolean constante) {
        this.constante = constante;
    }
}
