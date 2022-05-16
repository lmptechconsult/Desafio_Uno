package com.desafio.uno.model;

import java.time.LocalDate;
import java.util.Set;

import com.desafio.uno.config.CustomLocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class PeriodoFaltante {
	/**
	 * Valores de salida
	 * */
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("fechaCreacion")
	@JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate fechaCreacion;
	
	@JsonProperty("fechaFin")
	@JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate fechaFin;
	
	@JsonProperty("fechas")
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Set<LocalDate> fechas;
	
	@JsonProperty("fechasFaltantes")
	@JsonSerialize(using = CustomLocalDateSerializer.class)
    private Set<LocalDate> fechasFaltantes;

}
