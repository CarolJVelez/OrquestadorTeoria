package com.co.sg.ms.common.orchestrate.comun.dto;

import lombok.Data;

@Data
public class ContextServer {

    private static ContextServer contextServer;

    private String numeroDocumento; //Numero de documento del usuario.
    private String latitud; //Latitud (Georreferencia)
    private String longitud; //Longitud (Georreferencia)

    private ContextServer(){}

    public static ContextServer getContextServer() {

        if(contextServer== null){
            contextServer = new ContextServer();
        }
        return contextServer;
    }
}
