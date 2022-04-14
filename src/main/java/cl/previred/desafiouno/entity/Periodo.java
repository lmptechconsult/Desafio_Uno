package cl.previred.desafiouno.entity;

import java.util.List;

public class Periodo {
	
	private int id;
	private String fechaCreacion;
	private String fechaFin;
	private List<Fecha> fechasFaltantes;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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

	public List<Fecha> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<Fecha> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
	
}
