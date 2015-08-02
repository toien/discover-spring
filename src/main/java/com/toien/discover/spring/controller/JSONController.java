package com.toien.discover.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class JSONController {
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Map<String, Object> getUser(
			@PathVariable(value = "id") String id) {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("id", 1L);
		result.put("name", "Toien");
		result.put("age", 11);

		return result;

	}
}
