package com.walle.designPattern.simpleFactory;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */ // 具体产品角色：猫类
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("喵喵喵");
    }
}
