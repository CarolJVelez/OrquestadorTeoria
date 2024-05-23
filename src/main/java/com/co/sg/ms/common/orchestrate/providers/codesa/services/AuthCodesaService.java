/*
 * Archivo que contiene el código de
 * la clase AuthCodesaService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */
package com.co.sg.ms.common.orchestrate.providers.codesa.services;

import com.co.sg.ms.common.orchestrate.comun.entities.DetallesConexion;
import com.co.sg.ms.common.orchestrate.comun.services.IDetalleConexionService;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.LoginRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
 * @class AuthCodesaService
 * @description Clase que almacena los servicios de autenticación de Codesa.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Service
public class AuthCodesaService implements IAuthCodesaService{

    private final WebClient webClient;
    private final IDetalleConexionService detalleConexionService;

    @Autowired
    public AuthCodesaService(WebClient.Builder webClientBuilder, IDetalleConexionService detalleConexionService) {
        this.webClient = webClientBuilder.build();
        this.detalleConexionService = detalleConexionService;

    }

    @Override
    public Mono<LoginResponse> iniciarloginCodesa() {

        LoginRequest loginRequest = obtenerDetallesConexion();

        return webClient.post()
                .uri("https://dev-superflex-me.codesa.com.co/mt-api/api-ms-usuario/autenticacion")
                .bodyValue(loginRequest)
                .retrieve()
                .bodyToMono(LoginResponse.class);
    }

    public LoginRequest obtenerDetallesConexion() {
        DetallesConexion detallesConexion =  detalleConexionService.obtenerDetallesConexion();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setTecnologiaId(detallesConexion.getTecnologiaId());
        String[] macs = new String[]{detallesConexion.getMacs()};
        loginRequest.setMacs(macs);
        loginRequest.setPassword(detallesConexion.getPassword());
        loginRequest.setUsuario(detallesConexion.getUsuario());
        return loginRequest;
    }

}
