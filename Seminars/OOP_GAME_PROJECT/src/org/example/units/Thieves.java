package org.example.units;

public abstract class Thieves extends BaseHero{
    protected int accuracy;
    protected int stealth;
    public Thieves(float hp, String name, int x, int y, int armor, int[] damage, int pace, String class_name, int team, int accuracy, int stealth) {
        super(hp, name, x, y, armor, damage, pace, class_name, team);
        this.stealth = stealth;
        this.accuracy = accuracy;
    }
}
