package com.example.wheresmystuff.Model.Item;

import java.util.Date;

import com.example.wheresmystuff.Model.User;

public class LostItem implements Item {

	private ItemInfo itemInfo;
	private String user;
	
	
	public LostItem(String itemName, String itemCategory, String itemStatus, String itemDescription, String user, Date date,
			int keepsake, int heirloom, int misc, String zip, String street) {
		
		itemInfo = new ItemInfo(itemName, keepsake, heirloom, misc, itemStatus, itemDescription, itemCategory, date, zip, street);
		this.user = user;
		
	}
	
	


	@Override
	public void setItemName(String newItemName) {
		// TODO Auto-generated method stub
		itemInfo.setItemName(newItemName);

	}

	@Override
	public void setItemCategory(String newItemCategory) {
		// TODO Auto-generated method stub
		itemInfo.setItemCategory(newItemCategory);

	}

	@Override
	public void setItemStatus(String newItemStatus) {
		// TODO Auto-generated method stub
		itemInfo.setItemStatus(newItemStatus);

	}
	
	@Override
	public void setItemDescription(String newItemDescription) {
		itemInfo.setItemDescription(newItemDescription);
		
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return itemInfo.getItemName();
	}

	@Override
	public String getItemCategory() {
		// TODO Auto-generated method stub
		return itemInfo.getItemCategory();
	}

	@Override
	public String getItemStatus() {
		// TODO Auto-generated method stub
		return itemInfo.getItemStatus();
	}
	
	@Override
	public String getItemDescription() {
		return itemInfo.getItemDescription();
		
	}


	@Override
	public String getStreet() {
		return itemInfo.getStreet();
	}


	@Override
	public String getZip() {
		// TODO Auto-generated method stub
		
		return itemInfo.getZip();
	}


	@Override
	public int [] kindofItem() {
		// TODO Auto-generated method stub
		int [] bool = itemInfo.getItemInfo();
		return bool;
	}

	public String getDateAsString(){
		Date date = itemInfo.getDate();
		int month = date.getMonth();
		int day = date.getDay();
		int year = date.getYear();
		return month + "/" + day +"/" + year;
	}



}
