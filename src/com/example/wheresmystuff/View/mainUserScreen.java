package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Presenter.Register_Presenter;
import com.example.wheresmystuff.Presenter.User_Screen_Presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class mainUserScreen extends Activity implements IMyProfilePage{

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_user_screen);	
		User_Screen_Presenter presenter = new User_Screen_Presenter(this, new DB(this));
		
		
		
	}
	
	public void postItem(View post_button){
		Intent i = new Intent(this, Register_Item.class);
		startActivity(i);
		Log.d("mainUserScreen", "Post Item clicked. starting display lost items class");
	}
	
	
	public void yourListings(View your_listings){
	Intent i = new Intent(this, DisplayItems.class);
	startActivity(i);
	Log.d("mainUserScreen", "Your Listings clicked. starting display lost items class");
	}
}
