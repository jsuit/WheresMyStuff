package com.example.wheresmystuff;

public class ValidateName {

	
	protected static String validate(String name){
		if (name.compareTo("") == 0 || name == null) {
			return "Invalid Name\n";
		}
		
		return null;

		
	}
}
