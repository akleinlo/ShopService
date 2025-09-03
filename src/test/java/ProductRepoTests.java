package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class ProductRepoTests {

    @Test
    void addProduct_repoShouldContainSomething_whenProductHasBeenAdded() {
        // GIVEN
        ProductRepo repo = new ProductRepo();
        Product p = new Product("Laptop", 3523, new BigDecimal("1345.00"));

        // WHEN
        repo.addProduct(p);

        // THEN
        assertTrue(repo.getAllProducts().contains(p));
    }

    @Test
    void removeProduct_repoShouldBeEmpty_afterTheOnlyProductHasBeenRemoved() {
        // GIVEN
        ProductRepo repo = new ProductRepo();
        Product p = new Product("Laptop", 3523, new BigDecimal("1345.00"));
        repo.addProduct(p);

        // WHEN
        repo.removeProduct(p);

        // THEN
        assertTrue(repo.getAllProducts().isEmpty());
    }

    @Test
    void removeProduct_repoShouldNotContainProduct_afterProductHasBeenRemoved() {
        ProductRepo repo = new ProductRepo();
        Product p = new Product("Laptop", 3523, new BigDecimal("1345.00"));
        repo.addProduct(p);
        Product p2 = new Product("Laptop", 3524, new BigDecimal("1345.00"));
        repo.addProduct(p2);

        // WHEN
        repo.removeProduct(p2);

        // THEN
        assertFalse(repo.getAllProducts().contains(p2));
    }

    @Test
    void getSingleProduct_shouldReturnProduct_whenIDExists() {
        // GIVEN
        ProductRepo repo = new ProductRepo();
        Product p = new Product("Laptop", 3523, new BigDecimal("1345.00"));
        repo.addProduct(p);

        // WHEN
        Product result = repo.getSingleProduct(p.id());

        // THEN
        assertEquals(p, result);
    }

    @Test
    void getSingleProduct_shouldReturnException_whenIDDoesNotExist() {
        // GIVEN
        ProductRepo repo = new ProductRepo();
        Product p = new Product("Laptop", 3523, new BigDecimal("1345.00"));
        repo.addProduct(p);

        // THEN
        assertThrows(IllegalArgumentException.class, () -> {
            repo.getSingleProduct(1234);
        });
    }
}
