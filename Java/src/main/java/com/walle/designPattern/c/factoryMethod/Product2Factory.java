package com.walle.designPattern.c.factoryMethod;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */
public class Product2Factory extends AbstractFactory {
    @Override
    public Product newProduct() {
        return new Product2();
    }
}
