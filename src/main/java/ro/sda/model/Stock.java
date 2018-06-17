package ro.sda.model;

public class Stock {

    Long id;
    Long productId;
    Integer amount;
    String location;

    public Stock(){

    }

    public Stock(Long productId, Integer amount, String location) {
        this.productId = productId;
        this.amount = amount;
        this.location = location;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
