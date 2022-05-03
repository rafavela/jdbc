package com.dragonfruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragonfruit.model.PersonBean;
import com.dragonfruit.service.PersonService;

@RestController
@RequestMapping("/v1")
public class JdbcController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/person")
	public List<PersonBean> getPerson(){
		return personService.getPersonList();
	}
}
