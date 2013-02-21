package com.example.wheresmystuff;

 public class Validation {

	
	
	public static boolean validate(String name, String phone_num, String  address, String email, String password, String check_password){
		
		 return ValidateAddress.validate(address) && ValidatePhone.validate(phone_num) && ValidateEmail.validate(email) && ValidatePassword.validate(password, check_password); 
	}

	
	
	
	
	
	
	
}
