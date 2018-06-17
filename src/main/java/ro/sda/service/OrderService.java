package ro.sda.service;

import ro.sda.model.Order;

public interface OrderService {

        void placeOrder(Order order);
        void cancelOrder(Long orderID);
}
