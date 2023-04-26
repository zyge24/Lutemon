package com.example.lutemon;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

/**

 */
public class BattleFieldFragment extends Fragment {

    private Spinner sFighter1, sFighter2;

    private TextView tvResult;
    private Button btnFight;

    private HashMap<Integer, Lutemon> lutemons;

    public BattleFieldFragment() {
        // Required empty public constructor
    }


    public static BattleFieldFragment newInstance() {
        BattleFieldFragment fragment = new BattleFieldFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle_field, container, false);
        BattleField battleField = BattleField.getInstance();
        lutemons = battleField.getLutemonsAtBattleField();
        SpinnerAdapter adapter = new SpinnerAdapter(getContext(), lutemons);
        tvResult = view.findViewById(R.id.tvFightResult);
        btnFight = view.findViewById(R.id.btnFight);
        sFighter1 = view.findViewById(R.id.sFighter1);
        sFighter1.setAdapter(adapter);
        sFighter2 = view.findViewById(R.id.sFighter2);
        sFighter2.setAdapter(adapter);

        btnFight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Lutemon lutemon1 = (Lutemon) sFighter1.getSelectedItem();
                Lutemon lutemon2 = (Lutemon) sFighter2.getSelectedItem();
                if (lutemon1 == lutemon2) {
                    tvResult.setText("Valitse uudelleen, lutemon ei voi taistella itseään vastaan");
                } else {
                    ArrayList<String> battleEvents = BattleField.fight(lutemon1, lutemon2);
                    Handler handler = new Handler();
                    Runnable runnable = new Runnable() {
                        int currentIndex = 0;
                        @Override
                        public void run() {
                            if(currentIndex<battleEvents.size()){
                            tvResult.setText(battleEvents.get(currentIndex));
                            currentIndex++;
                            handler.postDelayed(this, 2000);}
                            else {
                            }
                        }
                    };
                    handler.post(runnable);
                    SpinnerAdapter adapterUpdate1 = (SpinnerAdapter) sFighter1.getAdapter();
                    SpinnerAdapter adapterUpdate2 = (SpinnerAdapter) sFighter2.getAdapter();
                    lutemons = battleField.getLutemonsAtBattleField();
                    adapterUpdate1.setLutemons(lutemons);
                    adapterUpdate2.setLutemons(lutemons);
                    adapterUpdate1.notifyDataSetChanged();
                    adapterUpdate2.notifyDataSetChanged();

                }
            }
        });
        return view;
    }
}