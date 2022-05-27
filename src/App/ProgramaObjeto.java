package App;

import sintaxis.Simbolo;

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
    public HashMap<String, String> registroH;
    private HashMap<String, String> registroT;
    private HashMap<String, String> registroR;
    public HashMap<String, String> registroD;
    public ArrayList<HashMap<String, String>> registrosT;
    private HashMap<String, String> registroM;
    public HashMap<String, String> registroE;
    private ArrayList<String> relocalizables;
    public ArrayList<HashMap<String, String>> registrosM;
    private String iniProg;
    private String dirPrimInst;
    private File progObj;
    private ArrayList<String> codsObj;
    private String finProg;
    private ArrayList<Simbolo> tabsim;

    public ProgramaObjeto(ArrayList<String> codsObj, String nombreArch, ArrayList<Simbolo> tabsim){
        iniciaLiza();
        this.tabsim = tabsim;
        this.codsObj = codsObj;
        String nombre = nombreArch.replace(".err",".obj");
        progObj = new File(nombre);
        creaRegistroH(codsObj);
        creaRegistosT(codsObj);
        creaRegistrosM();
        creaRegistroFin();
        escribeArchivo();
    }

    public ProgramaObjeto(){
        iniciaLiza();
    }

    private void iniciaLiza(){
        registroH = new LinkedHashMap<>();
        registrosT = new ArrayList<>();
        registrosM = new ArrayList<>();
        registroM = new LinkedHashMap<>();
        registroE = new LinkedHashMap<>();
        relocalizables = new ArrayList<>();
        registroR = new LinkedHashMap<>();
        registroD = new LinkedHashMap<>();
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
        iniProg = str.toString().toUpperCase();
        registroH.put("H", "H");
        registroH.put("Nombre",iniProg);
        registroH.put("Direccion", dirInicio);
        registroH.put("Longitud",longitud);
    }
    public void creaRH(String linea){
        if(linea.length() == 19){
            this.registroH.put("H","H");
            this.registroH.put("Nombre",linea.substring(1,7));
            this.registroH.put("Direccion",linea.substring(7,13));
            this.registroH.put("Longitud",linea.substring(13,19));
        } else {
            System.out.println("Error en el programa");
        }
    }
    private String longPrograma(ArrayList<String> codsObj){
        finProg = codsObj.get(codsObj.size() - 1);
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
            if(codObj.contains("EQU")) continue;

            if(acumulador.isEmpty() && !codigoO.equals("----")){
                registroT = new LinkedHashMap<>();
                registroT.put("T","T");
                String dirInicio = anexaCeros(cod[0],6);
                registroT.put("Direccion",dirInicio);
                agregaCodObj(codigoO,acumulador,codObj);
            }else if(!codigoO.equals("----") && acumulador.length() < 60){
                agregaCodObj(codigoO,acumulador,codObj);
                if(codsObj.indexOf(codObj) == codsObj.size() - 1){
                    String longitud = String.valueOf(acumulador.length() / 2);
                    registroT.put("Longitud", anexaCeros(longitud,2));
                    registroT.put("Codigo",acumulador.toString());
                    registrosT.add(registroT);
                }
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
    public void creaRT(String linea){
        registroT = new HashMap<>();
        registroT.put("T","T");
        registroT.put("Direccion",linea.substring(1,7));
        registroT.put("Longitud",linea.substring(7,9));
        registroT.put("Codigo",linea.substring(9));
        registrosT.add(registroT);
    }
    private void creaRegistrosM(){
        for (String cadena : relocalizables){
            String[] elementos = cadena.split("\t+");
            registroM = new LinkedHashMap<>();
            registroM.put("M","M");
            int bytes = cadena.contains("WORD") ? 6 : 5;
            int decDir = Integer.parseInt(elementos[0],16);
            String inicio = bytes == 6 ? elementos[0]: Integer.toHexString(++decDir);
            registroM.put("Inicio", anexaCeros(inicio,6));
            registroM.put("Longitud","0" + bytes);
            registroM.put("Bandera","+");
            registroM.put("Simbolo",iniProg);
            registrosM.add(registroM);
        }
    }
    public void creaRM(String linea){
        if(linea.length() == 16){
            registroM = new LinkedHashMap<>();
            registroM.put("M","M");
            registroM.put("Inicio",linea.substring(1,7));
            registroM.put("Longitud",linea.substring(7,9));
            registroM.put("Bandera",linea.substring(9,10));
            registroM.put("Simbolo",linea.substring(10,16));
            registrosM.add(registroM);
        }else {
            System.out.println("Error en el registro M");
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
        Pattern expReg = Pattern.compile("WORD|BYTE|RESW|RESB|BASE|EQU");
        System.out.println(finProg);
        String[] elementos = finProg.split("\t+");
        if(elementos.length < 4){
            for (String cod : codsObj){
                Matcher matcher = expReg.matcher(cod);
                if(!matcher.find()){
                    dirPrimInst = cod.split("\t+")[0];
                    dirPrimInst = anexaCeros(dirPrimInst,6);
                    break;
                }

            }
        }else{
            String simbolo = elementos[2];
            String direccion = "";
            for(Simbolo s : tabsim){
                if(s.nombre.equals(simbolo)){
                    direccion = s.dirOSimbolo;
                    break;
                }
            }
            dirPrimInst = anexaCeros(direccion,6);
        }
        registroE.put("E","E");
        registroE.put("Direccion",dirPrimInst);
    }
    public void creaRE(String linea){
        registroE.put("E","E");
        if(linea.length() > 1){
            registroE.put("Direccion", linea.substring(1));
        }
    }
    public void creaRR(String linea){
        registroR.put("R","R");
        if(linea.length() > 7){
            int fin = 7;
            int inicio = 1;

            while (fin <= linea.length()){
                registroR.put(linea.substring(inicio,fin),linea.substring(inicio,fin));
                inicio = fin;
                fin += 6;
            }
        }else {
            registroR.put(linea.substring(1,7),linea.substring(1,7));
        }
    }
    public void creaRD(String linea){
        registroD.put("D","D");
        if(linea.length() > 13){
            int cont = 0;
            int fin = 13;
            int inicio = 1;
            while (fin <= linea.length()){
                registroD.put(linea.substring(inicio, inicio + 6),linea.substring(fin -6,fin));
                inicio = fin;
                fin += 12;
                cont++;
            }
        }else {
            registroD.put(linea.substring(1,7),linea.substring(7,13));
        }
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
