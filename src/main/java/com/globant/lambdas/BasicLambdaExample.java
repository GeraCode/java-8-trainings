package com.globant.lambdas;

import java.util.function.Predicate;

public class BasicLambdaExample {
    public static void main(String[] args) {
        // Defining Lambda Expression for Predicate Functional interface
        Predicate<Integer> p = number -> (number % 2 == 0);

        System.out.println(p.test(10));
        System.out.println(p.test(11));
    }
}
