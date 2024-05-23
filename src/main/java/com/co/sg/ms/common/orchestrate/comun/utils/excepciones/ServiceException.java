package com.co.sg.ms.common.orchestrate.comun.utils.excepciones;

import lombok.Data;

@Data
public class ServiceException extends  RuntimeException{

    private String mensaje;
    public ServiceException(String message) {
        super(message);
    }
}
