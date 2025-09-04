package org.example;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Products
        Product product1 = new Product("Laptop", 23675, new BigDecimal("1275.00"));
        Product product2 = new Product("Rotwein", 3764, new BigDecimal("74.95"));
        Product product3 = new Product("Tee", 743687, new BigDecimal("17.95"));

        // add to ProductRepo
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        productRepo.addProduct(product3);

        // new OrderMapRepo
        OrderMapRepo orderMapRepo = new OrderMapRepo();

        // ShopService
        ShopService shopService = new ShopService(productRepo, orderMapRepo);

        // place order
        shopService.placeOrder(List.of(23675, 3764, 743687), 1);

        Order order = orderMapRepo.getOrderByID(1);
        System.out.println(order);

    }
}