package cl.mgajardo.apiperiodosperdidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ApiConfig {
		
	@Bean
	public ObjectMapper mapper() throws ParseException {
		ObjectMapper objectMapper = new ObjectMapper();
	     objectMapper = JsonMapper.builder()
	    		    .addModule(new JavaTimeModule())
	    		    .build();
	     return objectMapper;
	}
	
}
