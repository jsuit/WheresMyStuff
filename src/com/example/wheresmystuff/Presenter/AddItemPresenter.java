package com.example.wheresmystuff.Presenter;

import java.util.Date;

import android.util.Log;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Model.Item.LostItem;
import com.example.wheresmystuff.View.IItemView;

public class AddItemPresenter {

	private final IModel myModel;
	/** the view to display to */
	private final IItemView myView;
	private Item i;

	/**
	 * Make a new presenter
	 * 
	 * @param m
	 *            the model
	 * @param view
	 *            the view
	 */
	public AddItemPresenter(IModel m, IItemView view) {
		myModel = m;
		myView = view;
		i = null;
	}

	public void makeAnItem(String name, String category, String status,
			String description, Date date, String zip, String street,
			boolean keep, boolean heir, boolean m) {
		// TODO Auto-generated method stub

		myModel.open();
		String curUser = myModel.getCurUser();
		i = new LostItem(name, category, status, description, curUser, date,
				keep, heir, m, zip, street);
		myModel.close();
		confirmTheSave(i);

	}

	public void confirmTheSave(Item i) {
		// TODO Auto-generated method stub
		myModel.open();
		String name = i.getItemName();
		String description = i.getItemDescription();
		String status = i.getItemStatus();
		boolean[] array = i.kindofItem();

		// ****Make validation classes******
		if (array[0] == array[1] && array[0] == array[2] && array[0] == false) {
			myView.notify_of_error(
					"You must choose either a Heirloom, Keepsake, or Misc",
					"Error");
		} else {
			String date = i.getDateAsString().toString();
			String category = i.getItemCategory();
			String curUser = myModel.getCurUser();
			String zip = i.getZip();
			String street = i.getStreet();
			myView.confirm("Are you sure?", "Confirm");
		}
		myModel.close();
	}

	public void save() {
		
		String name = i.getItemName();
		String description = i.getItemDescription();
		String status = i.getItemStatus();
		boolean[] array = i.kindofItem();
		String date = i.getDateAsString().toString();
		String category = i.getItemCategory();
		String curUser = myModel.getCurUser();
		String zip = i.getZip();
		String street = i.getStreet();
		myModel.open();
		long row = myModel.saveItem(name, description, status, array[0],
				array[1], array[2], date, curUser, street, zip, category);
		if (row == -1) {
			myView.notify_of_error("Could not insert into table", "Error");
		} else
			myView.makeToast("Saved your " + name);
		myModel.close();
	}
	
}
