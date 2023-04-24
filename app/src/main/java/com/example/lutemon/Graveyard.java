package com.example.lutemon;

import java.util.HashMap;

public class Graveyard  extends Storage {
    protected HashMap<Integer,Lutemon> lutemonsAtGraveyard= new HashMap<>();

    public Graveyard() {

    }

    public boolean isLutemonAtGraveyard(Integer id){
        return lutemonsAtGraveyard.containsKey(id);
    }
    public HashMap<Integer, Lutemon> getLutemonsAtGraveyard() {
        return lutemonsAtGraveyard;
    }

    public void add(Lutemon lutemon){
        lutemonsAtGraveyard.put(lutemon.getId(), lutemon);
    }
    public void removeLutemon(Integer id){
        lutemonsAtGraveyard.remove(id);
    }
}
