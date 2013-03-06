package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.ItemAdapter;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.ListingPresenter;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;


	

	public class LostItemTab extends ListActivity implements IItemView {
		private ListingPresenter my_presenter;
		private Item [] i;
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.display_lost_items);
	        my_presenter = new ListingPresenter(new DB(this), this);
	        ItemAdapter adapter = new ItemAdapter(this, i);
	        setListAdapter(adapter);
	        Log.d("View", "Set adapter");
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
		public void notify_of_error(String error_message, String title) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void confirm(String string, String string2) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void setItem(Item[] i) {
			// TODO Auto-generated method stub
			this.i = i;
		}
	}
