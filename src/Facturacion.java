import java.util.Scanner;

public class Facturacion {
    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabón en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        System.out.print("Ingrese la fecha de la factura: ");
        factura.setFechaFactura(scanner.nextLine());

        System.out.print("Ingrese el número de la factura: ");
        while (true) {
            try {
                factura.setNumeroFactura(scanner.nextLong());
                scanner.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intente nuevamente.");
            }
        }

        System.out.print("Ingrese el nombre del cliente: ");
        while (true) {
            try {
                factura.setCliente(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intente nuevamente.");
            }
        }

        // Carga de artículos
        while (true) {
            System.out.print("Ingrese el código del artículo (o '0' para finalizar): ");
            String codigo = scanner.nextLine();
            if (codigo.equals("0")) break;

            String[] articulo = buscarArticulo(codigo);
            if (articulo == null) {
                System.out.println("El código ingresado no existe. Intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            double precioUnitario = Double.parseDouble(articulo[2]);
            factura.agregarDetalle(new DetalleFactura(codigo, articulo[1], cantidad, precioUnitario));
        }

        // Cálculo y presentación
        factura.calcularMontoTotal();
        factura.imprimirFactura();

        scanner.close();
    }

    private static String[] buscarArticulo(String codigo) {
        for (String[] articulo : articulos) {
            if (articulo[0].equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
}
