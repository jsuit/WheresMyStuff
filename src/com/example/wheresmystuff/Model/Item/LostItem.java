package com.example.wheresmystuff.Model.Item;

import com.example.wheresmystuff.Model.User;

public class LostItem implements Item {

	private ItemInfo itemInfo;
	private User user;
	
	public LostItem(String itemName, String itemCategory, String itemStatus, String itemDescription, User user) {
		
		itemInfo = new ItemInfo(itemName, itemCategory, itemStatus, itemDescription);
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

}
