package com.example.projectandroid.vehicle;

public class Vehicle {
    private String make;
    private String plate;
    private String color;
    private String category;

    public Vehicle(String make, String plate, String color,String category) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = category;
    }

    public String toDisplay() {
        return "Employee has a " + category + "\n" +
                "-Model: " + make + "\n" +
                "-Plate: " + plate + "\n" +
                "-Color: " + color + "\n" ;

    }
}
