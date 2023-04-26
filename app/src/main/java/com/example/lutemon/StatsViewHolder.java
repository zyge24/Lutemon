package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StatsViewHolder extends RecyclerView.ViewHolder  {

    TextView name, attackstats, damagestats, kills, deaths, maxHit, training;
    ImageView picture, btnFullHealth, btnAttack, btnDefence, btnHealth;
    public StatsViewHolder(@NonNull View itemView) {
        super(itemView);
        picture = itemView.findViewById(R.id.ivLutemonPicture);
        name = itemView.findViewById(R.id.tvName);
        attackstats = itemView.findViewById(R.id.tvAttackStats);
        damagestats = itemView.findViewById(R.id.tvDamageStats);
        kills = itemView.findViewById(R.id.tvKills);
        deaths = itemView.findViewById(R.id.tvDeath);
        maxHit =itemView.findViewById(R.id.tvMaxHit);
        training =itemView.findViewById(R.id.tvTraining);

    }
}
