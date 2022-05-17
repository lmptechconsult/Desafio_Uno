package com.previred.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.domain.Periodo;
import com.previred.util.ConversionUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileWrite {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileWrite.class);

	public void writeFile(Periodo periodo, String pathname) {
		ConversionUtil conversionUtil = new ConversionUtil();
		PrintWriter file = null;
		ObjectMapper mapper = new ObjectMapper();
		
		String fecha = conversionUtil.parseaDate(new Date());
		
		try {
			file = new PrintWriter(new File(pathname + "_" + fecha + ".json"));
			
			file.print(mapper.writeValueAsString(periodo));
		} catch (FileNotFoundException e) {
			LOGGER.error("Error en la generacion de los archivos", e);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error en el proceso del formato Json", e);
		} finally {
			if (file != null) {
				file.close();			
			}
		}
	}
	
}
