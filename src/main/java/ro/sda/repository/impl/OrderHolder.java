package ro.sda.repository.impl;

import ro.sda.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHolder {

    private Map<Long, Order> orders = new HashMap<Long, Order>();

    public void setOrders(List<Order> orders) {
        for (Order order : orders) {
            this.orders.put(order.getId(), order);
        }
    }

    public void addOrder(Order order) {
        this.orders.put(order.getId(), order);
    }

    public Order getOrder(Long id) {
        return this.orders.get(id);
    }

    public List<Order> getOrders() {
        return new ArrayList<Order>(this.orders.values());
    }

    public Long getNextId() {
        Long max = 0L;
        for (Order order : orders.values()) {
            if (max < order.getId()) {
                max = order.getId();
            }
        }
        return max + 1;
    }
}
