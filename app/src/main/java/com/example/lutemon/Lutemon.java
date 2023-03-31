package com.example.lutemon;

public class Lutemon extends Storage {
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

    private static int idCounter = 0;

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
        this.stats = new LutemonStats(0,0,0,0,0);
        idCounter++;
    }

    public void defence(Lutemon lutemon){

    }

    public int attack(){
        return 0;
    }

    public int getNumberOfCreatedLutemons(){
        return idCounter;
    }

}
