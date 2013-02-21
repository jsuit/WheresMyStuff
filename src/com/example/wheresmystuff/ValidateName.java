package com.example.wheresmystuff;

public class ValidateName {

	
<<<<<<< HEAD
	protected static String validate(String name){
		if (name.compareTo("") == 0 || name == null) {
			return "Invalid Name\n";
		}
		
		return null;
=======
	protected static boolean validate(String name){
		if(null == name) return false;
		return true;
>>>>>>> bug fix
		
	}
}
