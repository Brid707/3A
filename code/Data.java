/*
 * Data.java
 *
 * Copyright (c) 2025 Bridget Mendez. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Bridget Men>
 * ("Confidential Information"). You shall not disclose such Confidential Infor>
 * and shall use it only in accordance with the terms of the license agreement >
 * entered into with Bridget Mendez.
 *
 * Bridget Mendez MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY >
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IM>
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFR>
 * NOMBRE APELLIDO SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A
 * RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

import java.io.*;
import java.util.*;
/**
 *clase para almacenar las lineas de datos leidas de un archivo.
 *Proporciona metodos para guardar datos y recuperarlos.
 *@1.0 04/11/2025
 *Bridget Mendez 
 */

public class Data {
    private List<String> dataList;

    /**
     * Constructor por defecto
     */
    public Data() {
        dataList = new ArrayList<String>();
    }

    /**
     * Guarda una linea de datos dentro de la lista.
     * @param newData la nueva linea de datos a guardar
     */
    public void saveData(String newData) {
        dataList.add(newData);
    }

    /**
     * Devuelve todos los datos guardados en un arreglo de cadenas.
     */
    public String[] getAllData() {
        String[] arr = new String[dataList.size()];
        arr = dataList.toArray(arr);
        return arr;
    }
    /**
     * Elimina todos los datos almacenados.
     */
    public void clearData() {
        dataList.clear();
    }
}
