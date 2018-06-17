package ro.sda.reader.impl;

import ro.sda.model.Stock;
import ro.sda.reader.StockReader;

import java.util.Scanner;

public class StockReaderImpl implements StockReader {

    public Stock readStock(){
        Stock stock = new Stock();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product ID: ");
        stock.setProductId(scanner.nextLong());
        System.out.println("Stock amount: ");
        stock.setAmount(scanner.nextInt());
        System.out.println("Location: ");
        stock.setLocation(scanner.next());

        return stock;
    }

}