package com.example.projectandroid.employee;

import com.example.projectandroid.vehicle.Vehicle;

public class Programmer extends Employee {
    private static final int GAIN_FACTOR_PROJECTS = 200;
    private Integer nbProjects;

    public Programmer(String firstName, String lastName, Integer birthYear, Double monthlySalary, Integer rate, Integer employeeId, Vehicle vehicle, Integer nbProjects) {
        super(firstName, lastName, birthYear, monthlySalary, rate, employeeId, vehicle);
        this.nbProjects = nbProjects;
    }

    @Override
    double annualIncome() {
        return getSalary() + (nbProjects * GAIN_FACTOR_PROJECTS);
    }

    @Override
    String getTask() {
        return String.format("He/She has completed %d projects", nbProjects);
    }
}