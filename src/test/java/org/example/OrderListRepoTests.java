package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class OrderListRepoTests {
    @Test
    void addOrder_repoShouldContainSomething_whenOrderHasBeenAdded() {
        // GIVEN
        OrderListRepo repo = new OrderListRepo();
        List<Product> products = List.of(new Product("Laptop", 4653, new BigDecimal("1250.00")));
        Order order = new Order(4653, products, new BigDecimal("1250.00"));

        // WHEN
        repo.addOrder(order);

        // THEN
        assertTrue(repo.getAllOrders().contains(order));
    }

    @Test
    void removeOrder_repoShouldBeEmpty_whenTheOnlyOrderHasBeenRemoved() {
        // GIVEN
        OrderListRepo repo = new OrderListRepo();
        List<Product> products = List.of(new Product(
                "Laptop", 4763, new BigDecimal("3575.00")
        ));
        Order order = new Order(4763, products, new BigDecimal("3575.00"));

        // WHEN
        repo.addOrder(order);
        repo.removeOrder(order);

        // THEN
        assertTrue(repo.getAllOrders().isEmpty());
    }

    @Test
    void getOrderByID_shouldReturnCorrectOrder_whenIDExists() {
        // GIVEN
        OrderListRepo repo = new OrderListRepo();

        Product product1 = new Product("Laptop", 4763, new BigDecimal("3575.00"));
        Product product2 = new Product("Laptop", 4773, new BigDecimal("3525.00"));
        List<Product> products = List.of(product1, product2);

        Order order = new Order(47, products, new BigDecimal("7100.00"));
        repo.addOrder(order);

        // WHEN
        Order result = repo.getOrderByID(47);

        // THEN
        assertEquals(order, result);
    }

}
