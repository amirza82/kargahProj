package com.example;

import java.security.PublicKey;

public class Nurse extends Person{

    public Nurse (String name, String phoneNumber, String address, int ID, String email){
        super(name, phoneNumber, email, address, ID);
    }

    @Override
    public void print(){
        super.print();
    }
}
