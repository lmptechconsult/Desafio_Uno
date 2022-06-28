package cl.prueba.modelos;

import java.util.ArrayList;
import java.util.List;

public class Dato {

	
	private int id;
	private String fechaCreacion;
	private String fechaFin;
	List<String> fechas;
	
	
	public Dato() {
		this.fechas = new ArrayList<String>();
	}

	public Dato(int id, String fechaCreacion, String fechaFin, List<String> fechas) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
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

	public List<String> getFechas() {
		return fechas;
	}

	public void setFechas(List<String> fechas) {
		this.fechas = fechas;
	}

	@Override
	public String toString() {
		return "Dato [getId()=" + getId() + ", getFechaCreacion()=" + getFechaCreacion() + ", getFechaFin()="
				+ getFechaFin() + ", getFechas()=" + getFechas() + "]";
	}
	
	
	
}
