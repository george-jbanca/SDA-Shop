package ro.sda.service;

import ro.sda.model.Product;

import java.util.List;


public interface ProductService {

    List<Product> listAllProducts();

    void addProduct(Product product);

    void removeProduct(Long productId);

}
