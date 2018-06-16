package ro.sda.repository;

import ro.sda.model.Order;

import java.util.List;

public interface OrderRepository {

    Order findOrderById(Long id);

    List<Order> findAllOrders();

    void persistOrder(Order order);

    void persistOrders(List<Order> orders);

}
