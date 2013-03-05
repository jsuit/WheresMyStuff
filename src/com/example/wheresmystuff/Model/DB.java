package com.example.wheresmystuff.Model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.wheresmystuff.DB_Helper;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Model.Item.ItemInfo;
import com.example.wheresmystuff.Model.Item.LostItem;

public class DB implements IModel{

	private DB_Helper my_helper;
	private SQLiteDatabase database;
	private static String curUser;
	  public DB(Context context) {
		    my_helper = new DB_Helper(context);
	  }
	  
	  public void open()  {
		    database = my_helper.getWritableDatabase();
	  }
	  
	  
	  public void close() {
		    my_helper.close();
	  }

	@Override
	public long addPerson(User p) {
		ContentValues values = new ContentValues();
		
		String [] c_info =  p.getContactInfoAsArray();
		//ORDER MATTERS
		String [] columns = {DB_Helper.KEY_EMAIL, DB_Helper.KEY_NAME, DB_Helper.KEY_PHONE, DB_Helper.KEY_ZIP, DB_Helper.KEY_STREET,
							DB_Helper.KEY_LOGIN_ATTEMPTS, DB_Helper.KEY_PASSWORD};
		assert(c_info.length == columns.length -2);
		//put c_info into values
		for (int i = 0; i < c_info.length; i++) {
			values.put(columns[i], c_info[i]);
		}
		//put non_contact info into values
		values.put(columns[5],p.getLoginAttempts());
		values.put(columns[6], p.getPassword());
		
		return database.insert(DB_Helper.DATABASE_TABLE_USERS, null, values);
		
		
	}

	@Override
	public boolean findPerson(String uid, String password) {
		String [] columns = new String [] {DB_Helper.KEY_NAME, DB_Helper.KEY_PASSWORD};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns, DB_Helper.KEY_PASSWORD + " = ? AND " + DB_Helper.KEY_NAME + " = ?",
		         new String[] {password, uid},
		         null,
		         null,
		         null);
		
		
		if(!c.moveToFirst()){
			c.close();
			return false;
		}
		else c.close();
		
		return true;
	}

	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean find_uid(String uid){
		String [] columns = new String [] {DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns, DB_Helper.KEY_NAME + " = ?",
		         new String[] {uid },
		         null,
		         null,
		         null);
		boolean value=c.moveToFirst();
		c.close();
		//didn't find it
		
		if(!value)	{
			Log.d("value", "false");
			return false;	
		}
		//did find it
		else return true;	
	}

	@Override
	public int getLoginAttempts(String u_name) {
		// TODO Auto-generated method stub
		String [] columns = new String [] {DB_Helper.KEY_NAME, DB_Helper.KEY_LOGIN_ATTEMPTS};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns, DB_Helper.KEY_NAME + "=?",
		         new String[] {u_name},
		         null,
		         null,
		         null);
		
		if(!c.moveToFirst()) return -1;
		
		int c_index = c.getColumnIndex(DB_Helper.KEY_LOGIN_ATTEMPTS);
		
		int num = c.getInt(c_index);
	
		c.close();
		return num;
	}

	@Override
	public boolean find_password(String password) {
		String [] columns = new String [] {DB_Helper.KEY_PASSWORD};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns, DB_Helper.KEY_PASSWORD + " = ?",
		         new String[] {password},
		         null,
		         null,
		         null);
		boolean value=	c.moveToFirst();
		c.close();
		return value;	
	}

	@Override
	public void increase_login_attempts(int i, String u_name) {
		// TODO Auto-generated method stub
		String [] columns = new String [] {DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns, DB_Helper.KEY_NAME + " = ? ",
		         new String[] {u_name},
		         null,
		         null,
		         null);
		
		if(!c.moveToFirst()) Log.d("increase login attempts", "failed to find user");
		else{
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS, i);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME+"=?", new String[] {u_name});
		c.close();
		Log.d("increase_login_attempts", "got user and increased the size");
		}
		c.close();
		return;
		
	}

	@Override
	public void setLocked(String u_name) {
		// TODO Auto-generated method stub
		String [] columns = new String [] {DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns, DB_Helper.KEY_NAME + " = ? ",
		         new String[] {u_name},
		         null,
		         null,
		         null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS, 3);
		database.update("table", cv, DB_Helper.KEY_NAME+"=?", new String[] {u_name});
	}
/*
	@Override
	public Item[] getLostItems(String current_user) {
		String [] columns = new String [] {DB_Helper.ITEM_NAME,
				DB_Helper.ITEM_STATUS,
				DB_Helper.ITEM_DESCRIPTION,
				DB_Helper.ITEM_CATEGORY,
				DB_Helper.ITEM_ROW_ID,
				DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.ITEM_TABLE, columns, DB_Helper.KEY_NAME + " = ? AND " + DB_Helper.ITEM_STATUS + " = ?",
		         new String[] {current_user, "lost"},
		         null,
		         null,
		         null);
				
		if(!c.moveToFirst()) {
			c.close();
			return null;	
		}
		List<Item> items = new ArrayList<Item>();
		while(!c.isAfterLast()){
			String itemName = c.getColumnName(c.getColumnIndex(DB_Helper.ITEM_NAME));
			String itemCategory = c.getColumnName(c.getColumnIndex(DB_Helper.ITEM_CATEGORY));
			String itemStatus = c.getColumnName(c.getColumnIndex(DB_Helper.ITEM_STATUS));
			String itemDescription = c.getColumnName(c.getColumnIndex(DB_Helper.ITEM_DESCRIPTION));
			
			Item item = new LostItem(itemName, itemCategory, itemStatus, itemDescription, current_user,null, false, false, false, itemDescription, itemDescription);
			
			items.add(item);	
		}
				Item [] a_item = new Item[items.size()];
				a_item = items.toArray(a_item);
				c.close();
		return a_item;
	}
*/
	@Override
	public void setCurUser(String name){
		// TODO Auto-generated method stub
		curUser = name;
		
	}

	@Override
	public String getCurUser() {
		// TODO Auto-generated method stub
		return curUser;
	}

	@Override
	public Item[] getItems(String current_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item[] getLostItems(String current_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long saveItem(String name, String description, String status,
			boolean keep, boolean heir, boolean misc, String date,
			String curUser, String street, String zip, String type) {
		
		String [] col = {DB_Helper.ITEM_NAME, DB_Helper.ITEM_STATUS, DB_Helper.ITEM_DESCRIPTION, DB_Helper.ITEM_CATEGORY, DB_Helper.ITEM_STREET,
				DB_Helper.KEY_NAME, DB_Helper.ITEM_ZIP, DB_Helper.ITEM_TYPE, DB_Helper.ITEM_DATE, DB_Helper.ITEM_KEEPSAKE, DB_Helper.ITEM_HEIRLOOM, DB_Helper.ITEM_MISC
		};
		
		ContentValues cv = new ContentValues();
		cv.put(col[0], name);
		cv.put(col[1], status);
		cv.put(col[2], description);
		cv.put(col[3], type);
		cv.put(col[4], street);
		cv.put(col[5], curUser);
		cv.put(col[6], zip);
		cv.put(col[7], type);
		cv.put(col[8], date);
		cv.put(col[9], keep);
		cv.put(col[10], heir);
		cv.put(col[11], misc);
	
		return database.insert(DB_Helper.ITEM_TABLE, null, cv);
		
		
	}
		
}

	
	

	

	

	
	
	
	

