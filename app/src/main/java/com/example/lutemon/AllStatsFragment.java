package com.example.lutemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class AllStatsFragment extends Fragment {

    private static RecyclerView recyclerViewKills, recyclerViewDeaths;

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
        View view = inflater.inflate(R.layout.fragment_all_stats, container, false);
        LinkedHashMap<Lutemon,Integer> kills = Stats.killStats();
        LinkedHashMap <Lutemon,Integer> deaths = Stats.deathStats();
        recyclerViewKills = view.findViewById(R.id.rvTopKills);
        recyclerViewKills.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewKills.setAdapter(new AllStatsViewAdapter(this.getContext(), kills));
        recyclerViewDeaths = view.findViewById(R.id.rvTopDeaths);
        recyclerViewDeaths.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewDeaths.setAdapter(new AllStatsViewAdapter(this.getContext(), deaths));
        return view;
    }
}