package com.example;

import java.util.List;
import java.util.Scanner;

public class Hospital {

    private static List<Person> staff;
    private static List<Person> patients;
    private static Admin admin = new Admin("Admin", "Password");
    
    public static Admin getAdmin() {
        return admin;
    }
    public static void setAdmin(Admin admin) {
        Hospital.admin = admin;
    }
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

    public void examinate(Patient patient, Doctor doctor){

        System.out.println("Enter the prescription:\n");
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        scn.close();

        patient.addPrescription(new Prescription(line, doctor.getID(), patient.getID()));
    }
    
    public static void changePatientDescription(Doctor doctor, Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new description: ");
        patient.setDescription(scanner.nextLine());
        scanner.close();
    }

    public static void discharge(Doctor doctor, Patient patient) {
        Hospital.patients.remove(patient);
    }

    //--------------------------------Admin Methods --------------------------------

    public static void addNurse(String name, String phoneNumber, String address, int ID, String email, String password) {
        Hospital.staff.add(new Nurse(name, phoneNumber, address, ID, email, password));
    }

    public static void addDoctor(String name, String phoneNumber, String address, int ID, String email, String profesion, String password) {
        Hospital.staff.add(new Doctor(name, phoneNumber, address, ID, email, profesion, password));
    }

    //fire a nurse or doctor
    public static void fireStaff(Integer ID_OF_STAFF){
        for (Person staff : Hospital.staff) {
            if(ID_OF_STAFF.equals(staff.getID())) {
                Hospital.staff.remove(staff);
                System.out.println("The employee with ID " + staff.getID() + " has been successfully fired.");
                return;
            }
        }
        System.out.println("No staff with this ID was found.");
    }


}