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
 * @description Clase que almacena la información de la respuesta de la venta de Chance.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public  class VentaChanceBnetResponse {

    /*private String template;
    private String serie1;
    private String serie2;
    private boolean imprime;
    private Object mensajeNoImpresion;
    private boolean asesorPrepago;
    private double saldoPrepago;
    private String tipoPapel;
    private String templatePromocion;
    private Object nombrePromocion;
    private boolean activoPromocion;
    private Object imprimeColilla;
    private boolean imprimePromocion;
    private String tipoPapelPromocion;
    private boolean reproduceAudio;
    private boolean emiteFacturaElectronica;
    private Object transaccionId;*/
    public VentaCanalDigital ventaCanalDigital;

    @Data
    public static class VentaCanalDigital{
        public String fechaVenta;
        public String horaVenta;
        public String fechaSorteo;
        public int idAgencia;
        public String codigoSeguridad;
        public long idTransaccion;
        public String frm;
        public ArrayList<String> loterias;
        public ArrayList<Apuesta> apuestas;
        public String subTotal;
        public String iva;
        public String total;
    }

    @Data
    public static class Apuesta{
        public String numero;
        public String juego;
        public String valor;
    }
    
}
