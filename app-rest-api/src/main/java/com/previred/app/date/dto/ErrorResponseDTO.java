package com.previred.app.date.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDTO {

	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date timestamp;
	private String error;
}
