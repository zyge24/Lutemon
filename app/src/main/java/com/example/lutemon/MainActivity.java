package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

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
        Intent intent = new Intent(this, BattleArena.class);
        startActivity(intent);
    }
    public void switchToLutemonList(View view) {
        Intent intent = new Intent(this, List_Lutemons.class);
        startActivity(intent);
    }


  public void switchToMoveLutemons(View view) {
        Intent intent = new Intent(this, MoveLutemon.class);
        startActivity(intent);
    }
}