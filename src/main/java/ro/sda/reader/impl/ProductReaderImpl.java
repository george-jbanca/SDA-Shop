package ro.sda.reader.impl;

import ro.sda.model.Product;
import ro.sda.reader.ProductReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductReaderImpl implements ProductReader {

    public Product readProduct(){
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        product.setName(scanner.next());
        System.out.println("Price: ");
        product.setPrice(scanner.nextBigDecimal());
        System.out.println("Description: ");
        product.setDescription(scanner.next());
        return product;
    }

    public String readProductId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input product id: ");
        return scanner.nextLine();
    }
}
