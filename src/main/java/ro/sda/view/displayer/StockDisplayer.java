package ro.sda.view.displayer;

import ro.sda.model.Stock;

import java.util.List;

public class StockDisplayer {

    public void listStocks(List<Stock> stocks) {
        for (Stock stock : stocks) {
            System.out.println(stock.toString());
        }
    }

}
