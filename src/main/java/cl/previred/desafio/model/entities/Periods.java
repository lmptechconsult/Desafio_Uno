package cl.previred.desafio.model.entities;

import java.time.LocalDate;
import java.util.List;


/**
 * @author franciscoperez
 */
public class Periods {
	
	private long id;
	private LocalDate fechaCreacion;
	private LocalDate fechaFin;
	private List<LocalDate> fechas;
	private List<LocalDate> fechasFaltantes;
	
	public Periods(Dates dates,List<LocalDate> fechasFaltantes) {
		super();
		this.id = dates.getId();
		this.fechaCreacion = dates.getFechaCreacion();
		this.fechaFin = dates.getFechaFin();
		this.fechas = dates.getFechas();
		this.fechasFaltantes = fechasFaltantes;
	}

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

	public List<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}

	@Override
	public String toString() {
		return "Periods [id=" + id + ", fechaCreacion=" + fechaCreacion + ", fechaFin=" + fechaFin + ", fechas="
				+ fechas + ", fechasFaltantes=" + fechasFaltantes + "]";
	}

	
}
