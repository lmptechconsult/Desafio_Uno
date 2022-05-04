package com.previred.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.previred.exception.BadRequestException;
import com.previred.exception.InvalidDataException;
import com.previred.model.PeriodoModel;
import com.previred.util.GsonLocalDateTypeAdapter;

@Repository
public class PeriodoRepository {

	Logger logger = LogManager.getLogger(PeriodoRepository.class.getName());
	
	public PeriodoModel buscarPeriodoFaltantes() throws Exception{
			
		PeriodoModel periodoModel = new PeriodoModel();
		String comando="curl -X GET -H \"Accept: application/json\" http://127.0.0.1:8080/periodos/api";
		String line = "";
		String response = "";	
		
		try {
			Process p = Runtime.getRuntime().exec(comando);             
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			             
			while ((line = reader.readLine())!= null) {
				response += (line+"\n");
			}		
			
			GsonBuilder builder = new GsonBuilder();
	        builder.registerTypeAdapter(LocalDate.class, new GsonLocalDateTypeAdapter());
	        Gson gson = builder.create();	       
	        
	        JsonObject convertedObject = gson.fromJson(response, JsonObject.class);	
	        
	        if(convertedObject.has("id")) {
	        	periodoModel = gson.fromJson(convertedObject.toString(), PeriodoModel.class);
				return periodoModel;
	        }else {
	        	logger.error(convertedObject.get("message").toString());				
	        	throw new BadRequestException(convertedObject.get("message").toString());
	        }			
		}
		catch (IOException e) {	
			logger.error(e);			
			throw new Exception(e.getMessage());			
		} catch (InterruptedException e) {			
			logger.error(e);			
			throw new Exception(e.getMessage());
		}catch(JsonSyntaxException e) {
			logger.error(e);			
			throw new InvalidDataException(e.getMessage());
		}catch(Exception e) {
			logger.error(e);			
			throw new Exception(e.getMessage());
		}		
		
	}
}
