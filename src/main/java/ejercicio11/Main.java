/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio11;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
/**
 *
 * @author SANTIAGO
 */
public class Main {
    
    
    static double leerNota(String texto, int numero) {
        String limpio = texto.trim();
        double nota;
        try {
            nota = Double.parseDouble(limpio);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("la nota " + numero + " ('" + limpio + "') no es un número");
        }
        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("la nota " + numero + " (" + limpio + ") está fuera del rango 0 a 5");
        }
        return nota;
    }
    
    public static void main(String[] args) {
        int procesados = 0;
        int conError = 0;
        int numeroLinea = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("notas.csv", StandardCharsets.UTF_8));
             PrintWriter pw = new PrintWriter(new FileWriter("reporte.csv", StandardCharsets.UTF_8))) {

            pw.println("codigo,nombre,promedio,estado");
            
            br.readLine();
            numeroLinea = 1;
            
            String linea;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.isBlank()) {
                    continue;
                }
                try {
                    String[] c = linea.split(",");
                    if (c.length != 5) {
                        throw new IllegalArgumentException("se esperaban 5 columnas y hay " + c.length);
                    }
                    String codigo = c[0].trim();
                    String nombre = c[1].trim();
                    double n1 = leerNota(c[2], 1);
                    double n2 = leerNota(c[3], 2);
                    double n3 = leerNota(c[4], 3);

                    double promedio = (n1 + n2 + n3) / 3;
                    String estado = promedio >= 3.0 ? "APROBADO" : "REPROBADO";

                    pw.println(codigo + "," + nombre + ","
                            + String.format(Locale.US, "%.2f", promedio) + "," + estado);
                    procesados++;
                } catch (IllegalArgumentException e) {
                    System.out.println("Línea " + numeroLinea + " con error: " + e.getMessage());
                    conError++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró notas.csv. Debe estar en la carpeta del proyecto.");
            return;
        } catch (IOException e) {
            System.out.println("Error al leer o escribir los archivos: " + e.getMessage());
            return;
        }

        System.out.println("Registros procesados: " + procesados);
        System.out.println("Registros con error: " + conError);
    }
}

   //gggg santi 

