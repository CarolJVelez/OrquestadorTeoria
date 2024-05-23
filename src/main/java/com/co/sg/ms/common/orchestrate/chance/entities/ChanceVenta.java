/*
 * Archivo que contiene el código de
 * la clase ChanceVenta
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/*
 * @class ChanceVenta
 * @description Clase encargada de crear la estructura de la tabla tr_chance.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tr_chance")
public class ChanceVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "chance_id")
    private Long chanceId; //Id unico de la tabla tr_chance.

    @Column(name = "transaccion_canal_dig_id")
    private Long transaccionCanalDig; //Numero de la transacción generado por SG.

    @Column(name = "transaccion_id")
    private Long transaccionId; //Id de la transacción.

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha; //Fecha en la que se realizo la transacción.

    private String hora; //Hora de la transacción.

    private String nit; //Nit.

    @Column(name = "subproducto_id")
    private int subproductoId; //Id del subproducto.

    private String ciudad; //Nombre de la ciudad.

    private String departamento; //Nombre del departamento.

    @Column(name = "colaborador_id")
    private Long colaboradorId; //Id del colaborador la cual va amarrada la apuesta.

    @Column(name = "tipo_documento")
    private String tipoDocumento; //Tipo de documento (CC, CEX, CE, PA, NIT).

    private String identificacion; //Numero de documento.

    @Column(name = "cuenta_celular")
    private String cuentaCelular; //Numero de celular.

    private String usuario; //Usuario.

    @Column(name = "valor_total")
    private int valorTotal; //Valor total de la transacción.

    @Column(name = "valor_iva")
    private int valorIva; // Valor del IVA.

    @Column(name = "valor_neto")
    private int valorNeto; //Valor neto.

    private String estado; //Estado de la transacción.

    private String consecutivo; //Consecutivo.

    private String frm; //FRM id.

    @Column(name = "cod_seguridad")
    private String codSeguridad; //Codigo de seguridad de la transacción.

    private String loterias; //Loterías

    private String vendedor; //Nombre del vendedor.

    private String latitud; //Latitud (Georreferencia)

    private String longitud; //Longitud (Georrefrencia)
}
