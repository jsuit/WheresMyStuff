package com.example.wheresmystuff.validation;

public class CheckNameLocation extends CheckDisplayAll {

	private String[] array;

	public CheckNameLocation() {
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
=======
	/**
	 * Constructor. Sets the Name or Location array to argument.
	 * 
	 * @param String [] array
	 */
>>>>>>> New Everything
	public CheckNameLocation(String[] array) {
		this.array = array;
	}

	@Override
<<<<<<< HEAD
=======
	/**
	 * Sees if there are two non-empty strings in the array
	 * Returns true if there is. False otherwise
	 * @return boolean
	 */
>>>>>>> New Everything
	public boolean check() {
		for (String a : array) {
			if ("".compareTo(a) == 0)
				return false;
		}
		return true;
	}

	@Override
<<<<<<< HEAD
	public String name_location() {
=======
	/**
	 * Gets either name or location. This method assumes that there is only one non-empty
	 * string in array.
	 * 
	 * @param String 
	 */
	public String getNameOrlocation() {
>>>>>>> New Everything
		String str = null;
		for (String a : array) {
			if ("".compareTo(a) == 0)
				continue;
<<<<<<< HEAD
			else str = a;
=======
			else
				str = a;
>>>>>>> New Everything
		}
		return str;
	}

}
