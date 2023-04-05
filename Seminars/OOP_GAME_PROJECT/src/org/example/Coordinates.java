package org.example;

import org.example.units.BaseHero;

import java.util.ArrayList;

public interface Coordinates {

    int[] getSelfPosition();

    int[] findClosestEnemy(BaseHero hero, ArrayList<BaseHero> team);
}
