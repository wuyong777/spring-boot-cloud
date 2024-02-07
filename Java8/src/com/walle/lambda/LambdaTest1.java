package com.walle.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest1 {

    public static void main(String args[]) {

        List<String> list = new ArrayList<String>();
        list.add("444");
        list.add("222");
        list.add("555");
        list.add("111");
        list.add("333");
        // 使用 java 8 排序
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));   //  顺序
        System.out.println(list);
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));   //  倒序
        System.out.println(list);
    }

}
