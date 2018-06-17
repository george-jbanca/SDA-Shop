package ro.sda.repository;

import ro.sda.model.Stock;

import java.util.List;

public interface StockRepository {

    List<Stock> getAllStockByProductId(Long id);

    Stock findStockById(Long id);

    List<Stock> findAllStock();

    void persistStock(Stock stock);

    void persistStocks(List<Stock> stocks);
    void deleteStock(Long stockId);
}
