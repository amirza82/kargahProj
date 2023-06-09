package com.example;

import java.util.Date;

public class Prescription {
    private String info;
    private Doctor doctore;
    private Integer patientID;
    private Date date;
    private Integer ID;
    private static Integer classID = 1;


    public Prescription(String info, Doctor doctore, int patientID) {
        this.info = info;
        this.doctore = doctore;
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
    public Doctor getDoctore() {
        return doctore;
    }
    public void setDoctore(Doctor doctore) {
        this.doctore = doctore;
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
        return "DoctorID: "+ doctore.getID()+ " - " +"Doctor's Name: "+ doctore.getName()+ " - " +"Doctor's profesion: "+doctore.getProfesion()
                +"\n"+"Prescription: "+info +"\n"+"In Date: "+this.date;
    }



}
