package ro.sda;

import ro.sda.model.Order;
import ro.sda.model.Product;
import ro.sda.reader.impl.StockReaderImpl;
import ro.sda.repository.Repository;
import ro.sda.repository.impl.OrderRepositoryImpl;
import ro.sda.repository.impl.ProductRepositoryImpl;
import ro.sda.repository.impl.StockRepositoryImpl;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public  static void main(String[] args){
        Product product1 = new Product("Iphone", BigDecimal.valueOf(2000),"latest telephone");
        Product product2 = new Product("Iphone2", BigDecimal.valueOf(3000),"latest telephone v2");
        Repository repository = new ProductRepositoryImpl();
        repository.save(product1);
        repository.save(product2);
        List<Product> products = repository.findAll();

        Order order1 = new Order();
        Repository orderRepository = new OrderRepositoryImpl();
        orderRepository.save(order1);
//      List<Long> order = orderRepository.l


        StockRepositoryImpl stockRepository = new StockRepositoryImpl();
        StockReaderImpl stockReader = new StockReaderImpl();
        stockRepository.save(stockReader.readStock());


        /*
        * TODO: use GeneralView
        * * GeneralView generalView = new GeneralView();
        * * generalView.displayOptions();
        * */

    }
}
