package App;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Intermedio {
    private final File aIntermedio;
    private final File aFuente;
    private final Map<Integer, Object> mapa;
    private final ArrayList<String> lineasErrores;
    private ArrayList<String> lineasArchivo;
    private Map<String, String> tabsim;

    public Intermedio(Map<Integer, Object> mapa, File archivo, ArrayList lineasErrores){
        lineasArchivo = new ArrayList<>();
        String nombre = archivo.getName().replace(".xe", ".int");
        aFuente = archivo;
        this.mapa = mapa;
        this.lineasErrores = lineasErrores;
        aIntermedio = new File(nombre);
        generaTabla();
        escribeArchivo();
    }

    private void generaTabla(){
        String linea;
        Scanner sc;
        String[] elementos;
        tabsim = new HashMap<>();
        String lineaAEscribir;
        int cp = 0x0;
        int contador = 1;
        int contMap = 1;
        try {
            sc = new Scanner(aFuente);
            cp += bytesStart();
            while (sc.hasNext()){
                linea = sc.nextLine();
                if(!lineasErrores.contains(contador)){
                    elementos = linea.split("[\t\r\0]");
                    String aEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea;
                    if(elementos[1].equals("START")){
                        lineaAEscribir = aEscribir;
                        lineasArchivo.add(lineaAEscribir);
                        contador++;
                        continue;
                    }
                    if(elementos[1].equals("END")) {
                        lineaAEscribir = aEscribir;
                        lineasArchivo.add(lineaAEscribir);
                        break;
                    }
                    HashMap mapaArchivo = (HashMap) this.mapa.get(contMap++);
                    Iterator it = mapaArchivo.keySet().iterator();
                    Object key = it.next();

                    if(!elementos[0].isBlank() && !tabsim.containsKey(elementos[0]) && !elementos[1].equals("START")){
                        tabsim.put(elementos[0],Integer.toHexString(cp));
                    }
                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
                    switch (tipoInstruccion(key)){
                        case "SIC":
                            cp += (int)mapaArchivo.get(key);
                        break;
                        case "DIRECTIVA":
                            cp += bytesDirectiva(key,mapaArchivo);
                        break;
                        case "Byte":
                            cp += bytesByte(key,mapaArchivo);
                        break;
                    }
                    contador++;
                }else{
                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\tError: sintaxis";
                    contador++;
                }
                lineasArchivo.add(lineaAEscribir);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int bytesStart(){
        HashMap mapaStart = (HashMap) this.mapa.get(0);
        String dirInicial = (String) mapaStart.get("Start");
        if(dirInicial.contains("H") | dirInicial.contains("H")){
            String[] cadenas = dirInicial.split("[H|h]+");
            return Integer.parseInt(cadenas[0],16);
        }
        return Integer.parseInt(dirInicial);
    }
    private int bytesDirectiva(Object key, HashMap mapa){
        int bytes = 0;
        if(key.toString().contains("WORD")){
            bytes = 3;
        }else if(key.toString().contains("RESB")){
            String direccion = (String) mapa.get(key);
            bytes = direccion.contains("H") | direccion.contains("h")
                    ?
                    Integer.parseInt(direccion,16)
                    :
                    Integer.parseInt(direccion);
        }
        else{

            String direccion = (String) mapa.get(key);
            bytes = direccion.contains("H") | direccion.contains("h")
                    ?
                    Integer.parseInt(direccion,16)
                    :
                    Integer.parseInt(direccion);
            bytes *= 3;
        }
        return bytes;
    }

    private String tipoInstruccion(Object key){
        Pattern patronFormato = Pattern.compile("F1|F2|F3|F4");
        Pattern patronDirectivas = Pattern.compile("WORD|RESB|RESW");
        Matcher matcher;
        matcher = patronFormato.matcher(key.toString());
        if(matcher.find()) return "SIC";
        matcher = patronDirectivas.matcher(key.toString());
        if(matcher.find()) return  "DIRECTIVA";
        if(key.toString().contains("Byte")) return "Byte";
        if(key.toString().contains("Base")) return "Base";
        return "End";
    }

    private int bytesByte(Object key, HashMap mapa){
        String total;
        if(key.toString().contains("C")){
            String valor = (String) mapa.get(key);
            total = String.valueOf(valor.length());
            return Integer.parseInt(total,16);
        }
        String valor = (String) mapa.get(key);
        int longitud = valor.length();
        if(longitud % 2 == 0) {
            total = String.valueOf(longitud/2);
            return Integer.parseInt(total,16);
        }
        total = String.valueOf((longitud+1)/2);
        return Integer.parseInt(total);
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

    public File archivoIntermedio() {return  aIntermedio;}

}
