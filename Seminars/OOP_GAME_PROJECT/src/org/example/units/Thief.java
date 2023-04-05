package org.example.units;

import org.example.weapons.Knife;

public class Thief extends Thieves{

    protected Knife weapon;
    public Thief(String name, int y) {
        super(7, name, 9, y, 6, new int[]{1, 10}, 3, "Вор", "light",70, 85);
        weapon = new Knife();
    }
}
