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
import java.util.HashMap;
import java.util.List;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private HashMap<Integer, Lutemon> lutemons = new HashMap();
    private Storage storage = Storage.getInstance();
    private Home home = storage.getHome();
    private TrainingArea trainingArea = storage.getTrainingArea();
    private BattleField battleField = storage.getBattleField();

    List<Integer> ids;

    public LutemonListAdapter(Context context, HashMap<Integer,Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        ids = new ArrayList<Integer>(lutemons.keySet());
    }


    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view_list, parent, false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        int id = ids.get(position);
        System.out.println("positio:" + position + " id: " + id);
        holder.picture.setImageResource(lutemons.get(id).getPicture());
        holder.name.setText(lutemons.get(id).getName() + " (" + lutemons.get(id).getColor() + ")");
        holder.attack.setText("Hyökkäys: " + String.valueOf(lutemons.get(id).getAttack()));
        holder.defence.setText("Puolustus: " + String.valueOf(lutemons.get(id).getDefence()));
        holder.health.setText("Elämäpisteet: " + String.valueOf(lutemons.get(id).getHealth()) + "/" + String.valueOf(lutemons.get(id).getMaxHealt()));
        holder.experience.setText("Kokemus: " + String.valueOf(lutemons.get(id).getExperience()));
        holder.id.setText("id: " + String.valueOf(lutemons.get(id).getId()));

        if(home.isLutemonAtHome(id)){

            holder.btnHome.setBackgroundColor(Color.GREEN);
        }
        if(trainingArea.isLutemonAtTrainingArea(id)){

            holder.btnTraining.setBackgroundColor(Color.GREEN);
        }
        if(battleField.isLutemonAtBattleField(id)){

            holder.btnFight.setBackgroundColor(Color.GREEN);
        }

        holder.btnHome.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            storage.moveLutemon(id, storage.getLutemonLocation(id), home);
            holder.btnHome.setBackgroundColor(Color.GREEN);
            holder.btnFight.setBackgroundColor(Color.TRANSPARENT);
            holder.btnTraining.setBackgroundColor(Color.TRANSPARENT);
        });
        holder.btnTraining.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            storage.moveLutemon(id, storage.getLutemonLocation(id), trainingArea);
            holder.btnTraining.setBackgroundColor(Color.GREEN);
            holder.btnFight.setBackgroundColor(Color.TRANSPARENT);
            holder.btnHome.setBackgroundColor(Color.TRANSPARENT);
        });
        holder.btnFight.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            storage.moveLutemon(id, storage.getLutemonLocation(id), battleField);
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
