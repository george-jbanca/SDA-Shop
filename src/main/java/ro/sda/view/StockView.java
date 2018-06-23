package ro.sda.view;

import ro.sda.model.Order;
import ro.sda.reader.OrderReader;
import ro.sda.reader.impl.OrderReaderImpl;
import ro.sda.service.impl.OrderServiceImpl;
import sun.security.pkcs11.wrapper.Constants;

import java.util.Scanner;

public class StockView implements MyMarketView {
   OrderServiceImpl orderService = new OrderServiceImpl();

    OrderReader orderReader = new OrderReaderImpl();



    public void displayView() {
        int option = -1;
        System.out.println("1.List Stock.");
        System.out.println("2.Add Stock.");
        System.out.println("4.Exit.");
        option = readOption();
        processOption(option);
        while (option != Constants.EXIT_OPTION) {
            displayView();
        }


    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();

    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                orderService.listOrders();
                return;
            case 2:
                Order order = orderReader.readOrder();
                orderService.placeOrder(order);
                return;
            case 0:
            default:
                return;

        }
    }
}