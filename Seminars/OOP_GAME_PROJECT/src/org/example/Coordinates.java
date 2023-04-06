package org.example;

import org.example.units.BaseHero;

import java.util.ArrayList;

public interface Coordinates {

    int[] getSelfPosition();

    BaseHero findClosestEnemy(ArrayList<BaseHero> team);
}
