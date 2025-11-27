/*
 * TestProgram.java
 *
 * Copyright (c) 2025 Bridget Mendez. All Rights Reserved.
 *
 * Programa de prueba para verificar los cálculos de regresión.
 * 
 * @version 2.0.1 26/11/2025
 * @author Bridget Mendez
 */

/**
 * Clase de prueba para verificar los cálculos de regresión lineal.
 */
public class TestProgram {

    /**
     * Ejecuta pruebas básicas de los cálculos.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  TEST DE REGRESIÓN LINEAL Y CORRELACIÓN");
        System.out.println("  Versión 2.0.1 - 26/11/2025");
        System.out.println("==============================================\n");

        testCalculosBasicos();
        testLecturaArchivos();
        testTodosLosTests();
    }

    /**
     * Prueba los cálculos básicos con datos de ejemplo.
     */
    private static void testCalculosBasicos() {
        System.out.println("--- Test 1: Cálculos Básicos ---");
        
        String[] dataX = {"130", "650", "99", "150", "128", "302", "95", "945", "368", "961"};
        String[] dataY = {"186", "699", "132", "272", "291", "331", "199", "1890", "788", "1601"};

        EstimacionCorLineal est = new EstimacionCorLineal();
        est.calcularParametros(dataX, dataY);
        est.setDblXk(386.0);

        System.out.printf("  β0 = %.4f (esperado: -22.55)\n", est.getDblB0());
        System.out.printf("  β1 = %.4f (esperado: 1.7279)\n", est.getDblB1());
        System.out.printf("  rxy = %.4f (esperado: 0.9545)\n", est.getDblRXY());
        System.out.printf("  r² = %.4f (esperado: 0.9111)\n", est.getDblR());
        System.out.printf("  yk = %.4f (esperado: 644.429)\n", est.getDblYk());
        
        verificarResultado(est.getDblB0(), -22.55, "β0");
        verificarResultado(est.getDblB1(), 1.7279, "β1");
        verificarResultado(est.getDblRXY(), 0.9545, "rxy");
        verificarResultado(est.getDblR(), 0.9111, "r²");
        verificarResultado(est.getDblYk(), 644.429, "yk");
        
        System.out.println("  ✓ Test completado\n");
    }

    /**
     * Prueba la lectura de archivos.
     */
    private static void testLecturaArchivos() {
        System.out.println("--- Test 2: Lectura de Archivos ---");
        
        try {
            Data dataX = new Data();
            Input input = new Input();
            input.readData("estimeted.txt", dataX);
            
            String[] valores = dataX.getAllData();
            System.out.println("  Archivo leído correctamente");
            System.out.println("  Número de valores: " + valores.length);
            System.out.println("  Primer valor: " + valores[0]);
            System.out.println("  Último valor: " + valores[valores.length - 1]);
            System.out.println("  ✓ Test completado\n");
        } catch (Exception e) {
            System.out.println("  ✗ Error al leer archivo: " + e.getMessage());
            System.out.println();
        }
    }

    /**
     * Ejecuta todos los tests del programa principal.
     */
    private static void testTodosLosTests() {
        System.out.println("--- Test 3: Ejecución de Todos los Tests ---");
        
        Logic logic = new Logic();
        
        System.out.println("\nTest 1:");
        logic.ejecutarTest1();
        
        System.out.println("\nTest 2:");
        logic.ejecutarTest2();
        
        System.out.println("\nTest 3:");
        logic.ejecutarTest3();
        
        System.out.println("\nTest 4:");
        logic.ejecutarTest4();
        
        System.out.println("\n  ✓ Todos los tests completados");
    }

    /**
     * Verifica que un resultado esté dentro del margen de error aceptable.
     * 
     * @param calculado valor calculado
     * @param esperado valor esperado
     * @param nombre nombre del parámetro
     */
    private static void verificarResultado(double calculado, double esperado, String nombre) {
        double margenError = 0.01;
        double diferencia = Math.abs(calculado - esperado);
        
        if (diferencia <= margenError) {
            System.out.println("  ✓ " + nombre + " correcto");
        } else {
            System.out.println("  ✗ " + nombre + " incorrecto (diferencia: " + diferencia + ")");
        }
    }
}
