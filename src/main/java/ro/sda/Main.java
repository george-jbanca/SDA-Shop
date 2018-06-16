package ro.sda;

import ro.sda.model.Product;
import ro.sda.repository.ProductRepository;
import ro.sda.repository.impl.ProductRepositoryImpl;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public  static void main(String[] args){
        Product product1 = new Product("Iphone", BigDecimal.valueOf(2000),"latest telephone");
        Product product2 = new Product("Iphone2", BigDecimal.valueOf(3000),"latest telephone v2");
        ProductRepository repository = new ProductRepositoryImpl();
        repository.persistProduct(product1);
        repository.persistProduct(product2);
        List<Product> products = repository.getAllProducts();
    }
}
