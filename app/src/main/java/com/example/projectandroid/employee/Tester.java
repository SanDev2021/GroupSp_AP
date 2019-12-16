package com.example.projectandroid.employee;

import com.example.projectandroid.vehicle.Vehicle;

public class Tester extends Employee {
    private static final int GAIN_FACTOR_ERROR = 10;
    private Integer nbBugs;

    public Tester(String firstName, String lastName, Integer birthYear, Double monthlySalary, Integer rate, Integer employeeId, Vehicle vehicle, Integer nbBugs) {
        super(firstName, lastName, birthYear, monthlySalary, rate, employeeId, vehicle);
        this.nbBugs = nbBugs;
    }

    @Override
double annualIncome(){return getSalary()+(nbBugs* GAIN_FACTOR_ERROR);}
@Override
String getTask(){ return  String.format("He/She has completed %d bugs", nbBugs);}
}
