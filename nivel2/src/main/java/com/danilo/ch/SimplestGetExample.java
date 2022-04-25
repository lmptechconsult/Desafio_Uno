package com.danilo.ch;


import org.springframework.web.client.RestTemplate;

import com.danilo.ch.model.Fecha;

public class SimplestGetExample {
	
	
	
	public static final String GDD = "http://127.0.0.1:8080/periodos/api";
	
	
	public static String consumeApi() {
		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method and default Headers.
		String result = restTemplate.getForObject(GDD, String.class);
		
		return result;
	}

}
