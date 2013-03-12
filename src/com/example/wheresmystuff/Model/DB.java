package com.example.wheresmystuff.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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

public class DB implements IModel {

	private final static String TRUE = "1";
	private final static String FALSE = "0";
	private DB_Helper my_helper;
	private SQLiteDatabase database;
	private static String curUser;

	public DB(Context context) {
		my_helper = new DB_Helper(context);
	}

	public void open() {
		database = my_helper.getWritableDatabase();
	}

	public void close() {
		my_helper.close();
	}

	@Override
	public long addPerson(User p) {
		ContentValues values = new ContentValues();

		String[] c_info = p.getContactInfoAsArray();
		// ORDER MATTERS
		String[] columns = { DB_Helper.KEY_EMAIL, DB_Helper.KEY_NAME,
				DB_Helper.KEY_PHONE, DB_Helper.KEY_ZIP, DB_Helper.KEY_STREET,
				DB_Helper.KEY_LOGIN_ATTEMPTS, DB_Helper.KEY_PASSWORD,
				DB_Helper.KEY_ADMIN };

		// put c_info into values
		for (int i = 0; i < c_info.length; i++) {
			values.put(columns[i], c_info[i]);
		}
		// put non_contact info into values
		values.put(columns[5], p.getLoginAttempts());
		values.put(columns[6], p.getPassword());
		values.put(columns[7], 0);
		firstAdmin(p.getName());
		return database.insert(DB_Helper.DATABASE_TABLE_USERS, null, values);

	}

	private void firstAdmin(String name) {

		if("jon".compareTo(name) == 0){

			ContentValues cv = new ContentValues();
			cv.put(DB_Helper.KEY_ADMIN, 1);
			String [] columns = {DB_Helper.KEY_NAME, DB_Helper.KEY_ADMIN};
			Cursor cursor = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
					DB_Helper.KEY_NAME + " = ?", new String[] { name }, null,
					null, null);

			database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
					+ "=?", new String[] { name });		
		}
	}

	@Override
	public boolean findPerson(String uid, String password) {

		String[] columns = new String[] {DB_Helper.KEY_NAME,
				DB_Helper.KEY_PASSWORD };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_PASSWORD + " = ? AND " + DB_Helper.KEY_NAME
						+ " = ?", new String[] { password, uid }, null, null,
				null);

		if (!c.moveToFirst()) {
			c.close();
			return false;
		} else
			c.close();

		return true;
	}

	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean find_uid(String uid) {

		String[] columns = new String[] { DB_Helper.KEY_NAME };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + " = ?", new String[] { uid }, null, null,
				null);
		boolean value = c.moveToFirst();
		c.close();
		// didn't find it

		if (!value) {
			Log.d("value", "false");
			return false;
		}
		// did find it
		else
			return true;
	}

	@Override
	public int getLoginAttempts(String u_name) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME,
				DB_Helper.KEY_LOGIN_ATTEMPTS };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + "=?", new String[] { u_name }, null, null,
				null);

		if (!c.moveToFirst())
			return -1;

		int c_index = c.getColumnIndex(DB_Helper.KEY_LOGIN_ATTEMPTS);

		int num = c.getInt(c_index);

		c.close();
		return num;
	}

	@Override
	public boolean find_password(String password, String uid) {
		String[] columns = new String[] { DB_Helper.KEY_PASSWORD,
				DB_Helper.KEY_NAME };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_PASSWORD + " = ? AND " + DB_Helper.KEY_NAME
						+ "= ?", new String[] { password, uid }, null, null,
				null);
		boolean value = c.moveToFirst();
		c.close();
		return value;
	}

	@Override
	public void increase_login_attempts(int i, String u_name) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + "=?", new String[] { u_name }, null, null,
				null);

		if (!c.moveToFirst())
			Log.d("increase login attempts", "failed to find user");
		else {
			ContentValues cv = new ContentValues();
			cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS, i);
			database.update(DB_Helper.DATABASE_TABLE_USERS, cv,
					DB_Helper.KEY_NAME + "=?", new String[] { u_name });
			c.close();
			Log.d("increase_login_attempts", "got user and increased the size");
		}
		c.close();
		return;

	}

	@Override
	public void setLocked(String u_name) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + " = ?", new String[] { u_name }, null,
				null, null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS, 3);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { u_name });
	}

	@Override
	public Item[] getItems(String current_user, String key) {
		assert (key != null);
		Cursor c = null;
		String upper = key.toUpperCase();
		if ("L".compareTo(upper) == 0) {
			c = database.query(DB_Helper.ITEM_TABLE, null,
					DB_Helper.KEY_NAME + "=? AND " + DB_Helper.ITEM_CATEGORY
							+ "=?", new String[] { current_user, "Lost" },
					null, null, null);

			if (!c.moveToFirst()) {
				c.close();
				return null;
			}
		}else if("N".compareTo(upper) ==0){
			c = database.query(DB_Helper.ITEM_TABLE, null,
					DB_Helper.KEY_NAME + "=? AND " + DB_Helper.ITEM_CATEGORY
							+ "=?", new String[] { current_user, "Needed" },
					null, null, null);

			if (!c.moveToFirst()) {
				c.close();
				return null;
			}

		}
		List<Item> items = new ArrayList<Item>();
		int i = c.getCount();
		while (!c.isAfterLast()) {
			String itemName = c
					.getString(c.getColumnIndex(DB_Helper.ITEM_NAME));
			String itemCategory = c.getString(c
					.getColumnIndex(DB_Helper.ITEM_CATEGORY));
			String itemStatus = c.getString(c
					.getColumnIndex(DB_Helper.ITEM_STATUS));
			String itemDescription = c.getString(c
					.getColumnIndex(DB_Helper.ITEM_DESCRIPTION));
			Date date = new Date(c.getString(c
					.getColumnIndex(DB_Helper.ITEM_DATE)));
			int keepsake = c.getInt(c.getColumnIndex(DB_Helper.ITEM_KEEPSAKE));
			int heirloom = c.getInt(c.getColumnIndex(DB_Helper.ITEM_HEIRLOOM));
			int misc = c.getInt(c.getColumnIndex(DB_Helper.ITEM_MISC));
			String zip = c.getString(c.getColumnIndex(DB_Helper.ITEM_ZIP));
			String street = c
					.getString(c.getColumnIndex(DB_Helper.ITEM_STREET));
			Item item = new LostItem(itemName, itemCategory, itemStatus,
					itemDescription, current_user, date, keepsake, heirloom,
					misc, zip, street);
			items.add(item);
			c.moveToNext();
		}
		int length = items.size();
		Item[] a_item = new Item[items.size()];
		a_item = items.toArray(a_item);
		c.close();
		return a_item;
	}

	@Override
	public void setCurUser(String name) {
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
	public long saveItem(String name, String description, String status,
			int keep, int heir, int misc, String date, String curUser,
			String street, String zip, String type) {

		String[] col = { DB_Helper.ITEM_NAME, DB_Helper.ITEM_STATUS,
				DB_Helper.ITEM_DESCRIPTION, DB_Helper.ITEM_CATEGORY,
				DB_Helper.ITEM_STREET, DB_Helper.KEY_NAME, DB_Helper.ITEM_ZIP,
				DB_Helper.ITEM_DATE, DB_Helper.ITEM_KEEPSAKE,
				DB_Helper.ITEM_HEIRLOOM, DB_Helper.ITEM_MISC };

		ContentValues cv = new ContentValues();
		cv.put(col[0], name);
		cv.put(col[1], status);
		cv.put(col[2], description);
		cv.put(col[3], type);
		cv.put(col[4], street);
		cv.put(col[5], curUser);
		cv.put(col[6], zip);
		cv.put(col[7], date);
		cv.put(col[8], keep);
		cv.put(col[9], heir);
		cv.put(col[10], misc);

		return database.insert(DB_Helper.ITEM_TABLE, null, cv);

	}

	@Override
	public Collection<String> getLockedAccounts() {
		// TODO Auto-generated method stub
		// must prevent non-admin from calling this

		String[] columns = { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.ITEM_TABLE, columns,
				DB_Helper.KEY_LOGIN_ATTEMPTS + "=?", new String[] { "1" },
				null, null, null);
		if (!c.moveToFirst()) {
			c.close();
			return null;
		} else {
			Collection<String> uids = new ArrayList<String>();
			while (c.moveToNext()) {
				uids.add(c.getString(c.getColumnIndex(DB_Helper.KEY_NAME)));
			}
			c.close();
			return uids;
		}
	}

	@Override
	public void setAdmin(String uid) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null,
				null, null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_ADMIN, TRUE);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
	}

	@Override
	public void removeAdmin(String uid) {
		// TODO Auto-generated method stub

		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null,
				null, null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_ADMIN, FALSE);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
		c.close();

	}

	@Override
	public void unlockAccount(String uid) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + " = ?", new String[] { uid }, null,
				null, null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS,0);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
		c.close();
	}
	@Override
	public void lockAccount(String uid) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null,
				null, null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS,3);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
		c.close();
	}

	@Override
	public boolean isAdmin(String uid) {

		String [] columns = {DB_Helper.KEY_ADMIN, DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_ADMIN + "=? AND " + DB_Helper.KEY_NAME +"=?", new String[] { TRUE, uid },
				null, null, null);

		boolean value = c.moveToFirst();
		c.close();
		return value;
	}
	
	 @Override
	public void removeUser(String uid){
		int user_deleted = database.delete(DB_Helper.DATABASE_TABLE_USERS, DB_Helper.KEY_NAME + "=" + uid, null);
		int rows_deleted = database.delete(DB_Helper.ITEM_TABLE, DB_Helper.KEY_NAME + "=" + uid, null);

	}


}