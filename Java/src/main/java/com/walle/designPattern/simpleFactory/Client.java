package com.walle.designPattern.simpleFactory;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Animal cat = AnimalFactory.createAnimal("cat");
        cat.makeSound();  // 输出：“喵喵喵”

        Animal dog = AnimalFactory.createAnimal("dog");
        dog.makeSound();  // 输出：“汪汪汪”
    }
}