package com.example.wheresmystuff.Model;
<<<<<<< HEAD
=======

>>>>>>> New Everything
/**
 * Just like a reg. user except he/she can remove users, lock/unlock accounts.
 * 
 * 
 */

public class Admin extends RegularUser {

<<<<<<< HEAD
	
	 /**
     * Constructor that takes in all the information to make a User.
     * 
     * @param Strings: email, name, password, phoneNum, zip, street; int: login_attempts
     */
=======
	/**
	 * Constructor that takes in all the information to make a User.
	 * 
	 * @param Strings
	 *            : email, name, password, phoneNum, zip, street; int:
	 *            login_attempts
	 */
>>>>>>> New Everything
	public Admin(String email, String name, String password, String phoneNum,
			String zip, String street, int login_attempt) {
		super(email, name, password, phoneNum, zip, street, login_attempt);
		// TODO Auto-generated constructor stub
<<<<<<< HEAD
	
	}
	
	public String getName(){
		return super.getName();
	}

	public boolean isAdmin(){
		return true;
		
=======

	}

	/**
	 * returns the name of Admin
	 * 
	 * @param void
	 */
	public String getName() {
		return super.getName();
	}

	/**
	 * returns that the admin is an admin
	 * 
	 * @param void
	 */
	public boolean isAdmin() {
		return true;

>>>>>>> New Everything
	}
}
