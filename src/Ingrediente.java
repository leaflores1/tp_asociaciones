import java.util.ArrayList;
import java.util.Scanner;

class Ingrediente {
    String nombre;
    double cantidad;
    String unidadMedida;

    public Ingrediente(String nombre, double cantidad, String unidadMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    public String toString() {
        return nombre + " " + cantidad + " " + unidadMedida;
    }
}