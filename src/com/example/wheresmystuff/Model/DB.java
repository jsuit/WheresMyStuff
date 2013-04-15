package com.example.wheresmystuff.Model;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
=======
>>>>>>> New Everything
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.method.DateTimeKeyListener;
import android.util.Log;

import com.example.wheresmystuff.DB_Helper;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Model.Item.ItemInfo;
import com.example.wheresmystuff.Model.Item.LostItem;

public class DB implements IModel {

<<<<<<< HEAD
	 /**
     * Database class. This holds the actual database.
     * 
     * @param item the item to add to the buffer
     */
	
	
	private final static String TRUE = "1";
	private final static String FALSE = "0";
	private DB_Helper my_helper;
	private SQLiteDatabase database;
=======
	/**
	 * Database class. This holds the actual database.
	 * 
	 * @param item
	 *            the item to add to the buffer
	 */

	private final static String TRUE = "1";
	private final static String FALSE = "0";
	private DB_Helper my_helper;
	private static SQLiteDatabase database;
>>>>>>> New Everything
	private static String curUser;

	public DB(Context context) {
		my_helper = new DB_Helper(context);
	}

	public void open() {
<<<<<<< HEAD
		database = my_helper.getWritableDatabase();
	}

	public void close() {
		my_helper.close();
	}

	@Override
	
	 /**
     * Saves a person to the database.
     * 
     * @param User to save to database
     */
=======
		if (database == null || !database.isOpen())
			database = my_helper.getWritableDatabase();
	}

	public void close() {
		if (database != null && database.isOpen())
			my_helper.close();
	}

	@Override
	/**
	 * Saves a person to the database.
	 * 
	 * @param User to save to database
	 */
>>>>>>> New Everything
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
<<<<<<< HEAD
		if (p.isAdmin()) values.put(columns[7], 1);
		else values.put(columns[7], 0);
=======
		if (p.isAdmin())
			values.put(columns[7], 1);
		else
			values.put(columns[7], 0);
>>>>>>> New Everything
		values = firstAdmin(p.getName(), values);
		long id = database.insert(DB_Helper.DATABASE_TABLE_USERS, null, values);
		return id;
	}

<<<<<<< HEAD
	
	 /**
     * user called admin is always an admin.
     * 
     * @param name of user, values of user to save
     */
	private ContentValues firstAdmin(String name, ContentValues values) {

		if("admin".compareTo(name) == 0){

			values.put(DB_Helper.KEY_ADMIN, 1);
			return values;
		}else return values;
	}

	@Override
	 /**
     * Method that is used during login. Want to know if there is a usr with the same password and id. If there is, return true; else 
     * return false
     * 
     * @param user id of person and their password
     */
	public boolean findPerson(String uid, String password) {

		String[] columns = new String[] {DB_Helper.KEY_NAME,
=======
	/**
	 * user called admin is always an admin.
	 * 
	 * @param name
	 *            of user, values of user to save
	 */
	private ContentValues firstAdmin(String name, ContentValues values) {

		if ("admin".compareTo(name) == 0) {

			values.put(DB_Helper.KEY_ADMIN, 1);
			return values;
		} else
			return values;
	}

	@Override
	/**
	 * Method that is used during login. Want to know if there is a usr with the same password and id. 
	 * If there is, return true; else return false
	 * 
	 * @param user id of person and their password
	 */
	public boolean findPerson(String uid, String password) {

		String[] columns = new String[] { DB_Helper.KEY_NAME,
>>>>>>> New Everything
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

<<<<<<< HEAD
	
	@Override
=======
	@Override
	/**
	 *Determines if a uid already exists in the database. Returns true if user exists; else false.
	 *
	 * @param String user id of person and their password
	 * @return boolean
	 */
>>>>>>> New Everything
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
<<<<<<< HEAD
=======
	/**
	 * Returns the number of times a usr has attempted to login according to uid
	 * specified by parameter. Returns -1 if no user found. 
	 * 
	 * @param String
	 *            user id of person and their password
	 * @return int number of times attempted
	 */
>>>>>>> New Everything
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
<<<<<<< HEAD
=======
	/**
	 * Determines if user specified by uid has a particular password.
	 * Returns true if user has password; false otherwise.
	 * 
	 * @param user id of person and their password
	 * @return boolean 
	 */
>>>>>>> New Everything
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
<<<<<<< HEAD
=======
	/**
	 * Increases the number of login attempts according a parameter. 
	 * 
	 * @param String user id of person, int already incremented count
	 * @return void
	 */
>>>>>>> New Everything
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
<<<<<<< HEAD
=======
	/**
	 * Sets account to locked status
	 * 
	 * @param String uid
	 * @return void
	 */
>>>>>>> New Everything
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
<<<<<<< HEAD
	}

	@Override
=======
		c.close();
	}

	@Override
	/**
	 * Returns all the items of a certain kind as an Item array of a current user.
	 * key tells us what kind of item to search for. 
	 * 
	 * @param String current user, String key
	 * @return Item []
	 */
>>>>>>> New Everything
	public Item[] getItems(String current_user, String key) {
		assert (key != null);
		Cursor c = null;
		String upper = key.toUpperCase(Locale.US);
<<<<<<< HEAD

		if ("L".compareTo(upper) == 0) {
			c = database.query(DB_Helper.ITEM_TABLE, null,
					DB_Helper.KEY_NAME + "=? AND " + DB_Helper.ITEM_CATEGORY
							+ "=?", new String[] { current_user, "Lost" },
					null, null, null);
=======
		if ("L".compareTo(upper) == 0) {
			c = database.query(DB_Helper.ITEM_TABLE, null, DB_Helper.KEY_NAME
					+ "=? AND " + DB_Helper.ITEM_CATEGORY + "=?", new String[] {
					current_user, "Lost" }, null, null, null);
>>>>>>> New Everything

			if (!c.moveToFirst()) {
				c.close();
				return null;
			}
<<<<<<< HEAD
		}else if("N".compareTo(upper) ==0){
			c = database.query(DB_Helper.ITEM_TABLE, null,
					DB_Helper.KEY_NAME + "=? AND " + DB_Helper.ITEM_CATEGORY
							+ "=?", new String[] { current_user, "Needed" },
					null, null, null);
=======
		} else if ("N".compareTo(upper) == 0) {
			c = database.query(DB_Helper.ITEM_TABLE, null, DB_Helper.KEY_NAME
					+ "=? AND " + DB_Helper.ITEM_CATEGORY + "=?", new String[] {
					current_user, "Needed" }, null, null, null);
>>>>>>> New Everything

			if (!c.moveToFirst()) {
				c.close();
				return null;
			}

<<<<<<< HEAD
		}else if("F".compareTo(upper)==0){
			c = database.query(DB_Helper.ITEM_TABLE, null,
					DB_Helper.KEY_NAME + "=? AND " + DB_Helper.ITEM_CATEGORY
							+ "=?", new String[] { current_user, "Found" },
					null, null, null);
=======
		} else if ("F".compareTo(upper) == 0) {
			c = database.query(DB_Helper.ITEM_TABLE, null, DB_Helper.KEY_NAME
					+ "=? AND " + DB_Helper.ITEM_CATEGORY + "=?", new String[] {
					current_user, "Found" }, null, null, null);
>>>>>>> New Everything

			if (!c.moveToFirst()) {
				c.close();
				return null;
			}
		}
<<<<<<< HEAD
=======
		// create a list of items
		return createListofItems(c, current_user);
	}

	/**
	 * Creates an array of items for the current user. Pass in cursor that
	 * contains all the info. Method closes cursor.
	 * 
	 * @param Cursor
	 *            c, String current_user
	 * @return Item []
	 */

	private Item[] createListofItems(Cursor c, String current_user) {

>>>>>>> New Everything
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
			long date = c.getLong(c.getColumnIndex(DB_Helper.ITEM_DATE));
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

		Item[] a_item = new Item[items.size()];
		a_item = items.toArray(a_item);
		c.close();
		return a_item;
<<<<<<< HEAD
	}

	@Override
=======

	}

	@Override
	/**
	 * Sets the current usr to the name passed in.
	 * @param String name
	 * 
	 */
>>>>>>> New Everything
	public void setCurUser(String name) {
		// TODO Auto-generated method stub
		curUser = name;

	}

	@Override
<<<<<<< HEAD
=======
	/**
	 *Returns the current_user 
	 * 
	 * @return String curUser
	 */
>>>>>>> New Everything
	public String getCurUser() {
		// TODO Auto-generated method stub
		return curUser;
	}

	@Override
<<<<<<< HEAD
	public Item[] getItems(String current_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
=======
	/**
	 * Saves an Item.Returns -1 if error
	 * 
	 * @param String name, String description, String status, int keep
	 * int heir, Long date, String cur_User, String street, String zip, String type of item
	 * @return Item []
	 */
>>>>>>> New Everything
	public long saveItem(String name, String description, String status,
			int keep, int heir, int misc, Long date, String curUser,
			String street, String zip, String type) {

		String[] col = { DB_Helper.ITEM_NAME, DB_Helper.ITEM_STATUS,
				DB_Helper.ITEM_DESCRIPTION, DB_Helper.ITEM_CATEGORY,
				DB_Helper.ITEM_STREET, DB_Helper.KEY_NAME, DB_Helper.ITEM_ZIP,
				DB_Helper.ITEM_DATE, DB_Helper.ITEM_KEEPSAKE,
				DB_Helper.ITEM_HEIRLOOM, DB_Helper.ITEM_MISC };

		ContentValues cv = new ContentValues();
		cv.put(col[0], name.toLowerCase(Locale.US));
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
<<<<<<< HEAD
=======
	/**
	 * Returns all the locked Accounts as a Collection<String> 
	 * 
	 * 
	 * @return Collection<String>
	 */
>>>>>>> New Everything
	public Collection<String> getLockedAccounts() {
		// TODO Auto-generated method stub
		// must prevent non-admin from calling this

		String[] columns = { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.ITEM_TABLE, columns,
				DB_Helper.KEY_LOGIN_ATTEMPTS + "=?", new String[] { "3" },
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
<<<<<<< HEAD
=======
	/**
	 * Sets a particular user to admin. Doesn't care if user is already admin.
	 * If user doesn't exist, nothing will happen. 
	 * 
	 * @param String uid
	 * @return void
	 */
>>>>>>> New Everything
	public void setAdmin(String uid) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
<<<<<<< HEAD
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null,
				null, null);
=======
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null, null,
				null);
>>>>>>> New Everything
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_ADMIN, TRUE);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
<<<<<<< HEAD
	}

	@Override
=======
		c.close();
	}

	@Override
	/**
	 * Makes a user a regular user.
	 * 
	 * @param String current user, String key
	 * @return void
	 */
>>>>>>> New Everything
	public void removeAdmin(String uid) {
		// TODO Auto-generated method stub

		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
<<<<<<< HEAD
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null,
				null, null);
=======
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null, null,
				null);
>>>>>>> New Everything
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_ADMIN, FALSE);
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
		c.close();

	}

	@Override
<<<<<<< HEAD
=======
	/**
	 * Takes a user's account and sets it unlocked status. 
	 * 
	 * @param String uid
	 * 
	 */
>>>>>>> New Everything
	public void unlockAccount(String uid) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
<<<<<<< HEAD
				DB_Helper.KEY_NAME + " = ?", new String[] { uid }, null,
				null, null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS,0);
=======
				DB_Helper.KEY_NAME + " = ?", new String[] { uid }, null, null,
				null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS, 0);
>>>>>>> New Everything
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
		c.close();
	}
<<<<<<< HEAD
	@Override
=======

	@Override
	/**
	 * Takes a user's account and sets it to locked.
	 * 
	 * @param String uid
	 * 
	 */
>>>>>>> New Everything
	public void lockAccount(String uid) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { DB_Helper.KEY_NAME };

		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
<<<<<<< HEAD
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null,
				null, null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS,3);
=======
				DB_Helper.KEY_NAME + "=?", new String[] { uid }, null, null,
				null);
		ContentValues cv = new ContentValues();
		cv.put(DB_Helper.KEY_LOGIN_ATTEMPTS, 3);
>>>>>>> New Everything
		database.update(DB_Helper.DATABASE_TABLE_USERS, cv, DB_Helper.KEY_NAME
				+ "=?", new String[] { uid });
		c.close();
	}

	@Override
<<<<<<< HEAD
	public boolean isAdmin(String uid) {

		String [] columns = {DB_Helper.KEY_ADMIN, DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_ADMIN + "=? AND " + DB_Helper.KEY_NAME +"=?", new String[] { TRUE, uid },
				null, null, null);
=======
	/**
	 * Checks to see if user is an admin. If yes, return true; else false.
	 * 
	 * @param String current user
	 * @return boolean
	 */
	public boolean isAdmin(String uid) {

		String[] columns = { DB_Helper.KEY_ADMIN, DB_Helper.KEY_NAME };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_ADMIN + "=? AND " + DB_Helper.KEY_NAME + "=?",
				new String[] { TRUE, uid }, null, null, null);
>>>>>>> New Everything

		boolean value = c.moveToFirst();
		c.close();
		return value;
	}
<<<<<<< HEAD
	 @Override
	 /**
	     * Removes a user.
	     * 
	     * @param String uid of user to unlock
	     *	@return returns number of items deleted + number of usrs deleted
	     */
	public int removeUser(String uid){
		open();
		String [] where = {uid};
		int user_deleted = database.delete(DB_Helper.DATABASE_TABLE_USERS, DB_Helper.KEY_NAME + "=?", where);
		int rows_deleted = database.delete(DB_Helper.ITEM_TABLE, DB_Helper.KEY_NAME + "=?", where);
		close();
		if(user_deleted == 0)return 0;
		else return user_deleted + rows_deleted;
=======

	@Override
	/**
	 * Removes a user.
	 * 
	 * @param String uid of user to unlock
	 *	@return returns number of items deleted + number of usrs deleted
	 */
	public int removeUser(String uid) {
		open();
		String[] where = { uid };
		int user_deleted = database.delete(DB_Helper.DATABASE_TABLE_USERS,
				DB_Helper.KEY_NAME + "=?", where);
		int rows_deleted = database.delete(DB_Helper.ITEM_TABLE,
				DB_Helper.KEY_NAME + "=?", where);
		close();
		if (user_deleted == 0)
			return 0;
		else
			return user_deleted + rows_deleted;
>>>>>>> New Everything

	}

	@Override
<<<<<<< HEAD
	public boolean find_email(String email,String uid) {
		// TODO Auto-generated method stub
		String [] columns = {DB_Helper.KEY_EMAIL, DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_EMAIL + "=? AND " + DB_Helper.KEY_NAME +"=?", new String[] { email, uid },
				null, null, null);
=======
	/**
	 * Determines if user has email. Returns true if user does; else false.
	 * 
	 * @param String email, String uid
	 * @return boolean
	 */
	public boolean find_email(String email, String uid) {
		// TODO Auto-generated method stub
		String[] columns = { DB_Helper.KEY_EMAIL, DB_Helper.KEY_NAME };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				DB_Helper.KEY_EMAIL + "=? AND " + DB_Helper.KEY_NAME + "=?",
				new String[] { email, uid }, null, null, null);
>>>>>>> New Everything

		boolean value = c.moveToNext();
		c.close();
		return value;
	}

	@Override
<<<<<<< HEAD
	public List<String> getAccounts() {
		String [] columns = {DB_Helper.KEY_NAME};
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				null, null, null, null, null);

		boolean value = c.moveToFirst();
		if(value){
			List<String> users = new ArrayList<String>();
			while(!c.isAfterLast()){		
					users.add(c.getString(c.getColumnIndex(DB_Helper.KEY_NAME)));
					c.moveToNext();
				}
				c.close();
				return users;
			}
		else {
			c.close();
			return null;
		}
	}

	

	@Override
	public Cursor searchByDate(String lost_etc_categories, String refined_search) {
		// TODO Auto-generated method stub

		Long date = Long.parseLong(refined_search);
		String[] args = {refined_search, lost_etc_categories};
		String sql = "SELECT * FROM " + DB_Helper.ITEM_TABLE + " WHERE " + DB_Helper.ITEM_DATE + " >=?" + " AND " 
		+ DB_Helper.ITEM_CATEGORY + "=?"  + " ORDER BY " + 
		DB_Helper.ITEM_DATE + " DESC";

		Cursor c = database.rawQuery(sql, args);

=======
	/**
	 *Returns all user names of all accounts as a list. If no accounts, then return null; 
	 * 
	 * @param String current user, String key
	 * @return List<String> of accounts
	 */
	public List<String> getAccounts() {
		String[] columns = { DB_Helper.KEY_NAME };
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns,
				null, null, null, null, null);

		if (c.moveToFirst())
			// this method closes the cursor
			return createListOfAccounts(c);
		else
			return null;
	}

	/**
	 * makes a list of accounts and returns it.Cursor must not be null
	 * 
	 * @param String
	 *            Cursor c
	 * @return List<String> of uids of accounts
	 */
	private List<String> createListOfAccounts(Cursor c) {
		List<String> users = new ArrayList<String>();
		while (!c.isAfterLast()) {
			users.add(c.getString(c.getColumnIndex(DB_Helper.KEY_NAME)));
			c.moveToNext();
		}
		c.close();
		return users;
	}

	@Override
	/**
	 *Finds all items of a certain type (Lost, Found, Needed, Donations) on or after a date 
	 *First parameter tells us the type.
	 * 
	 * @param String lost_etc_categories, String this_date
	 * @return Cursor
	 */
	public Cursor searchByDate(String lost_etc_categories, String this_date) {
		// TODO Auto-generated method stub

		Long date = Long.parseLong(this_date);
		String[] args = { this_date, lost_etc_categories };
		String sql = "SELECT * FROM " + DB_Helper.ITEM_TABLE + " WHERE "
				+ DB_Helper.ITEM_DATE + " >=?" + " AND "
				+ DB_Helper.ITEM_CATEGORY + "=?" + " ORDER BY "
				+ DB_Helper.ITEM_DATE + " DESC";

		Cursor c = database.rawQuery(sql, args);
		c.moveToFirst();
>>>>>>> New Everything
		return c;
	}

	@Override
<<<<<<< HEAD
	public Cursor searchByCategory(String lost_etc_categories,
			String refined_search) {

		refined_search=refined_search.toLowerCase(Locale.US);
		int value = "item_keepsakes".compareTo("item_"+refined_search);
		String [] args = {lost_etc_categories,"1"};

		String sql = "SELECT * FROM " + DB_Helper.ITEM_TABLE + " WHERE " + DB_Helper.ITEM_CATEGORY + "=? AND " + "item_"+refined_search+ "=?" +
					" ORDER BY " + DB_Helper.ITEM_DATE + " DESC";
		 Cursor c =    database.rawQuery(sql, args);
		 return c;
	}

	@Override
	public Cursor searchByStatus(String lost_etc_categories, String refined_search) {


		String [] args = {lost_etc_categories,refined_search};
		
		String sql = "SELECT * FROM " + DB_Helper.ITEM_TABLE + " WHERE " + DB_Helper.ITEM_CATEGORY + "=? AND " + DB_Helper.ITEM_STATUS + "=?";
		 Cursor c =    database.rawQuery(sql, args);
		 c.moveToFirst();
		 return c;

=======
	/**
	 *Finds all items of a certain type (Lost, Found, Needed, Donations) by a predetermined Category (ex: Heirloom) 
	 *First parameter tells us the type.
	 * 
	 * @param String lost_etc_categories, String refined_searchg
	 * @return Cursor
	 */
	public Cursor searchByCategory(String lost_etc_categories,
			String refined_search) {

		refined_search = refined_search.toLowerCase(Locale.US);
		int value = "item_keepsakes".compareTo("item_" + refined_search);
		String[] args = { lost_etc_categories, "1" };

		String sql = "SELECT * FROM " + DB_Helper.ITEM_TABLE + " WHERE "
				+ DB_Helper.ITEM_CATEGORY + "=? AND " + "item_"
				+ refined_search + "=?" + " ORDER BY " + DB_Helper.ITEM_DATE
				+ " DESC";
		Cursor c = database.rawQuery(sql, args);
		c.moveToFirst();
		return c;
	}

	@Override
	/**
	 *Finds all items of a certain type (Lost, Found, Needed, Donations) by status 
	 *First parameter tells us the type.
	 * 
	 * @param String lost_etc_categories, String refined-search
	 * @return Cursor
	 */
	public Cursor searchByStatus(String lost_etc_categories,
			String refined_search) {

		String[] args = { lost_etc_categories, refined_search };

		String sql = "SELECT * FROM " + DB_Helper.ITEM_TABLE + " WHERE "
				+ DB_Helper.ITEM_CATEGORY + "=? AND " + DB_Helper.ITEM_STATUS
				+ "=?";
		Cursor c = database.rawQuery(sql, args);
		c.moveToFirst();
		return c;
>>>>>>> New Everything

		// TODO Auto-generated method stub

	}
<<<<<<< HEAD
	@Override
	public Cursor searchByItemName( String lost_etc_categories, String [] name_location){
		//first member in itemname should be the name, second the zip
		
		
		Cursor c = database.query(DB_Helper.ITEM_TABLE, null,DB_Helper.ITEM_CATEGORY + "=? AND " +
				DB_Helper.ITEM_NAME+"=? AND " + DB_Helper.ITEM_ZIP + "=?", new String[] { lost_etc_categories, name_location[0].toLowerCase(Locale.US), name_location[1] },
				null, null, DB_Helper.ITEM_NAME + " ASC");
		c.moveToFirst();
		return c;
	}
	@Override
	public Cursor searchByItemName( String lost_etc_categories, String itemName){
		//first member in itemname should be the name, second the zip
		
		
		Cursor c = database.query(DB_Helper.ITEM_TABLE, null,DB_Helper.ITEM_CATEGORY + "=? AND " +
				DB_Helper.ITEM_NAME+"=?", new String[] { lost_etc_categories, itemName.toLowerCase() },
				null, null, DB_Helper.ITEM_NAME + " ASC");
		if(!c.moveToFirst()){
			c = database.query(DB_Helper.ITEM_TABLE, null,DB_Helper.ITEM_CATEGORY + "=? AND " +
					DB_Helper.ITEM_ZIP +"=?", new String[] { lost_etc_categories, itemName },
					null, null, DB_Helper.ITEM_NAME + " ASC");
		}
=======

	@Override
	/**
	 *Finds all items of a certain type (Lost, Found, Needed, Donations) by name and/or location of item 
	 *First parameter tells us the type. Second parameter has name of item and/or location
	 * 
	 * @param String lost_etc_categories, String [] name_location
	 * @return Cursor
	 */
	public Cursor searchByItemName(String lost_etc_categories,
			String[] name_location) {
		// first member in itemname should be the name, second the zip

		Cursor c = database.query(
				DB_Helper.ITEM_TABLE,
				null,
				DB_Helper.ITEM_CATEGORY + "=? AND " + DB_Helper.ITEM_NAME
						+ "=? AND " + DB_Helper.ITEM_ZIP + "=?",
				new String[] { lost_etc_categories,
						name_location[0].toLowerCase(Locale.US),
						name_location[1] }, null, null, DB_Helper.ITEM_NAME
						+ " ASC");
		c.moveToFirst();
		return c;
	}

	@Override
	/**
	 *Finds all items of a certain type (Lost, Found, Needed, Donations) by name
	 *First parameter tells us the type. Second parameter gives us the name of item or location but
	 *not both
	 * 
	 * @param String lost_etc_categories, String itemName
	 * @return Cursor
	 */
	public Cursor searchByItemName(String lost_etc_categories,
			String itemNameLocation) {
		// first member in itemname should be the name, second the zip

		Cursor c = database.query(DB_Helper.ITEM_TABLE, null,
				DB_Helper.ITEM_CATEGORY + "=? AND " + DB_Helper.ITEM_NAME
						+ "=?", new String[] { lost_etc_categories,
						itemNameLocation.toLowerCase() }, null, null,
				DB_Helper.ITEM_NAME + " ASC");
		if (!c.moveToFirst()) {
			return searchByZip(lost_etc_categories, itemNameLocation);

		}
		c.moveToFirst();
>>>>>>> New Everything
		return c;
	}

	@Override
<<<<<<< HEAD
	public Cursor searchByZip(String lost_etc_categories,
			String refined_search) {
		// TODO Auto-generated method stub
		
		Cursor c = database.query(DB_Helper.ITEM_TABLE, null,DB_Helper.ITEM_CATEGORY + "=? AND " +
				DB_Helper.ITEM_ZIP +"=?", new String[] { lost_etc_categories, refined_search },
				null, null, DB_Helper.ITEM_NAME + " ASC");
		return c;
		
	}

	




=======
	/**
	 *Search by ZipCode of item. 
	 * 
	 * @param String lost_etc_categories, String zip
	 * @return Cursor
	 */
	public Cursor searchByZip(String lost_etc_categories, String i_zip) {
		// TODO Auto-generated method stub

		Cursor c = database
				.query(DB_Helper.ITEM_TABLE, null, DB_Helper.ITEM_CATEGORY
						+ "=? AND " + DB_Helper.ITEM_ZIP + "=?", new String[] {
						lost_etc_categories, i_zip }, null, null,
						DB_Helper.ITEM_NAME + " ASC");
		c.moveToFirst();
		return c;
	}

>>>>>>> New Everything
}