package com.walle.designPattern.c.simpleFactory;

public class SimpleFactory {
    public static Product newProduct(int type) {
        switch (type) {
            case 1:
                return new Product1();
            case 2:
                return new Product2();
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }
}