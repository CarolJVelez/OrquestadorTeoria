/*
 * Archivo que contiene el código de
 * la clase LoginRequest
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
 * @class LoginRequest
 * @description Clase que almacena la información necesaria para realizar un login.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class LoginRequest {

    private String usuario; // Usuario con el cual se va inicar sesion.

    private String password; // Contraseña para iniciar sesion.

    private String[] macs; //MACS para iniciar sesión.

    private Integer tecnologiaId; // TecnologiaId para iniciar sesion

}
