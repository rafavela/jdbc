package com.dragonfruit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonBean {
	public String firstName;
	public String lastName;
	public String email;
}
