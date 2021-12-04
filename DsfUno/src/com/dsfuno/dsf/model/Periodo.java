package com.dsfuno.dsf.model;

import java.util.Iterator;

public class Periodo {

	private String id;
	private String fechaCreacion;
	private String fechaFin;
	private String fechas;
	Iterator<String> iFechas;

	public Periodo() {
		super();
	}

	public Periodo(String id, String fechaCreacion, String fechaFin, String fechas, Iterator<String> iFechas) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
		this.iFechas = iFechas;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the fechas
	 */
	public String getFechas() {
		return fechas;
	}

	/**
	 * @param fechas the fechas to set
	 */
	public void setFechas(String fechas) {
		this.fechas = fechas;
	}

	/**
	 * @return the iFechas
	 */
	public Iterator<String> getiFechas() {
		return iFechas;
	}

	/**
	 * @param iFechas the iFechas to set
	 */
	public void setiFechas(Iterator<String> iFechas) {
		this.iFechas = iFechas;
	}

}
