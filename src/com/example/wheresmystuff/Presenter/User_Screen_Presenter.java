package com.example.wheresmystuff.Presenter;

import java.util.ArrayList;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.ILoginView;
import com.example.wheresmystuff.View.IMyProfilePage;


public class User_Screen_Presenter {

	private IModel myModel;
	private IMyProfilePage myView;
	
	public User_Screen_Presenter(IMyProfilePage v, IModel m){
		myModel = m;
		myView = v;
	}
	
	
}
