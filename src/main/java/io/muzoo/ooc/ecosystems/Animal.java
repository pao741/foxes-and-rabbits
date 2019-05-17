package io.muzoo.ooc.ecosystems;

import java.util.Random;

public abstract class Animal {
    boolean alive;
    int age;
    private static final Random rand = new Random();

    public boolean isAlive() {
        return alive;
    }
    protected int breed() {
        int births = 0;
        if (canBreed() && rand.nextDouble() <= getBreedingProb()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }
    protected boolean canBreed() {
        return age >= getBreedingAge();
    }
    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            alive = false;
        }
    }
    abstract int getMaxAge();
    abstract int getBreedingAge();
    abstract double getBreedingProb();
    abstract int getMaxLitterSize();
    abstract Location getLocation();
    abstract void setLocation(Location location);
    abstract void setLocation(int row, int col);
}
