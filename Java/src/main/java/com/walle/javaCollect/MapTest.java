package com.walle.javaCollect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }
        System.out.println("-----------------------");
        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        System.out.println("-----------------------");
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        System.out.println("-----------------------");
        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}
/*
通过Map.keySet遍历key和value：
key= 1 and value= value1
key= 2 and value= value2
key= 3 and value= value3
-----------------------
通过Map.entrySet使用iterator遍历key和value：
key= 1 and value= value1
key= 2 and value= value2
key= 3 and value= value3
-----------------------
通过Map.entrySet遍历key和value
key= 1 and value= value1
key= 2 and value= value2
key= 3 and value= value3
-----------------------
通过Map.values()遍历所有的value，但不能遍历key
value= value1
value= value2
value= value3
 */