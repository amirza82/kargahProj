package com.example;
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
    public void show_prof() {
        super.show_prof();
    }

    public void print() {
        super.show_prof();
        System.out.println("Department: "+department);
        System.out.println("Profesion: " + profesion);

    }
}
