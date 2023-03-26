package org.example.units;

import org.example.weapons.Bow;

public class Sniper extends BaseHero{
    protected int arrows;
    protected int maxArrows;
    protected int accuracy;
    protected Bow weapon;


    public Sniper(String name, int x, int y) {
        super(7, name, x, y, 12, new int[] {1, 8}, 2, "Снайпер");
        arrows = maxArrows = 10;
        accuracy = 10;
        weapon = new Bow();

    }
}
