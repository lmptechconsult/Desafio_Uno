package com.example.demo.model;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CompletaPeriodo {
	  @JsonProperty("id")
	  private Long id ;

	  @JsonProperty("fechaCreacion")
	  private LocalDate fechaCreacion;

	  @JsonProperty("fechaFin")
	  private LocalDate fechaFin;
	  
	  @JsonProperty("fechaFaltante")
	  private List<LocalDate> fechaFaltante;

	  @JsonProperty("fechas")
	  @Valid
	  private List<LocalDate> fechas;

	  public CompletaPeriodo id(Long id) {
	    this.id = id;
	    return this;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<LocalDate> getFechaFaltante() {
		return fechaFaltante;
	}

	public void setFechaFaltante(List<LocalDate> fechaFaltante) {
		this.fechaFaltante = fechaFaltante;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}
	  


}
