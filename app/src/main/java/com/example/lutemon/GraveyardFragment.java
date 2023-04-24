package com.example.lutemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraveyardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraveyardFragment extends Fragment {

    private Graveyard graveyard;
    private static RecyclerView recyclerView;
    private static HashMap<Integer,Lutemon> lutemons;
    public GraveyardFragment() {
        // Required empty public constructor
    }

    public static GraveyardFragment newInstance() {
        return new GraveyardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graveyard, container, false);
        graveyard = Storage.getInstance().getGraveyard();
        lutemons = graveyard.getLutemonsAtGraveyard();
        recyclerView = view.findViewById(R.id.rvGraveyard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new GraveyardViewAdapter(this.getContext(), lutemons));
        return view;
    }
}