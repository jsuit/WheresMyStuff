package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.View.DisplayItems;
import com.example.wheresmystuff.View.IItemView;
import com.example.wheresmystuff.View.ILoginView;


public class ListingPresenter {
	private final  IModel myModel;
	/** the view to display to */
	private final IItemView myView;
	private String current_user;
	

	/**
	 * Make a new presenter
	 * @param m the model
	 * @param view the view
	 */
	public ListingPresenter(IModel m, IItemView view, String key) {
		myModel = m;
		myView = view;
		myModel.open();
		current_user = myModel.getCurUser();
		myView.setItem(myModel.getItems(myModel.getCurUser(), key));
		myModel.close();
	
	}
	
	
	
	
}
