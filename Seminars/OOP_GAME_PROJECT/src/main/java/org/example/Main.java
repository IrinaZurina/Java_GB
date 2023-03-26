package org.example;

import org.example.units.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        heroes.add(new Sniper("Бойд", 2, 6));
        heroes.add(new Thief("Арлина", 2, 3));
        heroes.add(new Monk("Арден", 1, 2));
        heroes.add(new Peasant("Бранн", 1, 5));
        heroes.add(new Crossbowman("Эна", 14, 2));
        heroes.add(new Spearman("Айрелл", 14, 7));
        heroes.add(new Wizard("Анвелл", 15, 4));
        heroes.add(new Peasant("Виллем", 15, 3));

    }
}
