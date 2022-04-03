package edu.jijumbeck.jigsawpuzzle.model;

public class Cell {
    private boolean isOccupied = false;

    void setOccupied() {
        isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
