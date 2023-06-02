package com.example;


public class Nurse extends Person{

    public Nurse (String name, String phoneNumber, String address, int ID, String email, String password){
        super(name, phoneNumber, email, address, ID, password);
    }

    @Override
    public void print(){
        super.print();
    }
}
