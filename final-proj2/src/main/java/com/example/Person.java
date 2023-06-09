package com.example;

public class Person implements IHospital{

    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Integer ID;
    private String password;

    public Person(String name, String phoneNumber, String email, String address, int ID, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email=email;
        this.ID = ID;
        this.password = password;
    }

    public Person(String name, String email, String address, int ID,String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber=phoneNumber;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pasword) {
        this.password = pasword;
    }


    @Override
    public void show_prof() {
        System.out.println("Name: " + this.name);
        System.out.println("phoneNumber: " + this.phoneNumber);
        System.out.println("email: " + this.email);
        System.out.println("Address: " + this.address);
        System.out.println("ID: " + this.ID);
    }
}

