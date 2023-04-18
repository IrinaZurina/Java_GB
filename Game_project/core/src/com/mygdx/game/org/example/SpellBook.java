package com.mygdx.game.org.example;

public enum SpellBook {
    healOne(1, -1), healFive(2, -5), healTen(3, -10),
    attackOne(1, 1), attackTwo(5, 2), attackThree(10, 3),
    resurrect(25, Float.NaN),
    restoreTwoMana(1, -2), restoreFiveMana(3, -5), restoreTenMana(5, -10);

    private final float power, cost;

    SpellBook(float cost, float power){
        this.power = power;
        this.cost = cost;
    }

    public float getPower() {
        return power;
    }

    public float getCost() {
        return cost;
    }
}

