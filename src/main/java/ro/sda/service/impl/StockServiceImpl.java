package ro.sda.service.impl;

import ro.sda.model.Stock;
import ro.sda.repository.StockRepository;
import ro.sda.repository.impl.StockRepositoryImpl;
import ro.sda.service.StockService;

import java.util.List;

public class StockServiceImpl implements StockService {

    StockRepository stockRepository = new StockRepositoryImpl();

    public Integer checkStockById(Long stockId) {
        Stock stock = new Stock();
        stock = stockRepository.findStockById(stockId);
        return stock.getAmount();
    }

    public String checkStockForLocation(Long stockId) {
        Stock stock = new Stock();
        stock = stockRepository.findStockById(stockId);
        String stockLocation = stock.getLocation();

        return stockLocation;
    }


    public void deleteStock(Long stockId) {
        stockRepository.deleteStock(stockId);

    }
}
