package com.example.farzammohammadiassad_comp304lab01_ex02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BottomFragment extends Fragment {
    StringBuilder hello = new StringBuilder();
    String tag = "Lifecycle";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_blank2, container, false);
        TextView bottomTextView = (TextView) rootView.findViewById(R.id.bottomTextView);
        hello.append("\nIn the onCreate() Executed");
        bottomTextView.setText(hello);
        return rootView;
    }

    public void onStart()
    {
        super.onStart();
        TextView bottomTextView = (TextView) getView().findViewById(R.id.bottomTextView);
        hello.append("\nIn the onStart() Executed");
        bottomTextView.setText(hello);
    }
    //

    public void onResume()
    {
        super.onResume();
        TextView bottomTextView = (TextView) getView().findViewById(R.id.bottomTextView);
        hello.append("\nIn the onResume() Executed");
        bottomTextView.setText(hello);
    }
    public void onPause()
    {
        super.onPause();
        TextView bottomTextView = (TextView) getView().findViewById(R.id.bottomTextView);
        hello.append("\nIn the onPause() Executed");
        bottomTextView.setText(hello);
    }

    public void onStop()
    {
        super.onStop();
        TextView bottomTextView = (TextView) getView().findViewById(R.id.bottomTextView);
        hello.append("\nIn the onStop() Executed");
        bottomTextView.setText(hello);
        hello = new StringBuilder();
    }
    public void onDestroy()
    {
        super.onDestroy();
        TextView bottomTextView = (TextView) getView().findViewById(R.id.bottomTextView);
        hello.append("\nIn the onDestroy() Executed");
        bottomTextView.setText(hello);
    }
}