package com.example.lutemon;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Lutemon implements Serializable {
    protected static final long serialVersionUID = 3453475L;
    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealt;
    protected int id;
    protected LutemonStats stats;
    protected int picture;

    private static int idCounter = 1;

    public Lutemon(String name, String color, int attack, int defence, int experience, int health, int maxHealt, int picture) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.health = health;
        this.maxHealt = maxHealt;
        this.picture = picture;
        this.id = idCounter;
        this.stats = new LutemonStats(0,0,0,0,0,0);
        idCounter++;
    }

    public int defence(int enemyAttack){
        int damage = Math.max((enemyAttack - defence), 0);
        System.out.println(name + "ottaa vahinkoa " + damage);
        stats.addTotalDamageReceived(damage);
        this.health =  health - damage;
        if (health <= 0) {
            System.out.println(name + " kuoli taistelussa");
        }
        return damage;
    }

    public int attack(){
        int multiplier = (int) (Math.random() * 3);
        int hit = attack*multiplier;
        stats.testMaxHit(hit);
        return hit;
    }

    public static Integer getNumberOfCreatedLutemons(){
        return idCounter;
    }

    public String getName() {
        return name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getColor() {
        return color;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealt(int maxHealt) {
        this.maxHealt = maxHealt;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealt() {
        return maxHealt;
    }

    public Integer getId() {
        return id;
    }

    public LutemonStats getStats() {
        return stats;
    }

    public int getPicture() {
        return picture;
    }

    public void setFullHealth(){this.health=getMaxHealt();}




    public static void save(Context context) {
        try {
            ObjectOutputStream idWriter = new ObjectOutputStream(context.openFileOutput("id.data", Context.MODE_PRIVATE));
            idWriter.writeObject(idCounter);
            idWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedostoston tallentaminen ei onnistunut");
            throw new RuntimeException(e);
        }
    }


    public static void load(Context context) {
        try {
            ObjectInputStream idReader = new ObjectInputStream(context.openFileInput("id.data"));
            idCounter = (int) idReader.readObject();
            idReader.close();
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
    }}