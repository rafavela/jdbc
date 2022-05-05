package com.dragonfruit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dragonfruit.exception.NotFoundException;
import com.dragonfruit.model.PersonBean;
import com.dragonfruit.util.ApplicationConstants;

@Repository
public class PersonDao {

	@Autowired
	private JdbcTemplate template;
	
	@Value("${person.list}")
	private String personQuery;
	
	@Value("${person.record}")
	private String personRecord;
	
	@Value("${person.insert}")
	private String personInsert;
			
	public List<PersonBean> getPersonList() {
		return template.query(personQuery, rowMapper);
	}	
	
	private RowMapper<PersonBean> rowMapper = (rs,rowNum) ->{
		PersonBean person = new PersonBean();
		person.setFirstName(rs.getString(ApplicationConstants.FIRST_NAME));
		person.setLastName(rs.getString(ApplicationConstants.LAST_NAME));
		person.setEmail(rs.getString(ApplicationConstants.EMAIL));
		return person;
	};
	
	public PersonBean getPersonByEmail(String email) {
		 return template.query(personRecord, 
				preparedStatement -> {
					preparedStatement.setString(1, email);
				}, 
				rowMapper)
		 	.stream()
		 	.findFirst()
		 	.orElseThrow(()->new NotFoundException(email));
	}
	
	
	public void savePerson(PersonBean personBean) {		
		template.update(personInsert, 
			preparedStatement -> {
				preparedStatement.setString(1, personBean.getFirstName());
				preparedStatement.setString(2, personBean.getLastName());
				preparedStatement.setString(3, personBean.getEmail());
			});
	}
}
