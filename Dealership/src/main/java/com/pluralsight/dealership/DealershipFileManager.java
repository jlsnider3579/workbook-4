package com.pluralsight.dealership;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    public Dealership getDealership() {
        ArrayList<Vehicle> inventory = new ArrayList<>();
        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input;

            // reads first line of dealership file
            if ((input = bufferedReader.readLine()) != null) {
                String[] dealerShipInfo = input.split("\\|");
                if (dealerShipInfo.length != 3) {
                    System.out.println("Invalid dealership format");
                    return null;
                }
                String name = dealerShipInfo[0];
                String address = dealerShipInfo[1];
                String phoneNumber = dealerShipInfo[2];

                // initialize the dealership object
                dealership = new Dealership(name, address, phoneNumber, inventory);
            } else {
                System.out.println("dealership file is empty");
                return null;
            }


            while ((input = bufferedReader.readLine()) != null) {
                String[] vehicleData = input.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);

            }
            bufferedReader.close();
            return dealership;
        } catch (Exception e) {
            System.out.println("error reading file");
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealerShip) throws IOException {
        try {
            FileWriter fr = new FileWriter("src/main/resources/inventory.csv");
            BufferedWriter br = new BufferedWriter(fr);
            for (Vehicle vehicle: dealerShip.getAllVehicles()){
                br.write(vehicle.toString());

            }
            br.close();

        } catch (Exception e) {


        }
    }
}



