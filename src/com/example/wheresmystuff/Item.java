package com.example.wheresmystuff;

public interface Item {

	public void setItemName(String newItemName);
	
	public void setItemCategory(String newItemCategory);
	
	public void setItemStatus(String newItemStatus);
	
	public void setItemDescription(String newItemDescription);
	
	public String getItemName();
	
	public String getItemCategory();
	
	public String getItemStatus();
	
	public String getItemDescription();
	
}
