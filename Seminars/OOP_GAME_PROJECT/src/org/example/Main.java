package org.example;

import org.example.units.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.units.GameInterface.sortTeam;

public class Main {
    public static ArrayList<BaseHero> TeamOne = sortTeam(GameInterface.createTeamOne());
    public static ArrayList<BaseHero> TeamTwo = sortTeam(GameInterface.createTeamTwo());
    public static ArrayList<BaseHero> allTeam = GameInterface.uniteTeams(TeamOne, TeamTwo);
    public static void main(String[] args) {

//        System.out.println("Team One:");
//        TeamOne.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println();
//
//        System.out.println("Team Two:");
//        TeamTwo.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println();

        GameInterface.LetTheGameStart(TeamOne, TeamTwo);

//        Scanner input = new Scanner(System.in);
//        while (true){
//            allTeam = sortTeam(allTeam);
//            View.view();
//            input.nextLine();
//            for (BaseHero human: allTeam) {
//                if (TeamOne.contains(human)) human.step(TeamTwo, TeamOne);
//                else human.step(TeamOne, TeamTwo);
//            }
//        }

        //
        // View.view();

        //SpellBook spell = SpellBook.values()[new Random().nextInt(SpellBook.values().length)];
    }

}
