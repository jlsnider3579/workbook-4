package com.pluralsight.dealership;

import com.pluralsight.dealership.Contract;

// A subclass of Contract representing a lease contract
public class LeaseContract extends Contract {
    private double expectedEndingValue; // 50% of the vehicle price at the end of the lease
    private double leaseFee;            // Lease fee set at 7% of the vehicle price

    // Constructor to initialize LeaseContract-specific fields along with the common fields
    public LeaseContract(String customerName, String customerEmail, String vehicleSold, double vehiclePrice) {
        super(customerName, customerEmail, vehicleSold, vehiclePrice);
        this.expectedEndingValue = vehiclePrice * 0.5; // Expected vehicle value at lease end
        this.leaseFee = vehiclePrice * 0.07;           // Lease fee
    }

    // Calculates the total lease price, including vehicle price, ending value, and lease fee
    @Override
    public double getTotalPrice() {
        return vehiclePrice + expectedEndingValue + leaseFee;
    }

    // Calculates the monthly payment based on a 4% interest rate over 36 months
    @Override
    public double getMonthlyPayment() {
        return getTotalPrice() * 0.04 / 36;
    }

    // Getters for lease-specific details
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }
}



