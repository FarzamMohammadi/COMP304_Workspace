package com.example.farzammohammadiassad_comp304lab01_ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "onCreate() Executed For Fragments", Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "onStart() Executed For Fragments", Toast.LENGTH_SHORT).show();
    }

    public void displayToast(View v){

    }
}