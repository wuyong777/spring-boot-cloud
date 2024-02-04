package com.walle.SE;

/*
方法参数变量的值传递方式有两种：值传递和引用传递。

值传递：在方法调用时，传递的是实际参数的值的副本。当参数变量被赋予新的值时，只会修改副本的值，不会影响原始值。Java 中的基本数据类型都采用值传递方式传递参数变量的值。

引用传递：在方法调用时，传递的是实际参数的引用（即内存地址）。当参数变量被赋予新的值时，会修改原始值的内容。Java 中的对象类型采用引用传递方式传递参数变量的值。
*/
public class ParamTransTest {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("a = " + a + ", b = " + b); // 输出a和b的值
        swap(a, b); // 调用swap方法
        System.out.println("a = " + a + ", b = " + b); // 输出a和b的值

    }

    public static void swap(int x, int y) {
        System.out.println("x = " + x + ", y = " + y); // 输出x和y的值
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x = " + x + ", y = " + y); // 输出x和y的值
    }
}


