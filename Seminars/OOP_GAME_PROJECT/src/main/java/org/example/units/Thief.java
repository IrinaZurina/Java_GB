package org.example.units;

import org.example.weapons.Knife;

public class Thief extends Thieves{

    protected Knife weapon;
    public Thief(String name, int x, int y) {
        super(7, name, x, y, 6, new int[]{1, 10}, 3, "Вор", 70, 85);
        weapon = new Knife();
    }
}
