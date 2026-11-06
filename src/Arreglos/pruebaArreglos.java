package Arreglos;
import java.util.Locale;
import java.util.Arrays;
import java.util.Scanner;

public class pruebaArreglos {

    public static double [] pedirNotas(Scanner entrada) {
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            double nota = -1;
            while (nota < 0.0 || nota > 5.0) {
                System.out.print("Ingrese la nota " + (i + 1) + " (0.0 a 5.0): ");
                try {
                    nota = Double.parseDouble(entrada.nextLine().replace(',', '.'));
                    if (nota < 0.0 || nota > 5.0) {
                        System.out.println("Nota inválida. Debe estar entre 0.0 y 5.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido.");
                    nota = -1;
                }
            }
            notas[i] = nota;
        }
        return notas;
    }

    public static double calcularPromedio(double [] nota){
        double suma=0;
        for (double n: nota) {
            suma+=n;
        }return suma/ nota.length;
    }

    public static boolean validarAprueban (double [] nota){
        for (double n: nota) {
            if (n < 3.0) {
                return false;
            }
        }
        return true;
    }
    public static void mostrarReprobadas(double[] notas) {
        boolean hayReprobadas = false;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 3.0) {
                if (!hayReprobadas) {
                    mostrar("Notas reprobadas:");
                    hayReprobadas = true;
                }
                mostrar("  - Nota " + (i + 1) + ": " + notas[i]);
            }
        }

        if (hayReprobadas) {
            mostrar("Debes recuperar las notas indicadas.");
        } else {
            mostrar("¡Felicidades! No tienes notas por recuperar.");
        }
    }
    public static void mostrar   (String mensaje){
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        entrada.useLocale(Locale.US);
        double[] misNotas = pedirNotas(entrada);
        double promedio = calcularPromedio(misNotas);
        boolean aprueban = validarAprueban(misNotas);

        mostrar("Promedio: " + promedio);
        mostrar(aprueban ? "Aprobó todas las notas" : "Tiene al menos una nota reprobada");
        mostrarReprobadas(misNotas);

    }
}
