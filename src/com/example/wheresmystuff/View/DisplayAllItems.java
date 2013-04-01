package com.example.wheresmystuff.View;

import java.util.List;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.ItemAdapter;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.advancedSearchPresenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.view.ViewGroup;

public class DisplayAllItems extends Activity implements OnItemSelectedListener,
		IItemView2 {
	private String search_criteria;
	private String search_criteria_radio;
	private String topButtonString;
	private Spinner spinner;
	private Spinner spinner2;
	private advancedSearchPresenter presenter;
	private ListView list_of_items;
	private Item [] items;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displayallitems);
		spinner = (Spinner) findViewById(R.id.search_by);
		spinner2 = (Spinner) findViewById(R.id.search_category);

		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, getResources()
						.getStringArray(R.array.SearchByList));
		spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(spinnerAdapter);

		ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, getResources()
						.getStringArray(R.array.RefineSearch));
		spinner.setAdapter(spinnerAdapter);
		spinner2.setAdapter(spinnerAdapter2);
		presenter = new advancedSearchPresenter(new DB(this), this);
		list_of_items = (ListView) findViewById(R.id.list_of_many_items);
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) 
            {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                search_criteria_radio = checkedRadioButton.getText().toString();
  
            }
        });
	}
	
	protected void onResume(){
		super.onResume();
		//spinner2.setVisibility(View.GONE);
	}

	


	
	public void makeInvisibleSpinner(){
		spinner2.setVisibility(View.GONE);

	}

	public void setAdapter(){
		list_of_items.setAdapter(new ItemAdapter(this, items));
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
		items = i;
	}

	@Override
	public void setItem(List<String> accounts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSpinnerVisible() {
		// TODO Auto-generated method stub
		spinner2.setVisibility(View.VISIBLE);
	}

	@Override
	//presenter gets the criteria. Either it does a search or displays more buttons
	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long arg3) {
		String category;
		
		
		if(parent.getId() == R.id.search_by){
			search_criteria = parent.getItemAtPosition(pos).toString();
			presenter.getCriteria(search_criteria);
			//either does a search or displays another spinner
			presenter.displayCategory();
		}
		else if(parent.getId() == R.id.search_category){
			 category = parent.getItemAtPosition(pos).toString();
			 presenter.refineSearch(category);	 
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void search_btn(View v){
		
		
	}
	
	

}
