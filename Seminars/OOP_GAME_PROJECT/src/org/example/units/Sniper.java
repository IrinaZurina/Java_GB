package org.example.units;

import org.example.weapons.Bow;

public class Sniper extends Shooter{
    protected Bow weapon;
    public Sniper(String name, int y) {
        super(7, name, 0, y, 12, new int[] {1, 8}, 2, "Снайпер", "dark", 12, 50);

        weapon = new Bow();
    }
}
