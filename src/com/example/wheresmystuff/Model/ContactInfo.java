package com.example.wheresmystuff.Model;

public class ContactInfo {

	private String email, name, zip, street, phoneNum;
	
	public ContactInfo(String email, String name, String phoneNum, String zip, String street) {
		
		this.email = email;
		this.name = name;
		this.phoneNum = phoneNum;
		this.zip = zip;
		this.street = street;
		
	}
	
	public String getEmail() {
		
		return email;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getPhoneNum() {
		
		return phoneNum;
		
	}
	
	public String getZip() {
		
		return zip;
		
	}
	
	public String getStreet() {
		
		return street;
		
	}
	
	public void setEmail(String newEmail) {
		
		email = newEmail;
		
	}
	
	public void setPhoneNum(String newPhoneNum) {
		
		phoneNum = newPhoneNum;
		
	}
	
	public void setZip(String newZip) {
		
		zip = newZip;
		
	}
	
	public void setStreet(String newStreet) {
		
		street = newStreet;
		
	}
	
	public void setName(String newName) {
		
		name = newName;
		
	}
	
}
