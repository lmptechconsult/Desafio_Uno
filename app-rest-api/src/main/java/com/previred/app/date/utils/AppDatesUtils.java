package com.previred.app.date.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@Slf4j
public class AppDatesUtils {
	
 
	/**
	 * Metodo que genera una fecha a partir de un año y mes.
	 * @param year
	 * @param month
	 * @return
	 */
	public static String generatedEvalDate(Integer year, Integer month){
		StringBuilder date = new StringBuilder();
		date.append(year);
		date.append("-");
		date.append(month < 10 ? "0" + month : month);
		date.append("-");
		date.append("01");
		if(log.isDebugEnabled())
			log.debug("DATE GENERATED: {}", date.toString());
		return date.toString();
	}	
}
