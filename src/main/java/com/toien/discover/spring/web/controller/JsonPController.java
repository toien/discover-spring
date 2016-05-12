package com.toien.discover.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/jsonp")
public class JsonPController {
	
	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello(@RequestParam String callback, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("id", 1L);
		result.put("name", "Toien");
		result.put("age", 11);

		response.setHeader("Content-Type", "text/javascript");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<String>(callback + "('nihao')", responseHeaders, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	public String hello2(@RequestParam String callback, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("id", 1L);
		result.put("name", "Toien");
		result.put("age", 11);

		response.setHeader("Content-Type", "text/javascript");

		String serialized = null;
		try {
			serialized = this.mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return callback + "(" + serialized + ")";
	}

}
