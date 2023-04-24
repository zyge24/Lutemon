package com.example.lutemon;

import java.util.HashMap;

public class BattleField extends Storage {

    protected HashMap<Integer, Lutemon> lutemonsAtBattleField = new HashMap<>();
    ;


    public BattleField() {
    }

    public static String fight(Lutemon a, Lutemon b) {
        Storage storage = Storage.getInstance();
        BattleField battleField = Storage.getInstance().getBattleField();
        Graveyard graveyard = Storage.getInstance().getGraveyard();
        System.out.println(a.getName() + " vs. " + b.getName());
        int i = 1;
        do {
            if (i % 2 == 0) {
                int damage = b.defence(a.attack());
                a.stats.addTotalDamageMade(damage);
            } else {
                int damage = a.defence(b.attack());
                b.stats.addTotalDamageMade(damage);
            }
            System.out.println("Tilanne hyökkäyksen jälkeen:");
            System.out.println(a.getName() + "hyökkäys: " + a.getAttack() + " puolustus: " + a.getDefence() + " Kokemus: " + a.getExperience() + " Elämäpisteet: " + a.getHealth() + "/" + a.getMaxHealt());
            System.out.println(b.getName() + "hyökkäys: " + b.getAttack() + " puolustus: " + b.getDefence() + " Kokemus: " + b.getExperience() + " Elämäpisteet: " + b.getHealth() + "/" + b.getMaxHealt());
            i++;
        } while (a.getHealth() > 0 && b.getHealth() > 0);
        if (a.getHealth() > 0) {
            storage.moveLutemon(b.getId(), battleField, graveyard);
            b.stats.addDeaths();
            a.stats.addKill();
            a.setExperience(a.getExperience()+1);
            return a.getName();
        } else {
            storage.moveLutemon(a.getId(), battleField, graveyard);
            a.stats.addDeaths();
            b.stats.addKill();
            b.setExperience(b.getExperience()+1);
            return b.getName();
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
