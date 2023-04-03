package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<BaseHero> brightSide = new ArrayList<>();
        ArrayList<BaseHero> darkSide = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String brightHero = BrightSide.values()[new Random().nextInt(BrightSide.values().length)].toString();
            String darkHero = DarkSide.values()[new Random().nextInt(DarkSide.values().length)].toString();
            switch (brightHero) {
                case ("thief"):
                    brightSide.add(new Thief(getName(), getX(), getY()));
                    break;
                case ("monk"):
                    brightSide.add(new Monk(getName(), getX(), getY()));
                    break;
                case ("crossbowman"):
                    brightSide.add(new Crossbowman(getName(), getX(), getY()));
                    break;
                default:
                    brightSide.add(new Peasant(getName(), getX(), getY()));
                    break;
            }
            switch (darkHero) {
                case ("spearman"):
                    darkSide.add(new Spearman(getName(), getX(), getY()));
                    break;
                case ("wizard"):
                    darkSide.add(new Wizard(getName(), getX(), getY()));
                    break;
                case ("sniper"):
                    darkSide.add(new Sniper(getName(), getX(), getY()));
                    break;
                default:
                    darkSide.add(new Peasant(getName(), getX(), getY()));
                    break;
            }
        }

        System.out.println("Bright side:");
        for (BaseHero hero: brightSide) {
            System.out.println(hero.name + " - " + hero.getInfo());
        }

        System.out.println();

        System.out.println("Dark side:");
        for (BaseHero hero: darkSide) {
            System.out.println(hero.name + " - " + hero.getInfo());
        }


        SpellBook spell = SpellBook.values()[new Random().nextInt(SpellBook.values().length)];


        }
    private static String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    private static int getX(){
        return new Random().nextInt(1, 20);
    }
    private static int getY(){
        return new Random().nextInt(1, 20);
    }


}
