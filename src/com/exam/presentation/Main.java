package com.exam.presentation;

import java.util.Scanner;

import com.exam.SwingUI;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                

                System.out.println("\n=== SISTEMA DE EXÁMENES ===");
                System.out.println("1. Ejecutar en Consola");
                System.out.println("2. Ejecutar en Swing (Interfaz gráfica)");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                String opcion = sc.nextLine();

                switch (opcion) {

                    case "1":
                        ejecutarConsola();
                        break;

                    case "2":
                        ejecutarSwing();
                        break;

                    case "3":
                        System.out.println("Saliendo del sistema...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción inválida");
                }
            }
        }
    }

    // Ejecuta modo consola
    private static void ejecutarConsola() {
        try {
            Console console = new Console();
            console.iniciar();
        } catch (Exception e) {
            System.out.println("Error en consola: " + e.getMessage());
        }
    }

    // Ejecuta modo Swing
    private static void ejecutarSwing() {
        try {
            javax.swing.SwingUtilities.invokeLater(() -> {
                new SwingUI();
            });
        } catch (Exception e) {
            System.out.println("Error en Swing: " + e.getMessage());
        }
    }
}