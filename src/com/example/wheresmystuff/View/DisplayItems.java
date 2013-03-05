package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.ItemAdapter;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.ListingPresenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class DisplayItems extends Activity implements IItemView {
	private Item[] items;
	private ListingPresenter myPresenter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myPresenter = new ListingPresenter(new DB(this), this);		
		setContentView(R.layout.displayitems);
		TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
		tabHost.setup();

		TabSpec spec1=tabHost.newTabSpec("Tab 1");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("Lost Items");
		tabHost.addTab(spec1);
		
		TabSpec spec2=tabHost.newTabSpec("Tab 2");
		spec2.setIndicator("Found Items");
		spec2.setContent(R.id.tab2);
		tabHost.addTab(spec2);
		TabSpec spec3=tabHost.newTabSpec("Tab 3");
		spec3.setIndicator("Donations");
		spec3.setContent(R.id.tab3);
		tabHost.addTab(spec3);
		
		final ListView one=(ListView)findViewById(R.id.lost_list_view);
		if(items!=null){
			ItemAdapter my_adapter = new ItemAdapter(this, items);
			one.setAdapter(my_adapter);
		}
		
/*
		TabSpec spec4 = tabHost.newTabSpec("Tab 4");
		spec4.setIndicator("Something Else");
		spec4.setContent(R.id.tab4);
		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		tabHost.addTab(spec4);
*/		
		Log.d("Model", "Set adapter");
		}
	
	
	public void setItem(Item[] i) {
		// TODO Auto-generated method stub
		
		items = i;
		
	}

	@Override
	public void notify_of_error(String error_message, String title) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(error_message);
		builder.setTitle(title);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			      public void onClick(DialogInterface dialog, int id) {
			    	  return;

			         }

			     });
		
		builder.create().show();
	}
	

	@Override
	public <T> void call_intent(Class<T> c) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void makeToast(String string) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void confirm(String string, String string2) {

		// TODO Auto-generated method stub
		
	}
}
