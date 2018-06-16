package ro.sda.model;

import ro.sda.repository.OrderRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {

    private Long id;
    private Long customerId;
    private List<Product> orderProducts;
    private String placedTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    private String[] status = {"Placed", "Pending", "Delivered", "Returned", "Canceled", "Problem with payment"};

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Product> getOrderProducts() {
        return this.orderProducts;
    }

    public void setOrderProducts(List<Product> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getPlacedTimeStamp() {
        return this.placedTimeStamp;
    }

    public void setPlacedTimeStamp(String placedTimeStamp) {
        this.placedTimeStamp = placedTimeStamp;
    }

    public String[] getStatus() {
        return this.status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
}
