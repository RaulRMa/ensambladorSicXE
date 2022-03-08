package App;

import Gui.Principal;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Principal ventana = new Principal();

    }
    private static void calcula(){
        int valor1 = 0x9;
        int valor2 = 0x2;
        int resultado = valor1 + valor2;
        System.out.println("Este es el resultado: " + Integer.toHexString(resultado).toUpperCase(Locale.ROOT));
    }
}
