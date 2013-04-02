package com.example.wheresmystuff.View;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.ItemAdapter;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.advancedSearchPresenter;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.provider.CalendarContract.Calendars;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayAllItems extends Activity implements
		OnItemSelectedListener, IItemView2 {
	private String search_criteria;
	private String search_criteria_radio;

	private Spinner spinner;
	private Spinner spinner2;
	private advancedSearchPresenter presenter;
	private ListView list_of_items;
	private Item[] items;
	private Button dp;
	private RadioGroup status_radio;
	private int year;
	private int month;
	private int day;
	private String refined_search;
	private boolean date = true;
	private boolean category = false;
	private boolean status = false;
	private ListView l_view;
	ItemAdapter adapter;
	TextView status_text;
	private OnDateSetListener date_listener;
	public void onCreate(Bundle savedInstanceState) {
		search_criteria_radio = "Lost";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displayallitems);
		
		status_text = (TextView) findViewById(R.id.OpenClosed);
		spinner = (Spinner) findViewById(R.id.search_by);
		spinner2 = (Spinner) findViewById(R.id.search_category);

		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, getResources()
						.getStringArray(R.array.SearchByList));
		spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, getResources()
						.getStringArray(R.array.RefineSearch));
		spinner.setAdapter(spinnerAdapter);
		spinner2.setAdapter(spinnerAdapter2);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.Category, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		;
		dp = (Button) findViewById(R.id.date_btn);
		setUPPickers();
		setUpRadios();

		
		date_listener = new OnDateSetListener() {

			

			@Override
			public void onDateSet(DatePicker view, int myear, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				year = myear;
				month = monthOfYear;
				day = dayOfMonth;
				date = true;
				category = false;
				status = false;
				refined_search = getDate().toString();
				
			}

		};
		
		presenter = new advancedSearchPresenter(new DB(this), this);

		l_view = (ListView) findViewById(R.id.list_of_many_items);
	
	}
	private void setUPPickers() {
		// TODO Auto-generated method stub
		Calendar c = new GregorianCalendar();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
		
		// DatePickerDialog.OnDateSetListener

		refined_search = getDate().toString();
	}

	void setUpRadios() {
		// TODO Auto-generated method stub
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		radioGroup
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						l_view.setAdapter(null);
						RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
						search_criteria_radio = checkedRadioButton.getText()
								.toString();

					}
				});

		status_radio = (RadioGroup) findViewById(R.id.status_radio);
		status_radio
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						
						RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
						refined_search = checkedRadioButton.getText()
								.toString();
						date = false;
						category = false;
						status = true;
						

					}
				});

	}

	public void onRadioButtonStatusClicked(View v) {

		if (((RadioButton) v).isChecked()) {
			refined_search = ((RadioButton) v).getText().toString();
			
		}

	}

	protected void onResume() {
		super.onResume();
		spinner.setOnItemSelectedListener(this);
		spinner2.setOnItemSelectedListener(this);

	}

	public void makeInvisibleSpinner() {
		spinner2.setVisibility(View.GONE);

	}

	public void setAdapter() {
		adapter = new ItemAdapter(this, items);
		l_view.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		// l_view.setAdapter(adapter);

	}

	/*
	 * Button handler for date picker
	 */
	public void datePicker(View v) {
		DatePickerDialog date_picker = new DatePickerDialog(this, date_listener, year, month, day);
		date_picker.show();
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
	// presenter gets the criteria. Either it does a search or displays more
	// buttons
	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long arg3) {

		if (parent.getId() == R.id.search_by) {
			l_view.setAdapter(null);
			search_criteria = parent.getItemAtPosition(pos).toString();
			presenter.getCriteria(search_criteria);
			// display next spinner if needed
			presenter.displayCategory();
			

		}

		else if (parent.getId() == R.id.search_category) {
			l_view.setAdapter(null);
			date = false;
			category = true;
			status = false;
			refined_search = parent.getItemAtPosition(pos).toString();
			
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	public void search_btn(View v) {
		l_view.setAdapter(null);
		if(refined_search.compareTo("Open") == 0 || "Closed".compareTo(refined_search)==0)
			status_text.setText(refined_search);
		presenter.search(presenter.check(search_criteria_radio,
				search_criteria, refined_search), date, category, status);
		
		// startActivity(i);
		RadioButton rb = (RadioButton) findViewById(R.id.off_radio);
		RadioButton rb2 = (RadioButton) findViewById(R.id.on_radio);
		rb.setChecked(false);
		rb2.setChecked(false);

	}

	@Override
	public void makeDatePickerInvisible() {
		// TODO Auto-generated method stub
		dp.setVisibility(View.GONE);

	}

	@Override
	public void makeDatePickerVisible() {
		// TODO Auto-generated method stub
		dp.setVisibility(View.VISIBLE);
	}

	@Override
	public void makeRadioInvisible() {
		// TODO Auto-generated method stub
		
		status_radio.setVisibility(View.GONE);
		status_text.setVisibility(View.GONE);

	}

	@Override
	public void makeRadioVisible() {
		// TODO Auto-generated method stub
		
		status_radio.setVisibility(View.VISIBLE);
		status_text.setVisibility(View.VISIBLE);
	}

	@Override
	public Long getDate() {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month, day);
		return cal.getTimeInMillis();

	}

	

}