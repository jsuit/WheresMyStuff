package com.example.wheresmystuff.Model.Item;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

<<<<<<< HEAD


=======
>>>>>>> New Everything
import com.example.wheresmystuff.Model.User;

public class LostItem implements Item {

	private ItemInfo itemInfo;
	private String user;
<<<<<<< HEAD
	
	
	public LostItem(String itemName, String itemCategory, String itemStatus, String itemDescription, String user, long date,
			int keepsake, int heirloom, int misc, String zip, String street) {
		
		itemInfo = new ItemInfo(itemName, keepsake, heirloom, misc, itemStatus, itemDescription, itemCategory, date, zip, street);
		this.user = user;
		
	}
	
	





=======

	public LostItem(String itemName, String itemCategory, String itemStatus,
			String itemDescription, String user, long date, int keepsake,
			int heirloom, int misc, String zip, String street) {

		itemInfo = new ItemInfo(itemName, keepsake, heirloom, misc, itemStatus,
				itemDescription, itemCategory, date, zip, street);
		this.user = user;

	}
>>>>>>> New Everything

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
<<<<<<< HEAD
	
	@Override
	public void setItemDescription(String newItemDescription) {
		itemInfo.setItemDescription(newItemDescription);
		
=======

	@Override
	public void setItemDescription(String newItemDescription) {
		itemInfo.setItemDescription(newItemDescription);

>>>>>>> New Everything
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
<<<<<<< HEAD
	
	@Override
	public String getItemDescription() {
		return itemInfo.getItemDescription();
		
	}

=======

	@Override
	public String getItemDescription() {
		return itemInfo.getItemDescription();

	}
>>>>>>> New Everything

	@Override
	public String getStreet() {
		return itemInfo.getStreet();
	}

<<<<<<< HEAD

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

	public Long getDateAsString(){
		Long date = itemInfo.getDate();
		Calendar myCal = new GregorianCalendar();
		//SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date;
	}



=======
	@Override
	public String getZip() {
		// TODO Auto-generated method stub

		return itemInfo.getZip();
	}

	@Override
	public int[] kindofItem() {
		// TODO Auto-generated method stub
		int[] bool = itemInfo.getItemInfo();
		return bool;
	}

	public Long getDateAsString() {
		Long date = itemInfo.getDate();
		Calendar myCal = new GregorianCalendar();
		// SimpleDateFormat date_format = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date;
	}

>>>>>>> New Everything
}
