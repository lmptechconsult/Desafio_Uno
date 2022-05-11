package cl.previred.desafio.model.entities;

import java.time.LocalDate;
import java.util.List;
/**
 * @author franciscoperez
 */

public class Dates {
	
	private long id;
	private LocalDate fechaCreacion;
	private LocalDate fechaFin;
	private List<LocalDate> fechas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	

}
