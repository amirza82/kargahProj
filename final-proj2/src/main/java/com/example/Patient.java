package com.example;

import java.util.List;

public class Patient extends Person {
    private List<Prescription> prescriptions=new ArrayList<>();
    private String description;
    private static Integer classID = 1;


    public Patient(String name, String phoneNumber, String email, String address,
                   String description) {
        super(name,email,address,classID,phoneNumber);

        this.description = description;
        classID++;
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