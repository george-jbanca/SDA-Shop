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

import ro.sda.Constants;
import ro.sda.model.Product;
import ro.sda.reader.ProductReader;
import ro.sda.reader.impl.ProductReaderImpl;
import ro.sda.service.ProductService;
import ro.sda.service.impl.ProductServiceImpl;
import ro.sda.view.displayer.ProductDisplayer;

import java.util.List;
import java.util.Scanner;

public class ProductView implements MyMarketView {

    ProductService productService = new ProductServiceImpl();
    ProductReader productReader = new ProductReaderImpl();
    ProductDisplayer productDisplayer = new ProductDisplayer();

    int option = -1;

    public void displayOptions() {
        System.out.println("1. List Product");
        System.out.println("2. Add Product");
        System.out.println("0. Exit");
        System.out.println();
        option = readOption();
        while (option != Constants.EXIT_OPTION) {
            processOption(option);
            displayOptions();
        }
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                List<Product> products = productService.listAllProducts();
                productDisplayer.listProducts(products);
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