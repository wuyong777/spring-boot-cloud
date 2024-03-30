package com.walle.javaBasic;

enum Color
{
    RED, GREEN, BLUE;
}
 
public class EnumTest {
    public static void main(String[] args)
    {
        // 调用 values()
        Color[] arr = Color.values();
 
        // 迭代枚举
        for (Color col : arr)
        {
            // 查看索引
            System.out.println(col + " at index " + col.ordinal());
        }
 
        // 使用 valueOf() 返回枚举常量，不存在的会报错 IllegalArgumentException
        System.out.println(Color.valueOf("RED"));
        //System.out.println(Color.valueOf("WHITE"));
    }
}

/*
RED at index 0
GREEN at index 1
BLUE at index 2
RED
 */