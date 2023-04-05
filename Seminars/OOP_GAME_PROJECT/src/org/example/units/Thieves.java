package org.example.units;

public abstract class Thieves extends BaseHero{
    protected int accuracy;
    protected int stealth;
    public Thieves(float hp, String name, int x, int y, int armor, int[] damage, int pace, String class_name, String side, int accuracy, int stealth) {
        super(hp, name, x, y, armor, damage, pace, class_name, side);
        this.stealth = stealth;
        this.accuracy = accuracy;
    }
}
