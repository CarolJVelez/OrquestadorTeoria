/*
 * Archivo que contiene el código de
 * la clase VentaChanceBnetRequest
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
 * @description Clase que almacena la información de la petición para validar la venta de Chance.
 * @author Cristian Muñoz.
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class VentaChanceBnetRequest {
    private String version;
    private boolean asumeIva;
    private double valorIva;
    private int valor;
    private int valorTotal;
    private String fechaSorteo;
    private boolean semanario;
    private boolean distribucion;
    private boolean validar;
    private String codigoMedioPago;
    private Apuesta apuestas;
    private boolean esRecomendado;
    private boolean ventaDirecta;
    private long numeroTransaccionCliente;
    private String terceroId;
    private String terceroIdentificacion;
    private boolean canalDigital;

    @Data
    public static class Apuesta {
        private int subProductoId;
        private String servicioId;
        private ArrayList<ListaAPuestas> lista;
    }

    @Data
    public static class ListaAPuestas {
        private int apuestaId;
        private String numero;
        private Object productoId;
        private String codigoLoteria;
        private String fechaSorteo;
        private int valor;
        private int encima;
        private int productoNombreCorto;
        private String loteriaNombreCorto;

    }

}
