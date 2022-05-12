package sintaxis;

public class Simbolo {
    public String nombre;
    public boolean equ;
    public String expresion;
    public boolean relativo;
    public String dirOSimbolo;
    public boolean positivo;
    public Simbolo(String nombre, String expresion, boolean esEqu){
        this.nombre = nombre;
        this.expresion = expresion;
        this.equ = esEqu;
    }
    public Simbolo(String nombre){
        this.nombre = nombre;
    }
}
