package com.example.farzammohammadi_comp304sec002_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        //Retrieve Price of desired home
        SharedPreferences myPref = getSharedPreferences("paymentPrice", MODE_PRIVATE);
        String priceOfSelectedHome = myPref.getString("paymentPrice","");

        //Retrieve button objects
        RadioButton cashRadio = (RadioButton) findViewById(R.id.radioButtonCash);
        RadioButton creditRadio = (RadioButton) findViewById(R.id.radioButtonCredit);
        RadioButton debitRadio = (RadioButton) findViewById(R.id.radioButtonDebit);
        Button proceedButton = (Button) findViewById(R.id.buttonProceed);
        Intent intent1 = new Intent(PaymentActivity.this, LastScreenActivity.class);


        //Call next method beased on what payment method user picks
        proceedButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (cashRadio.isChecked()) {
                    Toast.makeText(PaymentActivity.this, "Price To Be Charged: " +priceOfSelectedHome + "\nMethod of Payment: Cash", Toast.LENGTH_LONG ).show();
                    startActivity(intent1);
                } else if (creditRadio.isChecked()) {
                    Toast.makeText(PaymentActivity.this, "Price To Be Charged: " +priceOfSelectedHome + "\nMethod of Payment: Credit", Toast.LENGTH_LONG ).show();
                    startActivity(intent1);
                } else if (debitRadio.isChecked()) {
                    Toast.makeText(PaymentActivity.this, "Price To Be Charged: " +priceOfSelectedHome + "\nMethod of Payment: Debit", Toast.LENGTH_LONG ).show();
                    startActivity(intent1);
                }
            }
            });
    }
}