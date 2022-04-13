package previred.desafiouno.periodos.servicios.model;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

@JsonIgnoreProperties(ignoreUnknown = true)
public class Periodo {

	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("fechaCreacion")
	private LocalDate fechaCreacion = null;

	@JsonProperty("fechaFin")
	private LocalDate fechaFin = null;

	@JsonProperty("fechas")
	//@Valid
	private List<LocalDate> fechas = null;
	
	@JsonProperty("fechasFaltantes")
	//@Valid
	private List<LocalDate> fechasFaltantes = null;
	
	
	
	

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
	
}
