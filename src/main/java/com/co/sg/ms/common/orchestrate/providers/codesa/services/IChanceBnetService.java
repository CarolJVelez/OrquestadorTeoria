/*
 * Archivo que contiene el código de
 * la interfaz IChanceBnetService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */
package com.co.sg.ms.common.orchestrate.providers.codesa.services;

import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.ParametrosBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.ValidaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.VentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ParametrosBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ValidaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.VentaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.LoginRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.LoginResponse;
import reactor.core.publisher.Mono;

/*
 * @interface IChanceBnetService
 * @description Interfaz que almacena los servicios de Chance en SuperFlex.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
public interface IChanceBnetService {

    public Mono<ParametrosBnetResponse> consultarParametrosBnet(ParametrosBnetRequest data);

    public Mono<ValidaChanceBnetResponse> validarChanceBnet(ValidaChanceBnetRequest data);

    public Mono<VentaChanceBnetResponse> realizarVentaChanceBnet(VentaChanceBnetRequest data);

}
