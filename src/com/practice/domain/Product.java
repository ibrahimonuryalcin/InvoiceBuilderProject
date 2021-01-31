
package com.practice.domain;

import java.util.Objects;

public class Product {
    private String productName;
    private String productBarcodeNumber;
    private int stock;
    private double price;

    public Product(String productName, String productBarcodeNumber, int stock, double price) {
        this.productName = productName;
        this.productBarcodeNumber = productBarcodeNumber;
        this.stock = stock;
        this.price = price;
    }
    public Product(){
       
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBarcodeNumber() {
        return productBarcodeNumber;
    }

    public void setProductBarcodeNumber(String productBarcodeNumber) {
        this.productBarcodeNumber = productBarcodeNumber;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.productBarcodeNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productBarcodeNumber, other.productBarcodeNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", productBarcodeNumber=" + productBarcodeNumber + ", stock=" + stock + ", price=" + price + '}';
    }


}
