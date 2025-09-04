package org.example;

import java.util.*;

public class OrderMapRepo implements OrderRepoInterface{
    private Map<Integer, Order> orders = new HashMap();

    public void addOrder(Order order) {
        orders.put(order.orderID(), order);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public void removeOrder(Order order) {
        orders.remove(order.orderID());
    }

    public Order getOrderByID(int id) {
        Order order = orders.get(id);
        if (order == null) {
            throw new IllegalArgumentException("Order ID does not exist.");
        }
        return order;
    }

    // OVERRIDDEN METHODS


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }
}

