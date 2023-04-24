package com.example.lutemon;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    protected static HashMap<Integer,Lutemon> lutemons = new HashMap<>();

    private static Storage storage;
    private static TrainingArea trainingArea= new TrainingArea();
    private static BattleField battleField= new BattleField();
    private static Home home= new Home();
    private static Graveyard graveyard= new Graveyard();
    protected Storage() {

    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public TrainingArea getTrainingArea() {
        return trainingArea;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public Home getHome() {
        return home;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }

    public void addLutemon(Lutemon lutemon){
        lutemons.put(lutemon.getId(), lutemon);
    }

    public HashMap<Integer, Lutemon> getLutemons() {
        return lutemons;
    }

    public void moveLutemon(Integer id, Storage from, Storage to){
        if(from != to){
        Lutemon lutemon = lutemons.get(id);
        to.add(lutemon);
        from.removeLutemon(id);}
    }

    public Storage getLutemonLocation(Integer id){
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

    public void add(Lutemon lutemon){
        lutemons.put(lutemon.getId(), lutemon);
    }
    public void removeLutemon(Integer id){
        lutemons.remove(id);
    }

    public HashMap<Integer,Lutemon> getAliveLutemons(){
        List<Integer> dead = new ArrayList<Integer>(graveyard.getLutemonsAtGraveyard().keySet());
        HashMap<Integer,Lutemon> result = new HashMap<>();
        for (Map.Entry<Integer,Lutemon> all : lutemons.entrySet()){
            if (!dead.contains(all.getKey())) {
                result.put(all.getKey(),all.getValue());
            }
        }
        return result;
    }
}
