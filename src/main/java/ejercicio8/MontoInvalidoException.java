/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

public class MontoInvalidoException extends Exception {

    public MontoInvalidoException(double monto) {
        super("Monto inválido: " + monto + ". Debe ser mayor que cero.");
    }
}
