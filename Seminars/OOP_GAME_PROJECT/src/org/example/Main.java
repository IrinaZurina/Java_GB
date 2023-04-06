package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> TeamOne = createTeamOne();
        ArrayList<BaseHero> TeamTwo = createTeamTwo();

        System.out.println("Team Two:");
        for (BaseHero hero: TeamTwo) {
            System.out.println(hero.getInfo());
        }


        System.out.println();

        System.out.println("Team One:");
        for (BaseHero hero: TeamOne) {
            System.out.println(hero.getInfo());
        }

        TeamTwo.get(0).findClosestEnemy(TeamOne);
        SpellBook spell = SpellBook.values()[new Random().nextInt(SpellBook.values().length)];
    }

    private static String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();}


    private static ArrayList<BaseHero> createTeamOne(){
        ArrayList<BaseHero> teamOne = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String TeamOneHero = TeamOne.values()[new Random().nextInt(TeamOne.values().length)].toString();
            switch (TeamOneHero) {
                case ("spearman"):
                    teamOne.add(new Spearman(getName(), i));
                    break;
                case ("wizard"):
                    teamOne.add(new Wizard(getName(), i));
                    break;
                case ("sniper"):
                    teamOne.add(new Sniper(getName(), i));
                    break;
                default:
                    teamOne.add(new Peasant(getName(), 0, i));
                    break;
            }
        }
        return teamOne;
    }

    private static ArrayList<BaseHero> createTeamTwo(){
        ArrayList<BaseHero> TeamTwo = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String teamTwoHero = org.example.TeamTwo.values()[new Random().nextInt(org.example.TeamTwo.values().length)].toString();
            switch (teamTwoHero) {
                case ("thief"):
                    TeamTwo.add(new Thief(getName(), i));
                    break;
                case ("monk"):
                    TeamTwo.add(new Monk(getName(), i));
                    break;
                case ("crossbowman"):
                    TeamTwo.add(new Crossbowman(getName(), i));
                    break;
                default:
                    TeamTwo.add(new Peasant(getName(), 9, i));
                    break;
            }
        }
        return TeamTwo;
    }



}
