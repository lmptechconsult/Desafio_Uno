package com.jsnaranjov.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jsnaranjov.repo.IJsonResp;

/**
 * @author Jaime Sebastián Naranjo V
 * @version 1.0.0
 */

@Component
public class JsonResp implements IJsonResp{
	private int id;
	private Date fechaCreacion;
	private Date fechaFin;
	private List<Date> fechas;
	private List<Date> fechasFaltantes;

	public JsonResp(int id, Date fechaCreacion, Date fechaFin, List<Date> fechas, List<Date> fechasFaltantes) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
		this.fechasFaltantes = fechasFaltantes;
	}
	
	public JsonResp() {
		super();
	}

	public List<Date> getFechas() {
		return fechas;
	}

	public void setFechas(List<Date> fechas) {
		if (fechas.size() > 100) {
			throw new IllegalArgumentException("No se permiten más de 100 fechas");
		} else {
			this.fechas = fechas;
		}
	}

	public List<Date> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<Date> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date FechaFin) {
		this.fechaFin = FechaFin;
	}
	

}
