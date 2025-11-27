/*
 * App.java
 *
 * Copyright (c) 2025 Bridget Mendez. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Bridget Mendez.
 * ("Confidential Information"). You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license agreement you
 * entered into with Bridget Mendez.
 *
 * Bridget Mendez MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 * Bridget Mendez SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A
 * RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

import java.util.Scanner;

/**
 * Clase principal que ejecuta los cálculos de regresión lineal y correlación.
 * Implementa el Programa 3 del PSP (Personal Software Process).
 * 
 * @version 2.0.1 26/11/2025
 * @author Bridget Mendez
 */
public class App {

    /**
     * Constructor por defecto.
     */
    public App() {
    }

    /**
     * Punto de entrada principal del programa.
     * Muestra un menú para seleccionar qué tipo de cálculo realizar.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("==============================================");
        System.out.println("  Programa de Regresión Lineal y Correlación");
        System.out.println("  PSP - Programa 3");
        System.out.println("  Versión 2.0.1");
        System.out.println("==============================================\n");

        while (continuar) {
            mostrarMenu();
            
            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    ejecutarTest1();
                    break;
                case 2:
                    ejecutarTest2();
                    break;
                case 3:
                    ejecutarTest3();
                    break;
                case 4:
                    ejecutarTest4();
                    break;
                case 5:
                    ejecutarTodosLosTests();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\nGracias por usar el programa. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor intente de nuevo.\n");
            }
        }

        scanner.close();
    }

    /**
     * Muestra el menú principal del programa.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Test 1: Tamaño estimado vs Tamaño real");
        System.out.println("2. Test 2: Tamaño estimado vs Tiempo de desarrollo");
        System.out.println("3. Test 3: Tamaño planeado vs Tamaño real");
        System.out.println("4. Test 4: Tamaño planeado vs Tiempo de desarrollo");
        System.out.println("5. Ejecutar todos los tests");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    /**
     * Lee y valida la opción seleccionada por el usuario.
     * 
     * @param scanner objeto Scanner para leer la entrada
     * @return la opción seleccionada
     */
    private static int leerOpcion(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Ejecuta el Test 1: Regresión entre tamaño estimado y tamaño real.
     */
    private static void ejecutarTest1() {
        System.out.println("\n=== TEST 1: Tamaño Estimado vs Tamaño Real ===");
        
        Logic logic = new Logic();
        logic.ejecutarTest1();
    }

    /**
     * Ejecuta el Test 2: Regresión entre tamaño estimado y tiempo de desarrollo.
     */
    private static void ejecutarTest2() {
        System.out.println("\n=== TEST 2: Tamaño Estimado vs Tiempo de Desarrollo ===");
        
        Logic logic = new Logic();
        logic.ejecutarTest2();
    }

    /**
     * Ejecuta el Test 3: Regresión entre tamaño planeado y tamaño real.
     */
    private static void ejecutarTest3() {
        System.out.println("\n=== TEST 3: Tamaño Planeado vs Tamaño Real ===");
        
        Logic logic = new Logic();
        logic.ejecutarTest3();
    }

    /**
     * Ejecuta el Test 4: Regresión entre tamaño planeado y tiempo de desarrollo.
     */
    private static void ejecutarTest4() {
        System.out.println("\n=== TEST 4: Tamaño Planeado vs Tiempo de Desarrollo ===");
        
        Logic logic = new Logic();
        logic.ejecutarTest4();
    }

    /**
     * Ejecuta todos los tests de forma secuencial.
     */
    private static void ejecutarTodosLosTests() {
        System.out.println("\n=== EJECUTANDO TODOS LOS TESTS ===\n");
        
        ejecutarTest1();
        ejecutarTest2();
        ejecutarTest3();
        ejecutarTest4();
        
        System.out.println("\n=== TODOS LOS TESTS COMPLETADOS ===");
    }
}
