package org.example.units;


import org.example.Coordinates;

import java.util.ArrayList;

public abstract class BaseHero implements GameInterface, Coordinates {
    public static void main(String[]args){}
    public String name;
    protected String class_name;
    public int x;
    public int y;
    protected float hp;
    protected float max_hp;
    protected int armor; // броня
    protected int[] damage; //здесь должны лежать мин и макс наносимый урон при ручном бое
    protected int pace;
    protected int team;
    //protected Weapons weapon;
    @Override
    public String toString() {
        return name + " " + hp + " " + armor + " " + class_name;
    }

    // Инициализация
    public BaseHero(float hp, String name, int x, int y, int armor, int[] damage, int pace, String class_name, int team){
        this.hp = this.max_hp = hp;
        this.name = name;
        this.x = x;
        this.y = y;
        this.armor = armor;
        this.damage = damage;
        this.class_name = class_name;
        this.pace = pace;
        this.team = team;
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {}

    @Override
    public String getInfo() {return name + " - " + class_name + " - " + getSelfPosition()[0] + ";" + getSelfPosition()[1];}

    @Override
    public int[] getSelfPosition() {
        int[] selfPos = new int[]{x, y};
        return selfPos;
    }

    @Override
    public BaseHero findClosestEnemy(ArrayList<BaseHero> team) {
        BaseHero closestEnemy = team.get(0);
        double minDistance = Math.sqrt(81 + 81);
        for (BaseHero enemy: team) {
            double distance = Math.sqrt(Math.pow(enemy.x - this.x, 2) + Math.pow(enemy.y - this.y, 2));
            if (distance < minDistance) {
                minDistance = distance;
                closestEnemy = enemy;
            }
        }
        System.out.println("Ближайший враг - " + closestEnemy.name + ", " + closestEnemy.class_name + ", " +
                "Здоровье " + closestEnemy.hp);
        return closestEnemy;
    }

    @Override
    public void getDamage(float damage) {
        if (this.hp - damage > 0) {this.hp -= damage;}

    }

    public static void getTeamPositions(ArrayList<BaseHero> team) {
        for (BaseHero hero: team) {
            System.out.println(hero.getSelfPosition()[0] + ";" + hero.getSelfPosition()[1]);
        }
    }


}
