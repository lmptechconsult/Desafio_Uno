package com.miSolucion.demo;

import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SpringBootApplication
public class MiSolucionApplication {

public static void main(String[] args){
		
		escribir();
		leer();


		}

		private static void leer() {
		JSONParser jsonParser = new JSONParser();

		try(FileReader reader = new FileReader("fechas.json")){
		Object obj = jsonParser.parse(reader);

		JSONObject archivoFechas = (JSONObject) obj;
		System.out.println("El Archivo contien el siguiente JSON");
		System.out.println(archivoFechas);
			
			String fechaCreacion = (String) archivoFechas.get("fechaCreacion");
			
			String anoCreacion = (String) fechaCreacion.subSequence(0, 4);
			String mesCreacion = (String) fechaCreacion.subSequence(5, 7);
			
			int ianoCreacion = Integer.parseInt(anoCreacion);  
			int imesCreacion = Integer.parseInt(mesCreacion);
			
			
			String fechaFin = (String) archivoFechas.get("fechaFin");
			
			String anoFin = (String) fechaFin.subSequence(0, 4);
			String mesFin = (String) fechaFin.subSequence(5, 7);
			
			int ianoFin = Integer.parseInt(anoFin);  
			int imesFin = Integer.parseInt(mesFin);

			JSONArray fechasList = (JSONArray) archivoFechas.get("fechas");
			
			int i = 1;
			
			List<String> sfechaList = new ArrayList<String>();
			
			int j = 0;
			for(Object fecha: fechasList) {
				//System.out.println(fecha);
				sfechaList.add((String) fechasList.get(j));
				j++;
				
				
				
				
			}
			
			int size = sfechaList.size();
			String[] stringArrayFechaList = sfechaList.toArray(new String[size]);
			
			for (String s : stringArrayFechaList) {
	            System.out.println(s);
				
				String anoArray = (String) s.substring(0, 4);
				String mesArray = (String) s.substring(5, 7);
			
				
				Integer ianoArray = Integer.parseInt(anoArray);  
				Integer imesArray = Integer.parseInt(mesArray);
				
				if(ianoArray >= ianoCreacion || ianoArray <= ianoFin) {
					while (i < imesArray) {
						
						System.out.println("Faltante: "+anoArray+"-"+"0"+i+"-"+"01");
						i++;
						
					}
					i++;
					System.out.println(mesArray);
					
						
				}
	        }
	


		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}

}

		

		private static void escribir() {

		JSONArray fechasList = new JSONArray();
		fechasList.add("1969-03-01");
		fechasList.add("1969-05-01");
		fechasList.add("1969-09-01");
		fechasList.add("1970-01-01");
		

		JSONObject archivoFechas = new JSONObject();

		archivoFechas.put("id", 6);
		archivoFechas.put("fechaCreacion", "1969-03-01");
		archivoFechas.put("fechaFin", "1970-01-01");

		archivoFechas.put("fechas", fechasList);

		try(FileWriter file = new FileWriter("fechas.json")){
		file.write(archivoFechas.toJSONString());
		file.flush();
		}catch(IOException e) {
		e.printStackTrace();
		}



		}
		
		
	}