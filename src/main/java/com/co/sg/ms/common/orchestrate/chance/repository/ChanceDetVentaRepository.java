/*
 * Archivo que contiene el código de
 * la interfaz ChanceDetVentaRepository
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.repository;


import com.co.sg.ms.common.orchestrate.chance.entities.ChanceDetVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @interface ChanceDetVentaRepository
 * @description Interfaz encargada de la realización de logica de base de datos del detalle de venta para la tabla
 * de_chance_producto.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Repository
public interface ChanceDetVentaRepository extends JpaRepository<ChanceDetVenta, Long> {
}
