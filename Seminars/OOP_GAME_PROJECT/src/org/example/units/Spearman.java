package org.example.units;


import org.example.weapons.Spear;

public class Spearman extends Thieves{
    protected Spear weapon;
    public Spearman(String name, int y) {
        super(6, name, 0, y, 8, new int[]{1, 7}, 3, "Копейщик", 1, 80, 60);
        weapon = new Spear();
    }
}
