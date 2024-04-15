package com.example.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double mark;

    public Student(){}

    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }



    public void printInfo(){
        System.out.printf("%3d | %-10s %-10s | %.2f\n", getId(), getFirstName(), getLastName(), getMark());
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMark() {
        return mark;
    }
}
