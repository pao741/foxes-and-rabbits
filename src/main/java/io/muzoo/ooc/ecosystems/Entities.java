package io.muzoo.ooc.ecosystems;

public abstract class Entities {
    Location location;
    boolean alive;

    void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }
    void setLocation(Location location) {
        this.location = location;
    }
    abstract Location getLocation();
}
