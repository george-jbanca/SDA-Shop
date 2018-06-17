package ro.sda.service.impl;

import ro.sda.model.Product;
import ro.sda.repository.ProductRepository;
import ro.sda.repository.impl.ProductRepositoryImpl;
import ro.sda.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository = new ProductRepositoryImpl();


    public List<Product> listAllProducts() {
        return productRepository.getAllProducts();
    }

    public void addProduct(Product product) {
        productRepository.persistProduct(product);

    }

    public void removeProduct(Long productId) {
        productRepository.deleteProduct(productId);
    }
}
