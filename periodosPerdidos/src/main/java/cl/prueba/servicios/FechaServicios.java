package cl.prueba.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.prueba.modelos.Dato;
import cl.prueba.modelos.FechaFaltante;

@SuppressWarnings("deprecation")
@Service
public class FechaServicios implements IFechasServicios {

	private Gson gson = new Gson();
	private List<String> datos = new ArrayList<String>();
	private FechaFaltante fechaFaltante;

	@SuppressWarnings("resource")
	@Override
	public void GeneradorDeDatos(String entrada, String salida) {
		borrarArchivo(entrada,salida);
		try {
			DefaultHttpClient Client = new DefaultHttpClient();

			HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/periodos/api");

			httpGet.setHeader("accept", "application/json");

			HttpResponse response = Client.execute(httpGet);

			BufferedReader breader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = breader.readLine()) != null) {
				Dato dt = new Gson().fromJson(line, Dato.class);
				String json = gson.toJson(dt);
				addDatos(json, entrada);
			}
			breader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addDatos(String json, String nombreJson) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreJson+".json", true))) {
			bw.write(json);
			bw.newLine();

		} catch (IOException ex) {
			Logger.getLogger("error al leer Json " + ex);
		}
	}

	@Override
	public void CreateFechasFaltantes(String salida, String entrada) {
		try (BufferedReader br = new BufferedReader(new FileReader(entrada+".json"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				Dato dt = new Gson().fromJson(linea, Dato.class);
				datos = fechasFaltantes(dt);
				fechaFaltante = new FechaFaltante(dt.getId(), dt.getFechaCreacion(), dt.getFechaFin(), datos);
				String json = gson.toJson(fechaFaltante);
				addDatos(json, salida);
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	// Metodo para buscar las fechas que faltan por cada id
	@Override
	public List<String> fechasFaltantes(Dato dato) {

		int yearCreacion = Integer.parseInt(dato.getFechaCreacion().substring(0, 4));
		int mesCreacion = Integer.parseInt(dato.getFechaCreacion().substring(5, 7));
		int yearFin = Integer.parseInt(dato.getFechaFin().substring(0, 4));
		int mesFin = Integer.parseInt(dato.getFechaFin().substring(5, 7));
		List<Integer> mes = new ArrayList<Integer>();
		List<String> fechaFaltante = new ArrayList<String>();

		for (int contador = yearCreacion; contador <= yearFin; contador++) {
			int largoMeses = 12;
			mes.clear();
			for (String elemento : dato.getFechas()) {
				if (contador == Integer.parseInt(elemento.substring(0, 4))) {
					mes.add(Integer.parseInt(elemento.substring(5, 7)));
				}
			}

			if (contador > yearCreacion) {
				mesCreacion = 1;
			}
			if (contador == yearFin) {
				largoMeses = mesFin;
			}
			for (int i = mesCreacion; i <= largoMeses; i++) {
				if (!mes.contains(i)) {
					if (i < 10) {
						fechaFaltante.add(contador + "-0" + i + "-01");
					} else {
						fechaFaltante.add(contador + "-" + i + "-01");
					}
				}
			}

		}
		return fechaFaltante;
	}

	@Override
	public List<FechaFaltante> ReadFechasFaltantes(String salida) {
		List<FechaFaltante> fechasRespuesta = new ArrayList<FechaFaltante>();
		try (BufferedReader br = new BufferedReader(new FileReader(salida+".json"))) {
			String linea;
			
			while ((linea = br.readLine()) != null) {
				FechaFaltante dt = new Gson().fromJson(linea, FechaFaltante.class);
				fechaFaltante = new FechaFaltante(dt.getId(), dt.getFechaCreacion(), dt.getFechaFin(), dt.getFechasFaltantes());
		    	 fechasRespuesta.add(fechaFaltante);				
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}		
		return fechasRespuesta;
	}
	
	public static void borrarArchivo(String entrada, String salida){
		File file = new File(salida+".json");
		if(file.exists()){
			if(file.delete()){
				System.out.println("Se eliminó el fichero");
			}
		}else{
			System.out.println("El fichero no existe.");
		}
		 file = new File(entrada+".json");
		if(file.exists()){
			if(file.delete()){
				System.out.println("Se eliminó el fichero");
			}
		}else{
			System.out.println("El fichero no existe.");
		}
	}
}
