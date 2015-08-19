package com.toien.discover.spring.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toien.discover.spring.vo.Person;

@RestController
@RequestMapping("/json")
public class JSONController {
	@RequestMapping(value="/map", method = RequestMethod.GET)
	public Map<String, Object> map() {
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("id", 1L);
		result.put("name", "Toien");
		result.put("age", 11);

		return result;

	}
	@RequestMapping(value="/string", method = RequestMethod.GET)
	public Map<String, Object> string() {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("id", 1L);
		result.put("name", "Toien");
		result.put("age", 11);
		
		return result;
		
	}
	@RequestMapping(value="/vo", method = RequestMethod.GET)
	public Person dto() {
		
		return new Person("SSH", 133);
		
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST, consumes="application/json;charset=UTF-8")
	public Person create(@RequestBody Person p) {
		
		System.out.println(p);
		
		return p;
	}
	
	@RequestMapping(value="/put", method = RequestMethod.PUT)
	public Person put(@RequestBody Person[] persons) {
		
		System.out.println(persons);
		
		return persons[0];
	}
	
	@RequestMapping(value="/putform", method = RequestMethod.PUT)
	public Person form(@RequestParam String name) {
		
		System.out.println(name);
		
		return new Person(name, 22);
	}
	
	@RequestMapping(value="/putjson", method = RequestMethod.PUT)
	public Person putjson(@RequestBody Person p) {
		return p;
	}
	
}
