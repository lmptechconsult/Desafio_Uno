package com.desafio.uno.model;

import java.time.LocalDate;
import java.util.Set;

import com.desafio.uno.config.CustomLocalDateArrayDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;

@Data
public class Periodo {
	
	  @JsonProperty("id")
	  private Long id;

	  @JsonProperty("fechaCreacion")
	  @JsonDeserialize(using = LocalDateDeserializer.class)  
	  @JsonSerialize(using = LocalDateSerializer.class)  
	  private LocalDate fechaCreacion;

	  @JsonProperty("fechaFin")
	  @JsonDeserialize(using = LocalDateDeserializer.class)  
	  @JsonSerialize(using = LocalDateSerializer.class)  
	  private LocalDate fechaFin;

	  @JsonProperty("fechas")
	  @JsonDeserialize(using = CustomLocalDateArrayDeserializer.class)
	  private Set<LocalDate> fechas;

}
