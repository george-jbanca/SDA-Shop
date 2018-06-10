package ro.sda.repository;

import ro.sda.model.Product;

import java.util.ArrayList;

public interface ProductsRepository {

    ArrayList<Product> getAllProducts();//returneaza lista de produse
    Product getProductByID(Long ID);//primesti Long ID, returneaza un produs
    void persistProduct(Product product);//primeste un product ca parametru,il scrie in fisier;nu returneaza
    void persistProducts(ArrayList<Product> products);//primeste lista de produse ca parametru,nu returneaza


}
