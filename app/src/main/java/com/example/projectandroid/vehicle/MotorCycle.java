package com.example.projectandroid.vehicle;

public class MotorCycle extends Vehicle {
    private Boolean sideCar;

    public MotorCycle(String make, String plate, String color, String category, Boolean sideCar) {
        super(make, plate, color, category);
        this.sideCar = sideCar;
    }

    @Override
    public String toDisplay() {
        return super.toDisplay() + "\n" +
                (sideCar ? "With" : "without") + "a side car";
    }
}
