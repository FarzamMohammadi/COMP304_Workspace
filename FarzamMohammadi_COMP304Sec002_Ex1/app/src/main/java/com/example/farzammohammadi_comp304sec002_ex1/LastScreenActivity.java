package com.example.farzammohammadi_comp304sec002_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LastScreenActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText name, email, cardNumber, age, phoneNumber;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);
        //Retrieve TextBox objects
        name=(EditText)findViewById(R.id.txtName);
        email=(EditText)findViewById(R.id.txtEmail);
        cardNumber=(EditText)findViewById(R.id.txtCardNumber);
        age=(EditText)findViewById(R.id.txtAge);
        phoneNumber=(EditText)findViewById(R.id.txtPhone);
        btnSubmit = (Button)findViewById(R.id.submitInfoButton);
        //On Submit Click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || cardNumber.getText().toString().isEmpty() || age.getText().toString().isEmpty()
                        || phoneNumber.getText().toString().isEmpty()) {
                    Toast.makeText(LastScreenActivity.this, "Please Fill All the Details", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LastScreenActivity.this, ("Name -  " + name.getText().toString() + " \n" + "Email -  " + email.getText().toString()
                            + " \n" + "E-Mail -  " + cardNumber.getText().toString() + " \n" + "DOB -  " + age.getText().toString()
                            + " \n" + "Contact -  " + phoneNumber.getText().toString()), Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}