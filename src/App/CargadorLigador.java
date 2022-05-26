package App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

public class CargadorLigador {

    private ArrayList<ProgramaObjeto> programasObjeto;

    public LinkedHashMap<String, ArrayList<String>> getTabse() {
        return tabse;
    }

    private LinkedHashMap<String, ArrayList<String>> tabse;
    private LinkedHashMap<String, ArrayList<String>> mapaMem;
    private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> mapaMemRel;
    private String DIRPROG;
    private String DIRSC;
    private String LONSC;
    private String DIREJ;
    private ArrayList<String> seccionesCont;
    private ArrayList<String> simbolos;
    private ArrayList<String> direcciones;
    private ArrayList<String> longitudes;
    private LinkedHashMap<String, String> localidades;
    private LinkedHashMap<String, String> relocalizadas;

    public CargadorLigador(ArrayList<ProgramaObjeto> programas, String dirInicio){
        this.programasObjeto = programas;
        DIRPROG = dirInicio;
        DIRSC = DIRPROG;
        tabse = new LinkedHashMap<>();

        seccionesCont = new ArrayList<>();
        simbolos = new ArrayList<>();
        direcciones = new ArrayList<>();
        longitudes = new ArrayList<>();
        try{
            paso1();
            paso2();
            creaMapMem();
            relocalizaMapMem();
            System.out.println("Listo!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void paso1() throws Exception {
        for (ProgramaObjeto p : programasObjeto){
            this.LONSC = p.registroH.get("Longitud");
            insertaValores(p.registroH.get("Nombre"),"",this.DIRSC, this.LONSC);
            if(!p.registroD.isEmpty()){
                for(String simbolo : p.registroD.keySet()){
                    if(simbolo.equals("D")) continue;
                    String dir = p.registroD.get(simbolo);
                    if(!simbolos.contains(simbolo)){
                        int sumaDirS = Integer.parseInt(DIRSC,16) + Integer.parseInt(dir,16);
                        String dirS = Integer.toHexString(sumaDirS);
                        insertaValores("",simbolo,dirS,"");
                    }
                    else {
                        throw new Exception("Error, simbolo ya existe en tabse");
                    }
                }
            }
            int suma = Integer.parseInt(DIRSC,16) + Integer.parseInt(LONSC,16);
            this.DIRSC = Integer.toHexString(suma).toUpperCase(Locale.ROOT);
        }
        tabse.put("SC",seccionesCont);
        tabse.put("Simbolos",simbolos);
        tabse.put("Direccion",direcciones);
        tabse.put("Longitudes",longitudes);
    }

    private void paso2() throws Exception {
        this.DIRSC = this.DIRPROG;
        this.DIREJ = this.DIRPROG;
        ArrayList<String> bytes = new ArrayList<>();
        localidades = new LinkedHashMap();
        relocalizadas = new LinkedHashMap<>();
        for (ProgramaObjeto p : programasObjeto){
            HashMap<String, String> regH = p.registroH;
            this.LONSC = regH.get("Longitud");
            for(HashMap<String, String> rT : p.registrosT){
                String direccion = rT.get("Direccion");
                int suma = Integer.parseInt(DIRSC,16) + Integer.parseInt(direccion,16);
                localidades.put(Integer.toHexString(suma), rT.get("Codigo"));
            }
            if(!p.registrosM.isEmpty()){
                for(HashMap<String, String> rM : p.registrosM){
                    String simbolo = rM.get("Simbolo");
                    int indice;
                    String dirSimbolo;
                    if(simbolos.contains(simbolo)){
                        indice = simbolos.indexOf(simbolo);
                        dirSimbolo = direcciones.get(indice);
                    }
                    else if(seccionesCont.contains(simbolo)){
                        indice = seccionesCont.indexOf(simbolo);
                        dirSimbolo = direcciones.get(indice);
                    }
                    else{
                        throw new Exception("Error, simbolo externo no definido");
                    }
                    String dirRM = rM.get("Inicio");
                    int suma = Integer.parseInt(this.DIRSC,16) + Integer.parseInt(dirRM,16);
                    String dirRelocalizable = Integer.toHexString(suma);
                    String band = rM.get("Bandera");
                    String mBytes = rM.get("Longitud");
                    if(relocalizadas.containsKey(dirRelocalizable)){
                        String aux = relocalizadas.get(dirRelocalizable);
                        relocalizadas.put(dirRelocalizable,aux + "," + mBytes + band + dirSimbolo);
                    }else{
                        relocalizadas.put(dirRelocalizable,mBytes +band + dirSimbolo);
                    }
                }
            }
            if(p.registroE.containsKey("Direccion")){
                int suma = Integer.parseInt(DIRSC,16) + Integer.parseInt(p.registroE.get("Direccion"),16);
                DIREJ = Integer.toHexString(suma).toUpperCase(Locale.ROOT);
            }
            int suma = Integer.parseInt(DIRSC,16) + Integer.parseInt(LONSC,16);
            DIRSC = Integer.toHexString(suma);
        }
    }

    private void creaMapMem(){
        mapaMem = new LinkedHashMap<>();
        ArrayList<String> fila = null;
        for(String clave : localidades.keySet()){
            String locIni = clave.substring(0,2);
            String bit3 = clave.substring(2,3);
            int cont = Integer.parseInt(bit3,16);
            String codobj = localidades.get(clave);
            int longitud = codobj.length() / 2;
            int byteIni = Integer.parseInt(clave.substring(clave.length() - 1),16);
            int cont2 = 0;
            int subIni = 0;
            int subFin = 2;
            while (cont2 <= longitud){
                boolean bandera = false;
                for(int i = 0; i < 16; i++){
                    if(cont2 == longitud){
                        bandera = true;
                        break;
                    }
                    if(i == 0){
                        fila = new ArrayList<>();
                    }
                    if(byteIni <= i){
                        fila.add(codobj.substring(subIni,subFin));
                        subIni = subFin;
                        subFin += 2;
                        cont2++;
                    }
                    else{
                        fila.add("FF");
                    }
                }
                mapaMem.put(locIni + Integer.toHexString(cont) + 0,fila);
                cont++;
                byteIni = 0;
                if(bandera){
                    break;
                }
            }

        }
    }
    private void relocalizaMapMem(){
        System.out.println(relocalizadas);
        for(String dir : relocalizadas.keySet()){
            String valor = relocalizadas.get(dir);
            int localidad = Integer.parseInt(dir.substring(dir.length() - 1),16 ) + 1;
            int bit = Integer.parseInt(dir.substring(2,3),16);
            String direccion =  dir.substring(0,2);
            ArrayList<String> filaAux = mapaMem.get(direccion+ bit + 0);
            ArrayList<String> filaAux2 = null;
            if(!valor.contains(",")){
                boolean bandera = false;
                int medBytes = Integer.parseInt(valor.substring(0,2));
                int valSimbolo = Integer.parseInt(valor.substring(3),16);
                StringBuilder cadena = new StringBuilder();
                int locAux = localidad;
                for (int i = 0; i < (medBytes - 1)/2; i++){
                    if(locAux >= filaAux.size()){
                        bit++;
                        filaAux2 = mapaMem.get(direccion+ bit + 0);
                        locAux = 0;
                        bandera = true;
                    }
                    if(bandera){
                        cadena.append(filaAux2.get(locAux++));
                    }else{
                        cadena.append(filaAux.get(locAux++));
                    }
                }
                int suma = valSimbolo + Integer.parseInt(cadena.toString(),16);
                String sumaVals = Integer.toHexString(suma);
                int ini = 0;
                int fin = 2;
                for(int j = 0; j < sumaVals.length() / 2; j++){
                    filaAux.set(localidad++, sumaVals.substring(ini,fin));
                    if(bandera){
                        filaAux = filaAux2;
                        localidad = 0;
                    }
                    ini = fin;
                    fin += 2;
                }
            }
            else{
                String[] valores = valor.split(",");
                for(String val : valores){
                    boolean bandera = false;
                    int medBytes = Integer.parseInt(val.substring(0,2));
                    int valSimbolo = Integer.parseInt(val.substring(3),16);
                    StringBuilder cadena = new StringBuilder();
                    int locAux = localidad == 5 ? localidad : --localidad;
                    for (int i = 0; i < (medBytes == 5 ? (medBytes - 1)/2 : 3); i++){
                        if(locAux >= filaAux.size()){
                            bit++;
                            filaAux2 = mapaMem.get(direccion+ bit + 0);
                            locAux = 0;
                            bandera = true;
                        }
                        if(bandera){
                            cadena.append(filaAux2.get(locAux++));
                        }else{
                            cadena.append(filaAux.get(locAux++));
                        }
                    }
                    int suma = valSimbolo + Integer.parseInt(cadena.toString(),16);
                    String sumaVals = Integer.toHexString(suma);
                    int ini = 0;
                    int fin = 2;
                    int locaux2 = localidad++;
                    for(int j = 0; j < sumaVals.length() / 2; j++){
                        filaAux.set(locaux2++, sumaVals.substring(ini,fin));
                        if(bandera){
                            filaAux = filaAux2;
                            localidad = 0;
                        }
                        ini = fin;
                        fin += 2;
                    }
                }
            }
        }
    }
    private void insertaValores(String sc, String simbolo, String direccion, String longitud){
        seccionesCont.add(sc);
        simbolos.add(simbolo);
        direcciones.add(direccion);
        longitudes.add(longitud);
    }

}
