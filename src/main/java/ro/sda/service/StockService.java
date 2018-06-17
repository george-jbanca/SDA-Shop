package ro.sda.service;

import ro.sda.model.Stock;

import java.util.List;

public interface StockService {
    Integer checkStockById (Long stockId);
    String checkStockForLocation (Long stockId);
    void deleteStock(Long stockId);

}
