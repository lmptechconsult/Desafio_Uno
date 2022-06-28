package cl.mgajardo.apiperiodosperdidos.viewmodel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Validated
public class PeriodoPerdido {
	
@JsonProperty("id")
private Long id = null;

@JsonProperty("fechaCreacion")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate fechaCreacion;

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
@JsonProperty("fechaFin")
private LocalDate fechaFin;

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
@JsonProperty("fechas")
private List<LocalDate> fechas;

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
@JsonProperty("fechasFaltantes")
@Valid
private List<LocalDate> fechasFaltantes;


public PeriodoPerdido id(Long id) {
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

public PeriodoPerdido fechaCreacion(LocalDate fechaCreacion) {
  this.fechaCreacion = fechaCreacion;
  return this;
}

/**
 * Get fechaCreacion
 * @return fechaCreacion
**/
@ApiModelProperty(value = "")

@Valid

public LocalDate getFechaCreacion() {
  return fechaCreacion;
}

public void setFechaCreacion(LocalDate fechaCreacion) {
  this.fechaCreacion = fechaCreacion;
}

/**
 * Get fechaFin
 * @return fechaFin
**/
@ApiModelProperty(value = "")

@Valid

public LocalDate getFechaFin() {
  return fechaFin;
}

public void setFechaFin(LocalDate fechaFin) {
  this.fechaFin = fechaFin;
}

public PeriodoPerdido fechaFin(LocalDate fechaFin) {
  this.fechaFin = fechaFin;
  return this;
}

public PeriodoPerdido fechas(List<LocalDate> fechas) {
  this.fechas = fechas;
  return this;
}

public PeriodoPerdido addFechasItem(LocalDate fechasItem) {
  if (this.fechas == null) {
    this.fechas = new ArrayList<>();
  }
  this.fechas.add(fechasItem);
  return this;
}


public PeriodoPerdido fechasFaltantes(List<LocalDate> fechasFaltantes) {
  this.fechasFaltantes = fechasFaltantes;
  return this;
}

public PeriodoPerdido addFechasFaltantesItem(LocalDate fechasFaltantesItem) {
	  if (this.fechas == null) {
	    this.fechas = new ArrayList<>();
	  }
	  this.fechas.add(fechasFaltantesItem);
	  return this;
	}
/**
 * Get fechas
 * @return fechas
**/
@ApiModelProperty(value = "")

@Valid

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
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PeriodoPerdido periodoPerdido = (PeriodoPerdido) o;
  return Objects.equals(this.id, periodoPerdido.id) &&
      Objects.equals(this.fechaCreacion, periodoPerdido.fechaCreacion) &&
      Objects.equals(this.fechaFin, periodoPerdido.fechaFin) &&
      Objects.equals(this.fechas, periodoPerdido.fechas) &&
      Objects.equals(this.fechasFaltantes, periodoPerdido.fechasFaltantes);
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
  sb.append("    fechasFaltantes: ").append(toIndentedString(fechasFaltantes));
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
