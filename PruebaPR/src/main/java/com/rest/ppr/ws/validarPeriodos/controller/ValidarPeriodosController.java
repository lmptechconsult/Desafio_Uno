package com.rest.ppr.ws.validarPeriodos.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rest.ppr.ws.validarPeriodos.service.ValidarPeriodosService;

/** Clase controller que accede a los servicios rest.
 * @author Rodrigo.Perez */
@RestController
@Scope("prototype")
public class ValidarPeriodosController {

    /** Objeto de la interface ValidarPeriodosService. */
    @Autowired
    private ValidarPeriodosService validarPeriodosService;

    /** Metodo GET para validar los periodos faltantes.
     * @return String.
     * @throws IOException */
    @RequestMapping(method = RequestMethod.GET, value = "/validarPeriodos")
    public final String validarPeriodos() throws IOException {
        return validarPeriodosService.getValidarPeriodos();
    }
}
