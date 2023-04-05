package org.example.units;

import java.util.ArrayList;

public class Peasant extends BaseHero{
    public Peasant(String name, int x, int y) {
        super(8, name, x, y, 6, new int[]{1, 4}, 4, "Крестьянин", "neutral");
    }

}
