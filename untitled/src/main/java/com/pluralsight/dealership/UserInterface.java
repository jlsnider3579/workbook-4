package com.pluralsight.car.dealership;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership;
    static Scanner scanner = new Scanner(System.in);
    public void display(){
        init();
        String choice;

        do {
            displayDealershipMenu();
            choice = usersMenuInput(scanner);

            switch (choice.toLowerCase()){
                case "1":
                    processGetAllVehiclesRequest();
                    break;
                case "2":
                    processGetByPriceRequest();
                    break;
                case "3":
                    processGetByMakeModelRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetByYearRequest();
                    break;
                case "8":
                    System.out.println("Add a vehicle");
                    break;
                case "9":
                    System.out.println("Remove a vehicle");
                    break;
                case "x":
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Invalid input try again.");
            }

        } while (!choice.equalsIgnoreCase("x"));
        scanner.close();
    }

    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        if(this.dealership != null){
            System.out.println("dealership loaded");
        } else {
            System.out.println("dealership not loaded, check file");
        }
    }

    private String usersMenuInput( Scanner scanner) {
        System.out.print("Enter your command: ");
        return scanner.nextLine().trim();
    }

    private String promptMethod(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    private void displayDealershipMenu() {
        System.out.println("""
                1 ) List all Vehicles
                2 ) Find Vehicles Within a Price Range
                3 ) Find Vehicles by make / model
                4 ) Find vehicles by color
                5 ) Find vehicles by mileage range
                6 ) Find vehicles by type (car, truck, SUV, van)
                7 ) Find vehicles by year range
                8 ) Add a vehicle
                9 ) Remove a vehicle
                x ) Quit
                """);
    }

    private void displayVehicles(ArrayList<Vehicle> inventory){
        for (Vehicle v : inventory){
            System.out.println(v);
        }
    }

    public void processGetByPriceRequest(){
        int min = Integer.parseInt(promptMethod("Enter minimum Value"));
        int max = Integer.parseInt(promptMethod("Enter maximum Value"));

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByPrice(min,max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest(){
        String userMakeQuery = promptMethod("What car make are you looking for?");
        String userModelQuery = promptMethod("What car model are you looking for?");
        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByMakeModel(userMakeQuery,userModelQuery);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest(){
        int min = Integer.parseInt(promptMethod("Enter minimum year"));
        int max = Integer.parseInt(promptMethod("Enter maximum year"));

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByYear(min,max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest(){
        String colorQuery = promptMethod("Enter vehicle color.");
        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByColor(colorQuery);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest(){
        int min = Integer.parseInt(promptMethod("Enter minimum mileage"));
        int max = Integer.parseInt(promptMethod("Enter maximum mileage"));

        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByMileage(min,max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest(){
        String vehicleTypeQuery = promptMethod(" Enter vehicle by type (car, truck, SUV, van)");
        ArrayList<Vehicle> vehicles = this.dealership.getVehiclesByType(vehicleTypeQuery);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest(){
        if(dealership != null) {
            ArrayList<Vehicle> vehicles = this.dealership.getAllVehicles();
            displayVehicles(vehicles);
        }
        else{
            System.out.println("This dealership is empty.");
        }
    }

    public void processAddVehicleRequest(){

    }

    public void processRemoveVehicleRequest(){
        String vinQueryToDelete = promptMethod("Insert VIN number for vehicle that you want to delete.");
        Vehicle vehicle = this.dealership.findVehicleByVin(Integer.parseInt(vinQueryToDelete));


    }




}
