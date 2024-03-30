package com.walle.designPattern.c.prototype;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */
public class ConcretePrototype2 implements Prototype {

    private String data;

    public ConcretePrototype2(String data) {
        this.data = data;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getData() {
        return data;
    }
}
