package com.example.lutemon;

import androidx.annotation.NonNull;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Stats {

    public Stats() {
    }

    public static LinkedHashMap<Lutemon,Integer> killStats(){
        LinkedHashMap<Lutemon,Integer> kills = new LinkedHashMap<>();
        HashMap<Integer, Lutemon> all = Storage.getAllLutemons();
        int i = 0;
        for (Lutemon lutemon:all.values()) {
            kills.put(lutemon,lutemon.stats.getKills());
        }
        LinkedHashMap<Lutemon, Integer> result = sortLinkedHashMap(kills);
        return result;
    }
    public static LinkedHashMap<Lutemon,Integer> deathStats(){
        LinkedHashMap<Lutemon,Integer> deaths = new LinkedHashMap<>();
        HashMap<Integer, Lutemon> all = Storage.getAllLutemons();
        for (Lutemon lutemon:all.values()) {
            deaths.put(lutemon,lutemon.stats.getDeaths());
        }
        LinkedHashMap<Lutemon, Integer> result = sortLinkedHashMap(deaths);
        return result;
    }
    @NonNull
    private static LinkedHashMap<Lutemon, Integer> sortLinkedHashMap(LinkedHashMap<Lutemon, Integer> list) {
        List<Map.Entry<Lutemon, Integer>> midresult = new ArrayList<>(list.entrySet());
        Collections.sort(midresult, valueComparator);
        Collections.reverse(midresult);
        LinkedHashMap<Lutemon,Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Lutemon, Integer> lutemon : midresult) {
            result.put(lutemon.getKey(), lutemon.getValue());
        }
        return result;
    }

    static Comparator<Map.Entry<Lutemon, Integer>> valueComparator = new Comparator<Map.Entry<Lutemon, Integer>>() {
        @Override
        public int compare(Map.Entry<Lutemon, Integer> e1, Map.Entry<Lutemon, Integer> e2) {
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            return v1.compareTo(v2);
        }
    
};}
