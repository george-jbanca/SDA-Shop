package ro.sda.service.impl;
import ro.sda.model.Order;
import ro.sda.model.OrderState;
import ro.sda.repository.impl.OrderRepositoryImpl;
import ro.sda.service.OrderService;

public class OrderServiceImpl implements OrderService {

    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();

    public void placeOrder(Order order) {
        order.setStatus(OrderState.PLACED);
        orderRepository.save(order);
    }

    public void cancelOrder(Long orderID) {
        Order order = orderRepository.find(orderID);
        order.setStatus(OrderState.CANCELED);
        orderRepository.save(order);
    }
}
