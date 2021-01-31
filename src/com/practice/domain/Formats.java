
package com.practice.domain;

public class Formats {
    public static final String PRODUCT_LIST_HEADER_FORMAT = "|%1$-15s|%2$-30s|%3$8s|%4$12s|\n";
    public static final String PRODUCT_LIST_FORMAT = "|%1$-15s %2$-30s %3$8d %4$12.2f|\n"; 
    public static final String INVOICE_INFORMATION_FORMAT = "DATE : %td/%tm/%tY%-5sSaat : %tT|\n";
    public static final String TOTAL_AMOUNT_FORMAT = "|%1$58s  :  %2$5.2f|\n";
    public static final String INVOICE_PRODUCT_FORMAT = "|%1$s (%2$d ADET X %3$.2f)\n%4$-20s%5$-7s%6$10.2f|\n";
    public static final String INVOICE_TOTAL_AMOUNT_FORMAT = "|%1$25s  :  %2$5.2f|\n";
}
