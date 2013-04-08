package com.example.wheresmystuff.validation;

public class ValidatePassword {

public static String validate(String password, String check_password){

		if (password == null || check_password == null || "".compareTo(password) == 0) {
			return "Invalid Password. Need a Password\n";
		}
		if(password.compareTo(check_password) != 0){
			return "Invalid Password. Passwords don't match.\n";
		}
		if(password.length() < 6){
			return "Invalid Password. Need 7 characters with at least one number\n";
		}
		if(password.length()>99){
			return "Invalid Password. Too Long.\n";
		}
		int numbers = 0;
		for (int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))){
				numbers++;
			}
		}

		if(numbers < password.length() && numbers >= 1){
			return null;

		}
		if(numbers == password.length()){
			return "Invalid Password. Can't be all numbers.\n";
		}
		if(numbers == 0 ){
			return "Invalid Password. No Numbers.";
		}
		else return "Invalid Password.\n";

		//boolean value = password.matches("[((0-9)|(a-z)|(A-Z)){6,12}]");
		//return true;
	}
}