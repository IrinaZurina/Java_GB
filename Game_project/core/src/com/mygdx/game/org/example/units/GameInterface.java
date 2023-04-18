package com.mygdx.game.org.example.units;

import com.mygdx.game.org.example.Names;
import com.mygdx.game.org.example.TeamOne;
import com.mygdx.game.org.example.View;

//import org.example.Names;
//import org.example.TeamOne;
//import org.example.TeamTwo;
//import org.example.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public interface GameInterface {


    static String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();}

    static ArrayList<BaseHero> createTeamOne(){
        ArrayList<BaseHero> teamOne = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String TeamOneHero = TeamOne.values()[new Random().nextInt(TeamOne.values().length)].toString();
            switch (TeamOneHero) {
                case ("spearman"):
                    teamOne.add(new Spearman('\u2020' + getName(), i));
                    break;
                case ("wizard"):
                    teamOne.add(new Wizard('\u058D' + getName(), i));
                    break;
                case ("sniper"):
                    teamOne.add(new Sniper('\u21A3' + getName(), i));
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
            String teamTwoHero = com.mygdx.game.org.example.TeamTwo.values()
                    [new Random().nextInt(com.mygdx.game.org.example.TeamTwo.values().length)].toString();
            switch (teamTwoHero) {
                case ("thief"):
                    TeamTwo.add(new Thief('\u2020' + getName(), i));
                    break;
                case ("monk"):
                    TeamTwo.add(new Monk('\u058D' + getName(), i));
                    break;
                case ("crossbowman"):
                    TeamTwo.add(new Crossbowman('\u21A3' + getName(), i));
                    break;
                default:
                    TeamTwo.add(new Peasant(getName(), 9, i));
                    break;
            }
        }
        return TeamTwo;
    }

    static ArrayList<BaseHero> uniteTeams(ArrayList<BaseHero> TeamOne, ArrayList<BaseHero> TeamTwo){
        ArrayList<BaseHero> allTeam = new ArrayList<>();
        for (BaseHero hero: TeamOne) {allTeam.add(hero);}
        for (BaseHero hero: TeamTwo) {allTeam.add(hero);}
//        TeamOne.forEach(n -> allTeam.add(n));
//        TeamTwo.forEach(n -> allTeam.add(n));
        return allTeam;
    }

    static ArrayList<BaseHero> sortTeam(ArrayList<BaseHero> team){
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
    float getHp();
    void getDamage(float damage);

    static void LetTheGameStart(ArrayList<BaseHero> TeamOne, ArrayList<BaseHero> TeamTwo){
        Scanner input = new Scanner(System.in);
        while (true){
            //View.view();
            input.nextLine();
            TeamOne.forEach(n -> n.step(TeamTwo, TeamOne));
            TeamTwo.forEach(n -> n.step(TeamOne, TeamTwo));
            if (!BaseHero.checkTeamHp(TeamOne)) {
                //View.view();
                System.out.println("WINNER - TEAM TWO");
                break;
            }
            if (!BaseHero.checkTeamHp(TeamTwo)) {
                //View.view();
                System.out.println("WINNER - TEAM ONE");
                break;
            }

            TeamOne.forEach(n -> {if (!n.state.equals("dead")) n.state = "standBy";});
            TeamTwo.forEach(n -> {if (!n.state.equals("dead")) n.state = "standBy";});

            sortTeam(TeamOne);
            sortTeam(TeamTwo);
        }
    }


}
