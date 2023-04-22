package com.example.lutemon;

import java.util.HashMap;

public class BattleField extends Storage {

    protected static HashMap<Integer, Lutemon> lutemonsAtBattleField = new HashMap<>();

    public BattleField() {
    }

    public static String fight(Lutemon a, Lutemon b) {
        System.out.println(a.getName() + " vs. " + b.getName());
        int i = 1;
        do {
            if (i % 2 == 0) {
                b.defence(a.attack());
            } else {
                a.defence(b.attack());
            }
            System.out.println("Tilanne hyökkäyksen jälkeen:");
            System.out.println(a.getName() + "hyökkäys: " + a.getAttack() + "puolustus: " + a.getDefence() + "Kokemus: " + a.getExperience() + "Elämäpisteet: " + a.getHealth() + "/" + a.getMaxHealt());
            System.out.println(b.getName() + "hyökkäys: " + b.getAttack() + "puolustus: " + b.getDefence() + "Kokemus: " + b.getExperience() + "Elämäpisteet: " + b.getHealth() + "/" + b.getMaxHealt());
            i++;
        } while (a.getHealth() > 0 && b.getHealth() > 0);
        if (a.getHealth() > 0) {
            return a.getName();
        }else{
            return b.getName();
        }
    }

    public static boolean isLutemonAtBattleField(Integer id) {
        return lutemonsAtBattleField.containsKey(id);
    }

    public static HashMap<Integer, Lutemon> getLutemonsAtBattleField() {
        return lutemonsAtBattleField;
    }
}
