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

    EditText editUserId;
    EditText editUserName;
    EditText editUserPassword;
    DatabaseManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUserId = (EditText) findViewById(R.id.editTextID);
        editUserName = (EditText) findViewById(R.id.editTextUserName);
        editUserPassword = (EditText) findViewById(R.id.editTextPassword);

        dbManager =  new DatabaseManager(this);
        try {
            dbManager.open();
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        DatabaseHelper dbHelper = new DatabaseHelper(this);
//
//        dbHelper.insertData(10,"test","pass");

    }

    public void btnInsertPressed(View v){
        dbManager.insert(Integer.parseInt(editUserId.getText().toString()),editUserName.getText().toString(), editUserPassword.getText().toString());


    }

    public void btnFetchPressed(View v){

        Cursor cursor = dbManager.fetch();

        if(cursor.moveToFirst()){
            do{
                String ID = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USER_ID));
                String username = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USER_NAME));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USER_PASSWORD));
                Log.i("DATABASE_TAG","I have read ID : " + ID + " Username "+ username+ "password :" + password);

            }while (cursor.moveToNext());
        }

    }

    public void btnUpdatePressed(View v){

        dbManager.update(Long.parseLong(editUserId.getText().toString()), editUserName.getText().toString(), editUserPassword.getText().toString());
    }

    public void btnDeletePressed(View v){

        dbManager.delete(Long.parseLong(editUserId.getText().toString()));
    }
}