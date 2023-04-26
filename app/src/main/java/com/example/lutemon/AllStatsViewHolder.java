package com.example.lutemon;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllStatsViewHolder extends RecyclerView.ViewHolder {

    TextView name, stat;

    public AllStatsViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tvAllStatsLutemonName);
        stat = itemView.findViewById(R.id.tvStats);
    }
}
