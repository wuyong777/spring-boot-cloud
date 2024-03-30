package com.walle.designPattern.c.simpleFactory;

public class Client {
    public static void main(String[] args) {
        Product product1 = SimpleFactory.newProduct(1);
        product1.showName();

        Product product2 = SimpleFactory.newProduct(2);
        product2.showName();
    }
}