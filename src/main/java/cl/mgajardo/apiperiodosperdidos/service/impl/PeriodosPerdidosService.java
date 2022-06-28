package cl.mgajardo.apiperiodosperdidos.service.impl;
import cl.mgajardo.apiperiodosperdidos.service.IPeriodosPerdidosService;
import cl.mgajardo.apiperiodosperdidos.viewmodel.Periodo;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PeriodosPerdidosService implements IPeriodosPerdidosService {
	
	RestTemplate rest = new RestTemplate();
	
	@Override
	public Periodo getPeriodos(String urlapigdd) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Accept", "application/json");
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Periodo> response = rest.exchange(urlapigdd, HttpMethod.GET, entity, Periodo.class, "1");
		Periodo retornoPeriodo = new Periodo();
		retornoPeriodo.setFechaCreacion(response.getBody().getFechaCreacion());
		retornoPeriodo.setFechaFin(response.getBody().getFechaFin());
		retornoPeriodo.setFechas(response.getBody().getFechas());
		retornoPeriodo.setId(response.getBody().getId());
		return retornoPeriodo;
	}
}
