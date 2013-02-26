package com.example.wheresmystuff.Model;

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
	  
	 void close();
	 
	 

	
}
