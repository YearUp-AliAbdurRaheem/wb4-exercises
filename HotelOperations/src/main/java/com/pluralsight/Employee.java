package com.pluralsight;

public class Employee {
    private int EID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private int regularHours = 40;

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    private double overtimeRate = 1.5;

    public Employee(int EID,
                    String name,
                    String department,
                    double payRate,
                    double hoursWorked) {
        this.EID = EID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Derived Getters
    public double getTotalPay() {
        return (hoursWorked > regularHours) ?
                getOvertimeHours() * (payRate * overtimeRate)
                :
                (hoursWorked * payRate);
    }

    public double getOvertimeHours() {
        return hoursWorked > regularHours ?
                hoursWorked - regularHours :
                0;
    }

    // Getters
    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getRegularHours() {
        return regularHours;
    }

    public void setRegularHours(int regularHours) {
        this.regularHours = regularHours;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }
}
