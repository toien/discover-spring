package com.toien.discover.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JSONController {
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public Map<String, Object> getMap() {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("id", 1L);
		result.put("name", "Toien");
		result.put("age", 11);

		return result;

	}
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String getString() {
		return "Shit";
	}
}
