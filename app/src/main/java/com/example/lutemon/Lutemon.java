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

    public void defence(int enemyAttack){
        int damage = Math.max((enemyAttack - defence), 0);
        System.out.println("Tekee vahinkoa " + damage);
        this.health =  health - damage;
        if (health <= 0) {
            System.out.println(name + " kuoli taistelussa");
        }
    }

    public int attack(){

        return attack;
    }

    public static int getNumberOfCreatedLutemons(){
        return idCounter;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
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

    public int getId() {
        return id;
    }

    public LutemonStats getStats() {
        return stats;
    }

    public int getPicture() {
        return picture;
    }
}
