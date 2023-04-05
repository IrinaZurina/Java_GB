package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.Random;
import org.example.Coordinates;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> darkSide = createDarkTeam();
        ArrayList<BaseHero> brightSide = createLightTeam();

        System.out.println("Bright side:");
        for (BaseHero hero: brightSide) {
            System.out.println(hero.getInfo());
        }

        System.out.println();

        System.out.println("Dark side:");
        for (BaseHero hero: darkSide) {
            System.out.println(hero.getInfo());
        }

        SpellBook spell = SpellBook.values()[new Random().nextInt(SpellBook.values().length)];
    }

    private static String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();}


    private static ArrayList<BaseHero> createDarkTeam(){
        ArrayList<BaseHero> darkSide = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String darkHero = DarkSide.values()[new Random().nextInt(DarkSide.values().length)].toString();
            switch (darkHero) {
                case ("spearman"):
                    darkSide.add(new Spearman(getName(), i));
                    break;
                case ("wizard"):
                    darkSide.add(new Wizard(getName(), i));
                    break;
                case ("sniper"):
                    darkSide.add(new Sniper(getName(), i));
                    break;
                default:
                    darkSide.add(new Peasant(getName(), 0, i));
                    break;
            }
        }
        return darkSide;
    }

    private static ArrayList<BaseHero> createLightTeam(){
        ArrayList<BaseHero> brightSide = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String brightHero = BrightSide.values()[new Random().nextInt(BrightSide.values().length)].toString();
            switch (brightHero) {
                case ("thief"):
                    brightSide.add(new Thief(getName(), i));
                    break;
                case ("monk"):
                    brightSide.add(new Monk(getName(), i));
                    break;
                case ("crossbowman"):
                    brightSide.add(new Crossbowman(getName(), i));
                    break;
                default:
                    brightSide.add(new Peasant(getName(), 9, i));
                    break;
            }
        }
        return brightSide;
    }



}
