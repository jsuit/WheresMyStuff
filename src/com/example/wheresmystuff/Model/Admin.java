package com.example.wheresmystuff.Model;

public class Admin extends RegularUser {

	public Admin(String email, String name, String password, String phoneNum,
			String zip, String street, int login_attempt) {
		super(email, name, password, phoneNum, zip, street, login_attempt);
		// TODO Auto-generated constructor stub
	
	}
	
	public String getName(){
		return super.getName();
	}

}
