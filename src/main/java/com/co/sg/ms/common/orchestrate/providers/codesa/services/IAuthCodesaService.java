/*
 * Archivo que contiene el código de
 * la interfaz IAuthCodesaService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */
package com.co.sg.ms.common.orchestrate.providers.codesa.services;

import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.LoginResponse;
import reactor.core.publisher.Mono;

/*
 * @interface IAuthCodesaService
 * @description Interfaz que almacena los servicios de autenticación de Codesa.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
public interface IAuthCodesaService {

    public Mono<LoginResponse> iniciarloginCodesa();
}
