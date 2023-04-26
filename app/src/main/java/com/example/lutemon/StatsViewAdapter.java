package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatsViewAdapter extends RecyclerView.Adapter<StatsViewHolder> {

    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private Context context;
    List<Integer> ids;

    public StatsViewAdapter(Context context, HashMap<Integer, Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        ids = new ArrayList<Integer>(lutemons.keySet());
    }


    public StatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StatsViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view_stats, parent, false));
    }


    public void onBindViewHolder(StatsViewHolder holder, int position) {
        int id = ids.get(position);
        Home home = Home.getInstance();
        holder.picture.setImageResource(lutemons.get(id).getPicture());
        holder.name.setText(lutemons.get(id).getName() + " (" + lutemons.get(id).getColor() + ")");
        holder.attackstats.setText("Aiheutettu vahinko: " + String.valueOf(lutemons.get(id).getStats().getTotalDamageMade()));
        holder.damagestats.setText("Vastaanotettu vahinko: " + String.valueOf(lutemons.get(id).getStats().getTotalDamageReceived()));
        holder.kills.setText("Tapot: " + String.valueOf(lutemons.get(id).getStats().getKills()));
        holder.deaths.setText("Kuolemat: " + String.valueOf(lutemons.get(id).getStats().getDeaths()));
        holder.training.setText("Treenikertoja: " + String.valueOf(lutemons.get(id).getStats().getTraining()));
        holder.maxHit.setText("Maksimilyönti: " + String.valueOf(lutemons.get(id).getStats().getMaxHit()));
    }

    @Override
    public int getItemCount() {
        return ids.size();
    }
}
