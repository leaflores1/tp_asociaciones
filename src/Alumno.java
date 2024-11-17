import java.util.ArrayList;
import java.util.Scanner;

class Alumno {
    String nombreCompleto;
    long legajo;
    ArrayList<Nota> notas;

    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.notaExamen;
        }
        return notas.isEmpty() ? 0 : suma / notas.size();
    }

    public void imprimirInformacion() {
        System.out.println("Alumno: " + nombreCompleto + " - Legajo: " + legajo);
        for (Nota nota : notas) {
            System.out.println("Cátedra: " + nota.catedra + " - Nota: " + nota.notaExamen);
        }
        System.out.println("Promedio: " + calcularPromedio());
    }
}