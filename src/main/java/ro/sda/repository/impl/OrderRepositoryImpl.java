package ro.sda.repository.impl;

import ro.sda.model.Order;
import ro.sda.repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository{

    public static final String FILE_PATH = "products.json";
    private ProductHolder holder = new ProductHolder();

    public Order findOrderById(Long id) {
        return null;
    }

    public List<Order> findAllOrders() {
        return null;
    }

    public void persist(Order order) {

    }

    public void persist(List<Order> orders) {

    }
}
