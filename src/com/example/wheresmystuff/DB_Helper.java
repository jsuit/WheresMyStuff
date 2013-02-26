package com.example.wheresmystuff;

import com.example.wheresmystuff.Model.IModel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_Helper extends SQLiteOpenHelper {
	
	public static final String KEY_ROW_ID = "id";
	public static final String KEY_NAME = "id_name";
	public static final String KEY_ZIP = "zip";
	public static final String KEY_STREET = "street";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_PHONE = "phone";
	public static final String KEY_PASSWORD = "id_password";
	public static final String KEY_LOGIN_ATTEMPTS = "login_attempts";
	public static final String DATABASE_TABLE_USERS = "reg_users_table";
	private static final String DATABASE_NAME = "users_info_db";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_CREATE = "CREATE TABLE "
		      + DATABASE_TABLE_USERS + "(" + KEY_ROW_ID + 
		     " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
		      + " TEXT NOT NULL," + KEY_PASSWORD + " TEXT NOT NULL," + KEY_LOGIN_ATTEMPTS + " INTEGER NOT NULL," + KEY_ZIP + " TEXT," +
		      KEY_STREET + " TEXT," + KEY_EMAIL + " TEXT NOT NULL," + KEY_PHONE + " TEXT);";
	
	public DB_Helper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		
	}

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DB_Helper.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USERS);
	    onCreate(db);
		
	}
	
	

	
	
	

}
