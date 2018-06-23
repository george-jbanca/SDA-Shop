package ro.sda.view;

import ro.sda.Constants;
import ro.sda.reader.OrderReader;
import ro.sda.reader.impl.OrderReaderImpl;
import ro.sda.service.OrderService;
import ro.sda.service.impl.OrderServiceImpl;
import java.util.Scanner;


public class OrderView implements MyMarketView {

    OrderService orderService = new OrderServiceImpl();
    OrderReader orderReader = new OrderReaderImpl();

    public void displayOptions() {
        int option = -1;
        System.out.println("1.List Orders");
        System.out.println("2.Add Order");
        System.out.println("3.Exit");
        option = readOption();
        processOption(option);
        while (option != Constants.EXIT_OPTION) {
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
                orderReader.readOrder();
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
