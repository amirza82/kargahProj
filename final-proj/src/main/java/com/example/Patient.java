package com.example;

import java.util.List;

public class Patient extends Person {
    private List<Prescription> prescriptions;
    private String description;
    
    public Patient(String name, String phoneNumber, String email, String address, int ID,
                String description) {
        super(name, phoneNumber, email, address, ID);
        
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
        System.out.println("\nprescriptions: ");
        for (int i = 0; i < this.prescriptions.size(); i++) {
            System.out.println(i + ". {\n" + prescriptions.get(i)  + "\n}\n");
        }
    }


}