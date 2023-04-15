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

        GameInterface.LetTheGameStart(TeamOne, TeamTwo);

    }

}
