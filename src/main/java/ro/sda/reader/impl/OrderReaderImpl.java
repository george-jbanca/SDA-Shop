package ro.sda.reader.impl;

import ro.sda.model.Order;
import ro.sda.model.OrderState;
import ro.sda.reader.OrderReader;
import ro.sda.reader.ProductReader;

import java.util.Scanner;

public class OrderReaderImpl implements OrderReader {

    ProductReader productReader = new ProductReaderImpl();

    public Order readOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        System.out.println("Input product id: ");
        String idValue = scanner.nextLine();
        while (!idValue.equals("x")) {
            order.getOrderProducts().add(Long.valueOf(idValue));
            idValue = productReader.readProductId();
        }
        return order;
    }

    private OrderState parseOrderState(String input) {
        input = input.toUpperCase();
        OrderState orderState = OrderState.valueOf(input);
        return orderState;
    }
}