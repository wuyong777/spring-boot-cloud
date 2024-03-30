package com.walle.designPattern.simpleFactory;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */ // 简单工厂角色：动物工厂
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
