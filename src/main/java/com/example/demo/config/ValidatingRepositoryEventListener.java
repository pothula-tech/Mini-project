package com.example.demo.config;

import javax.validation.Validator;

import org.springframework.util.MultiValueMap;
//to handle the bad request
public class ValidatingRepositoryEventListener 

{
	private MultiValueMap<String, Validator> validators;
	
	public ValidatingRepositoryEventListener addValidator(String event, Validator validator) {
		validators.add(event, validator);
		return this;
	}

}
