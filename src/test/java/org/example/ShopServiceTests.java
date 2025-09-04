package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopServiceTests {
    @Test
    void placeOrder_shouldAddOrder_whenAllProductsExist() {
        // GIVEN
        Product product1 = new Product("Laptop", 4763, new BigDecimal("3575.00"));
        Product product2 = new Product("Laptop", 4769, new BigDecimal("3575.00"));

        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        OrderListRepo orderListRepo = new OrderListRepo();

        ShopService shopService = new ShopService(productRepo, orderListRepo);

        // WHEN
        shopService.placeOrder(List.of(4763, 4769), 5165);

        // THEN
        Order order = orderListRepo.getOrderByID(5165);
        assertEquals(2, order.products().size()); // should contain 2 products
        assertEquals(new BigDecimal("7150.00"), order.totalPrice());

    }
}
