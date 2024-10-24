package com.pluralsight.hotel;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    // Constructor
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Getter for total pay (including overtime pay)
    public double getTotalPay() {
        double regularHours = getRegularHours();
        double overtimeHours = getOvertimeHours();
        return (regularHours * payRate) + (overtimeHours * payRate * 1.5);
    }

    // Getter for regular hours (up to 40 hours)
    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    // Getter for overtime hours (hours over 40)
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // Additional getters for other fields (if needed)
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
}
