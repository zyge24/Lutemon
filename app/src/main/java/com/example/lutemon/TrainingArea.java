package com.example.lutemon;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class TrainingArea  extends Storage {

    private static TrainingArea trainingArea;
    protected HashMap<Integer, Lutemon> lutemonsAtTrainingArea = new HashMap<>();


    private TrainingArea() {
        super();
    }

    public static TrainingArea getInstance() {
        if (trainingArea == null) {
            trainingArea = new TrainingArea();
        }
        return trainingArea;
    }
    @Override
    public void save(Context context) {
        try {
            ObjectOutputStream trainingWriter = new ObjectOutputStream(context.openFileOutput("training.data", Context.MODE_PRIVATE));
            trainingWriter.writeObject(lutemonsAtTrainingArea);
            trainingWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedostoston tallentaminen ei onnistunut");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load(Context context) {
        try {
            ObjectInputStream trainingReader = new ObjectInputStream(context.openFileInput("training.data"));
            lutemonsAtTrainingArea = (HashMap<Integer, Lutemon>) trainingReader.readObject();
            trainingReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoston lukeminen ei onnistunut");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Tiedostoston lukeminen ei onnistunut");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Tiedostoston lukeminen ei onnistunut");
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Integer> train(Lutemon lutemon) {
        lutemon.stats.addTraining();
        Integer dice1 = (int) (Math.random() * 6) + 1;
        Integer dice2 = (int) (Math.random() * 6) + 1;
        Integer trainerDice1 = (int) (Math.random() * 6) + 1;
        Integer trainerDice2 = (int) (Math.random() * 6) + 1;
        Integer success = 0;
        if ((trainerDice2 + trainerDice1) < (dice1 + dice2)) {
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
