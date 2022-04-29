package com.example.demo.servicio;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CompletaPeriodo;

@Service
public class PeriodoServices {
	
	public CompletaPeriodo entregaFechas(){
				
		CompletaPeriodo resultado = traeDatos();
		LocalDate fechaIni = resultado.getFechaCreacion(); 
		LocalDate fechaFin = resultado.getFechaFin();
		List<LocalDate> cuentaFecha =new ArrayList();
		
		while(fechaIni.isBefore(fechaFin) )
		{
			
			if(!resultado.getFechas().contains(fechaIni)){
				
				cuentaFecha.add(fechaIni);
			}
			
			System.out.println(fechaIni);
			fechaIni = fechaIni.plusMonths(1);
			
		}  resultado.setFechaFaltante(cuentaFecha);

		return resultado;
	}
	
	public CompletaPeriodo traeDatos() {
		
		String url = "http://localhost:8080/periodos/api";
		try {
			RestTemplate restTemplate = new RestTemplate();
			CompletaPeriodo result = restTemplate.getForObject(url, CompletaPeriodo.class);
			return result;
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	


}
