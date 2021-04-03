package com.example.farzammohammadi_comp304sec002_lab03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersianCuisineActivity extends AppCompatActivity {

    String[] locationNames;
    String[] locationDescriptions;
    private Integer imageid[] = {
            R.drawable.persian1,
            R.drawable.persian2,
            R.drawable.persian3,
            R.drawable.persian4,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persian_cuisine);

        String str_location[] = new String[]{"2015 Avenue Rd, North York, ON M5M 4A5", "420 College St, Toronto, ON M5T 1T3","995 Bay St, Toronto, ON M5S 3C4", "777 Queen St W, Toronto, ON M6J 1G1"};
        locationNames = getResources().getStringArray(R.array.locaionNamesPersian);
        locationDescriptions = getResources().getStringArray(R.array.locationDescritionsPersian);

        ListView listView=(ListView)findViewById(R.id.mainLView);

        // For populating list data
        listviewAdapter customCuisineList = new listviewAdapter(this, locationNames, locationDescriptions, imageid);
        listView.setAdapter(customCuisineList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"You Selected "+locationNames[position]+ " restaurant",Toast.LENGTH_SHORT).show();

                String map = "http://maps.google.co.in/maps?q=" + str_location[position];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(intent);

            }
        });
    }
}