/*
 * Archivo que contiene el código de
 * la clase FechaUtils
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * @class FechaUtils
 * @description Clase encargada de contener los formatos de la fecha y consultar la fecha actual.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
public class FechaUtils {

    private static final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");

    public static String consultarHoraActual(){
        LocalDateTime hora = LocalDateTime.now();
        return hora.format(formatoHora);
    }

    public static String getCurrentEpochTime() {
        return Long.toString( System.currentTimeMillis());
    }

    public static String  consularFechaActual(){
        Date todayDate = new Date();
        return formatofecha.format(todayDate);
    }

}
