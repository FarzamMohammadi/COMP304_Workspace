package com.example.farzammohammadi_comp304sec002_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    String[] cuisineNames;
    String[] cuisineDescriptions;
    private Integer imageid[] = {
            R.drawable.italian,
            R.drawable.greek,
            R.drawable.persian,
            R.drawable.chinese,
            R.drawable.indian,
            R.drawable.vegeterian,
            R.drawable.vegan

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuisineNames = getResources().getStringArray(R.array.cuisineNames);
        cuisineDescriptions = getResources().getStringArray(R.array.cuisineDescriptions);

        ListView listView=(ListView)findViewById(R.id.mainLView);

        // For populating list data
        listviewAdapter customCuisineList = new listviewAdapter(this, cuisineNames, cuisineDescriptions, imageid);
        listView.setAdapter(customCuisineList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"You Selected "+cuisineNames[position]+ " cuisine",Toast.LENGTH_SHORT).show();

                Intent intent;
                switch(position) {
                    case 0:
                        intent = new Intent(MainActivity.this, ItalianCuisineActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, GreekCuisineActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, PersianCuisineActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, ItalianCuisineActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, GreekCuisineActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, PersianCuisineActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, PersianCuisineActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}