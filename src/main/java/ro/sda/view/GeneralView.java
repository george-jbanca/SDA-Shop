package ro.sda.view;

import ro.sda.Constants;

import java.util.Scanner;

public class GeneralView implements MyMarketView {

    ProductView productView = new ProductView();
    OrderView orderView = new OrderView();
    StockView stockView = new StockView();
    int option = -1;

    public void displayOptions() {
        System.out.println("1.Product Menu");
        System.out.println("2.Order Menu");
        System.out.println("3.Stock Menu");
        System.out.println("0.Exit Menu");
        option = readOption();
        while (option != Constants.EXIT_OPTION) {
            processOption(option);
            displayOptions();
        }
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextInt();
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                productView.displayOptions();
                return;
            case 2:
                orderView.displayOptions();
                return;
            case 3:
                stockView.displayOptions();
                return;
            case 4:break;
            default:break;
        }
    }
}
