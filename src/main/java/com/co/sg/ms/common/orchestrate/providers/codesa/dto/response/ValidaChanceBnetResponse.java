/*
 * Archivo que contiene el código de
 * la clase ValidaChanceBnetResponse
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @class ValidaChanceBnetResponse
 * @description Clase que almacena la información de la respuesta de la pre-venta de Chance.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class ValidaChanceBnetResponse {

    public ArrayList<ListApuesta> listApuestas;
    public ArrayList<String> loterias;
    public ArrayList<String> productos;
    public int numeroLoterias;

    @Data
    public static class ListApuesta{
        private int apuestaId;
        private String numero;
        private Object colilla;
        private double valorDirecto;
        private double valorCombinado;
        private double valorPata;
        private double valorUna;
        private double valorTotal;
        private Object valorFijoDirectoId;
        private Object valorFijoCombinadoId;
        private Object valorFijoPataId;
        private Object valorFijoUnaId;
        private String mensaje;
        private int codigoSalida;
        private String codigoLoteria;
        private String fechaSorteo;
        private Object productoId;
        private int subProductoId;
        private String servicio;
        private Object tipoChanceId;
        private double encimaValor;

    }

}
