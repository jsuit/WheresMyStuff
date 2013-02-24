package com.example.wheresmystuff;

public class ValidatePassword {

static String validate(String password, String check_password){

		if (password == null || check_password == null || "".compareTo(password) == 0) {
			return "Invalid Password\n";
		}
		if(password.compareTo(check_password) != 0){
			return "Invalid Password\n";
		}
		if(password.length() < 6 || password.length() > 100){
			return "Invalid Password\n";
		}
		int numbers = 0;
		for (int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))){
				numbers++;
			}
		}

		if(numbers < password.length() && numbers >= 1){
			return null;

		}else return "Invalid Password\n";

		//boolean value = password.matches("[((0-9)|(a-z)|(A-Z)){6,12}]");
		//return true;
	}
}