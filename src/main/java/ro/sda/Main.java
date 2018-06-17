package ro.sda;

import ro.sda.model.Order;
import ro.sda.model.Product;
import ro.sda.model.Stock;
import ro.sda.reader.impl.StockReaderImpl;
import ro.sda.repository.OrderRepository;
import ro.sda.repository.ProductRepository;
import ro.sda.repository.impl.OrderRepositoryImpl;
import ro.sda.repository.impl.ProductRepositoryImpl;
import ro.sda.repository.impl.StockRepositoryImpl;

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

        Order order1 = new Order();
        OrderRepository orderRepository = new OrderRepositoryImpl();
        orderRepository.persistOrder(order1);
//        List<Long> order = orderRepository.l


        StockRepositoryImpl stockRepository = new StockRepositoryImpl();
        StockReaderImpl stockReader = new StockReaderImpl();
        stockRepository.persistStock(stockReader.readStock());



    }
}
