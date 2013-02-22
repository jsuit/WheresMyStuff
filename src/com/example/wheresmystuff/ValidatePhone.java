package com.example.wheresmystuff;

public class ValidatePhone {

	
	protected static String validate(String phone){
		
		if (phone == null || "".compareTo(phone) == 0 || !phone.matches("(0-9){10,11}")) {
			return null;
		}
		return "Invalid Phone Number\n";
			
	}
	
}