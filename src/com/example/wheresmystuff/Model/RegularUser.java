package com.example.wheresmystuff.Model;


public class RegularUser implements User {

	private String email, password, name, zip, street, phoneNum;
	private boolean acc_status, admin_status;
	private ContactInfo contact_info;
	
	public RegularUser(String email, String name, String password, String phoneNum, String zip, String street) {
		
		this.password = password;
		contact_info = new ContactInfo(email, name, phoneNum, zip, street);
		
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
		
		acc_status = bool;
		
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
	public void add_to_list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove_to_list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save_user(User user) {
		// TODO Auto-generated method stub

	}

}
