package cl.mgajardo.apiperiodosperdidos.service;

import cl.mgajardo.apiperiodosperdidos.viewmodel.Periodo;

public interface IPeriodosPerdidosService {
	
	//servicio para la obtención de los periodos
	public Periodo getPeriodos(String urlgdd);

}
