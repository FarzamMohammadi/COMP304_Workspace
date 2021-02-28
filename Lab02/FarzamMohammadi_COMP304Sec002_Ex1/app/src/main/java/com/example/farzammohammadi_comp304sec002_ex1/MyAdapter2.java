package com.example.farzammohammadi_comp304sec002_ex1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder>{

    //Instanciate Global Variables
    SharedPreferences myPreference;
    String data1[], data2[];
    Context context;
    private RadioButton lastCheckedRB = null;

    //Adapter Constructor
    public MyAdapter2(Context ct, String location[], String price[]){
        context = ct;
        data1 = location;
        data2 = price;
        myPreference = context.getSharedPreferences("paymentPrice", Context.MODE_PRIVATE);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.my_row2, parent, false);
            return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SharedPreferences.Editor prefEditor = myPreference.edit();

        //Prevent multiple Radio Selection
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked_rb = (RadioButton) group.findViewById(checkedId);
                checked_rb.setChecked(true);
                if (lastCheckedRB != null) {
                    lastCheckedRB.setChecked(false);

                }
                //store the clicked radiobutton
                lastCheckedRB = checked_rb;
            }
        });

        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);

        //Adds desired price to Preference and pass it
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((RadioButton) view).isChecked()) {
                    holder.button.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View view) {
                            prefEditor.putString("paymentPrice",  holder.myText2.getText().toString());
                            prefEditor.commit();
                            Intent intent = new Intent(context, PaymentActivity.class);
                            context.startActivity(intent);
                        }
                    });
                }
            }
        });


    }
    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        Button button;
        RadioButton radioButton;
        RadioGroup radioGroup;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.homeAddress);
            myText2 = itemView.findViewById(R.id.rentPrice);
            button = itemView.findViewById(R.id.paymentButton);
            radioButton = itemView.findViewById(R.id.radioButton);
            radioGroup = itemView.findViewById(R.id.radioGroup);
        }
    }
}
