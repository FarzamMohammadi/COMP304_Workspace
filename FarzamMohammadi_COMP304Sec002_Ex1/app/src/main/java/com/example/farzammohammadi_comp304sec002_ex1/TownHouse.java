package com.example.farzammohammadi_comp304sec002_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class TownHouse extends AppCompatActivity {
    RecyclerView recyclerView;

    String location[], price[];
    int images[] = {R.drawable.t1, R.drawable.t2, R.drawable.t3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_home);

        //Retrieve location and price arrays
        location = getResources().getStringArray(R.array.apartmentsLocations);
        price  = getResources().getStringArray(R.array.apartmentPrices);

        //Instanciate Recycler
        recyclerView = findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(this, location, price, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    //Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_options_menu, menu);
        return true;
    }
    //Menu Options
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.apartment_item:
                Intent intent1 = new Intent(this, ApartmentHome.class);
                startActivity(intent1);
                return true;
            case R.id.detachedHome_item:
                Intent intent2 = new Intent(this, DetachedHome.class);
                startActivity(intent2);
                return true;
            case R.id.semiDetachedHome_item:
                Intent intent3 = new Intent(this, SemiDetached.class);
                startActivity(intent3);
                return true;
            case R.id.condominium_item:
                Intent intent4 = new Intent(this, Condominium.class);
                startActivity(intent4);
                return true;
            case R.id.townHouse_item:
                Intent intent5 = new Intent(this, TownHouse.class);
                startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}