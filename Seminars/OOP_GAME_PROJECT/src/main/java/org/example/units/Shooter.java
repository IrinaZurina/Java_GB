package org.example.units;

public abstract class Shooter extends BaseHero{
    protected int arrows;
    protected int maxArrows;
    protected int accuracy;
    public Shooter(float hp, String name, int x, int y, int armor, int[] damage, int pace, String class_name, int arrows, int accuracy) {
        super(hp, name, x, y, armor, damage, pace, class_name);
        this.arrows = this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(){
        System.out.println("Shoot!");
    }

    @Override
    public void step() {
        System.out.println("Shooter");
    }
}
