package sintaxis;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruccion {
    private final String nombre;
    private String direccion;
    private String simbolo;
    private int bytes;

    public Instruccion(String nombre, String direccion, String simbolo){
        this.nombre = nombre;
        this.direccion = direccion;
        this.simbolo = simbolo;
        calculaBytes(nombre,direccion);
    }
    public Instruccion(String nombre, String direccion){
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
                bytes = bytesDirectiva(nombre,direccion);
                break;
            case "Byte":
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
        if(tipo.contains("F1")) return 1;
        if(tipo.contains("F2")) return 2;
        if(tipo.contains("F3")) return 3;
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

    public String getNombre() {
        return nombre;
    }

    public int getBytes() {
        return bytes;
    }
    public String getSimbolo() {
        return simbolo;
    }
}
