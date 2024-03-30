package com.walle.designPattern.c.factoryMethod;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new Product1Factory();
        Product product1 = factory1.newProduct();
        product1.showName();

        AbstractFactory factory2 = new Product2Factory();
        Product product2 = factory2.newProduct();
        product2.showName();
    }
}