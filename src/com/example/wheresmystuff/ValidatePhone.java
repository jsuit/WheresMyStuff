package com.example.wheresmystuff;

public class ValidatePhone {

	
	protected static boolean validate(String phone){
		
		if (phone == null || phone.compareTo("") == 0) {
			return false;
		}
		return true;
				//phone.matches("(0-9){10,11}");
			
	}
	
}
