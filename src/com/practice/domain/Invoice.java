
package com.practice.domain;

import java.time.ZonedDateTime;
import java.util.Set;

public class Invoice {

    private String shopName = centerString(40,"STORE NAME");
    private String address = centerString(40,"STORE ADRESS");
    private String phoneNumber = centerString(40,"PHONE NUMBER");
    private Set<Product> sellProductSet;
                        

    public void printInvoice(Set<Product> sellProductSet){
        ZonedDateTime current = ZonedDateTime.now();
        double totalAmount = 0;
        System.out.println(shopName+"\n"+address+"\n"+phoneNumber+"\n");
        System.out.printf(Formats.INVOICE_INFORMATION_FORMAT,current,current,current,"",current);
        System.out.println("--------------------------------------");
        for(Product sellProduct : sellProductSet){
            System.out.printf(Formats.INVOICE_PRODUCT_FORMAT, sellProduct.getProductBarcodeNumber(),sellProduct.getStock(),sellProduct.getPrice(),sellProduct.getProductName(),"",(sellProduct.getPrice()*sellProduct.getStock()));
            totalAmount += sellProduct.getPrice()*sellProduct.getStock();
        }
        System.out.println("--------------------------------------");
        System.out.printf(Formats.INVOICE_TOTAL_AMOUNT_FORMAT,"Total Amount", totalAmount);
    }


public static String centerString (int width, String s) {
    return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
}

}