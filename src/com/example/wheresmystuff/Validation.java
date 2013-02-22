package com.example.wheresmystuff;

 public class Validation {

	
	
	public static boolean validate(String name, String phone_num, String  address, String email, String password, String check_password){
		
		 return ValidateName.validate(name) && ValidatePassword.validate(password, check_password) && ValidateAddress.validate(address) && ValidatePhone.validate(phone_num); 
		 
		 
	}

	
	
	
	
	
	
	
}
