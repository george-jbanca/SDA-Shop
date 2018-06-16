package ro.sda.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.model.Order;
import ro.sda.repository.OrderRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository{

    public static final String FILE_PATH = "orders.json";
    private OrderHolder holder = new OrderHolder();

    public List<Order> findAllOrders() {
        return holder.getOrders();
    }

    public Order findOrderById(Long id) {
        return holder.getOrder(id);
    }

    public void persistOrder(Order order) {
        order.setId(holder.getNextId());
        holder.addOrder(order);
        writeToFile(holder.getOrders());
    }

    public void persistOrders(List<Order> orders) {
        for(Order order : orders) {
            order.setId(holder.getNextId());
            holder.addOrder(order);
        }
        writeToFile(holder.getOrders());
    }

    private void  writeToFile(List<Order> orders) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String ordersLiteral = gson.toJson(orders);
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            fw.write(ordersLiteral);
            fw.close();
        }catch(IOException e) {
            System.out.println("EXCEPTION!!");
        }
    }

    private List<Order> readFromFile(){
        List<Order> orders = null;
        StringBuilder sb = new StringBuilder();
        try{
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fileReader);
            while(br.ready()){
                sb.append(br.readLine());
            }
        }catch (IOException e){
            System.out.println("EXCEPTIO!");
        }
        String ordersLiteral = sb.toString();
        orders = Arrays.asList(new Gson().fromJson(ordersLiteral,Order[].class));
        return orders;
    }
}
