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
	public ListingPresenter(IModel m, IItemView view) {
		myModel = m;
		myView = view;
		list();
	
	}
	
	public void list(){
		myModel.open();
		current_user = myModel.getCurUser();
		Item [] items = (myModel.getLostItems(current_user));
		if(items != null){
			//myView.setItem(items);
		}
		
		
		myModel.close();
	}
	
	
}
