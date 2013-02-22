package com.example.wheresmystuff;

public class ValidatePhone {

	
	protected static boolean validate(String phone){
		
		if (phone == null || phone.compareTo("") == 0) {
			return true;
		}
		return true;
				//phone.matches("(0-9){10,11}");
			
	}
	
}
