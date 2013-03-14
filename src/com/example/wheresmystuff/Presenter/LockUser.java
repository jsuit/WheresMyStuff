package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.LockOrUnlock;

public class LockUser {

	private final IModel myModel;
	private final LockOrUnlock myView;
	
	public LockUser(LockOrUnlock v, IModel m) {
		
		myModel = m;
		myView = v;
		
	}
	
	public void lockUser(String username) {
		
		myModel.open();
		if (myModel.find_uid(username)) {
			
			myModel.setLocked(username);
			
		}
		myModel.close();
		
	}
	
}
