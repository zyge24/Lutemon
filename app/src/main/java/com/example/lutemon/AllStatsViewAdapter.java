package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AllStatsViewAdapter extends RecyclerView.Adapter<AllStatsViewHolder>  {
    private LinkedHashMap<Lutemon, Integer> stats = new LinkedHashMap<>();
    private Context context;
    private List<Lutemon> lutemons;

    public AllStatsViewAdapter(Context context, LinkedHashMap<Lutemon,Integer> stats) {
        this.context = context;
        this.stats =stats;
        lutemons = new ArrayList<Lutemon>(stats.keySet());
    }


    @NonNull
    @Override
    public AllStatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllStatsViewHolder(LayoutInflater.from(context).inflate(R.layout.stats_view_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AllStatsViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.name.setText(lutemon.getName());
        holder.stat.setText(String.valueOf(stats.get(lutemon)));

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
