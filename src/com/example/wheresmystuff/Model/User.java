package com.example.wheresmystuff.Model;

public interface User {

	//No item class yet.
	//public void add_n_items(Item item, int numberOfItems);
	
	//public void remove_n_items(Item item, int numberOfItems);
	
	public String getPassword();
	
	public int getLoginAttempts();

	public ContactInfo getContactInfo();

	public String[] getContactInfoAsArray();
	
	public void increaseLoginAttempts();

	public String  getName();
	
	public boolean isAdmin();
	
}
