package com.example;

public class Doctor extends Nurse{
    private String profesion;

    public Doctor(String name, String phoneNumber, String address, int ID, String email, String profesion) {
        super(name, phoneNumber, address, ID, email);
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
