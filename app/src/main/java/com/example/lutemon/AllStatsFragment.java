package com.example.lutemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AllStatsFragment extends Fragment {



    public AllStatsFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static AllStatsFragment newInstance() {
        AllStatsFragment fragment = new AllStatsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lutemon_stats, container, false);
        return view;
    }
}