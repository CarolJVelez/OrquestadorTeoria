/*
 * Archivo que contiene el código de
 * la clase ParametrosBnetResponse
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

/*
 * @class ParametrosBnetResponse
 * @description Clase que almacena la información de la respuesta de los parametros de bnet.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class ParametrosBnetResponse {
    
    private ArrayList<Producto> productos;
    private ArrayList<LoteriasBnetHoy> loteriasBnetHoy;
    private int maximoApuestas;
    private int cantidadMaximaLoterias;
    private int cantidadMaximaCopias;
    private int rangoDiasRepetirApuestas;
    private int tipoDeValor;
    private boolean seriado;
    private boolean asumeIva;
    private boolean realizaRedondeo;
    private String modoRedondeo;
    private double multipoRedondeo;
    private boolean limpiarPanel;
    private int valorMinimoApuesta;
    private double topeMinimoFormulario;
    private double topeMaximoFormulario;

    @Data
    public static class Producto {
        private int subProductoId;
        private String servicioId;
        private String codigo;
        private String nombreSubproducto;
        private int codigoBnet;
        private String nombre;
        private String nombreCorto;
        private double iva;
        private Object tipoChanceId;
        private String valorFijo;
        private int cifras;
        private boolean directo;

    }

    @Data
    public static class LoteriasBnetHoy {
        private int loteriaId;
        private String codigo;
        private String nombre;
        private String nombreCorto;
        private int cifras;
        private int serie;
        private String horaCierre;
        private int tipoLoteria;
        private String fechaSorteo;
        private String codigoSivical;
    }

}
