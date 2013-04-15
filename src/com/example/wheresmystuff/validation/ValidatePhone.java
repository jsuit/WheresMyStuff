package com.example.wheresmystuff.validation;

public class ValidatePhone {



	protected static String validate(String phone){


<<<<<<< HEAD
		if (phone == null || "".compareTo(phone) == 0 || !phone.matches("(0-9){10,11}")) {
=======
		if (phone == null || "".compareTo(phone) == 0 || phone.matches("\\d{10}|\\d{11}")) {
>>>>>>> New Everything
			return null;
		}
		return "Invalid Phone Number\n";

	}



}