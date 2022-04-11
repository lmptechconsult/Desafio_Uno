package com.desafio.periodos.config;

import com.desafio.periodos.config.exceptions.ServiceException;
import com.desafio.periodos.config.exceptions.ExceptionBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    private static final Log LOGGER = LogFactory.getLog(ExceptionConfig.class.getName());
    private static final String MENSAJE = " Causa: ";


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionBody> exception(Exception e) {
        LOGGER.error("Ha ocurrido un error generico: " + e.getMessage() + MENSAJE + e.getCause());
        return new ResponseEntity<>(new ExceptionBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), Exception.class.getName()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionBody> serviceException(ServiceException e) {

        if (e.getCuerpoExcepcion()!=null) {
            LOGGER.error("Ha ocurrido un error asociado al consumo de un servicio: " + e.getMensaje());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionBody(HttpStatus.CONFLICT.value(), e.getCuerpoExcepcion().getMensaje(),
                    ServiceException.class.getName(), e.getCuerpoExcepcion().getTraceId(), e.getMensaje()));
        }else {
            LOGGER.error("Ha ocurrido un error asociado al consumo de un servicio: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionBody(HttpStatus.CONFLICT.value(), e.getMessage(), ServiceException.class.getName()));
        }
    }

}
