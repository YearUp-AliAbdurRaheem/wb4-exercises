package com.pluralsight;

import java.util.Objects;

public class Reservation {
    // Private attributes
    private String RoomType;
    private int numberOfNights;
    private boolean isWeekend;

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        if (roomType == null) {
            throw new IllegalArgumentException("RoomType Cannot Be Null!");
        }
        roomType = roomType.strip();
        roomType = roomType.stripLeading();
        roomType = roomType.toLowerCase();
        if (!roomType.equalsIgnoreCase("king")
                &&
            !roomType.equalsIgnoreCase("double")) {
            throw new IllegalArgumentException("Invalid RoomType: " + roomType);
        }
        this.RoomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        if (numberOfNights < 0) {
            throw new IllegalArgumentException("NumberOfNights Cannot Be Negative!");
        }
        if (isWeekend && numberOfNights > 2) {
            throw new IllegalArgumentException("Too long of weekend: " + numberOfNights);
        }
        if (isWeekend && numberOfNights < 1) {
            throw new IllegalArgumentException("Too short of weekend: " + numberOfNights);
        }

        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }


    public double getPrice() {
        return RoomType.equalsIgnoreCase("king") ?
                    139.00
                    :
                    124.00;
    }

    public double getReservationTotal() {
        return isWeekend ?
                (getPrice() + (getPrice() / 10)) * numberOfNights
                :
                getPrice() * numberOfNights;
    }
}
