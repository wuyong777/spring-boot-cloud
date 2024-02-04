package com.walle.SE;

public class StaticFinalVariableTest {
    // 常量
    public static final String APP_NAME = "MyApp";
    public static final String APP_VERSION = "1.0.0";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    
    public static void main(String[] args) {
        // AppConfig.APP_NAME="YourApp"; 报错-->在Java中，final关键字表示一个变量只能被赋值一次。一旦一个final变量被赋值，就不能再改变它的值。
        System.out.println("Application name: " + StaticFinalVariableTest.APP_NAME);
        System.out.println("Application version: " + StaticFinalVariableTest.APP_VERSION);
        System.out.println("Database URL: " + StaticFinalVariableTest.DATABASE_URL);
    }
}