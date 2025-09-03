package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getSingleProduct(int id) {
        for (Product p : products) {
            if (id == p.id()) {
                return p;
            }
        }
        throw new IllegalArgumentException("Product-ID not found.");
    }
}
