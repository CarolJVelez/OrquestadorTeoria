/*
 * Archivo que contiene el código de
 * la clase ChanceRest
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.rest;

import com.co.sg.ms.common.orchestrate.chance.dto.request.ConfirVentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.chance.dto.request.ParametrosRequest;
import com.co.sg.ms.common.orchestrate.chance.dto.request.ValidVentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.chance.dto.response.ConfirVentaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ValidaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ParametrosBnetResponse;
import com.co.sg.ms.common.orchestrate.chance.services.IChanceService;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.VentaChanceBnetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/*
 * @class ChanceRest
 * @description Clase encargada en la construcción de los servicios rest para Chance.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@RequestMapping("/api/chance")
@RestController
public class ChanceRest {

    @Autowired
    private IChanceService chanceService; //Llamado a los servicios de Chance

    /*
     * @function consultarParametrosBnet
     * @description Servicio rest encargado de consultar los parametros de Bnet.
     * @param {ParametrosRequest} request
     * @return chanceService.consultarParametrosBnet
     */
    @PostMapping("/parametros-bnet")
    public  Mono<ResponseEntity<ParametrosBnetResponse>> consultarParametrosBnet(@RequestBody ParametrosRequest request){

        return chanceService.consultarParametrosBnet(request)
                .map(parametros -> new ResponseEntity<>(parametros, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED));
    }

    /*
     * @function validarChanceBnet
     * @description Servicio rest encargado de validar la pre-venta de Chance.
     * @param {ValidListChanceBnetRequest} request
     * @return chanceService.validarChanceBnet
     */
    @PostMapping("/validar-chance-bnet")
    public  Mono<ResponseEntity<ValidaChanceBnetResponse>> validarChanceBnet(@RequestBody ValidVentaChanceBnetRequest request){

        return chanceService.validarChanceBnet(request)
                .map(validaChance -> new ResponseEntity<>(validaChance, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED));
    }

    /*
     * @function realizarVentaChanceBnet
     * @description Servicio rest encargado de realizar venta de Chance.
     * @param {ListApuestasBnetRequest} request
     * @return chanceService.realizarVentaChanceBnet
     */
    @PostMapping("/venta-chance-bnet")
    public Mono<List<VentaChanceBnetResponse>> realizarVentaChanceBnet(@RequestBody ConfirVentaChanceBnetRequest request){

        return chanceService.realizarVentaChanceBnet(request);
    }

}
