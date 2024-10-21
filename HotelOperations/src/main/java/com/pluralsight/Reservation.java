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
                getPrice() + (getPrice() / 10)
                :
                getPrice();
    }
}
