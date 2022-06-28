package cl.prueba.servicios;

import java.util.List;



import cl.prueba.modelos.Dato;
import cl.prueba.modelos.FechaFaltante;

public interface IFechasServicios {

	
	public void GeneradorDeDatos(String entrada, String Salida);
	public void addDatos(String json, String nombreJson);
	public void CreateFechasFaltantes(String salida,String entrada);
	public List<String> fechasFaltantes(Dato dato);
	public List<FechaFaltante> ReadFechasFaltantes(String salida);
}
