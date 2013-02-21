package com.example.wheresmystuff;

public class ValidatePhone {

	
	protected static boolean validate(String phone){
		
		if (phone == null) {
			return true;
		}
		return phone.matches("(0-9){10,11}");
			
	}
	
}
