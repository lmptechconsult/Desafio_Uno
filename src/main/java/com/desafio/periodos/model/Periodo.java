package com.desafio.periodos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Periodo implements Serializable {

    private static final long serialVersionUID = -348894758647354080L;
    @JsonProperty("id")
    @ApiModelProperty(notes = "id entregado por GDD", name = "id", dataType = "Long")
    private Long id;

    @JsonProperty("fechaCreacion")
    @ApiModelProperty(notes = "fecha creación entregado por GDD", name = "fechaCreacion", dataType = "LocalDate")
    private LocalDate fechaCreacion;

    @JsonProperty("fechaFin")
    @ApiModelProperty(notes = "fecha fin entregado por GDD", name = "fechaFin", dataType = "LocalDate")
    private LocalDate fechaFin;

    @JsonProperty("fechas")
    @ApiModelProperty(notes = "Lista de fechas del periodo entregado por GDD", name = "fechas", dataType = "List<LocalDate>")
    private List<LocalDate> fechas;

    @JsonProperty("fechasFaltantes")
    @ApiModelProperty(notes = "Lista de fechas que faltan de la lista de fechas", name = "fechasFaltantes", dataType = "List<LocalDate>")
    private List<LocalDate>fechasFaltantes;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return Objects.equals(id, periodo.id) &&
                Objects.equals(fechaCreacion, periodo.fechaCreacion) &&
                Objects.equals(fechaFin, periodo.fechaFin) &&
                Objects.equals(fechas, periodo.fechas) &&
                Objects.equals(fechasFaltantes, periodo.fechasFaltantes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaCreacion, fechaFin, fechas, fechasFaltantes);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Periodo{");
        sb.append("id=").append(id);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", fechas=").append(fechas);
        sb.append(", fechasFaltantes=").append(fechasFaltantes);
        sb.append('}');
        return sb.toString();
    }
}
