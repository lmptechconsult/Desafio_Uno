package com.previred.periods.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class MissedPeriodsValuesConfig.
 */
@Configuration
public class MissedPeriodsValuesConfig {
	
	/** The url service gdd. */
	@Value("${url.service.gdd}")
	private String urlServiceGdd;

	/**
	 * Gets the url service gdd.
	 *
	 * @return the url service gdd
	 */
	public String getUrlServiceGdd() {
		return urlServiceGdd;
	}
	
}
