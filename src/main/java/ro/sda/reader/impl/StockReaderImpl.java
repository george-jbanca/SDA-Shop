package ro.sda.reader.impl;

import ro.sda.model.Stock;
import ro.sda.reader.StockReader;

import java.util.Scanner;

public class StockReaderImpl implements StockReader {

    public Stock readStock(){
        Stock stock = new Stock();
        // citim product id

        Scanner scanner = new Scanner(System.in);
        System.out.println("Product ID: ");
        stock.getStockId();




        return stock;
    }

}