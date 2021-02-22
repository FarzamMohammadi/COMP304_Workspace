package com.example.farzammohammadi_comp304sec002_ex1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeTypesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeTypesFragment extends Fragment {


    private ListView homeListView;
    private ArrayAdapter aAdapter;
    private String[] homeTypes = {"Apartment", "Detached Home", "Semi-Detached Home", "Condominium", "Town House"};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeTypesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeTypesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeTypesFragment newInstance(String param1, String param2) {
        HomeTypesFragment fragment = new HomeTypesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_types, container, false);
        //ListView
        homeListView = (ListView) view.findViewById(R.id.homeTypesListView);
        aAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, homeTypes);
        homeListView.setAdapter(aAdapter);
        homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override//Menu
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub

                String type = homeTypes[position];
                Log.d("STATE", type);
                if (type == "Apartment"){
                    Intent intent = new Intent(getActivity(), ApartmentHome.class);
                    startActivity(intent);
                }
                if (type == "Detached Home"){
                    Intent intent = new Intent(getActivity(), DetachedHome.class);
                    startActivity(intent);
                }
                if (type == "Semi-Detached Home"){
                    Intent intent = new Intent(getActivity(), SemiDetached.class);
                    startActivity(intent);
                }
                if (type == "Condominium"){
                    Intent intent = new Intent(getActivity(), Condominium.class);
                    startActivity(intent);
                }
                if (type == "Town House"){
                    Intent intent = new Intent(getActivity(), TownHouse.class);
                    startActivity(intent);
                }


            }
        });

        return view;
    }


}