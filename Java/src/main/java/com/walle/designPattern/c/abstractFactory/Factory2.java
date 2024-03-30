package com.walle.designPattern.c.abstractFactory;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */
public class Factory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}
