package com.pluralsight.dealership;

// Base abstract class for different types of contracts
public abstract class Contract {
    protected String customerName;  // The name of the customer
    protected String customerEmail; // The customer's email
    protected String vehicleSold;   // Details about the vehicle
    protected double vehiclePrice;  // Price of the vehicle

    // Constructor to initialize common fields for all contracts
    public Contract(String customerName, String customerEmail, String vehicleSold, double vehiclePrice) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.vehiclePrice = vehiclePrice;
    }

    // Abstract method to get the total price of the contract
    public abstract double getTotalPrice();

    // Abstract method to calculate the monthly payment
    public abstract double getMonthlyPayment();

    // Getters for accessing common contract properties
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }
}
