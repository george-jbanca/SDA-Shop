package ro.sda.service;

import ro.sda.model.Order;

import java.util.List;

public interface OrderService {

        void placeOrder(Order order);
        void cancelOrder(Long orderID);
        public List<Order> listAllOrders();
}
