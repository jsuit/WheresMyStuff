package com.example.wheresmystuff;

public class ValidateEmail {

	protected static boolean validate(String addr){
		
		boolean value= addr.matches("[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[@]+[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[(com)|(org)|(net)]+");
		return value;
		
	}
	
}
