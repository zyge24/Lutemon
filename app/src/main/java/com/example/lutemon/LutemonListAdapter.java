package com.example.lutemon;

import static android.R.color.holo_green_light;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }


    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view_list, parent, false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.picture.setImageResource(lutemons.get(position).getPicture());
        holder.name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.attack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.defence.setText("Puolustus: " + String.valueOf(lutemons.get(position).getDefence()));
        holder.health.setText("Elämäpisteet: " + String.valueOf(lutemons.get(position).getHealth()) + "/" + String.valueOf(lutemons.get(position).getMaxHealt()));
        holder.experience.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));

        if(Home.isLutemonAtHome(lutemons.get(position).getId())){
            holder.btnHome.setBackgroundColor(Color.GREEN);
        }
        if(TrainingArea.isLutemonAtTrainingArea(lutemons.get(position).getId())){
            holder.btnTraining.setBackgroundColor(Color.GREEN);
        }
        if(BattleField.isLutemonAtBattleField(lutemons.get(position).getId())){
            holder.btnFight.setBackgroundColor(Color.GREEN);
        }

        holder.btnHome.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            System.out.println(position);
            System.out.println(pos);
            Storage.moveLutemon(lutemons.get(pos).getId(), Storage.getLutemonLocation(lutemons.get(pos).getId()), Home.getLutemonsAtHome());
            holder.btnHome.setBackgroundColor(Color.GREEN);
            holder.btnFight.setBackgroundColor(Color.TRANSPARENT);
            holder.btnTraining.setBackgroundColor(Color.TRANSPARENT);
        });
        holder.btnTraining.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.moveLutemon(lutemons.get(pos).getId(), Storage.getLutemonLocation(lutemons.get(pos).getId()), TrainingArea.getLutemonsAtTrainingArea());
            holder.btnTraining.setBackgroundColor(Color.GREEN);
            holder.btnFight.setBackgroundColor(Color.TRANSPARENT);
            holder.btnHome.setBackgroundColor(Color.TRANSPARENT);
        });
        holder.btnFight.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.moveLutemon(lutemons.get(pos).getId(), Storage.getLutemonLocation(lutemons.get(pos).getId()), BattleField.getLutemonsAtBattleField());
            holder.btnFight.setBackgroundColor(Color.GREEN);
            holder.btnHome.setBackgroundColor(Color.TRANSPARENT);
            holder.btnTraining.setBackgroundColor(Color.TRANSPARENT);
        });
    }





    @Override
    public int getItemCount() {
        return lutemons.size();
    }


}
