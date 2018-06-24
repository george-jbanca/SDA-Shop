package ro.sda.view;

import ro.sda.Constants;
import ro.sda.model.Order;
import ro.sda.model.Stock;
import ro.sda.reader.OrderReader;
import ro.sda.reader.StockReader;
import ro.sda.reader.impl.OrderReaderImpl;
import ro.sda.reader.impl.StockReaderImpl;
import ro.sda.service.impl.OrderServiceImpl;
import ro.sda.service.impl.StockServiceImpl;
import ro.sda.view.displayer.OrderDisplayer;
import ro.sda.view.displayer.StockDisplayer;


import java.util.List;
import java.util.Scanner;

public class StockView implements MyMarketView {

    StockServiceImpl stockService = new StockServiceImpl();
    StockReader stockReader = new StockReaderImpl();
    StockDisplayer stockDisplayer = new StockDisplayer();
    int option = -1;

    public void displayOptions() {

        System.out.println("1.List Stock.");
        System.out.println("2.Add Stock.");
        System.out.println("4.Exit.");
        option = readOption();
        processOption(option);
        while (option != Constants.EXIT_OPTION) {
            displayOptions();
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
                List<Stock> stocks = stockService.listAllStocks();
                stockDisplayer.listStocks(stocks);
                return;
            case 2:
               stockService.addStock(stockReader.readStock());
                return;
            case 0:
            default:
                return;

        }
    }
}
