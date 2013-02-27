package com.example.wheresmystuff;

public class ItemInfo {

	private String itemName, itemCategory, itemStatus, itemDescription;
	
	public ItemInfo(String itemName, String itemCategory, String itemStatus, String itemDescription) {
		
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemStatus = itemStatus;
		this.itemDescription = itemDescription;
		
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
	
}
