package org.example.units;

import org.example.weapons.Knife;
import org.example.weapons.Spear;

public class Spearman extends BaseHero{
    protected int accuracy;
    protected Spear weapon;
    public Spearman(String name, int x, int y) {
        super(6, name, x, y, 8, new int[]{1, 7}, 3, "Копейщик");

    }
}
