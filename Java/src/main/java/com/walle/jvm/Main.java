package com.walle.jvm;

import java.net.URL;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */ // 使用示例
public class Main {
    public static void main(String[] args) throws Exception {
        URL customClassLocation = new URL("file:/path/to/custom/classes/");
        CustomClassLoader myClassLoader = new CustomClassLoader(CustomClassLoader.class.getClassLoader(), customClassLocation);

        // 加载并实例化自定义类
        Class<?> myClass = myClassLoader.loadClass("com.example.MyCustomClass");
        Object instance = myClass.getDeclaredConstructor().newInstance();

        // 如果MyCustomClass有无参构造函数且可访问，以下将会调用构造函数并打印相关信息
        if (instance instanceof MyCustomClass) {
            MyCustomClass customInstance = (MyCustomClass) instance;
            System.out.println(customInstance.someMethod());
        }
    }
}
