package com.mygdx.game.org.example.units;

import java.util.ArrayList;

public class Peasant extends BaseHero{
    public Peasant(String name, int x, int y) {
        super(8, name, x, y, 6, new int[]{1, 4}, 4, "Крестьянин", 0);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendlyTeam) {
        this.state = "busy";
    }
}

