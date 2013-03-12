package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.AddRemoveAdmin;

public class AddAdminPresenter {

	private final IModel myModel;
	private final AddRemoveAdmin myView;
	
	public AddAdminPresenter(AddRemoveAdmin v, IModel m) {
		
		myModel = m;
		myView = v;
		
	}
	
	
	
}
