package ro.sda.service.impl;

import ro.sda.model.Stock;
import ro.sda.repository.impl.StockRepositoryImpl;
import ro.sda.service.StockService;

public class StockServiceImpl implements StockService {

    StockRepositoryImpl stockRepository = new StockRepositoryImpl();

    public Integer checkStockById(Long stockId) {
        Stock stock = new Stock();
        stock = stockRepository.find(stockId);
        return stock.getAmount();
    }

    public String checkStockForLocation(Long stockId) {
        Stock stock = new Stock();
        stock = stockRepository.find(stockId);
        String stockLocation = stock.getLocation();

        return stockLocation;
    }


    public void deleteStock(Long stockId) {
        stockRepository.delete(stockId);

    }
}
