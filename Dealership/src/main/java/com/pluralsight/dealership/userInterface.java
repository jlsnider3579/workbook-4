package com.pluralsight.dealership;

import java.util.Scanner;

public class userInterface {
    Scanner dScanner = new Scanner(System.in);
    boolean uInput = true;

    public void display() {

            while (uInput) {
                System.out.println("""
                        \nWelcome user to the online dealearship
                        
                        1 - Find vehicles within a price range
                        2 - Find vehicles by make / model
                        3 - Find vehicles by year range
                        4 - Find vehicles by color
                        5 - Find vehicles by mileage range
                        6 - Find vehicles by type (car, truck, SUV, van)
                        7 - List ALL vehicles
                        8 - Add a vehicle
                        9 - Remove a vehicle
                        99 - Quit
                        """);
                String choice = dScanner.nextLine().toUpperCase();
            }
    }
}

