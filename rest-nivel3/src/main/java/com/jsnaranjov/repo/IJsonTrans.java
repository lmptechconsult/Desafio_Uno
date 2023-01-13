package com.jsnaranjov.repo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Jaime Sebastián Naranjo V
 * @version 1.0.0
 */

@Component
public interface IJsonTrans{

	public int getId();
	public void setId(int id);

	public Date getFechaCreacion();
	public void setFechaCreacion(Date fechaCreacion);

	public Date getFechaFin();
	public void setFechaFin(Date fechaFin);

	public List<Date> getFechas();
	public void setFechas(List<Date> fechas);
	
	public List<Date> obtenerFechasFaltantes();

}
