package com.example.wheresmystuff.Model.Item;

import java.util.Date;

public class ItemInfo {

	private String itemName, itemCategory, itemStatus, itemDescription, zip, street;
	private Date date;
	private int keepsake, misc, heirloom;
	public ItemInfo(String itemName, int keepsake, int heirloom, int misc, String itemStatus, String itemDescription, String item_category, Date date, String zip, String street) {
		
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
	
	public int [] getItemInfo(){
		int [] integer = new int[3];
		integer[0] = this.keepsake;
		integer[1] = this.heirloom;
		integer[2] = this.misc;
		return integer;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	
}
