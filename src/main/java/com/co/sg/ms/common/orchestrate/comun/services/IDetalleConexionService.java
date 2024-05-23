/*
 * Archivo que contiene el código de
 * la interfaz IDetalleConexionService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.services;

import com.co.sg.ms.common.orchestrate.comun.entities.DetallesConexion;

/*
 * @interface IDetalleConexionService
 * @description Interfaz encargada de la realización de logica de DetalleConexionService.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
public interface IDetalleConexionService {

    public DetallesConexion obtenerDetallesConexion();
}
