/*
 * Logic.java
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

/**
 * Clase que coordina la ejecución de los tests de regresión lineal.
 * Maneja la lectura de datos y la invocación de los cálculos.
 * 
 * @version 2.0.1 26/11/2025
 * @author Bridget Mendez
 */
public class Logic {

    private static final double XK_VALUE = 386.0;

    /**
     * Constructor por defecto.
     */
    public Logic() {
    }

    /**
     * Ejecuta el Test 1: regresión entre tamaño estimado y tamaño real.
     */
    public void ejecutarTest1() {
        Data dataX = new Data();
        Data dataY = new Data();
        
        Input input = new Input();
        input.readData("estimeted.txt", dataX);
        input.readData("actualAdded.txt", dataY);

        procesarDatos(dataX, dataY, XK_VALUE, "Tamaño Estimado", "Tamaño Real");
    }

    /**
     * Ejecuta el Test 2: regresión entre tamaño estimado y tiempo de desarrollo.
     */
    public void ejecutarTest2() {
        Data dataX = new Data();
        Data dataY = new Data();
        
        Input input = new Input();
        input.readData("estimeted.txt", dataX);
        input.readData("actualDevelop.txt", dataY);

        procesarDatos(dataX, dataY, XK_VALUE, "Tamaño Estimado", "Tiempo de Desarrollo");
    }

    /**
     * Ejecuta el Test 3: regresión entre tamaño planeado y tamaño real.
     */
    public void ejecutarTest3() {
        Data dataX = new Data();
        Data dataY = new Data();
        
        Input input = new Input();
        input.readData("planAdded.txt", dataX);
        input.readData("actualAdded.txt", dataY);

        procesarDatos(dataX, dataY, XK_VALUE, "Tamaño Planeado", "Tamaño Real");
    }

    /**
     * Ejecuta el Test 4: regresión entre tamaño planeado y tiempo de desarrollo.
     */
    public void ejecutarTest4() {
        Data dataX = new Data();
        Data dataY = new Data();
        
        Input input = new Input();
        input.readData("planAdded.txt", dataX);
        input.readData("actualDevelop.txt", dataY);

        procesarDatos(dataX, dataY, XK_VALUE, "Tamaño Planeado", "Tiempo de Desarrollo");
    }

    /**
     * Procesa los datos y calcula la regresión lineal y correlación.
     * 
     * @param dataX datos del eje X
     * @param dataY datos del eje Y
     * @param xk valor de xk para la predicción
     * @param labelX etiqueta para el eje X
     * @param labelY etiqueta para el eje Y
     */
    private void procesarDatos(Data dataX, Data dataY, double xk, 
                               String labelX, String labelY) {
        EstimacionCorLineal estimacion = new EstimacionCorLineal();
        
        String[] arrDataX = dataX.getAllData();
        String[] arrDataY = dataY.getAllData();

        estimacion.calcularParametros(arrDataX, arrDataY);

        mostrarResultados(estimacion, xk, labelX, labelY);
    }

    /**
     * Muestra los resultados de los cálculos en consola.
     * 
     * @param estimacion objeto con los cálculos realizados
     * @param xk valor de xk usado para la predicción
     * @param labelX etiqueta para el eje X
     * @param labelY etiqueta para el eje Y
     */
    private void mostrarResultados(EstimacionCorLineal estimacion, double xk,
                                   String labelX, String labelY) {
        System.out.println("\nDatos de entrada:");
        System.out.println("  Variable X: " + labelX);
        System.out.println("  Variable Y: " + labelY);
        System.out.println("  Valor xk: " + xk);

        System.out.println("\nParámetros de regresión:");
        System.out.printf("  B0 = %.4f\n", estimacion.getDblB0());
        System.out.printf("  B1 = %.4f\n", estimacion.getDblB1());

        System.out.println("\nCoeficientes de correlación:");
        System.out.printf("  rxy = %.4f\n", estimacion.getDblRXY());
        System.out.printf("  r² = %.4f\n", estimacion.getDblR());

        System.out.println("\nPredicción:");
        System.out.printf("  yk = %.4f\n", estimacion.getDblYk());

        evaluarCorrelacion(estimacion.getDblR());
    }

    /**
     * Evalúa y muestra la calidad de la correlación.
     * 
     * @param r2 coeficiente de determinación (r²)
     */
    private void evaluarCorrelacion(double r2) {
        System.out.println("\nEvaluación de la correlación:");
        
        if (r2 >= 0.9) {
            System.out.println("  ✓ Excelente: La relación es altamente predictiva");
        } else if (r2 >= 0.7) {
            System.out.println("  ✓ Buena: La relación es fuerte y útil para planificación");
        } else if (r2 >= 0.5) {
            System.out.println("  ! Aceptable: Usar con precaución para planificación");
        } else {
            System.out.println("  ✗ Pobre: No confiable para planificación");
        }
    }
}
