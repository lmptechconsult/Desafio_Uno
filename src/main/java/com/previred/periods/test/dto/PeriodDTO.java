package com.previred.periods.test.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodDTO.
 */
@JsonInclude(Include.NON_NULL)
public class PeriodDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6223062648359162776L;

	/** The id. */
	@JsonProperty("id")
	private Long id;
	
	/** The fecha creacion. */
	@JsonProperty("fechaCreacion")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate fechaCreacion;
	
	/** The fecha fin. */
	@JsonProperty("fechaFin")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate fechaFin;
	
	/** The fechas. */
	@JsonProperty("fechas")
	private List<LocalDate> fechas;
	
	/** The fechas faltantes. */
	@JsonProperty("fechasFaltantes")
	private List<LocalDate> fechasFaltantes;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the fecha creacion.
	 *
	 * @return the fecha creacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Sets the fecha creacion.
	 *
	 * @param fechaCreacion the new fecha creacion
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Gets the fecha fin.
	 *
	 * @return the fecha fin
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the new fecha fin
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Gets the fechas.
	 *
	 * @return the fechas
	 */
	public List<LocalDate> getFechas() {
		return fechas;
	}

	/**
	 * Sets the fechas.
	 *
	 * @param fechas the new fechas
	 */
	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

	/**
	 * Gets the fechas faltantes.
	 *
	 * @return the fechas faltantes
	 */
	public List<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}

	/**
	 * Sets the fechas faltantes.
	 *
	 * @param fechasFaltantes the new fechas faltantes
	 */
	public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
}
