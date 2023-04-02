package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        heroes.add(new Sniper(getName(), 2, 6));
        heroes.add(new Thief(getName(), 2, 3));
        heroes.add(new Monk(getName(), 1, 2));
        heroes.add(new Peasant(getName(), 1, 5));
        heroes.add(new Crossbowman(getName(), 14, 2));
        heroes.add(new Spearman(getName(), 14, 7));
        heroes.add(new Wizard(getName(), 15, 4));
        heroes.add(new Peasant(getName(), 15, 3));

        for (BaseHero hero: heroes) {
            System.out.println(hero.name + " - " + hero.getInfo());
        }


        SpellBook spell = SpellBook.values()[new Random().nextInt(SpellBook.values().length)];


        }
    private static String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }


}
