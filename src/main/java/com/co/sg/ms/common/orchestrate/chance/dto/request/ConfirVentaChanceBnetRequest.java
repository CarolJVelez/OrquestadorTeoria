/*
 * Archivo que contiene el código de
 * la clase ListApuestasBnetRequest
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.dto.request;

import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.VentaChanceBnetRequest;
import lombok.Data;

import java.util.ArrayList;

/*
 * @class ListApuestasBnetRequest
 * @description Clase encargada de contener los datos de venta para Chance.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
public class ConfirVentaChanceBnetRequest {

    ArrayList<VentaChanceBnetRequest>ventaChance;
}
