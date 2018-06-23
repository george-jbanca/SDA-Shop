package ro.sda.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.model.Order;
import ro.sda.repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OrderRepositoryImpl implements Repository<Order> {

    public static final String FILE_PATH = "orders.json";
    private OrderHolder holder = new OrderHolder();

    /*
     * TODO: do as in ProductRepositoryImpl
     * */
    public OrderRepositoryImpl() {
        holder.setAllOrders(readFromFile());

    }


    public List<Order> findAll() {
        return holder.getAllOrders();
    }

    public Order find(Long id) {
        return holder.getOrder(id);
    }

    public void save(Order order) {
        order.setId(holder.getNextId());
        holder.addOrder(order);
        writeToFile(holder.getAllOrders());
    }

    public void saveAll(List<Order> orders) {
        for (Order order : orders) {
            order.setId(holder.getNextId());
            holder.addOrder(order);
        }
        writeToFile(holder.getAllOrders());
    }

    private void writeToFile(List<Order> orders) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String ordersLiteral = gson.toJson(orders);
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            fw.write(ordersLiteral);
            fw.close();
        } catch (IOException e) {
            System.out.println("EXCEPTION!!");
        }
    }

    private List<Order> readFromFile() {
        List<Order> orders = null;
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fileReader);
            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("EXCEPTIO!");
        }
        String ordersLiteral = sb.toString();
        orders = Arrays.asList(new Gson().fromJson(ordersLiteral, Order[].class));
        return orders;
    }

    public void delete(Long productId) {
        holder.deleteOrder(productId);
        writeToFile(holder.getOrders());
    }

}
