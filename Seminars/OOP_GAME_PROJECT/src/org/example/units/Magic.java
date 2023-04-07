package org.example.units;

public abstract class Magic extends BaseHero{
    protected int mana;
    protected int maxMana;
    protected int accuracy;

    public Magic(float hp, String name, int x, int y, float armor, int[] damage, int pace, String class_name, int team, int mana, int accuracy) {
        super(hp, name, x, y, armor, damage, pace, class_name, team);
        this.mana = this.maxMana = mana;
        this.accuracy = accuracy;
    }
}
