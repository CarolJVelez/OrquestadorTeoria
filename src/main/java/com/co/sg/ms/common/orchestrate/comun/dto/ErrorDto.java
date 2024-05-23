package com.co.sg.ms.common.orchestrate.comun.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

    private String code;
    private String mensaje;
}
