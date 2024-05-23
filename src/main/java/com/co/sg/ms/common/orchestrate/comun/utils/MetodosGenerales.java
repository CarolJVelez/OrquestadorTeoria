/*
 * Archivo que contiene el código de
 * la clase MetodosGenerales
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.utils;

/*
 * @class MetodosGenerales
 * @description Clase encargada de contener los metodos generales.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
public class MetodosGenerales {

    public static int eliminarPunto(String valor){
        String valorsinPunto = valor.replace(".", "");
        int resultado = Integer.parseInt(valorsinPunto);
        return resultado;

    }
}
