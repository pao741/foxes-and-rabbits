package io.muzoo.ooc.ecosystems.Entities;

import io.muzoo.ooc.ecosystems.*;

public abstract class Entities {
    Location location;
    boolean alive;

    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }
    void setLocation(Location location) {
        this.location = location;
    }
    abstract Location getLocation();
}
