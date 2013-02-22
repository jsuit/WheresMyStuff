package com.example.wheresmystuff;

 public class Validation {

	
<<<<<<< HEAD
	
<<<<<<< HEAD
=======

>>>>>>> fix weird things
		public static String[] validate(String name, String phone_num, String  address, String email, String password, String check_password){
			String[] validate = {ValidateName.validate(name), ValidateAddress.validate(address), ValidatePhone.validate(phone_num), ValidateEmail.validate(email), ValidatePassword.validate(password, check_password)};
			return validate; 
			//ValidateAddress.validate(address) && ValidatePhone.validate(phone_num) && ValidateEmail.validate(email) && ValidatePassword.validate(password, check_password); 
		}

<<<<<<< HEAD
=======
	public static boolean validate(String name, String phone_num, String  address, String email, String password, String check_password){
		
		 return ValidateAddress.validate(address) && ValidatePhone.validate(phone_num) && ValidateEmail.validate(email) && ValidatePassword.validate(password, check_password); 
	}
>>>>>>> bug fix
=======
 }
>>>>>>> fix weird things

	
	
	
	
	
	
	

