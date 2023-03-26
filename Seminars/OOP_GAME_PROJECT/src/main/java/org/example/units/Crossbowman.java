package org.example.units;

import org.example.weapons.Crossbow;

public class Crossbowman extends BaseHero{
    protected int bolt;
    protected int maxBolt;
    protected int accuracy;
    protected Crossbow weapon;
    public Crossbowman(String name, int x, int y) {
        super(9, name, x, y, 7, new int[] {2, 12}, 2, "Арбалетчик");
        bolt = maxBolt = 10;
        accuracy = 6;
        weapon = new Crossbow();
    }
}
