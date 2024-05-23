/*
 * Archivo que contiene el código de
 * la clase DetallesConexion
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @class DetallesConexion
 * @description Clase encargada de crear la estructura de la tabla MA_DETALLES_CONEXION.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MA_DETALLES_CONEXION")
public class DetallesConexion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;
    public String usuario;
    public String password;
    public String macs;
    public int tecnologiaId;
    public String nombre_variable;

}
