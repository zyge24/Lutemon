package com.example.lutemon;

import java.util.HashMap;

public class Home extends Storage{

    protected static HashMap<Integer,Lutemon> lutemonsAtHome = new HashMap<>();

    protected Integer experienceToDevelop = 2;

    public Home() {
    }
    public static void createLutemon(Lutemon lutemon){
        lutemonsAtHome.put(Lutemon.getNumberOfCreatedLutemons(), lutemon);
        addLutemon(lutemon);

    }

    public static boolean isLutemonAtHome(Integer id){
        return lutemonsAtHome.containsKey(id);
    }

    public static HashMap<Integer, Lutemon> getLutemonsAtHome() {
        return lutemonsAtHome;
    }

    public boolean useExperienceToHealth(Lutemon lutemon){
        if (lutemon.getExperience() >= experienceToDevelop){
            lutemon.setExperience((lutemon.getExperience()-2));
            lutemon.setMaxHealt(lutemon.getMaxHealt()+1);
            return true;
        }
        return false;
    }
    public boolean useExperienceToAttack(Lutemon lutemon){
        if (lutemon.getExperience() >= experienceToDevelop){
            lutemon.setExperience((lutemon.getExperience()-2));
            lutemon.setAttack(lutemon.getAttack()+1);
            return true;
        }
        return false;
    }
    public boolean useExperienceToDefence(Lutemon lutemon){
        if (lutemon.getExperience() >= experienceToDevelop){
            lutemon.setExperience((lutemon.getExperience()-2));
            lutemon.setDefence(lutemon.getDefence()+1);
            return true;
        }
        return false;
    }

}
