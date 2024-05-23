/*
 * Archivo que contiene el código de
 * la interfaz IChanceService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */
package com.co.sg.ms.common.orchestrate.chance.services;

import com.co.sg.ms.common.orchestrate.chance.dto.request.ConfirVentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.chance.dto.request.ParametrosRequest;
import com.co.sg.ms.common.orchestrate.chance.dto.request.ValidVentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ValidaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ParametrosBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.VentaChanceBnetResponse;
import reactor.core.publisher.Mono;

import java.util.List;

/*
 * @interface IChanceService
 * @description Interfaz encargada de contener todos los servicios de Chance.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
public interface IChanceService {

    public Mono<ParametrosBnetResponse> consultarParametrosBnet(ParametrosRequest data);

    public Mono<ValidaChanceBnetResponse> validarChanceBnet(ValidVentaChanceBnetRequest data);

    public Mono<List<VentaChanceBnetResponse>> realizarVentaChanceBnet(ConfirVentaChanceBnetRequest data);

}
