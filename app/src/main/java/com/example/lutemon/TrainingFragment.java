package com.example.lutemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingFragment extends Fragment {

    private Button btnTrain;
    private Spinner sLutemon;
    private TextView trainingEvent, trainingResult;

    private HashMap<Integer, Lutemon> lutemons;

    public TrainingFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TrainingFragment newInstance() {
        TrainingFragment fragment = new TrainingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_training, container, false);
        TrainingArea trainingArea =TrainingArea.getInstance();
        lutemons = trainingArea.getLutemonsAtTrainingArea();
        SpinnerAdapter adapter = new SpinnerAdapter(getContext(), lutemons);
        btnTrain = view.findViewById(R.id.btnTraining);
        trainingEvent = view.findViewById(R.id.tvTrainingEvents);
        trainingResult = view.findViewById(R.id.tvTrainingResult);
        sLutemon = view.findViewById(R.id.sTrainLutemon);
        sLutemon.setAdapter(adapter);

        btnTrain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Lutemon lutemon = (Lutemon) sLutemon.getSelectedItem();
                ArrayList<Integer> result = trainingArea.train(lutemon);
                trainingEvent.setText("Sait treenissä tuloksen: "+ result.get(0).toString() + " + "+ result.get(1).toString() + " = " + String.valueOf(result.get(0)+result.get(1)) +", kehittyäksesi sinun piti ylittää: "+result.get(2).toString()+ " + "+result.get(3).toString()+ " = " + String.valueOf(result.get(2)+result.get(3)));
                if(result.get(4) == 0){
                    trainingResult.setText("Ei tullu kehitystä tällä kertaa");
                } else{
                    trainingResult.setText("Onnistuit treeneissä! Sait yhden kokemuspisteen!");
                }

            }
        });

        return view;
    }

}