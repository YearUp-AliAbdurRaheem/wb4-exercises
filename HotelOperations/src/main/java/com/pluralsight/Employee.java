package com.pluralsight;

import java.time.Duration;
import java.time.LocalTime;

public class Employee {
    private int EID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private int regularHours = 40;
    private double overtimeRate = 1.5;

    private double punchInTime = -1; // -1 means employee never punched in

    private LocalTime localPunchInTime;

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

    public void punchIn(double punchInTime) {
        this.punchInTime = punchInTime;
    }

    public void punchOut(double punchOutTime) throws Exception {
        if (this.punchInTime == -1) {
            throw new Exception("Error: Employee cannot punch out before punching in.");
        }
        hoursWorked += punchOutTime - punchInTime;
        this.punchInTime = -1;
    }

    public void punchTimeSheet(double punchInTime, double punchOutTime) {
        hoursWorked += punchOutTime - punchInTime;
        this.punchInTime = -1;
    }

    public void punchIn() {
        localPunchInTime = LocalTime.now();
    }

    public void punchOut() throws Exception {
        if (localPunchInTime == null) {
            throw new Exception("Error: Employee cannot punch out before punching in.");
        }
        hoursWorked += Duration.between(localPunchInTime, LocalTime.now()).toHours();
    }

    // Derived Getters
    public double getTotalPay() {
        return (hoursWorked > regularHours) ?
                (regularHours * payRate) + ((getOvertimeHours() * payRate) * overtimeRate)
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

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }
}
