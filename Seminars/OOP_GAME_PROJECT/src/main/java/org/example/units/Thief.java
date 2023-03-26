package org.example.units;

import org.example.weapons.Bow;
import org.example.weapons.Knife;

public class Thief extends BaseHero{
    protected int accuracy;
    protected Knife weapon;
    public Thief(String name, int x, int y) {
        super(7, name, x, y, 6, new int[]{1, 10}, 3, "Вор");
        accuracy = 12;
        weapon = new Knife();
    }
}
