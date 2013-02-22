package com.example.wheresmystuff;

public class ValidateName {

	
	protected static boolean validate(String name){
		if (name.compareTo("") == 0 || name == null) {
			return false;
		}
		
		return true;
		
	}
}
