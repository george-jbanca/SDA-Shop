package ro.sda.repository;
import ro.sda.model.Stock;
import java.util.List;

public interface StockRepository {

        List<Stock> getAllStock();
        Stock getStockByStockId(Long StockId);
        public void persistStock(List<Stock> stocks);


}


