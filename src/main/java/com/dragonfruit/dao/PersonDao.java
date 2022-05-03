package com.dragonfruit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dragonfruit.model.PersonBean;
import com.dragonfruit.util.ApplicationConstants;

@Repository
public class PersonDao {

	@Autowired
	private JdbcTemplate template;
	
	@Value("${person.list}")
	private String personQuery;
	
	public List<PersonBean> getPersonList() {
		System.out.println("personQuery "+personQuery);
		
		return template.query(personQuery, (rs,rowNum) ->{
			PersonBean person = new PersonBean();
			person.setFirstName(rs.getString(ApplicationConstants.FIRST_NAME));
			person.setLastName(rs.getString(ApplicationConstants.LAST_NAME));
			person.setEmail(rs.getString(ApplicationConstants.EMAIL));
			return person;
		});
	}	
	
	
	
}
