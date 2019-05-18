package io.muzoo.ooc.ecosystems;

import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * A simple model of a fox.
 * Foxes age, move, eat rabbits, and die.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2002.10.28
 */
public class Fox extends Carnivore{
    // Characteristics shared by all foxes (static fields).

    private static final int BREEDING_AGE = 10;
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.11;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 3;
    // A shared random number generator to control breeding.
    private static final Random rand = new Random();

    // Individual characteristics (instance fields).

    private Location location;
    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Create a fox. A fox can be created as a new born (age zero
     * and not hungry) or with random age.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     */
    public Fox(boolean randomAge) {
        age = 0;
        alive = true;
        if (randomAge) {
            age = rand.nextInt(MAX_AGE);
            foodLevel = rand.nextInt(RABBIT_FOOD_VALUE);
        } else {
            // leave age at 0
            foodLevel = RABBIT_FOOD_VALUE;
        }
    }
    void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }
    void setLocation(Location location) {
        this.location = location;
    }
    @Override
    int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    int getBreedingAge() {
        return BREEDING_AGE;
    }

    @Override
    double getBreedingProb() {
        return BREEDING_PROBABILITY;
    }

    @Override
    int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }
    @Override
    int getRabbitFoodValue() {
        return RABBIT_FOOD_VALUE;
    }

    @Override
    int getFoodLevel() {
        return foodLevel;
    }

    @Override
    Location getLocation() {
        return location;
    }

    @Override
    void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    @Override
    String myClass() {
        return "Fox";
    }

}
