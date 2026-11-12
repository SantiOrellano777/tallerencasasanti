/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author SANTIAGO
 */
public class Main {
     public static void main(String[] args) {
        Bitacora bitacora = new Bitacora("bitacora.txt");

        try {
            bitacora.registrar("Sistema iniciado");
            bitacora.registrar("ERROR: no se pudo conectar a la base de datos");
            bitacora.registrar("Usuario admin inició sesión");
            bitacora.registrar("ERROR: tiempo de espera agotado");

            System.out.println("Contenido de la bitácora:");
            for (String linea : bitacora.leer()) {
                System.out.println(linea);
            }
            System.out.println("Total de errores: " + bitacora.contar("error"));
        } catch (IOException e) {
            System.out.println("Error al usar la bitácora: " + e.getMessage());
        }
        
        Bitacora inexistente = new Bitacora("noexiste.txt");
        try {
            inexistente.leer();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo noexiste.txt no existe. Verifique el nombre y la ruta.");
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }
}

