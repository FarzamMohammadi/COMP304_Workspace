package com.example.farzammohammadi_comp304sec002_lab03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GreekCuisineActivity extends AppCompatActivity {

    String[] locationNames;
    String[] locationDescriptions;
    private Integer imageid[] = {
            R.drawable.greek1,
            R.drawable.greek2,
            R.drawable.greek3,
            R.drawable.greek4,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greek_cuisine);

        String str_location[] = new String[]{"456 Danforth Ave, Toronto, ON M4K 1P3", "643 Mt Pleasant Rd, Toronto, ON M4S 2M9","80 Ossington Ave, Toronto, ON M6J 2Y7", "3200 Dufferin Street#22, Toronto, ON M6A 3B2"};
        locationNames = getResources().getStringArray(R.array.locaionNamesGreek);
        locationDescriptions = getResources().getStringArray(R.array.locationDescritionsGreek);

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