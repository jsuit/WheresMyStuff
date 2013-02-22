package com.example.wheresmystuff;

public class ValidateName {

	
<<<<<<< HEAD
	protected static boolean validate(String name){
		if(null == name) return false;
		return true;
=======
	protected static String validate(String name){
		if (name.compareTo("") == 0 || name == null) {
			return "Invalid Name\n";
		}
		
		return null;
>>>>>>> master
		
	}
}
