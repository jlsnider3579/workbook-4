package com.pluralsight.dealership;

import com.pluralsight.dealership.Contract;

// A subclass of Contract representing a sales contract
public class SalesContract extends Contract {
    private double salesTax;       // Sales tax applied to the vehicle price
    private double recordingFee;   // Fixed fee for recording the sale
    private double processingFee;  // Processing fee based on vehicle price
    private boolean wantToFinance; // Whether the customer wants to finance the purchase

    // Constructor to initialize SalesContract-specific fields along with the common fields
    public SalesContract(String customerName, String customerEmail, String vehicleSold, double vehiclePrice, double salesTax, double recordingFee, boolean wantToFinance) {
        super(customerName, customerEmail, vehicleSold, vehiclePrice);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        // Processing fee is higher for vehicles priced above $10,000
        this.processingFee = vehiclePrice < 10000 ? 295 : 495;
        this.wantToFinance = wantToFinance;
    }

    // Calculates the total price, including vehicle price, taxes, and fees
    @Override
    public double getTotalPrice() {
        return vehiclePrice + salesTax + recordingFee + processingFee;
    }

    // Calculates the monthly payment based on financing options
    @Override
    public double getMonthlyPayment() {
        if (!wantToFinance) {
            return 0; // No monthly payment if financing is not chosen
        } else if (vehiclePrice >= 10000) {
            return getTotalPrice() * 0.0425 / 48; // 4.25% interest over 48 months for vehicles over $10,000
        } else {
            return getTotalPrice() * 0.0525 / 24; // 5.25% interest over 24 months for vehicles under $10,000
        }
    }

    // Getters for sales-specific details
    public double getSalesTax() {
        return salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isWantToFinance() {
        return wantToFinance;
    }
}
