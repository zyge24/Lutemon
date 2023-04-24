package com.example.lutemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;


public class LutemonStatsFragment extends Fragment {

    private static RecyclerView recyclerView;
    private static HashMap<Integer,Lutemon> lutemons;
    public LutemonStatsFragment() {
        // Required empty public constructor
    }


    public static LutemonStatsFragment newInstance(String param1, String param2) {
        return new LutemonStatsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lutemon_stats, container, false);
        lutemons = Storage.getInstance().getLutemons();
        recyclerView = view.findViewById(R.id.rvLutemonStats);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new StatsViewAdapter(this.getContext(), lutemons));
        return view;
    }
}