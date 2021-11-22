package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Response;
import com.example.demo.service.ApiPeriodosService;

@RestController
public class FechasApi {
	@Autowired
	ApiPeriodosService periodosService;
		
	/**
	 * Metodo que recibe la respuesta de la Api actual ya procesada.  
	 * 	
	 * @return Response Api Actual.
	 * @throws Exception
	 */
	@GetMapping(value="/periodos-perdidos/api")
	public Response periodosPerdidos() throws Exception {		
		return periodosService.getResponse();
	}
	
}
