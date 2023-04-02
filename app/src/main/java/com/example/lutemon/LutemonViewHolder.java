package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    TextView name, attack, defence, health, experience;
    ImageView picture;

    public LutemonViewHolder(View itemView) {
        super(itemView);
        picture = itemView.findViewById(R.id.ivLutemonPicture);
        name = itemView.findViewById(R.id.tvName);
        attack = itemView.findViewById(R.id.tvAttack);
        defence = itemView.findViewById(R.id.tvDefence);
        health = itemView.findViewById(R.id.tvHealth);
        experience = itemView.findViewById(R.id.tvExperience);

    }
}
