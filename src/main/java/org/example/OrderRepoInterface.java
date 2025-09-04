package org.example;

import java.util.List;

public interface OrderRepoInterface {
    void addOrder(Order order);
    void removeOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderByID(int id);
}
