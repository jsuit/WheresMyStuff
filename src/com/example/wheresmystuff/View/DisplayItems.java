package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.ItemAdapter;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.ListingPresenter;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class DisplayItems extends TabActivity implements IItemView {
	private Item[] items;
	private ListingPresenter myPresenter;
	final private static String LOST = "Lost";
	final private static String FOUND = "Found";
	final private static String DONATIONS = "Donations";
	
	public void onCreate(Bundle savedInstanceState) {
		
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.displayitems);
	 
	        TabHost tabHost = getTabHost();
	 
	        // Inbox Tab
	        TabSpec inboxSpec = tabHost.newTabSpec(LOST);
	        // Tab Icon
	        inboxSpec.setIndicator(LOST, getResources().getDrawable(R.drawable.crosshairs));
	        Intent lostItem = new Intent(this, LostItemTab.class);
	        // Tab Content
	        inboxSpec.setContent(lostItem);
	        
	        // Outbox Tab
	        TabSpec outboxSpec = tabHost.newTabSpec(FOUND);
	        outboxSpec.setIndicator(FOUND, getResources().getDrawable(R.drawable.crosshairs));
	        Intent outboxIntent = new Intent(this, FoundItemsTab.class);
	        outboxSpec.setContent(outboxIntent);
	 
	        // Profile Tab
	        TabSpec profileSpec = tabHost.newTabSpec(DONATIONS);
	        profileSpec.setIndicator(DONATIONS, getResources().getDrawable(R.drawable.crosshairs));
	        Intent profileIntent = new Intent(this, Donations.class);
	        profileSpec.setContent(profileIntent);
	 
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(inboxSpec); // Adding Inbox tab
	        tabHost.addTab(outboxSpec); // Adding Outbox tab
	        tabHost.addTab(profileSpec); // Adding Profile tab
	
	
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
