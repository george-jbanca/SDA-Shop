package ro.sda.service.impl;

import ro.sda.model.Product;
import ro.sda.repository.impl.ProductRepositoryImpl;
import ro.sda.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();


    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);

    }

    public void removeProduct(Long productId) {
        productRepository.delete(productId);
    }
}
