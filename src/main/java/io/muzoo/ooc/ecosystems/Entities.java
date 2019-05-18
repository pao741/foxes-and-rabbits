package io.muzoo.ooc.ecosystems;

public class Entities {
    Location location;

    void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }
    void setLocation(Location location) {
        this.location = location;
    }
}
