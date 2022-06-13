package com.globant.streams.data;

import com.globant.streams.models.Customer;
import com.globant.streams.models.Order;
import com.globant.streams.models.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OrderDataLoader {

    public static List<Order> getOrders() {
        List<Customer> customers = CustomerDataLoader.getCustomers();
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1L, LocalDate.parse("2021-02-28"), LocalDate.parse("2021-03-08"), "NEW", customers.get(4)));
        orders.add(new Order(2L, LocalDate.parse("2021-02-28"), LocalDate.parse("2021-03-05"), "NEW", customers.get(2)));
        orders.add(new Order(3L, LocalDate.parse("2021-04-10"), LocalDate.parse("2021-04-18"), "DELIVERED", customers.get(4)));
        orders.add(new Order(4L, LocalDate.parse("2021-03-22"), LocalDate.parse("2021-03-27"), "PENDING", customers.get(2)));
        orders.add(new Order(5L, LocalDate.parse("2021-03-04"), LocalDate.parse("2021-03-12"), "NEW", customers.get(0)));
        orders.add(new Order(6L, LocalDate.parse("2021-03-30"), LocalDate.parse("2021-04-07"), "DELIVERED", customers.get(8)));
        orders.add(new Order(7L, LocalDate.parse("2021-03-05"), LocalDate.parse("2021-03-09"), "PENDING", customers.get(7)));
        orders.add(new Order(8L, LocalDate.parse("2021-03-27"), LocalDate.parse("2021-04-05"), "NEW", customers.get(3)));
        orders.add(new Order(9L, LocalDate.parse("2021-04-14"), LocalDate.parse("2021-04-18"), "NEW", customers.get(9)));
        orders.add(new Order(10L, LocalDate.parse("2021-03-10"), LocalDate.parse("2021-03-19"), "NEW", customers.get(7)));
        orders.add(new Order(11L, LocalDate.parse("2021-04-01"), LocalDate.parse("2021-04-04"), "DELIVERED", customers.get(0)));
        orders.add(new Order(12L, LocalDate.parse("2021-02-24"), LocalDate.parse("2021-02-28"), "PENDING", customers.get(4)));
        orders.add(new Order(13L, LocalDate.parse("2021-03-15"), LocalDate.parse("2021-03-21"), "NEW", customers.get(4)));
        orders.add(new Order(14L, LocalDate.parse("2021-03-30"), LocalDate.parse("2021-04-07"), "PENDING", customers.get(3)));
        orders.add(new Order(15L, LocalDate.parse("2021-03-13"), LocalDate.parse("2021-03-14"), "DELIVERED", customers.get(4)));
        orders.add(new Order(16L, LocalDate.parse("2021-03-13"), LocalDate.parse("2021-03-21"), "NEW", customers.get(0)));
        orders.add(new Order(17L, LocalDate.parse("2021-03-31"), LocalDate.parse("2021-03-31"), "DELIVERED", customers.get(5)));
        orders.add(new Order(18L, LocalDate.parse("2021-03-25"), LocalDate.parse("2021-03-31"), "PENDING", customers.get(8)));
        orders.add(new Order(19L, LocalDate.parse("2021-02-28"), LocalDate.parse("2021-03-09"), "DELIVERED", customers.get(8)));
        orders.add(new Order(20L, LocalDate.parse("2021-03-23"), LocalDate.parse("2021-03-30"), "NEW", customers.get(4)));
        orders.add(new Order(21L, LocalDate.parse("2021-03-19"), LocalDate.parse("2021-03-24"), "DELIVERED", customers.get(8)));
        orders.add(new Order(22L, LocalDate.parse("2021-02-27"), LocalDate.parse("2021-03-01"), "NEW", customers.get(4)));
        orders.add(new Order(23L, LocalDate.parse("2021-04-19"), LocalDate.parse("2021-04-24"), "PENDING", customers.get(3)));
        orders.add(new Order(24L, LocalDate.parse("2021-03-24"), LocalDate.parse("2021-03-24"), "DELIVERED", customers.get(0)));
        orders.add(new Order(25L, LocalDate.parse("2021-03-03"), LocalDate.parse("2021-03-10"), "NEW", customers.get(0)));
        orders.add(new Order(26L, LocalDate.parse("2021-03-17"), LocalDate.parse("2021-03-26"), "NEW", customers.get(9)));
        orders.add(new Order(27L, LocalDate.parse("2021-03-20"), LocalDate.parse("2021-03-25"), "NEW", customers.get(0)));
        orders.add(new Order(28L, LocalDate.parse("2021-04-09"), LocalDate.parse("2021-04-16"), "DELIVERED", customers.get(1)));
        orders.add(new Order(29L, LocalDate.parse("2021-04-06"), LocalDate.parse("2021-04-08"), "PENDING", customers.get(0)));
        orders.add(new Order(30L, LocalDate.parse("2021-04-19"), LocalDate.parse("2021-04-20"), "DELIVERED", customers.get(0)));
        orders.add(new Order(31L, LocalDate.parse("2021-03-03"), LocalDate.parse("2021-03-04"), "NEW", customers.get(2)));
        orders.add(new Order(32L, LocalDate.parse("2021-03-15"), LocalDate.parse("2021-03-24"), "DELIVERED", customers.get(1)));
        orders.add(new Order(33L, LocalDate.parse("2021-04-18"), LocalDate.parse("2021-04-24"), "PENDING", customers.get(0)));
        orders.add(new Order(34L, LocalDate.parse("2021-03-28"), LocalDate.parse("2021-03-28"), "NEW", customers.get(5)));
        orders.add(new Order(35L, LocalDate.parse("2021-03-15"), LocalDate.parse("2021-03-17"), "NEW", customers.get(0)));
        orders.add(new Order(36L, LocalDate.parse("2021-03-04"), LocalDate.parse("2021-03-08"), "DELIVERED", customers.get(1)));
        orders.add(new Order(37L, LocalDate.parse("2021-03-18"), LocalDate.parse("2021-03-25"), "NEW", customers.get(7)));
        orders.add(new Order(38L, LocalDate.parse("2021-04-11"), LocalDate.parse("2021-04-20"), "NEW", customers.get(7)));
        orders.add(new Order(39L, LocalDate.parse("2021-04-12"), LocalDate.parse("2021-04-17"), "NEW", customers.get(8)));
        orders.add(new Order(40L, LocalDate.parse("2021-03-12"), LocalDate.parse("2021-03-12"), "PENDING", customers.get(2)));
        orders.add(new Order(41L, LocalDate.parse("2021-02-24"), LocalDate.parse("2021-02-26"), "NEW", customers.get(4)));
        orders.add(new Order(42L, LocalDate.parse("2021-04-08"), LocalDate.parse("2021-04-14"), "DELIVERED", customers.get(8)));
        orders.add(new Order(43L, LocalDate.parse("2021-03-03"), LocalDate.parse("2021-03-11"), "NEW", customers.get(2)));
        orders.add(new Order(44L, LocalDate.parse("2021-03-12"), LocalDate.parse("2021-03-14"), "DELIVERED", customers.get(3)));
        orders.add(new Order(45L, LocalDate.parse("2021-04-01"), LocalDate.parse("2021-04-06"), "DELIVERED", customers.get(0)));
        orders.add(new Order(46L, LocalDate.parse("2021-03-16"), LocalDate.parse("2021-03-22"), "NEW", customers.get(9)));
        orders.add(new Order(47L, LocalDate.parse("2021-04-07"), LocalDate.parse("2021-04-12"), "PENDING", customers.get(1)));
        orders.add(new Order(48L, LocalDate.parse("2021-04-05"), LocalDate.parse("2021-04-06"), "NEW", customers.get(1)));
        orders.add(new Order(49L, LocalDate.parse("2021-04-10"), LocalDate.parse("2021-04-13"), "NEW", customers.get(6)));
        orders.add(new Order(50L, LocalDate.parse("2021-03-18"), LocalDate.parse("2021-03-21"), "NEW", customers.get(8)));
        return orders;

    }

    public static List<Order> loadProducts(List<Order> orders) {
        List<Product> products = ProductDataLoader.getProducts();
        orders.get(0).setProducts(new HashSet<>(Arrays.asList(products.get(4),products.get(18),products.get(20))));
        orders.get(1).setProducts(new HashSet<>(Arrays.asList(products.get(10),products.get(12),products.get(13),products.get(16))));
        orders.get(2).setProducts(new HashSet<>(Arrays.asList(products.get(2),products.get(4),products.get(12),products.get(14),products.get(18))));
        orders.get(3).setProducts(new HashSet<>(Arrays.asList(products.get(11),products.get(21),products.get(25))));
        orders.get(4).setProducts(new HashSet<>(Arrays.asList(products.get(4))));
        orders.get(5).setProducts(new HashSet<>(Arrays.asList(products.get(4),products.get(11))));
        orders.get(6).setProducts(new HashSet<>(Arrays.asList(products.get(0),products.get(7),products.get(9),products.get(12),products.get(20),products.get(24))));
        orders.get(7).setProducts(new HashSet<>(Arrays.asList(products.get(7),products.get(11))));
        orders.get(8).setProducts(new HashSet<>(Arrays.asList(products.get(7))));
        orders.get(9).setProducts(new HashSet<>(Arrays.asList(products.get(7),products.get(13))));
        orders.get(10).setProducts(new HashSet<>(Arrays.asList(products.get(5),products.get(10),products.get(11),products.get(20),products.get(21),products.get(26))));
        orders.get(11).setProducts(new HashSet<>(Arrays.asList(products.get(5),products.get(10),products.get(12),products.get(18))));
        orders.get(12).setProducts(new HashSet<>(Arrays.asList(products.get(10),products.get(22),products.get(23),products.get(25))));
        orders.get(13).setProducts(new HashSet<>(Arrays.asList(products.get(17))));
        orders.get(14).setProducts(new HashSet<>(Arrays.asList(products.get(6),products.get(12),products.get(15))));
        orders.get(15).setProducts(new HashSet<>(Arrays.asList(products.get(15),products.get(17),products.get(21),products.get(22),products.get(25),products.get(28))));
        orders.get(16).setProducts(new HashSet<>(Arrays.asList(products.get(3),products.get(17))));
        orders.get(17).setProducts(new HashSet<>(Arrays.asList(products.get(1),products.get(2),products.get(12),products.get(26))));
        orders.get(18).setProducts(new HashSet<>(Arrays.asList(products.get(12),products.get(13),products.get(14),products.get(17),products.get(21),products.get(25))));
        orders.get(19).setProducts(new HashSet<>(Arrays.asList(products.get(21))));
        orders.get(20).setProducts(new HashSet<>(Arrays.asList(products.get(22),products.get(25))));
        orders.get(21).setProducts(new HashSet<>(Arrays.asList(products.get(5),products.get(6))));
        orders.get(22).setProducts(new HashSet<>(Arrays.asList(products.get(4),products.get(6),products.get(10),products.get(26))));
        orders.get(23).setProducts(new HashSet<>(Arrays.asList(products.get(1),products.get(3),products.get(5),products.get(23),products.get(27))));
        orders.get(24).setProducts(new HashSet<>(Arrays.asList(products.get(1),products.get(16),products.get(18),products.get(27),products.get(28))));
        orders.get(25).setProducts(new HashSet<>(Arrays.asList(products.get(3))));
        orders.get(26).setProducts(new HashSet<>(Arrays.asList(products.get(5),products.get(14),products.get(23))));
        orders.get(27).setProducts(new HashSet<>(Arrays.asList(products.get(8),products.get(21))));
        orders.get(28).setProducts(new HashSet<>(Arrays.asList(products.get(21))));
        orders.get(29).setProducts(new HashSet<>(Arrays.asList(products.get(5),products.get(7),products.get(28))));
        orders.get(30).setProducts(new HashSet<>(Arrays.asList(products.get(11),products.get(15),products.get(27))));
        orders.get(31).setProducts(new HashSet<>(Arrays.asList(products.get(4),products.get(7))));
        orders.get(32).setProducts(new HashSet<>(Arrays.asList(products.get(11),products.get(12),products.get(20),products.get(22),products.get(25),products.get(28))));
        orders.get(33).setProducts(new HashSet<>(Arrays.asList(products.get(0),products.get(5),products.get(12),products.get(18),products.get(21),products.get(26))));
        orders.get(34).setProducts(new HashSet<>(Arrays.asList(products.get(4),products.get(8),products.get(10),products.get(25))));
        orders.get(35).setProducts(new HashSet<>(Arrays.asList(products.get(6),products.get(27))));
        orders.get(36).setProducts(new HashSet<>(Arrays.asList(products.get(10),products.get(14))));
        orders.get(37).setProducts(new HashSet<>(Arrays.asList(products.get(6),products.get(10),products.get(13),products.get(17),products.get(19))));
        orders.get(38).setProducts(new HashSet<>(Arrays.asList(products.get(0),products.get(20))));
        orders.get(39).setProducts(new HashSet<>(Arrays.asList(products.get(0),products.get(9),products.get(10),products.get(11),products.get(28))));
        orders.get(40).setProducts(new HashSet<>(Arrays.asList(products.get(3),products.get(4),products.get(12),products.get(13),products.get(18),products.get(28))));
        orders.get(41).setProducts(new HashSet<>(Arrays.asList(products.get(1))));
        orders.get(42).setProducts(new HashSet<>(Arrays.asList(products.get(5))));
        orders.get(43).setProducts(new HashSet<>(Arrays.asList(products.get(7),products.get(12),products.get(17),products.get(19),products.get(23),products.get(25))));
        orders.get(44).setProducts(new HashSet<>(Arrays.asList(products.get(0),products.get(14),products.get(22),products.get(24))));
        orders.get(45).setProducts(new HashSet<>(Arrays.asList(products.get(10),products.get(12),products.get(15),products.get(18),products.get(23))));
        orders.get(46).setProducts(new HashSet<>(Arrays.asList(products.get(19),products.get(20),products.get(22),products.get(27))));
        orders.get(47).setProducts(new HashSet<>(Arrays.asList(products.get(2),products.get(6),products.get(9),products.get(14),products.get(18),products.get(25))));
        orders.get(48).setProducts(new HashSet<>(Arrays.asList(products.get(2),products.get(4),products.get(11),products.get(12),products.get(16),products.get(28))));
        orders.get(49).setProducts(new HashSet<>(Arrays.asList(products.get(14),products.get(15))));
        return orders;
    }

}
