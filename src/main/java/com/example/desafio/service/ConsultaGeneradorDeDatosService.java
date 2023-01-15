package com.example.desafio.service;

import com.example.desafio.entities.GeneradorDeDatosResponse;

import java.text.ParseException;

public interface ConsultaGeneradorDeDatosService {

    GeneradorDeDatosResponse consultaGDD() throws ParseException;
}
