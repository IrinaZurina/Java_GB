package org.example.units;

import org.example.Main;
import org.example.Names;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Shooter extends BaseHero{
    protected int arrows;
    protected int maxArrows;
    protected int accuracy;
    public Shooter(float hp, String name, int x, int y, float armor, int[] damage, int pace, String class_name, int team, int arrows, int accuracy) {
        super(hp, name, x, y, armor, damage, pace, class_name, team);
        this.arrows = this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(BaseHero enemy){
        enemy.getDamage(new Random().nextInt(this.damage[0], this.damage[1]) * accuracy/100);
        System.out.println("Shoot!");
        System.out.println(enemy.name + ", " + enemy.class_name + ": Броня " + enemy.armor + " Здоровье " + enemy.hp);
        this.state = "busy";
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendlyTeam) {
        if (this.hp > 0 && this.arrows > 0){
            BaseHero closestEnemy = findClosestEnemy(enemyTeam);
            if (closestEnemy.hp > 0) shoot(closestEnemy);
            this.arrows -= 1;
            for (BaseHero hero: friendlyTeam) {
                if (hero.class_name.equals("Крестьянин") && hero.hp > 0 && hero.state.equals("standBy")) {
                    this.arrows ++;
                    hero.state = "busy";
                    break;}
            }
        }
        System.out.println(this.class_name + " " + this.name + " осталось " + this.arrows + " стрел");
    }
}