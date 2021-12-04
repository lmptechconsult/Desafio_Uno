package com.example.desafio1.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio1.clases.Periodo;

@RestController
@RequestMapping("/demo")
public class DemoApiController extends GddExtController
{
	
	@GetMapping("/solved")
    @ResponseBody
    public ResponseEntity<Periodo> getDemoSolved() {
		
		try 
		{
	   	   Periodo period = getOnePeriod();
		   if(period != null)
		   {
			    Collections.sort(period.getFechas());
				getMissingPeriod(period);
				return new ResponseEntity<>(period, HttpStatus.OK);
		   }
        } 
		catch (Exception e) 
		{
		   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	   return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	                    
    }
	 
	private static void getMissingPeriod(Periodo period)
	{
		List<LocalDate> dateList = period.getFechas();
		
		if(period.getFechasFaltantes() == null)
		{
			period.setFechasFaltantes(new ArrayList<>());
		}
		
		int contador = 0;
		for (ListIterator<LocalDate> iterator = dateList.listIterator(); iterator.hasNext(); )
		{
			if(iterator.hasNext() && iterator.nextIndex() < dateList.size() - 1)
			{
				LocalDate firstDate = iterator.next();
				LocalDate nextDate = dateList.get(iterator.nextIndex());
			    
			    if(firstDate != null && nextDate != null)
			    {
			    	Period diff = Period.between((firstDate).withDayOfMonth(1),(nextDate).withDayOfMonth(1));
					
					if(diff.getMonths() > 0)
					{
						addMissingMonths(firstDate, diff.getMonths(), period.getFechasFaltantes());
					}
			    }
			}
			else
			{
				break;
			}
		}
	}
	
	private static void addMissingMonths(LocalDate firstDate, int difMeses, List<LocalDate> missingDateList) 
	{
		for (int i = 1; i < difMeses; i++)
		{
			LocalDate missingDate = (firstDate).plusMonths(i);
			missingDateList.add(missingDate);
		}
	}
	
}
