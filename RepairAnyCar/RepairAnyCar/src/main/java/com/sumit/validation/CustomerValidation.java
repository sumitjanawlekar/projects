package com.sumit.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sumit.pojo.Customer;

public class CustomerValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
