package com.example.wheresmystuff;

public class ValidatePhone {

	
<<<<<<< HEAD
	protected static String validate(String phone){
=======
	protected static boolean validate(String phone){
		int length = phone.length();
		if(length >= 15) return false;
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < length; i++){
			if(Character.isDigit(phone.charAt(i))){
				buffer.append(phone.charAt(i));
			}
			
		}
		if(buffer.toString().length() == 10) return true;
		return false;
		
>>>>>>> bug fix
		
		if (phone == null || "".compareTo(phone) == 0 || !phone.matches("(0-9){10,11}")) {
			return null;
		}
		return "Invalid Phone Number\n";
			
	}

	
	
}
