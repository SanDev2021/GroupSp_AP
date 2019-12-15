package com.example.projectandroid.employee;

import com.example.projectandroid.vehicle.Vehicle;

import java.util.Calendar;

abstract public class Employee {
    private Integer id = 0;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer birthYear;
    private Double monthlySalary;
    private Integer rate;
    private Vehicle vehicle;


    public Employee(String firstName, String lastName, Integer birthYear, Double monthlySalary, Integer rate,Integer employeeId, Vehicle vehicle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;
        this.vehicle = vehicle;
        this.id = employeeId;
        this.age = Calendar.getInstance().get(Calendar.YEAR) - birthYear; //Calculate Age
        if (rate > 100) {
            this.rate = 100;
        } else if (rate < 10) {
            this.rate = 10;
        } else {
            this.rate = rate;
        }
    }



    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Integer getRate() {
        return rate;
    }

    abstract double annualIncome();

    abstract String getTask();

    public String toDisplay() {
        String type = "";
        if (this instanceof Manager) type = "a Manager";
        else if (this instanceof Tester) type = "a Tester";
        else if (this instanceof Programmer) type = "a Programmer";

        String output = "Name: " + firstName + " " + lastName + "," + type + "\n" +
                "Age: " + age + "\n" +
                vehicle.toDisplay() + "\n" +
                "Occupation rate: " + rate + "%" + "\n" +
                "Annual income: $" + annualIncome() + "\n" +
                getTask();
        return output;

    }

    public double getSalary() {
        return monthlySalary * 12 * rate;
    }
}
