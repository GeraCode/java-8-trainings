package com.globant.streams.gsb;

import java.util.List;
import java.util.Map;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciseEsteban {

    static final String COMMA = ",";

    static String animals = "Dog,Cat,Rabbit,Dog,Dog,Lizard,Cat,Cat,Dog,Rabbit,Guinea Pig,Dog";
    static List<String> list = List.of("Hello", "Hello", "World", "World", "World", "World", "Piece", "Piece");
    static Predicate<String> petNamesPredicate = s -> s.equals("Cat") || s.equals("Dog");

    public void main(String[] args) {
        //Task #1 Create method to group the list and expose the amount of each groupped item. Answer {Hello=2, World=4, Piece=2}
        System.out.println(one());

        //Task #2 Create method to create an array from string field (animals). Then group and count only Dogs and Cats, rest should be skipped. Answer {Cat=3, Dog=5}
        System.out.println(two());

        //Task #3 Create a method which will define if a string is a Palindrome
        // (same text in backward and forward chars order, example: Anna, Redivider, deified, civic, radar)
        System.out.println("Is palindrome -> " + three("Anna"));
        System.out.println("Is palindrome -> " + three("Redivider"));
        System.out.println("Is palindrome -> " + three("deified"));
        System.out.println("Is palindrome -> " + three("civic"));
        System.out.println("Is palindrome -> " + three("radar"));
        System.out.println("Is palindrome -> " + three("Gerardo"));
        System.out.println("Is palindrome -> " + three("MEXICO"));



        //Given a string, return true if the number of appearances of "is" anywhere in
        //the string is equal to the number of appearances of "not" anywhere in the
        //string (case sensitive).

        //Examples:

        //method("This is not") → false
        System.out.println(" This is not-> " + method1("This is not"));

        //method("This is notnot") → true
        System.out.println(" This is notnot-> " + method1("This is notnot"));

        //method ("Duck not") → false
        System.out.println(" Duck not-> " + method1("Duck not"));

        //method ("is not not is not is") → true
        System.out.println(" is not not is not is-> " + method1("is not not is not is"));

        //method("There is not a single place but many in this world") → false
        System.out.println(" There is not a single place but many in this world-> " + method1("There is not a single place but many in this world"));

        //method("noisxxnotyynotxisi") → true}
        System.out.println(" noisxxnotyynotxisi-> " + method1("noisxxnotyynotxisi"));



    }

    public static Map<String, Long> one() {
        return list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }


    public static Map<String, Long> two() {
        List<String> animalsList = List.of(animals.split(COMMA));
        return animalsList.stream().filter(petNamesPredicate).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public static Boolean three(String text) {
        return text.toLowerCase().equals(new StringBuilder(text).reverse().toString().toLowerCase());
    }


    public  boolean method1(String str) {
        int isCount = 0;
        int notCount = 0;
        try {
            for (int i = 0; i < str.length(); i++) {

                if (str.substring(i, i + 2).equals("is")) {
                    System.out.println(str.substring(i, i + 1));
                    isCount++;
                }
                if (str.substring(i, i + 3).equals("not")) {
                    System.out.println(str.substring(i, i + 2));
                    notCount++;
                }

            }
        }catch (Exception e){

        }
        return isCount == notCount;
    }

}





