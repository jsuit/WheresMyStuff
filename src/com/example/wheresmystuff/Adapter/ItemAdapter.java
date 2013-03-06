package com.example.wheresmystuff.Adapter;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.Item.Item;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<Item> {
	/** The context for the adapter */
	private final Context context;
	/** the people to show in the list */
	private final Item[] items;
	
	public ItemAdapter(Context ctx, Item[] i) {
		super(ctx, R.layout.item_row, i);
		context = ctx;
		items = i;
	}
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		//Set up the view by creating the widgets out of the xml spec
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.item_row, parent, false);
	
	    //Grab the two widgets in teh view
	    TextView textView = (TextView) rowView.findViewById(R.id.label);
	    
	    
	    //set the widget values
	    textView.setText(items[position].getItemName() + " "+ items[position].getDateAsString());
          Log.d("Adapter", "Set row for: " + position);
          
	    
	    Log.d("Model", "Got row " + position);
	    
      //lastly return the prepared view for the list to use
	    return rowView;
	  }
	
}
