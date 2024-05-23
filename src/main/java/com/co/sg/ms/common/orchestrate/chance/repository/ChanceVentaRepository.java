/*
 * Archivo que contiene el código de
 * la interfaz ChanceVentaRepository
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.repository;

import com.co.sg.ms.common.orchestrate.chance.entities.ChanceVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
 * @interface ChanceVentaRepository
 * @description Interfaz encargada de la realización de logica de base de datos de la transacción de venta para la tabla
 * tr_chance.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Repository
public interface ChanceVentaRepository extends JpaRepository<ChanceVenta, Long> {

    @Query("SELECT v FROM ChanceVenta v WHERE v.transaccionId = :transaccion")
    ChanceVenta getVentaChance(Long transaccion);

}
