package com.walle.javaBasic;

public class StaticVeriableTest {
    // 静态变量
    private static int count = 0;
    
    public StaticVeriableTest() {
        count++;
    }
    
    public static int getCount() {
        return count;
    }
    
    public static void main(String[] args) {
        StaticVeriableTest c1 = new StaticVeriableTest();
        StaticVeriableTest c2 = new StaticVeriableTest();
        StaticVeriableTest c3 = new StaticVeriableTest();
        StaticVeriableTest c4 = new StaticVeriableTest();
        System.out.println("目前为止创建的对象数: " + StaticVeriableTest.getCount());
    }
}
/*
目前为止创建的对象数: 4
 */