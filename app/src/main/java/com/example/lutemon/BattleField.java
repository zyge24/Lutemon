package com.example.lutemon;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class BattleField extends Storage {

    protected HashMap<Integer, Lutemon> lutemonsAtBattleField = new HashMap<>();
    private static BattleField battleField;


    private BattleField() {
        super();
    }

    public static BattleField getInstance() {
        if (battleField == null) {
            battleField = new BattleField();
        }
        return battleField;
    }

    @Override
    public void save(Context context) {
        try {
            ObjectOutputStream battleWriter = new ObjectOutputStream(context.openFileOutput("battle.data", Context.MODE_PRIVATE));
            battleWriter.writeObject(lutemonsAtBattleField);
            battleWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedostoston tallentaminen ei onnistunut");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load(Context context) {
        try {
            ObjectInputStream battleReader = new ObjectInputStream(context.openFileInput("battle.data"));
            lutemonsAtBattleField = (HashMap<Integer, Lutemon>) battleReader.readObject();
            battleReader.close();
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

    public static ArrayList<String> fight(Lutemon a, Lutemon b) {
        ArrayList<String> battleEvents = new ArrayList<>();
        BattleField battleField = BattleField.getInstance();
        Graveyard graveyard = Graveyard.getInstance();
        battleEvents.add(a.getName() + " vs. " + b.getName());
        int i = 1;
        do {
            if (i % 2 == 0) {
                int damage = b.defence(a.attack());
                battleEvents.add(a.getName()+ " hyökkää ja tekee " + damage + " vahinkoa " + b.getName()+ ":n");
                a.stats.addTotalDamageMade(damage);
            } else {
                int damage = a.defence(b.attack());
                battleEvents.add(b.getName()+ " hyökkää ja tekee " + damage + " vahinkoa " + a.getName()+ ":n");
                b.stats.addTotalDamageMade(damage);
            }
            battleEvents.add("Tilanne hyökkäyksen jälkeen:\n" +
                    a.getName() + "hyökkäys: " + a.getAttack() + " puolustus: " + a.getDefence() + " Kokemus: " + a.getExperience() + " Elämäpisteet: " + a.getHealth() + "/" + a.getMaxHealt() + "\n" +
                    b.getName() + "hyökkäys: " + b.getAttack() + " puolustus: " + b.getDefence() + " Kokemus: " + b.getExperience() + " Elämäpisteet: " + b.getHealth() + "/" + b.getMaxHealt());
            i++;
        } while (a.getHealth() > 0 && b.getHealth() > 0);
        if (a.getHealth() > 0) {
            Storage.moveLutemon(b.getId(), battleField, graveyard);
            b.stats.addDeaths();
            a.stats.addKill();
            a.setExperience(a.getExperience() + 1);
            battleEvents.add(a.getName()+ "voittaa kamppailun ja " + b.getName() + " siirtyy lepäämään hautausmaalle.");
            return battleEvents;
        } else {
            Storage.moveLutemon(a.getId(), battleField, graveyard);
            a.stats.addDeaths();
            b.stats.addKill();
            b.setExperience(b.getExperience() + 1);
            battleEvents.add(a.getName()+ "voittaa kamppailun ja " + b.getName() + " siirtyy lepäämään hautausmaalle.");
            return battleEvents;
        }
    }

    public boolean isLutemonAtBattleField(Integer id) {
        return lutemonsAtBattleField.containsKey(id);
    }

    public HashMap<Integer, Lutemon> getLutemonsAtBattleField() {
        return lutemonsAtBattleField;
    }

    public void add(Lutemon lutemon) {
        lutemonsAtBattleField.put(lutemon.getId(), lutemon);
    }

    public void removeLutemon(Integer id) {
        lutemonsAtBattleField.remove(id);
    }



}
