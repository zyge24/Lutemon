package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class List_Lutemons extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;
    private static HashMap<Integer,Lutemon> lutemons;
    private static ArrayList<Lutemon> lutemonsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        storage = Storage.getInstance();
        lutemons = storage.getAliveLutemons();
        lutemonsArray = new ArrayList<>(lutemons.values());

        recyclerView = findViewById(R.id.rvLutemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), lutemons));
    }
}