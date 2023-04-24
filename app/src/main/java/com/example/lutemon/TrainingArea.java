package com.example.lutemon;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainingArea  extends Storage {

    protected HashMap<Integer, Lutemon> lutemonsAtTrainingArea = new HashMap<>();
    ;

    public TrainingArea() {

    }

    public ArrayList<Integer> train(Lutemon lutemon) {
        lutemon.stats.addTraining();
        Integer dice1 = (int) (Math.random() * 6) + 1;
        Integer dice2 = (int) (Math.random() * 6) + 1;
        Integer trainerDice1 = (int) (Math.random() * 6) + 1;
        Integer trainerDice2 = (int) (Math.random() * 6) + 1;
        Integer success = 0;
        if ((trainerDice2 + trainerDice1) > (dice1 + dice2)) {
            lutemon.setExperience((lutemon.getExperience() + 1));
            success = 1;
        }
        ArrayList<Integer> dices = new ArrayList<>();
        dices.add(dice1);
        dices.add(dice2);
        dices.add(trainerDice1);
        dices.add(trainerDice2);
        dices.add(success);
        return dices;
    }

    public boolean isLutemonAtTrainingArea(Integer id) {
        return lutemonsAtTrainingArea.containsKey(id);
    }

    public HashMap<Integer, Lutemon> getLutemonsAtTrainingArea() {
        return lutemonsAtTrainingArea;
    }

    public void addToTrainingArea(Lutemon lutemon) {
        lutemonsAtTrainingArea.put(lutemon.getId(), lutemon);
    }

    public void add(Lutemon lutemon) {
        lutemonsAtTrainingArea.put(lutemon.getId(), lutemon);
    }

    public void removeLutemon(Integer id) {
        lutemonsAtTrainingArea.remove(id);
    }
}
