package com.mygdx.game.org.example;

import com.mygdx.game.org.example.units.BaseHero;

//import org.example.units.BaseHero;

import java.util.ArrayList;

public interface Coordinates {

    int[] getSelfPosition();

    BaseHero findClosestEnemy(ArrayList<BaseHero> team);
}
