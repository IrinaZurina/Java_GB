package com.mygdx.game.org.example;

import static com.mygdx.game.org.example.units.GameInterface.sortTeam;
//import static org.example.units.GameInterface.sortTeam;

import com.mygdx.game.org.example.units.BaseHero;
import com.mygdx.game.org.example.units.GameInterface;

//import org.example.units.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<BaseHero> TeamOne = sortTeam(GameInterface.createTeamOne());
    public static ArrayList<BaseHero> TeamTwo = sortTeam(GameInterface.createTeamTwo());
    public static ArrayList<BaseHero> allTeam = GameInterface.uniteTeams(TeamOne, TeamTwo);
    public static void main(String[] args) {

        GameInterface.LetTheGameStart(TeamOne, TeamTwo);

    }

}
