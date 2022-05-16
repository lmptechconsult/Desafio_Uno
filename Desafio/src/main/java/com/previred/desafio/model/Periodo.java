package com.previred.desafio.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Periodo {

	private Long id;
	private String fechaCreacion;
	private String fechaFin;
	private ArrayList<String> fechas;
	private ArrayList<String> fechasFaltantes;

	public Periodo(Long id, String fechaCreacion, String fechaFin, ArrayList<String> fechas,
			ArrayList<String> fechasFaltantes) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
		this.fechasFaltantes = fechas;
	}

	public Periodo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public ArrayList<String> getFechas() {
		return fechas;
	}

	public void setFechas(ArrayList<String> fechas) {
		this.fechas = fechas;
	}

	public void addFechasFaltantes(String fecha) {
		this.fechasFaltantes.add(fecha);
	}

	public ArrayList<String> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(ArrayList<String> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}

}
