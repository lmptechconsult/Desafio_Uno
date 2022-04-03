package com.previred.app.date.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@Getter
@Setter
public class ResponseDTO extends ExternalResponseDTO {
	
	   	
   private List<String> fechasFaltantes;
   
   /**
    * Obtiene las fechas faltantes en formato JSON
    * @return
    */
   @JsonIgnore
   public String getMissingDatesJSON() {
	   Gson gson = new GsonBuilder().create();
	   JsonArray jsonArray = gson.toJsonTree(this.fechasFaltantes).getAsJsonArray();
	   JsonObject obj = new JsonObject();
	   obj.add("fechasFaltantes", jsonArray);
	   return gson.toJson(obj);
   }
   
   @Override
   @JsonIgnore
   public String toString() {
	   return new Gson().toJson(this);
   }
}
