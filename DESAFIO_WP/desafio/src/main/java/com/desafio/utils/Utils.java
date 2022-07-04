package com.desafio.utils;

import java.util.Collection;

public class Utils {
	
	private Utils() {
		throw new IllegalStateException("Utils class no se puede instanciar");
		}
	
	
	/**
	* Método para validar si una colección es nula o está vacía.
	*
	* @param c
	*            Collection a evaluar
	* @return true si está nula o vacía, false en caso contrario
	* @author W.Pacheco
	*/
	public static boolean isNullOrEmpty(final Collection<?> c) {
	return (c == null || c.isEmpty());
	}
	

}
