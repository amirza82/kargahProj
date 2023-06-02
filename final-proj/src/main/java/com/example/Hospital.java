package com.example;

import java.util.List;
import java.util.Scanner;

public class Hospital {

    private static List<Person> staff;
    private static List<Person> patients;
     
    
    public static List<Person> getStaff() {
        return staff;
    }
    public static void setStaff(List<Person> staff) {
        Hospital.staff = staff;
    }
    public static List<Person> getPatients() {
        return patients;
    }
    public static void setPatients(List<Person> patients) {
        Hospital.patients = patients;
    }
    
    //-----------------------Get By ID--------------------------------

    public static Person getStaffByID(Integer ID) {
        for (Person person : staff) {
            if (person.getID().equals(ID)) {
                return person;
            }
        }
        return null;
    }

    public static Person getPatientByID(Integer ID) {
        for (Person person : patients) {
            if (person.getID().equals(ID)) {
            return person;    
            }
        }
        return null;
    }

    //---------------------------Registeration--------------------------------

    public static void registerStaff(Person Persin) {
        staff.add(Persin);
    }

    public static void registerPatient(Person persons){
        patients.add(persons);
    }

    //---------------------------Doctor methods--------------------------------

    public static void newVisit(Doctor doctor, Patient patient){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the prescription for this patient.\nThe patient info is as follows: \n\n");
        patient.print();
        System.out.print("Prescription: ");
        patient.addPrescription(new Prescription(scanner.nextLine(), doctor.getID(), patient.getID()));
        scanner.close();
    }
    
    public static void changePatientDescription(Doctor doctor, Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new description: ");
        patient.setDescription(scanner.nextLine());
        scanner.close();
    }




}