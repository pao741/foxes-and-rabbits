package io.muzoo.ooc.ecosystems;

import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2002.10.28
 */
public class Rabbit extends Animal{
    // Characteristics shared by all rabbits (static fields).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 50;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.15;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 5;
    // A shared random number generator to control breeding.
    private static final Random rand = new Random();

    // Individual characteristics (instance fields).

    private boolean alive;
    // The rabbit's position
//    private Location location;

    public Rabbit(boolean randomAge) {
        age = 0;
        alive = true;
        if (randomAge) {
            age = rand.nextInt(MAX_AGE);
        }
    }
    public void run(Field updatedField, List newRabbits) {
        incrementAge();
        if (alive) {
            int births = breed();
            for (int b = 0; b < births; b++) {
                Rabbit newRabbit = new Rabbit(false);
                newRabbits.add(newRabbit);
                Location loc = updatedField.randomAdjacentLocation(location);
                newRabbit.setLocation(loc);
                updatedField.place(newRabbit, loc);
            }
            Location newLocation = updatedField.freeAdjacentLocation(location);
            // Only transfer to the updated field if there was a free location
            if (newLocation != null) {
                setLocation(newLocation);
                updatedField.place(this, newLocation);
            } else {
                // can neither move nor stay - overcrowding - all locations taken
                alive = false;
            }
        }
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
    Location getLocation() {
        return location;
    }

    public boolean isAlive() {
        return alive;
    }
    public void setEaten() {
        alive = false;
    }
//    void setLocation(int row, int col) {
//        this.location = new Location(row, col);
//    }
//    void setLocation(Location location) {
//        this.location = location;
//    }
}