package com.example.wheresmystuff.validation;

public class CheckNameLocation extends CheckDisplayAll {

	private String[] array;

	public CheckNameLocation() {
		// TODO Auto-generated constructor stub
	}

	public CheckNameLocation(String[] array) {
		this.array = array;
	}

	@Override
	public boolean check() {
		for (String a : array) {
			if ("".compareTo(a) == 0)
				return false;
		}
		return true;
	}

	@Override
	public String name_location() {
		String str = null;
		for (String a : array) {
			if ("".compareTo(a) == 0)
				continue;
			else str = a;
		}
		return str;
	}

}
