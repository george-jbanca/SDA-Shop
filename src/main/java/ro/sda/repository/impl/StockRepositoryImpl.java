package ro.sda.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.model.Stock;
import ro.sda.repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StockRepositoryImpl implements Repository<Stock> {

    public static final String FILE_PATH = "stocks.json";
    private StockHolder holder = new StockHolder();

    /*
    * TODO: do as in ProductRepositoryImpl
    * */
    public StockRepositoryImpl() {

    }

    public List<Stock> getAllStockByProductId(Long id) {
        return holder.getStocks();
    }

    public Stock find(Long id) {
        return holder.getStock(id);
    }

    public List<Stock> findAll() {
        return holder.getStocks();
    }


    public void save(Stock stock) {
        stock.setId(holder.getNextId());
        holder.addStock(stock);
        writeToFile(holder.getStocks());
    }

    public void saveAll(List<Stock> stocks) {
        for (Stock stock : stocks) {
            stock.setId(holder.getNextId());
            holder.addStock(stock);
        }
        writeToFile(holder.getStocks());
    }

    private void writeToFile(List<Stock> stocks) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String stocksLiteral = gson.toJson(stocks);
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            fw.write(stocksLiteral);
            fw.close();
        } catch (IOException e) {
            System.out.println("EXCp!");
        }
    }

    private List<Stock> readFromFile() {
        List<Stock> stocks = null;
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fileReader);
            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("EXCEPTI!");
        }
        String stocksLiteral = sb.toString();
        stocks = Arrays.asList(new Gson().fromJson(stocksLiteral, Stock[].class));
        return stocks;
    }

    public void delete(Long stockId) {
        holder.deleteStock(stockId);
    }
}
