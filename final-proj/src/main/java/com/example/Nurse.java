package com.example;


public class Nurse extends Person{

    public Nurse (String name, String phoneNumber, String address, int ID, String email, String password){
        super(name, phoneNumber, email, address, ID, password);
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
