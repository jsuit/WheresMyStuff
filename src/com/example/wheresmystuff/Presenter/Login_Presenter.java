package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.ILoginView;

public class Login_Presenter {

	
	private final IModel myModel;
	private final ILoginView myView;
	
	public Login_Presenter(ILoginView v, IModel m){
		myModel = m;
		myView = v;
	}
	
	
	public boolean validate(String name, String password){
		
		//search the model. From that determine if legit or not
		//if can't, then call: 
		myView.notify_of_error("Unknow user and/or invalid password");
		return false;
	}
}
