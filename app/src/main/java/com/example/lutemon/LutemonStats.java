package com.example.lutemon;

import java.io.Serializable;

public class LutemonStats implements Serializable {
    private int kills;
    private int deaths;
    private int totalDamageMade;
    private int totalDamageReceived;
    private int maxHit;
    private int training;

    public LutemonStats(int kills, int deaths, int totalDamageMade, int totalDamageReceived, int maxHit, int training) {
        this.kills = kills;
        this.deaths = deaths;
        this.totalDamageMade = totalDamageMade;
        this.totalDamageReceived = totalDamageReceived;
        this.maxHit = maxHit;
        this.training = training;
    }

    public void addKill() {
        this.kills = (kills+1);
    }

    public void addDeaths() {
        this.deaths = (deaths+1);
    }

    public void addTotalDamageMade(int damageMade) {
        this.totalDamageMade = (totalDamageMade + damageMade);
    }

    public void addTotalDamageReceived(int damageReceived) {
        this.totalDamageReceived = (totalDamageReceived + damageReceived);
    }

    public void testMaxHit(int newMaxHit) {
        if(newMaxHit>maxHit){
        this.maxHit = newMaxHit;}
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getTotalDamageMade() {
        return totalDamageMade;
    }

    public int getTotalDamageReceived() {
        return totalDamageReceived;
    }

    public int getMaxHit() {
        return maxHit;
    }

    public void addTraining(){++training;}

    public int getTraining() {
        return training;
    }
}
