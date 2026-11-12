/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.poo.practicas.modelo.tallerencasasanti;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
/**
 *
 * @author SANTIAGO
 */
public class Tallerencasasanti {
    
    
    interface Llamable {
    void llamar(String numero);
    void colgar();
    default String funcion() { return "Llamadas"; }
    }
    
    interface Fotografiable {
    void tomarFoto();
    int getMegapixeles();
    default String funcion() { return "Fotografía"; }
    }
    
    abstract class Dispositivo {
    protected String marca;
    protected String modelo;
    protected double precio;

    public Dispositivo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    
    protected String precioFormateado() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.US);
        simbolos.setGroupingSeparator('.');
        return new DecimalFormat("#,##0", simbolos).format(precio);
    }

    public abstract void describir();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

//santi orellano guerrero prueba
