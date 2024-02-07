package com.walle.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String args[]) {

        List<String> str = new ArrayList<>();
        str.add("ddd2");
        str.add("aaa2");
        str.add("bbb1");
        str.add("aaa1");
        str.add("bbb3");
        str.add("ccc");
        str.add("bbb2");
        str.add("ddd1");


        // filtering
        str.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
        // "aaa2", "aaa1"

        // sorting
        str.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
        // "aaa1", "aaa2"


        // mapping
        str.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


        // matching
        boolean anyStartsWithA = str.stream().anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = str.stream().allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = str.stream().noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        // counting
        long startsWithB = str.stream().filter((s) -> s.startsWith("b")).count();
        System.out.println(startsWithB);    // 3


        // reducing
        Optional<String> reduced = str.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }
}

