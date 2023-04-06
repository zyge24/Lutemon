package com.example.lutemon;

import java.util.HashMap;

public class BattleField extends Storage {

    protected static HashMap<Integer,Lutemon> lutemonsAtBattleField = new HashMap<>();

    public BattleField() {
    }

    public void fight(Lutemon a, Lutemon b) {
        System.out.println(a.getName() + " vs. " + b.getName());
        int i = 1;
        do {
            if (i % 2 == 0) {
                b.defence(a.attack());
            } else {
                a.defence(b.attack());
            }
            System.out.println("Tilanne hyökkäyksen jälkeen:");
            System.out.println(a.getName() + "hyökkäys:" + a.getAttack() + "puolustus:" + a.getDefence() + "Kokemus:" + a.getExperience() +"Elämäpisteet:" + a.getHealth() + "/" + a.getMaxHealt());
            System.out.println(b.getName() + "hyökkäys:" + b.getAttack() + "puolustus:" + b.getDefence() + "Kokemus:" + b.getExperience()+ "Elämäpisteet:" + b.getHealth() + "/" + b.getMaxHealt());
            i++;
        } while (a.getHealth() > 0 && b.getHealth() > 0);

    }
}
