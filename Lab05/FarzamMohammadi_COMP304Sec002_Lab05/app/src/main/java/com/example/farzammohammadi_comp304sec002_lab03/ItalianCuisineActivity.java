package com.example.farzammohammadi_comp304sec002_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ItalianCuisineActivity extends AppCompatActivity {

    String[] locationNames;
    String[] locationDescriptions;
    private Integer imageid[] = {
            R.drawable.italian1,
            R.drawable.italian2,
            R.drawable.italian3,
            R.drawable.italian4,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_cuisine);

        String str_location[] = new String[]{"720 Queen St W, Toronto, ON M6J 1E8" ,"120 Avenue Rd, Toronto, ON M5R 2H4", "1288 Dundas St W, Toronto, ON M6J 1X7" ,"147 Spadina Ave., Toronto, ON M5V 2L7"};
        locationNames = getResources().getStringArray(R.array.locaionNames);
        locationDescriptions = getResources().getStringArray(R.array.locationDescritions);

        ListView listView=(ListView)findViewById(R.id.italianLView);

        // For populating list data
        listviewAdapter customCuisineList = new listviewAdapter(this, locationNames, locationDescriptions, imageid);
        listView.setAdapter(customCuisineList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"You Selected "+locationNames[position]+ " Cuisine",Toast.LENGTH_SHORT).show();

                String map = "http://maps.google.co.in/maps?q=" + str_location[position];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(intent);

            }
        });
    }
}