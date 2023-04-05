package org.example.units;

public abstract class Shooter extends BaseHero{
    protected int arrows;
    protected int maxArrows;
    protected int accuracy;
    public Shooter(float hp, String name, int x, int y, int armor, int[] damage, int pace, String class_name, String side, int arrows, int accuracy) {
        super(hp, name, x, y, armor, damage, pace, class_name, side);
        this.arrows = this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(){
        System.out.println("Shoot!");
    }

    @Override
    public void step() {
        // check hp
        // check arrows
        // alive - find the closest enemy
        // shoot
        // check peasant
        // if peasant present - finish step
        // else : arrows -= 1
        System.out.println("Shooter");
    }
}
