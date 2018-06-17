package ro.sda.service.impl;
import ro.sda.model.Order;
import ro.sda.repository.OrderRepository;
import ro.sda.repository.impl.OrderRepositoryImpl;
import ro.sda.service.OrderService;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = new OrderRepositoryImpl();

    public void placeOrder(Long orderID) {
        Order order = new Order();
        order.setId(orderID);
        orderRepository.persistOrder(order);
    }

    public void updateOrder(Long orderID) {


    }
}
