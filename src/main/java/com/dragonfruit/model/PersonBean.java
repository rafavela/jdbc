package com.dragonfruit.model;

import com.dragonfruit.util.ApplicationConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonBean {
	public String firstName = ApplicationConstants.NOT_FOUND;
	public String lastName = ApplicationConstants.NOT_FOUND;
	public String email = ApplicationConstants.NOT_FOUND;
}
