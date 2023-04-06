package com.example.lutemon;


import java.util.HashMap;

public class Storage {
    protected String name;
    protected static HashMap<Integer,Lutemon> lutemons = new HashMap<>();

    private static Storage storage = null;

    protected Storage() {
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }


    public static void addLutemon(Lutemon lutemon){
        lutemons.put(Lutemon.getNumberOfCreatedLutemons(), lutemon);
    }

    public static HashMap<Integer, Lutemon> getLutemons() {
        return lutemons;
    }

    public static void moveLutemon(Integer id, HashMap<Integer, Lutemon> from, HashMap<Integer, Lutemon> to){
        Lutemon lutemon = from.get(id);
        to.put(id,lutemon);
        from.remove(id);
    }
}
