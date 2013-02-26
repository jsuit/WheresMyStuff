package com.example.wheresmystuff.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.wheresmystuff.DB_Helper;

public class DB implements IModel{

	private DB_Helper my_helper;
	private SQLiteDatabase database;
	
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
		//fix this
		String [] c_info =  p.getContactInfoAsArray();
		
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
		         new String[] { password, uid },
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
		Cursor c = database.query(DB_Helper.DATABASE_TABLE_USERS, columns, DB_Helper.KEY_NAME + " = ? ",
		         new String[] {uid },
		         null,
		         null,
		         null);
		boolean value=	c.moveToFirst();
		c.close();
		//didn't find it
		
		if(!value)	{
			Log.d("value", "false");
			return false;	
		}
		//did find it
		else return true;
		
	}

	
	
	

}
