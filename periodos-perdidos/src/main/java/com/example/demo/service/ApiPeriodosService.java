package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Periodos;
import com.example.demo.dto.Response;

@Service
public class ApiPeriodosService {
	@Autowired
	RestTemplate restTemplate;
		
	
	final private static String URL_API = "http://127.0.0.1:8080/periodos/api";
	
	/**
	 * Metodo que consume Api "Generador Datos Desafio"
	 * @return Response Api GDD
	 */
	private ResponseEntity<Periodos> getPeriodos(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Periodos> entity = new HttpEntity<>(headers);
				
		ResponseEntity<Periodos> response = restTemplate.exchange(URL_API, HttpMethod.GET, entity, new ParameterizedTypeReference<Periodos>() {
		});		
		
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
							
	}
	
	/**
	 * Metodo que compara las fechas devueltas por la Api "GDD", con las fechas faltantes
	 * 
	 * @return Clase Response para respuesta de la Api actual.
	 * @throws Exception
	 */
	public Response getResponse() throws Exception{				
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fechaCreacion = getPeriodos().getBody().getFechaCreacion();
		String  fechaFin = getPeriodos().getBody().getFechaFin();
		
		
		List<String> fechas = getPeriodos().getBody().getFechas();
		List<String> fechasFaltantes = new ArrayList<String>();
		
		Calendar fechaAux = Calendar.getInstance();
		fechaAux.setTime(format.parse(fechaCreacion));		
		while(!fechaFin.equals(format.format(fechaAux.getTime()))) {
					
			String aux = format.format(fechaAux.getTime());
			if(!fechas.contains(aux)) {
				fechasFaltantes.add(aux);
			}					
			fechaAux.add(Calendar.MONTH, 1);
		}
		
		return new Response(getPeriodos().getBody().getId(), fechaCreacion.toString(), 
				fechaFin.toString(), fechas, fechasFaltantes);			
							
	}	
	
}
