package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopService {
    private final ProductRepo productRepo; // knows all products
    private final OrderRepoInterface orderRepo;

    // Constructor
    public ShopService(ProductRepo productRepo, OrderRepoInterface orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    // GETTER
    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public OrderRepoInterface getOrderRepo() {
        return orderRepo;
    }

    // METHODS
    public void placeOrder(List<Integer> productIDs, int orderID) {
        List<Product> products = new ArrayList<>(); // collects found products
        BigDecimal total = BigDecimal.ZERO; // start value for total

        for (int id : productIDs) {
            try {
                Product p = productRepo.getSingleProduct(id); // Product lookup (throws exception if not found)
                products.add(p); // add to order list
                total = total.add(p.price()); // add price (BigDecimal instead of +)
            } catch (IllegalArgumentException e) { // product not found
                System.out.println("Product with ID " + id + " does not exist.");
                return; // order is not being saved
            }
        }
        Order order = new Order(orderID, products, total); // Assemble order
        orderRepo.addOrder(order);
    }

    // OVERRIDDEN METHODS
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }
}
