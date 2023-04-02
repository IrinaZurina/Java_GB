package org.example.units;

import org.example.weapons.Bow;

public class Sniper extends Shooter{
    protected Bow weapon;
    public Sniper(String name, int x, int y) {
        super(7, name, x, y, 12, new int[] {1, 8}, 2, "Снайпер", 12, 50);

        weapon = new Bow();
    }
}
