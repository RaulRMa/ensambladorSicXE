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
    private final ArrayList<String> lineasArchivo, tipoErrores;
    private int primerDir, ultimaDir;

    public Intermedio(ArrayList<Instruccion> mapa, File archivo, ArrayList<Integer> lineasErrores, ArrayList<String> errores){
        lineasArchivo = new ArrayList<>();
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
                if(elementos[1].trim().equals("END")) {
                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
                    lineasArchivo.add(lineaAEscribir);
                    ultimaDir = cp;
                    break;
                }
                if(elementos[1].trim().equals("START")){
                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
                    lineasArchivo.add(lineaAEscribir);
                    contador++;
                    primerDir = cp;
                    continue;
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
                    lineaAEscribir = Integer.toHexString(cp).toUpperCase(Locale.ROOT) + "\t" + linea + "\t----";
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
            //String encabezado = "Nemónico\t" + "Número\t" + "Uso especial";
            //wr.println(encabezado);

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
    private String codigoObjeto(Instruccion instruccion){
        String algo = "";
        if(instruccion.isDirectiva()){
            return codopDirectiva(instruccion);
        }
        switch (instruccion.getNombre()){
            case "INSF3":

                break;
            case "INSF2":

                break;
            case "INSF1":

                break;
        }
        return algo;
    }

    private String codopDirectiva(Instruccion instruccion){
        Pattern patronDirectivas = Pattern.compile("WORD|BYTE");
        Matcher matcher = patronDirectivas.matcher(instruccion.getNombre());
        if(matcher.find()){
            if(instruccion.getNombre().contains("BYTE") ){
                if( instruccion.getSimbolo().equals("C")) {
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
            int valor = 6 - instruccion.getDireccion().length();
            if(6 - valor != 0){
                String ceros = "";
                for(int i = 0; i < valor; i++) ceros += "0";
                return ceros + bytes;
            }
            return String.valueOf(bytes);
        }
        return "\t----";
    }
    private String codopInstF3(Instruccion instruccion){
        return "";
    }
    public File tablaSimbolos(){return tabsimbolos;}
}
