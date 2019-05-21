package io.muzoo.ooc.ecosystems.Entities;

import io.muzoo.ooc.ecosystems.Location;

public class Hunter extends Actor {
    private static final int RABBIT_HUNT_VALUE = 1;
    private int huntLevel;

    Hunter(){
        huntLevel = RABBIT_HUNT_VALUE;
    }

    public int getRabbitHuntValue() {
        return RABBIT_HUNT_VALUE;
    }

    @Override
    public void setHuntLevel(int huntLevel) {
        this.huntLevel = huntLevel;
    }

    @Override
    Location getLocation() {
        return this.location;
    }
}
