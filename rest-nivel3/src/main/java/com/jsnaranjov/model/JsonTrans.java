package com.jsnaranjov.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jsnaranjov.repo.IJsonTrans;


/**
 * @author Jaime Sebastián Naranjo V
 * @version 1.0.0
 */

@Component
public class JsonTrans implements IJsonTrans {
	private int id;
	private Date fechaCreacion;
	private Date fechaFin;
	private List<Date> fechas;

	public JsonTrans(int id, Date fechaCreacion, Date fechaFin, List<Date> fechas) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
	}

	public JsonTrans() {
		super();
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

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Date> getFechas() {
		return fechas;
	}

	public void setFechas(List<Date> fechas) {
		this.fechas = fechas;
	}

	public List<Date> obtenerFechasFaltantes() {
		List<Date> resultado = new ArrayList<>();
		Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(this.fechaCreacion);
		Calendar calFin = Calendar.getInstance();
		calFin.setTime(this.fechaFin);
		while (calInicio.before(calFin)) {
			if (!this.fechas.contains(calInicio.getTime())) {
				resultado.add(calInicio.getTime());
			}
			calInicio.add(Calendar.MONTH, 1);
		}
		return resultado;
	}
}
