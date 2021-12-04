package com.example.desafio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.desafio1.clases.Periodo;

import reactor.core.publisher.Mono;

public class GddExtController
{
	@Autowired
    @Qualifier("REST_CLIENT_API_PERIOD")
	WebClient apiPeriodClient;
	
	public Periodo getOnePeriod()
	{
		try
		{
	        return apiPeriodClient.get().uri("/api").
	                retrieve().bodyToMono(Periodo.class).
	                block();
		}
		catch(Throwable te)
		{
			te.printStackTrace();
		}
		return null;
	}
}
