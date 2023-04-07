package org.example;

import org.example.units.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> TeamOne = GameInterface.sortTeam(GameInterface.createTeamOne());
        ArrayList<BaseHero> TeamTwo = GameInterface.sortTeam(GameInterface.createTeamTwo());

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
