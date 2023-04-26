package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraveyardViewAdapter extends RecyclerView.Adapter<GraveyardViewHolder> {
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private Context context;
    List<Integer> ids;

    private TrainingArea trainingArea = TrainingArea.getInstance();
    private BattleField battleField = BattleField.getInstance();
    private Home home = Home.getInstance();
    private Graveyard graveyard = Graveyard.getInstance();


    public GraveyardViewAdapter(Context context, HashMap<Integer, Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        ids = new ArrayList<Integer>(lutemons.keySet());

    }

    public GraveyardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GraveyardViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view_graveyard, parent, false));
    }

    public void onBindViewHolder(GraveyardViewHolder holder, int position) {
        int id = ids.get(position);
        holder.picture.setImageResource(lutemons.get(id).getPicture());
        holder.name.setText(lutemons.get(id).getName() + " (" + lutemons.get(id).getColor() + ")");
        holder.attack.setText("Hyökkäys: " + String.valueOf(lutemons.get(id).getAttack()));
        holder.defence.setText("Puolustus: " + String.valueOf(lutemons.get(id).getDefence()));
        holder.health.setText("Elämäpisteet: " + String.valueOf(lutemons.get(id).getHealth()) + "/" + String.valueOf(lutemons.get(id).getMaxHealt()));
        holder.experience.setText("Kokemus: " + String.valueOf(lutemons.get(id).getExperience()));

        holder.btnWakeup.setOnClickListener(view -> {
            lutemons.get(id).setFullHealth();
            Storage.moveLutemon(id, graveyard, home);

        });
    }

    @Override
    public int getItemCount() {
        return ids.size();
    }
}