package com.example;


public class Nurse extends Person{
    private String department;
    private static Integer classID = 1;

    public Nurse(String name, String phoneNumber, String address, String email, String password, String department ){
        super(name, phoneNumber, email, address,classID, password);
        this.department=department;
        classID++;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void show_prof(){
        super.show_prof();
    }
    public void print()
    {
        super.show_prof();
        System.out.println("Department: "+department);

    }
}
