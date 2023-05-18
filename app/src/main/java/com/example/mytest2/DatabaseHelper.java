package com.example.mytest2;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "MY_COMPANY.DB";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_TABLE = "USERS";
    static final String USER_ID = "_ID";
    static final String USER_NAME  = "user_name";
    static final String USER_PASSWORD = "password";

    private static final String CREATE_DB_QUERY = "CREATE TABLE "+ DATABASE_TABLE +"("
           + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_NAME + " TEXT NOT NULL," + USER_PASSWORD + " TEXT NOT NULL"+")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertData( int _id,String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.USER_ID,_id);
        contentValues.put(DatabaseHelper.USER_NAME, username);
        contentValues.put(DatabaseHelper.USER_PASSWORD, password);
        db.insert(DatabaseHelper.DATABASE_TABLE,null,contentValues);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        Log.d("MYLOG", "CREATE_DB_QUERY called");
//        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DATABASE_TABLE + "("
//                + USER_ID + " INTEGER PRIMARY KEY," + USER_NAME + " TEXT,"
//                + USER_PASSWORD + " TEXT" + ")";
//        db.execSQL(CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_DB_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE);

    }
}

