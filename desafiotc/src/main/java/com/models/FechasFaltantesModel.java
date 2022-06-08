package com.models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * FechasFaltantesModel
 * Clase para generar salida con fechas faltantes
 */

public class FechasFaltantesModel {
	private int id;
	private LocalDate fechaCreacion;
	private LocalDate fechaFin;
	private ArrayList<LocalDate> fechas;
	private ArrayList<LocalDate> fechasFaltantes;
	
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
	public ArrayList<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}
	public void setFechasFaltantes(ArrayList<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
}
