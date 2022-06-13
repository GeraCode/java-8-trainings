package com.globant.lambdas.data;

import com.globant.lambdas.models.Address;
import com.globant.lambdas.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDataLoader {

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John","Smith",10,new Address("New York"), Arrays.asList("dog","cat","duck")));
        users.add(new User("James","Bond",13,new Address("Chicago"), Arrays.asList("parrot","dog","fish")));
        users.add(new User("Henry","Ford",16,new Address("California"), Arrays.asList("bird","rabbit")));
        users.add(new User("Emma","Stone",19,new Address("Boston"), Arrays.asList("hamster","turtle")));
        users.add(new User("Robert","Johnson",22,new Address("Houston"), Arrays.asList("dog","hamster","turtle")));
        users.add(new User("Jennifer","Anniston",25,new Address("Phoenix"), Arrays.asList("hamster","cat")));
        users.add(new User("Richard","Williams",28,new Address("Philadelphia"),Arrays.asList("rabbit","turtle","dog")));
        users.add(new User("Michael","Jordan",31,new Address("Miami"),Arrays.asList("cat","turtle","bird")));
        users.add(new User("Kelly","Miller",34,new Address("Texas"),Arrays.asList("hamster","rabbit")));
        users.add(new User("Hannah","Montana",39,new Address("Detroit"),Arrays.asList("fish","dog","turtle")));
        return users;
    }
}
