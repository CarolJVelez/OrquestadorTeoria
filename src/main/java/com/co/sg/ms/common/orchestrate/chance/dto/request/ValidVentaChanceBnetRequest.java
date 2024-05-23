/*
 * Archivo que contiene el código de
 * la clase ValidListChanceBnetRequest
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.dto.request;

import lombok.Data;
import java.util.ArrayList;

/*
 * @class ValidListChanceBnetRequest
 * @description Clase encargada de contener los datos para el envio de la pre-venta de Chance.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class ValidVentaChanceBnetRequest {

    private int valor; //Valor de la transacción.
    private int subProductoId; //SubProducto Id.
    private ArrayList<ListApuesta>listApuestas; //Lista de apuestas que se enviaran.

    /*
     * @class ListApuesta
     * @description Clase encargada de contener los datos de ListApuesta.
     * @author David Forero
     * @version 1.0 17/05/2024 Creación de la clase.
     */
    @Data
    public static class ListApuesta {
        private String numero; //Numero que se aposto
        private String codigoLoteria; //Codigo de la loteria
        private Long modalidadJuego; //Modalidad de juego
        private int valor; //Valor por apuesta
    }
}
