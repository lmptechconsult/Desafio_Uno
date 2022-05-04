package com.previred.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class GsonLocalDateTypeAdapter extends TypeAdapter<LocalDate> {

	@Override
	public void write(JsonWriter out, LocalDate value) throws IOException {
		out.value(value.format(DateTimeFormatter.ISO_LOCAL_DATE));		
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		return LocalDate.parse(in.nextString(), DateTimeFormatter.ISO_LOCAL_DATE);
	}
  
}