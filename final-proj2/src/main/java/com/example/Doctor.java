package com.example;

public class Doctor extends Person {
    private String profesion;
    private String department;
    private static Integer classID = 1;

    public Doctor(String name, String phoneNumber, String address, String email, String profesion, String password, String department) {
        super(name, phoneNumber, email, address, classID, password);
        this.profesion = profesion;
        this.department=department;
        classID++;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void show_prof() {
        super.show_prof();
    }

    public void print() {
        super.show_prof();
        System.out.println("Department: "+department);
        System.out.println("Profesion: " + profesion);

    }

}
