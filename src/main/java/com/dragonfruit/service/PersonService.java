package com.dragonfruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonfruit.dao.PersonDao;
import com.dragonfruit.model.PersonBean;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;

	public List<PersonBean> getPersonList() {
		return personDao.getPersonList();
	}

	public PersonBean getPersonByEmail(String email) {
		return personDao.getPersonByEmail(email);
	}	
}
