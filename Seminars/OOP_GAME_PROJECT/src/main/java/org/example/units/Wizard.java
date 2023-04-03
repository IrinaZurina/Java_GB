package org.example.units;

import java.util.ArrayList;

public class Wizard extends Magic{

    //protected ArrayList<Spell> spells;

    public Wizard(String name, int x, int y) {
        super(10, name, x, y, 10, new int[] {2, 7}, 1, "Маг", 15, 75);
//        spells.add(new Attack(new int[]{2, 10}));
//        spells.add(new Defend(new int[]{1, 5}));
//        spells.add(new RestoreHP(new int[]{1, 5}));
//        spells.add(new RestoreMana(new int[]{1, 5}));
    }
}
