package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.ItemAdapter;

import android.app.ListActivity;
import android.os.Bundle;
 
public class FoundItemsTab extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_found_items);
        
    }
}
