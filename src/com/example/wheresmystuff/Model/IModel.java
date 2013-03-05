package com.example.wheresmystuff.Model;

import com.example.wheresmystuff.Model.Item.Item;

import android.database.SQLException;

public interface IModel {

	/**
	 * Add a person to the model
	 * 
	 * @param p the person to add
	 * @return 
	 */
	long addPerson(User p);
	/**
	 * Lookup a person by their id
	 * 
	 * @param uid the id to search for
	 * 
	 * @return the person with that id or null if not found
	 */
	boolean findPerson(String u_name, String password);
	/**
	 * Remove a person from the model 
	 * 
	 * @param id the id of the person to remove
	 */
	void removePerson(String id);
	/**
	 * Get all the people  in the model as an array
	 * 
	 * @return an array of all people in the model.
	 */
	 void open() throws SQLException;
	 
	 boolean find_uid(String uid);
	 
	 int getLoginAttempts(String u_name);
	  
	 void close();
	boolean find_password(String password);
	
	void increase_login_attempts(int i, String u_name);
	void setLocked(String u_name);
	Item [] getItems(String current_user);
	void setCurUser(String name);
	String getCurUser();
	Item[] getLostItems(String current_user);
	long saveItem(String name, String description, String status,
			boolean b, boolean c, boolean d, String date,
			String curUser, String street, String zip, String type);
	 
	 

	
}
