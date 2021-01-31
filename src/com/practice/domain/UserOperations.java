package com.practice.domain;

import com.practice.exceptions.ProductNotFountException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserOperations {

    private Product product;

    Set<Product> productSet = new HashSet<Product>();

    public Set<Product> addProduct(Product product) {

        productSet.add(product);

        return productSet;

    }

    public void listProducts(Set<Product> products) {
        for (Product product : products) {
            System.out.printf(Formats.PRODUCT_LIST_FORMAT, product.getProductBarcodeNumber(), product.getProductName(), product.getStock(), product.getPrice());
        }
    }

    public Product searchProduct(String productBarcodeNumber) throws ProductNotFountException {
        for (Product product : productSet) {
            if (product.getProductBarcodeNumber().equals(productBarcodeNumber)) {
                return product;
            }
        }
        throw new ProductNotFountException("ProductNotFound");

    }

    public void deleteProduct(String productBarcodeNumber) throws ProductNotFountException {
        productSet.remove(searchProduct(productBarcodeNumber));
    }

    Set<Product> sellProductSet = new HashSet<Product>();

    public Set<Product> sellProduct(String productBarcodeNumber, int piece) throws ProductNotFountException {
        Product searchResultProduct = searchProduct(productBarcodeNumber);
        Product sellProduct = new Product(searchResultProduct.getProductName(), searchResultProduct.getProductBarcodeNumber(), piece, searchResultProduct.getPrice());

        sellProductSet.add(sellProduct);
        searchResultProduct.setStock(searchResultProduct.getStock() - piece);

        return sellProductSet;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Product sellProduct : sellProductSet) {
            totalAmount += sellProduct.getStock()* sellProduct.getPrice();
        }
        return totalAmount;
    }

    public void printInvoice() {
        Invoice invoice = new Invoice();

        invoice.printInvoice(sellProductSet);
    }

}
