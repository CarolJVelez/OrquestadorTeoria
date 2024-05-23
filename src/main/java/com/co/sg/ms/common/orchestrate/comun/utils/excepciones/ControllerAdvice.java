package com.co.sg.ms.common.orchestrate.comun.utils.excepciones;

import com.co.sg.ms.common.orchestrate.comun.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex) {
        ErrorDto errorDto = ErrorDto.builder().code("p-500").mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }
}