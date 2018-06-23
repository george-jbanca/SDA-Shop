package ro.sda.view;

/*
 * TODO:
 * create interface MyMarketView that defines
 * * displayOptions
 * * readOption
 * * processOption
 *
 * Create Class GeneralView implements MyMarketView
 * 1. Products
 * 2. Stock
 * 3. Orders*/

import ro.sda.reader.ProductReader;
import ro.sda.reader.impl.ProductReaderImpl;
import ro.sda.service.ProductService;
import ro.sda.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class ProductView implements MyMarketView {

    ProductService productService = new ProductServiceImpl();
    ProductReader productReader = new ProductReaderImpl();

    public void displayOptions() {
        int option = -1;
        System.out.println("1. List Product");
        System.out.println("2. Add Product");
        System.out.println("3. Exit");
        System.out.println();
        option = readOption();
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    public void processOption(int option) {
        switch (option){
            case 1:
                productService.listAllProducts();
                return;
            case 2:
                productService.addProduct(productReader.readProduct());
                return;
            case 3:
            default:
                return;
        }
    }
}
