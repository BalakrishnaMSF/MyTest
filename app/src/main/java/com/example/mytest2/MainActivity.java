package com.example.mytest2;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Bala","bala@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Krishna","krishna@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Mahesh","mahesh@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Meghana","meghana@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Manasa","Manasa@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Jasmin","jasmin@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Divya","divya@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Sumaiya","sumaiya@gmail",R.drawable.ic_launcher_foreground));
        items.add(new Item("Bala_123","bala@gmail",R.drawable.ic_launcher_background));
        items.add(new Item("Krishna_143","krishna@gmail",R.drawable.ic_launcher_background));
        items.add(new Item("Mahesh_132","mahesh@gmail",R.drawable.ic_launcher_background));
        items.add(new Item("Meghana_123","meghana@gmail",R.drawable.ic_launcher_background));
        items.add(new Item("Manasa_032","Manasa@gmail",R.drawable.ic_launcher_background));
        items.add(new Item("Jasmin_143","jasmin@gmail",R.drawable.ic_launcher_background));
        items.add(new Item("Divya_132","divya@gmail",R.drawable.ic_launcher_background));
        items.add(new Item("Sumaiya_53","sumaiya@gmail",R.drawable.ic_launcher_background));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }


}