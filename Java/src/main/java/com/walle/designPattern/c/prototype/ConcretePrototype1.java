package com.walle.designPattern.c.prototype;

public class ConcretePrototype1 implements Prototype {

    private String data;

    public ConcretePrototype1(String data) {
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

