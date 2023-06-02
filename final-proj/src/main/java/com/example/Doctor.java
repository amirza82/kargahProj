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

    public void examinate(Patient patient, Doctor doctor){

        System.out.println("Enter the prescription:\n");
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        scn.close();

        patient.addPrescription(new Prescription(line, doctor.getID(), patient.getID()));
    }

}
