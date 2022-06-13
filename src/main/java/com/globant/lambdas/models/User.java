package com.globant.lambdas.models;

import java.util.List;

public class User {

    private String name;
    private String lastName;
    private int age;
    private Address address;

    private List<String> pets;

    public User(String name, String lastName, int age, Address address, List<String> pets) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", pets=" + pets +
                '}';
    }
}
