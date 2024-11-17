import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Ingrese el nombre completo del alumno: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el legajo del alumno: ");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Limpiar buffer

            Alumno alumno = new Alumno(nombre, legajo);

            System.out.print("Ingrese la cantidad de notas para el alumno: ");
            int cantidadNotas = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Ingrese el nombre de la cátedra: ");
                String catedra = scanner.nextLine();
                System.out.print("Ingrese la nota del examen: ");
                double nota = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                alumno.agregarNota(new Nota(catedra, nota));
            }

            alumnos.add(alumno);
        }

        for (Alumno alumno : alumnos) {
            alumno.imprimirInformacion();
        }

        scanner.close();
    }
}