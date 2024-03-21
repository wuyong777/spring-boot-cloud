package com.walle.SE;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wuyong
 * Date: 2024-03-21
 */
public class HelloWorld2 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        List<String> list = new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("bb");
        list.add("bc");
        list.add("bc");
        list.add("bd");
        list.add("bd");
        list.add("cc");
        list.add("dd");

        list
                .stream()
                .distinct()
                .filter(s -> s.startsWith("b"))
                .sorted()
                .forEach(System.out::println);
    }
}
