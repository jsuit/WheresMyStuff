package com.example.wheresmystuff;

public class ValidatePassword {

	protected static boolean validate(String password, String check_password){
		
		if (password == null) {
			return false;
		}
		return password.matches("[((0-9)|(a-z)|(A-Z)){6,12}]");
		
	}
}
