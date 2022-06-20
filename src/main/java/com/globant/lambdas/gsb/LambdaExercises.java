package com.globant.lambdas.gsb;

import com.globant.lambdas.data.UserDataLoader;
import com.globant.lambdas.models.Address;
import com.globant.lambdas.models.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExercises {


    static Predicate<User> lessThan30Predicate = u -> u.getAge() < 30;
    static Predicate<User> olderThan22Predicate = u -> u.getAge() > 22;
    static Predicate<User> olderThan27Predicate = u -> u.getAge() > 27;
    static Predicate<User> lessThan25Predicate = u -> u.getAge() < 25;
    static Predicate<User> isOddNumberPredicate = u -> u.getAge() % 2 != 0;

    static Function<User, Address> userAddressFunction = User::getAddress;
    static Function<User, Stream<String>> petsFunction = user -> user.getPets().stream();
    static Function<List<User>, Map<String, Address>> getMapWithNameAndAddressFunction =
            users -> users.stream()
                    .filter(lessThan30Predicate)
                    .collect(Collectors.toMap(User::getName, User::getAddress));

    static Consumer<User> updateAddressConsumer = u -> u.getAddress().setCity("Tokio");

    static Consumer<User> namesAgesConsumer = u ->
            System.out.println(u.getName());
    static Consumer<User> PetsConsumer = u ->
            System.out.println(u.getPets());
    static Supplier<User> newUser = () ->
            new User("Gerardo", "Salvador", 30,
                    new Address("Iztapalapa"), Arrays.asList("dragon", "crocodile"));


    public static void main(String[] args) {
        System.out.println("Data");
        List<User> users = UserDataLoader.getUsers();
        users.forEach(System.out::println);


        System.out.println("\nExercise 1 - Obtain a list of users with age > 22 using the Predicate Interface");
        getExercise1OlderThan22(users);

        System.out.println("\nExercise 2 - Obtain a list of users whose age is an odd number and < 25 using Predicate chaining");
        getExercise2IsOddNumberAndLessThan25Predicate(users);

        System.out.println("\nExercise 3 - Obtain the address of the first user in the user list using the Function Interface");
        System.out.println("address.getCity() = " + getExercise3ObtainAddressFunction(users).getCity());

        System.out.println("\nExercise 4 - Create a map with the user's name and address  with age < 30 using Function interface\n");
        System.out.println("map  = " + getExercise4MapUserNameAndAddress(users));

        System.out.println("\nExercise 5 - Update the address of the third user in the user list using the Consumer interface and print the updated list");
        getExercise5UpdateAddressThirdUser(users);

        System.out.println("\nExercise 6 - Print the name and pets of the users with age > 27 using Consumer chaining");
        getExercise6PrintNameAndPetsWithAgeOlder27(users);

        System.out.println("\nExercise 7 - Create a new user using the Supplier interface and print it");
        getExercise7NewUserUsingSupplier();

        System.out.println("\nExercise 8 - Print the pets of all users using Method Reference");
        getExercise8PetsMethodReference(users);

        System.out.println("\nExercise 9 - Obtain a list of users with age < 29 using Method Reference");
        getExercise9UserLessThan29MethodReference(users);
    }

    public static void getExercise1OlderThan22(List<User> users) {
        users.stream().filter(olderThan22Predicate).forEach(System.out::println);
    }

    public static void getExercise2IsOddNumberAndLessThan25Predicate(List<User> users) {
        users.stream().filter(isOddNumberPredicate.and(lessThan25Predicate)).forEach(System.out::println);
    }

    public static Address getExercise3ObtainAddressFunction(List<User> users) {
        return users.stream().findFirst().map(userAddressFunction).orElse(null);
    }

    public static Map<String, Address> getExercise4MapUserNameAndAddress(List<User> users) {
        return getMapWithNameAndAddressFunction.apply(users);
    }

    public static void getExercise5UpdateAddressThirdUser(List<User> users) {
        updateAddressConsumer.accept(users.get(2));
        users.forEach(System.out::println);
    }

    public static List<User> getExercise6PrintNameAndPetsWithAgeOlder27(List<User> users) {
        return users.stream().filter(olderThan27Predicate).peek(namesAgesConsumer.andThen(PetsConsumer)).collect(Collectors.toList());
    }

    public static void getExercise7NewUserUsingSupplier() {
        System.out.println(newUser.get());
    }

    public static void getExercise8PetsMethodReference(List<User> users) {
        users.stream().flatMap(petsFunction).forEach(System.out::println);
    }

    public static void getExercise9UserLessThan29MethodReference(List<User> users) {
        users.stream().filter(LambdaExercises::usersLessThan29).forEach(System.out::println);
    }

    private static boolean usersLessThan29(User user) {
        return user.getAge() < 29;
    }

}
