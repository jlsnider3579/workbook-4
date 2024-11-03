package com.pluralsight.dealership;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
    Dealership dealership;
    Scanner s = new Scanner(System.in);
    DealershipFileManager fileManager;

    private void displayDealershipMenu() {
        System.out.println("""
                1 ) Find Vehicles Within a Price Range
                2 ) Find Vehicles by make / model
                3 )Find vehicles by year range
                4 ) Find vehicles by color
                5 ) Find vehicles by mileage range
                6 ) Find vehicles by type (car, truck, SUV, van)
                7 ) List all Vehicles
                8 ) Add a vehicle
                9 ) Remove a vehicle
                x ) Quit
                """);

    }

    public void display() throws IOException {
        init();
        String choice;
        do {
            displayDealershipMenu();
            choice = userMenuPrompt(s);

            switch (choice.toLowerCase()) {
                case "1":
                    PriceRange();
                    break;
                case "2":
                    makeModel();
                    break;
                case "3":
                    getYear();
                    break;
                case "4":
                    getColor();
                    break;
                case "5":
                    getMileage();
                    break;
                case "6":
                    getType();
                    break;
                case "7":
                    getAllVehicles();
                    break;
                case "8":
                    getAddedVehicle();
                    break;
                case "9":
                    getRemovedVehicle();
                    break;
                case "x":
                    System.out.println("Exiting... ");
                    break;
                default:
                    System.out.println("Invalid response please choose on of the following above ");

            }


        } while (!choice.equalsIgnoreCase("x"));

    }

    private void init() {

        fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        if (this.dealership != null) {
            System.out.println("Dealership loaded");

        } else {
            System.out.println("Dealership not loaded");
        }
    }

    private void PriceRange() {
        double min;
        double max;

        System.out.println("Input minimum price");
        min = Double.parseDouble(s.nextLine());
        System.out.println("Input maximum price");
        max = Double.parseDouble(s.nextLine());

        if (min > max) {
            double m = min;
            min = max;
            max = m;

        }
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice((int) min, (int) max);
        displayVehicles(vehicles);

    }

    private void makeModel() {
        String make;
        String model;

        System.out.println("Input Vehicle make ");
        make = s.nextLine().trim().toLowerCase();
        System.out.println("Input vehicle model ");
        model = s.nextLine().trim().toLowerCase();
        List<Vehicle> vehiclesMakeModel = dealership.getVehiclesByMakeModel(make, model);

        if (vehiclesMakeModel.isEmpty()) {
            System.out.println("no vehicles of that make and model ");
        } else {
            displayVehicles(vehiclesMakeModel);
        }
    }

    public void getYear() {
        String input;

        System.out.println("Please enter minimum year ");
        input = s.nextLine().trim();
        int min = getPosInt(input);
        if (min == -1)
            return;

        System.out.println("Please enter maximum year ");
        input = s.nextLine().trim();
        int max = getPosInt(input);
        if (max == -1) ;

        List<Vehicle> vehiclesYear = dealership.getVehiclesByYear(min, max);
        if (vehiclesYear.isEmpty()) {
            System.out.println("Sorry there are no Vehicles within these years ");
        } else {
            displayVehicles(vehiclesYear);
        }
    }

    public void getColor() {
        String color;

        System.out.println(" please enter a color you're looking for ");
        color = s.nextLine().trim();

        List<Vehicle> vehiclesColor = dealership.getVehiclesByColor(color);
        if (vehiclesColor.isEmpty()) {
            System.out.println("Sorry there are no vehicles with the specified color ");
        } else {
            displayVehicles(vehiclesColor);
        }
    }

    public void getMileage() {
        String input;

        System.out.print("Please enter preferred minimum mileage ");
        input = s.nextLine().trim();
        int min = getPosInt(input);
        if (min == -1)
            return;

        System.out.print("Please enter preferred maximum mileage: ");
        input = s.nextLine().trim();
        int max = getPosInt(input);
        if (max == -1)
            return;


        List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(min, max);
        if (vehiclesByMileage.isEmpty()) {
            System.out.println("Sorry there are no vehicles within that mileage range...");
        } else {
            displayVehicles(vehiclesByMileage);
        }
    }

    public void getType() {
        String vehicleType;

        System.out.println("Please enter a Vehicle type ");
        vehicleType = s.nextLine().trim();

        List<Vehicle> vehiclesType = dealership.getVehiclesByType(vehicleType);
        if (vehiclesType.isEmpty()) {
            System.out.println("Sorry there are no vehicles of that type ");
        } else {
            displayVehicles(vehiclesType);
        }
    }

    public void getAllVehicles() {
        if (dealership != null) {
            ArrayList<Vehicle> vehicles = this.dealership.getAllVehicles();
            displayVehicles(vehicles);
        } else {
            System.out.println("This dealership is empty.");
        }
    }

    public void getAddedVehicle() throws IOException {
        String input;
        int vin;
        String make;
        String model;
        int year;
        String type;
        String color;
        int mileage;
        double price;


        System.out.println("Please enter the Vehicle vin number");
        input = s.nextLine().toLowerCase().trim();
        vin = getPosInt(input);

        System.out.println("Please enter vehicle year ");
        input = s.nextLine().toLowerCase().trim();
        year = getPosInt(input);

        System.out.println("Please enter vehicle make ");
        make = s.nextLine().toLowerCase().trim();


        System.out.println("Please enter vehicle model ");
        model = s.nextLine().toLowerCase().trim();


        System.out.println("Please enter vehicle type ");
        type = s.nextLine().toLowerCase().trim();


        System.out.println("Please enter vehicle color ");
        color = s.nextLine().toLowerCase().trim();


        System.out.println("Please enter vehicle mileage ");
        input = s.nextLine().toLowerCase().trim();
        mileage = getPosInt(input);

        System.out.println("Enter vehicle price ");
        input = s.nextLine().toLowerCase().trim();
        price = getPosInt(input);

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        dealership.addVehicle(vehicle);

        System.out.println("Vehicle has successfully been added ");
        new DealershipFileManager().saveDealership(dealership);
    }


    public void getRemovedVehicle() throws IOException {
        int vin;

        System.out.println("Please enter the vehicle vin number to remove ");
        vin = getPosInt(s.nextLine());
        dealership.RemoveVehicles(dealership.getVehiclesByVin(vin).get(0));

        System.out.println("Vehicle has been successfully removed from inventory ");
        new DealershipFileManager().saveDealership(dealership);
    }

    private String userMenuPrompt(Scanner s) {
        System.out.println("Enter your choice");
        return s.nextLine().trim();
    }

    public void displayVehicles(List<Vehicle> inventory) {
        for (Vehicle v : inventory) {
            System.out.println(v);
        }
    }

    public int getPosInt(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number > 0) {  // Ensure the number is positive
                return number;
            } else {
                System.out.println("Please enter a positive integer.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        return -1; // Return -1 if the input is invalid
    }

}


