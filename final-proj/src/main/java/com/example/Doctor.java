package com.example;

import java.util.Scanner;

public class Doctor extends Nurse{
    private String profesion;

    public Doctor(String name, String phoneNumber, String address, int ID, String email, String profesion, String password) {
        super(name, phoneNumber, address, ID, email, password);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Profesion" + profesion);
    }

}
