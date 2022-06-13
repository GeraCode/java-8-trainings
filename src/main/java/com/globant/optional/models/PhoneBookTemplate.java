package com.globant.optional.models;

import java.util.HashMap;
import java.util.Optional;

public class PhoneBookTemplate {

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
        {
            put("Von Miller", "212-456-7890");
            put("Vin Diesel", "415-123-1234");
            put("Kim Kardashian", "207-183-8750");
            put("Scarlett Johansson", "456-879-3456");
        }
    };

    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    PhoneBookTemplate() { }

    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    public Optional<String> findPhoneNumberByName(String name){
        //TODO Please copy this class to your own package and do the required implementation
        return null;
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber){
        //TODO Please copy this class to your own package and do the required implementation
        return null;
    }

    @Override
    public String toString() {
        System.out.println("Hello from PhoneBook's toString method");
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneBookEntries +
                '}';
    }

}
