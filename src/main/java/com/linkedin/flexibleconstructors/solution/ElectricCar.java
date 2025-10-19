package com.linkedin.flexibleconstructors.solution;

public class ElectricCar extends Vehicle {
    private int batteryCapacity;  // in kWh
    private String chargingType;  // "FAST" or "STANDARD"

    public ElectricCar(String licensePlate, int year, int batteryCapacity) {
        // PROLOGUE - Code before super()

        // 1. Validate year (fail fast!)
        if (year < 2010) {
            throw new IllegalArgumentException("Year must be 2010 or later");
        }

        // 2. Validate battery capacity (fail fast!)
        if (batteryCapacity < 40 || batteryCapacity > 200) {
            throw new IllegalArgumentException(
                    "Battery capacity must be between 40 and 200 kWh");
        }

        // 3. Initialize batteryCapacity field
        this.batteryCapacity = batteryCapacity;

        // 4. Initialize chargingType field based on capacity
        this.chargingType = (batteryCapacity >= 75) ? "FAST" : "STANDARD";

        // Call superclass constructor
        super(licensePlate, year);

        // EPILOGUE - Code after super()

        // Print configuration message
        System.out.println("Electric car configured with " + batteryCapacity +
                " kWh battery and " + chargingType + " charging");
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getChargingType() {
        return chargingType;
    }
}
