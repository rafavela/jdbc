package com.dragonfruit.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dragonfruit.model.PersonBean;

@Repository
public class PersonDao {
	
	public List<PersonBean> getPersonList() {
		PersonBean person1 = new PersonBean("Rafael", "Velazquez", "test@test.com");
		PersonBean person2 = new PersonBean("Lupe", "Vazquez", "test2@test.com");
		PersonBean person3 = new PersonBean("Jimena", "Rosas", "test3@test.com");
		
		return Arrays.asList(person1,person2,person3);
	}	
	
}
