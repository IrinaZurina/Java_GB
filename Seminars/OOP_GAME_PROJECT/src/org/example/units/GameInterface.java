package org.example.units;

import org.example.Names;
import org.example.TeamOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public interface GameInterface {


    private static String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();}

    static ArrayList<BaseHero> createTeamOne(){
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

    static ArrayList<BaseHero> createTeamTwo(){
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

    static ArrayList<BaseHero> sortTeam(ArrayList<BaseHero> team){
        //int minPace = team.get(0).pace;
        for (int j = 0; j < team.size(); j++) {
            for (int i = 1; i < team.size(); i++) {
                if (team.get(i).pace < team.get(i-1).pace) Collections.swap(team, i - 1, i);
                else if (team.get(i).pace == team.get(i-1).pace){
                    if (team.get(i).hp > team.get(i-1).hp) Collections.swap(team, i - 1, i);
                }
            }
        }
        return team;
    }

    void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendlyTeam);
    String getInfo();
    void getDamage(float damage);

    static void LetTheGameStart(ArrayList<BaseHero> TeamOne, ArrayList<BaseHero> TeamTwo){
        int round = 1;
        while (round == 1) {  // ПОМЕНЯТЬ УСЛОВИЕ ВЫХОДА ИЗ ИГРЫ!!!
            System.out.println("----------ROUND " + round + "----------");
            System.out.println("-----Team 1-----");
            for (BaseHero hero : TeamOne) {
                System.out.print(hero.name + ": ");
                hero.step(TeamTwo, TeamOne);
                System.out.println();
            }

            System.out.println();
            System.out.println("-----Team 2-----");
            for (BaseHero hero : TeamTwo) {
                System.out.print(hero.name + ": ");
                hero.step(TeamOne, TeamTwo);
                System.out.println();
            }
            TeamOne.forEach(n -> n.state = "standBy");
            TeamTwo.forEach(n -> n.state = "standBy");
            round++;
        }
    }


}
