package com.example.farzammohammadi_comp304sec002_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheckOutActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String location[], price[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_home);

        //Retrieve Decided Prcies and locations
        SharedPreferences myPref = getSharedPreferences("listOfHomes", MODE_PRIVATE);
        String locationStrings = myPref.getString("HomeLocations","");
        String priceStrings = myPref.getString("HomePrices","");
        location = locationStrings.split("-");
        price = priceStrings.split("-");

        //Instanciate Recycler
        recyclerView = findViewById(R.id.recyclerView);
        MyAdapter2 myAdapter = new MyAdapter2(this, location, price);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}