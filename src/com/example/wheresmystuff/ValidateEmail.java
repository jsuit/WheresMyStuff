package com.example.wheresmystuff;

public class ValidateEmail {

<<<<<<< HEAD
<<<<<<< HEAD
=======
	
		

>>>>>>> fix weird things
	protected static String validate(String addr){
		if(addr.matches("[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[@]+[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[(com)|(org)|(net)]+")) {
			return null;
		}
		else return "Invalid Email\n";	
<<<<<<< HEAD
=======
	protected static boolean validate(String addr){
		
		return false;
		
		
>>>>>>> bug fix
=======

>>>>>>> fix weird things
	}
	
}
