/*
 * Archivo que contiene el código de
 * la clase LoginResponse
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */
package com.co.sg.ms.common.orchestrate.providers.codesa.dto.response;

import lombok.Data;

/*
 * @class LoginResponse
 * @description Clase que almacena la información de la respuesta del login.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */

@Data
public class LoginResponse {

    private String jwt;
    private boolean cambiaClave;
    private String impresoras;
    private String mensajeServicio;
    private String direccionMac;
    private boolean asesorPrepago;
    private boolean habilitaSeguroEnVenta;
    private String nombreDepartamento;
    private int equipoId;
    private int usuarioId;
    private String jwtFechaVencimiento;
    private String fechaServidor;
    private String horaServidor;
    private SuperGirosResponse superGirosResponse;
    private String superGirosXsrfToken;
    private String isSuperGirosLoginOk;

    @Data
    public static class SuperGirosResponse{
        private String localizedMessage;
        private String readableMsg;
        private int httpCode;
        private String glicExceptionCode;
    }

}
