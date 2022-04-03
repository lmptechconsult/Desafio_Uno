package com.previred.app.date.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@Getter
@Setter
public class ExternalResponseDTO {

   private Long id;
   private String fechaCreacion;
   private String fechaFin;
   private List<String> fechas;
   
   @Override
   @JsonIgnore
   public String toString() {
	   return new Gson().toJson(this);
   }
}
