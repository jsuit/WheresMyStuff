package com.example.wheresmystuff.View;

public interface IItemView2 extends IItemView {

	public void makeSpinnerVisible();

	void makeDatePickerVisible();

	void makeRadioVisible();

	void makeRadioInvisible();

	void makeDatePickerInvisible();

	public void makeInvisibleSpinner();

	Long getDate();

	public void setAdapter();
}
