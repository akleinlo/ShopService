package org.example;

import java.math.BigDecimal;

public record Product(
        String name,
        int id,
        BigDecimal price) {
}
