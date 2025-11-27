/*
 * Input.java
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
 *clase encargada de la lectura de datos de entrada desde un archivo.
 *Lee linea por linea y almacena los satos en un contenedor Data.
 *@1.0 04/11/2025
 *Bridget Mendez 
 */
public class Input {
        // Campos de la clase
    private String data;
    private java.io.BufferedReader br;
    /**
     * Constructor por defecto.
     */
    public Input() {
    }
    /**
     * Lee los datos de un archivo y los guarda en el contenedor proporcionado.
     * @param fileName el nombre del archivo a leer
     * @param dataContainer el objeto Data donde se almacenarÃ¡n las lÃ­neas leÃ­das
     */
    public void readData(String fileName, Data dataContainer) {
        try {
            br = new java.io.BufferedReader(new java.io.FileReader(fileName));
            while ((data = br.readLine()) != null) {
                dataContainer.saveData(data);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
