package org.example.units;


public class BaseHero {
    public static void main(String[]args){}
    public String name;
    protected String class_name;
    protected int x;
    protected int y;
    protected float hp;
    protected float max_hp;
    protected int armor; // броня
    protected int[] damage; //здесь должны лежать мин и макс наносимый урон при ручном бое
    protected int pace;
    //protected Weapons weapon;
    @Override
    public String toString() {
        return name + " " + hp + " " + armor + " " + class_name;
    }

    public BaseHero(float hp, String name, int x, int y, int armor, int[] damage, int pace, String class_name){
        this.hp = this.max_hp = hp;
        this.name = name;
        this.x = x;
        this.y = y;
        this.armor = armor;
        this.damage = damage;
        this.class_name = class_name;
        this.pace = pace;
    }

}
