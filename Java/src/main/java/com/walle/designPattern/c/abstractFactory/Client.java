package com.walle.designPattern.c.abstractFactory;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new Factory1();
        ProductA productA1 = factory1.createProductA();
        productA1.showName();

        ProductB productB1 = factory1.createProductB();
        productB1.showName();

        AbstractFactory factory2 = new Factory2();
        ProductA productA2 = factory2.createProductA();
        productA2.showName();

        ProductB productB2 = factory2.createProductB();
        productB2.showName();
    }
}