package ro.sda.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.model.Product;
import ro.sda.repository.ProductRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    public static final String FILE_PATH = "products.json";

    private ProductHolder holder = new ProductHolder();

    public ProductRepositoryImpl() {
        holder.setAllProducts(readFromFile());
    }

    public List<Product> getAllProducts() {
        return holder.getAllProducts();
    }

    public Product getProductByID(Long id) {
        return holder.getProduct(id);
    }

    public void persistProduct(Product product) {
        product.setId(holder.getNextId());
        holder.addProduct(product);
        writeToFile(holder.getAllProducts());
    }

    public void persistProducts(List<Product> products) {
        for (Product product : products) {
            product.setId(holder.getNextId());
            holder.addProduct(product);
        }
        writeToFile(holder.getAllProducts());
    }

    private void writeToFile(List<Product> products) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String productsLiteral = gson.toJson(products);
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            fileWriter.write(productsLiteral);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("EXCEPTION!!!");
        }
    }

    private List<Product> readFromFile() {
        List<Product> products = null;
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fileReader);
            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION!");
        }
        String productsLiteral = sb.toString();
        products = Arrays.asList(new Gson().fromJson(productsLiteral, Product[].class));
        return products;
    }

    public void deleteProduct(Long productId) {
        holder.deleteProduct(productId);
        writeToFile(holder.getAllProducts());

    }
}
