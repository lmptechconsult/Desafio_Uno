package com.previred.app.date.controller.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.previred.app.date.dto.ErrorResponseDTO;
import com.previred.app.date.exception.InteropException;
import com.previred.app.date.exception.ServicesException;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@RestControllerAdvice
public class ErrorHandler {
	   
	/**
	 * 
	 * @param exception
	 * @return
	 */
    @ExceptionHandler(value = ServicesException.class)
    public ResponseEntity<ErrorResponseDTO> handlerServicesException(ServicesException exception) {
    	ErrorResponseDTO error = new ErrorResponseDTO("ERROR", new Date(), exception.getMessage());
        return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.CONFLICT);
    }
    
    /**
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(value = InteropException.class)
    public ResponseEntity<ErrorResponseDTO> handlerInteropException(InteropException exception) {
    	ErrorResponseDTO error = new ErrorResponseDTO("ERROR", new Date(), exception.getMessage());
        return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.FAILED_DEPENDENCY);
    }
    
    /**
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDTO> globalExceptions(Exception exception) {
    	ErrorResponseDTO error = new ErrorResponseDTO("ERROR", new Date(), "Internal server error");
        return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
