package cl.previred.desafiouno.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.previred.desafiouno.entity.Fecha;
import cl.previred.desafiouno.entity.Periodo;

@Repository
public class PeriodoDAOImpl implements PeriodoDAO {
	
	@Override
	public List<Periodo> getPeriodos(String fechainicio, String fechafin) {
		
		List<Periodo> listaPeriodo = new ArrayList();
		List<Fecha> listafechas = new ArrayList();

		try {
			double d1=Double.parseDouble(fechainicio);
			Double D1 = d1;
			
			d1=Double.parseDouble(fechafin);
			D1 = d1;
			
			if(D1.isNaN()) {
				return listaPeriodo;
			}
		}catch(NumberFormatException nfe){
			return listaPeriodo;
		}
		
		if(fechainicio.length()!=8) {
			return listaPeriodo;
		}
		
		if(fechafin.length()!=8) {
			return listaPeriodo;
		}
		
		int anio = Integer.parseInt(fechainicio.substring(0,4));
		int mes = Integer.parseInt(fechainicio.substring(4,6));
		int dia = Integer.parseInt(fechainicio.substring(6,fechainicio.length()));
		
		Calendar cal = Calendar.getInstance();
//		cal.set(2022, 00, 01);
		cal.set(anio, (mes - 1), dia);
		Date fechaInicio = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//		cal.set(2022, 04, 01); //Year, month and day of month
		anio = Integer.parseInt(fechafin.substring(0,4));
		mes = Integer.parseInt(fechafin.substring(4,6));
		dia = Integer.parseInt(fechafin.substring(6,fechainicio.length()));

		cal.set(anio, (mes - 1), dia);
		Date fechaFin = cal.getTime();

		List<String> result = new ArrayList<String>();

		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(fechaInicio);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(fechaFin);
		result.add(sdf.format(fechaInicio));
		while (tempStart.before(tempEnd)) {
			if(sdf.format(tempStart.getTime()).substring(8, sdf.format(tempStart.getTime()).length()).equalsIgnoreCase("01")) {
				result.add(sdf.format(tempStart.getTime()));
				Fecha fecha =  new Fecha();
				fecha.setFecha(sdf.format(tempStart.getTime()));
				listafechas.add(fecha);
			}
			
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}

//		for (int i=0;i<result.size(); i++) {
//			System.out.println(result.get(i));
//		}

		Date myDate = new Date();
		Periodo periodo = new Periodo();
		periodo.setId(1);

		try {

			myDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechainicio.substring(0,4) + "-" + fechainicio.substring(4,6) + "-" + fechainicio.substring(6,fechainicio.length()));
			periodo.setFechaCreacion(new SimpleDateFormat("dd-MM-yyyy").format(myDate));

			myDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechafin.substring(0,4) + "-" + fechafin.substring(4,6) + "-" + fechafin.substring(6,fechainicio.length()));
			periodo.setFechaFin(new SimpleDateFormat("dd-MM-yyyy").format(myDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		periodo.setFechasFaltantes(listafechas);
		
		listaPeriodo.add(periodo);
		
		return listaPeriodo;
	}

}
