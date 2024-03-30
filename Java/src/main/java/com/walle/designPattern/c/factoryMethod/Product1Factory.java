package com.walle.designPattern.c.factoryMethod;

public class Product1Factory extends AbstractFactory {
    @Override
    public Product newProduct() {
        return new Product1();
    }
}

