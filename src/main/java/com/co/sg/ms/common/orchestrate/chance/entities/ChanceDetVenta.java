/*
 * Archivo que contiene el código de
 * la clase ChanceDetVenta
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.entities;

import jakarta.persistence.*;
import lombok.*;

/*
 * @class ChanceDetVenta
 * @description Clase encargada de crear la estructura de la tabla de_chance_producto.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "de_chance_producto")
public class ChanceDetVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chance_producto_id")
    private Long chanceProductoId; //Id unico de la tabla de_chance_producto.

    @Column(name = "chance_id")
    private Long chanceId; //chanceId asociado a la tabla tr_chance.

    @Column(name = "numero_apostado")
    private int numeroApostado; //Numero apostado.

    @Column(name = "valor_apostado")
    private int valorApostado; //Valor de la apuesta.

    @Column(name = "modo_juego")
    private String modoJuego; //Modo de juego (Uña, Pata, 3 cifras, 4 Cifras).

}
