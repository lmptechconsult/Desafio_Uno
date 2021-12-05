package com.devru.desafiouno.webservices;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

/***
 * 
 * @author devru
 *
 */
public class ResponseHandler {
	
    public static HashMap<String, Object> generateResponse(String message, HttpStatus status, Object responseObj) {
    	HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        return map;
    }
}
