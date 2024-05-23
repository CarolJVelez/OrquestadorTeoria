/*
 * Archivo que contiene el código de
 * la clase ParametrosBnetRequest
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */
package com.co.sg.ms.common.orchestrate.providers.codesa.dto.request;

import lombok.Data;

/*
 * @class ParametrosBnetRequest
 * @description Clase que almacena la información de la petición para consultar los parametros de bnet.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class ParametrosBnetRequest {

  private String  semanario;
  private String fechaSorteo;

}
