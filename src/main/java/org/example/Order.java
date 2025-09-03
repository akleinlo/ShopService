package org.example;

import java.math.BigDecimal;
import java.util.List;

public record Order(
        int orderID,
        List<Product> products,
        BigDecimal totalPrice) {
}
