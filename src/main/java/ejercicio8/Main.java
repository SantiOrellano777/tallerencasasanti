/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria("Cliente", 500000);
        int opcion = 0;

        try {
            do {
                System.out.println("1. Consultar 2. Depositar 3. Retirar 4. Salir");
                System.out.print("Opción: ");
                try {
                    opcion = Integer.parseInt(sc.nextLine().trim());

                    switch (opcion) {
                        case 1:
                            System.out.println("Titular: " + cuenta.getTitular()
                                    + " - Saldo: $" + CuentaBancaria.formato(cuenta.getSaldo()));
                            break;
                        case 2:
                            System.out.print("Monto a depositar: ");
                            double deposito = Double.parseDouble(sc.nextLine().trim());
                            cuenta.depositar(deposito);
                            System.out.println("Depósito exitoso. Nuevo saldo: $"
                                    + CuentaBancaria.formato(cuenta.getSaldo()));
                            break;
                        case 3:
                            System.out.print("Monto a retirar: ");
                            double retiro = Double.parseDouble(sc.nextLine().trim());
                            cuenta.retirar(retiro);
                            System.out.println("Retiro exitoso. Nuevo saldo: $"
                                    + CuentaBancaria.formato(cuenta.getSaldo()));
                            break;
                        case 4:
                            System.out.println("Gracias por usar el cajero.");
                            break;
                        default:
                            System.out.println("Opción no válida. Elija entre 1 y 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un número.");
                    opcion = 0; // para que el menú se repita
                } catch (SaldoInsuficienteException e) {
                    System.out.println(e.getMessage());
                } catch (MontoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            } while (opcion != 4);
        } finally {
            sc.close();
        }
    }
}
