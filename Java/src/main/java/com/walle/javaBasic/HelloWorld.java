package com.walle.javaBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args){
        System.out.println("hello");
        System.out.println();

        String s = new String("world");
        List<String> strings = new ArrayList<>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");
        for (String string : strings) {
            if (string == null) {

            }
            if (string != null) {

            }
        }
       Map<Object, Object> h = new HashMap<>();
        h.put(1,"aa");
        h.put(2,"bb");
        h.put(3,"cc");
        for (Map.Entry<Object, Object> he : h.entrySet()) {
            System.out.println(he.getKey());
            System.out.println(he.getValue());

        }


    }
}
