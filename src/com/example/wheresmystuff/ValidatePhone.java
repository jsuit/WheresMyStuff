package com.example.wheresmystuff;

public class ValidatePhone {

	
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
		
		
	}

	
	
}
