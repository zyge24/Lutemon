package com.example.lutemon;

import java.util.HashMap;

public class Home  extends Storage {

    protected HashMap<Integer,Lutemon> lutemonsAtHome  = new HashMap<>();;

    protected static Integer experienceToDevelop = 2;

    public Home() {
    }



    public void createLutemon(Lutemon lutemon){
        lutemonsAtHome.put(lutemon.getId(), lutemon);
        Storage.getInstance().addLutemon(lutemon);

    }

    public boolean isLutemonAtHome(Integer id){
        return lutemonsAtHome.containsKey(id);
    }

    public HashMap<Integer, Lutemon> getLutemonsAtHome() {
        return lutemonsAtHome;
    }

    public void addLutemon (Lutemon lutemon){
        lutemonsAtHome.put(lutemon.getId(), lutemon);
    }
    public void removeLutemon(Integer id){
        lutemonsAtHome.remove(id);
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
