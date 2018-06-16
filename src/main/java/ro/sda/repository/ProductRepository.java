package ro.sda.repository;

import ro.sda.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductByID(Long ID);

    void persistProduct(Product product);

    void persistProducts(List<Product> products);
}
