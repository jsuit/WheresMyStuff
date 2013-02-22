package com.example.wheresmystuff;

public class ValidatePassword {

	protected static boolean validate(String password, String check_password){
		
		if (password == null || check_password == null || "".compareTo(password) == 0) {
			return false;
		}
		if(password.compareTo(check_password) != 0){
			return false;
		}
		if(password.length() < 6 || password.length() > 100){
			return false;
		}
		int numbers = 0;
		for (int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))){
				numbers++;
			}
		}
	
		if(numbers < password.length() && numbers >= 1){
			return true;
			
		}else return false;
		
		//boolean value = password.matches("[((0-9)|(a-z)|(A-Z)){6,12}]");
		//return true;
	}
}
