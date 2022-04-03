package com.previred.app.date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.previred.app")
public class ApplicationConfig {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}

}
