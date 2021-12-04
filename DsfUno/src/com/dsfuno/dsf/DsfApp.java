package com.dsfuno.dsf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dsfuno.dsf.model.Periodo;

/**
 * Solución Desafio Previred, desafio de PreviRed para el proceso de
 * postulación. Francisco Devaud - francisco.devaud@gmail.com
 * 
 **/

public class DsfApp {

	public static void main(String[] args) {
		System.out.println("Solución Desafio Previred");
		readJson(args[0].toString(), args[1].toString());
	}

	@SuppressWarnings("unchecked")
	public static void readJson(String fileINName, String fileOUTName) {

		if (!fileINName.equals(null)) {
			System.out.println("fileINName " + fileINName);

		} else {

			System.out.println("fileINName null");
		}

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(fileINName)) {

			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;
			System.out.println(employeeList);

			employeeList.forEach(dsf -> operacionJson((JSONObject) dsf, fileOUTName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void operacionJson(JSONObject periodos, String fileOUTName) {

		System.out.println("\n--------------------------------------------------\n");

		JSONObject periodoRead = (JSONObject) periodos;

		JSONArray subJson = (JSONArray) periodoRead.get("fechas");
		Iterator<String> iterator = subJson.iterator();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		List<LocalDate> fechasList = new ArrayList<>();

		JSONArray subJsonB = (JSONArray) periodoRead.get("fechas");
		Iterator<String> iterator2 = subJsonB.iterator();
		while (iterator2.hasNext()) {

			LocalDate localDate = LocalDate.parse(iterator2.next(), formatter);

			fechasList.add(localDate);
		}

		Periodo periodo = new Periodo();
		periodo.setId((String) periodoRead.get("id").toString());
		periodo.setFechaCreacion((String) periodoRead.get("fechaCreacion"));
		periodo.setFechaFin((String) periodoRead.get("fechaFin"));
		periodo.setiFechas(iterator);

		System.out.println("\nPeriodos Entregados\n");
		while (periodo.getiFechas().hasNext()) {
			System.out.println(iterator.next());
		}

		LocalDate ldFechaInicio = LocalDate.parse(periodo.getFechaCreacion(), formatter);
		LocalDate ldFechaFin = LocalDate.parse(periodo.getFechaFin(), formatter);

		List<LocalDate> recibe = faltantesPeriodos(ldFechaInicio, ldFechaFin, fechasList);
		System.out.println("\nPeriodos Faltantes\n");
		for (LocalDate localDate2 : recibe) {

			System.out.println(localDate2);

		}

		System.out.println("Escribe archivo");
		escribirFile(periodo.getId(), periodo.getFechaCreacion(), periodo.getFechaFin(), recibe, fileOUTName);

	}

	public static List<LocalDate> faltantesPeriodos(LocalDate ldFechaInicio, LocalDate ldFechaFin,
			List<LocalDate> fechasList) {
		Set<LocalDate> fechaTemp = new HashSet<LocalDate>();
		while (ldFechaInicio.isBefore(ldFechaFin)) {
			ldFechaInicio = ldFechaInicio.plusMonths(1);
			Boolean flag = false;
			for (LocalDate auxFechas : fechasList) {
				if (auxFechas.equals(ldFechaInicio))
					flag = true;
			}
			if (!flag)
				fechaTemp.add(ldFechaInicio);
		}

		return fechaTemp.stream().sorted().collect(Collectors.toList());
	}

	public static void escribirFile(String strID, String fechaCrea, String fechaFin, List<LocalDate> fechasList,
			String nombreOutPut)

	{

		JSONObject desafioJsn = new JSONObject();
		desafioJsn.put("id", strID);
		desafioJsn.put("fechaCreacion", fechaCrea);
		desafioJsn.put("fechaFin", fechaFin);

		JSONArray listaFechasFaltantes = new JSONArray();
		for (LocalDate fecha : fechasList) {
			listaFechasFaltantes.add(fecha.toString());
		}

		desafioJsn.put("fechasFaltantes", listaFechasFaltantes);

		JSONObject desafioObj = new JSONObject();
		desafioObj.put("", desafioJsn);

		JSONArray employeeList = new JSONArray();
		employeeList.add(desafioObj);

		try (FileWriter file = new FileWriter(nombreOutPut)) {

			file.write(employeeList.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
