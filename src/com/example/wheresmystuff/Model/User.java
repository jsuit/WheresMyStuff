package com.example.wheresmystuff.Model;


/**
* User Inteface. All the kind of users will extend this interface 
* 
*
*/


public interface User {

	public String getPassword();
	
	public int getLoginAttempts();

	public ContactInfo getContactInfo();

	public String[] getContactInfoAsArray();
	
	public void increaseLoginAttempts();

	public String  getName();
	
	public boolean isAdmin();
	
}
