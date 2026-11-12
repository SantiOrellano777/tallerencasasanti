/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SANTIAGO
 */
public class Bitacora {

    private final String ruta;
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Bitacora(String ruta) {
        this.ruta = ruta;
    }

    public void registrar(String mensaje) throws IOException {
        String fecha = LocalDateTime.now().format(formato);
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta, StandardCharsets.UTF_8, true))) {
            pw.println("[" + fecha + "] " + mensaje);
        }
    }
    
    public List<String> leer() throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }
    
    public int contar(String palabra) throws IOException {
        int total = 0;
        for (String linea : leer()) {
            if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                total++;
            }
        }
        return total;
    }
}
