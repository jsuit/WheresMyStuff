package com.example.wheresmystuff.Adapter;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.Item.Item;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
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
	    TextView textView = (TextView) rowView.findViewById(R.id.item_name_row);
	    TextView item_desrc = (TextView) rowView.findViewById(R.id.item_description_row);
	    TextView item_date = (TextView) rowView.findViewById(R.id.item_date_row);
	    TextView item_status = (TextView) rowView.findViewById(R.id.item_status_row);
	    //set the widget values
	    String label1, label2, label3, label4;
	    label1 = "ITEM";
	    label2 = "DESCRIPTION";
	    label3 = "DATE ENTERED";
	    label4 = "STATUS";
	    SpannableString content = new SpannableString("ITEM:  " +items[position].getItemName());
	    content.setSpan(new UnderlineSpan(), 0, label1.length(), 0);
	    textView.setText(content);
	    SpannableString descr = new SpannableString("DESCRIPTION:  "+items[position].getItemDescription());
	    descr.setSpan(new UnderlineSpan(), 0, label2.length(), 0);
	    item_desrc.setText(descr);
	    SpannableString date = new SpannableString("DATE ENTERED:  " +items[position].getDateAsString());
	    date.setSpan(new UnderlineSpan(), 0, label3.length(), 0);
	    item_date.setText(date);
	    SpannableString status = new SpannableString("STATUS:  " +items[position].getItemStatus());
	    status.setSpan(new UnderlineSpan(), 0, label4.length(), 0);
	    item_status.setText(status);
          Log.d("Adapter", "Set row for: " + position);
          
	    
	    Log.d("Model", "Got row " + position);
	    
      //lastly return the prepared view for the list to use
	    return rowView;
	  }
	
	public int getSize(){
		if(items!=null)
		return items.length;
		else{
			return 0;
		}
	}
		
	
}
