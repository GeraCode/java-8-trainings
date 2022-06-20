package com.globant.streams.gsb;


import com.globant.streams.data.CustomerDataLoader;
import com.globant.streams.data.OrderDataLoader;
import com.globant.streams.data.ProductDataLoader;
import com.globant.streams.models.Customer;
import com.globant.streams.models.Order;
import com.globant.streams.models.Product;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExercises {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    static Predicate<Product> productBooksPredicate = p -> p.getCategory().equals("Books");
    static Predicate<Product> product300Predicate = p ->  p.getPrice() > 300;
    static Predicate<Order> productBabyPredicate = o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("Baby"));
    static Predicate<Order> productDate15032021Predicate = order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15));
    static Predicate<Product> productToysPredicate = p -> p.getCategory().equals("Toys");
    static Predicate<Order> productOrder2Predicate = order ->order.getCustomer().getTier().equals(2);
    static Predicate<Order> productOrder202121Predicate = order ->order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1));
    static Predicate<Order> productOrder202141Predicate = order ->order.getOrderDate().isAfter(LocalDate.of(2021, 4, 1));

    static Consumer<Product> productPricesDiscountConsumer = p -> p.setPrice(Double.valueOf(df.format((p.getPrice() - (p.getPrice() * 0.10)))));


    public static void main(String[] args) {

        List<Product> productList = ProductDataLoader.loadOrders(ProductDataLoader.getProducts());
        List<Order> orderList = OrderDataLoader.loadProducts(OrderDataLoader.getOrders());
        List<Customer> customersList = CustomerDataLoader.getCustomers();


        System.out.println("\nExercise 1");
        exercise1(productList).forEach(System.out::println);

        System.out.println("\nExercise 2");
        exercise2(orderList).forEach(System.out::println);

        System.out.println("\nExercise 3");
        exercise3(productList).forEach(System.out::println);

        System.out.println("\nExercise 4");
        exercise4(orderList).forEach(System.out::println);

        System.out.println("\nExercise 5");
        System.out.println("Product = " + exercise5(productList));

        System.out.println("\nExercise 6");
        exercise6(orderList).forEach(System.out::println);

        System.out.println("\nExercise 7");
        exercise7(orderList).forEach(System.out::println);

        System.out.println("\nExercise 8");
        System.out.println("total lump sum  = " + exercise8(orderList));

        System.out.println("\nExercise 9");
        System.out.println("average = " + exercise9(orderList));

        System.out.println("\nExercise 10");
        System.out.println("stats\n" + exercise10(productList));

        System.out.println("\nExercise 11");
        System.out.println(" Map<Long, Integer>\n" + exercise11(orderList));

        System.out.println("\nExercise 12");
        System.out.println(" Map<Customer, List<Order>>\n" + exercise12(orderList));

        System.out.println("\nExercise 13");
        System.out.println(" Map<Long, Double>\n" + exercise13(orderList));

        System.out.println("\nExercise 14");
        System.out.println(" Map<String, List<Product>>\n" + exercise14(productList));

        System.out.println("\nExercise 15");
        System.out.println("Map<String, Product>\n" + exercise15(productList));


    }

    public static List<Product> exercise1(List<Product> productList) {
        return productList.stream()
                .filter(productBooksPredicate.and(product300Predicate))
                .collect(Collectors.toList());
    }

    public static List<Order> exercise2(List<Order> orderList) {
        return orderList.stream()
                .filter(productBabyPredicate)
                .collect(Collectors.toList());
    }

    public static List<Product> exercise3(List<Product> productList) {
        return productList.stream()
                .filter(productToysPredicate).peek(productPricesDiscountConsumer)
                .collect(Collectors.toList());
    }

    public static List<Product> exercise4(List<Order> orderList) {
        return orderList.stream()
                .filter(productOrder2Predicate.and(productOrder202121Predicate).and(productOrder202141Predicate))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static Product exercise5(List<Product> productList) {
        return productList.stream()
                .filter(productBooksPredicate)
                .min(Comparator.comparing(Product::getPrice))
                .get();
    }

    static List<Order> exercise6(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed()).limit(3)
                .collect(Collectors.toList());
    }

    static List<Product> exercise7(List<Order> orderList) {
        return orderList.stream()
                .filter(productDate15032021Predicate)
                .peek(System.out::println)
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    static Double exercise8(List<Order> orderList) {
        return orderList.stream()
                .filter(order -> order.getOrderDate().getMonthValue()==2)
                .filter(order -> order.getOrderDate().getYear()==2021)
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice).sum();
    }

    static Double exercise9(List<Order> orderList) {
        return orderList.stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice).average().getAsDouble();

    }

    static DoubleSummaryStatistics exercise10(List<Product> productList) {
        return productList.stream().filter(
                product -> product.getCategory().equals("Books")).mapToDouble(Product::getPrice).summaryStatistics();
    }

    static Map<Long, Integer> exercise11(List<Order> orderList) {
        return orderList.stream().collect(Collectors.toMap(Order::getId, order -> order.getProducts().size()));
    }

    static Map<Customer, List<Order>> exercise12(List<Order> orderList) {
        return orderList.stream().collect(Collectors.groupingBy(Order::getCustomer));
    }

    static Map<Long, Double> exercise13(List<Order> orderList) {
        return orderList.stream()
                .collect(Collectors.toMap(
                        Order::getId, order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()));
    }

    static Map<String, List<Product>> exercise14(List<Product> productList) {
        return productList.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    static Map<String, Product> exercise15(List<Product> products) {
        return products.stream()
                .collect(Collectors.toMap(Product::getCategory,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Product::getPrice))));
    }

}