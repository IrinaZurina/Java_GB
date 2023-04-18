package com.mygdx.game.org.example.units;

import com.mygdx.game.org.example.Main;

import java.util.ArrayList;
import java.util.Random;

public abstract class Thieves extends BaseHero{
    protected int accuracy;
    protected int stealth;
    public Thieves(float hp, String name, int x, int y, float armor, int[] damage, int pace, String class_name, int team, int accuracy, int stealth) {
        super(hp, name, x, y, armor, damage, pace, class_name, team);
        this.stealth = stealth;
        this.accuracy = accuracy;
    }
    protected void strike(BaseHero enemy) {
        enemy.getDamage((float) (new Random().nextInt(this.damage[0], this.damage[1]) * accuracy) /100);
        this.state = "busy";
    }

    protected boolean checkIfEmpty(int x, int y, ArrayList<BaseHero> AllTeam){
        boolean empty = true;
        for (BaseHero hero: AllTeam) {
            if (hero.x == x && hero.y == y) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    protected int[] chooseDirection(BaseHero enemy){
        int [] cellToChoose = new int[2];
        double minDistance = Math.sqrt(Math.pow(enemy.x - this.x, 2) + Math.pow(enemy.y - this.y, 2));
        ArrayList<int []> newPositions = new ArrayList<>();
        if (this.x + 1 < 10 && checkIfEmpty(this.x + 1, this.y, Main.allTeam)) newPositions.add(new int[]{this.x + 1, this.y});
        if (this.x - 1 > -1 && checkIfEmpty(this.x - 1, this.y, Main.allTeam)) newPositions.add(new int[]{this.x - 1, this.y});
        if (this.y + 1 < 10 && checkIfEmpty(this.x, this.y + 1, Main.allTeam)) newPositions.add(new int[]{this.x, this.y + 1});
        if (this.y - 1 > -1 && checkIfEmpty(this.x, this.y - 1, Main.allTeam)) newPositions.add(new int[]{this.x, this.y - 1});
        for (int[] pos: newPositions) {
            if (Math.sqrt(Math.pow(enemy.x - pos[0], 2) + Math.pow(enemy.y - pos[1], 2)) < minDistance) {
                minDistance = Math.sqrt(Math.pow(enemy.x - pos[0], 2) + Math.pow(enemy.y - pos[1], 2));
                cellToChoose[0] = pos[0];
                cellToChoose[1] = pos[1];
            }
        }
        return cellToChoose;
    }
    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendlyTeam) {
        if (this.hp > 0){
            BaseHero closestEnemy = findClosestEnemy(enemyTeam);
            if (Math.sqrt(Math.pow(closestEnemy.x - this.x, 2) + Math.pow(closestEnemy.y - this.y, 2)) < 2) strike(closestEnemy);
            else {
                this.x = chooseDirection(closestEnemy)[0];
                this.y = chooseDirection(closestEnemy)[1];
            }
        }
    }
}

