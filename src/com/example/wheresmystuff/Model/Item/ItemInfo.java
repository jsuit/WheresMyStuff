package com.example.wheresmystuff.Model.Item;

import java.util.Date;

public class ItemInfo {

	private String itemName, itemCategory, itemStatus, itemDescription, zip, street;
	private Date date;
	private boolean keepsake, misc, heirloom;
	public ItemInfo(String itemName, boolean keepsake, boolean heirloom, boolean misc, String itemStatus, String itemDescription, String item_category, Date date, String zip, String street) {
		
		this.itemName = itemName;
		this.itemCategory = item_category;
		this.itemStatus = itemStatus;
		this.itemDescription = itemDescription;
		//lost, found, donations, or required
		this.date = date;
		this.keepsake = keepsake;
		this.misc = misc;
		this.heirloom=heirloom; 
		this.zip = zip;
		this.street = street;
	}
	
	public void setItemName(String newItemName) {
		
		itemName = newItemName;
		
	}
	
	public void setItemCategory(String newItemCategory) {
		
		itemCategory = newItemCategory;
		
	}
	
	public void setItemStatus(String newItemStatus) {
		
		itemStatus = newItemStatus;
		
	}
	
	public void setItemDescription(String newItemDescription) {
		
		itemDescription = newItemDescription;
	}
	
	public String getItemName() {
		
		return itemName;
		
	}
	
	public String getItemCategory() {
		
		return itemCategory;
		
	}
	
	public String getItemStatus() {
		
		return itemStatus;
		
	}
	
	public String getItemDescription() {
		
		return itemDescription;
		
	}
	
	public String getZip(){
		return this.zip;
	}
	
	public String getStreet(){
		return this.street;
	}
	
	public boolean[] getItemInfo(){
		boolean [] bool = new boolean[3];
		bool[0] = this.keepsake;
		bool[1] = this.heirloom;
		bool[2] = this.misc;
		return bool;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	
}
