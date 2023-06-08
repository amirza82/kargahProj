package com.example;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<Prescription> prescriptions = new ArrayList<Prescription>();
    private String description;
    
    public Patient(String name, String phoneNumber, String email, String address, int ID,
                String description, String password) {
        super(name, phoneNumber, email, address, ID, password);
        
        this.description = description;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
    public void setPrescriptions(List<Prescription> prescription) {
        this.prescriptions = prescription;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void print(){
        super.print();
        System.out.println(this.description);
        System.out.println("\nprescriptions: ");
        for (int i = 0; i < this.prescriptions.size(); i++) {
            System.out.println(i + ". {\n" + prescriptions.get(i)  + "\n}\n");
        }
    }

    public void addPrescription(Prescription prescription){
        prescriptions.add(prescription);
    }

    

}