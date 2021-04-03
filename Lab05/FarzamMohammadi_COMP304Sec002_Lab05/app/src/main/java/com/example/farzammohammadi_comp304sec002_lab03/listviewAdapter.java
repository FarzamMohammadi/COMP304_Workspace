package com.example.farzammohammadi_comp304sec002_lab03;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class listviewAdapter extends ArrayAdapter {

    private String[] itemName;
    private String[] itemDescription;
    private Integer[] itemImage;
    private Activity context;

    public listviewAdapter(Activity context, String[] _itemName, String[] _itemDescription, Integer[] _itemImage) {
        super(context, R.layout.activity_listview, _itemName);
        this.context = context;
        this.itemName = _itemName;
        this.itemDescription = _itemDescription;
        this.itemImage = _itemImage;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.activity_listview, null, true);
        TextView textViewCountry = (TextView) row.findViewById(R.id.line_a);
        TextView textViewCapital = (TextView) row.findViewById(R.id.line_b);
        ImageView imageFlag = (ImageView) row.findViewById(R.id.line_c);

        textViewCountry.setText(itemName[position]);
        textViewCapital.setText(itemDescription[position]);
        imageFlag.setImageResource(itemImage[position]);
        return  row;
    }
}
