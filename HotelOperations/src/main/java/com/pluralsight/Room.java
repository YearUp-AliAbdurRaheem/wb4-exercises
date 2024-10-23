package com.pluralsight;

public class Room {
    // Private attributes
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        occupied = isOccupied;
        dirty = isDirty;
    }

    public void checkIn() throws Exception {
        if (occupied || dirty) {
            throw new Exception("Error: The room is " +
                    (occupied ? "occupied" : "") +
                    (occupied && dirty ? " and " : "") +
                    (dirty ? "dirty" : "") +
                    ".");
        }
        occupied = dirty = true;
    }

    public void checkOut() throws Exception {
        if (!occupied) {
            throw new Exception("Error: The room is unoccupied.");
        }
        occupied = false;
        dirty = true;
    }

    public void cleanRoom() {
        dirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return occupied && dirty;
    }
}
