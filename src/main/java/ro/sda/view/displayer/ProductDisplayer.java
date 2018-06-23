package ro.sda.view.displayer;

import ro.sda.model.Product;

import java.util.List;

public class ProductDisplayer {

    public void listProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

}
