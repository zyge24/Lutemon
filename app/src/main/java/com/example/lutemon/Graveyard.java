package com.example.lutemon;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Graveyard extends Storage {
    protected HashMap<Integer, Lutemon> lutemonsAtGraveyard = new HashMap<>();

    private static Graveyard graveyard;

    private Graveyard() {
        super();
    }

    public static Graveyard getInstance() {
        if (graveyard == null) {
            graveyard = new Graveyard();
        }
        return graveyard;
    }
    @Override
    public void save(Context context) {
        try {
            ObjectOutputStream graveWriter = new ObjectOutputStream(context.openFileOutput("grave.data", Context.MODE_PRIVATE));
            graveWriter.writeObject(lutemonsAtGraveyard);
            graveWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedostoston tallentaminen ei onnistunut");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load(Context context) {
        try {
            ObjectInputStream graveReader = new ObjectInputStream(context.openFileInput("grave.data"));
            lutemonsAtGraveyard = (HashMap<Integer, Lutemon>) graveReader.readObject();
            graveReader.close();
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

    public boolean isLutemonAtGraveyard(Integer id) {
        return lutemonsAtGraveyard.containsKey(id);
    }

    public HashMap<Integer, Lutemon> getLutemonsAtGraveyard() {
        return lutemonsAtGraveyard;
    }

    public void add(Lutemon lutemon) {
        lutemonsAtGraveyard.put(lutemon.getId(), lutemon);
    }

    public void removeLutemon(Integer id) {
        lutemonsAtGraveyard.remove(id);
    }
}
