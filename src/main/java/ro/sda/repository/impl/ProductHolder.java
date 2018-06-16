package ro.sda.repository.impl;

import ro.sda.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductHolder {

    private Map<Long, Product> products = new HashMap<Long, Product>();

    public void setProducts(List<Product> products) {
        for (Product product : products) {
            this.products.put(product.getId(), product);
        }
    }

    public void addProduct(Product product) {
        this.products.put(product.getId(), product);
    }

    public Product getProduct(Long id) {
        return this.products.get(id);
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(this.products.values());
    }

    public Long getNextId() {
        Long max = 0L;
        for (Product product : products.values()) {
            if (max < product.getId()) {
                max = product.getId();
            }
        }
        return max + 1;
    }
}
