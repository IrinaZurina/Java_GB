package org.example;

import org.example.units.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<BaseHero> TeamOne = GameInterface.sortTeam(GameInterface.createTeamOne());
    public static ArrayList<BaseHero> TeamTwo = GameInterface.sortTeam(GameInterface.createTeamTwo());
    public static ArrayList<BaseHero> allTeam = GameInterface.uniteTeams(TeamOne, TeamTwo);
    public static void main(String[] args) {

        System.out.println("Team One:");
        TeamOne.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();

        System.out.println("Team Two:");
        TeamTwo.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();

        GameInterface.LetTheGameStart(TeamOne, TeamTwo);



        //SpellBook spell = SpellBook.values()[new Random().nextInt(SpellBook.values().length)];
    }

}
