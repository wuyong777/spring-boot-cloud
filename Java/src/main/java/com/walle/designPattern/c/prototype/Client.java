package com.walle.designPattern.c.prototype;

public class Client {

    public static void main(String[] args) {
        try {
            // 创建具体原型实例
            ConcretePrototype1 concretePrototype1 = new ConcretePrototype1("ConcretePrototype1 Data");

            // 克隆具体原型实例并打印克隆后对象的数据
            ConcretePrototype1 clonedPrototype1 = (ConcretePrototype1) concretePrototype1.clone();
            System.out.println(clonedPrototype1.getData());

            // 创建另一个具体原型实例
            ConcretePrototype2 concretePrototype2 = new ConcretePrototype2("ConcretePrototype2 Data");

            // 克隆具体原型实例并打印克隆后对象的数据
            ConcretePrototype2 clonedPrototype2 = (ConcretePrototype2) concretePrototype2.clone();
            System.out.println(clonedPrototype2.getData());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}