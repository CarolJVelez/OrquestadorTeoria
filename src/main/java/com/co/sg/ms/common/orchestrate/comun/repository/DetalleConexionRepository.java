/*
 * Archivo que contiene el código de
 * la interfaz DetalleConexionRepository
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.repository;

import com.co.sg.ms.common.orchestrate.comun.entities.DetallesConexion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/*
 * @interface DetalleConexionRepository
 * @description Interfaz encargada de la realización de logica de base de datos del detalle de venta para la tabla
 * MA_DETALLES_CONEXION.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Repository
public interface DetalleConexionRepository extends JpaRepository<DetallesConexion, Long> {

    @Query("SELECT dc FROM DetallesConexion dc WHERE dc.nombre_variable = :nombreVariable")
    DetallesConexion findByLoginCodesa(String nombreVariable);



}
