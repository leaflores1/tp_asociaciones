import java.util.ArrayList;
import java.util.Scanner;

class Plato {
    String nombreCompleto;
    double precio;
    boolean esBebida;
    ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void imprimirPlato() {
        System.out.println("Plato: " + nombreCompleto);
        System.out.println("Precio: $" + precio);
        if (!esBebida) {
            System.out.println("Ingredientes:");
            for (Ingrediente ingrediente : ingredientes) {
                System.out.println("- " + ingrediente);
            }
        }
        System.out.println();
    }
}