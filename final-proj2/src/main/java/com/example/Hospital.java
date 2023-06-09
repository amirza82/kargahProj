package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospital {

    private static List<Person> staff=new ArrayList<>() ;
    private static List<Person> patients=new ArrayList<>();
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

    public static void registerPatient(Person persons) {
        patients.add(persons);
    }

    //---------------------------Doctor methods--------------------------------

    public static void examinate(Patient patient, Doctor doctor) {

        System.out.println("Enter the prescription: ");
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        patient.addPrescription(new Prescription(line, doctor, patient.getID()));
    }

    public static void changePatientDescription(Doctor doctor, Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new description: ");
        String descrip=scanner.nextLine();
        patient.setDescription(descrip);
    }

    public static void discharge(Doctor doctor, Patient patient) {
        Hospital.patients.remove(patient);
    }
    //--------------------------------Admin Methods --------------------------------

    public static void addNurse(String name, String phoneNumber, String address, String email, String password, String department) {
        Hospital.staff.add(new Nurse(name, phoneNumber, address, email, password, department));
    }

    public static void addDoctor(String name, String phoneNumber, String address,  String email, String profesion, String password, String department) {
        Hospital.staff.add(new Doctor(name, phoneNumber, address, email, profesion, password, department));
    }
    public static void addPatient(String name, String phoneNumber, String email, String address, String description) {
        Hospital.patients.add(new Patient(name,phoneNumber,email,address,description));
    }
    //fire a nurse or doctor
    public static<T extends Person> void fireStaff(Integer ID_OF_STAFF,T per) {
        for (Person staff : Hospital.staff) {
            if (per instanceof Doctor && staff.getID()==ID_OF_STAFF && staff instanceof Doctor) {
                Hospital.staff.remove(staff);
                System.out.println("The Doctor "+per.getName()+" with ID " + staff.getID() + " has been successfully fired.");
                return;
            }else
            if (per instanceof Nurse && staff.getID()==ID_OF_STAFF && staff instanceof Nurse) {
                Hospital.staff.remove(staff);
                System.out.println("The Nurse "+per.getName()+" with ID " + staff.getID() + " has been successfully fired.");
                return;
            }
        }
    }

    //--------------------------------Show Patient-------------------------------------
    public static void show_Patient() {
        for (Person patient : patients) {
            patient.show_prof();
            System.out.println("\n\n\n");
        }
    }

    //------------------------------Search By Name---------------------------------------
    public static <T extends Person> List<T> Search_By_Name(List<T> person, String word) {
        List<T> test = new ArrayList<>();
        boolean search2 = true;
        int length = word.length();
        String wordchar;
        String titlechar;
        for (int j = 0; j <= person.size() - 1; j++) {
            search2 = true;
            int length2 = person.get(j).getName().length();
            for (int i = 0; i <= length - 1 && i <= length2 - 1; i++) {
                wordchar = String.valueOf(word.charAt(i));
                titlechar = String.valueOf(person.get(j).getName().charAt(i));
                if (wordchar.equalsIgnoreCase(titlechar) != true) {
                    search2 = false;
                }

            }
            if (search2 == true) {
                test.add(person.get(j));
            }
        }
        return test;
    }
}