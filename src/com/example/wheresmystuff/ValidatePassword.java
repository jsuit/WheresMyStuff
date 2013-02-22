package com.example.wheresmystuff;

public class ValidatePassword {

	protected static String validate(String password, String check_password){
		
		if (password == null || !password.matches("[((0-9)|(a-z)|(A-Z)){6,12}]")) {
			return "Invalid Password \n";
		}
		return null;
		
	}
}
