package org.example.units;

import java.util.ArrayList;

public class Wizard extends Magic{

    //protected ArrayList<Spell> spells;

    public Wizard(String name, int y) {
        super(10, name, 0, y, 10, new int[] {2, 7}, 3, "Маг", 1, 15, 75);
//        spells.add(new Attack(new int[]{2, 10}));
//        spells.add(new Defend(new int[]{1, 5}));
//        spells.add(new RestoreHP(new int[]{1, 5}));
//        spells.add(new RestoreMana(new int[]{1, 5}));
    }
}
