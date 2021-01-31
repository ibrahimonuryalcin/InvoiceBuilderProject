
package com.practice.exceptions;

public class ProductNotFountException extends Exception{

    public ProductNotFountException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.out.println("Product is not found");
    }
    
}
