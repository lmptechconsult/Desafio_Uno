package com.example.desafio1.clases;

import java.time.LocalDate;
import java.util.List;

public class Periodo
{
  private Long id;
  private LocalDate fechaCreacion;
  private LocalDate fechaFin;
  private List<LocalDate> fechas;
  private List<LocalDate> fechasFaltantes;

	  public Long getId()
	{
		return id;
	}
	public List<LocalDate> getFechasFaltantes()
	{
		return fechasFaltantes;
	}
	public void setFechasFaltantes(List<LocalDate> fechasFaltantes)
	{
		this.fechasFaltantes = fechasFaltantes;
	}
	public LocalDate getFechaCreacion()
	{
		return fechaCreacion;
	}
	public LocalDate getFechaFin()
	{
		return fechaFin;
	}
	public List<LocalDate> getFechas()
	{
		return fechas;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public void setFechaCreacion(LocalDate fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}
	public void setFechaFin(LocalDate fechaFin)
	{
		this.fechaFin = fechaFin;
	}
	public void setFechas(List<LocalDate> fechas)
	{
		this.fechas = fechas;
	}



}
