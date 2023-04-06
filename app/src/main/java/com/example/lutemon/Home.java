package com.example.lutemon;

import java.util.HashMap;

public class Home extends Storage{

    protected static HashMap<Integer,Lutemon> lutemonsAtHome = new HashMap<>();

    public Home() {
    }
    public static void createLutemon(Lutemon lutemon){
        lutemonsAtHome.put(Lutemon.getNumberOfCreatedLutemons(), lutemon);
        addLutemon(lutemon);

    }

}
