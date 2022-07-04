package com.desafio.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Periodo {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("fechaCreacion")
	private LocalDate fechaCreacion;
	
	@JsonProperty("fechaFin")
	private LocalDate fechaFin ;
	
	@JsonProperty("fechas")
	private List<LocalDate> fechas ;
	
	@JsonProperty("fechasFaltantes")
	private List<LocalDate> fechasFaltantes;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public List<LocalDate> getFechas() {
		return fechas;
	}
	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}
	public List<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}
	public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
	
	@Override
	public String toString() {
		return "Periodo [id=" + id + ", fechaCreacion=" + fechaCreacion + ", fechaFin=" + fechaFin + ", fechas="
				+ fechas + ", fechasFaltantes=" + fechasFaltantes + "]";
	}


}
