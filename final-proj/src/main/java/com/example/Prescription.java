package com.example;


public class Prescription {
    private String info;
    private Integer doctoreID;
    private Integer patientID;
    
    public Prescription(String info, int doctoreID, int patientID) {
        this.info = info;
        this.doctoreID = doctoreID;
        this.patientID = patientID;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Integer getDoctoreID() {
        return doctoreID;
    }
    public void setDoctoreID(int doctoreID) {
        this.doctoreID = doctoreID;
    }
    public Integer getPatientID() {
        return patientID;
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    
    @Override
    public String toString(){
        return info + " " + doctoreID.toString() + " " + patientID.toString();
    }

}
