package ro.sda.view.displayer;

import ro.sda.model.Order;

import java.util.List;

public class OrderDisplayer {

    public void listOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

}
