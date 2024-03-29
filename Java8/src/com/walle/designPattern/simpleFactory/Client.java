package com.walle.designPattern.simpleFactory;

// 抽象产品角色：定义动物接口
interface Animal {
    void makeSound();
}

// 具体产品角色：猫类
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("喵喵喵");
    }
}

// 具体产品角色：狗类
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪汪");
    }
}

// 简单工厂角色：动物工厂
class AnimalFactory {
    // 根据传入的类型字符串创建对应的动物对象
    public static Animal createAnimal(String type) {
        if ("cat".equals(type)) {
            return new Cat();
        } else if ("dog".equals(type)) {
            return new Dog();
        } else {
            throw new IllegalArgumentException("未知的动物类型");
        }
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Animal cat = AnimalFactory.createAnimal("cat");
        cat.makeSound();  // 输出：“喵喵喵”

        Animal dog = AnimalFactory.createAnimal("dog");
        dog.makeSound();  // 输出：“汪汪汪”
    }
}