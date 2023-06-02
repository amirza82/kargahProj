package com.example;

import java.util.Date;

public class Prescription {
    private String info;
    private Integer doctoreID;
    private Integer patientID;
    private Date date;
    private Integer ID;
    private static Integer classID = 1;
    
    
    public Prescription(String info, int doctoreID, int patientID) {
        this.info = info;
        this.doctoreID = doctoreID;
        this.patientID = patientID;
        this.date = new Date();
        this.ID = classID++;

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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return info + " " + doctoreID.toString() + " " + patientID.toString();
    }
    


}
