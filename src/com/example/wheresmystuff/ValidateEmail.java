package com.example.wheresmystuff;

public class ValidateEmail {

<<<<<<< HEAD
	protected static boolean validate(String addr){
		
		return false;
		
		
=======
	protected static String validate(String addr){
		if(addr.matches("[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[@]+[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[(com)|(org)|(net)]+")) {
			return null;
		}
		else return "Invalid Email\n";	
>>>>>>> master
	}
	
}
