package com.example.mytest2;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editUserId;
    EditText editUserName;
    EditText editUserPassword;
    DatabaseManager dbManager;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        editUserId = (EditText) findViewById(R.id.editTextID);
//        editUserName = (EditText) findViewById(R.id.editTextUserName);
//        editUserPassword = (EditText) findViewById(R.id.editTextPassword);
//
//        dbManager =  new DatabaseManager(this);
//        try {
//            dbManager.open();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public void btnInsertPressed(View v){
        dbManager.insert(Integer.parseInt(editUserId.getText().toString()),editUserName.getText().toString(), editUserPassword.getText().toString());
        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();


    }

    public void btnFetchPressed(View v){

        Cursor cursor = dbManager.fetch();

        if(cursor.moveToFirst()){
            do{
                String ID = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USER_ID));
                String username = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USER_NAME));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USER_PASSWORD));
                Log.i("DATABASE_TAG","I have read ID : " + ID + " Username "+ username+ "password :" + password);
                Toast.makeText(this, "Data fetched", Toast.LENGTH_SHORT).show();

            }while (cursor.moveToNext());
        }

    }

    public void btnUpdatePressed(View v){

        dbManager.update(Long.parseLong(editUserId.getText().toString()), editUserName.getText().toString(), editUserPassword.getText().toString());
        Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();

    }

    public void btnDeletePressed(View v){

        dbManager.delete(Long.parseLong(editUserId.getText().toString()));
        Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show();

    }


    Button closeButton;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        closeButton = (Button) findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
                builder.setMessage("Data inserted , Do you want to close click Exit or to add another data click OK")
                        .setCancelable(false)
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"you choose to exit from Application",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you choose to add another data/operations",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });

    }
}