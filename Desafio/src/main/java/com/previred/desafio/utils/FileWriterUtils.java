package com.previred.desafio.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterUtils {

	public static void FileWrite(String json_object, String path) throws IOException {

		try {
			FileWriter fileWriter = new FileWriter(path);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(json_object);
			printWriter.close();

		} catch (Exception e) {

			new Exception("Error en la escritura del archivo " + path);
		}

	}

}
