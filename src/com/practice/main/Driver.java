package com.practice.main;

import com.practice.domain.Formats;
import com.practice.domain.Product;
import com.practice.domain.UserOperations;
import com.practice.exceptions.ProductNotFountException;
import java.util.Scanner;
import java.util.Set;

public class Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserOperations userOperations = new UserOperations();
        Set<Product> productList=null;
        Set<Product> sellProductList=null;

        String operations = "1 - Add Product\n"
                            + "2 - List Products\n"
                            + "3 - Delete Products\n"
                            + "4 - Sell\n"
                            + "5 - Print Invoice\n"
                            + "q - Quit";
        
        System.out.println("WELCOME THE SHOP");

        while (true) {
            System.out.println(operations);

            System.out.print("Select an operation : ");
            String operation = scanner.nextLine();

            if (operation.equals("q")) {
                System.out.println("Quit Program");
                break;
            } else if (operation.equals("1")) {
                System.out.print("Product Name : ");
                String productName = scanner.nextLine();

                System.out.print("Product Barcode Number : ");
                String productBarcodeNumber = scanner.nextLine();

                System.out.print("Product Stock : ");
                int stock = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Product Price : ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                Product product = new Product(productName, productBarcodeNumber, stock, price);

                productList = userOperations.addProduct(product);

            } else if (operation.equals("2")) {
                System.out.printf(Formats.PRODUCT_LIST_HEADER_FORMAT, "BARCODE NUMBER", "PRODUCT NAME", "STOCK", "PRICE");
                System.out.println("------------------------------------------------------------------------");
                userOperations.listProducts(productList);
                System.out.println("------------------------------------------------------------------------");

            } else if (operation.equals("3")) {

                System.out.println("Product Barcode Number");
                String productBarcodeNumber = scanner.nextLine();

                try {
                    userOperations.deleteProduct(productBarcodeNumber);
                } catch (ProductNotFountException ex) {
                    System.out.println("Product is not found");;
                    continue;
                }

            } else if (operation.equals("4")) {
                
                System.out.println("Product Barcode Number");
                String productBarcodeNumber = scanner.nextLine();

                System.out.println("Price");
                int price = scanner.nextInt();
                scanner.nextLine();
                try {
                    sellProductList = userOperations.sellProduct(productBarcodeNumber, price);
                } catch (ProductNotFountException ex) {
                    System.out.println("Product Not Found");;    
                }

                System.out.println("----------SELL LİST----------");
                System.out.printf(Formats.PRODUCT_LIST_HEADER_FORMAT, "BARCODE NUMBER", "PRODUCT NAME", "PIECE", "PRICE");
                System.out.println("------------------------------------------------------------------------");
                userOperations.listProducts(sellProductList);
                System.out.println("------------------------------------------------------------------------");

                double totalAmount = userOperations.calculateTotalAmount();
                System.out.printf(Formats.TOTAL_AMOUNT_FORMAT, "Total Amount", totalAmount);
                
            } else if (operation.equals("5")) {
                System.out.println("-----------------INVOICE--------------");
                userOperations.printInvoice();
                System.out.println("--------------------------------------");
            }
        }
    }

}
