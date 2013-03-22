package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Presenter.Register_Presenter;
import com.example.wheresmystuff.Presenter.User_Screen_Presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class mainUserScreen extends Activity implements IMyProfilePage{

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	
	
	}
	
	protected void onResume(){
		super.onResume();
		setContentView(R.layout.activity_main_user_screen);	
		User_Screen_Presenter presenter = new User_Screen_Presenter(this, new DB(this));
		presenter.checkAdmin();
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
	
	public void makeAdminButtonsVisisble(){
		
		Button add_remove = (Button) findViewById(R.id.addRemove);
		Button lock_unlock = (Button) findViewById(R.id.lock_unlock);
		Button remove_user = (Button) findViewById(R.id.remove_user_button);
		remove_user.setVisibility(View.VISIBLE);
		add_remove.setVisibility(View.VISIBLE);
		lock_unlock.setVisibility(View.VISIBLE);	
		
		ImageView view = (ImageView) findViewById(R.id.wheresmystuffimage);
		view.setVisibility(View.GONE);
		
	}
	
	public void addOrRemoveAdmin(View v){
		Intent i = new Intent(this, AddRemoveAdmin.class);
		startActivity(i);
	}
	public void makeAdminButtonsInvisisble(){
		Button remove_user = (Button) findViewById(R.id.remove_user_button);
		remove_user.setVisibility(View.GONE);
		Button add_remove = (Button) findViewById(R.id.addRemove);
		Button lock_unlock = (Button) findViewById(R.id.lock_unlock);
		add_remove.setVisibility(View.GONE);
	//	ImageView view = (ImageView) findViewById(R.drawable.wheresmystuffimage);
	//	view.setVisibility(View.VISIBLE);
		lock_unlock.setVisibility(View.GONE);
		
		
	}
	//button handler
	public void lockOrUnlock(View v) {

		Intent i = new Intent(this, LockOrUnlock.class);
		startActivity(i);
		Log.d("Lock/Unlock screen", "Lock/Unlock button clicked directing to activity");
	}
	
	public void removeUser(View v){
		Intent i = new Intent(this, LockOrUnlock.class);
	}
}
