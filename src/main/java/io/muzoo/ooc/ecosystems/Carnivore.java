package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;

public abstract class Carnivore extends Animal {

    private void incrementHunger() {
        setFoodLevel(  getFoodLevel()-1);
        if (getFoodLevel() <= 0) {
            alive = false;
        }
    }
    private Location findFood(Field field, Location location) {
        Iterator adjacentLocations =
                field.adjacentLocations(location);
        while (adjacentLocations.hasNext()) {
            Location where = (Location) adjacentLocations.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setEaten();
                    setFoodLevel( getRabbitFoodValue());
                    return where;
                }
            }
        }
        return null;
    }
    public void hunt(Field currentField, Field updatedField, List newFoxes) {
        incrementAge();
        incrementHunger();
        if (alive) {
            // New foxes are born into adjacent locations.
            int births = breed();
            for (int b = 0; b < births; b++) {
                Fox newFox = new Fox(false);
                newFoxes.add(newFox);
                Location loc = updatedField.randomAdjacentLocation(getLocation());
                newFox.setLocation(loc);
                updatedField.place(newFox, loc);
            }
            // Move towards the source of food if found.
            Location newLocation = findFood(currentField, getLocation());
            if (newLocation == null) {  // no food found - move randomly
                newLocation = updatedField.freeAdjacentLocation(getLocation());
            }
            if (newLocation != null) {
                setLocation(newLocation);
                updatedField.place(this, newLocation);
            } else {
                // can neither move nor stay - overcrowding - all locations taken
                alive = false;
            }
        }
    }

    abstract int getRabbitFoodValue();
    abstract int getFoodLevel();
    abstract void setFoodLevel(int foodLevel);

}
