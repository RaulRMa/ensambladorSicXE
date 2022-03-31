package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramaObjeto {
    private final HashMap<String, String> registroH;
    private HashMap<String, String> registroT;
    private final ArrayList<HashMap<String, String>> registrosT;
    private HashMap<String, String> registroM;
    private final HashMap<String, String> registroE;
    private final ArrayList<String> relocalizables;
    private final ArrayList<HashMap<String, String>> registrosM;
    private String iniProg;
    private String dirPrimInst;
    private final File progObj;
    private ArrayList<String> codsObj;

    public ProgramaObjeto(ArrayList<String> codsObj, String nombreArch){
        registroH = new LinkedHashMap<>();
        registrosT = new ArrayList<>();
        registrosM = new ArrayList<>();
        registroM = new LinkedHashMap<>();
        registroE = new LinkedHashMap<>();
        relocalizables = new ArrayList<>();
        this.codsObj = codsObj;
        String nombre = nombreArch.replace(".err",".obj");
        progObj = new File(nombre);
        creaRegistroH(codsObj);
        creaRegistosT(codsObj);
        creaRegistrosM();
        creaRegistroFin();
        escribeArchivo();
    }
    private String anexaCeros(String cadena, int numero){
        if(cadena.length() < numero){
            StringBuilder ceros = new StringBuilder();
            ceros.append("0".repeat(Math.max(0, numero)));
            return ceros.substring(0,numero - cadena.length()) + cadena;
        }
        return  cadena;
    }
    private void creaRegistroH(ArrayList<String> codsObj){
        String[] h = codsObj.get(0).split("\t+");
        String nombreP = h[1];
        StringBuilder str = new StringBuilder();
        String dirInicio = anexaCeros(h[0], 6);
        if(nombreP.length() < 6){
            str.append(nombreP);
            str.append(" ".repeat(6 - nombreP.length()));
        }else if(nombreP.length() > 6){
            str.append(nombreP, 0, 6);
        }
        String longitud = anexaCeros(longPrograma(codsObj),6);
        iniProg = str.toString();
        registroH.put("H", "H");
        registroH.put("Nombre",iniProg);
        registroH.put("Direccion", dirInicio);
        registroH.put("Longitud",longitud);
    }
    private String longPrograma(ArrayList<String> codsObj){
        String finProg = codsObj.get(codsObj.size() - 1);
        String[] primero = codsObj.get(0).split("\t+");
        String[] ultimo = finProg.split("\t+");
        String dir1 = anexaCeros(primero[0],4);
        String dir2 = anexaCeros(ultimo[0],4);
        int dec1 = Integer.parseInt(dir1,16);
        int dec2 = Integer.parseInt(dir2,16);
        int result = dec2 - dec1;
        codsObj.remove(0);
        codsObj.remove(codsObj.size() - 1);
        return Integer.toHexString(result);
    }
    private void creaRegistosT(ArrayList<String> codsObj){

        StringBuilder acumulador = new StringBuilder();

        for (String codObj : codsObj){
            String[] cod = codObj.split("\t+");
            String codigoO = cod[cod.length - 1].split(" ")[0];
            if(acumulador.isEmpty() && !codigoO.equals("----")){
                registroT = new LinkedHashMap<>();
                registroT.put("T","T");
                String dirInicio = anexaCeros(cod[0],6);
                registroT.put("Direccion",dirInicio);
                agregaCodObj(codigoO,acumulador,codObj);
            }else if(!codigoO.equals("----") && acumulador.length() < 60){
                agregaCodObj(codigoO,acumulador,codObj);
            }else{
                if(acumulador.isEmpty()) continue;
                String longitud = String.valueOf(acumulador.length() / 2);
                registroT.put("Longitud", anexaCeros(longitud,2));
                registroT.put("Codigo",acumulador.toString());
                acumulador = new StringBuilder();
                registrosT.add(registroT);
            }
        }
    }
    private void creaRegistrosM(){
        for (String cadena : relocalizables){
            String[] elementos = cadena.split("\t+");
            registroM = new LinkedHashMap<>();
            registroM.put("M","M");
            int decDir = Integer.parseInt(elementos[0],16);
            String inicio = Integer.toHexString(++decDir);
            registroM.put("Inicio", anexaCeros(inicio,2));
            registroM.put("Longitud","05");
            registroM.put("Bandera","+");
            registroM.put("Simbolo",iniProg);
            registrosM.add(registroM);
        }
    }
    private void agregaCodObj(String cadena, StringBuilder acumulador, String inst){
        if(cadena.contains("*")){
            relocalizables.add(inst);
            String codRe = cadena.split("[*]")[0];
            acumulador.append(codRe);
        }else{
            acumulador.append(cadena);
        }
    }
    private void creaRegistroFin(){
        Pattern expReg = Pattern.compile("WORD|BYTE|RESW|RESB|BASE");
        for (String cod : codsObj){
            Matcher matcher = expReg.matcher(cod);
            if(!matcher.find()){
                dirPrimInst = cod.split("\t+")[0];
                dirPrimInst = anexaCeros(dirPrimInst,6);
                break;
            }

        }
        registroE.put("E","E");
        registroE.put("Direccion",dirPrimInst);
    }
    private void escribeArchivo(){
        try {
            PrintWriter writer = new PrintWriter(progObj);
            for (String cadena : registroH.values()){
                writer.print(cadena);
            }
            writer.print("\n");
            for (HashMap<String,String> registro : registrosT){
                for (String cadena : registro.values()){
                    writer.print(cadena);
                }
                writer.print("\n");
            }
            for (HashMap<String,String> registro : registrosM){
                for (String cadena : registro.values()){
                    writer.print(cadena);
                }
                writer.print("\n");
            }
            for (String cadena : registroE.values()){
                writer.print(cadena);
            }
            writer.close();
            progObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
