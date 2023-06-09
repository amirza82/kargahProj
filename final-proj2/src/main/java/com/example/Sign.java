package com.example;

public class Sign {

    // public Person signUpPatient(String name, String phoneNumber, String email, String address, int ID,
    // String description, String password){

    //     for (Person patient : Hospital.getPatients()) {
    //         if (patient.getName().equals(name) && patient.getPhoneNumber().equals(phoneNumber)) {
    //             return null;
    //         }
    //     }
    //     Patient patient = new Patient(name, phoneNumber, email, address, ID, description, password);
    //     Hospital.registerPatient(patient);
    //     return patient;
    // }

    // public Person signInPatient(String name, String password){
    //     for (Person patient : Hospital.getPatients()) {
    //         if(name.equals(patient.getName()) && password.equals(patient.getPassword())){
    //             return patient;
    //         }
    //     }
    //     return null;
    // }

    public static Person signInStaff(String name, String password){
        for (Person staff : Hospital.getStaff()) {
            if (staff.getName().equalsIgnoreCase(name) && staff.getPassword().equalsIgnoreCase(password)) {
                return staff;
            }
        }
        return null;
    }


    public static Admin signInAdmin(String name, String password) {
        if (Hospital.getAdmin().getName().equalsIgnoreCase(name) && Hospital.getAdmin().getPassword().equalsIgnoreCase(password)){
            return Hospital.getAdmin();
        } else {
            return null;
        }
    }
}
