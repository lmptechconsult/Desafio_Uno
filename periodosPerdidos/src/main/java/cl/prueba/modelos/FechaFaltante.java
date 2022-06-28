package cl.prueba.modelos;

import java.util.ArrayList;
import java.util.List;

public class FechaFaltante {	

	private int id;
	private String fechaCreacion;
	private String fechaFin;
	List<String> fechasFaltantes;
	
	public FechaFaltante() {
		this.fechasFaltantes = new ArrayList<String>();
	}
	
	
	public FechaFaltante(int id, String fechaCreacion, String fechaFin, List<String> fechasFaltantes) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechasFaltantes = fechasFaltantes;
	}

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

	public List<String> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<String> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}

	@Override
	public String toString() {
		return "FechaFaltante [getId()=" + getId() + ", getFechaCreacion()=" + getFechaCreacion() + ", getFechaFin()="
				+ getFechaFin() + ", getFechasFaltantes()=" + getFechasFaltantes() + "]";
	}
	
	
	
}
