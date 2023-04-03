package org.example.units;

import java.util.ArrayList;

public class Monk extends Magic{
    // protected ArrayList<Spell> spells;

    public Monk(String name, int x, int y) {
        super(8, name, x, y, 7, new int[] {1, 8}, 1, "Монах", 20, 80);

//        spells.add(new Attack(new int[]{1, 8}));
//        spells.add(new Defend(new int[]{2, 6}));
//        spells.add(new RestoreHP(new int[]{2, 6}));
//        spells.add(new RestoreMana(new int[]{2, 6}));
    }
}