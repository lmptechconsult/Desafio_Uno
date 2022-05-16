package com.desafio.uno.config;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomLocalDateSerializer extends JsonSerializer<Object> {


	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

		if(value instanceof Set<?>) {
			Set<LocalDate> faltantes = (Set<LocalDate>) value;
			gen.writeStartArray(faltantes.size());
			for (LocalDate localDate : faltantes) {
				gen.writeString(localDate.toString());
			}
			gen.writeEndArray();
			return;
		}
		
		gen.writeString(((LocalDate)value).toString());
	}

}
