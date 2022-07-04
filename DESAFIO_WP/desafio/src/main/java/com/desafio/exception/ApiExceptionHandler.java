
package com.desafio.exception;


import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manejo de Excepciones
 * @author W.Pacheco
 */
@RestControllerAdvice
public class ApiExceptionHandler {       
     
    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<ExceptionResponse> handleUnknownHostException(UnknownHostException ex) {
        ExceptionResponse response = new ExceptionResponse("Error de conexion","erorr-1024",ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.PARTIAL_CONTENT);
    }
    
     @ExceptionHandler(BussinesException.class)
    public ResponseEntity<ExceptionResponse> handleBussinesRuleException(BussinesException ex) {
        ExceptionResponse response = new ExceptionResponse("Error: ",ex.getCode(),ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.PARTIAL_CONTENT);
    }
    
}
