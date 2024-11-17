import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        System.out.print("Ingrese la cantidad de platos a cargar: ");
        int cantidadPlatos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.print("Ingrese el nombre del plato: ");
            String nombrePlato = scanner.nextLine();
            System.out.print("Ingrese el precio del plato: ");
            double precio = scanner.nextDouble();
            System.out.print("¿Es una bebida? (true/false): ");
            boolean esBebida = scanner.nextBoolean();
            scanner.nextLine();

            Plato plato = new Plato(nombrePlato, precio, esBebida);

            if (!esBebida) {
                System.out.print("Ingrese la cantidad de ingredientes: ");
                int cantidadIngredientes = scanner.nextInt();
                scanner.nextLine();

                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.print("Ingrese el nombre del ingrediente: ");
                    String nombreIngrediente = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del ingrediente: ");
                    double cantidad = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese la unidad de medida: ");
                    String unidadMedida = scanner.nextLine();

                    plato.agregarIngrediente(new Ingrediente(nombreIngrediente, cantidad, unidadMedida));
                }
            }

            platosMenu.add(plato);
        }

        System.out.println("\nMENÚ:");
        for (Plato plato : platosMenu) {
            plato.imprimirPlato();
        }

        scanner.close();
    }
}