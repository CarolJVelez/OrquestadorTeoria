/*
 * Archivo que contiene el código de
 * la clase DetalleConexionService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.comun.services;

import com.co.sg.ms.common.orchestrate.comun.repository.DetalleConexionRepository;
import com.co.sg.ms.common.orchestrate.comun.entities.DetallesConexion;
import com.co.sg.ms.common.orchestrate.comun.utils.Constantes.ConstanteLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @class DetalleConexionService
 * @description Clase encargada de contener todos los servicios de detalle conexión.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Service
public class DetalleConexionService implements IDetalleConexionService {
    @Autowired
    private DetalleConexionRepository detalleConexionRepository;


    @Override
    public DetallesConexion obtenerDetallesConexion(){

        return  detalleConexionRepository.findByLoginCodesa(ConstanteLogin.loginCodesa);
    }
}
