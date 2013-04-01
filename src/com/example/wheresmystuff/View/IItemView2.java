package com.example.wheresmystuff.View;

import java.util.Calendar;

public interface IItemView2 extends IItemView {

	public void makeSpinnerVisible();
	public void makeInvisibleSpinner();
	public void makeDatePickerInvisible();
	public void makeDatePickerVisible();
	public void makeRadioInvisible();
	public void makeRadioVisible();
	public Long getDate();
	public void setAdapter();
}
