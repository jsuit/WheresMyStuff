package com.example.wheresmystuff;

import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Presenter.AddAdminPresenter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class AddRemoveAdmin extends Activity {

	private AddAdminPresenter my_presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_remove_admin);
		my_presenter = new AddAdminPresenter(this, new DB(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_remove_admin, menu);
		return true;
	}
	
	public void AddAdmin(View createAdminButton) {
		
		String user_name = ((EditText) findViewById(R.id.adminID)).getText().toString();
		String email_add = ((EditText) findViewById(R.id.email_address)).getText().toString();
		String password = ((EditText) findViewById(R.id.password)).getText().toString();
		String retype_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
		Log.d("AddRemoveAdmin", "Create admin button clicked");
		
	}

}
