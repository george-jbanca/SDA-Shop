package ro.sda.view;

import ro.sda.Constants;
import ro.sda.model.Order;
import ro.sda.reader.OrderReader;
import ro.sda.reader.impl.OrderReaderImpl;
import ro.sda.service.OrderService;
import ro.sda.service.impl.OrderServiceImpl;
import ro.sda.view.displayer.OrderDisplayer;

import java.util.List;
import java.util.Scanner;


public class OrderView implements MyMarketView {

    OrderServiceImpl orderService = new OrderServiceImpl();
    OrderReader orderReader = new OrderReaderImpl();
    OrderDisplayer orderDisplayer = new OrderDisplayer();
    int option = -1;

    public void displayOptions() {
        System.out.println("1.List Orders");
        System.out.println("2.Add Order");
        System.out.println("0.Exit");
        option = readOption();
        while (option != Constants.EXIT_OPTION) {
            processOption(option);
            displayOptions();
        }
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input option: ");
        return scanner.nextInt();
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                List<Order> orders = orderService.listAllOrders();
                orderDisplayer.listOrders(orders);
                return;
            case 2:
                orderService.placeOrder(orderReader.readOrder());
                return;
            case 3:
                return;
            default:
                return;

        }
    }
}
