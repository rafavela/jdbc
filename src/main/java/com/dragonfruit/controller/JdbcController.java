package com.dragonfruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dragonfruit.model.PersonBean;
import com.dragonfruit.service.PersonService;

@RestController
@RequestMapping("/v1")
public class JdbcController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/person")
	public List<PersonBean> getPersonList(){
		return personService.getPersonList();
	}
	
	@GetMapping("/person/{email}")
	public PersonBean getPersonByPathVar(@PathVariable String email) {	
		return personService.getPersonByEmail(email);
	}
	
	@GetMapping("/person/search")
	public PersonBean getPersonByParameter(@RequestParam String email) {
		return personService.getPersonByEmail(email);
	}		
}
