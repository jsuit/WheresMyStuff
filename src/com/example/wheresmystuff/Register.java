package com.example.wheresmystuff;

import android.app.Activity;
<<<<<<< HEAD
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
=======
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
>>>>>>> master
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
=======
import android.widget.TextView;
>>>>>>> master
import android.widget.Toast;

public class Register extends Activity implements OnClickListener{
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
<<<<<<< HEAD
=======
	
>>>>>>> master
		View save = findViewById(R.id.Save);
		save.setOnClickListener(this);
		
		
	}

	

	@Override
	public void onClick(View v) {
	
		
		
		
		// TODO Auto-generated method stub
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
		if(v.getId() == R.id.Save){
			Log.d("button", "msg");
			String name = ((EditText) findViewById(R.id.Name)).getText().toString();
			String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
			String password = ((EditText) findViewById(R.id.password)).getText().toString();
			String check_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
			String zip = ((EditText) findViewById(R.id.zip_code)).getText().toString();
			String check_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
			String street = ((EditText) findViewById(R.id.Street)).getText().toString(); 
<<<<<<< HEAD
			boolean correct_info = false;//Validation.validate(name, phone, zip + " " + street ,email, password, check_password);	
=======
			String email = ((EditText) findViewById(R.id.email)).getText().toString(); 
			String [] check = Validation.validate(name, phone, zip + " " + street ,email, password, check_password);
			 StringBuffer errorMessage = new StringBuffer();
			//change 5 to some variable
			for(int i=0; i<5; i++) {
				if(check[i] != null) errorMessage.append(check[i]);
			}
>>>>>>> master
			
			if(errorMessage.length() != 0){
				TextView textView = new TextView(this);
		        textView.setBackgroundColor(Color.DKGRAY);
		        textView.setTextColor(Color.WHITE);
		        textView.setTextSize(30);
				Typeface typeface = Typeface.create("serif", Typeface.BOLD);
		        textView.setTypeface(typeface);
		        textView.setGravity(Gravity.CENTER);
		        textView.setText(errorMessage.toString());
		        Toast t = Toast.makeText(this,null, Toast.LENGTH_LONG);
				 t.setGravity(Gravity.RELATIVE_LAYOUT_DIRECTION|Gravity.CENTER_HORIZONTAL, 0, 0);
				 t.setView(textView);
				 t.show();
			}
				 
				
				
			
			if(true){
				
				Toast.makeText(this, "Error in Input", Toast.LENGTH_LONG).show();
				
				
			}
		}
		
		
	}
	}

	
