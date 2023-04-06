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
    public Shooter(float hp, String name, int x, int y, int armor, int[] damage, int pace, String class_name, int team, int arrows, int accuracy) {
        super(hp, name, x, y, armor, damage, pace, class_name, team);
        this.arrows = this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(BaseHero enemy){
        enemy.getDamage(new Random().nextInt(this.damage[0], this.damage[1]) * accuracy/100);
        System.out.println("Shoot!");
        System.out.println(enemy.name + ", " + enemy.class_name + ", " + "Здоровье " + enemy.hp);;
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {
        // check hp and arrows
        //      alive and has arrows - find the closest enemy and shoot
        //      check peasant
        //          if peasant present - finish step
        //          else : arrows -= 1
        // hp or arrows = 0 - return
        if (this.hp > 0 && this.arrows > 0){
            shoot(findClosestEnemy(enemyTeam));
        }
    }
}
