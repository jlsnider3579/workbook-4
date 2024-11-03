package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private final String address;
    private String phoneNumber;
    private ArrayList<com.pluralsight.car.dealership.Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber, ArrayList<com.pluralsight.car.dealership.Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }

    public void addVehicle(com.pluralsight.car.dealership.Vehicle vehicle){
        inventory.add(vehicle);
    }

    public ArrayList<com.pluralsight.car.dealership.Vehicle> getAllVehicles(){
        if(inventory.isEmpty()){
            System.out.println("No vehicles available at the moment.");
        } else {
            System.out.println("Vehicles available at " + name + ": ");
            for(com.pluralsight.car.dealership.Vehicle vehicle : inventory){
                System.out.println(vehicle);
            }

        }
        return inventory;
    }

    public ArrayList<com.pluralsight.car.dealership.Vehicle> getVehiclesByPrice(int min, int max){
        ArrayList<com.pluralsight.car.dealership.Vehicle> filteredVehiclesByPrice = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredVehiclesByPrice.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByPrice);

        return filteredVehiclesByPrice; // Return the filtered list
    }

    public ArrayList<com.pluralsight.car.dealership.Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<com.pluralsight.car.dealership.Vehicle> filteredVehiclesByMakeModel = new ArrayList<>();

        for (com.pluralsight.car.dealership.Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                filteredVehiclesByMakeModel.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByMakeModel);
        return filteredVehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> filteredVehiclesByYear = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                filteredVehiclesByYear.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByYear);

        return filteredVehiclesByYear;

    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> filteredVehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getColor().equalsIgnoreCase(color)){
                filteredVehiclesByColor.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByColor);

        return filteredVehiclesByColor;
    }

    public ArrayList<com.pluralsight.car.dealership.Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<com.pluralsight.car.dealership.Vehicle> filteredVehiclesByMileage = new ArrayList<>();
        for(com.pluralsight.car.dealership.Vehicle vehicle : inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredVehiclesByMileage.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByMileage);
        return filteredVehiclesByMileage;
    }

    public ArrayList<com.pluralsight.car.dealership.Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<com.pluralsight.car.dealership.Vehicle> filteredVehiclesByType = new ArrayList<>();
        for(com.pluralsight.car.dealership.Vehicle vehicle : inventory) {
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                filteredVehiclesByType.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByType);
        return filteredVehiclesByType;
    }

    public com.pluralsight.car.dealership.Vehicle findVehicleByVin(int vin){
        com.pluralsight.car.dealership.Vehicle vehicle = null;
        for(com.pluralsight.car.dealership.Vehicle v : inventory) {
            if(vehicle.getVin() == v.getVin()) {
                vehicle = v;
            }
        }
        return vehicle;
    }

    public void removeVehicle(com.pluralsight.car.dealership.Vehicle v){

        inventory.remove(v);

    }

    public void noMatchCaseHandling(ArrayList<com.pluralsight.car.dealership.Vehicle> vehicles){
        if(vehicles.toArray().length < 1) {
            System.out.println("No matching vehicles.");
        }
    }

    @Override
    public String toString() {
        return String.format("Dealership: %s, Address: %s, Phone Number: %s \n Inventory: \n%s",
                name,address,phoneNumber,inventory);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<com.pluralsight.car.dealership.Vehicle> getInventory() {
        return inventory;
    }
}
