package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Employee(0, "Ali", "Ali", 10, 41).getTotalPay());
        Room room1 = new Room(1, 1, false, false);
        Room room2 = new Room(1, 1, false, true);
        Room room3 = new Room(1, 1, true, false);
        Room room4 = new Room(1, 1, true, true);

        try {
            System.out.println("Room one:"); room1.checkIn();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Room 1 is " + (room1.isOccupied() ? "occupied" : "unoccupied") + '.'); // Tests is code ran after exception was thrown
        }
        try {
            System.out.println("Room two:"); room2.checkIn();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Room 2 is " + (room2.isOccupied() ? "occupied" : "unoccupied") + '.');
        }
        try {
            System.out.println("Room three:"); room3.checkIn();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Room 3 is " + (room3.isOccupied() ? "occupied" : "unoccupied") + '.');
        }
        try {
            System.out.println("Room four:"); room4.checkIn();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Room 4 is " + (room4.isOccupied() ? "occupied" : "unoccupied") + '.');
        }


        Employee employee1 = new Employee(0, "Ali", "Ali", 10, 41);
        try {
            System.out.println("Employee one PunchOut test:"); employee1.punchOut(0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(new Employee(0, "Ali", "Python", 10, 41).getLocalPunchInTime());

    }
}