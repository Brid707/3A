/*
 * Output.java
 *
 * Copyright (c) 2025 Bridget Mendez. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Bridget Mendez.
 * ("Confidential Information"). You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license agreement you
 * entered into with Bridget Mendez.
 *
 * BRIDGET MENDEZ MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 * NOMBRE APELLIDO SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A
 * RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
import java.io.*;
import java.util.*;

 /**
 * Clase para manejar la salida de datos a un archivo.
 *
 * @version 1.0 04/11/2025
 * @author Bridget Mendez
 */
public class OutPut {
    /**
     * Constructor por defecto.
     */
    public OutPut() {
    }
    /**
     * Escribe el texto de salida especificado en un archivo.
     * @param outFile el nombre del archivo de salida
     * @param outText el texto que se escribirÃ¡ en el archivo
     */
    public void writeData(String outFile, String outText) {
        try {
            FileWriter fw = new FileWriter(outFile);
            fw.write(outText);
            fw.close();
        } catch (IOException e) {
            System.err.println("Error escribiendo el archivo de salida: " + e.getMessage());
        }
    }
}
