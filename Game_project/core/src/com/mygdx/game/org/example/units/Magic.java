package com.mygdx.game.org.example.units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Magic extends BaseHero{
    protected int mana;
    protected int maxMana;
    protected int accuracy;

    public Magic(float hp, String name, int x, int y, float armor, int[] damage, int pace, String class_name, int team, int mana, int accuracy) {
        super(hp, name, x, y, armor, damage, pace, class_name, team);
        this.mana = this.maxMana = mana;
        this.accuracy = accuracy;
    }
    @Override
    public String getInfo() {
        return name + " - " + class_name + " - hp|броня " + Math.round(hp) + "|" + armor + " - Мана:" + mana +
                " - Позиция: "+getSelfPosition()[0] + ";" + getSelfPosition()[1];
    }
    protected void heal(BaseHero friend){
        friend.getDamage((float) (new Random().nextInt(this.damage[1], this.damage[0]) * accuracy) /100);
        this.state = "busy";
    }

    protected BaseHero findFriendToHeal(ArrayList<BaseHero> team){
        float minHp = team.get(0).hp;
        BaseHero friendToHeal = team.get(0);
        for (BaseHero hero: team) {
            if (hero.hp < minHp && hero.hp != 0){
                minHp = hero.hp;
                friendToHeal = hero;
            }
        }
        return friendToHeal;
    }
    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendlyTeam) {
        if (this.hp > 0 && this.mana > 0){
            BaseHero friendToHeal = findFriendToHeal(friendlyTeam);
            heal(friendToHeal);
            mana -= 1;
        }
    }
}
