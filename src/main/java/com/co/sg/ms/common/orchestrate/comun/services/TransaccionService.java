/*
 * Archivo que contiene el código de
 * la clase TransaccionService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.services;

import com.co.sg.ms.common.orchestrate.comun.repository.TransaccionRepository;
import com.co.sg.ms.common.orchestrate.comun.utils.FechaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @class TransaccionService
 * @description Clase encargada de contener todos los servicios de la transacción.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Service
public class TransaccionService implements ITransaccionService {

    @Autowired
    TransaccionRepository transaccionRepository;

    public Long generarTransaccionSg(){
        long transaccionSG = transaccionRepository.getSeqTransaccionCanalDigital();
        return transaccionSG;
    }

    public String generarTransaccion() {
        String transaccion;
        String SeqTransaccion = Long.toString(transaccionRepository.getSeqTransaccion());
        String epochTime = FechaUtils.getCurrentEpochTime();
        transaccion = SeqTransaccion + epochTime;
        return transaccion;
    }

}
