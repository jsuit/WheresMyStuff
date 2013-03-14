package com.example.wheresmystuff.Model;


public class RegularUser implements User {

	private String email, password, zip, street, phoneNum;
	private boolean acc_status, admin_status;
	private ContactInfo contact_info;
	private int login = 0;
	
	public RegularUser(String email, String name, String password, String phoneNum, String zip, String street, int login_attempt) {
		
		this.password = password;
		contact_info = new ContactInfo(email, name, phoneNum, zip, street);
		login = login_attempt;
	}
	
	public boolean getAdminStatus() {
		
		return admin_status;
		
	}
	
	public boolean getAccStatus() {
		
		return acc_status;
		
	}
	
	public String getEmail() {
		
		return contact_info.getEmail();
		
	}
	
	public String getName() {
		
		return contact_info.getName();
	}
	
	public String getPhoneNum() {
		
		return contact_info.getPhoneNum();
		
	}
	
	public String getZip() {
		
		return contact_info.getZip();
		
	}
	
	public String getStreet() {
		
		return contact_info.getStreet();
		
	}
	
	public void setAdminStatus(boolean bool) {
		
		admin_status = bool;
		
	}
	
	public void setAccStatus(boolean bool) {
		//if true,then unlocked
		acc_status = bool;
		if(bool) this.login = 0;
		
	}
	
	public void setEmail(String newEmail) {
		
		contact_info.setEmail(newEmail);
		
	}
	
	public void setName(String newName) {
		
		contact_info.setName(newName);
		
	}
	
	public void setPhoneNum(String newPhoneNum) {
		
		contact_info.setPhoneNum(newPhoneNum);
		
	}
	
	public void setZip(String newZip) {
		
		contact_info.setZip(newZip);
		
	}
	
	public void setStreet(String newStreet) {
		
		contact_info.setStreet(newStreet);
	}
	
	

	@Override
	public ContactInfo getContactInfo() {
		// TODO Auto-generated method stub
		return contact_info;
	}

	@Override
	public String[] getContactInfoAsArray() {
		// TODO Auto-generated method stub
		return this.contact_info.getContactInfoAsArray();
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public int getLoginAttempts() {
		return this.login;
		
	}
	@Override
	public void increaseLoginAttempts(){
		
		if(login < 3) setLoginAttempts(login++);
		else setLoginAttempts(3);
	}
	
	private void setLoginAttempts(int i){
		this.login = i;
	}

	public boolean isAdmin(){
		return false;
	}
	
}
