package org.example.units;

import org.example.weapons.Crossbow;

public class Crossbowman extends Shooter{

    protected Crossbow weapon;
    public Crossbowman(String name, int x, int y) {
        super(9, name, x, y, 7, new int[] {2, 12}, 2, "Арбалетчик", 10, 75);
        weapon = new Crossbow();
    }
}
