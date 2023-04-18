package com.mygdx.game.org.example.weapons;

public abstract class BaseWeapon {
    public static void main(String[] args) {}
    protected int [] damage;
    protected int actionRange; //радиус действия
    protected int weaponIntegrity; // текущий статус целостности оружия
    protected int maxWeaponIntegrity; // максмальный он же стартовый статус целостности оружия

    public BaseWeapon(int []damage, int actionRange, int weaponIntegrity){
        this.damage = damage;
        this.actionRange = actionRange;
        this.weaponIntegrity = this.maxWeaponIntegrity = weaponIntegrity;
    }
}
