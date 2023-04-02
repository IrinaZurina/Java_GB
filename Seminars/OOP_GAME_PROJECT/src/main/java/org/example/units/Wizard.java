package org.example.units;

import org.example.spells.*;

import java.util.ArrayList;

public class Wizard extends BaseHero{
    protected int mana;
    protected int maxMana;
    protected int accuracy;
    //protected ArrayList<Spell> spells;


    public Wizard(String name, int x, int y) {
        super(10, name, x, y, 10, new int[] {2, 7}, 1, "Маг");
        mana = maxMana = 12;
        accuracy = 8;
//        spells.add(new Attack(new int[]{2, 10}));
//        spells.add(new Defend(new int[]{1, 5}));
//        spells.add(new RestoreHP(new int[]{1, 5}));
//        spells.add(new RestoreMana(new int[]{1, 5}));
    }
}
