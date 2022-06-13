package com.globant.streams.data;

import com.globant.streams.models.Order;
import com.globant.streams.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ProductDataLoader {

    public static List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add (new Product(1L, "omnis quod consequatur", "Games", 184.83));
        products.add (new Product(2L, "vel libero suscipit", "Toys", 12.66));
        products.add (new Product(3L, "non nemo iure", "Grocery", 498.02));
        products.add (new Product(4L, "voluptatem voluptas aspernatur", "Toys", 536.80));
        products.add (new Product(5L, "animi cum rem", "Games", 458.20 ));
        products.add (new Product(6L, "dolorem porro debitis", "Toys", 146.52));
        products.add (new Product(7L, "aspernatur rerum qui", "Books", 656.42));
        products.add (new Product(8L, "deleniti earum et", "Baby", 41.46));
        products.add (new Product(9L, "voluptas ut quidem", "Books", 697.57));
        products.add (new Product(10L, "eos sed debitis", "Baby", 366.90));
        products.add (new Product(11L, "laudantium sit nihil", "Toys", 95.50));
        products.add (new Product(12L, "ut perferendis corporis", "Grocery", 302.19));
        products.add (new Product(13L, "sint voluptatem ut", "Toys", 295.37));
        products.add (new Product(14L, "quos sunt ipsam", "Grocery", 534.64));
        products.add (new Product(15L, "qui illo error", "Baby", 623.58));
        products.add (new Product(16L, "aut ex ducimus", "Books", 551.39));
        products.add (new Product(17L, "accusamus repellendus minus", "Books", 240.58));
        products.add (new Product(18L, "aut accusamus quia", "Baby", 881.38));
        products.add (new Product(19L, "doloremque incidunt sed", "Games", 988.49));
        products.add (new Product(20L, "libero omnis velit", "Baby", 177.61));
        products.add (new Product(21L, "consectetur cupiditate sunt", "Toys", 95.46));
        products.add (new Product(22L, "itaque ea qui", "Baby", 677.78));
        products.add (new Product(23L, "non et nulla", "Grocery", 70.49));
        products.add (new Product(24L, "veniam consequatur et", "Books", 893.44));
        products.add (new Product(25L, "magnam adipisci voluptate", "Grocery", 366.13));
        products.add (new Product(26L, "reiciendis consequuntur placeat", "Toys", 359.27));
        products.add (new Product(27L, "dolores ipsum sit", "Toys", 786.99));
        products.add (new Product(28L, "ut hic tempore", "Toys", 316.09));
        products.add (new Product(29L, "quas quis deserunt", "Toys", 772.78));
        products.add (new Product(30L, "excepturi nesciunt accusantium", "Toys", 911.46));
        return products;

    }

    public static List<Product> loadOrders(List<Product> products) {
        List<Order> orders = OrderDataLoader.getOrders();
        products.get(0).setOrders(new HashSet<>(Arrays.asList(orders.get(6),orders.get(33),orders.get(38),orders.get(39),orders.get(44))));
        products.get(1).setOrders(new HashSet<>(Arrays.asList(orders.get(6),orders.get(33),orders.get(38),orders.get(39),orders.get(44))));
        products.get(2).setOrders(new HashSet<>(Arrays.asList(orders.get(17),orders.get(23),orders.get(24),orders.get(41))));
        products.get(3).setOrders(new HashSet<>(Arrays.asList(orders.get(2),orders.get(17),orders.get(47),orders.get(48))));
        products.get(4).setOrders(new HashSet<>(Arrays.asList(orders.get(18),orders.get(23),orders.get(25),orders.get(40))));
        products.get(5).setOrders(new HashSet<>(Arrays.asList(orders.get(0),orders.get(2),orders.get(4),orders.get(5),orders.get(22),orders.get(31),orders.get(34),orders.get(40),orders.get(48))));
        products.get(6).setOrders(new HashSet<>(Arrays.asList(orders.get(10),orders.get(11),orders.get(21),orders.get(23),orders.get(26),orders.get(29),orders.get(33),orders.get(42))));
        products.get(7).setOrders(new HashSet<>(Arrays.asList(orders.get(14),orders.get(21),orders.get(22),orders.get(35),orders.get(37),orders.get(47))));
        products.get(8).setOrders(new HashSet<>(Arrays.asList(orders.get(6),orders.get(7),orders.get(8),orders.get(9),orders.get(29),orders.get(31),orders.get(43))));
        products.get(9).setOrders(new HashSet<>(Arrays.asList(orders.get(27),orders.get(34))));
        products.get(10).setOrders(new HashSet<>(Arrays.asList(orders.get(6),orders.get(39),orders.get(47))));
        products.get(11).setOrders(new HashSet<>(Arrays.asList(orders.get(1),orders.get(10),orders.get(11),orders.get(12),orders.get(22),orders.get(34),orders.get(36),orders.get(37),orders.get(39),orders.get(45))));
        products.get(12).setOrders(new HashSet<>(Arrays.asList(orders.get(3),orders.get(5),orders.get(7),orders.get(10),orders.get(30),orders.get(32),orders.get(39),orders.get(48))));
        products.get(13).setOrders(new HashSet<>(Arrays.asList(orders.get(1),orders.get(2),orders.get(6),orders.get(11),orders.get(14),orders.get(17),orders.get(18),orders.get(32),orders.get(33),orders.get(40),orders.get(43),orders.get(45),orders.get(48))));
        products.get(14).setOrders(new HashSet<>(Arrays.asList(orders.get(1),orders.get(9),orders.get(18),orders.get(37),orders.get(40))));
        products.get(15).setOrders(new HashSet<>(Arrays.asList(orders.get(2),orders.get(18),orders.get(26),orders.get(36),orders.get(44),orders.get(47),orders.get(49))));
        products.get(16).setOrders(new HashSet<>(Arrays.asList(orders.get(14),orders.get(15),orders.get(30),orders.get(45),orders.get(49))));
        products.get(17).setOrders(new HashSet<>(Arrays.asList(orders.get(1),orders.get(24),orders.get(48))));
        products.get(18).setOrders(new HashSet<>(Arrays.asList(orders.get(13),orders.get(15),orders.get(16),orders.get(18),orders.get(37),orders.get(43))));
        products.get(19).setOrders(new HashSet<>(Arrays.asList(orders.get(0),orders.get(2),orders.get(11),orders.get(24),orders.get(33),orders.get(40),orders.get(45),orders.get(47))));
        products.get(20).setOrders(new HashSet<>(Arrays.asList(orders.get(37),orders.get(43),orders.get(46))));
        products.get(21).setOrders(new HashSet<>(Arrays.asList(orders.get(0),orders.get(6),orders.get(10),orders.get(20),orders.get(32),orders.get(38),orders.get(46))));
        products.get(22).setOrders(new HashSet<>(Arrays.asList(orders.get(3),orders.get(10),orders.get(15),orders.get(18),orders.get(19),orders.get(27),orders.get(28),orders.get(33))));
        products.get(23).setOrders(new HashSet<>(Arrays.asList(orders.get(12),orders.get(15),orders.get(32),orders.get(44),orders.get(46))));
        products.get(24).setOrders(new HashSet<>(Arrays.asList(orders.get(12),orders.get(23),orders.get(26),orders.get(43),orders.get(45))));
        products.get(25).setOrders(new HashSet<>(Arrays.asList(orders.get(6),orders.get(44))));
        products.get(26).setOrders(new HashSet<>(Arrays.asList(orders.get(3),orders.get(12),orders.get(15),orders.get(18),orders.get(20),orders.get(32),orders.get(34),orders.get(43),orders.get(47))));
        products.get(27).setOrders(new HashSet<>(Arrays.asList(orders.get(0),orders.get(6),orders.get(10),orders.get(17),orders.get(22),orders.get(33))));
        products.get(28).setOrders(new HashSet<>(Arrays.asList(orders.get(23),orders.get(24),orders.get(30),orders.get(35),orders.get(46))));
        products.get(29).setOrders(new HashSet<>(Arrays.asList(orders.get(15),orders.get(24),orders.get(29),orders.get(32),orders.get(39),orders.get(40),orders.get(48))));
        return products;
    }
}
