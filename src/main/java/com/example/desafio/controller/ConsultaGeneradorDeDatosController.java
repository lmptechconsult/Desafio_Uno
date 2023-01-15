package com.example.desafio.controller;

import com.example.desafio.entities.GeneradorDeDatosResponse;
import com.example.desafio.service.ConsultaGeneradorDeDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/gdd")
public class ConsultaGeneradorDeDatosController {

    @Autowired
    private ConsultaGeneradorDeDatosService consultaGeneradorDeDatosService;

    @RequestMapping(value = "/consultaGDD", method = RequestMethod.GET)
    public GeneradorDeDatosResponse consultaGDD() throws ParseException {
        return consultaGeneradorDeDatosService.consultaGDD();
    }
}
