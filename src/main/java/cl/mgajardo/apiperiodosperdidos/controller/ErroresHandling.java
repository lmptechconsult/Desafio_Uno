package cl.mgajardo.apiperiodosperdidos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.mgajardo.apiperiodosperdidos.viewmodel.ErrorGeneral;

public class ErroresHandling {
	
	private Logger logger = LoggerFactory.getLogger(ErroresHandling.class);

	@ExceptionHandler(GeneralExceptionHandler.class)
	public ResponseEntity<ErrorGeneral> GenExceptionHandling(GeneralExceptionHandler exception) {
		logger.info("despliegue de mensaje: {} {}", exception.getMessage());
		ErrorGeneral errorGeneral = new ErrorGeneral();
		errorGeneral.setMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorGeneral);
	}

}
