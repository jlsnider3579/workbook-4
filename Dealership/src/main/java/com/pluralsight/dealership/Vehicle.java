package com.pluralsight.dealership;

    public class Vehicle {
        private int vin;
        private int year;
        private String make;
        private String model;
        private String vehicle;
        private String color;
        private int odometer;
        private double price;

        public int getVin() {
            return vin;
        }

        public int getYear() {
            return year;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public String getVehicle() {
            return vehicle;
        }

        public String getColor() {
            return color;
        }

        public int getOdometer() {
            return odometer;
        }

        public double getPrice() {
            return price;
        }

        public Vehicle(int vin, int year, String make, String model, String vehicle, String color, int odometer, double price) {
            this.vin = vin;
            this.year = year;
            this.make = make;
            this.model = model;
            this.vehicle = vehicle;
            this.color = color;
            this.odometer = odometer;
            this.price = price;

        }
    }

