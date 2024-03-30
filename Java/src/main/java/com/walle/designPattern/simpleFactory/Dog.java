package com.walle.designPattern.simpleFactory;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */ // 具体产品角色：狗类
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪汪");
    }
}
