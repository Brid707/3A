/*
 * EstimacionCorLineal.java
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
 * Clase para calcular parámetros de regresión lineal y correlación.
 * Implementa los métodos necesarios para PROBE del PSP.
 * 
 * @version 2.0.1 26/11/2025
 * @author Bridget Mendez
 */
public class EstimacionCorLineal {

    private double dblSumX;
    private double dblSumY;
    private double dblSumXY;
    private double dblSumXX;
    private double dblSumYY;
    private double dblAvgX;
    private double dblAvgY;
    private int intN;
    private double dblB1;
    private double dblRXY;
    private double dblB0;
    private double dblR;
    private double dblXk;
    private double dblYk;

    /**
     * Constructor por defecto.
     */
    public EstimacionCorLineal() {
        this.intN = 0;
        this.dblSumX = 0.0;
        this.dblSumY = 0.0;
        this.dblSumXY = 0.0;
        this.dblSumXX = 0.0;
        this.dblSumYY = 0.0;
    }

    /**
     * Calcula todos los parámetros de regresión y correlación.
     * 
     * @param dataX arreglo de valores X como cadenas
     * @param dataY arreglo de valores Y como cadenas
     */
    public void calcularParametros(String[] dataX, String[] dataY) {
        if (dataX.length != dataY.length) {
            throw new IllegalArgumentException(
                "Los arreglos deben tener la misma longitud");
        }

        this.intN = dataX.length;

        sumX(dataX);
        sumY(dataY);
        sumXY(dataX, dataY);
        sumXX(dataX);
        sumYY(dataY);

        getAvgX();
        getAvgY();

        getB1();
        getB0();
        getRXY();
        getR();
    }

    /**
     * Calcula la predicción yk para un valor xk dado.
     * 
     * @param xk valor de x para predecir y
     * @return el valor predicho yk
     */
    public double predecir(double xk) {
        this.dblXk = xk;
        getYk();
        return this.dblYk;
    }

    /**
     * Calcula la suma de los valores X.
     * 
     * @param datalist arreglo de valores como cadenas
     */
    private void sumX(String[] datalist) {
        this.dblSumX = 0.0;
        for (String valor : datalist) {
            try {
                this.dblSumX += Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.err.println("Error al parsear valor X: " + valor);
            }
        }
    }

    /**
     * Calcula la suma de los valores Y.
     * 
     * @param datalist arreglo de valores como cadenas
     */
    private void sumY(String[] datalist) {
        this.dblSumY = 0.0;
        for (String valor : datalist) {
            try {
                this.dblSumY += Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.err.println("Error al parsear valor Y: " + valor);
            }
        }
    }

    /**
     * Calcula la suma de los productos X*Y.
     * 
     * @param datalistX arreglo de valores X
     * @param datalistY arreglo de valores Y
     */
    private void sumXY(String[] datalistX, String[] datalistY) {
        this.dblSumXY = 0.0;
        for (int i = 0; i < datalistX.length; i++) {
            try {
                double x = Double.parseDouble(datalistX[i]);
                double y = Double.parseDouble(datalistY[i]);
                this.dblSumXY += (x * y);
            } catch (NumberFormatException e) {
                System.err.println("Error al calcular XY en posición " + i);
            }
        }
    }

    /**
     * Calcula la suma de los cuadrados de X.
     * 
     * @param datalist arreglo de valores X
     */
    private void sumXX(String[] datalist) {
        this.dblSumXX = 0.0;
        for (String valor : datalist) {
            try {
                double x = Double.parseDouble(valor);
                this.dblSumXX += (x * x);
            } catch (NumberFormatException e) {
                System.err.println("Error al calcular XX: " + valor);
            }
        }
    }

    /**
     * Calcula la suma de los cuadrados de Y.
     * 
     * @param datalist arreglo de valores Y
     */
    private void sumYY(String[] datalist) {
        this.dblSumYY = 0.0;
        for (String valor : datalist) {
            try {
                double y = Double.parseDouble(valor);
                this.dblSumYY += (y * y);
            } catch (NumberFormatException e) {
                System.err.println("Error al calcular YY: " + valor);
            }
        }
    }

    /**
     * Calcula el promedio de X.
     */
    private void getAvgX() {
        if (this.intN > 0) {
            this.dblAvgX = this.dblSumX / this.intN;
        } else {
            this.dblAvgX = 0.0;
        }
    }

    /**
     * Calcula el promedio de Y.
     */
    private void getAvgY() {
        if (this.intN > 0) {
            this.dblAvgY = this.dblSumY / this.intN;
        } else {
            this.dblAvgY = 0.0;
        }
    }

    /**
     * Calcula el parámetro β1 (pendiente) de la regresión.
     */
    private void getB1() {
        double numerador = this.dblSumXY - (this.intN * this.dblAvgX * this.dblAvgY);
        double denominador = this.dblSumXX - (this.intN * this.dblAvgX * this.dblAvgX);
        
        if (denominador != 0.0) {
            this.dblB1 = numerador / denominador;
        } else {
            this.dblB1 = 0.0;
            System.err.println("Advertencia: denominador cero en cálculo de β1");
        }
    }

    /**
     * Calcula el parámetro β0 (intercepto) de la regresión.
     */
    private void getB0() {
        this.dblB0 = this.dblAvgY - (this.dblB1 * this.dblAvgX);
    }

    /**
     * Calcula el coeficiente de correlación rxy.
     */
    private void getRXY() {
        double numerador = (this.intN * this.dblSumXY) - (this.dblSumX * this.dblSumY);
        
        double termX = (this.intN * this.dblSumXX) - (this.dblSumX * this.dblSumX);
        double termY = (this.intN * this.dblSumYY) - (this.dblSumY * this.dblSumY);
        double denominador = Math.sqrt(termX * termY);
        
        if (denominador != 0.0) {
            this.dblRXY = numerador / denominador;
        } else {
            this.dblRXY = 0.0;
            System.err.println("Advertencia: denominador cero en cálculo de rxy");
        }
    }

    /**
     * Calcula el coeficiente de determinación r² (r cuadrado).
     */
    private void getR() {
        this.dblR = this.dblRXY * this.dblRXY;
    }

    /**
     * Calcula el valor predicho yk dado xk.
     */
    private void getYk() {
        this.dblYk = this.dblB0 + (this.dblB1 * this.dblXk);
    }

    /**
     * Obtiene el valor de β0.
     * 
     * @return el valor de β0
     */
    public double getDblB0() {
        return dblB0;
    }

    /**
     * Obtiene el valor de β1.
     * 
     * @return el valor de β1
     */
    public double getDblB1() {
        return dblB1;
    }

    /**
     * Obtiene el coeficiente de correlación rxy.
     * 
     * @return el valor de rxy
     */
    public double getDblRXY() {
        return dblRXY;
    }

    /**
     * Obtiene el coeficiente de determinación r².
     * 
     * @return el valor de r²
     */
    public double getDblR() {
        return dblR;
    }

    /**
     * Obtiene el valor predicho yk.
     * 
     * @return el valor de yk
     */
    public double getDblYk() {
        return dblYk;
    }

    /**
     * Establece el valor de xk.
     * 
     * @param xk el nuevo valor de xk
     */
    public void setDblXk(double xk) {
        this.dblXk = xk;
        getYk();
    }

    /**
     * Obtiene el promedio de X.
     * 
     * @return el promedio de X
     */
    public double getDblAvgX() {
        return dblAvgX;
    }

    /**
     * Obtiene el promedio de Y.
     * 
     * @return el promedio de Y
     */
    public double getDblAvgY() {
        return dblAvgY;
    }

    /**
     * Obtiene el número de puntos de datos.
     * 
     * @return el número de puntos
     */
    public int getIntN() {
        return intN;
    }
}
