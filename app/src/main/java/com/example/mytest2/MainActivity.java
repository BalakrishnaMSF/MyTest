package com.example.mytest2;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of the DatabaseHelper class
        databaseHelper = new DatabaseHelper(this);

        // Add a new row to the table
        databaseHelper.addData("John", 25);

        // Get all the rows from the table
        Cursor cursor = databaseHelper.getAllData();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                Log.d("MainActivity", "Name: " + name + ", Age: " + age);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Update a row in the table
        databaseHelper.updateData(1, "Jane", 30);

        // Delete a row from the table
        databaseHelper.deleteData(1);
    }

}