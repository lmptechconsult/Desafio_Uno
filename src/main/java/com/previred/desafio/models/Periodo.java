package com.previred.desafio.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Periodo
 */
@Component
@Validated
public class Periodo   {
  @JsonProperty("id")
  
  private Long id = null;

  @JsonProperty("fechaCreacion")
  //@JsonFormat(pattern="yyyy-MM-dd")
  //@ApiModelProperty(dataType = "java.sql.Date")
  private LocalDate fechaCreacion = null;

  @JsonProperty("fechaFin")
  //@JsonFormat(pattern="yyyy-MM-dd")
  //@ApiModelProperty(dataType = "java.sql.Date")
  private LocalDate fechaFin = null;

  @JsonProperty("fechas")
  //@JsonFormat(pattern="yyyy-MM-dd")
  //@ApiModelProperty(dataType = "java.sql.Date")
  @Valid
  private List<LocalDate> fechas = null;

  @JsonProperty("fechasFaltantes")
  //@JsonFormat(pattern="yyyy-MM-dd")
  @ApiModelProperty(dataType = "java.sql.Date")
  private List<LocalDate> fechasFaltantes = null;
  
  public Periodo id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Periodo fechaCreacion(LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
    return this;
  }

  /**
   * Get fechaCreacion
   * @return fechaCreacion
  **/
  @ApiModelProperty(value = "", dataType = "java.sql.Date")

  @Valid

  public LocalDate getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Periodo fechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
    return this;
  }

  /**
   * Get fechaFin
   * @return fechaFin
  **/
  @ApiModelProperty(value = "", dataType = "java.sql.Date")

  @Valid

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }

  public Periodo fechas(List<LocalDate> fechas) {
    this.fechas = fechas;
    return this;
  }

  public Periodo addFechasItem(LocalDate fechasItem) {
    if (this.fechas == null) {
      this.fechas = new ArrayList<>();
    }
    this.fechas.add(fechasItem);
    return this;
  }

  /**
   * Get fechas
   * @return fechas
  **/
  @ApiModelProperty(value = "", dataType = "java.sql.Date")

  @Valid

  public List<LocalDate> getFechas() {
    return fechas;
  }

  public void setFechas(List<LocalDate> fechas) {
    this.fechas = fechas;
  }

  /********************************************************/
  
  //@ApiModelProperty(value = "", dataType = "java.sql.Date")
  public Periodo addFechasFalantesItem(LocalDate fechasFaltantesItem) {
    if (this.fechasFaltantes == null) {
      this.fechasFaltantes = new ArrayList<>();
    }
    this.fechasFaltantes.add(fechasFaltantesItem);
    return this;
  }

  
  /*********************************************************/
  
  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Periodo periodo = (Periodo) o;
    return Objects.equals(this.id, periodo.id) &&
	        Objects.equals(this.fechaCreacion, periodo.fechaCreacion) &&
	        Objects.equals(this.fechaFin, periodo.fechaFin) &&
	        Objects.equals(this.fechas, periodo.fechas) &&
	        Objects.equals(this.fechasFaltantes, periodo.fechas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fechaCreacion, fechaFin, fechas, fechasFaltantes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Periodo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fechaCreacion: ").append(toIndentedString(fechaCreacion)).append("\n");
    sb.append("    fechaFin: ").append(toIndentedString(fechaFin)).append("\n");
    sb.append("    fechas: ").append(toIndentedString(fechas)).append("\n");
    sb.append("    fechasFaltantes: ").append(toIndentedString(fechasFaltantes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

