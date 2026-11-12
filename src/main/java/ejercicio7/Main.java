/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

import java.util.Scanner;

public class Main {

    public static double promedio(double[] notas) {
        if (notas.length == 0) {
            throw new IllegalArgumentException("No hay notas para promediar");
        }
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }

    // Pide la cantidad de notas hasta que el usuario escriba un entero positivo
    static int leerCantidad(Scanner sc) {
        while (true) {
            System.out.print("¿Cuántas notas? ");
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n > 0) {
                    return n;
                }
                System.out.println("La cantidad debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido: escriba un número entero.");
            }
        }
    }

    // Pide una nota hasta que sea un número entre 0 y 5
    static double leerNota(Scanner sc, int numero) {
        while (true) {
            System.out.print("Nota " + numero + " (0 a 5): ");
            try {
                double nota = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
                if (nota >= 0 && nota <= 5) {
                    return nota;
                }
                System.out.println("La nota debe estar entre 0 y 5.");
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido: escriba un número, por ejemplo 4.5");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = leerCantidad(sc);
            double[] notas = new double[n];
            for (int i = 0; i < n; i++) {
                notas[i] = leerNota(sc, i + 1);
            }
            System.out.printf("Promedio: %.2f%n", promedio(notas));
        } finally {
            sc.close();
        }
    }
}
