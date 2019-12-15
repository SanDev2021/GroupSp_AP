package com.example.projectandroid.employee;

import com.example.projectandroid.vehicle.Vehicle;

public class Manager extends Employee {
    private static final int GAIN_FACTOR_CLIENT = 500;
    private static final int GAIN_FACTOR_TRAVEL = 100;
    private Integer nbClient;

    public Manager(String firstName, String lastName, Integer birthYear, Double monthlySalary, Integer rate, Integer employeeId, Vehicle vehicle, Integer nbClient) {
        super(firstName, lastName, birthYear, monthlySalary, rate, employeeId, vehicle);
        this.nbClient = nbClient;
    }

    @Override
    double annualIncome() {
        return getSalary() + (nbClient * GAIN_FACTOR_CLIENT) + GAIN_FACTOR_TRAVEL;
    }

    @Override
    String getTask() {
        return String.format("He/She has brought %d new clients", nbClient);
    }


}
