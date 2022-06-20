package com.globant.optional.gsb;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {


    public static void main(String[] args) {
        PhoneBook phoneBook=new PhoneBook();
        System.out.println("Exercise 1\n" + phoneBook.findPhoneNumberByName("Pedro Picapiedra"));
        System.out.println(phoneBook.findPhoneNumberByName("Piter Parker")
                +"/"+phoneBook.findNameByPhoneNumber("555-283-8750"));

        System.out.println("Exercise 2\n" + phoneBook.findPhoneNumberByNameAndPunishIfNothingFound("Pablo Marmol"));
        //System.out.print("\n" + phoneBook.findPhoneNumberByNameAndPunishIfNothingFound("Piter la anguila"));

        System.out.println("\nExercise 3\n" + phoneBook.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Javier Lopez"));
        System.out.println(phoneBook.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Picolin Palacios"));

        System.out.println("\nExercise 4\n" + phoneBook.findPhoneNumberByNameOrNameByPhoneNumber("Ramon Valdez","556-677-8899"));
        System.out.println(phoneBook.findPhoneNumberByNameOrNameByPhoneNumber("Ramon Ramirez","555-283-8750"));
        System.out.println(phoneBook.findPhoneNumberByNameOrNameByPhoneNumber("Mauricio Hernandez","222-333-4444"));
    }

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
        {
            put("Pedro Picapiedra", "555-456-7890");
            put("Pablo Marmol", "555-123-1234");
            put("Ramon Valdez", "555-283-8750");
            put("Javier Lopez", "555-579-3456");
        }
    };

    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    PhoneBook() { }

    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    public Optional<String> findPhoneNumberByName(String name){
        return Optional.ofNullable(phoneBookEntries.get(name));
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber){
        return  phoneBookEntries.entrySet().stream()
                .filter(stringStringEntry -> stringStringEntry.getValue().equals(phoneNumber))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    public  String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        return findPhoneNumberByName(name).orElseThrow(() -> new IllegalArgumentException("No phone number found"));
    }

    public  String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
        return this.findPhoneNumberByName(name).orElseGet(this::toString);
    }

    public  String findPhoneNumberByNameOrNameByPhoneNumber(String name,String phoneNumber){
        return findPhoneNumberByName(name).orElseGet(
                () -> findNameByPhoneNumber(phoneNumber).orElseGet(
                        () -> phoneBookEntries.values().stream().findFirst().get())
                );
    }

    @Override
    public String toString() {
        System.out.println("Hello from PhoneBook's toString method");
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneBookEntries +
                '}';
    }

}
