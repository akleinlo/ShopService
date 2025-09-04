package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopService {
    private final ProductRepo productRepo; // knows all products
    private final OrderListRepo orderListRepo; // saves orders

    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    // GETTER
    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public OrderListRepo getOrderListRepo() {
        return orderListRepo;
    }


    // METHODS
    public void placeOrder(List<Integer> productIDs, int orderID) {
        List<Product> products = new ArrayList<>(); // collects found products
        BigDecimal total = BigDecimal.ZERO; // start value for total

        for (int id : productIDs) {
            try {
                Product p = productRepo.getSingleProduct(id); // Product lookup (throws exception if not found)
                products.add(p); // Add to order list
                total = total.add(p.price()); // Add price (BigDecimal instead of +)
            } catch (IllegalArgumentException e) { // Product not found
                System.out.println("Product with ID " + id + " does not exist.");
                return; // order is not being saved
            }
        }
        Order order = new Order(orderID, products, total); // Assemble order
        orderListRepo.addOrder(order);
    }

    // OVERRIDDEN METHODS
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderListRepo, that.orderListRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderListRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderListRepo=" + orderListRepo +
                '}';
    }
}
