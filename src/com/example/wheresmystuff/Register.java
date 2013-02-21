package com.example.wheresmystuff;

import android.app.Activity;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity implements OnClickListener{
	
	private String name = null;
	private String email = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
	
		
		
		
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.Save){
			String name = ((EditText) findViewById(R.id.Name)).getText().toString();
			String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
			String password = ((EditText) findViewById(R.id.password)).getText().toString();
			String check_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
			String zip = ((EditText) findViewById(R.id.zip_code)).getText().toString();
			String street = ((EditText) findViewById(R.id.Street)).getText().toString(); 
			boolean correct_info = Validation.validate(name, phone, zip + " " + street ,email, password, check_password);		
		}
		
		
	}

	

}
