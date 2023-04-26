package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddNewLutemon.class);
        startActivity(intent);
    }
    public void switchToBattleArena(View view) {
        Intent intent = new Intent(this, ActionCenter.class);
        startActivity(intent);
    }
    public void switchToLutemonList(View view) {
        Intent intent = new Intent(this, List_Lutemons.class);
        startActivity(intent);
    }
    public void switchToStats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

    public void saveLutemons(View view){
        Context context = getApplicationContext();
        Home.getInstance().save(context);
        Graveyard.getInstance().save(context);
        BattleField.getInstance().save(context);
        TrainingArea.getInstance().save(context);
        Lutemon.save(context);


    }

    public void loadLutemons(View view){
        Context context = getApplicationContext();
        Home.getInstance().load(context);
        Graveyard.getInstance().load(context);
        BattleField.getInstance().load(context);
        TrainingArea.getInstance().load(context);
        Lutemon.load(context);

    }


}