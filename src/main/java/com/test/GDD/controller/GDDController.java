package com.test.GDD.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.GDD.core.GDDCore;
import com.test.GDD.model.ScheduleDTO;
import com.test.GDD.model.ScheduleFullResponseDTO;
import com.test.GDD.model.ScheduleResponseDTO;

import io.swagger.annotations.Api;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
@Api("Resource REST Endpoint for GDD")
public class GDDController {

	private GDDCore gddCore;

	@Autowired
	public GDDController(GDDCore gddCore){
		this.gddCore = gddCore;
	}


	@GetMapping("/d1/gdd/schedule/randomdate")
    public ResponseEntity<ScheduleDTO> GetSchedule(@RequestParam String fechaInicio, @RequestParam String fechaFin,
	HttpServletResponse response) throws IOException {
		ResponseEntity<ScheduleDTO> responseEntity = null;
		try {

			ScheduleDTO scheduleDTO = gddCore.DoListRandomDate(fechaInicio, fechaFin);

			if (scheduleDTO == null) {
				response.sendError(HttpStatus.NOT_FOUND.value(), "");
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(scheduleDTO);
			}

		}catch(Exception e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "");
		}
		return responseEntity;
    }

    @PostMapping("/n1/gdd/schedule/readfile")
    public ResponseEntity<ScheduleResponseDTO> GetScheduleReadFile(HttpServletResponse response) throws IOException {
		ResponseEntity<ScheduleResponseDTO> responseEntity = null;
		try {

			ScheduleResponseDTO result = gddCore.DoReadFile();

			if (result == null) {
				response.sendError(HttpStatus.NOT_FOUND.value(), "");
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.OK).build();
			}

		}catch(Exception e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "");
		}
		return responseEntity;
    }



	@PostMapping("/n2/gdd/schedule/writetextplain")
    public ResponseEntity<?> GetScheduleWriteTextPlain(HttpServletResponse response) throws IOException {
		ResponseEntity<?> responseEntity = null;
		try {

			boolean isValid = gddCore.WriteFileTextPlain();
			if (!isValid) {
				response.sendError(HttpStatus.NOT_FOUND.value(), "");
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.OK).build();
			}

		}catch(Exception e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "");
		}
		return responseEntity;
    }

	@PostMapping("/n3/gdd/schedule")
    public ResponseEntity<ScheduleFullResponseDTO> GetScheduleFull(@RequestBody ScheduleDTO scheduleDTO,
	HttpServletResponse response) throws IOException {
		ResponseEntity<ScheduleFullResponseDTO> responseEntity = null;
		try {

			ScheduleFullResponseDTO result = gddCore.GetScheduleFull(scheduleDTO);
			if (result == null)  {
				response.sendError(HttpStatus.NOT_FOUND.value(), "");
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(result);
			}

		}catch(Exception e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "");
		}
		return responseEntity;
    }
}
