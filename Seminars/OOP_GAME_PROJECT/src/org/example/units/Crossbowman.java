package org.example.units;

import org.example.weapons.Crossbow;

public class Crossbowman extends Shooter{

    protected Crossbow weapon;
    public Crossbowman(String name, int y) {
        super(9, name, 9, y, 7, new int[] {2, 12}, 2, "Арбалетчик", "light", 10, 75);
        weapon = new Crossbow();
    }
}
