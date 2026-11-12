/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.practicas.modelo.ejercicio4;

/**
 *
 * @author SANTIAGO
 */


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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

class Smartphone extends Dispositivo implements Llamable, Fotografiable {
    private int megapixeles;

    public Smartphone(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
    }

    @Override
    public String funcion() {
        return "Llamadas y fotografía";
    }

    @Override
    public void describir() {
        System.out.println("Smartphone " + marca + " " + modelo
                + " - $" + precioFormateado() + " - " + funcion());
    }

    @Override
    public void llamar(String numero) {
        System.out.println(marca + " llamando a " + numero);
    }

    @Override
    public void colgar() {
        System.out.println(marca + " finalizó la llamada");
    }

    @Override
    public void tomarFoto() {
        System.out.println(marca + " tomó una foto de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
    }
}

class Camara extends Dispositivo implements Fotografiable {
    private int megapixeles;

    public Camara(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
    }

    @Override
    public void describir() {
        System.out.println("Cámara " + marca + " " + modelo
                + " - $" + precioFormateado() + " - " + funcion());
    }

    @Override
    public void tomarFoto() {
        System.out.println(marca + " tomó una foto profesional de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
    }
}

public class Mainclass {
    public static void main(String[] args) {
        Dispositivo[] dispositivos = {
            new Smartphone("Samsung", "Galaxy S24", 3500000, 50),
            new Smartphone("Xiaomi", "Mi 10", 2200000, 108),
            new Camara("Canon", "EOS R50", 4200000, 24)
        };

        int mayor = 0;

        for (Dispositivo d : dispositivos) {
            d.describir();

            if (d instanceof Fotografiable) {
                Fotografiable f = (Fotografiable) d;
                f.tomarFoto();
                if (f.getMegapixeles() > mayor) {
                    mayor = f.getMegapixeles();
                }
            }

            if (d instanceof Llamable) {
                Llamable l = (Llamable) d;
                l.llamar("3001234567");
                l.colgar();
            }
            System.out.println();
        }

        System.out.println("Mayor resolución: " + mayor + " MP");
    }
}
