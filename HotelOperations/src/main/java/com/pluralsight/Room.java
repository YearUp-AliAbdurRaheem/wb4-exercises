package com.pluralsight;

public class Room {
    // Private attributes
    private final int NUMBER_OF_BEDS;
    private final double PRICE;
    private final boolean OCCUPIED;
    private final boolean DIRTY;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        NUMBER_OF_BEDS = numberOfBeds;
        PRICE = price;
        OCCUPIED = occupied;
        DIRTY = dirty;
    }

    public int getNUMBER_OF_BEDS() {
        return NUMBER_OF_BEDS;
    }

    public double getPRICE() {
        return PRICE;
    }

    public boolean isOCCUPIED() {
        return OCCUPIED;
    }

    public boolean isDIRTY() {
        return DIRTY;
    }

    public boolean isAvailable() {
        return OCCUPIED && DIRTY;
    }
}
