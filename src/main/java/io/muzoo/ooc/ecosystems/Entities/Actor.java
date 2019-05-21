package io.muzoo.ooc.ecosystems.Entities;

import io.muzoo.ooc.ecosystems.Field;
import io.muzoo.ooc.ecosystems.Location;

import java.util.Iterator;

public abstract class Actor extends Entities {
    public void act(Field currentField, Field updatedField) {
        // New foxes are born into adjacent locations.
        // Move towards the source of food if found.
        Location newLocation = findPrey(currentField, getLocation());
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
    private Location findPrey(Field field, Location location) {
        Iterator adjacentLocations =
                field.adjacentLocations(location);
        while (adjacentLocations.hasNext()) {
            Location where = (Location) adjacentLocations.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setEaten();
                    setHuntLevel( getRabbitHuntValue());
                    return where;
                }
            }
        }
        return null;
    }

    public abstract int getRabbitHuntValue();


    public abstract void setHuntLevel(int huntLevel);
}
