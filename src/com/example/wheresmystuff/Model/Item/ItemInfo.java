package com.example.wheresmystuff.Model.Item;

<<<<<<< HEAD
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ItemInfo {

	private String itemName, itemCategory, itemStatus, itemDescription, zip, street;
	private Long date;
	private int keepsake, misc, heirloom;
	public ItemInfo(String itemName, int keepsake, int heirloom, int misc, String itemStatus, String itemDescription, String item_category, long date2, String zip, String street) {
		
=======
/**
 * This class keeps the information pertaining to an item, like its name and
 * description
 * 
 * 
 */

public class ItemInfo {

	private String itemName, itemCategory, itemStatus, itemDescription, zip,
			street;
	private Long date;
	private int keepsake, misc, heirloom;

	/**
	 * Constructor
	 * 
	 */
	public ItemInfo(String itemName, int keepsake, int heirloom, int misc,
			String itemStatus, String itemDescription, String item_category,
			long date2, String zip, String street) {

>>>>>>> New Everything
		this.itemName = itemName;
		this.itemCategory = item_category;
		this.itemStatus = itemStatus;
		this.itemDescription = itemDescription;
<<<<<<< HEAD
		//lost, found, donations, or required
		this.date = date2;
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
=======
		// lost, found, donations, or required
		this.date = date2;
		this.keepsake = keepsake;
		this.misc = misc;
		this.heirloom = heirloom;
		this.zip = zip;
		this.street = street;
	}

	/**
	 * Sets the item's name.
	 * 
	 * @param String
	 *            newItemName
	 */

	public void setItemName(String newItemName) {

		itemName = newItemName;

	}

	/**
	 * Set item's category
	 * 
	 * @param String
	 *            newItemCategory
	 */

	public void setItemCategory(String newItemCategory) {

		itemCategory = newItemCategory;

	}

	/**
	 * Set item's Status to either open or closed
	 * 
	 * @param String
	 *            newItemStatus
	 */

	public void setItemStatus(String newItemStatus) {

		itemStatus = newItemStatus.toLowerCase();

	}

	/**
	 * Set item's Description.
	 * 
	 * @param String
	 *            newItemDescription
	 */

	public void setItemDescription(String newItemDescription) {

		itemDescription = newItemDescription;
	}

	/**
	 * Get item's name
	 * 
	 * @return String newItemName
	 */

	public String getItemName() {

		return itemName;

	}

	/**
	 * Get item's category
	 * 
	 * @return String
	 * 
	 */

	public String getItemCategory() {

		return itemCategory;

	}

	/**
	 * Get item's Status (open or closed). Will be in all lower case.
	 * 
	 * @return String
	 * 
	 */

	public String getItemStatus() {

		return itemStatus.toLowerCase();

	}

	/**
	 * Get item's description
	 * 
	 * @return String
	 * 
	 */

	public String getItemDescription() {

		return itemDescription;

	}

	/**
	 * Get ZipCode code of where item was found
	 * 
	 * @return String
	 * 
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 * Get Street of where item was found
	 * 
	 * @return String
	 * 
	 */

	public String getStreet() {
		return this.street;
	}

	/**
	 * Method that is used to tell us whether item is keepsake and/or heirloom
	 * and/or misc. Index 0 == keepsake, Index 1 == heirloom, Index 2 = misc.
	 * 
	 * @return int[]
	 * 
	 */

	public int[] getItemInfo() {
		int[] integer = new int[3];
>>>>>>> New Everything
		integer[0] = this.keepsake;
		integer[1] = this.heirloom;
		integer[2] = this.misc;
		return integer;
	}
<<<<<<< HEAD
	
	public Long getDate(){
		return this.date;
		
	}
	
	
=======

	/**
	 * Get Date item was found
	 * 
	 * @return Long
	 * 
	 */
	public Long getDate() {
		return this.date;

	}

>>>>>>> New Everything
}
