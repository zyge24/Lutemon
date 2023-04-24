package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeViewAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private HashMap<Integer,Lutemon> lutemons= new HashMap<>();
    private Context context;
    List<Integer> ids;


    public HomeViewAdapter(Context context, HashMap<Integer,Lutemon> lutemons){
        this.context =context;
        this.lutemons=lutemons;
        ids = new ArrayList<Integer>(lutemons.keySet());
    }
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view_home,parent,false));
    }
    public void onBindViewHolder(HomeViewHolder holder, int position){
        int id = ids.get(position);
        Home home = Storage.getInstance().getHome();
        holder.picture.setImageResource(lutemons.get(id).getPicture());
        holder.name.setText(lutemons.get(id).getName() + " (" + lutemons.get(id).getColor() + ")");
        holder.attack.setText("Hyökkäys: " + String.valueOf(lutemons.get(id).getAttack()));
        holder.defence.setText("Puolustus: " + String.valueOf(lutemons.get(id).getDefence()));
        holder.health.setText("Elämäpisteet: " + String.valueOf(lutemons.get(id).getHealth()) + "/" + String.valueOf(lutemons.get(id).getMaxHealt()));
        holder.experience.setText("Kokemus: " + String.valueOf(lutemons.get(id).getExperience()));

        holder.btnFullHealth.setOnClickListener(view -> {
            lutemons.get(id).setFullHealth();
            notifyDataSetChanged();
        });
        holder.btnAttack.setOnClickListener(view -> {
            home.useExperienceToAttack(lutemons.get(id));
            notifyDataSetChanged();
        });
        holder.btnDefence.setOnClickListener(view -> {
            home.useExperienceToDefence(lutemons.get(id));
            notifyDataSetChanged();

        });
        holder.btnHealth.setOnClickListener(view -> {
            home.useExperienceToHealth(lutemons.get(id));
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
