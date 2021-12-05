package com.devru.desafiouno.service;

import org.springframework.web.client.RestClientException;

import com.devru.desafiouno.dto.Periodo;

/**
* interface DateService para logica de negocio de los Periodos
*
* @author Devru
* @version 17-04-21
*/
public interface DateService {

	/**
	 * 
	 * Calcula periodos faltantes 
	 * @param
	 * @return Devuelve objeto Periodo con listado periodos iniciales y periodos faltantes calculados
	 */
	Periodo calcularPeriodos() throws RestClientException;
	
}
