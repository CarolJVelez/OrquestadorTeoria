/*
 * Archivo que contiene el código de
 * la clase ParametrosRequest
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.dto.request;

import lombok.Data;

/*
 * @class ParametrosRequest
 * @description Clase encargada de contener los datos para la consulta de parametros de Bnet.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class ParametrosRequest {

    private String numeroDocumento; //Numero de documento del usuario.
    private String latitud; //Latitud (Georreferencia)
    private String longitud; //Longitud (Georreferencia)

}
