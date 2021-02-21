package com.example.farzammohammadiassad_comp304lab01_ex02;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class VRActivity extends AppCompatActivity {
    StringBuilder hello = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_r);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onStart()
    {
        super.onStart();
        TextView bottomTextView = (TextView) findViewById(R.id.bottomTextView);        hello.append("\nIn the onStart() Executed");
        bottomTextView.setText(hello);
    }
    //

    public void onResume()
    {
        super.onResume();
        TextView bottomTextView = (TextView) findViewById(R.id.bottomTextView);        hello.append("\nIn the onResume() Executed");
        bottomTextView.setText(hello);
    }
    public void onPause()
    {
        super.onPause();
        TextView bottomTextView = (TextView) findViewById(R.id.bottomTextView);        hello.append("\nIn the onPause() Executed");
        bottomTextView.setText(hello);
    }

    public void onStop()
    {
        super.onStop();
        TextView bottomTextView = (TextView) findViewById(R.id.bottomTextView);        hello.append("\nIn the onStop() Executed");
        bottomTextView.setText(hello);
    }
    public void onDestroy()
    {
        super.onDestroy();
        TextView bottomTextView = (TextView) findViewById(R.id.bottomTextView);        hello.append("\nIn the onDestroy() Executed");
        bottomTextView.setText(hello);
    }
}