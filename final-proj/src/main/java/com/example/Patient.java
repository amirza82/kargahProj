package com.example;

import java.util.List;

public class Patient extends Person {
    private List<Prescription> prescriptions=new ArrayList<>();
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
    public void addPrescription(Prescription prescription){
        prescriptions.add(prescription);
    }

    @Override
    public void show_prof()
    {
        super.show_prof();
    }
    public void show_prescri()
    {
        System.out.println("PatientID: "+getID()+" - "+"Patient: "+getName()+"\n"+"Description of the patient: "+description+"\n");
        for (int i = 0; i < this.prescriptions.size(); i++) {
            System.out.println(i + ". {\n" + prescriptions.get(i)  + "\n}\n");
        }

    }

    

}