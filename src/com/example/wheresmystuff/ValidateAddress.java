package com.example.wheresmystuff;

import android.location.Geocoder;

public class ValidateAddress {

	
	
	protected static boolean validate(String addr){
		
		if(addr == null) return false;
		else{
			String[] zip_street = addr.split("\\s+");
			String zip = zip_street[0];
			String street = zip_street[1];
			//do stuff to validate
			
			
			
		}
		return false;
	}
}
