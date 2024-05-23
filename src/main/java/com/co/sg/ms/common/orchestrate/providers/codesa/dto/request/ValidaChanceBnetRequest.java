/*
 * Archivo que contiene el código de
 * la clase ValidaChanceBnetRequest
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

import java.util.ArrayList;

/*
 * @class ValidaChanceBnetRequest
 * @description Clase que almacena la información de la petición para validar la pre-venta de Chance.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class ValidaChanceBnetRequest {

    private ArrayList<String> numeros;
    private ArrayList<Loteria> loterias;
    private ArrayList<Long> codigosModalidades;
    private int valor;
    private boolean semanario;
    private boolean distribucion;
    private String fechaSorteo;
    private int subProductoId;

    @Data
    public static class Loteria {
        private String codigo;
        private String fechaSorteo;
    }
}
