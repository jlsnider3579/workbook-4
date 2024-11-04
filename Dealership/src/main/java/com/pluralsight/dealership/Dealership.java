package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles available at the moment.");
        } else {
            System.out.println("Vehicles available at " + name + ": ");
            for (Vehicle vehicle : inventory) {
                System.out.println(vehicle);
            }

        }
        return inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(int min, int max) {
        ArrayList<Vehicle> filteredVehiclesByPrice = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredVehiclesByPrice.add(vehicle);
            }
        }

        return filteredVehiclesByPrice; // Return the filtered list
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream().filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)).toList();
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return inventory.stream().filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream().filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .toList();
    }

    public List<Vehicle> getVehiclesByVin(int vin) {
        return inventory.stream().filter(vehicle -> vehicle.getVin() == vin).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return inventory.stream().filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return inventory.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType)).toList();
    }

    public void RemoveVehicles(Vehicle vehicle) {
        inventory.remove(vehicle);

    }

    public void getByAddedVehicles(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    @Override
    public String toString() {
        return "Dealership{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", inventory=" + inventory + '}';
    }
}




