package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.ValidatePassword;
import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.Model.User;
import com.example.wheresmystuff.View.ILoginView;
import com.example.wheresmystuff.View.mainUserScreen;

public class Login_Presenter {

	
	private final IModel myModel;
	private final ILoginView myView;
	
	public Login_Presenter(ILoginView v, IModel m){
		myModel = m;
		myView = v;
	}
	
	
	public void validate(String name, String password){
		
		//search the model. From that determine if legit or not 
		
		myModel.open();
		boolean found_user = myModel.findPerson(name, password);
		myModel.close();
		if(!found_user) myView.notify_of_error("Unknow user and/or invalid password");
		else{
			myView.call_intent(mainUserScreen.class);
		}
		
	}
}
