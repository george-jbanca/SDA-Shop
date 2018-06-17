package ro.sda.service.impl;
import ro.sda.model.Order;
import ro.sda.model.OrderState;
import ro.sda.repository.OrderRepository;
import ro.sda.repository.impl.OrderRepositoryImpl;
import ro.sda.service.OrderService;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = new OrderRepositoryImpl();

    public void placeOrder(Order order) {
        order.setStatus(OrderState.PLACED);
        orderRepository.persistOrder(order);
    }

    public void cancelOrder(Long orderID) {
        Order order = orderRepository.findOrderById(orderID);
        order.setStatus(OrderState.CANCELED);
        orderRepository.persistOrder(order);
    }
}
