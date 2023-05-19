package com.example.mytest2;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.button1);
        sub = (Button) findViewById(R.id.button2);
        mul = (Button) findViewById(R.id.button3);
        div = (Button) findViewById(R.id.button4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText) findViewById(R.id.number1);
                EditText et2 = (EditText) findViewById(R.id.number2);
                EditText et3 = (EditText) findViewById(R.id.number3);
                int n1 = Integer.parseInt(et1.getText().toString());
                int n2 = Integer.parseInt(et2.getText().toString());
                int result = n1 + n2;

                et3.setText("Total value "+ result);

            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText) findViewById(R.id.number1);
                EditText et2 = (EditText) findViewById(R.id.number2);
                EditText et3 = (EditText) findViewById(R.id.number3);

                int n1 = Integer.parseInt(et1.getText().toString());
                int n2 = Integer.parseInt(et2.getText().toString());
                int result = n1 - n2;

                et3.setText("Total value "+ result);


            }
        });


        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText) findViewById(R.id.number1);
                EditText et2 = (EditText) findViewById(R.id.number2);
                EditText et3 = (EditText) findViewById(R.id.number3);

                int n1 = Integer.parseInt(et1.getText().toString());
                int n2 = Integer.parseInt(et2.getText().toString());
                int result = n1 * n2;

                et3.setText("Total value "+ result);
            }

        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText) findViewById(R.id.number1);
                EditText et2 = (EditText) findViewById(R.id.number2);
                EditText et3 = (EditText) findViewById(R.id.number3);

                int n1 = Integer.parseInt(et1.getText().toString());
                int n2 = Integer.parseInt(et2.getText().toString());
                int result = n1 / n2;

                et3.setText("Total value "+ result);

            }
        });
    }
}