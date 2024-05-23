/*
 * Archivo que contiene el código de
 * la clase ChanceBnetService
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
import com.co.sg.ms.common.orchestrate.comun.services.IDetalleConexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
 * @class ChanceBnetService
 * @description Clase que almacena los servicios de Chance en SuperFlex.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Service
public class ChanceBnetService implements IChanceBnetService{

    private final WebClient webClient;
    private String token;
    private IDetalleConexionService detalleConexionService;

    @Autowired
    private IAuthCodesaService authCodesaService;

    @Autowired
    public ChanceBnetService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<ParametrosBnetResponse> consultarParametrosBnet(ParametrosBnetRequest data) {

        return authCodesaService.iniciarloginCodesa().doOnNext(loginResponse -> {
                    token = loginResponse.getJwt();
                })
                .flatMap(loginResponse -> webClient.post()
                        .uri("https://dev-superflex-me.codesa.com.co/mt-api/api-ms-apuestas/chance/parametros-bnet")
                        .header("Authorization", "Bearer " + token)
                        .bodyValue(data)
                        .retrieve()
                        .bodyToMono(ParametrosBnetResponse.class));
    }

    @Override
    public Mono<ValidaChanceBnetResponse> validarChanceBnet(ValidaChanceBnetRequest data) {
        return webClient.post()
                .uri("https://dev-superflex-me.codesa.com.co/mt-api/api-ms-apuestas/chance/validar-chance-bnet")
                .header("Authorization", "Bearer " + token)
                .bodyValue(data)
                .retrieve()
                .bodyToMono(ValidaChanceBnetResponse.class);
    }

    @Override
    public Mono<VentaChanceBnetResponse> realizarVentaChanceBnet(VentaChanceBnetRequest request) {
        Mono<VentaChanceBnetResponse>ventaChance = webClient.post()
                .uri("https://dev-superflex-me.codesa.com.co/mt-api/api-ms-apuestas/chance/venta-chance-bnet")
                .header("Authorization", "Bearer " + token)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(VentaChanceBnetResponse.class);
        return ventaChance;
    }

}
