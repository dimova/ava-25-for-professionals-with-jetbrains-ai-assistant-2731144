package com.linkedin.flexibleconstructors.solution;

public class Demo {
    void main(String[] args) {
        System.out.println("=== Test 1: Valid electric car (FAST charging) ===");
        try {
            ElectricCar car1 = new ElectricCar("ABC-123", 2022, 85);
            System.out.println("Success! Charging type: " + car1.getChargingType());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 2: Valid electric car (STANDARD charging) ===");
        try {
            ElectricCar car2 = new ElectricCar("DEF-456", 2020, 60);
            System.out.println("Success! Charging type: " + car2.getChargingType());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 3: Invalid year (fails fast) ===");
        try {
            ElectricCar car3 = new ElectricCar("XYZ-789", 2005, 60);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 4: Invalid battery capacity (fails fast) ===");
        try {
            ElectricCar car4 = new ElectricCar("GHI-012", 2023, 250);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 5: Battery capacity too low (fails fast) ===");
        try {
            ElectricCar car5 = new ElectricCar("JKL-345", 2021, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
