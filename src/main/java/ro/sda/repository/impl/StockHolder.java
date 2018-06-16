package ro.sda.repository.impl;

import ro.sda.model.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockHolder {

    private Map<Long, Stock> stocks = new HashMap<Long, Stock>();

    public void setStocks(List<Stock> stocks) {
        for (Stock stock : stocks) {
            this.stocks.put(stock.getId(), stock);
        }
    }

    public void addStock(Stock stock) {
        this.stocks.put(stock.getId(), stock);
    }

    public Stock getStock(Long id) {
        return this.stocks.get(id);
    }

    public List<Stock> getStocks() {
        return new ArrayList<Stock>(this.stocks.values());
    }

    public Long getNextId() {
        Long max = 0L;
        for (Stock stock : stocks.values()) {
            if (max < stock.getId()) {
                max = stock.getId();
            }
        }
        return max + 1;
    }
}
