package com.pluralsight.dealership;


import java.util.ArrayList;

public class Dealership {
    private String name;
    private String adress;
    private String phone;
    ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();

    public Dealership(String name, String adress, String phone) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.inventory = inventory;

    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public ArrayList<Vehicle> getVehiclePrice(double min, double max) {
        ArrayList<Vehicle> vehiclesBetweenPriceRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {

            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesBetweenPriceRange.add(vehicle);
            }
        }
        return vehiclesBetweenPriceRange;
    }
    public ArrayList<Vehicle> getVehicleMakeModel(String make, String model) {
        ArrayList<Vehicle> vehiclesMakeModel = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesMakeModel.add(vehicle);
            }

        }
        return vehiclesMakeModel;
    }
    ArrayList<Vehicle> getByYear(int year) {
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getYear() == year);
            vehiclesByYear.add(vehicle);
        }
        return vehiclesByYear;
    }
    ArrayList<Vehicle> vehicleByColor(String color) {
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getColor().equalsIgnoreCase(color));
            vehiclesByColor.add(vehicle);
        }
        return vehiclesByColor;
    }
    ArrayList<Vehicle> getVehicleByMileage(int odometer) {
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getOdometer() <= odometer);
            vehiclesByMileage.add(vehicle);
        }
        return vehiclesByMileage;
    }
    ArrayList<Vehicle> getVehiclesByType(String type) {
       ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
       for (Vehicle vehicle: inventory) {
           if (vehicle.getVehicleType().equalsIgnoreCase(type));
           vehiclesByType.add(vehicle);
       }
       return vehiclesByType;
    }
}


