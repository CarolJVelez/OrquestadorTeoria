/*
 * Archivo que contiene el código de
 * la interfaz TransaccionRepository
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.repository;

import com.co.sg.ms.common.orchestrate.comun.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * @interface TransaccionRepository
 * @description Interfaz encargada de la realización de logica de base de datos del detalle de venta para la tabla
 * MA_DETALLES_CONEXION.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    @Query(value = "SELECT NEXTVAL('seq_transaccion_canal_digital')", nativeQuery = true)
    Long getSeqTransaccionCanalDigital();

    @Query(value = "SELECT NEXTVAL('seq_transaccion_id')", nativeQuery = true)
    Long getSeqTransaccion();

}
