/*
 * Archivo que contiene el código de
 * la clase MsCommonOrchestrateApplication
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */
package com.co.sg.ms.common.orchestrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @class MsCommonOrchestrateApplication
 * @description Clase encargada de contener la logica para arrancar el microservicio MsCommonOrchestrate.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MsCommonOrchestrateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCommonOrchestrateApplication.class, args);
	}

}
