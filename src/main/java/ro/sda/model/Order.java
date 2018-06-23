package ro.sda.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {

    private Long id;
    private Long customerId;
    private List<Long> orderProducts;
    private String placedTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    private OrderState status = OrderState.PLACED;

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

    public List<Long> getOrderProducts() {
        return this.orderProducts;
    }

    public void setOrderProducts(List<Long> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getPlacedTimeStamp() {
        return this.placedTimeStamp;
    }

    public void setPlacedTimeStamp(String placedTimeStamp) {
        this.placedTimeStamp = placedTimeStamp;
    }

    public OrderState getStatus() {
        return this.status;
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }
}
