package ro.sda.reader.impl;

import ro.sda.model.Order;
import ro.sda.model.OrderState;
import ro.sda.reader.OrderReader;

import java.util.Scanner;

public class OrderReaderImpl implements OrderReader {
    public Order readOrder() {
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Id: ");
        System.out.println("cutomerId: ");
        System.out.println("Product list: ");
        OrderState orderState = null;
        while (orderState == null) {
            System.out.println("Read order state: ");
            orderState = parseOrderState(scanner.nextLine());
        }
        System.out.println();
        return order;
    }

    private OrderState parseOrderState(String input) {
        input = input.toUpperCase();
        OrderState orderState = OrderState.valueOf(input);
        return orderState;
    }
}
