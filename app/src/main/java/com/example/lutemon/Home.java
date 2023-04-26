package com.example.lutemon;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Home  extends Storage {

    private static Home home;

    protected HashMap<Integer,Lutemon> lutemonsAtHome  = new HashMap<>();;

    protected static Integer experienceToDevelop = 2;

    private Home() {
        super();
    }

    public static Home getInstance() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }

    @Override
    public void add(Lutemon lutemon) {
        lutemonsAtHome.put(lutemon.getId(), lutemon);
    }


    public boolean isLutemonAtHome(Integer id){
        return lutemonsAtHome.containsKey(id);
    }

    public HashMap<Integer, Lutemon> getLutemonsAtHome() {
        return lutemonsAtHome;
    }

    public void removeLutemon(Integer id){
        lutemonsAtHome.remove(id);
    }

    @Override
    public void save(Context context) {
        try {
            ObjectOutputStream homeWriter = new ObjectOutputStream(context.openFileOutput("home.data", Context.MODE_PRIVATE));
            homeWriter.writeObject(lutemonsAtHome);
            homeWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedostoston tallentaminen ei onnistunut");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load(Context context) {
        try {
            ObjectInputStream homeReader = new ObjectInputStream(context.openFileInput("home.data"));
            lutemonsAtHome = (HashMap<Integer, Lutemon>) homeReader.readObject();
            homeReader.close();
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
