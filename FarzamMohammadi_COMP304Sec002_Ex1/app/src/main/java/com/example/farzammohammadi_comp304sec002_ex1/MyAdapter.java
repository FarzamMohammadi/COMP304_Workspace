package com.example.farzammohammadi_comp304sec002_ex1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    SharedPreferences myPreference;
    StringBuilder locationsText = new StringBuilder ();
    StringBuilder PricesText = new StringBuilder ();
    public CheckBox cbSelect;
    String data1[], data2[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String location[],String price[], int img[]){
        context = ct;
        data1 = location;
        data2 = price;
        images = img;
        myPreference = context.getSharedPreferences("listOfHomes", Context.MODE_PRIVATE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SharedPreferences.Editor prefEditor = myPreference.edit();
        int counter =0;
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
        holder.button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                prefEditor.commit();
                    Log.e("I AM ", "Checkout Selected");
                Intent intent = new Intent(context, CheckOutActivity.class);
                context.startActivity(intent);
            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    locationsText.append(holder.myText1.getText().toString() + '-');
                    prefEditor.putString("HomeLocations", locationsText.toString());

                    PricesText.append(holder.myText2.getText().toString() + '-');
                    prefEditor.putString("HomePrices", PricesText.toString());


                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        Button button;
        TextView myText1, myText2;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.homeAddress);
            myText2 = itemView.findViewById(R.id.rentPrice);
            myImage = itemView.findViewById(R.id.homeImageView);
            checkBox = itemView.findViewById(R.id.toVisitCheckBox);
            button = itemView.findViewById(R.id.checkOutButton);

        }
    }
}
