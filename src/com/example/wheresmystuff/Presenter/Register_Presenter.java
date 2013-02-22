package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Validation;
import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.ILoginView;

public class Register_Presenter {

	private final IModel myModel;
	private final ILoginView myView;
	
	
	public Register_Presenter(ILoginView v, IModel m){
		myModel = m;
		myView = v;
	}
	
	public  boolean validate(String name, String phone_num, String  address, String email, String password, String check_password){
		
			String [] error_messages = Validation.validate(name, phone_num, address, email, password, check_password);
			StringBuffer error_text = new StringBuffer();
			for(int i=0; i< error_messages.length; i++) {
					if(error_messages[i] != null) error_text.append(error_messages[i]);
				}
		
			if(error_text.length() != 0){
				myView.notify_of_error(error_text.toString());
				return false;
			}
			return true;
	}
}
