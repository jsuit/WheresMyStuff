package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.IItemView;
import com.example.wheresmystuff.View.IItemView2;

public class advancedSearchPresenter {

	private String criteria;
	private final  IModel myModel;
	/** the view to display to */
	private final IItemView2 myView;
	private String current_user;
	private String refined_search;
	public advancedSearchPresenter(IModel myModel, IItemView2 view) {
		myView = view;
		this.myModel = myModel;
	}
	
	
	public void getCriteria(String criteria){
		this.criteria = criteria;
		this.criteria = this.criteria.toLowerCase();
		
	}
	
	public void searchOrGetMoreInfo(){
		if("category".compareTo(criteria)==0){
			myView.makeSpinnerVisible();
		}else if("date".compareTo(criteria) == 0){
			
		}else{
			//status
		}
	}


	public void displayIfPossible() {
		// TODO Auto-generated method stub
		
	}


	public void refineSearch(String category) {
		// TODO Auto-generated method stub
		//search for a specific category
		refined_search = category;
		//setListAdapter if search returns something
	}


	public void displayCategory() {
		// TODO Auto-generated method stub
		
		
	}


	
	

}
