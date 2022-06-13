package com.globant.streams.data;

import com.globant.streams.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDataLoader {

    public static List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "Stefan Walker", 1));
        customers.add(new Customer(2L, "Daija Von", 1));
        customers.add(new Customer(3L, "Ariane Rodriguez", 1));
        customers.add(new Customer(4L, "Marques Nikolaus", 2));
        customers.add(new Customer(5L, "Rachelle Greenfelder", 0));
        customers.add(new Customer(6L, "Larissa White", 2));
        customers.add(new Customer(7L, "Fae Heidenreich", 1));
        customers.add(new Customer(8L, "Dino Will", 2));
        customers.add(new Customer(9L, "Eloy Stroman", 1));
        customers.add(new Customer(10L, "Brisa O''Connell", 1));
        return customers;
    }
}
