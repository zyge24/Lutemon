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

    //tämä jäi kesken tarvitaan uuden lutemonin lisäämiseksi
    public static void addLutemon(Lutemon lutemon){
        lutemons.entrySet(0, lutemon);
    }
}
