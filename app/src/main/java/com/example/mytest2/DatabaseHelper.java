package com.example.mytest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE my_table ("
                + "id INTEGER PRIMARY KEY,"
                + "name TEXT,"
                + "age INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS my_table";
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public void addData(String name, int age) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);

        db.insert("my_table", null, values);
        db.close();
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM my_table", null);
        return cursor;
    }

    public void updateData(int id, String name, int age) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);

        db.update("my_table", values, "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase db = null;
        try {
            db = super.getWritableDatabase();
        } catch (SQLiteException e) {
            Log.e("DatabaseHelper", "Error opening writable database: " + e.getMessage());
        }
        return db;
    }

    public void deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("my_table", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }
}

