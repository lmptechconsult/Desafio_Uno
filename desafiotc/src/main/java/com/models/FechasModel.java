package com.models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * FechasModel
 * modelo para obtener fechas obtenidas
 */

public class FechasModel {
	private int id;
	private LocalDate fechaCreacion;
	private LocalDate fechaFin;
	private ArrayList<LocalDate> fechas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public ArrayList<LocalDate> getFechas() {
		return fechas;
	}
	public void setFechas(ArrayList<LocalDate> fechas) {
		this.fechas = fechas;
	}

	
	
}
