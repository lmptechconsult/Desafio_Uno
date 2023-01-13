package com.jsnaranjov.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsnaranjov.model.JsonTrans;
import com.jsnaranjov.repo.IJsonResp;
import com.jsnaranjov.repo.IJsonTrans;
import com.jsnaranjov.repo.IService;


/**
 * @author Jaime Sebastián Naranjo V
 * @version 1.0.0
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/api")
public class RestNivel3Controller {

	@Autowired
	private IJsonResp jsonR;
	@Autowired
	private IJsonTrans jsonT;
	@Autowired
	private IService srv;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/obtener")
	public String obtenerFechas() {
		ObjectMapper mapper = new ObjectMapper();
		String resultadoApi = srv.llamadaApi();
		String result;

		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			mapper.setDateFormat(df);

			jsonT = mapper.readValue(resultadoApi, JsonTrans.class);

			jsonR.setFechas(jsonT.getFechas());
			jsonR.setFechasFaltantes(jsonT.obtenerFechasFaltantes());
			jsonR.setFechaFin(jsonT.getFechaFin());
			jsonR.setFechaCreacion(jsonT.getFechaCreacion());
	        jsonR.setId(jsonT.getId());

	        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonR);

		} catch (JsonParseException e) {
			return "{\"error\": \"Error al parsear el JSON\"}";
		} catch (JsonMappingException e) {
			return "{\"error\": \"Error al parsear el JSON\"}";
		} catch (IOException e) {
			return "{\"error\": \"Error de entrada/salida\"}";
		} finally {

		}

	    return result;
	}
		
}
