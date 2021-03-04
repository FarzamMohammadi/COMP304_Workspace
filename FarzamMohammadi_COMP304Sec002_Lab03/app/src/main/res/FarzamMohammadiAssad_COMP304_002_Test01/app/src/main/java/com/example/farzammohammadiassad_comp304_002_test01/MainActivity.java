package com.example.farzammohammadiassad_comp304_002_test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.Serializable;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    CheckBox mainActivityCheckBoxes[] = new CheckBox[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button Retrieval
        Button stockChartsBtn = (Button) findViewById(R.id.stockChartBtn);
        // CheckBox Retrieval
        CheckBox option1cBox = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox option2cBox = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox option3cBox = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox option4cBox = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox option5cBox = (CheckBox) findViewById(R.id.checkBox5);

        // Putting All CBoxes Into An Array
        mainActivityCheckBoxes[0] =  option1cBox;
        mainActivityCheckBoxes[1] =  option2cBox;
        mainActivityCheckBoxes[2] =  option3cBox;
        mainActivityCheckBoxes[3] =  option4cBox;
        mainActivityCheckBoxes[4] =  option5cBox;

        // String Retrieval From Resources
        String cBoxOption1 = getString(R.string.ibm);
        String cBoxOption2 = getString(R.string.microsoft);
        String cBoxOption3 = getString(R.string.google);
        String cBoxOption4 = getString(R.string.apple);
        String cBoxOption5 = getString(R.string.oracle);

        // Text Setting of All CheckBoxes
        option1cBox.setText(cBoxOption1);
        option2cBox.setText(cBoxOption2);
        option3cBox.setText(cBoxOption3);
        option4cBox.setText(cBoxOption4);
        option5cBox.setText(cBoxOption5);

        // Event List
        stockChartsBtn.setOnClickListener(new View.OnClickListener(){
            StringBuilder stringsToPass = new StringBuilder();
            @Override
            public void onClick(View v) {
                for (CheckBox cBox : mainActivityCheckBoxes) {
                    if (cBox.isChecked()){
                        stringsToPass.append(cBox.getText());
                    }
                }
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                secondActivityIntent.putExtra("stocksToShow", (Serializable) stringsToPass);
                startActivity(secondActivityIntent);

            }
        });

    }
}