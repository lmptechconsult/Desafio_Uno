package com.danilo.ch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danilo.ch.model.Fecha;
import com.google.gson.Gson;

@SpringBootApplication
public class Nivel2Application {

	public static void main(String[] args) {
		// SpringApplication.run(Nivel2Application.class, args);

		String json = SimplestGetExample.consumeApi();
		Gson g = new Gson();
		Fecha fecha = g.fromJson(json, Fecha.class);

		String inicioStr = fecha.getFechaCreacion();
		String finStr = fecha.getFechaFin();

		//obtener lista desde fecha inicio a fecha fin
		List<String> listaInterna = createCompleteList(getYear(inicioStr), getYear(finStr), getMonth(inicioStr), getMonth(finStr));

		String[] fechasApi = fecha.getFechas();
		//convertir array de fechas a lista
		List<String> listaApi = Arrays.asList(fechasApi);
		List<String> fechasFaltantes = new ArrayList<String>();
		File file = new File(args[0] + "/Result.txt");
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter buff = new BufferedWriter(fw);
			buff.write("Fecha creación: " + inicioStr);
			buff.newLine();
			buff.write("Fecha fin: " + finStr);
			buff.newLine();
			buff.write("fechas recibidas:  "+ listaApi);
			buff.newLine();

		for (String item : listaInterna) {
			if(!item.equals(inicioStr)) {
				if (!listaApi.contains(item)) {
					fechasFaltantes.add(item);
				}
			}
		}
		buff.write("fechas faltantes:  " + fechasFaltantes);
		buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static String formatDate(int anio, String mes) {
		return mes.length() > 1 ? anio + "-" + mes + "-01" : anio + "-" + "0" + mes + "-01";
	}

	public static List<String> createCompleteList(int inicioInt, int terminoInt, int mes, int mesFin) {
		List<String> list = new ArrayList<String>();
		while (inicioInt <= terminoInt) {
			// aumentar mes
			while (mes <= 12) {
				list.add(formatDate(inicioInt, String.valueOf(mes)));
				mes++;
				if (inicioInt == terminoInt && mes == mesFin) {
					break;
				}
			}
			mes = 1;
			// aumentar anio
			inicioInt++;
		}
		return list;
	}

	public static int getMonth(String date) {
		return Integer.parseInt(date.substring(5, 7));
	}

	public static int getYear(String date) {
		return Integer.parseInt(date.substring(0, 4));
	}

}
