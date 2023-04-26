package com.example.lutemon;


import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Storage {
  //  protected static HashMap<Integer,Lutemon> lutemons = new HashMap<>();

    private static Storage storage;
    private static TrainingArea trainingArea= TrainingArea.getInstance();
    private static BattleField battleField= BattleField.getInstance();
    private static Graveyard graveyard= Graveyard.getInstance();
    private static Home home= Home.getInstance();

    protected Storage() {

    }


    public static void moveLutemon(Integer id, Storage from, Storage to){
        if(from != to){
        Lutemon lutemon = getLutemonById(id);
        to.add(lutemon);
        from.removeLutemon(id);}
    }

    public static Storage getLutemonLocation(Integer id){
        Storage lutemons = null;
        if (home.isLutemonAtHome(id)){
            lutemons = home;
        }
        if (trainingArea.isLutemonAtTrainingArea(id)){
            lutemons = trainingArea;
        }
        if (battleField.isLutemonAtBattleField(id)){
            lutemons = battleField;
        }
        if (graveyard.isLutemonAtGraveyard(id)){
            lutemons= graveyard;
        }
        return lutemons;
    }
    public static Lutemon getLutemonById(Integer id){
        HashMap<Integer, Lutemon> all = new HashMap<>();
        all.putAll(graveyard.getLutemonsAtGraveyard());
        all.putAll(home.getLutemonsAtHome());
        all.putAll(trainingArea.getLutemonsAtTrainingArea());
        all.putAll(battleField.getLutemonsAtBattleField());
        Lutemon lutemon = all.get(id);
        return lutemon;
    }

    public abstract void add(Lutemon lutemon);
    public abstract void removeLutemon(Integer id);

    public static HashMap<Integer,Lutemon> getAliveLutemons(){
        HashMap<Integer, Lutemon> result = new HashMap<>();
        result.putAll(home.getLutemonsAtHome());
        result.putAll(trainingArea.getLutemonsAtTrainingArea());
        result.putAll(battleField.getLutemonsAtBattleField());
        return result;
    }
    public static HashMap<Integer,Lutemon> getAllLutemons(){
        HashMap<Integer, Lutemon> result = new HashMap<>();
        result.putAll(graveyard.getLutemonsAtGraveyard());
        result.putAll(home.getLutemonsAtHome());
        result.putAll(trainingArea.getLutemonsAtTrainingArea());
        result.putAll(battleField.getLutemonsAtBattleField());
        return result;
    }

    public abstract void save(Context context);
    public abstract void load(Context context);


}
