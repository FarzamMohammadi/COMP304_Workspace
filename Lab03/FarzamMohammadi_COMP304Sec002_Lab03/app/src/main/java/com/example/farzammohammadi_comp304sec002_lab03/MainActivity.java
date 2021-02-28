package com.example.farzammohammadi_comp304sec002_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import Exercise01.FarzamMohammadi_COMP304Sec002_Lab03_Ex01;
import Exercise02.FarzamMohammadi_COMP304Sec002_Lab03_Ex02;
import Exercise03.FarzamMohammadi_COMP304Sec002_Lab03_Ex03;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView exerciseListView = findViewById(R.id.exerciseListView);
        //    Used for allowing the user to navigate to the other exercises in this application
        exerciseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // starts the exercise clicked on by user
                switch (adapterView.getItemAtPosition(i).toString()) {
                    case "Exercise 1":
                        Toast.makeText(MainActivity.this,  getResources().getString(R.string.ex1) + getResources().getString(R.string.main_menu_clicked_msg), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(view.getContext(), FarzamMohammadi_COMP304Sec002_Lab03_Ex01.class));
                        break;
                    case "Exercise 2":
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.ex2) + getResources().getString(R.string.main_menu_clicked_msg), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(view.getContext(), FarzamMohammadi_COMP304Sec002_Lab03_Ex02.class));
                        break;
                    case "Exercise 3":
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.ex3) + getResources().getString(R.string.main_menu_clicked_msg), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(view.getContext(), FarzamMohammadi_COMP304Sec002_Lab03_Ex03.class));
                        break;
                }
            }
        });
    }
}