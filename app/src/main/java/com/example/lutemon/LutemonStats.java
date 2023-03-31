package com.example.lutemon;

public class LutemonStats {
    private int kills;
    private int deaths;
    private int totalDamageMade;
    private int totalDamageReceived;
    private int maxHit;

    public LutemonStats(int kills, int deaths, int totalDamageMade, int totalDamageReceived, int maxHit) {
        this.kills = kills;
        this.deaths = deaths;
        this.totalDamageMade = totalDamageMade;
        this.totalDamageReceived = totalDamageReceived;
        this.maxHit = maxHit;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
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
}
